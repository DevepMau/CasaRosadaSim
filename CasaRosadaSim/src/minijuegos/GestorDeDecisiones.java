package minijuegos;

import java.awt.Graphics2D;

import entidades.Entidad;
import principal.PanelDeJuego;

public class GestorDeDecisiones {
	
	PanelDeJuego pdj;
	Entidad pnj;
	
	public GestorDeDecisiones(PanelDeJuego pdj) {
		this.pdj = pdj;
	}
	
	public void actualizar() {
		
		if(pnj != null) {
			if(pdj.ui.textoCompleto && (pdj.teclado.ENTER || pdj.raton.CLICK)) {
				pdj.ui.setearDialogo(pnj.dialogos[pnj.dialogoIndice++]);
			}
			
			pnj.hablar(pnj.dialogoIndice);
			
		}
	}
	
	public void dibujar(Graphics2D g2) {}
	
	//////////////////////////////////////////////////////////////////////////
	
	public void setearPNJ(Entidad pnj) {
		this.pnj = pnj;
	}

}
