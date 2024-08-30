package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Mikasa {
	Image imagen;
	Image imagenINV;
	double x;
	double y;
	double r; 
	double angMikasa;
	int vida;
	boolean formaHumana;

	
	public Mikasa (double x, double y, double r){ //Constructor del personaje Mikasa
		//this.imagen= imagen;
		this.x= x;
		this.y=y;
		this.r = r;
		imagen = Herramientas.cargarImagen("mikasaArcher.png");
		imagenINV=Herramientas.cargarImagen("mikasaArcherINV.png");
		this.vida = 3;
		formaHumana=true;
	}
	
	public void dibujar(Entorno entorno) {
		
		if (formaHumana==true) {
			entorno.dibujarImagen(imagen, this.x, this.y, this.angMikasa-Math.PI/2-0.1, 0.2);
		}
		if (formaHumana==false) {
			entorno.dibujarImagen(imagenINV, this.x, this.y, this.angMikasa-Math.PI/2-0.1, 0.4);
	}
	}
	
	public void kyojina (int vida) {
		this.formaHumana=false;
		this.vida=vida;
		
	}
	public void humana() {
		this.formaHumana=true;
	}

	public void restarVida () {
		this.vida--;
	}

	public void girar(double modificador) 
	{
		this.angMikasa = this.angMikasa + modificador;
		if(this.angMikasa < 0) {
			this.angMikasa +=2*Math.PI;
		}
        if(this.angMikasa > 2*Math.PI) {
        	this.angMikasa -=2*Math.PI;
        }	
	}

	public void moverseAdelanteX(){
		this.x += Math.cos(this.angMikasa)*5;
		
		//LIMITACIONES DEL ENTORNO
		if(this.x >= 800-this.r)
			this.x=800-this.r;
		if(this.x <= 0+this.r)
			this.x=0+this.r;
		if(this.y >= 600-this.r)
			this.y=600-this.r;
		if(this.y <= 0+this.r)
			this.y=0+this.r;
	}
	public void moverseAdelanteY(){
		this.y += Math.sin(this.angMikasa)*+5;
		
		//LIMITACIONES DEL ENTORNO
		if(this.x >= 800-this.r)
			this.x=800-this.r;
		if(this.x <= 0+this.r)
			this.x=0+this.r;
		if(this.y >= 600-this.r)
			this.y=600-this.r;
		if(this.y <= 0+this.r)
			this.y=0+this.r;
	}

	public void moverseAbajoX(){
		this.x += Math.cos(this.angMikasa)*-5;
		//LIMITACIONES DEL ENTORNO
		if(this.x >= 800-this.r)
			this.x=800-this.r;
		if(this.x <= 0+this.r)
			this.x=0+this.r;
		if(this.y >= 600-this.r)
			this.y=600-this.r;
		if(this.y <= 0+this.r)
			this.y=0+this.r;
	}
	public void moverseAbajoY(){
		this.y += Math.sin(this.angMikasa)*-5;
		//LIMITACIONES DEL ENTORNO
		if(this.x >= 800-this.r)
			this.x=800-this.r;
		if(this.x <= 0+this.r)
			this.x=0+this.r;
		if(this.y >= 600-this.r)
			this.y=600-this.r;
		if(this.y <= 0+this.r)
			this.y=0+this.r;
	}

}

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

