package decorador;

import circuitos.Circuito;

public class CircuitoMojado extends CircuitoDecorador{

	public CircuitoMojado(Circuito circuito) {
		super(circuito);
	}
	@Override
	public double getComplejidadModificada() {
		return Math.round((circuito.getComplejidadModificada() * 1.15)* 100d) / 100d;
	}
	
	public double getDistanciaModificada() {
		return Math.round((circuito.getDistanciaModificada() * 0.85)* 100d) / 100d;
	}
	
	
}
