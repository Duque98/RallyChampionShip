package decorador;

import circuitos.Circuito;

public class CircuitoNocturno extends CircuitoDecorador{

	public CircuitoNocturno(ComplejidadExtra compExtra) {
		super(compExtra);
	}

	@Override
	public void a�adirComplejidadExtra(Circuito circuito) {
		compExtra.a�adirComplejidadExtra(circuito);
		modificarCondiciones(circuito);
	}
	public void modificarCondiciones(Circuito circuito) {
		double compNueva = circuito.getComplejidad().getComplejidad() * 1.2;
		circuito.setComplejidadModificada(compNueva);
		
		double distNueva = circuito.getDistancia().getDistancia() * 0.8;
		circuito.setDistanciaModificada(distNueva);
	}
}
