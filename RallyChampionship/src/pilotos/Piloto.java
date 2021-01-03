package pilotos;

import java.util.HashMap;

import circuitos.Circuito;
import coches.Coche;
import enumerados.Concentracion;

/**
 * Clase modelo para un piloto
 * @author Jose Ignacio Duque Blazquez
 *
 */
public interface Piloto {
	public String getNombre();
	public void setNombre(String nombre);
	
	public Coche getCoche() ;
	public void setCoche(Coche coche);
	
	public Concentracion getConcentracion() ;
	public double getValorConcentracion() ;
	public void setConcentracion(Concentracion concentracion);
	
	public double getDestreza() ;
	public void setDestreza(double destreza) ;
	
	public boolean isDescalificado() ;
	public void setDescalificado(boolean descalificado) ;
	
	public HashMap<String, ResultadoCarrera> getHashResultados() ;
	public void setHashResultados(HashMap<String, ResultadoCarrera> hashResultados) ;
	
	
	
	//--Metodos--
	public void calcularDestreza();
	public int totalPuntos();
	public void asignarCoche(Coche coche);
	public boolean estaDescalificado();
	public ResultadoCarrera obtenerResultadoCircuito(Circuito circuito);
	public int totalCarrerasParticipadas();
	public int totalCarrerasAbandonadas();
	
	public void conducirCoche(Circuito circuito);
}
