package objetos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.PanelDeJuego;

public class ObjetoCalendario extends ObjetoInteractivo {
	
	PanelDeJuego pdj;

	public ObjetoCalendario(BufferedImage[] imagenes, PanelDeJuego pdj) {
		super(imagenes);
		this.pdj = pdj;
	}
	
	public void actualizar(int posX, int posY) {
		super.actualizar(posX, posY);
	}
	
	public void dibujar(Graphics2D g2) {
		super.dibujar(g2);
		int posX1 = getPosX() + pdj.tamañoDeBaldosa/2;
		int posX2 = getPosX() + pdj.tamañoDeBaldosa * 2 - (pdj.tamañoDeBaldosa/4);
		int posY = getPosY() + pdj.tamañoDeBaldosa/2  + pdj.tamañoDeBaldosa/16;
		g2.setColor(Color.white);
		g2.drawString(nombreDeMes(pdj.data.getMes()) ,posX1 ,posY);
		g2.drawString(""+pdj.data.getAño() ,posX2 ,posY );
	}
	
	private String nombreDeMes(int i) {
 		String mes = "";
 		switch(i) {
 		case 1 -> mes = "Enero";
 		case 2 -> mes = "Febrero";
 		case 3 -> mes = "Marzo";
 		case 4 -> mes = "Abril";
 		case 5 -> mes = "Mayo";
 		case 6 -> mes = "Junio";
 		case 7 -> mes = "Julio";
 		case 8 -> mes = "Agosto";
 		case 9 -> mes = "Septiembre";
 		case 10 -> mes = "Octubre";
 		case 11 -> mes = "Noviembre";
 		case 12 -> mes = "Diciembre";
 		}
 		return mes;
 	}

}
