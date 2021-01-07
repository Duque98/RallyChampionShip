package coches;

import circuitos.Circuito;
import enumerados.Combustible;
import enumerados.Velocidad;
import pilotos.Piloto;
/**
 * Clase modelo que representa un coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CocheReal implements Coche{
	//--Atributos--
	protected String nombre;
	protected Velocidad velocidad;
	protected Combustible combustible;
	protected double combustibleRestante;	//Tiene la de por defecto, luego va disminuyendo o aumentando segun avanza la carrera
	
	//--Constructores--
	/**
	 * Constructor por defecto
	 */
	public CocheReal() {this.nombre = "";}
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param velocidad_
	 * @param combustible_
	 */
	public CocheReal(String nombre_, Velocidad velocidad_, Combustible combustible_) {
		this.nombre = nombre_;
		this.velocidad = velocidad_;
		this.combustible = combustible_;
		this.combustibleRestante = combustible_.getCombustible();
	}
	
	//--Getters & Setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public Velocidad getVelocidad() { return this.velocidad;}
	public double getValorVelocidad() {return this.velocidad.getVelocidad();}
	public void setVelocidad(Velocidad velocidad_) { this.velocidad = velocidad_;}
	public Combustible getCombustible() {return this.combustible;}
	public double getValorCombustible() {return this.combustible.getCombustible();}
	public void setCombustible(Combustible combustible_) { this.combustible = combustible_;}
	public double getCombustibleRestante() { return this.combustibleRestante;}
	public void setCombustibleRestante(double combustibleRestante) { this.combustibleRestante = combustibleRestante;}
	
	
	//--Metodos--
	/**
	 * Devuelve true si tiene combustible restante
	 */
	public boolean tieneCombustibleRestante() {
		if(this.combustibleRestante > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Calcula la velocidad real de un coche para un piloto en un circuito
	 * @param piloto
	 * @param circuito
	 */
	public double calcularVelocidadReal(Piloto piloto, Circuito circuito) {
		double velocidad =  Math.round(((this.velocidad.getVelocidad() *  piloto.calcularDestreza()) / circuito.getComplejidadModificada())* 100d) / 100d;
		System.out.println("+++ Con estas condiciones es capaz de correr a " + velocidad + " km/hora +++");
		return velocidad;
	}
	/**
	 * Calcula el tiempo necesario que tendra que emplear un piloto para terminar una carrera con este coche en un circuito
	 * @param piloto
	 * @param circuito
	 */
	public double tiempoNecesarioFinalizar(Piloto piloto, Circuito circuito) {
		return Math.round(((circuito.getDistanciaModificada() / calcularVelocidadReal(piloto, circuito))*60)* 100d) / 100d;
	}
	/**
	 * Reduce el combustible restante
	 * @param tiempo
	 */
	public void reducirCombustible(double tiempo) {
		this.combustibleRestante = Math.round((this.combustibleRestante - tiempo)* 100d) / 100d;
	}
	/**
	 * Reduce el combustible restante
	 * @param combustible
	 */
	public void restarCombustible(double combustible) {
		this.combustibleRestante = Math.round((this.combustibleRestante - combustible)* 100d) / 100d;
	}

	/**
	 * Metodo toString para mostrar la informacion de un coche
	 */
	@Override
	public String toString() {
		return "<coche: " + this.nombre + "> <tipo: CocheNormal> <vel_teó: " + this.velocidad.getNombre() + "(" + this.velocidad.getVelocidad() + 
				")> <comb: " + this.combustible.getNombre() + "(" + this.combustible.getCombustible() + ")(actual:" + this.combustibleRestante + ")>";
	}
	
}
