package pilotos;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Subclase modelo de un piloto, en este caso para un piloto novato
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoNovato extends Piloto{
	//--Constructores
	public PilotoNovato() {
		super();
	}
	
	public PilotoNovato(String nombre_, Coche coche_, Concentracion concentracion_) {
		super(nombre_, coche_, concentracion_);
	}
	
	//TODO - Calcular destreza
}
