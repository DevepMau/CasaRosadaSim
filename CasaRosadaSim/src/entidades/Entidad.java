package entidades;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import objetos.Opcion;
import principal.PanelDeJuego;

public class Entidad {
	
	PanelDeJuego pdj;
	private int dialogoIndice = 0;
	private int opcionesIndice = 0;
	private int direccion = 1;
	private int tiempoMov = 40;
	private int imageMov = 0;
	private int afecto = 0;
	private boolean hayOpciones = false;
	private String nombre;
	private String[] mensaje;
	private HashMap<Integer, Opcion[]> opciones;
	private BufferedImage cabeza;
	private BufferedImage cuerpo;
	
	public final String FIN_DE_DIALOGO = "Fin de dialogo...";
	
	public Entidad(PanelDeJuego pdj) {
		this.pdj = pdj;
		
		cargarMensajes();
		cargarOpciones();
		
	}
	
	public void actualizar() {
		
		if (tiempoMov > 0) {
		    if (tiempoMov % 5 == 0) {
		        imageMov += direccion;
		    }
		    tiempoMov--;
		} else {
		    tiempoMov = 40;
		    direccion *= -1;
		}
		
		////////////////////////////////////////////////////////////////////
		
		hablar(dialogoIndice);
		
		if(hayOpciones()) {
			for(Opcion opcion : getOpciones().get(0)) {
				opcion.actualizar(pdj.raton.posX, pdj.raton.posY);
			}
			
			if(pdj.raton.CLICK && pdj.botonOn) {
				
	 			if(getOpciones().get(0)[0].isColision()) {

	 				mensaje[dialogoIndice] = getOpciones().get(0)[0].getRespuesta();
	 				dialogoIndice--;
	 				mostrarOpciones(false);
	 				
	 			}
	 			else if(getOpciones().get(0)[1].isColision()) {
	 				
	 				mensaje[dialogoIndice] = getOpciones().get(0)[1].getRespuesta();
	 				dialogoIndice--;
	 				mostrarOpciones(false);

	 			}
	 			else if(getOpciones().get(0)[2].isColision()) {
	 				
	 				mensaje[dialogoIndice] = getOpciones().get(0)[2].getRespuesta();
	 				dialogoIndice--;
	 				mostrarOpciones(false);

	 			}
	 		}
		}	
	}
	
	public void dibujar(Graphics2D g2) {
		
		g2.drawImage(getCuerpo(), 250, 50 + imageMov, null);
		g2.drawImage(getCabeza(), 250, 50 + imageMov*2, null);
		
		if(hayOpciones) {
			g2.setColor(pdj.ui.negroTransparente);
	 		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
	 		
	 		g2.setColor(pdj.ui.blancoLinea);
	 		g2.setFont(pdj.ui.getMaruMonica());
	 		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
	 		
	 		for(Opcion opciones : getOpciones().get(0)) {
	 			opciones.dibujar(g2);
	 		}
		}
	}
	
	public void hablar(int indice) {
		if(obtenerMensaje(dialogoIndice) == null) {
			dialogoIndice = 0; 
		}
		
		if(!obtenerMensaje(dialogoIndice).isEmpty()) {
			pdj.ui.dialogoActual = obtenerMensaje(dialogoIndice);
		}
		
				
	}
	
	public void setConjuntosDeOpciones(int cantDeConj) {
	    HashMap<Integer, Opcion[]> nuevasOpciones = new HashMap<>();

	    for (int i = 0; i < cantDeConj; i++) {
	        Opcion[] grupo = new Opcion[3];

	        for (int j = 0; j < grupo.length; j++) {
	            grupo[j] = new Opcion(pdj.img.opcion);
	            grupo[j].setearPosicionObjeto(175, 100 + j * 100);
	        }

	        nuevasOpciones.put(i, grupo);
	    }

	    this.setOpciones(nuevasOpciones);
	}
	
	public void habilitarOpciones() {
		if(!this.hayOpciones) {
			pdj.resetDelay();
		}
		this.hayOpciones = true;
	}
	
	public void siguienteDialogoIndice() {
		dialogoIndice++;
		if(mensaje[dialogoIndice] == null) {
			dialogoIndice = 0;
		}
	}
	
	public void setImagenes(BufferedImage cuerpo, BufferedImage cabeza) {
		setCuerpo(cuerpo);
		setCabeza(cabeza);
	}
	
	public void cargarMensajes() {}
	
	public void cargarOpciones() {}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void resetConversacion() {
		this.dialogoIndice = 0;
	}
	
	public int getDialogoIndice() {
		return dialogoIndice;
	}
	
	public int siguienteConversacionIndice() {
		return dialogoIndice = dialogoIndice + 2;
	}

	public int obtenerOpcionesIndice(int indice) {
		return opcionesIndice;
	}

	public boolean hayOpciones() {
		return hayOpciones;
	}

	public void mostrarOpciones(boolean hayOpciones) {
		this.hayOpciones = hayOpciones;
	}

	public String obtenerMensaje(int indice) {
		return mensaje[indice];
	}

	public void setMensajes(String[] mensaje) {
		this.mensaje = mensaje;
	}
	
	public void configurarMensajeByIndice(int indice, String mensaje) {
		this.mensaje[indice] = mensaje;
	}

	public HashMap<Integer, Opcion[]> getOpciones() {
		return opciones;
	}

	public void setOpciones(HashMap<Integer, Opcion[]> opciones) {
		this.opciones = opciones;
	}

	public BufferedImage getCabeza() {
		return cabeza;
	}

	public void setCabeza(BufferedImage cabeza) {
		this.cabeza = cabeza;
	}

	public BufferedImage getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(BufferedImage cuerpo) {
		this.cuerpo = cuerpo;
	}

	public int obtenerAfecto() {
		return afecto;
	}

	public void modifiarAfecto(int valor) {
		
		int suma = this.afecto + valor;
		
		if(suma < 0) {
			this.afecto = 0;
		}
		else if(suma > 100) {
			this.afecto = 100;
		}
		else {
			this.afecto = suma;
		}
	}


}
