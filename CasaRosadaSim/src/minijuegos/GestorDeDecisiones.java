package minijuegos;

import java.awt.Graphics2D;

import entidades.Entidad;
import principal.PanelDeJuego;

public class GestorDeDecisiones {
	
	PanelDeJuego pdj;
	Entidad pnj;
	String mensaje;
	private boolean finDeEvento = false;
	private boolean mostrarUIDeOpciones = false;
	
	public GestorDeDecisiones(PanelDeJuego pdj) {
		this.pdj = pdj;
	}
	
	public void actualizar() {
		
		if(pnj != null) {
			
			pdj.ui.nombreDePNJ = pnj.getNombre();
			
			if(pdj.ui.textoCompleto && (pdj.teclado.ENTER || pdj.raton.CLICK) && !pnj.hayOpciones() && pdj.botonOn && !finDeEvento) {
				
				pnj.siguienteDialogoIndice();
				
				mensaje = pnj.obtenerMensaje(pnj.getDialogoIndice());
				
				if(!mensaje.equals(pnj.FIN_DE_DIALOGO)) {
					
					if(!mensaje.trim().isEmpty()) {
						
						pdj.ui.setearDialogo();
						
					}
					else {
						
						pnj.habilitarOpciones();
	
					}		
					
				}
				else {
					
					pdj.transicionOn = true;
					finDeEvento = true;
					
				}

			}
			
			pnj.actualizar();
			
			if(finDeEvento) {
				if(!pdj.ui.oscureciendo) {
					salirDeGDD();
					finDeEvento = false;
				}
			}
			
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
		pdj.resetDelay();
		pdj.estadoDeJuego = pdj.MODO_DIALOGO;
	}
	
	public void salirDeGDD() {
		pdj.resetDelay();
		pnj.siguienteDialogoIndice();
		pdj.ui.setearDialogo();
		pdj.estadoDeJuego = pdj.MODO_JUEGO;
		pdj.zonaDeJuego = pdj.ZONA_TELEFONO;
		pdj.areas[2].resetArea();
	}

	public boolean habilitarUIDeOpciones() {
		return mostrarUIDeOpciones;
	}

}
