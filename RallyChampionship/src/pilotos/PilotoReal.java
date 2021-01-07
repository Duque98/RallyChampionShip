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
	protected HashMap<String, ResultadoCarrera> hashResultados; //NombreCircuito, resultado
	protected boolean descalificado; //F - no descalificado, T - descalificado
	protected String escuderia; //Escuderia a la que pertenece el piloto
	
	//--Constructores--
	public PilotoReal() {
		this.nombre = "";
		this.coche = null;
		this.descalificado = false;
		this.hashResultados = null;
		this.escuderia = "";
	}
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
	public abstract double calcularDestreza();
	
	public void asignarCoche(Coche coche) {
		this.coche = coche;
	}
	
	public ResultadoCarrera obtenerResultadoCircuito(Circuito circuito) {
		return this.hashResultados.get(circuito.getNombre());
	}
	
	public void añadirPuntos(Circuito circuito, double tiempo, int puntos) {
		this.hashResultados.put(circuito.getNombre(), new ResultadoCarrera(tiempo, puntos));
	}
	
	public int totalPuntos(){
		int totalPuntos = 0;
		if(!this.hashResultados.isEmpty()) {
			for(ResultadoCarrera res : this.hashResultados.values()) {
				totalPuntos += res.getPuntos();
			}	
		}
		return totalPuntos;
	}
	
	public int totalCarrerasParticipadas() {
		int totalParticipadas = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			if(res.getPuntos() > 0) {
				totalParticipadas += 1;
			}
		}
		return totalParticipadas;
	}
	
	public int totalCarrerasAbandonadas() {
		int totalAbandonadas = 0;
		for(ResultadoCarrera res : this.hashResultados.values()) {
			if(res.getPuntos() <= 0 && res.getTiempo() < 0.0) {
				totalAbandonadas += 1;
			}
		}
		return totalAbandonadas;
	}
	
	public boolean terminoCarrera(Circuito circuito) {
		if(this.hashResultados.get(circuito.getNombre()).getPuntos() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
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
			//System.out.println("¡¡¡ El " + this.coche.getNombre() + " se quedó sin combustible a falta de " + (combustibleNecesario * -1)+ " minutos para terminar !!!");
			//System.out.println("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera " + Math.round(((tiempoNecesario - (combustibleNecesario * -1)))* 100d) / 100d + " minutos !!!");
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
	@Override
	public String toString() {
		return "<piloto:" + this.nombre + "> <tipo: "+ getClass().getSimpleName() + "> <dest: " + calcularDestreza() + "> <conc: " + this.concentracion.getNombre() + "(" + this.concentracion.getConcentracion() +
				")> <descalificado:" + this.descalificado + ">";
	}
	
}
