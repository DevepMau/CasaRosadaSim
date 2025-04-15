package areas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objetos.ObjetoInteractivo;
import principal.PanelDeJuego;

public class AREA_Oficina extends Area {
	
 	ObjetoInteractivo[] mobiliario = new ObjetoInteractivo[5];
 	BufferedImage mesa;
 	
 	public AREA_Oficina(PanelDeJuego pdj) {
 		
 		super(pdj);
 		
 		mesa = pdj.img.mesa;
 		mobiliario[0] = new ObjetoInteractivo(pdj.img.netbook, getUnidad()*4 + (getUnidad()/2), getUnidad()*6 + (getUnidad()/2));
 		mobiliario[1] = new ObjetoInteractivo(pdj.img.carpetas, getUnidad()*14 + (getUnidad()/2), getUnidad()*6 + (getUnidad()/2));
 		mobiliario[2] = new ObjetoInteractivo(pdj.img.telefono, getUnidad() - (getUnidad()/2), getUnidad()*6);
 		mobiliario[3] = new ObjetoInteractivo(pdj.img.muñeco, getUnidad()*2 + (getUnidad()/2), getUnidad()*9);
 		mobiliario[4] = new ObjetoInteractivo(pdj.img.libro,getUnidad()*11, getUnidad()*9 + (getUnidad()/2));

 	}
 	
 	public void actualizar() {
 		
 		for(ObjetoInteractivo objeto : mobiliario) {
 			objeto.actualizar(pdj.raton.posX, pdj.raton.posY);
 		}
 		
 		if(pdj.raton.CLICK) {
 			if(mobiliario[0].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_NOTEBOOK;
 			}
 			else if(mobiliario[1].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_CARPETAS;
 			}
 			else if(mobiliario[2].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_TELEFONO;
 			}
 			else if(mobiliario[3].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_MUÑECO;
 			}
 			else if(mobiliario[4].isColision()) {
 				pdj.zonaDeJuego = pdj.ZONA_LIBRO;
 			}
 		}
 		
 	}
 	
 	public void dibujar(Graphics2D g2) {
 		g2.drawImage(pdj.img.mesa, 0, pdj.altoDePantalla - (getUnidad()*4), null);
 		for(ObjetoInteractivo objeto : mobiliario) {
 			objeto.dibujar(g2);
 			objeto.dibujarAreaSolida(g2);
 		}
 	}

}
