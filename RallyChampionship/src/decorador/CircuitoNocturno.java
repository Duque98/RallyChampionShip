package decorador;

import circuitos.Circuito;

public class CircuitoNocturno extends CircuitoDecorador{
	public CircuitoNocturno(Circuito circuito) {
		super(circuito);
	}
	@Override
	public double getComplejidadModificada() {
		return Math.round((circuito.getComplejidadModificada() * 1.2)* 100d) / 100d;
	}
	
	public double getDistanciaModificada() {
		return Math.round((circuito.getDistanciaModificada() * 0.8)* 100d) / 100d;
	}
	
}
