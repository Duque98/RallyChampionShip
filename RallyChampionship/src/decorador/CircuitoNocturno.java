package decorador;

import circuitos.Circuito;

public class CircuitoNocturno extends CircuitoDecorador{

	public CircuitoNocturno(ComplejidadExtra compExtra) {
		super(compExtra);
	}

	@Override
	public void añadirComplejidadExtra(Circuito circuito) {
		compExtra.añadirComplejidadExtra(circuito);
		modificarCondiciones(circuito);
	}
	public void modificarCondiciones(Circuito circuito) {
		double compNueva = circuito.getComplejidad().getComplejidad() * 1.2;
		circuito.setComplejidadModificada(compNueva);
		
		double distNueva = circuito.getDistancia().getDistancia() * 0.8;
		circuito.setDistanciaModificada(distNueva);
	}
}
