package circuitos;

import enumerados.Complejidad;
import enumerados.Distancia;

public interface Circuito {
	//--Getters & Setters
	public String getNombre();
	public void setNombre(String nombre);
	
	public Complejidad getComplejidad();
	public double getValorComplejidad();
	public void setComplejidad(Complejidad complejidad);
	
	public Distancia getDistancia();
	public int getValorDistancia();
	public void setDistancia(Distancia distancia);
	
	public double getComplejidadModificada();
	public void setComplejidadModificada(double complejidadModificada);
	
	public double getDistanciaModificada();
	public void setDistanciaModificada(double distanciaModificada);
}
