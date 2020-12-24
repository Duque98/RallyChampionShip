package enumerados;

/**
 * Enum para representar la Concentracion de un piloto
 * @author Jose Ignacio Duque Blazquez
 *
 */
public enum Concentracion {
	DESPISTADO ("DESPISTADO", 90.0),
	NORMAL ("NORMAL", 100.0),
	CONCENTRADO ("CONCENTRADO", 110.0),
	ZEN ("ZEN", 120.0);
	
	private final String nombre;
	private final double concentracion;
	
	Concentracion(String nombre_, double value_) {
		this.nombre = nombre_;
		this.concentracion = value_;}
	
	public String getNombre() { return this.nombre;}
	public double getConcentracion() {return this.concentracion;}
	
	@Override
	public String toString() {
		return getNombre() + "(original: "+getConcentracion()+")";
	}
}
