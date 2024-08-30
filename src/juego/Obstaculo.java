package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Obstaculo {
	Image imagen;
	double r;
	double x;
	double y;
	double escala;
	double angulo;

	public Obstaculo (double x, double y, double r, Image imagen, double escala,double angulo) { //Constructor de obstaculos
		this.r= r;
		this.x = x;
		this.y =y;
		this.imagen=imagen;
		this.escala=escala;
		this.angulo=angulo;
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, angulo, escala);
	}

}

		
	
