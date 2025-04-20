package entidades;

import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class Entidad {
	
	PanelDeJuego pdj;
	public String[] dialogos = new String[10];
	public int dialogoIndice = 0;
	private int direccion = 1;
	private int tiempoMov = 40;
	private int imageMov = 0;
	private String nombre = "Toto";
	
	public Entidad(PanelDeJuego pdj) {
		this.pdj = pdj;
		dialogos[0] = "Señor presidente! desea que hagamos otro pedido al FMI?\n"
				    + "Tambien si gusta podemos realizar algun recorte! Si me\n"
				    + "pregunta considero que la luz esta muy barata :D";
		dialogos[1] = "Y si se siente estresado le recomiendo sinceramente que\n"
				    + "se tome una vacaciones!";
		dialogos[2] = "Por favor digame que es lo que tiene en mente! ¿O acaso\n"
				    + "refiere que sea yo quien elija como debetiamos proceder?\n"
				    + "si es asi, no hay problema! confie en mi presi-kun! AH! \n"
				    + "Lo siento! quiero decir... Señor Presidente!";
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
		
	}
	
	public void dibujar(Graphics2D g2) {
		
		g2.drawImage(pdj.img.toto_cuerpo, 250, 50 + imageMov, null);
		g2.drawImage(pdj.img.toto_cabeza, 250, 50 + imageMov*2, null);
		
	}
	
	public void hablar(int indice) {
		if(dialogos[dialogoIndice] == null) {
			dialogoIndice = 0; 
		}
		
		pdj.ui.dialogoActual = dialogos[dialogoIndice];
				
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
