package pilotos;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Subclase modelo de un piloto, en este caso para un piloto Estrella
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoEstrella extends PilotoReal{
	//--Constructores
	/**
	 * Constructor por defecto
	 */
	public PilotoEstrella () {
		super();
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param concentracion_
	 */
	public PilotoEstrella (String nombre_, Concentracion concentracion_) {
		super(nombre_, concentracion_);
	}
	/**
	 * Metodo para calcular la destreza
	 */
	@Override
	public double calcularDestreza() {
		return Math.round(((((this.concentracion.getConcentracion() + 6) / 140) * 1.06) + 0.05)* 100d) / 100d;
	}
}