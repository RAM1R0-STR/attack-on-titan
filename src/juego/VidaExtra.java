package juego;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

	public class VidaExtra {
		double x;
		double y;
		double radio;
		double angulo;
		boolean conseguida;
		Image imagen;
	
	public VidaExtra (double x, double y, double radio, double angulo) {
		this.x=x;
		this.y=y;
		this.radio=radio;
		this.angulo=angulo;
		this.conseguida=false;
		imagen= Herramientas.cargarImagen("corazon.png");
	}
	
	public void dibujar (Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, angulo, 0.1);
		
	}
	
	public void tomoVidaExtra() {
		this.conseguida=true;
	}
	
	

}
