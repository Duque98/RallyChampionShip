package decorador;

import circuitos.Circuito;

public class CircuitoGravilla extends CircuitoDecorador{
	public CircuitoGravilla(ComplejidadExtra compExtra) {
		super(compExtra);
	}

	@Override
	public void a�adirComplejidadExtra(Circuito circuito) {
		compExtra.a�adirComplejidadExtra(circuito);
		modificarCondiciones(circuito);
	}
	public void modificarCondiciones(Circuito circuito) {
		double compNueva = circuito.getComplejidad().getComplejidad() * 1.05;
		circuito.setComplejidadModificada(compNueva);
		
		double distNueva = circuito.getDistancia().getDistancia() * 0.95;
		circuito.setDistanciaModificada(distNueva);
	}
}
