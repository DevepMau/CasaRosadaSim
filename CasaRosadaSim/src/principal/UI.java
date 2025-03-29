package principal;
 
 import java.awt.BasicStroke;
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.FontFormatException;
 import java.awt.Graphics2D;
 import java.io.IOException;
 import java.io.InputStream;
 
 public class UI {
 
 	PanelDeJuego pdj;
 	Graphics2D g2;
 	Font maruMonica;
 
 	public UI(PanelDeJuego pdj) {
 	
 		try {
 			InputStream is = getClass().getResourceAsStream("/fuentes/MaruMonica.ttf");
 			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
 		} catch (FontFormatException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
 
 	public void dibujar(Graphics2D g2) {
 
 		this.g2 = g2;
 
 		g2.setFont(maruMonica);
 		g2.setColor(Color.white);
 		g2.setFont(g2.getFont().deriveFont(Font.BOLD,16f));
 
 	}
 	
 	public void dibujarPantallaDeTitulo() {
 	}
 	
 	public void dibujarPantallaDeJuego() {
 	}
 	
 	public void dibujarPantallaDePausa() {
 	}
 	
 	public void dibujarPantallaDeDialogo() {
 	}

 	public void dibujarSubVentana(int x, int y, int width, int height) {
 
 		Color c = new Color(0,0,0, 200);
 		g2.setColor(c);
 		g2.fillRoundRect(x, y, width, height, 35, 35);
 		
 		c = new Color(255, 255, 255);
 		g2.setColor(c);
 		g2.setStroke(new BasicStroke(5));
 		g2.drawRoundRect(x, y, width-10, height-10, 25, 25);
 
 	}
 
 	public int obtenerXParaTextoCentrado(String texto) {
 
 		int longitud = (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();
 		int x = pdj.anchoDePantalla / 2 - longitud / 2;
 		return x;
 
 	}
 	
 	public Font getMaruMonica() {
 		
 		return this.maruMonica;
 	}
 	
 }