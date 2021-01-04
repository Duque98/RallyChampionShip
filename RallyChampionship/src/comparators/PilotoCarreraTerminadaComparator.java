package comparators;

import java.util.Comparator;

import pilotos.Piloto;

public class PilotoCarreraTerminadaComparator implements Comparator<Piloto>{
	@Override
	public int compare(Piloto p1, Piloto p2) {
		//Puntos del piloto
		if(p1.totalCarrerasParticipadas() < p2.totalCarrerasParticipadas()) {
			return -1;
		}
		if(p1.totalCarrerasParticipadas() > p2.totalCarrerasParticipadas()) {
			return 1;
		}
		if(p1.totalCarrerasParticipadas() - p2.totalCarrerasParticipadas() == 0) {
			//En caso de empate, por carreras terminadas
			return new PilotoNombreComparator().compare(p1, p2);
		}
		return 0;
	}
}
