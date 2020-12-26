package circuitos;

import enumerados.Complejidad;
import enumerados.Distancia;

/**
	 * Clase modelo para un Circuito
	 * @author Jose Ignacio Duque Blazquez
	 *
	 */
public class CircuitoReal implements Circuito{
	//--Atributos--
	private String nombre;
	
	private Distancia distancia;
	private double distanciaModificada;		//Tiene la de por defecto o en caso de modificada la modificada
	
	private Complejidad complejidad;	
	private double complejidadModificada; 	//Tiene la de por defecto o en caso de modificada la modificada
	
	//--Constructores--
	public CircuitoReal() {
		this.nombre = "";
		this.distanciaModificada = 0.0;
		this.complejidadModificada = 0.0;
	}
	public CircuitoReal(String nombre_, Complejidad complejidad_, Distancia distancia_) {
		this.nombre = nombre_; 
		this.complejidad = complejidad_;
		this.complejidadModificada = complejidad_.getComplejidad();
		this.distancia = distancia_;
		this.distanciaModificada = distancia_.getDistancia();
	}

	//--Getters & Setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public Complejidad getComplejidad() { return this.complejidad;}
	public double getValorComplejidad() { return this.complejidad.getComplejidad();}
	public void setComplejidad(Complejidad complejidad) {this.complejidad = complejidad;}
	
	public Distancia getDistancia() {return distancia;}
	public int getValorDistancia() {return distancia.getDistancia();}
	public void setDistancia(Distancia distancia) {this.distancia = distancia;}
	

	public double getComplejidadModificada() {return complejidadModificada;}
	public void setComplejidadModificada(double complejidadModificada) {this.complejidadModificada = complejidadModificada;}

	public double getDistanciaModificada() {return distanciaModificada;}
	public void setDistanciaModificada(double distanciaModificada) {this.distanciaModificada = distanciaModificada;}
	
	
	//--Metodos--

	//TODO - Metodos de toString, CompareTo,...
	
	@Override
	public String toString() {
		return "<circuito: " + this.nombre + " > <cond: " +" >"; 
	}
	
	


}
