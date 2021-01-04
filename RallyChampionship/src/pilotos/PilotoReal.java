package pilotos;

import java.util.HashMap;

import circuitos.Circuito;
import coches.Coche;
import enumerados.Concentracion;

public abstract class PilotoReal implements Piloto{
	//--Atributos--
	protected String nombre;
	protected Coche coche; 	//Asignado por la Escuderia
	protected Concentracion concentracion;
	protected double destreza;
	protected HashMap<String, ResultadoCarrera> hashResultados; //NombreCircuito, resultado
	protected boolean descalificado; //F - no descalificado, T - descalificado
	
	//--Constructores--
	public PilotoReal() {
		this.nombre = "";
		this.coche = null;
		this.destreza = 0.0;
		this.descalificado = false;
		this.hashResultados = null;
	}
	public PilotoReal(String nombre_, Concentracion concentracion_) {
		this.nombre = nombre_;
		this.coche = null;
		this.concentracion = concentracion_;
		this.destreza = 0.0;
		this.descalificado=false;
		this.hashResultados = new HashMap<String, ResultadoCarrera>();
	}

	
	//--Getters & Setters--
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public Coche getCoche() {return coche;}
	public void setCoche(Coche coche) {this.coche = coche;}
	
	public Concentracion getConcentracion() {return concentracion;}
	public double getValorConcentracion() { return this.concentracion.getConcentracion();}
	public void setConcentracion(Concentracion concentracion) {this.concentracion = concentracion;}
	
	public double getDestreza() {
		calcularDestreza();
		return destreza;
	}
	public void setDestreza(double destreza) {this.destreza = destreza;}
	
	public boolean isDescalificado() {return descalificado;}
	public void setDescalificado(boolean descalificado) {this.descalificado = descalificado;}
	
	public HashMap<String, ResultadoCarrera> getHashResultados() {return hashResultados;}
	public void setHashResultados(HashMap<String, ResultadoCarrera> hashResultados) {this.hashResultados = hashResultados;}
	
	//--Metodos--
	public void calcularDestreza() {}
	
	public void asignarCoche(Coche coche) {
		this.coche = coche;
	}
	
	public boolean estaDescalificado() {
		if(this.descalificado == false) {
			return false;
		}else {
			return true;
		}
	}
	
	public ResultadoCarrera obtenerResultadoCircuito(Circuito circuito) {
		return this.hashResultados.get(circuito.getNombre());
	}
	
	public int totalPuntos(){
		int totalPuntos = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			totalPuntos += res.getPuntos();
		}
		return totalPuntos;
	}
	
	public int totalCarrerasParticipadas() {
		int totalParticipadas = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			if(res.getPuntos() >= 0) {
				totalParticipadas += 1;
			}
		}
		return totalParticipadas;
	}
	
	public int totalCarrerasAbandonadas() {
		int totalAbandonadas = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			if(res.getPuntos() < 0) {
				totalAbandonadas += 1;
			}
		}
		return totalAbandonadas;
	}
	
	public void conducirCoche(Circuito circuito) {
		if(this.coche.tiempoNecesarioFinalizar(this, circuito) < this.concentracion.getConcentracion() && this.coche.tieneCombustibleRestante()) {
			ResultadoCarrera res = new ResultadoCarrera(this.coche.tiempoNecesarioFinalizar(this, circuito), 0); //TODO - los puntos habra que mirar como hacerlo
			this.hashResultados.put(circuito.getNombre(), res);
			this.coche.reducirCombustible(this, circuito);
		}else if(this.coche.tiempoNecesarioFinalizar(this, circuito) > this.concentracion.getConcentracion()) {
			ResultadoCarrera res = new ResultadoCarrera(this.concentracion.getConcentracion() - this.coche.tiempoNecesarioFinalizar(this, circuito), 0); //TODO - los puntos habra que mirar como hacerlo
			this.hashResultados.put(circuito.getNombre(), res); 
			this.coche.restarCombustible(this.concentracion.getConcentracion());
		}else {
			ResultadoCarrera res = new ResultadoCarrera(this.coche.getCombustibleRestante() - this.coche.tiempoNecesarioFinalizar(this, circuito), 0);//TODO - los puntos habra que mirar como hacerlo
			this.hashResultados.put(circuito.getNombre(), res);
			this.coche.restarCombustible(this.coche.tiempoNecesarioFinalizar(this, circuito));
		}
	}
	@Override
	public String toString() {
		return "<piloto:" + this.nombre + "> <tipo: "+ getClass().getSimpleName() + "> <dest: " + this.destreza + "> <conc: " + this.concentracion.getNombre() + "(" + this.concentracion.getConcentracion() +
				")> <descalificado:" + this.descalificado + ">";
	}
	
	//TODO -aplicar strategy para cambiar coche
}
