package objetos;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Opcion extends ObjetoInteractivo {
	
	private String mensaje;
	private String respuesta;
	private int offsetX = 0;
	private int velocidadScroll = 1; // píxeles por frame

	public Opcion(BufferedImage[] imagenes) {
		super(imagenes);
		// TODO Auto-generated constructor stub
	}
	
	public void actualizar(int posX, int posY) {
		super.actualizar(posX, posY);
	}
	
	public void dibujar(Graphics2D g2) {
		super.dibujar(g2);

		int startX = getPosX();
		int startY = getPosY() + 32;
		
		FontMetrics fm = g2.getFontMetrics();
		int textoAncho = fm.stringWidth(mensaje);
		
		if(isColision()) {
			
			g2.setColor(Color.black);
			g2.setClip(startX, startY - fm.getAscent(), this.getImagenes()[0].getWidth(), fm.getHeight());
			g2.drawString(mensaje, startX - offsetX, startY);
			g2.setClip(null);

			offsetX += velocidadScroll;

			if (offsetX > textoAncho + 50) {
				offsetX = -(textoAncho - 50);
			}
		}
		else {
			g2.setColor(Color.white);

			String textoMostrar = mensaje;
			int anchoMaximo = this.getImagenes()[0].getWidth() - 24;
			
			if(fm.stringWidth(mensaje) > anchoMaximo) {
				String puntos = "...";
				int anchoPuntos = fm.stringWidth(puntos);
				int i = mensaje.length();
				
				while (i > 0 && fm.stringWidth(mensaje.substring(0, i)) + anchoPuntos > anchoMaximo) {
					i--;
				}

				textoMostrar = mensaje.substring(0, i) + puntos;
			}

			g2.drawString(textoMostrar, getPosX() + 16, getPosY() + 32);
			offsetX = 0;
		}
		
	}
	
	public void setearOpcion(String mensaje, String respuesta) {
		setMensaje(mensaje);
		setRespuesta(respuesta);
	}
	
	//////////////////////////////////////////////////////////////////////

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
