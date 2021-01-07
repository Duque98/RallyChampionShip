package pilotos;

import java.util.HashMap;

import circuitos.Circuito;
import coches.Coche;
import enumerados.Concentracion;

/**
 * Clase modelo para un piloto
 * @author Jose Ignacio Duque Blazquez
 *
 */
public abstract class PilotoReal implements Piloto{
	//--Atributos--
	protected String nombre;
	protected Coche coche; 	//Asignado por la Escuderia
	protected Concentracion concentracion;
	protected HashMap<String, ResultadoCarrera> hashResultados; //HashMap<NombreCircuito, resultado>
	protected boolean descalificado; //F - no descalificado, T - descalificado
	protected String escuderia; //Escuderia a la que pertenece el piloto
	
	//--Constructores--
	/**
	 * Constructor por defecto
	 */
	public PilotoReal() {
		this.nombre = "";
		this.coche = null;
		this.descalificado = false;
		this.hashResultados = null;
		this.escuderia = "";
	}
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param concentracion_
	 */
	public PilotoReal(String nombre_, Concentracion concentracion_) {
		this.nombre = nombre_;
		this.coche = null;
		this.concentracion = concentracion_;
		this.descalificado=false;
		this.hashResultados = new HashMap<String, ResultadoCarrera>();
		this.escuderia = "";
	}

	
	//--Getters & Setters--
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public Coche getCoche() {return coche;}
	public void setCoche(Coche coche) {this.coche = coche;}
	public Concentracion getConcentracion() {return concentracion;}
	public double getValorConcentracion() { return this.concentracion.getConcentracion();}
	public void setConcentracion(Concentracion concentracion) {this.concentracion = concentracion;}
	public boolean isDescalificado() {return descalificado;}
	public void setDescalificado(boolean descalificado) {this.descalificado = descalificado;}
	public HashMap<String, ResultadoCarrera> getHashResultados() {return hashResultados;}
	public void setHashResultados(HashMap<String, ResultadoCarrera> hashResultados) {this.hashResultados = hashResultados;}
	public String getEscuderia() {return escuderia;}
	public void setEscuderia(String escuderia) {this.escuderia = escuderia;}
	
	//--Metodos--
	/**
	 * Metodo para calcular la destreza, se calcula en los hijos
	 */
	public abstract double calcularDestreza();
	/**
	 * Asigna un coche al piloto
	 * @param coche
	 */
	public void asignarCoche(Coche coche) {
		this.coche = coche;
	}
	/**
	 * Devuelve el resultado del piloto en un circuito en concreto
	 * 	- Devuelve el resultado si ha corrido en el circuito, en caso contrario devuelve null
	 *  @param circuito
	 */
	public ResultadoCarrera obtenerResultadoCircuito(Circuito circuito) {
		if(this.hashResultados.containsKey(circuito.getNombre())) {
			return this.hashResultados.get(circuito.getNombre());			
		}else {
			return null;
		}
	}
	/**
	 * Añade un resultado en el circuito correspondiente dentro del hashMap
	 * @param circuito
	 * @param tiempo
	 * @param puntos
	 */
	public void añadirPuntos(Circuito circuito, double tiempo, int puntos) {
		this.hashResultados.put(circuito.getNombre(), new ResultadoCarrera(tiempo, puntos));
	}
	/**
	 * Devuelve el total de puntos siempre que haya corrido en algun circuito
	 */
	public int totalPuntos(){
		int totalPuntos = 0;
		if(!this.hashResultados.isEmpty()) {
			for(ResultadoCarrera res : this.hashResultados.values()) {
				totalPuntos += res.getPuntos();
			}	
		}
		return totalPuntos;
	}
	/**
	 * Devuelve el numero de carreras en las que ha participado (puntos > 0)
	 */
	public int totalCarrerasParticipadas() {
		int totalParticipadas = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			if(res.getPuntos() > 0) {
				totalParticipadas += 1;
			}
		}
		return totalParticipadas;
	}
	/**
	 * Devuelve el numero de carreras que ha abandonado (puntos <=0 && tiempo < 0)
	 */
	public int totalCarrerasAbandonadas() {
		int totalAbandonadas = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			if(res.getPuntos() <= 0 && res.getTiempo() < 0.0) {
				totalAbandonadas += 1;
			}
		}
		return totalAbandonadas;
	}
	/**
	 * Devuelve true si termino la carrera en un circuito correspondiente
	 * @param circuito
	 */
	public boolean terminoCarrera(Circuito circuito) {
		if(this.hashResultados.containsKey(circuito.getNombre())) {			
			if(this.hashResultados.get(circuito.getNombre()).getPuntos() > 0) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	/**
	 * Conduce un coche en un circuito
	 *  - Si va bien de concentracion y de combustible termina la carrera
	 *  - Si le falta concentracion, pierde la carrera por concentracion
	 *  - Si le falta combustible, pierde la carrera por combustible
	 * @param circuito
	 */
	public void conducirCoche(Circuito circuito) {
		double tiempoNecesario = this.coche.tiempoNecesarioFinalizar(this, circuito);
		double concentracionNecesaria = Math.round((this.concentracion.getConcentracion() - tiempoNecesario)* 100d) / 100d;
		double combustibleNecesario = Math.round((this.coche.getCombustibleRestante() - tiempoNecesario)* 100d) / 100d;
		
		if(tiempoNecesario < this.concentracion.getConcentracion() && tiempoNecesario < this.coche.getCombustibleRestante()) { //Conduce bien, va bien de concentracion y de combustible
			ResultadoCarrera res = new ResultadoCarrera(tiempoNecesario, 0); 
			this.hashResultados.put(circuito.getNombre(), res);
			this.coche.reducirCombustible(tiempoNecesario);
			System.out.println("+++ " + this.nombre + " termina la carrera en " + tiempoNecesario + " minutos +++");
			
		}else if(this.concentracion.getConcentracion() <= this.coche.getCombustibleRestante()) { //Me quedo antes sin concentracion que de combustible
			//Falta de concentracion
			ResultadoCarrera res = new ResultadoCarrera(concentracionNecesaria, 0); 
			this.hashResultados.put(circuito.getNombre(), res); 
			this.coche.restarCombustible(this.concentracion.getConcentracion());
			System.out.println("¡¡¡ "+ this.nombre + " perdió la concentración a falta de " + (concentracionNecesaria * -1)+ " minutos para terminar !!!");
			System.out.println("¡¡¡ En el momento del despiste llevaba en carrera " + this.concentracion.getConcentracion()  + " minutos !!!");
		}else {
			//Falta de combustible
			ResultadoCarrera res = new ResultadoCarrera(combustibleNecesario, 0);
			this.hashResultados.put(circuito.getNombre(), res);
			this.coche.reducirCombustible(tiempoNecesario);
			if(this.concentracion.getConcentracion() <= this.coche.getCombustibleRestante()) { 
				System.out.println("¡¡¡ "+ this.nombre + " perdió la concentración a falta de " + (concentracionNecesaria * -1)+ " minutos para terminar !!!");
				System.out.println("¡¡¡ En el momento del despiste llevaba en carrera " + this.concentracion.getConcentracion()  + " minutos !!!");
				this.coche.restarCombustible(this.concentracion.getConcentracion());
				ResultadoCarrera resNuevo = new ResultadoCarrera(concentracionNecesaria, 0);
				this.hashResultados.put(circuito.getNombre(), resNuevo);
			}else {
				System.out.println("¡¡¡ El " + this.coche.getNombre() + " se quedó sin combustible a falta de " + (combustibleNecesario * -1)+ " minutos para terminar !!!");
				System.out.println("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera " + Math.round(((tiempoNecesario - (combustibleNecesario * -1)))* 100d) / 100d + " minutos !!!");
				ResultadoCarrera resNuevo = new ResultadoCarrera(combustibleNecesario, 0);
				this.hashResultados.put(circuito.getNombre(), resNuevo);
			}
		}
	}
	/**
	 * Metodo toString para mostrar la inforacion de un piloto
	 */
	@Override
	public String toString() {
		return "<piloto:" + this.nombre + "> <tipo: "+ getClass().getSimpleName() + "> <dest: " + calcularDestreza() + "> <conc: " + this.concentracion.getNombre() + "(" + this.concentracion.getConcentracion() +
				")> <descalificado:" + this.descalificado + ">";
	}
	
}
