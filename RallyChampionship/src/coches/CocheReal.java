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
	//--Metodos--
	
	public double calcularVelocidadReal(Piloto piloto, Circuito circuito) {
		double velocidadReal = Math.round(((this.velocidad.getVelocidad() *  piloto.getDestreza()) / circuito.getComplejidadModificada())* 100d) / 100d;
		return velocidadReal;
	}
	
	public double tiempoNecesarioFinalizar(Piloto piloto, Circuito circuito) {
		//tiempo ( en minutos ) = (d istancia del circuito / velocidad real del coche con piloto en circuito ) * 60 ;
		
		//double tiempo = (circuito.getDistanciaModificada() / calcularVelocidadReal(piloto, circuito))*60;
		return 0;
	}
	/*TODO - Proporcionar tiempo necesario (en minutos) para terminar la carrera 
	 *		 por un piloto en particular en un circuito concreto*/
	//TODO - Reducir combustible de un coche al final de cada carrera de acuerdo a los minutos competidos

	//TODO - Metodos de toString, CompareTo,...
}
