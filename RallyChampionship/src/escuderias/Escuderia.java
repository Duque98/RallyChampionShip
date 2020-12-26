package escuderias;

import java.util.ArrayList;

import coches.Coche;
import pilotos.Piloto;

/**
 * Clase modelo para representar una Escuderia
 * @author Jose Ignacio Duque Blazquez
 *
 */
public interface Escuderia {
	public String getNombre();
	public void setNombre(String nombre);
	public ArrayList<Piloto> getSetPilotos();
	public void setSetPilotos(ArrayList<Piloto> setPilotos);
	public ArrayList<Coche> getACoches();
	public void setACoches(ArrayList<Coche> aCoches);
}
