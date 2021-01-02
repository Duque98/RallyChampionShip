package coches;

import circuitos.Circuito;
import enumerados.Combustible;
import enumerados.Velocidad;
import pilotos.Piloto;

/**
 * Clase modelo de un coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public interface Coche {
	public String getNombre();
	public void setNombre(String nombre) ;
	
	public Velocidad getVelocidad();
	public double getValorVelocidad();
	public void setVelocidad(Velocidad velocidad_);
	
	public Combustible getCombustible();
	public double getValorCombustible();
	public void setCombustible(Combustible combustible_);
	
	public double getCombustibleRestante();
	
	public boolean tieneCombustibleRestante() ;
	
	public double calcularVelocidadReal(Piloto piloto, Circuito circuito);
	public double tiempoNecesarioFinalizar(Piloto piloto, Circuito circuito);
	public void reducirCombustible(Piloto piloto, Circuito circuito);
}
