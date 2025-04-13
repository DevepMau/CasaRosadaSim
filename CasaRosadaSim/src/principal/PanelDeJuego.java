package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import areas.AREA_Carpetas;
import areas.AREA_Libro;
import areas.AREA_Muñeco;
import areas.AREA_Notebook;
import areas.AREA_Oficina;
import areas.AREA_Telefono;

public class PanelDeJuego extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	// CONFIGURACIÓN DE PANTALLA
	final int tamañoOriginalDeBaldosa = 16;
	final int escala = 3;

	public final int tamañoDeBaldosa = tamañoOriginalDeBaldosa * escala;
	public final int maxColDePantalla = 16;
	public final int maxFilaDePantalla = 12;
	public final int anchoDePantalla = tamañoDeBaldosa * maxColDePantalla;
	public final int altoDePantalla = tamañoDeBaldosa * maxFilaDePantalla;
	
	//CONFIGURACION DEL MUNDO
	public final int maxColDeMundo = 16;
	public final int maxFilaDeMundo = 12;
	public final int anchoMundo = tamañoDeBaldosa * maxColDeMundo;
	public final int altoMundo = tamañoDeBaldosa * maxFilaDeMundo;

	//ESTADO DE LA NACION
	Datos data = new Datos();
	
	//SISTEMA
	public Teclado teclado = new Teclado(this);
	public UI ui = new UI(this);
	public Imagenes img = new Imagenes();
	public Raton raton = new Raton(this);
	Sonido musica = new Sonido();
	Sonido se = new Sonido();
	
	//AREAS
	AREA_Oficina areaOficina = new AREA_Oficina(this);
	AREA_Notebook areaNotebook = new AREA_Notebook(this);
	AREA_Telefono areaTelefono = new AREA_Telefono(this);
	AREA_Muñeco areaMuñeco = new AREA_Muñeco(this);
	AREA_Libro areaLibro = new AREA_Libro(this);
	AREA_Carpetas areaCarpetas = new AREA_Carpetas(this);
	
	//HILO DE JUEGO
	Thread hiloDeJuego;

	//ESTADO DE JUEGO
	public int estadoDeJuego;
	
	public final int MODO_TITULO = 0;
	public final int MODO_JUEGO = 1;
	public final int MODO_PAUSA = 2;
	public final int MODO_DIALOGO = 3;
	public final int MODO_COMBATE = 4;
	
	//ZONA DE JUEGO
	public int zonaDeJuego;
	
	public final int ZONA_OFICINA = 0;
	public final int ZONA_NOTEBOOK = 1;
	public final int ZONA_TELEFONO = 2;
	public final int ZONA_MUÑECO = 3;
	public final int ZONA_CARPETAS = 4;
	public final int ZONA_LIBRO = 5;
	
	
	// FPS
	int FPS = 60;

	public PanelDeJuego() {

		this.setPreferredSize(new Dimension(anchoDePantalla, altoDePantalla));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(teclado);
		this.setFocusable(true);
		this.addMouseListener(raton);
	    this.addMouseMotionListener(raton);

	}
	
	public void configuracionDeJuego() {
		estadoDeJuego = MODO_JUEGO;
		zonaDeJuego = ZONA_OFICINA;
	}

	public void iniciarHiloDeJuego() {
		hiloDeJuego = new Thread(this);
		hiloDeJuego.start();

	}
	
	public void reproducirMusica(int i) {

		musica.cargarArchivo(i);
		musica.reproducir();
		musica.repetir();

	}

	public void detenerMusica() {

		musica.detener();

	}

	public void ReproducirSE(int i) {

		se.cargarArchivo(i);
		se.reproducir();

	}

	@Override
	public void run() {

		double intervaloDeDibujo = 1000000000 / FPS;
		double delta = 0;
		long ultimoTiempo = System.nanoTime();
		long tiempoActual;

		while(hiloDeJuego != null) {

			tiempoActual = System.nanoTime();
			delta += (tiempoActual - ultimoTiempo) / intervaloDeDibujo;
			ultimoTiempo = tiempoActual;

			if(delta >= 1) {
				actualizar();
				repaint();
				delta--;
			}
		}

	}

	public void actualizar() {

		if(estadoDeJuego == MODO_JUEGO) {
			
			switch(zonaDeJuego) {
			
			case ZONA_NOTEBOOK -> areaNotebook.actualizar();
			case ZONA_TELEFONO -> areaTelefono.actualizar();
			case ZONA_MUÑECO -> areaMuñeco.actualizar();
			case ZONA_CARPETAS -> areaCarpetas.actualizar();
			case ZONA_LIBRO -> areaLibro.actualizar();
			default -> areaOficina.actualizar();
			
			}
		}
		if(estadoDeJuego == MODO_PAUSA) {
			
		}
		if(estadoDeJuego == MODO_COMBATE) {
			
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		//DEBUG
		long drawStart = 0;
		if(teclado.comprobarTiempoDeDibujado == true) {
			drawStart = System.nanoTime();
		}
		//PANTALLA DE TITULO
		if(estadoDeJuego == MODO_TITULO) {
		}
		//OTROS
		else {
			
			areaOficina.dibujar(g2);

			switch(zonaDeJuego) {
			
			case ZONA_NOTEBOOK -> areaNotebook.dibujar(g2);
			case ZONA_TELEFONO -> areaTelefono.dibujar(g2);
			case ZONA_MUÑECO -> areaMuñeco.dibujar(g2);
			case ZONA_CARPETAS -> areaCarpetas.dibujar(g2);
			case ZONA_LIBRO -> areaLibro.dibujar(g2);
			default -> areaOficina.dibujar(g2);
			
			}
			
			//UI
			ui.dibujar(g2);
			//ui.dibujarPantallaDeJuego();
		}

		//DEBUG
		if(teclado.comprobarTiempoDeDibujado == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
		}

		g2.dispose();

	}

}