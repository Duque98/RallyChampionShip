package rally;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import circuitos.Circuito;
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
	
	private ArrayList<Escuderia> aEscuderias;	//Escuderias que se han inscrito para el campeonato TODO - quizas hashSet
	private ArrayList<Piloto> aPilotos;			//Pilotos que van a competir en una carrera TODO - quizas hashSet
	
	
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

	//--Getters & Setters
	public int getLimiteAbandonos() {return limiteAbandonos;}
	public void setLimiteAbandonos(int limiteAbandonos) {this.limiteAbandonos = limiteAbandonos;}
	public int getLimitePilotos() {return limitePilotos;}
	public void setLimitePilotos(int limitePilotos) {this.limitePilotos = limitePilotos;}
	
	//--Metodos--
	public void aņadirCircuito(Circuito circuito) {
		this.tsCircuitos.add(circuito);
	}
	//TODO - Permitir la inscripcion de las escuderia en el campeonato
	//TODO - Gestionar el desarrollo del campeonato
	//TODO - Gestionar la celebracion de cada carrera del campeonato
}
