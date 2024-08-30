package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import javax.sound.sampled.Clip;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	Image fondo;
	Mikasa mikasa;
	Arma arma;
	Titan [] titans;
	Obstaculo [] obsta;
	Pocion pocion;
	VidaExtra vidaextra;
	Clip sonido;
	Clip ganador;
	Clip perdedor;
	boolean juegoTerminado;
	Image fondoGanador;
	Image fondoPerdedor;
	Image campfire;
	Image rock;
	Image bush;
	Image statue;
	int puntaje;
	Image imgTitan; 
	Image imgTitan1;
	Image imgTitan2;
	Image imgTitan3;
	Image imgTitan4;

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 8", 800, 600);
		fondo = Herramientas.cargarImagen("fondoa.png");
		
		imgTitan1 = Herramientas.cargarImagen("titan1.png");
		imgTitan2 = Herramientas.cargarImagen("titan2.png");
		imgTitan3 = Herramientas.cargarImagen("titan3.png");
		imgTitan4 = Herramientas.cargarImagen("titan4.png");

		sonido= Herramientas.cargarSonido("POSION.WAV");
		ganador=Herramientas.cargarSonido("GANASTEE.wav");
		perdedor=Herramientas.cargarSonido("PERDISTE.wav");
		sonido= Herramientas.cargarSonido("OPENINGUNO.wav");
		
		juegoTerminado=false;
		
		fondoGanador = Herramientas.cargarImagen("victoriadefdef.jpg");
		fondoPerdedor= Herramientas.cargarImagen("perdedorfondodef.png");
		
		puntaje=0;

		campfire=Herramientas.cargarImagen("central.png");
		statue=Herramientas.cargarImagen("fuente.png");
		rock=Herramientas.cargarImagen("rock.png");
		bush=Herramientas.cargarImagen("bush.png");

		//CREADOR DE MIKASA
		this.mikasa= new Mikasa(600.0, 300.0, 30);
		
		//CREADOR DE TITANES
		titans = new Titan [4];

		//CREADOR DE OBSTACULOS
		obsta = new Obstaculo[5];
		obsta[0] = new Obstaculo(80.0, 550.0, 70.0, statue, 0.4,180);
		obsta[1] = new Obstaculo(400, 300, 60,campfire,0.5,0);
		obsta[2] = new Obstaculo(720, 60,70,statue,0.4,45);
		obsta[3] = new Obstaculo(670, 380, 50,bush,0.75,0);
		obsta[4] = new Obstaculo(120, 250, 50,rock,0.7,0);

		//CREADOR DE ARMA
		this.arma = null;
		
		//CREADOR DE POCION
		this.pocion=null;
		
		//CREADOR DE VIDAEXTRA
		this.vidaextra=null;

		//INICIO EL JUEGO
		this.entorno.iniciar(); // Inicia el juego!	
	}
		//CREADOR DE CRONOMETRO	
		int ticks;
		int milisegundos;
		int segundos;
		int minutos;
		


		//METODO COLISION CON OBSTACULO 
		public int colisionObstaculo(double x1, double y1, double r1){ 
			for(int i=0;i<obsta.length;i++){
				if (Math.sqrt((x1-obsta[i].x)*(x1-obsta[i].x)+(y1-obsta[i].y)*(y1-obsta[i].y))-r1-obsta[i].r <0){
				return i;
				}
			}
			return obsta.length+1;
		}

		//METODO COLISION CON TITANES
		public int colisionTitanes(double x1, double y1, double r1, int t){
			for (int i = 0; i<titans.length; i++){
				if(titans[i]!=null){
					if (Math.sqrt((x1-titans[i].x)*(x1-titans[i].x)+(y1-titans[i].y)*(y1-titans[i].y))-r1-titans[i].r<0 && i!=t){
						return i;
					}		
				}
			}
			return titans.length+1;
		}

		//METODO COLISION DISPARO CON TITANES
		public int headShot(double x1, double y1, double r1){
			for (int i = 0; i<titans.length; i++){
				if(titans[i]!=null){
					if (Math.sqrt((x1-titans[i].x)*(x1-titans[i].x)+(y1-titans[i].y)*(y1-titans[i].y))+r1-titans[i].r<0){
						return i;
					}		
				}
			}
			return titans.length+1;
		}

		//METODO COLISION MIKASA CON TITANES
		boolean absorcion(double x1, double y1, double r1){
			for (int i=0;i<titans.length;i++){
				if(titans[i]!=null){
					if (Math.sqrt((x1-titans[i].x)*(x1-titans[i].x)+(y1-titans[i].y)*(y1-titans[i].y))-titans[i].r<0){
						return true;
					}
				}
			}
			return false;
		}
	
		public boolean colision(double x1, double y1,double x2, double y2, double dist) { //METODO COLISION MIKASA CON POCION
			return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)< dist*dist;	
		}
		
		public boolean estaEnObstaculo(double x, double y, double r) {
			for(int i=0; i<obsta.length; i++){
				if(Math.abs(x-obsta[i].x) <= Math.abs(r+obsta[i].r) || Math.abs(y-obsta[i].y) <= Math.abs(r+obsta[i].r)){
					return true;
				}
			}			
			return false;
		}
		
		//CREADOR DE NUMEROS RANDOM
		public double generadorRandX(int num){
		double valorMin=100;
		double valorMax=200;
		double valorMin2 = 900;
		double valorMax2 = 1000;
			if(num%2==0){
				return Math.random()*(-valorMax + (-valorMin)); 
			} else{
				return Math.random()*(valorMax2 + valorMin2);
			}
		}	
	
		public double generadorRandY(int num){
		double valorMin=100;
		double valorMax=200;
		double valorMin2 = 700;
		double valorMax2 = 800;
			if(num%2==0){
				return Math.random()*(-valorMax + (-valorMin)); 
			} else {
				return Math.random()*(valorMax2 + valorMin2);
			}
		}

		public Image titanRandom(double imgRand){
			if(imgRand >= 2 && imgRand<3 ){
				return imgTitan2;
			} else if(imgRand >= 3 && imgRand<4){
				return imgTitan3;
			} else if(imgRand >= 4 && imgRand<=5){
				return imgTitan4;
			}
			return imgTitan1;
		}
	
		//METODO DE CRONOMETRO
		public void cronometro(){
			if (ticks%1000==0) {
				milisegundos++;
			}
			if (milisegundos%100==0) {	
				segundos++;
			}
			if(segundos==60){
				minutos++;
				segundos=0;
			}
		}


	
	 /*------------------------------------------------------------METODO TICK-------------------------------------------------------*/
	public void tick() {
		if(!juegoTerminado){
		sonido.start();
		cronometro();

		//CREADOR DE FONDO Y MIKASA
		entorno.dibujarImagen(fondo, 400, 300, 0, 1);
		mikasa.dibujar(entorno);


		//-----------------------------------COMIENZO BLOQUE TITANES-------------------------------------------------------------------------
		for(int i=0;i<titans.length;i++){
			double imgRand =Math.random()*5;
			int numRand =(int) (Math.random()*11-1);/*CREO NUMEROS RANDOMS */
			double randX = generadorRandX(numRand); /*QUE FUNCIONAN COMO EL PUNTO*/
			double randY = generadorRandY(numRand); /*EN DONDE VAN A APARECER LOS TITANES*/
			
			if(titans[i]==null && segundos%7==0){   /*CREACION DE TITANES*/
				titans[i] = new Titan(randX,randY,40.0,2, titanRandom(imgRand));
			}
			if(titans[i]!=null){ /*DIBUJADOR DE TITANES Y MOVIMIENTOS DEL TITAN*/
			titans[i].dibujar(entorno);
			titans[i].angTitan = Math.atan2((mikasa.y - titans[i].y),(mikasa.x - titans[i].x));
			
			if (mikasa.formaHumana==false) { //EFECTO DE POCION
				titans[i].angTitan = Math.atan2((titans[i].y - mikasa.y),(titans[i].x - mikasa.x));
				if (segundos%5==0) {
					mikasa.humana();
				}
			}

			//MOVIMIENTO EN X DEL TITAN
			int h = colisionObstaculo(titans[i].x+Math.cos(titans[i].angTitan)*2, titans[i].y, titans[i].r);
			if (h>obsta.length){
				int j = colisionTitanes(titans[i].x+Math.cos(titans[i].angTitan)*2, titans[i].y, titans[i].r, i);
				if(j>titans.length){
					titans[i].movimientoX();
				}
				else{
					double alfaT = Math.atan2((titans[j].y - titans[i].y),(titans[j].x - titans[i].x));
					titans[i].colision_kickX(alfaT);			
				}
			}
			else{
				double alfaO = Math.atan2((obsta[h].y - titans[i].y),(obsta[h].x - titans[i].x));
				titans[i].colision_kickX(alfaO);	
				titans[i].rodear_obstaX();
			}
			
		//MOVIMIENTO EN Y DEL TITAN
		int w = colisionObstaculo(titans[i].x, titans[i].y+Math.sin(titans[i].angTitan)*2, titans[i].r);
		if (w>obsta.length){
			int j = colisionTitanes(titans[i].x, titans[i].y+Math.sin(titans[i].angTitan)*2, titans[i].r, i);
			if(j>titans.length){
				titans[i].movimientoY();
			}
			else{ //Empujon entre titanes para que no se traben
				double alfaT = Math.atan2((titans[j].y - titans[i].y),(titans[j].x - titans[i].x));
				titans[i].colision_kickY(alfaT);
			}
		}
		else{ //Para rodear el obstaculo
			double alfaO = Math.atan2((obsta[w].y-titans[i].y),(obsta[w].x - titans[i].x));
			titans[i].colision_kickY(alfaO);
			titans[i].rodear_obstaY();
			}

		if (mikasa.formaHumana==false && colision(mikasa.x,mikasa.y, titans[i].x, titans[i].y, 60)) {
			mikasa.humana();
			titans[i]=null;
			puntaje+=20;
			}
		}
	}
	//-----------------------------------FIN BLOQUE TITANES-------------------------------------------------------------------------


	//-----------------------------------COMIENZO BLOQUE OBSTACULOS-------------------------------------------------------------------------
		for(int i=0;i<obsta.length;i++){
			obsta[i].dibujar(entorno);
		}		
	//-----------------------------------FIN BLOQUE OBSTACULOS-------------------------------------------------------------------------
	

	//-----------------------------------COMIENZO BLOQUE MIKASA-------------------------------------------------------------------------
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)){ //MOVIMIENTO DE MIKASA: GIRAR A LA DERECHA
			mikasa.girar(Herramientas.radianes(6));
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)){ //MOVIMIENTO DE MIKASA: GIRAR A LA IZQUIERDA
			mikasa.girar(Herramientas.radianes(-6));
		}
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)){ //MOVIMIENTO DE MIKASA: MOVERSE ADELANTE
			int wx = colisionObstaculo(mikasa.x+Math.cos(mikasa.angMikasa)*5, mikasa.y, mikasa.r);
			if (wx>obsta.length){
				mikasa.moverseAdelanteX();
			}
			else{
				double alfaO = Math.atan2((obsta[wx].y - mikasa.y),(obsta[wx].x - mikasa.x));
				mikasa.x += Math.cos(alfaO)*-1;
			}

			int wy = colisionObstaculo(mikasa.x,mikasa.y+Math.sin(mikasa.angMikasa)*5,mikasa.r );
			if (wy>obsta.length){
				mikasa.moverseAdelanteY();
			}
			else{
				double alfaO = Math.atan2((obsta[wy].y - mikasa.y),(obsta[wy].x - mikasa.x));
				mikasa.y += Math.sin(alfaO)*-1;
			}

		}

		if(entorno.estaPresionada(entorno.TECLA_ABAJO)){ //MOVIMIENTO DE MIKASA: MOVERSE ATRAS
			int wx = colisionObstaculo(mikasa.x+Math.cos(mikasa.angMikasa)*-5, mikasa.y, mikasa.r);
			if (wx>obsta.length){
				mikasa.moverseAbajoX();
			}
			else{
				double alfaO = Math.atan2((obsta[wx].y - mikasa.y),(obsta[wx].x - mikasa.x));
				mikasa.x += Math.cos(alfaO)*-1;
			}

			int wy = colisionObstaculo(mikasa.x,mikasa.y+Math.sin(mikasa.angMikasa)*-5,mikasa.r );
			if (wy>obsta.length){
				mikasa.moverseAbajoY();
			}
			else{
				double alfaO = Math.atan2((obsta[wy].y - mikasa.y),(obsta[wy].x - mikasa.x));
				mikasa.y += Math.sin(alfaO)*-1;
			}
		}

		if (absorcion(this.mikasa.x, this.mikasa.y, this.mikasa.r)){ //COLISION MIKASA CON TITAN
			System.out.println(mikasa.vida);
			int aux = 0;
			double mikasaX = Math.random()*800-0;
			double mikasaY = Math.random()*600-0;
			while (aux ==0){
				mikasaX = Math.random()*800-0;
				mikasaY = Math.random()*600-0;
				if (!estaEnObstaculo(mikasaX, mikasaY, mikasa.r)){
					aux =1;
				}
			}
								
			mikasa.restarVida();
			this.mikasa.x= mikasaX;
			this.mikasa.y = mikasaY;
		}
		//-----------------------------------FIN BLOQUE MIKASA-------------------------------------------------------------------------
		

		//-----------------------------------COMIENZO BLOQUE ARMA-------------------------------------------------------------------------
		if(entorno.estaPresionada(entorno.TECLA_ESPACIO)){ //CREACION DE ARMA
			if(arma==null) {
				this.arma = new Arma(mikasa.x, mikasa.y, 10, mikasa.angMikasa);
			}			
		}
		if(arma!=null) { //DIBUJO DE ARMA Y COLISION CON TITAN
			arma.moverAdelante();
			arma.dibujarArma(entorno);
			int k= headShot(arma.x, arma.y, arma.r); 
			if (k<titans.length){
				this.titans[k] = null;
				puntaje+=10;
			}

		if(colisionObstaculo(arma.x,arma.y,arma.r)<obsta.length || arma.chocasteEntorno(entorno)==true || k<titans.length) //COLISION CON OBSTACULO
			arma =null;
		}
		//-----------------------------------FIN BLOQUE ARMA-------------------------------------------------------------------------


		//-----------------------------------COMIENZO BLOQUE POCION-------------------------------------------------------------------------
		if(pocion==null && segundos%10==0) {
			int aux = 0;
			double potaR = 20;
			double potaX = Math.random()*800-0;
			double potaY = Math.random()*600-0;
			while (aux ==0){
				potaX = Math.random()*800-0;
				potaY = Math.random()*600-0;
				if (!estaEnObstaculo(potaX, potaY, potaR)){
					aux =1;
				}
		}
		this.pocion= new Pocion(potaX,potaY,potaR,5) ;
	}
		
		if (pocion!=null ) {
				pocion.dibujar(entorno);
				pocion.angulo+=0.01;			
			if (colision(mikasa.x, mikasa.y,pocion.x,pocion.y,30)) {	
				pocion=null;
				mikasa.kyojina(mikasa.vida);
			}
		}
		// -----------------------------------FIN BLOQUE POCION-------------------------------------------------------------------------
		
		 
		//-----------------------------------COMIENZO BLOQUE VIDA EXTRA-----------------------------------------------------------------
		if (vidaextra==null && segundos%10==0) {
			int aux = 0;
			double vidaR = 1;
			double vidaX = Math.random()*800-0;
			double vidaY = Math.random()*600-0;
			while (aux ==0){
				vidaX = Math.random()*800-0;
				vidaY = Math.random()*600-0;
				if (!estaEnObstaculo(vidaX, vidaY, vidaR)){
					aux =1;
				}
		}
		this.vidaextra= new VidaExtra(vidaX,vidaY,vidaR,5) ;
			if(colision(mikasa.x,mikasa.y,vidaextra.x,vidaextra.y,30)) {
				vidaextra.tomoVidaExtra();				
		}}
	
		if(vidaextra!=null) {
			vidaextra.dibujar(entorno);
			if (colision(mikasa.x,mikasa.y,vidaextra.x,vidaextra.y,30)) {
				vidaextra=null;
				mikasa.vida++;	
			}			
		}
		
		//------------------------------------FIN DE BLOQUE VIDA EXTRA---------------------------------------------------------
		
		//CREADOR DE TEXTO TIEMPO
		entorno.cambiarFont("Aerial", 35, Color.black);
		entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 6, 32);
		entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 8, 32);
		entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 7, 31);
		entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 7, 33);
		entorno.cambiarFont("Aerial", 35, Color.red);
		entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 7, 32);
		
		//CREADOR DE TEXTO VIDAS
		entorno.cambiarFont("Aerial", 35, Color.black);
		entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 11, 590);
		entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 9, 590);
		entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 10, 591);
		entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 10, 589);
		entorno.cambiarFont("Aerial", 35, Color.red);
		entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 10, 590);

		//CREADOR DE TEXTO PUNTAJE
		entorno.cambiarFont("Aerial", 35, Color.black);
		entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 599, 590);
		entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 601, 590);
		entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 600, 591);
		entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 600, 589);
		entorno.cambiarFont("Aerial", 35, Color.red);
		entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 600, 590);
		
		//CORROBORO SI TERMINO EL JUEGO
		if(mikasa.vida<1 || puntaje==100) {
			juegoTerminado=true;
			sonido.stop();
			ganador.start();
			
		}
	//}
		} else { //CORROBORO SI GANE O PERDI
			if(mikasa.vida==0){	//SI PERDI			
				entorno.dibujarImagen(fondoPerdedor, entorno.ancho()/2,entorno.alto()/2 , 0, 0.6);
				sonido.stop();
				perdedor.start();
				ganador.stop();
				// -----------------------------------TEXTO PERDISTE-------------------------------------------------------------------------
				entorno.cambiarFont("Aerial", 30, Color.white);
				entorno.escribirTexto("Resumen de la partida:", 125, 135);
				entorno.cambiarFont("Aerial", 27, Color.white);
				entorno.escribirTexto("P e r d i s t e !", 140, 180);
				entorno.cambiarFont("Aerial", 25, Color.white);
				entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 140, 222);
				entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 140, 262);
				entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 140, 300);

			} else { //SI GANE
				entorno.dibujarImagen(fondoGanador, entorno.ancho()/2,entorno.alto()/2 , 0, 0.60);
				//-----------------------------------TEXTO GANASTE-------------------------------------------------------------------------
	
				entorno.cambiarFont("Aerial", 30, Color.white);
				entorno.escribirTexto("Resumen de la partida:", 80, 135);
				entorno.cambiarFont("Aerial", 27, Color.white);
				entorno.escribirTexto("G a n a s t e !", 90, 185);
				entorno.cambiarFont("Aerial", 25, Color.white);
				entorno.escribirTexto("Puntaje: " + String.valueOf(puntaje), 90, 230);
				entorno.escribirTexto("Vidas: " + String.valueOf(mikasa.vida), 90, 260);
				entorno.escribirTexto("Tiempo: "+ String.valueOf(minutos) + ":" + String.valueOf(segundos), 90, 290);
						
			}	
		}
	}	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
