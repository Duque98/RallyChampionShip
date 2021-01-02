package escuderias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

import coches.Coche;
import pilotos.Piloto;
import pilotos.ResultadoCarrera;
import rally.Organizacion;
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
	public int puntosTotales() {
		int totalPuntos = 0;
		for (Piloto piloto: this.aPilotos) {
			for(ResultadoCarrera res : piloto.getHashResultados().values()) {
				//TODO - Creo que falta condicion de que el piloto no este descalificado if(piloto.isDescalificado())
				totalPuntos += res.getPuntos();
			}
		}
		return totalPuntos;
	}
	
	public void inscribirseAlCampeonato() {
		Organizacion.getInstanceWithoutParameter().inscribirEscuderia(this);
	}
	
	public void enviarPilotosAlCampeonato() {
		ArrayList<Piloto> pilotoEnviar = new ArrayList<Piloto>();
		if(!this.aPilotos.isEmpty()) {
			for (Piloto piloto : this.aPilotos) {
				if(!piloto.isDescalificado()) {
					if(!this.aCoches.isEmpty()) {
						int j = 0;
						boolean enc = false;
						while(j < this.aCoches.size() && !enc) {
							if(this.aCoches.get(j).tieneCombustibleRestante()) {
								piloto.setCoche(this.aCoches.get(j));
								enc = true;
							}else {
								piloto.setCoche(null);
							}
						}
					}
					pilotoEnviar.add(piloto);
				}
			}
		}
		Organizacion.getInstanceWithoutParameter().recibirPilotosDelCampeonato(pilotoEnviar);
	}
}
