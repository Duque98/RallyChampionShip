package escuderias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

import circuitos.CircuitoReal;
import coches.Coche;
import pilotos.Piloto;
import pilotos.ResultadoCarrera;
import rally.Organizacion;
import strategy.IStrategy;

/**
 * Clase modelo para representar una escuderia
 *  @author Jose Ignacio Duque Blazquez
 *
 */
public class EscuderiaReal implements Escuderia{
	//Strategy
	private IStrategy strategy;		//Interfaz para aplicar el patron strategy para la ordenacion
	//--Atributos--
	private String nombre;			//Nombre de la escuderia
	private List<Piloto> aPilotos;  //List (ArrayList) de pilotos 
	private List<Coche> aCoches;	//List (ArrayList) de coches 
	
	//--Constructores--
	/**
	 * Constructor por defecto
	 */
	public EscuderiaReal() {
		this.nombre = "";
		this.aPilotos = null;
		this.aCoches = null;
	}
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param strategy
	 */
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
	/**
	 * Si tiene una estrategia de ordenacion (strategy) ordenara los pilotos y coches segun la estrategia
	 */
	public void ordenar() {
		if(this.strategy != null) {
			this.strategy.ordenar(this.aPilotos, this.aCoches);			
		}
	}
	/**
	 * Añade un piloto a su estructura de datos y añade al piloto la escuderia a la que pertenece
	 */
	public void añadirPiloto(Piloto piloto) {
		this.aPilotos.add(piloto);
		piloto.setEscuderia(this.nombre);
	}
	/**
	 * Añade un coche a su estructura de datos
	 */
	public void añadirCoche(Coche coche) {
		this.aCoches.add(coche);
	}
	/**
	 * Devuelve los puntos totales de los pilotos sin descalificar 
	 * @return
	 */
	public int puntosTotales() {
		int totalPuntos = 0;
		for (Piloto piloto: this.aPilotos) {
			if(!piloto.isDescalificado()) {
				totalPuntos += piloto.totalPuntos();
				
			}
		}
		return totalPuntos;
	}
	/**
	 * Se inscribe en la organizacion para competir
	 */
	public void inscribirseAlCampeonato() {
		Organizacion.getInstanceWithoutParameter().inscribirEscuderia(this);
	}
	/**
	 * Envia un piloto junto a su coche a competir 
	 *  - Si no tiene coches con combustible no lo envia y muestra un mensaje
	 */
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
	/**
	 * Recibe un piloto y si tiene un coche tambien lo recibe
	 */
	public void recibirPiloto(Piloto piloto) {
		this.aPilotos.add(piloto);
		if(piloto.getCoche()!=null) {
			this.aCoches.add(piloto.getCoche());			
		}
	}
	/**
	 * Devuelve true si todavia tiene algun coche con combustible
	 * @return
	 */
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
	/**
	 * Devuelve todas las carreras terminadas por todos sus pilotos
	 */
	public int totalCarrerasTerminadas() {
		int totalTerminadas = 0;
		for(Piloto piloto : this.aPilotos) {
			totalTerminadas += piloto.totalCarrerasParticipadas();
		}
		return totalTerminadas;
	}
	
	/**
	 * Devuelve true si todavia tiene algun piloto sin descalificar, devuelve false si todos descalificados
	 */
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
	/**
	 * Devuelve cuantos pilotos estan sin descalificar
	 */
	public int cuantosPilotoDisponibles() {
		int pilotosDisponibles = 0;
		for(Piloto piloto : this.aPilotos) {
			if(!piloto.isDescalificado()) {
				pilotosDisponibles++;
			}
		}
		return pilotosDisponibles;
	}
	/**
	 * Metodo toString para mostrar la informacion de una escuderia
	 */
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
	
	/**
	 * Metodo equals para saber si dos objetos son iguales
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true; //Ambos referencian al mismo objeto
		}
		if(!(obj instanceof EscuderiaReal)) {
			return false; //Tienen diferentes tipos
		}
		EscuderiaReal other = (EscuderiaReal) obj;
		return this.nombre.equals(other.getNombre()) && this.strategy == other.getStrategy() && this.aPilotos == other.getAPilotos() && this.aCoches == other.getACoches();
	}
	/**
	 * Metodo hashCode 
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 7 * result + this.nombre.hashCode();
		return result;
	}
}
