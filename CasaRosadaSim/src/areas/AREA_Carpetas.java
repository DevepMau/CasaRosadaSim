package areas;

import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class AREA_Carpetas extends Area {

	public AREA_Carpetas(PanelDeJuego pdj) {
		super(pdj);
		// TODO Auto-generated constructor stub
	}
	
	public void actualizar() {
		super.actualizar();
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(getNegroTransparente());
		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
		
		g2.setColor(getBlancoLinea());
		g2.drawString("Carpetas", 400, 300);
	}

}
