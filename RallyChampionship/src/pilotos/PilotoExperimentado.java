package pilotos;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Subclase modelo de un piloto, en este caso para un piloto experimentado
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoExperimentado extends PilotoReal{
	//--Constructores
	public PilotoExperimentado () {
		super();
	}
	
	public PilotoExperimentado (String nombre_,Concentracion concentracion_) {
		super(nombre_, concentracion_);
	}
	@Override
	public double calcularDestreza() {
		return Math.round((((this.concentracion.getConcentracion() + 3) / 130) * 1.03 ) * 100d) / 100d;
	}
}
