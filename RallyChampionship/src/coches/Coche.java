package coches;

import enumerados.Combustible;
import enumerados.Velocidad;

/**
 * Clase modelo de un coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Coche {
	//--Atributos--
	protected String nombre;
	protected Velocidad velocidad;
	protected Combustible combustible;
	
	//--Constructores--
	public Coche() {this.nombre = "";}
	public Coche(String nombre_, Velocidad velocidad_, Combustible combustible_) {
		this.nombre = nombre_;
		this.velocidad = velocidad_;
		this.combustible = combustible_;
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
	
	//--Metodos--
	//TODO - Calcular velocidad real
	/*TODO - Proporcionar tiempo necesario (en minutos) para terminar la carrera 
	 *		 por un piloto en particular en un circuito concreto*/
	//TODO - Reducir combustible de un coche al final de cada carrera de acuerdo a los minutos competidos

	//TODO - Metodos de toString, CompareTo,...
}
