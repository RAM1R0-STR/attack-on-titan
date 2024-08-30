package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {
	double x;
	double y;
	double ancho;
	double alto;
	Image imagen;
	Image imagen1;
	Image imagen2;
	Image imagen3;
	Image imagen4;
	Image imagen5;
	public Mikasa (double x, double y, double ancho, double alto){ //Constructor del personaje Mikasa
		//this.imagen= imagen;
		this.x= x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		imagen=Herramientas.cargarImagen("nenaprueba.png");
		imagen1=Herramientas.cargarImagen("nenaprueba7.png");
		imagen2=Herramientas.cargarImagen("nenaprueba2.png");
		imagen3=Herramientas.cargarImagen("nenaprueba4.png");
		imagen4=Herramientas.cargarImagen("nenaprueba1.png");
		imagen5=Herramientas.cargarImagen("nenaprueba5.png");

		
	}
	
	public void dibujar(Entorno entorno) {
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			entorno.dibujarImagen(imagen1, this.x, this.y, 0, 2);
		}else {
		      if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			entorno.dibujarImagen(imagen4, this.x, this.y, 0,2);
		      }else {
		    	  if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
		        entorno.dibujarImagen(imagen2, this.x, this.y, 0, 2);
		    	  }else {
		    		  if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {    	  
		    		   entorno.dibujarImagen(imagen5, this.x, this.y, 0, 2);
		    		  }else {
		    			  entorno.dibujarImagen(imagen, this.x, this.y, 0, 2);
		    		  }
		    	  }
		      }
		}
		
	}
	
	
	public void moverseDerecha(){
		this.x+=5;
		if(this.x >= 750) {
			this.x=750;
		}
	}
	
	public void moverseIzquierda(){
		this.x=this.x-5;
		if(this.x <= 50) {
			this.x=50;
		}
	}
	
	public void moverseArriba(){
		this.y=this.y-5;
		if(this.y <= 50) {
			this.y=50;
		}
	}
	
	public void moverseAbajo(){
		this.y=this.y+5;
		if(this.y >= 550) {
			this.y=550;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

