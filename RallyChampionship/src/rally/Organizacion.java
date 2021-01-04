package rally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import circuitos.Circuito;
import comparators.EscuderiaTotalPuntosComparator;
import comparators.PilotoParrillaSalidaComparator;
import escuderias.Escuderia;
import pilotos.Piloto;

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
	}
	
	//TODO - Gestionar la celebracion de cada carrera del campeonato
	public void gestionarCelebracionCarrera() {
		int numCarrera = 1;
		Iterator<Circuito> it = this.tsCircuitos.iterator();
		while(it.hasNext() && !esFin()) {
			Circuito circuito = it.next();
			System.out.println("********************************************************************************************************");
			System.out.println("*** CARRERA <" + numCarrera + "> EN " + circuito.toString() + " ***");
			System.out.println("********************************************************************************************************");
			System.out.println("********************************************************************************************************");
			System.out.println("******************************** Pilotos que van a competir en " + circuito.getNombre() + " *******************************");
			System.out.println("**********************************************************************************************************");
			
			for (int pilotoEnviados = 0; pilotoEnviados < this.limitePilotos; pilotoEnviados++) {
				for(Escuderia escuderia : this.aEscuderias) {
					escuderia.enviarPilotoAlCampeonato();
				}
			}
			
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
					
					System.out.println("+++ Con estas condiciones es capaz de correr a " + piloto.getCoche().calcularVelocidadReal(piloto, circuito)+ "km/hora +++");
					
					//TODO- vamos por aqui
					
					
					numeroPiloto++;
					System.out.println("@@@");
				}
			}
			this.aPilotos = new ArrayList<Piloto>();
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
