package decorador;

import circuitos.Circuito;
import enumerados.Complejidad;

public class CircuitoFrio extends CircuitoDecorador{
	public CircuitoFrio(ComplejidadExtra compExtra) {
		super(compExtra);
	}

	@Override
	public void a�adirComplejidadExtra(Circuito circuito) {
		compExtra.a�adirComplejidadExtra(circuito);
		modificarCondiciones(circuito);
	}
	public void modificarCondiciones(Circuito circuito) {
		double compNueva = circuito.getComplejidad().getComplejidad() * 1.1;
		circuito.setComplejidadModificada(compNueva);
		
		double distNueva = circuito.getDistancia().getDistancia() * 0.9;
		circuito.setDistanciaModificada(distNueva);
	}
}
