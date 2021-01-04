package coches;

import circuitos.Circuito;
import enumerados.Combustible;
import enumerados.Velocidad;
import pilotos.Piloto;

public class CocheReal implements Coche{
	//--Atributos--
	protected String nombre;
	protected Velocidad velocidad;
	protected Combustible combustible;
	protected double combustibleRestante;	//Tiene la de por defecto, luego va disminuyendo segun avanza la carrera
	
	//--Constructores--
	public CocheReal() {this.nombre = "";}
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
	public boolean tieneCombustibleRestante() {
		if(this.combustibleRestante > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public double calcularVelocidadReal(Piloto piloto, Circuito circuito) {
		return Math.round(((this.velocidad.getVelocidad() *  piloto.getDestreza()) / circuito.getComplejidadModificada())* 100d) / 100d;
	}
	
	public double tiempoNecesarioFinalizar(Piloto piloto, Circuito circuito) {
		return Math.round(((circuito.getDistanciaModificada() / calcularVelocidadReal(piloto, circuito))*60)* 100d) / 100d;
	}
	
	public void reducirCombustible(Piloto piloto, Circuito circuito) {
		this.combustibleRestante = this.combustibleRestante - tiempoNecesarioFinalizar(piloto, circuito);
	}
	
	public void restarCombustible(double combustible) {
		this.combustibleRestante = this.combustibleRestante - combustible;
	}

	//TODO - Metodos de toString, CompareTo,...
	@Override
	public String toString() {
		return "<coche: " + this.nombre + "> <tipo: CocheNormal> <vel_teó: " + this.velocidad.getNombre() + "(" + this.velocidad.getVelocidad() + 
				")> <comb: " + this.combustible.getNombre() + "(" + this.combustible.getCombustible() + ")(actual:" + this.combustibleRestante + ")>";
	}
	
}
