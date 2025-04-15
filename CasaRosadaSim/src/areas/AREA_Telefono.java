package areas;

import java.awt.Graphics2D;

import objetos.Objeto;
import principal.PanelDeJuego;

public class AREA_Telefono extends Area {
	
	Objeto[] contactos = new Objeto[6];

	public AREA_Telefono(PanelDeJuego pdj) {
		super(pdj);
		
		contactos[0] = new Objeto(pdj.img.contacto, getUnidad()*2, getUnidad()*3);
		contactos[1] = new Objeto(pdj.img.contacto, getUnidad()*2, getUnidad()*6);
		contactos[2] = new Objeto(pdj.img.contacto, getUnidad()*2, getUnidad()*9);
		contactos[3] = new Objeto(pdj.img.contacto, getUnidad()*8, getUnidad()*3);
		contactos[4] = new Objeto(pdj.img.contacto, getUnidad()*8, getUnidad()*6);
		contactos[5] = new Objeto(pdj.img.contacto, getUnidad()*8, getUnidad()*9);
		
	}
	
	public void actualizar() {
		super.actualizar();
		for(Objeto objeto : contactos) {
 			objeto.actualizar(pdj.raton.posX, pdj.raton.posY);
 		}
		
		if(pdj.raton.CLICK) {
 			if(contactos[0].isColision()) {
 				pdj.estadoDeJuego = pdj.MODO_DIALOGO;
 			}
 			else if(contactos[1].isColision()) {
 			}
 			else if(contactos[2].isColision()) {
 			}
 			else if(contactos[3].isColision()) {
 			}
 			else if(contactos[4].isColision()) {
 			}
 			else if(contactos[5].isColision()) {
 			}
 		}
		
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(getNegroTransparente());
		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
		
		for(Objeto objeto : contactos) {
 			objeto.dibujar(g2);
 			objeto.dibujarAreaSolida(g2);
 		}
	}

}
