package rally;

import java.util.ArrayList;
import java.util.HashSet;

import coches.Coche;
import pilotos.Piloto;

/**
 * Clase modelo para representar una Escuderia
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Escuderia {
	//--Atributos--
	private String nombre;
	private ArrayList<Piloto> aPilotos;
	private ArrayList<Coche> aCoches;
	
	//--Constructores--
	public Escuderia() {
		this.nombre = "";
		this.aPilotos = null;
		this.aCoches = null;
	}
	public Escuderia(String nombre_, ArrayList<Piloto> pilotos_, ArrayList<Coche> coches_) {
		this.nombre = nombre_;
		this.aPilotos = pilotos_;
		this.aCoches = coches_;
	}
	
	
	//--Getters & Setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public ArrayList<Piloto> getSetPilotos() {return aPilotos;}
	public void setSetPilotos(ArrayList<Piloto> setPilotos) {this.aPilotos = setPilotos;}
	public ArrayList<Coche> getACoches() {return aCoches;}
	public void setACoches(ArrayList<Coche> aCoches) {this.aCoches = aCoches;}
		
	//--Metodos--
	//TODO - Inscribirse en un campeonato gestionado por la organizacion
	//TODO - Ordenar sus pilotos y coches de acuerdo a los criterios, estos criterios se pueden modificar
	//TODO - Informacion sobre los puntos totales obtenidos por sus pilotos
	//TODO - Enviar a los pilotos (no descalificados) junto a sus coches (con combustible) a la organizacion para competir
}
