package entidades;

import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class PNJ_Toto extends Entidad {

	public PNJ_Toto(PanelDeJuego pdj) {
		
		super(pdj);
		this.setNombre("Toto-chan");
		this.setImagenes(pdj.img.toto_cuerpo, pdj.img.toto_cabeza);
	}
	
	public void actualizar() {
		
		super.actualizar();
	}
	
	public void dibujar(Graphics2D g2) {
		
		super.dibujar(g2);
	}
	
	/////////////////////////////////////////////////////
	
	public void cargarMensajes(
			) {
		
		this.setMensajes(new String[10]);
		
		this.configurarMensajeByIndice(0, "Señor presidente! desea que hagamos otro pedido al FMI?\n"
			                            + "Tambien si gusta podemos realizar algun recorte! Si me\n"
			                            + "pregunta considero que la luz esta muy barata :D");
		this.configurarMensajeByIndice(1, "Por favor digame que es lo que tiene en mente! ¿O acaso\n"
			                            + "refiere que sea yo quien elija como debetiamos proceder?\n"
			                            + "si es asi, no hay problema! confie en mi presi-kun! AH! \n"
			                            + "Lo siento! quiero decir... Señor Presidente!");
		this.configurarMensajeByIndice(2, "");
		this.configurarMensajeByIndice(3, "Hasta la proxima, señor presidente!");
		this.configurarMensajeByIndice(4, FIN_DE_DIALOGO);
		this.configurarMensajeByIndice(5, "nueva conversacion");
		this.configurarMensajeByIndice(6, "fin de nueva conversacion");
		this.configurarMensajeByIndice(7, FIN_DE_DIALOGO);
		
	}
	
	public void cargarOpciones() {
		
		setConjuntosDeOpciones(1);
		getOpciones().get(0)[0].setearOpcion("Mensaje de prueba 1", "Respuesta numero 1");
		getOpciones().get(0)[1].setearOpcion("Mensaje de prueba 2", "Respuesta numero 2");
		getOpciones().get(0)[2].setearOpcion("Mensaje de prueba 3", "Respuesta numero 3");
	}

}
