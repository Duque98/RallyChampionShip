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
	private String nombre;			//Nombre de un circuito
	private Distancia distancia;	//Distancia de un circuito
	private Complejidad complejidad;//Complejidad de un circuito	
	
	
	//--Constructores--
	/**
	 * Constructor por defecto
	 */
	public CircuitoReal() {
		this.nombre = "";
	}
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param complejidad_
	 * @param distancia_
	 */
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
	/**
	 * Metodo que devuelve la distancia modificada en caso que se haya modificado con alguna complicacion extra (decorator)
	 */
	@Override
	public double getDistanciaModificada() {
		return this.distancia.getDistancia();
	}
	/**
	 * Metodo que devuelve la complejidad modificada en caso que se haya modificado con alguna complicacion extra (decorator)
	 */
	@Override
	public double getComplejidadModificada() {
		return this.complejidad.getComplejidad();
	}
	
	//--Metodos--
	/**
	 * Metodo toString para mostrar la informacion de un circuito
	 */
	@Override
	public String toString() {
		return "<circuito:" + this.nombre + "> <cond: " + toComplicacion() +"> <comp: " + this.complejidad.getNombre() + "(original:" + this.complejidad.getComplejidad() +
				") (actual:" + this.getComplejidadModificada() + ")> <dist: " + this.distancia.getNombre() + "(orginial:" + this.distancia.getDistancia() +
				") (actual:" + this.getDistanciaModificada() + ")>"; 
	}
	/**
	 * Metodo para añadir la informacion de una complicacion extra en caso de mostrarla
	 */
	@Override
	public String toComplicacion() {
		return "";
	}
	
	/**
	 * Metodo equals para saber si dos objetos son iguales
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true; //Ambos referencian al mismo objeto
		}
		if(!(obj instanceof CircuitoReal)) {
			return false; //Tienen diferentes tipos
		}
		CircuitoReal other = (CircuitoReal) obj;
		return this.nombre.equals(other.getNombre()) && this.complejidad == other.getComplejidad() && this.distancia == other.getDistancia();
	}
	/**
	 * Metodo hashCode 
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 7 * result + this.nombre.hashCode();
		result = 13 * result + this.distancia.getNombre().hashCode();
		return result;
	}
}
