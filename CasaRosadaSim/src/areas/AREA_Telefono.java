package areas;

import java.awt.Graphics2D;

import objetos.ObjetoInteractivo;
import principal.PanelDeJuego;

public class AREA_Telefono extends Area {

	public AREA_Telefono(PanelDeJuego pdj) {
		super(pdj);
		
	}
	
	public void actualizar() {
		super.actualizar();
		for(ObjetoInteractivo objeto : pdj.contactos) {
 			objeto.actualizar(pdj.raton.posX, pdj.raton.posY);
 		}
		
		if(pdj.raton.CLICK) {
 			if(pdj.contactos[0].isColision()) {
 				pdj.gdd.setearPNJ(pdj.gabinete[0]);
 				pdj.estadoDeJuego = pdj.MODO_DIALOGO;
 			}
 			/*/else if(pdj.contactos[1].isColision()) {
 			}
 			else if(pdj.contactos[2].isColision()) {
 			}
 			else if(pdj.contactos[3].isColision()) {
 			}
 			else if(pdj.contactos[4].isColision()) {
 			}
 			else if(pdj.contactos[5].isColision()) {
 			}/*/
 		}
		
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(getNegroTransparente());
		g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);
		
		pdj.contactos[0].dibujar(g2);
		
		/*/for(ObjetoInteractivo objeto : pdj.contactos) {
 			objeto.dibujar(g2);
 			objeto.dibujarAreaSolida(g2);
 		}/*/
	}

}
