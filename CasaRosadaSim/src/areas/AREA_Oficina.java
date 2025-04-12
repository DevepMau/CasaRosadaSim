package areas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objetos.Objeto;
import principal.PanelDeJuego;

public class AREA_Oficina extends Area {
	
 	Objeto[] mobiliario = new Objeto[5];
 	BufferedImage mesa;
 	
 	public AREA_Oficina(PanelDeJuego pdj) {
 		
 		super(pdj);
 		
 		mesa = pdj.img.mesa;
 		mobiliario[0] = new Objeto(pdj.img.netbook, getUnidad()*4 + (getUnidad()/2), getUnidad()*6 + (getUnidad()/2));
 		mobiliario[1] = new Objeto(pdj.img.carpetas, getUnidad()*14 + (getUnidad()/2), getUnidad()*6 + (getUnidad()/2));
 		mobiliario[2] = new Objeto(pdj.img.telefono, getUnidad() - (getUnidad()/2), getUnidad()*6);
 		mobiliario[3] = new Objeto(pdj.img.muñeco, getUnidad()*2 + (getUnidad()/2), getUnidad()*9);
 		mobiliario[4] = new Objeto(pdj.img.libro,getUnidad()*11, getUnidad()*9 + (getUnidad()/2));

 	}
 	
 	public void actualizar() {
 		
 		for(Objeto objeto : mobiliario) {
 			objeto.actualizar(pdj.raton.posX, pdj.raton.posY);
 		}
 		
 		if(pdj.raton.CLICK) {
 			if(mobiliario[0].isColision()) {
 				pdj.zonaDeJuego = pdj.zonaNotebook;
 			}
 			else if(mobiliario[1].isColision()) {
 				pdj.zonaDeJuego = pdj.zonaCarpetas;
 			}
 			else if(mobiliario[2].isColision()) {
 				pdj.zonaDeJuego = pdj.zonaTelefono;
 			}
 			else if(mobiliario[3].isColision()) {
 				pdj.zonaDeJuego = pdj.zonaMuñeco;
 			}
 		}
 		
 	}
 	
 	public void dibujar(Graphics2D g2) {
 		g2.drawImage(pdj.img.mesa, 0, pdj.altoDePantalla - (getUnidad()*4), null);
 		for(Objeto objeto : mobiliario) {
 			objeto.dibujar(g2);
 			objeto.dibujarAreaSolida(g2);
 		}
 	}

}
