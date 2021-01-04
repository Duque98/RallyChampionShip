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
public class CocheResistente extends CocheReal{
	//--Atributos--
	private double depositoExtra; 
	
	//--Constructores--
	public CocheResistente() {
		super();
		this.depositoExtra = 100;
	}
	public CocheResistente(String nombre_, Velocidad velocidad_ , Combustible combustible_) {
		super(nombre_,velocidad_,combustible_);
		this.depositoExtra = 100;
	}
	
	//--Getters & Setters
	public double getDepositoExtra() { return this.depositoExtra;}
	public void setDepositoExtra(double depositoExtra_) {this.depositoExtra = depositoExtra_;}
	
	//--Metodos--
	@Override
	public void reducirCombustible(Piloto piloto, Circuito circuito) {
		if(this.depositoExtra > 0 && tiempoNecesarioFinalizar(piloto, circuito) > this.combustibleRestante) {
			this.combustibleRestante += this.depositoExtra;
			this.depositoExtra = 0;
		}else {
			this.combustibleRestante = this.combustibleRestante - tiempoNecesarioFinalizar(piloto, circuito);
		}
	}

	//TODO - Metodos de toString, CompareTo,...
	@Override
	public String toString() {
		return "<coche: " + this.nombre + "> <tipo: CocheResistente> <vel_teó: " + this.velocidad.getNombre() + "(" + this.velocidad.getVelocidad() + 
				")> <comb: " + this.combustible.getNombre() + "(" + this.combustible.getCombustible() + ")(actual:" + this.combustibleRestante + ")>> <reserva: " + this.depositoExtra + ">";
	}
}
