package escuderias;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coches.Coche;
import pilotos.Piloto;
import strategy.IStrategy;

/**
 * Interfaz que representa una escuderia
 * @author Jose Ignacio Duque Blazquez
 *
 */
public interface Escuderia {
	public String getNombre();
	public void setNombre(String nombre);
	public List<Piloto> getAPilotos();
	public void setAPilotos(ArrayList<Piloto> setPilotos);
	public List<Coche> getACoches();
	public void setACoches(ArrayList<Coche> aCoches);
	public IStrategy getStrategy();
	public void setStrategy(IStrategy strategy);
	
	public void ordenar();
	public void aņadirPiloto(Piloto piloto);
	public void aņadirCoche(Coche coche);
	
	public void inscribirseAlCampeonato();
	public void enviarPilotoAlCampeonato();
	
	public int puntosTotales();
	public int totalCarrerasTerminadas();
	
	
	public boolean tienePilotosDisponibles();
	public int cuantosPilotoDisponibles() ;
	
	public void recibirPiloto(Piloto piloto);
}
