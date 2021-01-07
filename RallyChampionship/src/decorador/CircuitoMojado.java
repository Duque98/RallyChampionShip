package decorador;

import circuitos.Circuito;
/**
 * Clase que extiende de CircuitoDecorador y representa una complicacion extra
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CircuitoMojado extends CircuitoDecorador{
	/**
	 * Constructor parametrizado
	 * @param circuito
	 */
	public CircuitoMojado(Circuito circuito) {
		super(circuito);
	}
	/**
	 * Devuelve la complejidad modificada
	 */
	@Override
	public double getComplejidadModificada() {
		return Math.round((circuito.getComplejidadModificada() * 1.15)* 100d) / 100d;
	}
	/**
	 * Devuelve la distancia modificada
	 */
	@Override
	public double getDistanciaModificada() {
		return Math.round((circuito.getDistanciaModificada() * 0.85)* 100d) / 100d;
	}
	/**
	 * Muestra la complicacion
	 */
	@Override
	public String toComplicacion() {
		return circuito.toComplicacion() + "Mojado ";
	}
}
