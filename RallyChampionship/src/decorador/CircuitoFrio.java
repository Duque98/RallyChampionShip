package decorador;

import circuitos.Circuito;
import enumerados.Complejidad;
import enumerados.Distancia;

public class CircuitoFrio extends CircuitoDecorador{
	
	public CircuitoFrio(Circuito circuito) {
		super(circuito);
	}
	@Override
	public double getComplejidadModificada() {
		return Math.round((circuito.getComplejidadModificada() * 1.1)* 100d) / 100d;
	}
	@Override
	public double getDistanciaModificada() {
		return Math.round((circuito.getDistanciaModificada() * 0.9)* 100d) / 100d;
	}
	@Override
	public String toComplicacion() {
		return circuito.toComplicacion() + "Frio ";
	}
}
