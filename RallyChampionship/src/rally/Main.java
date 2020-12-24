package rally;

import circuitos.Circuito;
import circuitos.CircuitoReal;
import decorador.CircuitoMojado;
import decorador.CircuitoNocturno;
import decorador.ComplejidadExtra;
import decorador.ComplejidadExtraImp;
import enumerados.Complejidad;
import enumerados.Distancia;

/**
 * Clase Main, sera el comienzo del proyecto y llamara a los metodos necesarios para su correcto funcionamiento
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Main {
	public static void main(String[] args) {
		Circuito portugal = new CircuitoReal("Portugal",Complejidad.MEDIA,Distancia.INTERMEDIA);
		System.out.println("El nombre es: " + portugal.getNombre());
		
		
		ComplejidadExtra compExtra = new ComplejidadExtraImp();
		
		ComplejidadExtra portugalMojado = new CircuitoMojado(compExtra);
		portugalMojado.a�adirComplejidadExtra(portugal);
		
		System.out.println("El nuevo nombre es: " + portugal.getNombre());
		
		ComplejidadExtra portugalNocturno = new CircuitoNocturno(portugalMojado);
		portugalNocturno.a�adirComplejidadExtra(portugal);
		
		System.out.println("El nuevo nombre es: " + portugal.getNombre());
		
		//Descomentar el conjunto de datos de los 3 siguientes que se quiera probar
		//Descomentar el siguiente conjunto de datos si se quiere probar simulaci�n del campeonato que termina de forma normal disput�ndose todas las carreras
		//DatosCampeonatoCompleto initdata = new DatosCampeonatoCompleto();
		//Descomentar el siguiente conjunto de datos si se quiere probar simulaci�n del campeonato que termina antes de que se realicen todas las carreras con el �nico piloto superviviente y su escuder�a declarados como campeones
		//DatosCampeonatoFinPrematuro initdata = new DatosCampeonatoFinPrematuro();
		//Descomentar el siguiente conjunto de datos si se quiere probar simulaci�n del campeonato que termina antes de que se realicen todas las carreras sin ning�n piloto superviviente y declar�ndose el campeonato como desierto
		//DatosCampeonatoPremioDesierto initdata = new DatosCampeonatoPremioDesierto();        

        //llamada al m�todo de Organizaci�n que gestiona el desarrollo del campeonato
		//->llamada al m�todo de la instancia de Organizaci�n que gestiona el Campeonato();
	}

}
