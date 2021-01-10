package coches;

import circuitos.Circuito;
import enumerados.Combustible;
import enumerados.Velocidad;
import pilotos.Piloto;

/**
 * Clase modelo de un subtipo de Coche, un coche rapido
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CocheRapido extends CocheReal{
	//--Atributos--
	private double depositoNitro;
	
	//--Constructores--
	/**
	 * Constructor por defecto
	 */
	public CocheRapido() {
		super(); 
		this.depositoNitro = 80.0;
	}
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param velocidad_
	 * @param combustible_
	 */
	public CocheRapido(String nombre_, Velocidad velocidad_ , Combustible combustible_) {
		super(nombre_,velocidad_,combustible_);
		this.depositoNitro = 80.0; //Siempre va a ser 80L
	}
	
	//--Getters & Setters
	public double getDepositoNitro() {return this.depositoNitro;}
	public void setDepositoNitro(double depositoNitro_) { this.depositoNitro = depositoNitro_;}
	
	//--Metodos--
	/**
	 * Calcula la velocidad real de un coche para un piloto en un circuito
	 * @param piloto
	 * @param circuito
	 */
	@Override
	public double calcularVelocidadReal(Piloto piloto, Circuito circuito) {
		double velocidadReal = Math.round(((this.velocidad.getVelocidad() *  piloto.calcularDestreza()) / circuito.getComplejidadModificada())* 100d) / 100d;
		System.out.println("+++ Con estas condiciones es capaz de correr a " + velocidadReal + "km/hora +++");
		if(this.depositoNitro > 0.0) {
			double porcentaje = Math.round(((velocidadReal * 20 ) / 100)* 100d) / 100d;
			if(porcentaje <= this.depositoNitro) {
				velocidadReal = Math.round((velocidadReal + porcentaje)* 100d) / 100d;
				this.depositoNitro = Math.round((this.depositoNitro - porcentaje)* 100d) / 100d;
				System.out.println("+++ El "+ this.nombre +" usa " + porcentaje +" de nitro para alcanzar "+ velocidadReal + " km/hora y el nitro restante es " + this.depositoNitro + " +++");
			}else {
				velocidadReal = Math.round((velocidadReal + this.depositoNitro)* 100d) / 100d;
				System.out.println("+++ El "+ this.nombre +" usa " + this.depositoNitro +" de nitro para alcanzar "+ velocidadReal + " km/hora y el nitro restante es 0.0 +++");
				this.depositoNitro = 0;
			}
		}
		return Math.round((velocidadReal)* 100d) / 100d;
	}
	/**
	 * Metodo toString para mostrar la informacion de un coche
	 */
	@Override
	public String toString() {
		return "<coche: " + this.nombre + "> <tipo:CocheRapido> <vel_teó: " + this.velocidad.getNombre() + "(" + this.velocidad.getVelocidad() + 
				")> <comb: " + this.combustible.getNombre() + "(" + this.combustible.getCombustible() + ")(actual:" + this.combustibleRestante + ")>> <nitroPendiente: " + this.depositoNitro + ">";
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
		if(!(obj instanceof CocheRapido)) {
			return false; //Tienen diferentes tipos
		}
		CocheRapido other = (CocheRapido) obj;
		return super.equals(other) && this.depositoNitro == other.getDepositoNitro();
	}
	
}
