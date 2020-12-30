package escuderias;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coches.Coche;
import pilotos.Piloto;
import strategy.IStrategy;

/**
 * Clase modelo para representar una Escuderia
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
	public void añadirPiloto(Piloto piloto);
	public void añadirCoche(Coche coche);
	
	public void mostrar();
}
