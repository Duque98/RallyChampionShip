package comparators;

import java.util.Comparator;

import pilotos.Piloto;
/**
 * Comparator para comparar los pilotos segun sus puntos totales y en caso de empate por sus carreras terminadas
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoParrillaSalidaComparator implements Comparator<Piloto>{
	@Override
	public int compare(Piloto p1, Piloto p2) {
		//Puntos del piloto
		if(p1.totalPuntos() < p2.totalPuntos()) {
			return -1;
		}
		if(p1.totalPuntos() > p2.totalPuntos()) {
			return 1;
		}
		if(p1.totalPuntos() - p2.totalPuntos() == 0) {
			//En caso de empate, por carreras terminadas
			return new PilotoCarreraTerminadaComparator().compare(p1, p2);
		}
		return 0;
	}
}
