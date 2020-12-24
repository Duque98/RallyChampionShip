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
		portugalMojado.añadirComplejidadExtra(portugal);
		
		System.out.println("El nuevo nombre es: " + portugal.getNombre());
		
		ComplejidadExtra portugalNocturno = new CircuitoNocturno(portugalMojado);
		portugalNocturno.añadirComplejidadExtra(portugal);
		
		System.out.println("El nuevo nombre es: " + portugal.getNombre());
		
		//Descomentar el conjunto de datos de los 3 siguientes que se quiera probar
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina de forma normal disputándose todas las carreras
		//DatosCampeonatoCompleto initdata = new DatosCampeonatoCompleto();
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras con el único piloto superviviente y su escudería declarados como campeones
		//DatosCampeonatoFinPrematuro initdata = new DatosCampeonatoFinPrematuro();
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras sin ningún piloto superviviente y declarándose el campeonato como desierto
		//DatosCampeonatoPremioDesierto initdata = new DatosCampeonatoPremioDesierto();        

        //llamada al método de Organización que gestiona el desarrollo del campeonato
		//->llamada al método de la instancia de Organización que gestiona el Campeonato();
	}

}
