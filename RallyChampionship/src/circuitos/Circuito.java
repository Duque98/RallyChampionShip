package circuitos;

import java.util.List;

import enumerados.Complejidad;
import enumerados.Distancia;

/**
 * Interfaz para representar un circuito
 * @author Jose Ignacio Duque Blazquez
 *
 */
public interface Circuito {
	//--Getters & Setters
	public String getNombre();
	public void setNombre(String nombre);
	
	public Complejidad getComplejidad();
	public double getValorComplejidad();
	public void setComplejidad(Complejidad complejidad);
	
	public Distancia getDistancia();
	public int getValorDistancia();
	public void setDistancia(Distancia distancia);
	
	//Metodo para el decorador
	public abstract double getDistanciaModificada();
	public abstract double getComplejidadModificada();
	
	public String toString();
	public String toComplicacion();
}
