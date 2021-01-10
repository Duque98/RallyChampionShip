package rally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import circuitos.Circuito;
import coches.Coche;
import comparators.CochesStrategy1Comparator;
import comparators.EscuderiaTotalPuntosComparator;
import comparators.PilotoDestrezaComparator;
import comparators.PilotoParrillaSalidaComparator;
import comparators.PilotosStrategy1Comparator;
import comparators.TiempoCarreraComparator;
import escuderias.Escuderia;
import pilotos.Piloto;
import pilotos.ResultadoCarrera;

/**
 * Clase modelo para representar la Organizacion, llevara a cabo la simulacion del proyecto
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Organizacion {
	//--Atributos--
	private static Organizacion org; 			//Singleton
	private int limiteAbandonos; 				//Numero maximo de abandonos que un piloto puede tener en el transcurso de un campeonato
	private int limitePilotos;					//Numero maximo de pilotos que una escuderia puede enviar a la competicion
	private TreeSet<Circuito> tsCircuitos;		//Treeset de circuitos que componen el campeonato 
	private List<Escuderia> aEscuderias;		//Lista (ArrayList) de escuderias que se han inscrito para el campeonato
	private List<Piloto> aPilotos;				//Lista (ArrayList) de pilotos junto al coche que van a competir en una carrera 
	
	
	//--Constructores--
	/**
	 * Constructor de la clase, privado para el correcto aplicamiento del patron singleton
	 * @param limiteAbandonos
	 * @param limitePilotos
	 * @param ordenCircuitos
	 */
	private Organizacion(int limiteAbandonos, int limitePilotos, Comparator<Circuito> ordenCircuitos) {
		this.limiteAbandonos = limiteAbandonos;
		this.limitePilotos = limitePilotos;
		this.tsCircuitos = new TreeSet<Circuito>(ordenCircuitos);
		this.aEscuderias = new ArrayList<Escuderia>();
		this.aPilotos = new ArrayList<Piloto>();
	}
	
	/**
	 * Metodo para aplicar el patron singleton
	 * @param limiteAbandonos
	 * @param limitePilotos
	 * @param ordenCircuitos
	 * @return Instancia de la clase
	 */
	public static Organizacion getInstance(int limiteAbandonos, int limitePilotos, Comparator<Circuito> ordenCircuitos) {
		if(org == null) {
			org = new Organizacion(limiteAbandonos, limitePilotos, ordenCircuitos);
		}
		return org;
	}
	
	/**
	 * Metodo para aplicar el patron singleton, solo vale para devolverlo, devuelve null en caso de que no exista ninguna organizacion
	 * @return
	 */
	public static Organizacion getInstanceWithoutParameter() {
		if(org != null) {
			return org;
		}else {
			return null;
		}
	}

	//--Getters & Setters
	public int getLimiteAbandonos() {return limiteAbandonos;}
	public void setLimiteAbandonos(int limiteAbandonos) {this.limiteAbandonos = limiteAbandonos;}
	public int getLimitePilotos() {return limitePilotos;}
	public void setLimitePilotos(int limitePilotos) {this.limitePilotos = limitePilotos;}
	
	//--Metodos--
	/**
	 * Añade un circuito al campeonado
	 * @param circuito
	 */
	public void añadirCircuito(Circuito circuito) {
		this.tsCircuitos.add(circuito);
	}
	/**
	 * Metodo para permitir la inscripcion de una escuderia
	 * @param escuderia
	 */
	public void inscribirEscuderia(Escuderia escuderia) {
		this.aEscuderias.add(escuderia);
		Collections.sort(this.aEscuderias, Collections.reverseOrder(new EscuderiaTotalPuntosComparator()));
	}
	/**
	 * Recibe un piloto que competira en el campeonato
	 * @param piloto
	 */
	public void recibirPilotoDelCampeonato(Piloto piloto) {
		this.aPilotos.add(piloto);
	}
	/**
	 * Gestiona el desarrollo de la competicion
	 */
	public void simulacion() {
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\r\n" + 
							"||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||\r\n" + 
							"||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		for(Circuito circuito : this.tsCircuitos) {
			System.out.println(circuito.toString());
		}
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\r\n");
		System.out.print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n" + 
							"%%%%%%%% ESCUDERÍAS DEL CAMPEONATO %%%%%%%%\r\n" + 
							"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n");
		for(Escuderia escuderia : this.aEscuderias) { 
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.print(escuderia.toString());
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		System.out.println("");
		
		gestionarCelebracionCarrera();
		
		gestionarFinCampeonato();
	}
	
	/**
	 * Gestiona las carreras del campeonato
	 *  - Muestra los pilotos que van a competir por carrera
	 *  - Gestiona la circulacion de cada piloto
	 *  
	 */
	public void gestionarCelebracionCarrera() {
		int numCarrera = 1;
		boolean encFin = false;
		Iterator<Circuito> it = this.tsCircuitos.iterator();
		while(it.hasNext()  && !encFin) {
			//&& !esFin()
			Circuito circuito = it.next();
			System.out.println("********************************************************************************************************");
			System.out.println("*** CARRERA <" + numCarrera + "> EN " + circuito.toString() + " ***");
			System.out.println("********************************************************************************************************");
			
			for (int pilotoEnviados = 0; pilotoEnviados < this.limitePilotos; pilotoEnviados++) {
				for(Escuderia escuderia : this.aEscuderias) {
					escuderia.enviarPilotoAlCampeonato();
				}
			}
			
			if(this.aPilotos.size() <= 1) {
				System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
				System.out.println("¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
				if(this.aPilotos.size() == 1) {
					int i= 0;
					while(!encFin) {
						Escuderia escuderia = this.aEscuderias.get(i);
						if(escuderia.getNombre().equals(this.aPilotos.get(0).getEscuderia())) {
							enviarPilotoCocheAEscuderia(escuderia, this.aPilotos.get(0));
							encFin=true;
						}
						i++;
					}
				}
				encFin=true;
			}else {
				System.out.println("********************************************************************************************************");
				System.out.println("******************************** Pilotos que van a competir en " + circuito.getNombre() + " *******************************");
				System.out.println("**********************************************************************************************************");
				
				//Ordenar los pilotos
				Collections.sort(this.aPilotos, new PilotoParrillaSalidaComparator());
				
				for(Piloto piloto : this.aPilotos) {
					System.out.println(piloto.toString());
				}
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + circuito.getNombre() + " ++++++++++++++++++++++++++");
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				int numeroPiloto = 1;
				for(Piloto piloto : this.aPilotos) {
					System.out.println("@@@ Piloto "+ numeroPiloto + " de " + this.aPilotos.size());
					System.out.println(piloto.toString() + " con ");
					System.out.println(piloto.getCoche().toString());
					
					piloto.conducirCoche(circuito);
									
					System.out.println("+++ El combustible del " + piloto.getCoche().getNombre() + " tras la carrera es " + piloto.getCoche().getCombustibleRestante() + " +++");
					System.out.println("@@@");
					numeroPiloto++;

					if(piloto.totalCarrerasAbandonadas() >= this.limiteAbandonos) {
						System.out.println("@@@");
						System.out.println("¡¡¡ " + piloto.getNombre() + " es DESCALIFICADO del campeonato por alcanzar el límite de abandonos(" + this.limiteAbandonos + ") !!!");
						System.out.println("@@@");
						piloto.setDescalificado(true);
					}
					
					//Devolvemos el piloto y el coche a su escuderia
					boolean enc = false;
					int i= 0;
					while(!enc) {
						Escuderia escuderia = this.aEscuderias.get(i);
						if(escuderia.getNombre().equals(piloto.getEscuderia())) {
							enviarPilotoCocheAEscuderia(escuderia, piloto);
							enc=true;
						}
						i++;
					}
				
				}	
				clasificacionCarrera(circuito);
			}
			this.aPilotos = new ArrayList<Piloto>();
			numCarrera++;
		}
	}
	/**
	 * Gestiona la clasificacion de una carrera y la muestra
	 * @param circuito
	 */
	public void clasificacionCarrera(Circuito circuito) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++ Clasificación final de la carrera en " + circuito.getNombre() + " ++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		ArrayList<Piloto> auxNegativo = new ArrayList<Piloto>();
		ArrayList<Piloto> auxPositivo = new ArrayList<Piloto>();
		for(Piloto piloto : this.aPilotos) {
			if(piloto.obtenerResultadoCircuito(circuito).getTiempo() < 0.0) {
				auxNegativo.add(piloto);				
			}else {
				auxPositivo.add(piloto);
			}
		}
		
		Collections.sort(auxPositivo, new TiempoCarreraComparator(circuito));
		Collections.sort(auxNegativo, new TiempoCarreraComparator(circuito));
		
		//TODO - los descalificados van al final
		int posicion = 1;
		for(Piloto piloto : auxPositivo) {
			ResultadoCarrera resAntiguo = piloto.obtenerResultadoCircuito(circuito);
			asignarPuntos(circuito, piloto, resAntiguo, posicion);
			ResultadoCarrera res = piloto.obtenerResultadoCircuito(circuito);
			System.out.println("@@@ Posición(" + posicion + "): " + piloto.getNombre() + " - Tiempo: " + res.getTiempo() + " minutos - Puntos: " + res.getPuntos() + " @@@");
			posicion++;				
		}
		posicion = 1;
		for(Piloto piloto : auxNegativo) {
			ResultadoCarrera res = piloto.obtenerResultadoCircuito(circuito);
			System.out.print("¡¡¡ Ha abandonado " + piloto.getNombre() + " - Tiempo: " + res.getTiempo() + " - Puntos: 0");
			if(piloto.totalCarrerasAbandonadas() >= this.limiteAbandonos) {
				System.out.print(" - Además ha sido descalificado para el resto del Campeonato");
				piloto.setDescalificado(true);
			}
			System.out.println(" !!!");
		}
		System.out.println("");
	}
	/**
	 * Gestiona el fin del campeonato
	 *   -Muestra los pilotos descalificados y los no descalifidaos
	 *   -La clasificacion de las escuderias (tambien las descalificadas)
	 *   -Comprueba si el campeonato a quedado desierto
	 */
	public void gestionarFinCampeonato() {
		System.out.println("****************************************************");
		System.out.println("**************** FIN DEL CAMPEONATO ****************");
		System.out.println("****************************************************");
		System.out.println("********** CLASIFICACIÓN FINAL DE PILOTOS **********");
		System.out.println("****************************************************");
		int hayPilotosSinDescalificar = 0;
		for(Escuderia escuderia : this.aEscuderias) {
			if(!escuderia.tienePilotosDisponibles()) { //Estan todos descalificados
				hayPilotosSinDescalificar++;
			}
		}
		
		ArrayList<Piloto> pilotosSinDescalificar = new ArrayList<Piloto>();
		ArrayList<Piloto> pilotosDescalificados = new ArrayList<Piloto>();
		for(Escuderia escuderia : this.aEscuderias) {
			ArrayList<Piloto> pilotos = (ArrayList<Piloto>) escuderia.getAPilotos();
			for(Piloto piloto : pilotos) {
				if(!piloto.isDescalificado()) {
					pilotosSinDescalificar.add(piloto);
				}else {
					pilotosDescalificados.add(piloto);
				}
			}
		}
		Collections.sort(pilotosSinDescalificar, Collections.reverseOrder(new PilotoParrillaSalidaComparator()));
		Collections.sort(pilotosDescalificados, Collections.reverseOrder(new PilotoParrillaSalidaComparator()));
		
		if(pilotosSinDescalificar.isEmpty()) {
			System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
			System.out.println("¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		int posicion = 1;
		for(Piloto piloto : pilotosSinDescalificar) {
			System.out.println("@@@ Posición(" + posicion + "): " + piloto.getNombre() + " - Puntos Totales: " + piloto.totalPuntos() + " @@@");
			for(Circuito circuito : this.tsCircuitos) {
				if(piloto.obtenerResultadoCircuito(circuito) != null) {
					System.out.println("Carrera(" + circuito.getNombre() + ") - Puntos:" + piloto.obtenerResultadoCircuito(circuito).getPuntos() + " - Tiempo:" + piloto.obtenerResultadoCircuito(circuito).getTiempo() +" minutos");								
				}
			}
			System.out.println("");
			posicion++;
		}
		System.out.println("****************************************************");
		System.out.println("************** PILOTOS DESCALIFICADOS **************");
		System.out.println("****************************************************");
		for(Piloto piloto : pilotosDescalificados) {
			System.out.println("--- Piloto Descalificado: " + piloto.getNombre() + " - Puntos Totales Anulados: " + piloto.totalPuntos() + " ---");
			for(Circuito circuito : this.tsCircuitos) {
				if(piloto.obtenerResultadoCircuito(circuito) != null) {
					System.out.println("Carrera(" + circuito.getNombre() + ") - Puntos:" + piloto.obtenerResultadoCircuito(circuito).getPuntos() + " - Tiempo:" + piloto.obtenerResultadoCircuito(circuito).getTiempo() +" minutos");								
				}
			}
			System.out.println("");
		}
	
		System.out.println("****************************************************");
		System.out.println("******** CLASIFICACIÓN FINAL DE ESCUDERÍAS *********");
		System.out.println("****************************************************");
		hayPilotosSinDescalificar = 0;
		for(Escuderia escuderia : this.aEscuderias) {
			if(!escuderia.tienePilotosDisponibles()) { //Estan todos descalificados
				hayPilotosSinDescalificar++;
			}
		}
		if(hayPilotosSinDescalificar >= this.aEscuderias.size()) {
			System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
			System.out.println("¡¡¡ Campeonato de escuderías queda desierto por haber sido descalificados todos los pilotos !!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}else {
			posicion = 1;
			Collections.sort(this.aEscuderias, Collections.reverseOrder(new EscuderiaTotalPuntosComparator()));
			for(Escuderia escuderia : this.aEscuderias) {
				if(escuderia.tienePilotosDisponibles()) {
					pilotosSinDescalificar = new ArrayList<Piloto>();
					pilotosDescalificados = new ArrayList<Piloto>();
					ArrayList<Coche> coches = (ArrayList<Coche>) escuderia.getACoches();
					ArrayList<Piloto> pilotos = (ArrayList<Piloto>) escuderia.getAPilotos();
					for(Piloto piloto : pilotos) {
						if(!piloto.isDescalificado()) {
							pilotosSinDescalificar.add(piloto);
						}else {
							pilotosDescalificados.add(piloto);
						}
					}
					System.out.println("@@@ Posición("+ posicion + ") " + escuderia.getNombre() + " con " + escuderia.puntosTotales() + " puntos @@@");
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					
					Collections.sort(pilotosSinDescalificar, new PilotoParrillaSalidaComparator());
					Collections.sort(pilotosDescalificados,new PilotoParrillaSalidaComparator());
					Collections.sort(coches,Collections.reverseOrder(new CochesStrategy1Comparator()));
					
					for(Piloto piloto : pilotosSinDescalificar) {
						System.out.println(piloto.toString());
					}
					for(Piloto piloto : pilotosDescalificados) {
						System.out.println(piloto.toString());
					}
					for(Coche coche : coches) {
						System.out.println(coche.toString());
					}
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				}
			}
		}
		System.out.println("****************************************************");
		System.out.println("************ ESCUDERIAS DESCALIFICADAS *************");
		System.out.println("****************************************************");
		Collections.sort(this.aEscuderias, new EscuderiaTotalPuntosComparator());
		for(Escuderia escuderia : this.aEscuderias) {
			if(!escuderia.tienePilotosDisponibles()) {
				pilotosSinDescalificar = new ArrayList<Piloto>();
				pilotosDescalificados = new ArrayList<Piloto>();
				ArrayList<Coche> coches = (ArrayList<Coche>) escuderia.getACoches();
				ArrayList<Piloto> pilotos = (ArrayList<Piloto>) escuderia.getAPilotos();
				for(Piloto piloto : pilotos) {
					if(!piloto.isDescalificado()) {
						pilotosSinDescalificar.add(piloto);
					}else {
						pilotosDescalificados.add(piloto);
					}
				}
				System.out.println("¡¡¡ Escudería Descalificada: " + escuderia.getNombre() + " con 0.0 puntos !!!");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				
				Collections.sort(pilotosSinDescalificar, new PilotoParrillaSalidaComparator());
				Collections.sort(pilotosDescalificados,new PilotoParrillaSalidaComparator());
				Collections.sort(coches,Collections.reverseOrder(new CochesStrategy1Comparator()));
				
				for(Piloto piloto : pilotosSinDescalificar) {
					System.out.println(piloto.toString());
				}
				for(Piloto piloto : pilotosDescalificados) {
					System.out.println(piloto.toString());
				}
				for(Coche coche : coches) {
					System.out.println(coche.toString());
				}
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			}
		}
	}
	/**
	 * Asigna los puntos al piloto correspondiente, en el circuito que sea, con el tiempo y los puntos correspondientes
	 * @param circuito
	 * @param piloto
	 * @param res
	 * @param posicion
	 */
	public void asignarPuntos(Circuito circuito, Piloto piloto, ResultadoCarrera res, int posicion) {
		switch(posicion) {
		case 1:
			piloto.añadirPuntos(circuito, res.getTiempo(), 10);
			break;
		case 2:
			piloto.añadirPuntos(circuito, res.getTiempo(), 8);
			break;
		case 3:
			piloto.añadirPuntos(circuito, res.getTiempo(), 6);
			break;
		case 4:
			piloto.añadirPuntos(circuito, res.getTiempo(), 4);
			break;
		default:
			piloto.añadirPuntos(circuito, res.getTiempo(), 2);
				
		}	
	}
	/**
	 * Envia un piloto junto a su coche a su escuderia
	 * @param escuderia
	 * @param piloto
	 */
	public void enviarPilotoCocheAEscuderia(Escuderia escuderia, Piloto piloto) {
		escuderia.recibirPiloto(piloto);
	}
}
