package enumerados;


/**
 * Enum para representar el Combustible de un coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public enum Combustible {
	ESCASO ("ESCASO", 350.0),
	NORMAL ("NORMAL", 440.0),
	GENEROSO ("GENEROSO", 460.0),
	ELEFANTE ("ELEFANTE", 480.0);
	
	private final String nombre;
	private final double combustible;
	
	Combustible (String nombre_, double value_) {
		this.nombre = nombre_;
		this.combustible = value_; }
	
	public String getNombre() { return this.nombre; }
	public double getCombustible() { return this.combustible;}
	
	@Override
	public String toString() {
		return getNombre() + "(original: "+getCombustible()+")";
	}
}
