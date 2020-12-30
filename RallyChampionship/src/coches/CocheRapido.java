package coches;

import enumerados.Combustible;
import enumerados.Velocidad;

/**
 * Clase modelo de un subtipo de Coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CocheRapido extends CocheReal{
	//--Atributos--
	private int depositoNitro;//TODO - es probable que double
	
	//--Constructores--
	public CocheRapido() {
		super(); 
		this.depositoNitro = 80;
	}
	public CocheRapido(String nombre_, Velocidad velocidad_ , Combustible combustible_) {
		super(nombre_,velocidad_,combustible_);
		this.depositoNitro = 80; //Siempre va a ser 80L
	}
	
	//--Getters & Setters
	public int getDepositoNitro() {return this.depositoNitro;}
	public void setDepositoNitro(int depositoNitro_) { this.depositoNitro = depositoNitro_;}
	
	//--Metodos--
	/*TODO - Calcular velocidad real (se hace de manera diferente que la padre) 
	 * 		 ademas se diferencia en si le queda nitro o no*/
	

	//TODO - Metodos de toString, CompareTo,...
	
}
