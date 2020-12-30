package comparators;

import java.util.Comparator;

import pilotos.Piloto;

public class PilotosStrategy1Comparator implements Comparator<Piloto>{

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
			//En caso de empate, por destreza
			return new PilotoDestrezaComparator().compare(p1, p2);
		}
		return 0;
	}

}
