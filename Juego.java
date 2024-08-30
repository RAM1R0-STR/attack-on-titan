package juego;

import java.awt.Color;
import java.awt.Image;



import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Image fondo;
	Image logo;
	Mikasa mikasa;
//	double anguloFondo;
	
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 3 - v1", 800, 600);
		fondo = Herramientas.cargarImagen("OIP.jpg");
		logo= Herramientas.cargarImagen("aot2.jpg");
//		anguloFondo=0;
		this.mikasa= new Mikasa(400.0, 300.0, 40.0, 80.0);
		
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		//entorno.dibujarRectangulo(500, 400, 100, 50, 0.0, Color.CYAN);
		//entorno.dibujarRectangulo(500, 400, 100, 50, 0.0, Color.DARK_GRAY);
		entorno.dibujarImagen(fondo, 400, 300, 0, 1.8);
		mikasa.dibujar(entorno);
		//entorno.dibujarRectangulo(500, 400, 100, 50, 0.0, Color.DARK_GRAY);
		//entorno.dibujarRectangulo(400, 300, 50, 110, 0, Color.red);
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			mikasa.moverseArriba();
		}
		if(entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			mikasa.moverseAbajo();
		}
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			mikasa.moverseDerecha();
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			mikasa.moverseIzquierda();
		}
		
			
		}
		//anguloFondo +=0.02;
		//entorno.dibujarImagen(fondo, 400, 300, anguloFondo, 0.5);
		
		
		

	
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
