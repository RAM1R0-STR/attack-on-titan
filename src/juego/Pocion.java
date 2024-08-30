package juego;

import entorno.Herramientas;
import entorno.Entorno;
import java.awt.*;

public class Pocion {
	double x;
	double y;
	double radio;
	Image imagen;
	double angulo;	

	public Pocion (double x, double y, double radio, double angulo) {
		this.x= x;
		this.y= y;
		this.radio= radio;
		this.angulo= angulo;	
		this.imagen= Herramientas.cargarImagen("posion.png");
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, angulo,0.1);
	}

}