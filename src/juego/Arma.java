package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Arma {
    double x;
    double y;
    double r;
    double angulo;
    Image imagen;
 
    public Arma (double x, double y, double r, double angulo){
        this.x=x;
        this.y=y;
        this.r=r;
        this.angulo=angulo;
        this.imagen=Herramientas.cargarImagen("flechaV2.png");
    }

    public void dibujarArma(Entorno entorno){
        entorno.dibujarImagen(imagen, x, y, angulo, 0.10);
    }

    public void moverAdelante() {
		this.x += Math.cos(this.angulo)*10;
		this.y += Math.sin(this.angulo)*10;
		/*if(this.x > 900) {
			this.x=-100;
		}
		if(this.x < -100) {
			this.x=900;
		}
		if(this.y > 650) {
			this.y=-50;
		}
		if(this.y < -50) {
			this.y=650;
		}*/
	
	}
    
    public boolean chocasteEntorno (Entorno entorno){
        if(x + this.r /2 < 0 || x + this.r/2 > entorno.ancho() ){
            return true;
        }
        if(y + this.r /2 < 0 || y + this.r/2 > entorno.ancho()) {
        	return true;
        }
           
        return false;
    }
    



}