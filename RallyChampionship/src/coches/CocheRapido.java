package coches;

import circuitos.Circuito;
import enumerados.Combustible;
import enumerados.Velocidad;
import pilotos.Piloto;

/**
 * Clase modelo de un subtipo de Coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CocheRapido extends CocheReal{
	//--Atributos--
	private double depositoNitro;
	
	//--Constructores--
	public CocheRapido() {
		super(); 
		this.depositoNitro = 80.0;
	}
	public CocheRapido(String nombre_, Velocidad velocidad_ , Combustible combustible_) {
		super(nombre_,velocidad_,combustible_);
		this.depositoNitro = 80.0; //Siempre va a ser 80L
	}
	
	//--Getters & Setters
	public double getDepositoNitro() {return this.depositoNitro;}
	public void setDepositoNitro(double depositoNitro_) { this.depositoNitro = depositoNitro_;}
	
	//--Metodos--
	@Override
	public double calcularVelocidadReal(Piloto piloto, Circuito circuito) {
		double velocidadReal = Math.round(((this.velocidad.getVelocidad() *  piloto.getDestreza()) / circuito.getComplejidadModificada())* 100d) / 100d;
		if(this.depositoNitro > 0.0) {
			double porcentaje = (velocidadReal * 20 ) / 100;
			if(porcentaje <= this.depositoNitro) {
				velocidadReal += porcentaje;
				this.depositoNitro -= porcentaje;
			}else {
				velocidadReal += this.depositoNitro;
				this.depositoNitro = 0;
			}
		}
		return velocidadReal;
	}
	

	//TODO - Metodos de toString, CompareTo,...
	
}
