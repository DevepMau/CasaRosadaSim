package objetos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Opcion extends ObjetoInteractivo {
	
	private String mensaje;
	private String respuesta;

	public Opcion(BufferedImage[] imagenes) {
		super(imagenes);
		// TODO Auto-generated constructor stub
	}
	
	public void actualizar(int posX, int posY) {
		super.actualizar(posX, posY);
	}
	
	public void dibujar(Graphics2D g2) {
		super.dibujar(g2);
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
