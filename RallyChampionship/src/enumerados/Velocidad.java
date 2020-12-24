package enumerados;

/**
 * Enum para representar la Velocidad de un coche
 * @author Jose Ignacio Duque Blazquez
 *
 */
public enum Velocidad {
	TORTUGA ("TORTUGA", 200.0),
	LENTA ("LENTA",210.0),
	NORMAL ("NORMAL", 220.0),
	RAPIDA ("RAPIDO", 230.0),
	GUEPARDO ("GUEPARDO", 240.0);
	
	private final String nombre;
	private final double velocidad;
	
	Velocidad(String nombre_, double value_) {
		this.nombre = nombre_;
		this.velocidad = value_; }
	
	public String getNombre() { return this.nombre; }
	public double getVelocidad() {return this.velocidad; }
	
	@Override
	public String toString() {
		return getNombre() + "(original: "+getVelocidad()+")";
	}
}
