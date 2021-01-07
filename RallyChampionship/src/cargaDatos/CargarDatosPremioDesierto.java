package cargaDatos;

import java.util.Collections;

import circuitos.Circuito;
import circuitos.CircuitoReal;
import coches.Coche;
import coches.CocheRapido;
import coches.CocheReal;
import coches.CocheResistente;
import comparators.ComplejidadComparator;
import comparators.DistanciaComparator;
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
import rally.Organizacion;
import strategy.Estrategia1;
import strategy.Estrategia2;
import strategy.Estrategia3;
import strategy.IStrategy;
/**
 * Carga los datos para una simulacion que concluye antes de finalizar el campeonato con todos los pilotos descalificados
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CargarDatosPremioDesierto {
	
	public CargarDatosPremioDesierto() {		
		System.out.println("******************************************************************************************************");
		System.out.println("****ESTA SIMULACIÓN CONCLUYE ANTES DE FINALIZAR EL CAMPEONATO CON TODOS LOS PILOTOS DESCALIFICADOS****");
		System.out.println("******************************************************************************************************");
		System.out.println("");
		//organizador debe ser una instancia única con la siguiente configuración:
		//LimiteAbandonos=1, LimitePilotos=3, 
		// Circuitos ordenados de forma descendente de acuerdo a su distancia
		Organizacion org = Organizacion.getInstance(1, 3, Collections.reverseOrder(new DistanciaComparator()));
		
		//creamos y añadimos los circuitos del campeonato:
		//Crear circuito portugal con nombre:”Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
		//además, acciones necesarias para que portugal sea un circuito con:
		//Gravilla y Nocturno
		//añadir circuito portugal a circuitos de la organización
		Circuito circuitoPortugal = new CircuitoReal("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA);
		circuitoPortugal = new CircuitoGravilla(circuitoPortugal);
		circuitoPortugal = new CircuitoNocturno(circuitoPortugal);
		org.añadirCircuito(circuitoPortugal);
		
		//Crear circuito cerdena con nombre:”Cerdeña" - complejidad:ALTA - distancia:CORTA);
		//además, acciones necesarias para que cerdena sea un circuito con:
		//Gravilla y Mojado
		//añadir circuito cerdena a circuitos de la organización
		Circuito circuitoCerdeña = new CircuitoReal("Cerdeña", Complejidad.ALTA, Distancia.CORTA);
		circuitoCerdeña = new CircuitoGravilla(circuitoCerdeña);
		circuitoCerdeña = new CircuitoMojado(circuitoCerdeña);
		org.añadirCircuito(circuitoCerdeña);
		
		//Crear circuito australia con nombre:”Australia" - complejidad:BAJA - distancia:LARGA);
		//además, acciones necesarias para que australia sea un circuito con:
		//Gravilla 
		//añadir circuito australia a circuitos de la organización
		Circuito circuitoAustralia = new CircuitoReal("Australia", Complejidad.BAJA, Distancia.LARGA);
		circuitoAustralia = new CircuitoGravilla(circuitoAustralia);
		org.añadirCircuito(circuitoAustralia);
		
		//Crear circuito corcega con nombre:”Córcega" - complejidad:MEDIA - distancia:INTERMEDIA);
		//además, acciones necesarias para que corcega sea un circuito con:
		//Nocturno y Gravilla
		//añadir circuito corcega a circuitos de la organización		
		Circuito circuitoCorcega = new CircuitoReal("Corcega", Complejidad.MEDIA, Distancia.INTERMEDIA);	
		circuitoCorcega = new CircuitoNocturno(circuitoCorcega);
		circuitoCorcega = new CircuitoGravilla(circuitoCorcega);
		org.añadirCircuito(circuitoCorcega);
		
		//Crear circuito finlandia con nombre:”Finlandia" - complejidad:ALTA - distancia:CORTA);
		//además, acciones necesarias para que finlandia sea un circuito con:
		//Nocturno, Frío y Mojado
		//añadir circuito finlandia a circuitos de la organización
		Circuito circuitoFinlandia = new CircuitoReal("Finlandia", Complejidad.ALTA, Distancia.CORTA);	
		circuitoFinlandia = new CircuitoNocturno(circuitoFinlandia);
		circuitoFinlandia = new CircuitoFrio(circuitoFinlandia);
		circuitoFinlandia = new CircuitoMojado(circuitoFinlandia);
		org.añadirCircuito(circuitoFinlandia);
		
		//Crear circuito alemania con nombre:”Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
		//además, acciones necesarias para que alemania sea un circuito con:
		//Mojado
		//añadir circuito alemania a circuitos de la organización
		Circuito circuitoAlemania = new CircuitoReal("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA);
		circuitoAlemania = new CircuitoMojado(circuitoAlemania);
		org.añadirCircuito(circuitoAlemania);
		
		//Crear circuito chile con nombre:”Chile" - complejidad:ALTA - distancia:CORTA);
		//además, acciones necesarias para que chile sea un circuito con:
		//Gravilla
		//añadir circuito chile a circuitos de la organización
		Circuito circuitoChile = new CircuitoReal("Chile", Complejidad.ALTA, Distancia.CORTA);
		circuitoChile = new CircuitoGravilla(circuitoChile);
		org.añadirCircuito(circuitoChile);
		
		//creamos e inscribimos a las escuderías que participarán en el campeonato:    
		IStrategy est1 = new Estrategia1();
		IStrategy est2 = new Estrategia2();
		IStrategy est3 = new Estrategia3();
		
		//Crear escuderia peugeot con nombre:"Peugeot"
		//ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
		//peugeot se inscribe en campeonato
		Escuderia escuderiaPeugeot = new EscuderiaReal("PEUGEOT",est3);
		
		//escudería citroen 
		//Crear escuderia citroen con nombre:"Citroen"		
		//ordenaciónPilotos: ascendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
		//citroen se inscribe en campeonato
		Escuderia escuderiaCitroen = new EscuderiaReal("CITROEN",est1);
		
		//escudería seat       
		//Crear escuderia seat con nombre:"Seat"
		//ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
		//seat se inscribe en campeonato
		Escuderia escuderiaSeat = new EscuderiaReal("SEAT",est3);
		
		//creamos los pilotos y los coches de cada escudería 
		//coches y pilotos de citroen
		//añadir a citroen un CocheResistente(nombre:"Citröen C5" - velocidad:RAPIDA - combustible:ELEFANTE);
		//añadir a citroen un CocheRapido(nombre:"Citröen C4" - velocidad:RAPIDA - combustible:ESCASO);
		//añadir a citroen un Coche(nombre:"Citröen C3" - velocidad:RAPIDA - combustible:ESCASO);
		Coche citroenC5 = new CocheResistente("Citröen C5", Velocidad.RAPIDA, Combustible.ELEFANTE);
		Coche citroenC4 = new CocheRapido("Citröen C4", Velocidad.RAPIDA, Combustible.ESCASO);
		Coche citroenC3 = new CocheReal("Citröen C3", Velocidad.RAPIDA, Combustible.ESCASO);
		escuderiaCitroen.añadirCoche(citroenC5);
		escuderiaCitroen.añadirCoche(citroenC4);
		escuderiaCitroen.añadirCoche(citroenC3);
		//añadir a citroen un PilotoExperimentado(nombre:"Loeb" - concentración: NORMAL));
		//añadir a citroen un PilotoEstrella(nombre:"Makinen" - concentración: ZEN));
		//añadir a citroen un PilotoNovato(nombre:"Auriol" - concentración: NORMAL));
		Piloto loeb = new PilotoExperimentado("Loeb", Concentracion.NORMAL);
		Piloto makinen = new PilotoEstrella("Makinen", Concentracion.ZEN);
		Piloto auriol = new PilotoNovato("Auriol", Concentracion.NORMAL);
		escuderiaCitroen.añadirPiloto(loeb);
		escuderiaCitroen.añadirPiloto(makinen);
		escuderiaCitroen.añadirPiloto(auriol);
		
		escuderiaCitroen.ordenar();
		escuderiaCitroen.inscribirseAlCampeonato();
		
		//coches y pilotos de seat
		//añadir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
		//añadir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
		//añadir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
		Coche tarraco = new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO);
		Coche ateca = new CocheRapido("Seat Ateca", Velocidad.GUEPARDO, Combustible.GENEROSO);
		Coche arona = new CocheReal("Seat Arona", Velocidad.RAPIDA, Combustible.ESCASO);
		escuderiaSeat.añadirCoche(tarraco);
		escuderiaSeat.añadirCoche(ateca);
		escuderiaSeat.añadirCoche(arona);
		//añadir a seat un PilotoExperimentado(nombre:"Ogier" - concentración: NORMAL));
		//añadir a seat un PilotoEstrella(nombre:"McRae" - concentración: CONCENTRADO));
		//añadir a seat un PilotoNovato(nombre:"Blomquist" - concentración: DESPISTADO));
		Piloto ogier = new PilotoExperimentado("Ogier", Concentracion.NORMAL);
		Piloto mcRae = new PilotoEstrella("McRae",Concentracion.CONCENTRADO);
		Piloto blomquist = new PilotoNovato("Blomquist",Concentracion.DESPISTADO);
		escuderiaSeat.añadirPiloto(ogier);
		escuderiaSeat.añadirPiloto(mcRae);
		escuderiaSeat.añadirPiloto(blomquist);
		
		escuderiaSeat.ordenar();
		escuderiaSeat.inscribirseAlCampeonato();
		
		//coches y pilotos de peugeot
		//añadir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
		//añadir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
		//añadir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
		Coche peugeot5008 = new CocheResistente("Peugeot 5008", Velocidad.LENTA, Combustible.GENEROSO);
		Coche peugeot3008 = new CocheRapido("Peugeot 3008", Velocidad.GUEPARDO, Combustible.NORMAL);
		Coche peugeot2008 = new CocheReal("Peugeot 2008", Velocidad.NORMAL, Combustible.ESCASO);
		escuderiaPeugeot.añadirCoche(peugeot5008);
		escuderiaPeugeot.añadirCoche(peugeot3008);
		escuderiaPeugeot.añadirCoche(peugeot2008);
		//añadir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentración: CONCENTRADO));
		//añadir a peugeot un PilotoEstrella(nombre:"Sainz" - concentración: ZEN ));
		//añadir a peugeot un PilotoNovato(nombre:"Sordo" - concentración: DESPISTADO));
		Piloto kankunnen = new PilotoExperimentado("Kankunnen",Concentracion.CONCENTRADO);
		Piloto sainz = new PilotoEstrella("Sainz",Concentracion.ZEN);
		Piloto sordo = new PilotoNovato("Sordo",Concentracion.DESPISTADO);
		escuderiaPeugeot.añadirPiloto(kankunnen);
		escuderiaPeugeot.añadirPiloto(sainz);
		escuderiaPeugeot.añadirPiloto(sordo);
		
		escuderiaPeugeot.ordenar();
		escuderiaPeugeot.inscribirseAlCampeonato();
	}
}
