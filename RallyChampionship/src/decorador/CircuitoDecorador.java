package decorador;

import circuitos.Circuito;
import circuitos.CircuitoReal;

public abstract class CircuitoDecorador extends CircuitoReal{
	protected Circuito circuito;
	
	public CircuitoDecorador(Circuito circuito) {
		super(circuito.getNombre(), circuito.getComplejidad(), circuito.getDistancia());
		this.circuito = circuito;
	}
}
