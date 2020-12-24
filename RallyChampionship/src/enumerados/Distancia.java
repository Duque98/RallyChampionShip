package enumerados;

/**
 * Enum para representar la Distancia de un circuito
 * @author Jose Ignacio Duque Blazquez
 *
 */
public enum Distancia {
	CORTA ("CORTA",250),
	INTERMEDIA ("INTERMEDIA",275),
	LARGA ("LARGA",300);
	
	private final String nombre;
	private final int distancia;
	
	Distancia(String nombre_, int value_) {
		this.nombre=nombre_; 
		this.distancia = value_;
	}
	
	public int getDistancia() {return this.distancia;}
	public String getNombre() {return this.nombre;}
	
	@Override
	public String toString() {
		return getNombre() + "(original: "+getDistancia()+")";
	}
}
