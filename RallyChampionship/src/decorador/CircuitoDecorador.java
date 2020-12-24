package decorador;

import circuitos.Circuito;

public abstract class CircuitoDecorador implements ComplejidadExtra{
	protected ComplejidadExtra compExtra;
	
	public CircuitoDecorador (ComplejidadExtra compExtra) {
		this.compExtra = compExtra;
	}
	
	@Override
	public void a�adirComplejidadExtra(Circuito circuito) {
		this.compExtra.a�adirComplejidadExtra(circuito);
	}
}
