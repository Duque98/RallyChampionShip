package coches;

import enumerados.Combustible;
import enumerados.Velocidad;

/**
 * Clase modelo de un subtipo de Coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CocheResistente extends CocheReal{
	//--Atributos--
	private int depositoExtra; //TODO - es probable que double
	
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
	public int getDepositoExtra() { return this.depositoExtra;}
	public void setDepositoExtra(int depositoExtra_) {this.depositoExtra = depositoExtra_;}
	
	//--Metodos--
	/*TODO - Reducir combustible (diferente al padre)
	 *  	 ademas se diferencia en si le queda deposito extra o no*/

	//TODO - Metodos de toString, CompareTo,...
}
