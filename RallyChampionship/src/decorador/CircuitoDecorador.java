package decorador;

import circuitos.Circuito;

public abstract class CircuitoDecorador implements ComplejidadExtra{
	protected ComplejidadExtra compExtra;
	
	public CircuitoDecorador (ComplejidadExtra compExtra) {
		this.compExtra = compExtra;
	}
	
	@Override
	public void añadirComplejidadExtra(Circuito circuito) {
		this.compExtra.añadirComplejidadExtra(circuito);
	}
}
