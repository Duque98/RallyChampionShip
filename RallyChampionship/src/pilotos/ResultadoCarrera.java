package pilotos;

/**
 * Clase para representar los resultados de un piloto en una carrera
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class ResultadoCarrera {
	//--Atributos --
	private int tiempo;	//Medido en minutos
	private int puntos;
	
	//--Constructores
	public ResultadoCarrera() {
		this.tiempo = 0;
		this.puntos = 0;
	}
	public ResultadoCarrera(int tiempo_, int puntos_) {
		this.tiempo = tiempo_;
		this.puntos = puntos_;
	}
	
	//--Getters & Setters
	public int getTiempo() {return tiempo;}
	public void setTiempo(int tiempo) {this.tiempo = tiempo;}
	public int getPuntos() {return puntos;}
	public void setPuntos(int puntos) {this.puntos = puntos;}
	
	
}
