package pilotos;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Subclase modelo de un piloto, en este caso para un piloto novato
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoNovato extends PilotoReal{
	//--Constructores
	public PilotoNovato() {
		super();
	}
	
	public PilotoNovato(String nombre_, Concentracion concentracion_) {
		super(nombre_, concentracion_);
	}
	@Override
	public double calcularDestreza() {
		return Math.round((((this.concentracion.getConcentracion() * 0.97) / 120) - 0.03 ) * 100d) / 100d;
	}
}
