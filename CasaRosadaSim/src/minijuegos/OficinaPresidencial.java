package minijuegos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objetos.Objeto;
import principal.PanelDeJuego;

public class OficinaPresidencial {
	
	PanelDeJuego pdj;
	private int unidad;
 	Objeto[] mobiliario = new Objeto[5];
 	BufferedImage mesa;
 	
 	public OficinaPresidencial(PanelDeJuego pdj) {
 		
 		this.pdj = pdj;
 		this.unidad = pdj.tamañoDeBaldosa;
 		mesa = pdj.img.mesa;
 		mobiliario[1] = new Objeto(pdj.img.carpetas, unidad*14 + (unidad/2), unidad*6 + (unidad/2));
 		mobiliario[2] = new Objeto(pdj.img.telefono, unidad - (unidad/2), unidad*6);
 		mobiliario[3] = new Objeto(pdj.img.muñeco, unidad*2 + (unidad/2), unidad*9);
 		mobiliario[4] = new Objeto(pdj.img.libro,unidad*11, unidad*9 + (unidad/2));
 		mobiliario[0] = new Objeto(pdj.img.netbook, unidad*4 + (unidad/2), unidad*6 + (unidad/2));

 	}
 	
 	public void actualizar() {
 		
 		for(Objeto objeto : mobiliario) {
 			objeto.actualizar(pdj.raton.posX, pdj.raton.posY);
 		}
 	}
 	
 	public void dibujar(Graphics2D g2) {
 		g2.drawImage(pdj.img.mesa, 0, pdj.altoDePantalla - (unidad*4), null);
 		for(Objeto objeto : mobiliario) {
 			objeto.dibujar(g2);
 			//objeto.dibujarAreaSolida(g2);
 		}
 	}

}
