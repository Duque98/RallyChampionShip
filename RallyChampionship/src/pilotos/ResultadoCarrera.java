package pilotos;

/**
 * Clase para representar los resultados de un piloto en una carrera
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class ResultadoCarrera {
	//--Atributos --
	private double tiempo;	//Medido en minutos
	private int puntos;
	
	//--Constructores
	/**
	 * Constructor por defecto
	 */
	public ResultadoCarrera() {
		this.tiempo = 0.0;
		this.puntos = 0;
	}
	/**
	 * Constructor parametrizado
	 * @param tiempo_
	 * @param puntos_
	 */
	public ResultadoCarrera(double tiempo_, int puntos_) {
		this.tiempo = tiempo_;
		this.puntos = puntos_;
	}
	
	//--Getters & Setters
	public double getTiempo() {return tiempo;}
	public void setTiempo(double tiempo) {this.tiempo = tiempo;}
	public int getPuntos() {return puntos;}
	public void setPuntos(int puntos) {this.puntos = puntos;}
	
	
}
