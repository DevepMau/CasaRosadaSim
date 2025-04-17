package objetos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ObjetoInteractivo {
	
	private int posX;
	private int posY;
	private boolean colision = false;
	private BufferedImage[] imagenes;
	private Rectangle areaSolida;
	
	public ObjetoInteractivo(BufferedImage[] imagenes) {
		this.imagenes = imagenes;
		this.areaSolida = new Rectangle(this.posX + (imagenes[0].getWidth()/8), 
										this.posY + (imagenes[0].getHeight()/16), 
										imagenes[0].getWidth() - (imagenes[0].getWidth()/4), 
										imagenes[0].getHeight() - (imagenes[0].getHeight()/8));
		
	}
	
	public void actualizar(int posX, int posY) {
 		if(estaSobre(posX, posY)) {
 			colision = true;
 		}
 		else {
 			colision = false;
 		}
 	}
 	
 	public void dibujar(Graphics2D g2) {
 		if(colision) {
 			g2.drawImage(imagenes[1], this.posX, this.posY, null);
 		}
 		else {
 			g2.drawImage(imagenes[0], this.posX, this.posY, null);
 		}
 	}
 	
 	public void dibujarAreaSolida(Graphics2D g2) {
 		g2.setColor(new Color(155, 155, 255, 100));
 		g2.fillRect(areaSolida.x, areaSolida.y, areaSolida.width, areaSolida.height);
 	}
 	
 	public boolean estaSobre(int mouseX, int mouseY) {
 	    return areaSolida.contains(mouseX, mouseY);
 	}
 	
 	public void setearPosicionObjeto(int posX, int posY) {
 		setPosX(posX);
 		setPosY(posY);
 		this.areaSolida.setLocation(posX + imagenes[0].getWidth()/8, posY + imagenes[0].getHeight()/16);
 	}
 	
 	///////////////////////////////////////////////////////////////////////////////

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Rectangle getAreaSolida() {
		return areaSolida;
	}

	public void setAreaSolida(Rectangle areaSolida) {
		this.areaSolida = areaSolida;
	}

	public boolean isColision() {
		return colision;
	}

	public void setColision(boolean colision) {
		this.colision = colision;
	}

	public BufferedImage[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(BufferedImage[] imagenes) {
		this.imagenes = imagenes;
	}

}
