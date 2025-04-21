package minijuegos;

import java.awt.Graphics2D;

import entidades.Entidad;
import principal.PanelDeJuego;

public class GestorDeDecisiones {
	
	PanelDeJuego pdj;
	Entidad pnj;
	private boolean mostrarOpciones = false;
	
	public GestorDeDecisiones(PanelDeJuego pdj) {
		this.pdj = pdj;
	}
	
	public void actualizar() {
		
		if(pnj != null) {
			if(pdj.ui.textoCompleto && (pdj.teclado.ENTER || pdj.raton.CLICK)) {

				if(!pnj.mensaje[pnj.getIndice()].isEmpty()) {
						
					System.out.println("dialogo: "+pdj.ui.dialogoActual);
					System.out.println("///////////////////////////////////////////////");
					pdj.ui.setearDialogo(pnj.mensaje[pnj.siguienteIndice()]);
					mostrarOpciones = false;
					
				}
				else {
					
					mostrarOpciones = true;
					pnj.hayOpciones = true;
					
				}
			}
			
			pdj.ui.nombreDePNJ = pnj.getNombre();
			
			pnj.actualizar();
			
		}
	}
	
	public void dibujar(Graphics2D g2) {
		if(pnj != null) {
			pnj.dibujar(g2);
			g2.drawImage(pdj.img.mesa, 0, pdj.tamañoDeBaldosa*9, null);
			
		}
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	public Entidad getPNJ() {
		return pnj;
	}
	
	public void setearPNJ(Entidad pnj) {
		this.pnj = pnj;
	}

	public boolean isMostrarOpciones() {
		return mostrarOpciones;
	}

	public void setMostrarOpciones(boolean mostrarOpciones) {
		this.mostrarOpciones = mostrarOpciones;
	}

}
