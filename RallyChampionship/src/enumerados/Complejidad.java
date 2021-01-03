package enumerados;

/**
 * Enum para representar la Complejidad de un circuito
 * @author Jose Ignacio Duque Blazquez
 *
 */
public enum Complejidad {
	BAJA ("BAJA", 1.0),
	MEDIA ("MEDIA", 1.25),
	ALTA ("ALTA", 1.5);
	private final String nombre;
	private final double complejidad;
	
	Complejidad(String nombre_, double value_) {
		this.nombre = nombre_;
		this.complejidad = value_;
	}
	
	public String getNombre() { return this.nombre;}
	public double getComplejidad() {return this.complejidad;}
	
}
