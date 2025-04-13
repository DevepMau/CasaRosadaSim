package principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	PanelDeJuego pdj;
	public boolean W, S, A, D, ENTER, ESCAPE;
	//DEBUG
	boolean comprobarTiempoDeDibujado = false;
	
	public Teclado(PanelDeJuego pdj) {
		this.pdj = pdj;
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int codigo = e.getKeyCode();
		
		//MODO JUEGO
		if(pdj.estadoDeJuego == pdj.MODO_JUEGO) {
			
			if(codigo == KeyEvent.VK_W) {
				W = true;
			}
			if(codigo == KeyEvent.VK_S) {
				S = true;
			}
			if(codigo == KeyEvent.VK_A) {
				A = true;
			}
			if(codigo == KeyEvent.VK_D) {
				D = true;
			}
			if(codigo == KeyEvent.VK_P) {
				pdj.estadoDeJuego = pdj.MODO_PAUSA;
			}
			if(codigo == KeyEvent.VK_ENTER) {
				ENTER = true;
			}
			if(codigo == KeyEvent.VK_ESCAPE) {
				ESCAPE = true;
			}
			//MODO DEBUG
			if(codigo == KeyEvent.VK_T) {
				if(comprobarTiempoDeDibujado == false) {
					comprobarTiempoDeDibujado = true;
				}
				else if(comprobarTiempoDeDibujado == true) {
					comprobarTiempoDeDibujado = false;
				}
			}
		}
		//MODO PAUSA
		else if(pdj.estadoDeJuego == pdj.MODO_PAUSA) {
			if(codigo == KeyEvent.VK_P) {
				pdj.estadoDeJuego = pdj.MODO_JUEGO;
			}
		}
		//MODO DIALOGO
		else if(pdj.estadoDeJuego == pdj.MODO_DIALOGO) {
			if(codigo == KeyEvent.VK_ENTER) {
				pdj.estadoDeJuego = pdj.MODO_JUEGO;
			}
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();

		if(codigo == KeyEvent.VK_W) {
			W = false;
		}
		if(codigo == KeyEvent.VK_S) {
			S = false;
		}
		if(codigo == KeyEvent.VK_A) {
			A = false;
		}
		if(codigo == KeyEvent.VK_D) {
			D = false;
		}
		if(codigo == KeyEvent.VK_ENTER) {
			ENTER = false;
		}
		if(codigo == KeyEvent.VK_ESCAPE) {
			ESCAPE = false;
		}


	}

}