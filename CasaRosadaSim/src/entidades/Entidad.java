package entidades;

import java.awt.Font;
import java.awt.Graphics2D;
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
	private boolean hayOpciones = false;
	private String nombre = "Toto-chan";
	private String[] mensaje = new String[10];
	public HashMap<Integer, Opcion[]> opciones = new HashMap<>();
	
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
			for(Opcion opcion : opciones.get(0)) {
				opcion.actualizar(pdj.raton.posX, pdj.raton.posY);
			}
			
			if(pdj.raton.CLICK && pdj.botonOn) {
				
	 			if(opciones.get(0)[0].isColision()) {

	 				mensaje[dialogoIndice] = opciones.get(0)[0].getRespuesta();
	 				dialogoIndice--;
	 				mostrarOpciones(false);
	 				
	 			}
	 			else if(opciones.get(0)[1].isColision()) {
	 				
	 				mensaje[dialogoIndice] = opciones.get(0)[1].getRespuesta();
	 				dialogoIndice--;
	 				mostrarOpciones(false);

	 			}
	 			else if(opciones.get(0)[2].isColision()) {
	 				
	 				mensaje[dialogoIndice] = opciones.get(0)[2].getRespuesta();
	 				dialogoIndice--;
	 				mostrarOpciones(false);

	 			}
	 		}
		}	
	}
	
	public void dibujar(Graphics2D g2) {
		
		g2.drawImage(pdj.img.toto_cuerpo, 250, 50 + imageMov, null);
		g2.drawImage(pdj.img.toto_cabeza, 250, 50 + imageMov*2, null);
		
		if(hayOpciones) {
			g2.setColor(pdj.ui.negroTransparente);
	 		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
	 		
	 		g2.setColor(pdj.ui.blancoLinea);
	 		g2.setFont(pdj.ui.getMaruMonica());
	 		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
	 		
	 		for(Opcion opciones : opciones.get(0)) {
	 			opciones.dibujar(g2);
	 		}
		}
	}
	
	public void hablar(int indice) {
		if(getMensaje(dialogoIndice) == null) {
			dialogoIndice = 0; 
		}
		
		if(!getMensaje(dialogoIndice).isEmpty()) {
			pdj.ui.dialogoActual = getMensaje(dialogoIndice);
		}
		
				
	}
	
	private void cargarMensajes() {
		mensaje[0] = "Señor presidente! desea que hagamos otro pedido al FMI?\n"
			    + "Tambien si gusta podemos realizar algun recorte! Si me\n"
			    + "pregunta considero que la luz esta muy barata :D";
		mensaje[1] = "Por favor digame que es lo que tiene en mente! ¿O acaso\n"
			    + "refiere que sea yo quien elija como debetiamos proceder?\n"
			    + "si es asi, no hay problema! confie en mi presi-kun! AH! \n"
			    + "Lo siento! quiero decir... Señor Presidente!";
		mensaje[2] = "";
		mensaje[3] = "Hasta la proxima, señor presidente!";
		mensaje[4] = FIN_DE_DIALOGO;
		mensaje[5] = "nueva conversacion";
		mensaje[6] = "fin de nueva conversacion";
		mensaje[7] = FIN_DE_DIALOGO;
		
	}
	
	private void cargarOpciones() {
		opciones.put(0, new Opcion[3]);
		opciones.get(0)[0] = new Opcion(pdj.img.opcion);
		opciones.get(0)[1] = new Opcion(pdj.img.opcion);
		opciones.get(0)[2] = new Opcion(pdj.img.opcion);
		opciones.get(0)[0].setearPosicionObjeto(175, 100);
		opciones.get(0)[1].setearPosicionObjeto(175, 200);
		opciones.get(0)[2].setearPosicionObjeto(175, 300);
		opciones.get(0)[0].setRespuesta("Respuesta numero 1");
		opciones.get(0)[1].setRespuesta("Respuesta numero 2");
		opciones.get(0)[2].setRespuesta("Respuesta numero 3");
		opciones.get(0)[0].setMensaje("Mensaje de prueba 1");
		opciones.get(0)[1].setMensaje("Mensaje de prueba 2");
		opciones.get(0)[2].setMensaje("Mensaje de prueba 3");
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

	public String getMensaje(int indice) {
		return mensaje[indice];
	}

	public void setMensaje(String[] mensaje) {
		this.mensaje = mensaje;
	}


}
