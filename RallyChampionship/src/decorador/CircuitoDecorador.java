package decorador;

import circuitos.Circuito;
import circuitos.CircuitoReal;
/**
 * Clase abstracta que gestiona las complicaciones extras de un circuito
 * @author Jose Ignacio Duque Blazquez
 *
 */
public abstract class CircuitoDecorador extends CircuitoReal{
	//--Atributos--
	protected Circuito circuito;
	
	/**
	 * Constructor parametrizado (decorator)
	 * @param circuito
	 */
	public CircuitoDecorador(Circuito circuito) {
		super(circuito.getNombre(), circuito.getComplejidad(), circuito.getDistancia());
		this.circuito = circuito;
	}
}
