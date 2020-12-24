package decorador;

import circuitos.Circuito;

public class CircuitoMojado extends CircuitoDecorador{
	
	
	public CircuitoMojado(ComplejidadExtra compExtra) {
		super(compExtra);
	}

	@Override
	public void a�adirComplejidadExtra(Circuito circuito) {
		compExtra.a�adirComplejidadExtra(circuito);
		modificarCondiciones(circuito);
	}
	public void modificarCondiciones(Circuito circuito) {
		double compNueva = circuito.getComplejidad().getComplejidad() * 1.15;
		circuito.setComplejidadModificada(compNueva);
		
		double distNueva = circuito.getDistancia().getDistancia() * 0.85;
		circuito.setDistanciaModificada(distNueva);
	}
}
