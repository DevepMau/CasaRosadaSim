package areas;

import java.awt.Color;
import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class Area {
	
	PanelDeJuego pdj;
	private int unidad;
 	private int anchoDeLinea;
	private Color blancoLinea  = new Color(255, 255, 255);
 	private Color azulMecanico  = new Color(72, 82, 98);
 	private Color negroTransparente = new Color(0, 0, 0, 205);
	
	public Area (PanelDeJuego pdj) {
		this.pdj = pdj;
		this.unidad = pdj.tamañoDeBaldosa;
 		this.anchoDeLinea = pdj.tamañoDeBaldosa/8;
	}

	public void actualizar() {
		if(pdj.teclado.ESCAPE) {
 			pdj.zonaDeJuego = pdj.zonaOficina;
 		}
	}
	
	public void dibujar(Graphics2D g2) {}
	
	public int getUnidad() {return unidad;}

	public void setUnidad(int unidad) {this.unidad = unidad;}

	public int getAnchoDeLinea() {return anchoDeLinea;}

	public void setAnchoDeLinea(int anchoDeLinea) {this.anchoDeLinea = anchoDeLinea;}

	public Color getBlancoLinea() {return blancoLinea;}

	public void setBlancoLinea(Color blancoLinea) {this.blancoLinea = blancoLinea;}

	public Color getNegroTransparente() {return negroTransparente;}

	public void setNegroTransparente(Color negroTransparente) {this.negroTransparente = negroTransparente;}

	public Color getAzulMecanico() {return azulMecanico;}

	public void setAzulMecanico(Color azulMecanico) {this.azulMecanico = azulMecanico;}

}
