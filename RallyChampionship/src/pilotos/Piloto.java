package pilotos;

import java.util.HashMap;

import coches.Coche;
import enumerados.Concentracion;

/**
 * Clase modelo para un piloto
 * @author Jose Ignacio Duque Blazquez
 *
 */
public abstract class Piloto {
	//--Atributos--
	protected String nombre;
	protected Coche coche; 	//Asignado por la Escuderia
	protected Concentracion concentracion;
	protected double destreza;
	protected HashMap<String, ResultadoCarrera> hashResultados;
	protected boolean descalificado; //F - no descalificado, T - descalificado
	
	//--Constructores--
	public Piloto() {
		this.nombre = "";
		this.destreza = 0.0;
		this.descalificado = false;
		this.hashResultados = null;
	}
	public Piloto(String nombre_, Coche coche_, Concentracion concentracion_) {
		this.nombre = nombre_;
		this.coche = coche_;
		this.concentracion = concentracion_;
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
	
	public double getDestreza() {return destreza;}
	public void setDestreza(double destreza) {this.destreza = destreza;}
	
	public boolean isDescalificado() {return descalificado;}
	public void setDescalificado(boolean descalificado) {this.descalificado = descalificado;}
	
	public HashMap<String, ResultadoCarrera> getHashResultados() {return hashResultados;}
	public void setHashResultados(HashMap<String, ResultadoCarrera> hashResultados) {this.hashResultados = hashResultados;}
	
	
	
	//--Metodos--
	
	
	
}
