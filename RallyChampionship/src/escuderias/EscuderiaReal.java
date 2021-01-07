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
		piloto.setEscuderia(this.nombre);
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
	
	public void enviarPilotoAlCampeonato() {
		ordenar();
		if(quedanCochesConCombustible()) {
			if(!this.aPilotos.isEmpty()) {
				int i = 0;
				int j = 0;
				boolean pilotoEnviado = false;
				while (i < this.aPilotos.size() && !pilotoEnviado) {
					Piloto piloto = this.aPilotos.get(i);
					if(!piloto.isDescalificado()) {			
						boolean enc = false;
						while(j < this.aCoches.size() && !enc) {
							Coche coche = this.aCoches.get(j);
							if(coche.tieneCombustibleRestante()) {
								piloto.setCoche(coche);
								enc = true;
								this.aCoches.remove(coche);
							}else {
								piloto.setCoche(null);
							}
							j++;
						}
						Organizacion.getInstanceWithoutParameter().recibirPilotoDelCampeonato(piloto);
						pilotoEnviado = true;
						this.aPilotos.remove(piloto);
					}
					i++;
				}
			}
		}else {
			if(!this.aPilotos.isEmpty()) {
				int i = 0;
				int j = 0;
				boolean pilotoEnviado = false;
				while (i < this.aPilotos.size() && !pilotoEnviado) {
					Piloto piloto = this.aPilotos.get(i);
					if(!piloto.isDescalificado()) {	
						pilotoEnviado = true;
						this.aPilotos.remove(piloto);
						this.aPilotos.add(piloto);
						System.out.println("¡¡¡ " + piloto.getNombre() + " NO ES ENVIADO A LA CARRERA porque su escudería(" + this.nombre +") no tiene más coches con combustible disponibles !!!");
					}
					i++;
				}
			}
		}
	}
	
	public void recibirPiloto(Piloto piloto) {
		this.aPilotos.add(piloto);
		if(piloto.getCoche()!=null) {
			this.aCoches.add(piloto.getCoche());			
		}
	}
	
	//Devuelve true si todavia tiene algun coche con combustible
	public boolean quedanCochesConCombustible() {
		boolean quedanCoches = false;
		if(!this.aCoches.isEmpty()) {
			int i = 0;
			while (i < this.aCoches.size() && !quedanCoches){
				if(this.aCoches.get(i).tieneCombustibleRestante()) {
					quedanCoches = true;
				}
				i++;
			}
		}
		return quedanCoches;
	}
	
	public int totalCarrerasTerminadas() {
		int totalTerminadas = 0;
		for(Piloto piloto : this.aPilotos) {
			totalTerminadas += piloto.totalCarrerasParticipadas();
		}
		return totalTerminadas;
	}
	
	//Devuelve true si todavia tiene algun piloto sin descalificar
	public boolean tienePilotosDisponibles() {
		int i = 0;
		boolean quedanPilotos = false;
		while (i < this.aPilotos.size() && !quedanPilotos) {
			if(!this.aPilotos.get(i).isDescalificado()) { //No esta descalificado
				quedanPilotos = true;
			}
			i++;
		}
		return quedanPilotos;
	}
	public int cuantosPilotoDisponibles() {
		int pilotosDisponibles = 0;
		for(Piloto piloto : this.aPilotos) {
			if(!piloto.isDescalificado()) {
				pilotosDisponibles++;
			}
		}
		return pilotosDisponibles;
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux = "%%% " + this.nombre + " %%%" + "\n";
		for(Piloto piloto : this.aPilotos) {
			aux += piloto.toString();
			aux += "\n";
		}
		for(Coche coche : this.aCoches) {
			aux += coche.toString();
			aux += "\n";
		}
		return aux;
	}
}
