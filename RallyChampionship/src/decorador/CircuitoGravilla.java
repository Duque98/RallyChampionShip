package decorador;

import circuitos.Circuito;
import enumerados.Complejidad;
import enumerados.Distancia;

public class CircuitoGravilla extends CircuitoDecorador{
	
	public CircuitoGravilla(Circuito circuito) {
		super(circuito);
	}
	@Override
	public double getComplejidadModificada() {
		return Math.round((circuito.getComplejidadModificada() * 1.05)* 100d) / 100d;
	}
	
	public double getDistanciaModificada() {
		return Math.round((circuito.getDistanciaModificada() * 0.95)* 100d) / 100d;
	}
}
