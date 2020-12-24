package rally;

import java.util.ArrayList;
import java.util.Comparator;

import circuitos.Circuito;
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
	private ArrayList<Circuito> aCircuitos;		//Circuitos que componen el campeonato TODO - quizas treeSet
	private ArrayList<Escuderia> aEscuderias;	//Escuderias que se han inscrito para el campeonato TODO - quizas hashSet
	private ArrayList<Piloto> aPilotos;			//Pilotos que van a competir en una carrera TODO - quizas hashSet
	
	//--Constructores--
	private Organizacion(int limiteAbandonos, int limitePilotos) {
		this.limiteAbandonos = limiteAbandonos;
		this.limitePilotos = limitePilotos;
		this.aCircuitos = new ArrayList<Circuito>();
		this.aEscuderias = new ArrayList<Escuderia>();
		this.aPilotos = new ArrayList<Piloto>();
	}
	
	public static Organizacion getInstance(int limiteAbandonos, int limitePilotos) {
		if(org == null) {
			org = new Organizacion(limiteAbandonos, limitePilotos);
		}
		return org;
	}

	//--Getters & Setters
	public int getLimiteAbandonos() {return limiteAbandonos;}
	public void setLimiteAbandonos(int limiteAbandonos) {this.limiteAbandonos = limiteAbandonos;}
	public int getLimitePilotos() {return limitePilotos;}
	public void setLimitePilotos(int limitePilotos) {this.limitePilotos = limitePilotos;}
	
	//--Metodos--
	//TODO - Permitir la inscripcion de las escuderia en el campeonato
	//TODO - Gestionar el desarrollo del campeonato
	//TODO - Gestionar la celebracion de cada carrera del campeonato
}
