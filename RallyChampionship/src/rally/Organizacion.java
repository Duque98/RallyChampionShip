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
import comparators.EscuderiaTotalPuntosComparator;
import comparators.PilotoParrillaSalidaComparator;
import comparators.TiempoCarreraComparator;
import escuderias.Escuderia;
import pilotos.Piloto;
import pilotos.ResultadoCarrera;

/**
 * Clase modelo para representar la Organizacion
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Organizacion {
	//--Atributos--
	private static Organizacion org; 			//Singleton
	
	private int limiteAbandonos; 				//Numero maximo de abandonos que un piloto puede tener en el transcurso de un campeonato
	private int limitePilotos;					//Numero maximo de pilotos que una escuderia puede enviar a la competicion

	private TreeSet<Circuito> tsCircuitos;		//Circuitos que componen el campeonato 
	
	private List<Escuderia> aEscuderias;	//Escuderias que se han inscrito para el campeonato
	private List<Piloto> aPilotos;			//Pilotos junto al coche que van a competir en una carrera 
	
	
	//--Constructores--
	private Organizacion(int limiteAbandonos, int limitePilotos, Comparator<Circuito> ordenCircuitos) {
		this.limiteAbandonos = limiteAbandonos;
		this.limitePilotos = limitePilotos;
		this.tsCircuitos = new TreeSet<Circuito>(ordenCircuitos);
		this.aEscuderias = new ArrayList<Escuderia>();
		this.aPilotos = new ArrayList<Piloto>();
	}
	
	public static Organizacion getInstance(int limiteAbandonos, int limitePilotos, Comparator<Circuito> ordenCircuitos) {
		if(org == null) {
			org = new Organizacion(limiteAbandonos, limitePilotos, ordenCircuitos);
		}
		return org;
	}
	
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
	public void añadirCircuito(Circuito circuito) {
		this.tsCircuitos.add(circuito);
	}
	public void inscribirEscuderia(Escuderia escuderia) {
		this.aEscuderias.add(escuderia);
		Collections.sort(this.aEscuderias, Collections.reverseOrder(new EscuderiaTotalPuntosComparator()));
	}
	
	public void recibirPilotoDelCampeonato(Piloto piloto) {
		this.aPilotos.add(piloto);
	}
	


	//TODO - Gestionar el desarrollo del campeonato
	public void simulacion() {
		System.out.println("*********************************************************************************************************\r\n" + 
							"*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************\r\n" + 
							"*********************************************************************************************************\r\n" + 
							"\r\n" + "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\r\n" + 
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
		
		//TODO - fin del campeonato
	}
	
	
	public void gestionarCelebracionCarrera() {
		int numCarrera = 1;
		Iterator<Circuito> it = this.tsCircuitos.iterator();
		while(it.hasNext() && !esFin()) {
			Circuito circuito = it.next();
			System.out.println("********************************************************************************************************");
			System.out.println("*** CARRERA <" + numCarrera + "> EN " + circuito.toString() + " ***");
			System.out.println("********************************************************************************************************");
			
			for (int pilotoEnviados = 0; pilotoEnviados < this.limitePilotos; pilotoEnviados++) {
				for(Escuderia escuderia : this.aEscuderias) {
					escuderia.enviarPilotoAlCampeonato();
				}
			}
			
			System.out.println("********************************************************************************************************");
			System.out.println("******************************** Pilotos que van a competir en " + circuito.getNombre() + " *******************************");
			System.out.println("**********************************************************************************************************");
			//Ordenar los pilotos
			Collections.sort(this.aPilotos, new PilotoParrillaSalidaComparator());
			
			if(this.aPilotos.size() <= 1) {
				System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
				System.out.println("¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}else {
				for(Piloto piloto : this.aPilotos) {
					System.out.println(piloto.toString());
				}
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + circuito.getNombre() + "++++++++++++++++++++++++++");
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
	public void enviarPilotoCocheAEscuderia(Escuderia escuderia, Piloto piloto) {
		escuderia.recibirPiloto(piloto);
	}
	
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
	/*
	 * No hay pilotos disponibles (todos descalificados)
	 * Solo queda 1 piloto (el resto descalificado)
	 */
	public boolean esFin() {
		boolean fin = false;
		int i = 0;
		int numeroPilotosDisponibles = 0;
		while (i < this.aEscuderias.size() && !fin) {
			if(!this.aEscuderias.get(i).tienePilotosDisponibles()) {
				fin = true;
			}
			numeroPilotosDisponibles += this.aEscuderias.get(i).cuantosPilotoDisponibles();
			i++;
		}
		if(numeroPilotosDisponibles <= 1) {
			fin = true;
		}
		return fin;
	}
}
