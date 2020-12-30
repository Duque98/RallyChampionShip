package circuitos;

import java.util.ArrayList;
import java.util.List;

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
	private Complejidad complejidad;	
	
	
	//--Constructores--
	public CircuitoReal() {
		this.nombre = "";
	}
	public CircuitoReal(String nombre_, Complejidad complejidad_, Distancia distancia_) {
		this.nombre = nombre_; 
		this.complejidad = complejidad_;
		this.distancia = distancia_;
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
	
	//--Decorator--
	@Override
	public double getDistanciaModificada() {
		return this.distancia.getDistancia();
	}
	@Override
	public double getComplejidadModificada() {
		return this.complejidad.getComplejidad();
	}
	
	//--Metodos--
	
	
	//TODO - Metodos de toString, CompareTo,...
	
	@Override
	public String toString() {
		//TODO -dos toString, 
		return "<circuito: " + this.nombre + " > <cond: " +" >"; 
	}
	

}
