package entidades;

import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class Entidad {
	
	PanelDeJuego pdj;
	public String[] dialogos = new String[10];
	public int dialogoIndice = 0;
	
	public Entidad(PanelDeJuego pdj) {
		this.pdj = pdj;
		dialogos[0] = "Señor presidente! desea que hagamos otro\n"
				    + "pedido al FMI? Tambien si gusta podemos\n"
				    + "realizar algun recorte! Si me pregunta consi\n"
				    + "-dero que la luz esta muy barata :D";
		dialogos[1] = "Y si se siente estresado le recomiendo sin\n"
				    + "-ceramente que se tome una vacaciones!";
		dialogos[2] = "Por favor digame que es lo que tiene en men\n"
			        + "-te! ¿O acaso refiere que sea yo quien eli\n"
			        + "-ja como debetiamos proceder? si es asi, no\n"
			        + " hay problema! confie en mi presi-kun!";
	}
	
	public void actualizar() {
		
	}
	
	public void dibujar(Graphics2D g2) {}
	
	public void hablar(int indice) {
		if(dialogos[dialogoIndice] == null) {
			dialogoIndice = 0; 
		}
		
		pdj.ui.dialogoActual = dialogos[dialogoIndice];
				
	}

}
