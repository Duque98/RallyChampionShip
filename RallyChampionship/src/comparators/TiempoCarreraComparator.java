package comparators;

import java.util.Comparator;

import circuitos.Circuito;
import pilotos.Piloto;
/**
 * Comparator para comparar los pilotos segun el tiempo obtenido como resultado de una carrera
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class TiempoCarreraComparator implements Comparator<Piloto>{
	private Circuito circuito;
	public TiempoCarreraComparator(Circuito circuito) {
		this.circuito = circuito;
	}
	
	@Override
	public int compare(Piloto p1, Piloto p2) {
		if(p1.obtenerResultadoCircuito(circuito).getTiempo() < p2.obtenerResultadoCircuito(circuito).getTiempo()) {
			return -1;
		}
		if(p1.obtenerResultadoCircuito(circuito).getTiempo() > p2.obtenerResultadoCircuito(circuito).getTiempo()) {
			return 1;
		}
		if(Math.abs(p1.obtenerResultadoCircuito(circuito).getTiempo() - p2.obtenerResultadoCircuito(circuito).getTiempo()) == 0.0) {
			return 0;
		}
		return 0;
	}

}
