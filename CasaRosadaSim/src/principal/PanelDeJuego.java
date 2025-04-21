package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import areas.Area;
import entidades.Entidad;
import minijuegos.GestorDeDecisiones;
import objetos.ObjetoInteractivo;

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
	public InicializadorDeRecursos inicializador = new InicializadorDeRecursos(this);
	Sonido musica = new Sonido();
	Sonido se = new Sonido();
	
	//AREAS
	public Area areas[] = new Area[6];
	public ObjetoInteractivo mobiliario[] = new ObjetoInteractivo[5];
	public ObjetoInteractivo contactos[] = new ObjetoInteractivo[6];
	public Entidad gabinete[] = new Entidad[6];
	
	//JUEGOS
	public GestorDeDecisiones gdd = new GestorDeDecisiones(this);
	
	//HILO DE JUEGO
	Thread hiloDeJuego;

	//ESTADO DE JUEGO
	public int estadoDeJuego;
	
	public final int MODO_TITULO = 0;
	public final int MODO_JUEGO = 1;
	public final int MODO_PAUSA = 2;
	public final int MODO_DIALOGO = 3;
	public final int MODO_OPCIONES = 4;
	
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
		inicializador.establecerAreas();
		inicializador.establecerObjetos();
		inicializador.establecerNPCs();
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
			
			case ZONA_NOTEBOOK -> areas[1].actualizar();
			case ZONA_TELEFONO -> areas[2].actualizar();
			case ZONA_MUÑECO -> areas[3].actualizar();
			case ZONA_CARPETAS -> areas[5].actualizar();
			case ZONA_LIBRO -> areas[4].actualizar();
			default -> areas[0].actualizar();
			
			}
		}
		if(estadoDeJuego == MODO_PAUSA) {
			
		}
		if(estadoDeJuego == MODO_DIALOGO) {
			gdd.actualizar();
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
		else if(estadoDeJuego == MODO_DIALOGO) {
			gdd.dibujar(g2);
			
			if(gdd.isMostrarOpciones()) {
				ui.dibujarPantallaDeOpciones(gdd.getPNJ() ,g2);
			}
		}
		else if(estadoDeJuego == MODO_JUEGO){
			
			areas[0].dibujar(g2);

			switch(zonaDeJuego) {
			
			case ZONA_NOTEBOOK -> areas[1].dibujar(g2);
			case ZONA_TELEFONO -> areas[2].dibujar(g2);
			case ZONA_MUÑECO -> areas[3].dibujar(g2);
			case ZONA_CARPETAS -> areas[5].dibujar(g2);
			case ZONA_LIBRO -> areas[4].dibujar(g2);
			default -> areas[0].dibujar(g2);
			
			}

		}
		
		ui.dibujar(g2);

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