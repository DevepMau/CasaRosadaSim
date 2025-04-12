package areas;

import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class AREA_Notebook extends Area {
	
	public AREA_Notebook(PanelDeJuego pdj) {
		super(pdj);
	}
	
	public void actualizar() {
		super.actualizar();
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(getNegroTransparente());
		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
		
		g2.setColor(getBlancoLinea());
		g2.fillRect(getUnidad()*2, getUnidad()*3, getUnidad()*12, getUnidad()*8);
	}

}
