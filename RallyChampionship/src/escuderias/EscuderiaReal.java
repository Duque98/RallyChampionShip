package escuderias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coches.Coche;
import pilotos.Piloto;
import strategy.IStrategy;

public class EscuderiaReal implements Escuderia{
	//Strategy
	private IStrategy strategy;
	
	//--Atributos--
	private String nombre;
	private List<Piloto> aPilotos; 
	private List<Coche> aCoches;	
	
	//--Constructores--
	public EscuderiaReal() {
		this.nombre = "";
		this.aPilotos = null;
		this.aCoches = null;
	}
	public EscuderiaReal(String nombre_,IStrategy strategy) {
		this.nombre = nombre_;
		this.strategy = strategy;
		this.aPilotos = new ArrayList<Piloto>();
		this.aCoches = new ArrayList<Coche>();
	}
	
	//--Getters & Setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public List<Piloto> getAPilotos() {return aPilotos;}
	public void setAPilotos(ArrayList<Piloto> setPilotos) {this.aPilotos = setPilotos;}
	public List<Coche> getACoches() {return aCoches;}
	public void setACoches(ArrayList<Coche> aCoches) {this.aCoches = aCoches;}
	public IStrategy getStrategy() {return strategy;}
	public void setStrategy(IStrategy strategy) {this.strategy = strategy;}
	
	//--Metodos--
	public void ordenar() {
		if(this.strategy != null) {
			this.strategy.ordenar(this.aPilotos, this.aCoches);			
		}
	}
	
	public void añadirPiloto(Piloto piloto) {
		this.aPilotos.add(piloto);
	}
	public void añadirCoche(Coche coche) {
		this.aCoches.add(coche);
	}
	
	public void mostrar() {
		System.out.println("Mostrando los coches...");
		for (int i = 0; i < this.aCoches.size(); i++) {
			System.out.println(this.aCoches.get(i).getNombre());
		}
		System.out.println("Mostrando los pilotos...");
		for (int i = 0; i < this.aPilotos.size(); i++) {
			System.out.println(this.aPilotos.get(i).getNombre());
		}
	}
	
	//TODO - Inscribirse en un campeonato gestionado por la organizacion
	//TODO - Informacion sobre los puntos totales obtenidos por sus pilotos
	//TODO - Enviar a los pilotos (no descalificados) junto a sus coches (con combustible) a la organizacion para competir
}
