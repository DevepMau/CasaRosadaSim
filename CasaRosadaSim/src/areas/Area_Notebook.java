package areas;

import java.awt.Color;
import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class Area_Notebook {
	
	PanelDeJuego pdj;
	int unidad;
 	int anchoDeLinea;
	Color blancoLinea  = new Color(255, 255, 255);
 	Color azulMecanico  = new Color(72, 82, 98);
 	Color negroTransparente = new Color(0, 0, 0, 205);
	
	public Area_Notebook(PanelDeJuego pdj) {
		this.pdj = pdj;
		this.unidad = pdj.tamañoDeBaldosa;
 		this.anchoDeLinea = pdj.tamañoDeBaldosa/8;
	}
	
	public void actualizar() {
		if(pdj.teclado.ESCAPE) {
 			pdj.zonaDeJuego = pdj.zonaOficina;
 		}
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(negroTransparente);
		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
		
		g2.setColor(blancoLinea);
		g2.fillRect(unidad*2, unidad*3, unidad*12, unidad*8);
	}

}
