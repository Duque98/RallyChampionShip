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
	/**
	 * Constructor por defecto
	 */
	public CocheResistente() {
		super();
		this.depositoExtra = 100;
	}
	/**
	 * Constructor parametrizado
	 * @param nombre_
	 * @param velocidad_
	 * @param combustible_
	 */
	public CocheResistente(String nombre_, Velocidad velocidad_ , Combustible combustible_) {
		super(nombre_,velocidad_,combustible_);
		this.depositoExtra = 100;
	}
	
	//--Getters & Setters
	public double getDepositoExtra() { return this.depositoExtra;}
	public void setDepositoExtra(double depositoExtra_) {this.depositoExtra = depositoExtra_;}
	
	//--Metodos--
	/**
	 * Reduce el combustible restante 
	 *  - En caso de que tenga deposito extra y el tiempo sea mayor que el combustible actual, hace uso del deposito extra 
	 * @param tiempo
	 */
	@Override
	public void reducirCombustible(double tiempo) {
		if(this.depositoExtra > 0 && tiempo > this.combustibleRestante) {
			System.out.println("+++ El " + this.nombre + " tiene que recurrir al depósito de reserva para poder correr +++");
			this.combustibleRestante += this.depositoExtra;
			this.depositoExtra = 0;
		}else {
			this.combustibleRestante = Math.round((this.combustibleRestante - tiempo)* 100d) / 100d;
		}
	}

	/**
	 * Metodo toString para mostrar la informacion de un coche
	 */
	@Override
	public String toString() {
		return "<coche: " + this.nombre + "> <tipo: CocheResistente> <vel_teó: " + this.velocidad.getNombre() + "(" + this.velocidad.getVelocidad() + 
				")> <comb: " + this.combustible.getNombre() + "(" + this.combustible.getCombustible() + ")(actual:" + this.combustibleRestante + ")>> <reserva: " + this.depositoExtra + ">";
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
		if(!(obj instanceof CocheResistente)) {
			return false; //Tienen diferentes tipos
		}
		CocheResistente other = (CocheResistente) obj;
		return super.equals(other) && this.depositoExtra == other.getDepositoExtra();
	}
}
