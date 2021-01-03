package rally;

import cargaDatos.CargarDatosCampeonatoCompleto;
import circuitos.Circuito;
import circuitos.CircuitoReal;
import coches.Coche;
import coches.CocheRapido;
import coches.CocheReal;
import coches.CocheResistente;
import comparators.CochesStrategy1Comparator;
import comparators.PilotosStrategy1Comparator;
import decorador.CircuitoFrio;
import decorador.CircuitoGravilla;
import decorador.CircuitoMojado;
import decorador.CircuitoNocturno;
import enumerados.Combustible;
import enumerados.Complejidad;
import enumerados.Concentracion;
import enumerados.Distancia;
import enumerados.Velocidad;
import escuderias.Escuderia;
import escuderias.EscuderiaReal;
import pilotos.Piloto;
import pilotos.PilotoEstrella;
import pilotos.PilotoExperimentado;
import pilotos.PilotoNovato;
import strategy.Estrategia1;
import strategy.Estrategia2;
import strategy.IStrategy;

/**
 * Clase Main, sera el comienzo del proyecto y llamara a los metodos necesarios para su correcto funcionamiento
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Main {
	public static void main(String[] args) {	
		
		//Descomentar el conjunto de datos de los 3 siguientes que se quiera probar
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina de forma normal disputándose todas las carreras
		CargarDatosCampeonatoCompleto initdata = new CargarDatosCampeonatoCompleto();
		
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras con el único piloto superviviente y su escudería declarados como campeones
		//DatosCampeonatoFinPrematuro initdata = new DatosCampeonatoFinPrematuro();
		
		//Descomentar el siguiente conjunto de datos si se quiere probar simulación del campeonato que termina antes de que se realicen todas las carreras sin ningún piloto superviviente y declarándose el campeonato como desierto
		//DatosCampeonatoPremioDesierto initdata = new DatosCampeonatoPremioDesierto();        

        //llamada al método de Organización que gestiona el desarrollo del campeonato
		Organizacion.getInstanceWithoutParameter().simulacion();
		//->llamada al método de la instancia de Organización que gestiona el Campeonato();
	}

}
