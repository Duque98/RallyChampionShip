package pilotos;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Subclase modelo de un piloto, en este caso para un piloto Estrella
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoEstrella extends Piloto{
	//--Constructores
	public PilotoEstrella () {
		super();
	}
	
	public PilotoEstrella (String nombre_, Coche coche_, Concentracion concentracion_) {
		super(nombre_, coche_, concentracion_);
	}
	
	//TODO - Calcular destreza
}