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
		System.out.println("****ESTA SIMULACI�N CONCLUYE ANTES DE FINALIZAR EL CAMPEONATO CON TODOS LOS PILOTOS DESCALIFICADOS****");
		System.out.println("******************************************************************************************************");
		System.out.println("");
		//organizador debe ser una instancia �nica con la siguiente configuraci�n:
		//LimiteAbandonos=1, LimitePilotos=3, 
		// Circuitos ordenados de forma descendente de acuerdo a su distancia
		Organizacion org = Organizacion.getInstance(1, 3, Collections.reverseOrder(new DistanciaComparator()));
		
		//creamos y a�adimos los circuitos del campeonato:
		//Crear circuito portugal con nombre:�Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
		//adem�s, acciones necesarias para que portugal sea un circuito con:
		//Gravilla y Nocturno
		//a�adir circuito portugal a circuitos de la organizaci�n
		Circuito circuitoPortugal = new CircuitoReal("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA);
		circuitoPortugal = new CircuitoGravilla(circuitoPortugal);
		circuitoPortugal = new CircuitoNocturno(circuitoPortugal);
		org.a�adirCircuito(circuitoPortugal);
		
		//Crear circuito cerdena con nombre:�Cerde�a" - complejidad:ALTA - distancia:CORTA);
		//adem�s, acciones necesarias para que cerdena sea un circuito con:
		//Gravilla y Mojado
		//a�adir circuito cerdena a circuitos de la organizaci�n
		Circuito circuitoCerde�a = new CircuitoReal("Cerde�a", Complejidad.ALTA, Distancia.CORTA);
		circuitoCerde�a = new CircuitoGravilla(circuitoCerde�a);
		circuitoCerde�a = new CircuitoMojado(circuitoCerde�a);
		org.a�adirCircuito(circuitoCerde�a);
		
		//Crear circuito australia con nombre:�Australia" - complejidad:BAJA - distancia:LARGA);
		//adem�s, acciones necesarias para que australia sea un circuito con:
		//Gravilla 
		//a�adir circuito australia a circuitos de la organizaci�n
		Circuito circuitoAustralia = new CircuitoReal("Australia", Complejidad.BAJA, Distancia.LARGA);
		circuitoAustralia = new CircuitoGravilla(circuitoAustralia);
		org.a�adirCircuito(circuitoAustralia);
		
		//Crear circuito corcega con nombre:�C�rcega" - complejidad:MEDIA - distancia:INTERMEDIA);
		//adem�s, acciones necesarias para que corcega sea un circuito con:
		//Nocturno y Gravilla
		//a�adir circuito corcega a circuitos de la organizaci�n		
		Circuito circuitoCorcega = new CircuitoReal("Corcega", Complejidad.MEDIA, Distancia.INTERMEDIA);	
		circuitoCorcega = new CircuitoNocturno(circuitoCorcega);
		circuitoCorcega = new CircuitoGravilla(circuitoCorcega);
		org.a�adirCircuito(circuitoCorcega);
		
		//Crear circuito finlandia con nombre:�Finlandia" - complejidad:ALTA - distancia:CORTA);
		//adem�s, acciones necesarias para que finlandia sea un circuito con:
		//Nocturno, Fr�o y Mojado
		//a�adir circuito finlandia a circuitos de la organizaci�n
		Circuito circuitoFinlandia = new CircuitoReal("Finlandia", Complejidad.ALTA, Distancia.CORTA);	
		circuitoFinlandia = new CircuitoNocturno(circuitoFinlandia);
		circuitoFinlandia = new CircuitoFrio(circuitoFinlandia);
		circuitoFinlandia = new CircuitoMojado(circuitoFinlandia);
		org.a�adirCircuito(circuitoFinlandia);
		
		//Crear circuito alemania con nombre:�Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
		//adem�s, acciones necesarias para que alemania sea un circuito con:
		//Mojado
		//a�adir circuito alemania a circuitos de la organizaci�n
		Circuito circuitoAlemania = new CircuitoReal("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA);
		circuitoAlemania = new CircuitoMojado(circuitoAlemania);
		org.a�adirCircuito(circuitoAlemania);
		
		//Crear circuito chile con nombre:�Chile" - complejidad:ALTA - distancia:CORTA);
		//adem�s, acciones necesarias para que chile sea un circuito con:
		//Gravilla
		//a�adir circuito chile a circuitos de la organizaci�n
		Circuito circuitoChile = new CircuitoReal("Chile", Complejidad.ALTA, Distancia.CORTA);
		circuitoChile = new CircuitoGravilla(circuitoChile);
		org.a�adirCircuito(circuitoChile);
		
		//creamos e inscribimos a las escuder�as que participar�n en el campeonato:    
		IStrategy est1 = new Estrategia1();
		IStrategy est2 = new Estrategia2();
		IStrategy est3 = new Estrategia3();
		
		//Crear escuderia peugeot con nombre:"Peugeot"
		//ordenaci�nPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaci�nCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
		//peugeot se inscribe en campeonato
		Escuderia escuderiaPeugeot = new EscuderiaReal("PEUGEOT",est3);
		
		//escuder�a citroen 
		//Crear escuderia citroen con nombre:"Citroen"		
		//ordenaci�nPilotos: ascendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaci�nCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
		//citroen se inscribe en campeonato
		Escuderia escuderiaCitroen = new EscuderiaReal("CITROEN",est1);
		
		//escuder�a seat       
		//Crear escuderia seat con nombre:"Seat"
		//ordenaci�nPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
		//ordenaci�nCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
		//seat se inscribe en campeonato
		Escuderia escuderiaSeat = new EscuderiaReal("SEAT",est3);
		
		//creamos los pilotos y los coches de cada escuder�a 
		//coches y pilotos de citroen
		//a�adir a citroen un CocheResistente(nombre:"Citr�en C5" - velocidad:RAPIDA - combustible:ELEFANTE);
		//a�adir a citroen un CocheRapido(nombre:"Citr�en C4" - velocidad:RAPIDA - combustible:ESCASO);
		//a�adir a citroen un Coche(nombre:"Citr�en C3" - velocidad:RAPIDA - combustible:ESCASO);
		Coche citroenC5 = new CocheResistente("Citr�en C5", Velocidad.RAPIDA, Combustible.ELEFANTE);
		Coche citroenC4 = new CocheRapido("Citr�en C4", Velocidad.RAPIDA, Combustible.ESCASO);
		Coche citroenC3 = new CocheReal("Citr�en C3", Velocidad.RAPIDA, Combustible.ESCASO);
		escuderiaCitroen.a�adirCoche(citroenC5);
		escuderiaCitroen.a�adirCoche(citroenC4);
		escuderiaCitroen.a�adirCoche(citroenC3);
		//a�adir a citroen un PilotoExperimentado(nombre:"Loeb" - concentraci�n: NORMAL));
		//a�adir a citroen un PilotoEstrella(nombre:"Makinen" - concentraci�n: ZEN));
		//a�adir a citroen un PilotoNovato(nombre:"Auriol" - concentraci�n: NORMAL));
		Piloto loeb = new PilotoExperimentado("Loeb", Concentracion.NORMAL);
		Piloto makinen = new PilotoEstrella("Makinen", Concentracion.ZEN);
		Piloto auriol = new PilotoNovato("Auriol", Concentracion.NORMAL);
		escuderiaCitroen.a�adirPiloto(loeb);
		escuderiaCitroen.a�adirPiloto(makinen);
		escuderiaCitroen.a�adirPiloto(auriol);
		
		escuderiaCitroen.ordenar();
		escuderiaCitroen.inscribirseAlCampeonato();
		
		//coches y pilotos de seat
		//a�adir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
		//a�adir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
		//a�adir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
		Coche tarraco = new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO);
		Coche ateca = new CocheRapido("Seat Ateca", Velocidad.GUEPARDO, Combustible.GENEROSO);
		Coche arona = new CocheReal("Seat Arona", Velocidad.RAPIDA, Combustible.ESCASO);
		escuderiaSeat.a�adirCoche(tarraco);
		escuderiaSeat.a�adirCoche(ateca);
		escuderiaSeat.a�adirCoche(arona);
		//a�adir a seat un PilotoExperimentado(nombre:"Ogier" - concentraci�n: NORMAL));
		//a�adir a seat un PilotoEstrella(nombre:"McRae" - concentraci�n: CONCENTRADO));
		//a�adir a seat un PilotoNovato(nombre:"Blomquist" - concentraci�n: DESPISTADO));
		Piloto ogier = new PilotoExperimentado("Ogier", Concentracion.NORMAL);
		Piloto mcRae = new PilotoEstrella("McRae",Concentracion.CONCENTRADO);
		Piloto blomquist = new PilotoNovato("Blomquist",Concentracion.DESPISTADO);
		escuderiaSeat.a�adirPiloto(ogier);
		escuderiaSeat.a�adirPiloto(mcRae);
		escuderiaSeat.a�adirPiloto(blomquist);
		
		escuderiaSeat.ordenar();
		escuderiaSeat.inscribirseAlCampeonato();
		
		//coches y pilotos de peugeot
		//a�adir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
		//a�adir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
		//a�adir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
		Coche peugeot5008 = new CocheResistente("Peugeot 5008", Velocidad.LENTA, Combustible.GENEROSO);
		Coche peugeot3008 = new CocheRapido("Peugeot 3008", Velocidad.GUEPARDO, Combustible.NORMAL);
		Coche peugeot2008 = new CocheReal("Peugeot 2008", Velocidad.NORMAL, Combustible.ESCASO);
		escuderiaPeugeot.a�adirCoche(peugeot5008);
		escuderiaPeugeot.a�adirCoche(peugeot3008);
		escuderiaPeugeot.a�adirCoche(peugeot2008);
		//a�adir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentraci�n: CONCENTRADO));
		//a�adir a peugeot un PilotoEstrella(nombre:"Sainz" - concentraci�n: ZEN ));
		//a�adir a peugeot un PilotoNovato(nombre:"Sordo" - concentraci�n: DESPISTADO));
		Piloto kankunnen = new PilotoExperimentado("Kankunnen",Concentracion.CONCENTRADO);
		Piloto sainz = new PilotoEstrella("Sainz",Concentracion.ZEN);
		Piloto sordo = new PilotoNovato("Sordo",Concentracion.DESPISTADO);
		escuderiaPeugeot.a�adirPiloto(kankunnen);
		escuderiaPeugeot.a�adirPiloto(sainz);
		escuderiaPeugeot.a�adirPiloto(sordo);
		
		escuderiaPeugeot.ordenar();
		escuderiaPeugeot.inscribirseAlCampeonato();
	}
}
