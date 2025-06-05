package areas;

import java.awt.Graphics2D;

import objetos.ObjetoInteractivo;
import principal.PanelDeJuego;

public class AREA_Oficina extends Area {
 	
 	public AREA_Oficina(PanelDeJuego pdj) {
 		
 		super(pdj);
 		

 	}
 	
 	public void actualizar() {
 		
 		for(ObjetoInteractivo objeto : pdj.mobiliario) {
 			objeto.actualizar(pdj.raton.posX, pdj.raton.posY);
 		}
 		
 		if(pdj.raton.CLICK) {
 			if(pdj.mobiliario[0].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_NOTEBOOK;
 			}
 			else if(pdj.mobiliario[1].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_CALENDARIO;
 			}
 			else if(pdj.mobiliario[2].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_TELEFONO;
 			}
 			else if(pdj.mobiliario[3].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_MUÑECO;
 			}
 			else if(pdj.mobiliario[4].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_LIBRO;
 			}
 		}
 		
 	}
 	
 	public void dibujar(Graphics2D g2) {
 		g2.drawImage(pdj.img.mesa, 0, pdj.altoDePantalla - (getUnidad()*4), null);
 		for(ObjetoInteractivo objeto : pdj.mobiliario) {
 			objeto.dibujar(g2);
 			//objeto.dibujarAreaSolida(g2);
 		}
 	}

}
