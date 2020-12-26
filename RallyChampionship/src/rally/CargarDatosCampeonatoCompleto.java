package rally;

import java.util.Collections;

import circuitos.Circuito;
import circuitos.CircuitoReal;
import comparators.DistanciaComparator;
import decorador.CircuitoFrio;
import decorador.CircuitoGravilla;
import decorador.CircuitoMojado;
import decorador.CircuitoNocturno;
import decorador.ComplejidadExtra;
import decorador.ComplejidadExtraImp;
import enumerados.Complejidad;
import enumerados.Distancia;
import escuderias.Escuderia;
import escuderias.EscuderiaReal;

public class CargarDatosCampeonatoCompleto {
	public CargarDatosCampeonatoCompleto(){
		System.out.println("*********************************************************************************************************");
		System.out.println("*****************ESTA SIMULACIÃ“N CONCLUYE NORMALMENTE COMPLETÃ�NDOSE TODAS LAS CARRERAS*******************");        
		System.out.println("*********************************************************************************************************\n");
		//organizador debe ser una instancia única con la siguiente configuración:
		//LimiteAbandonos=3, LimitePilotos=2, 		
		// Circuitos ordenados de forma descendente de acuerdo a su distancia
		Organizacion org = Organizacion.getInstance(3, 2, Collections.reverseOrder(new DistanciaComparator()));

		
		//creamos y añadimos los circuitos del campeonato:
		//Crear circuito portugal con nombre:”Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
		Circuito circuitoPortugal = new CircuitoReal("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA);
		//además, acciones necesarias para que portugal sea un circuito con:
		//Gravilla y Nocturno
		ComplejidadExtra compExtraPortugal = new ComplejidadExtraImp();
		ComplejidadExtra portugalGravilla = new CircuitoGravilla(compExtraPortugal);
		portugalGravilla.añadirComplejidadExtra(circuitoPortugal);
		ComplejidadExtra portugalNocturno = new CircuitoNocturno(portugalGravilla);
		portugalNocturno.añadirComplejidadExtra(circuitoPortugal);
		//añadir circuito portugal a circuitos de la organización
		org.añadirCircuito(circuitoPortugal);

		//Crear circuito cerdena con nombre:”Cerdeña" - complejidad:ALTA - distancia:CORTA);
		Circuito circuitoCerdeña = new CircuitoReal("Cerdeña", Complejidad.ALTA, Distancia.CORTA);
		//además, acciones necesarias para que cerdena sea un circuito con:
		//Gravilla y Mojado
		ComplejidadExtra compExtraCerdeña = new ComplejidadExtraImp();
		ComplejidadExtra cerdeñaGravilla = new CircuitoGravilla(compExtraCerdeña);
		cerdeñaGravilla.añadirComplejidadExtra(circuitoCerdeña);
		ComplejidadExtra cerdeñaMojado = new CircuitoGravilla(cerdeñaGravilla);
		cerdeñaMojado.añadirComplejidadExtra(circuitoCerdeña);	
		//añadir circuito cerdena a circuitos de la organización
		org.añadirCircuito(circuitoCerdeña);
			
		//Crear circuito australia con nombre:”Australia" - complejidad:BAJA - distancia:LARGA);
		Circuito circuitoAustralia = new CircuitoReal("Australia", Complejidad.BAJA, Distancia.LARGA);
		//además, acciones necesarias para que australia sea un circuito con:
		//Gravilla 
		ComplejidadExtra compExtraAustralia = new ComplejidadExtraImp();
		ComplejidadExtra australiaGravilla = new CircuitoGravilla(compExtraAustralia);
		australiaGravilla.añadirComplejidadExtra(circuitoAustralia);	
		//añadir circuito australia a circuitos de la organización
		org.añadirCircuito(circuitoAustralia);
		
		//Crear circuito corcega con nombre:”Córcega" - complejidad:MEDIA - distancia:INTERMEDIA);
		Circuito circuitoCorcega = new CircuitoReal("Corcega", Complejidad.MEDIA, Distancia.INTERMEDIA);		
		//además, acciones necesarias para que corcega sea un circuito con:
		//Nocturno y Gravilla
		ComplejidadExtra compExtraCorcega = new ComplejidadExtraImp();
		ComplejidadExtra corcegaNocturno = new CircuitoNocturno(compExtraCorcega);
		corcegaNocturno.añadirComplejidadExtra(circuitoCorcega);
		ComplejidadExtra corcegaGravilla = new CircuitoGravilla(corcegaNocturno);
		corcegaGravilla.añadirComplejidadExtra(circuitoCorcega);		
		//añadir circuito corcega a circuitos de la organización	
		org.añadirCircuito(circuitoCorcega);

		//Crear circuito finlandia con nombre:”Finlandia" - complejidad:ALTA - distancia:CORTA);
		Circuito circuitoFinlandia = new CircuitoReal("Finlandia", Complejidad.ALTA, Distancia.CORTA);	
		//además, acciones necesarias para que finlandia sea un circuito con:
		//Nocturno, Frío y Mojado
		ComplejidadExtra compExtraFinlandia = new ComplejidadExtraImp();
		ComplejidadExtra finlandiaNocturno = new CircuitoNocturno(compExtraFinlandia);
		finlandiaNocturno.añadirComplejidadExtra(circuitoFinlandia);
		ComplejidadExtra finlandiaFrio = new CircuitoFrio(finlandiaNocturno);
		finlandiaFrio.añadirComplejidadExtra(circuitoFinlandia);	
		ComplejidadExtra finlandiaMojado = new CircuitoMojado(finlandiaFrio);
		finlandiaMojado.añadirComplejidadExtra(circuitoFinlandia);		
		//añadir circuito finlandia a circuitos de la organización
		org.añadirCircuito(circuitoFinlandia);
		
		//Crear circuito alemania con nombre:”Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
		Circuito circuitoAlemania = new CircuitoReal("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA);
		//además, acciones necesarias para que alemania sea un circuito con:
		//Mojado
		ComplejidadExtra compExtraAlemania = new ComplejidadExtraImp();
		ComplejidadExtra alemaniaMojado = new CircuitoMojado(compExtraAlemania);
		alemaniaMojado.añadirComplejidadExtra(circuitoAlemania);
		//añadir circuito alemania a circuitos de la organización
		org.añadirCircuito(circuitoAlemania);
		
		//Crear circuito chile con nombre:”Chile" - complejidad:ALTA - distancia:CORTA);
		Circuito circuitoChile = new CircuitoReal("Chile", Complejidad.ALTA, Distancia.CORTA);
		//además, acciones necesarias para que chile sea un circuito con:
		//Gravilla
		ComplejidadExtra compExtraChile = new ComplejidadExtraImp();
		ComplejidadExtra chileGravilla = new CircuitoGravilla(compExtraChile);
		chileGravilla.añadirComplejidadExtra(circuitoChile);
		//añadir circuito chile a circuitos de la organización
		org.añadirCircuito(circuitoChile);
		
		//creamos e inscribimos a las escuderías que participarán en el campeonato:    
		//Crear escuderia peugeot con nombre:"Peugeot"
		Escuderia escuderiaPeugeot = new EscuderiaReal("Peugeot");
		
		//ordenaciónPilotos: ASCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaciónCoches: ASCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
		//peugeot se inscribe en campeonato

		//escudería citroen 
		//Crear escuderia citroen con nombre:"Citroen"		
		//ordenaciónPilotos: DESCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaciónCoches: DESCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
		//citroen se inscribe en campeonato

		//escudería seat       
		//Crear escuderia seat con nombre:"Seat"
		//ordenaciónPilotos: ASCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaciónCoches: ASCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
		//seat se inscribe en campeonato

		//creamos los pilotos y los coches de cada escudería 
		//coches y pilotos de citroen
		//añadir a citroen un CocheResistente(nombre:"Citröen C5" - velocidad:RAPIDA - combustible:ELEFANTE);
		//añadir a citroen un CocheRapido(nombre:"Citröen C4" - velocidad:RAPIDA - combustible:ESCASO);
		//añadir a citroen un Coche(nombre:"Citröen C3" - velocidad:RAPIDA - combustible:ESCASO);
		//añadir a citroen un PilotoExperimentado(nombre:"Loeb" - concentración: NORMAL));
		//añadir a citroen un PilotoEstrella(nombre:"Makinen" - concentración: ZEN));
		//añadir a citroen un PilotoNovato(nombre:"Auriol" - concentración: NORMAL));
			
		//coches y pilotos de seat
		//añadir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
		//añadir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
		//añadir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
		//añadir a seat un PilotoExperimentado(nombre:"Ogier" - concentración: NORMAL));
		//añadir a seat un PilotoEstrella(nombre:"McRae" - concentración: CONCENTRADO));
		//añadir a seat un PilotoNovato(nombre:"Blomquist" - concentración: DESPISTADO));
		 
		//coches y pilotos de peugeot
		//añadir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
		//añadir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
		//añadir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
		//añadir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentración: CONCENTRADO));
		//añadir a peugeot un PilotoEstrella(nombre:"Sainz" - concentración: ZEN ));
		//añadir a peugeot un PilotoNovato(nombre:"Sordo" - concentración: DESPISTADO));
	
	}
}
