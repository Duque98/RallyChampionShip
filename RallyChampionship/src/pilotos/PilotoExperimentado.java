package pilotos;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Subclase modelo de un piloto, en este caso para un piloto experimentado
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoExperimentado extends Piloto{
	//--Constructores
	public PilotoExperimentado () {
		super();
	}
	
	public PilotoExperimentado (String nombre_, Coche coche_, Concentracion concentracion_) {
		super(nombre_, coche_, concentracion_);
	}
	
	//TODO - Calcular destreza
}
