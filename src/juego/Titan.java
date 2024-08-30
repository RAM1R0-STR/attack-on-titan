package juego;
import entorno.Entorno;
import java.awt.*;

public class Titan {
	Image imagen;
	double x;
	double y;
	double r;
	double angTitan;
	double velTitan;
	
	public Titan (double x, double y, double r,double velTitan, Image imagen){ //Constructor del titan
		this.imagen=imagen;
		this.x= x;
		this.y=y;
		this.r = r;
		this.velTitan = velTitan;
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, angTitan+Math.PI/2,0.7);
	}

	public void movimientoX() {
		this.x += Math.cos(this.angTitan)*velTitan;
	}
	
	public void movimientoY() {
		this.y += Math.sin(this.angTitan)*velTitan;
	}
	
	public void colision_kickX(double alfa) {
		this.x += Math.cos(alfa)*-1;
	}
	
	public void colision_kickY(double alfa) {
		this.y += Math.sin(alfa)*-1;
	}
	
	public void rodear_obstaX() {		
		this.y += Math.sin(this.angTitan+Math.PI/2)*velTitan;
	}
	
	public void rodear_obstaY() {
		this.x += Math.cos(this.angTitan+Math.PI/2)*velTitan;
	}
}

		
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

