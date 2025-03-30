package principal;
 
 import java.awt.BasicStroke;
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.FontFormatException;
 import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.IOException;
 import java.io.InputStream;

import javax.imageio.ImageIO;
 
 public class UI {
 
 	PanelDeJuego pdj;
 	Graphics2D g2;
 	Font maruMonica;
 	int unidad;
 	int anchoDeLinea;
 	Color primario  = new Color(143, 208, 50);
 	Color primarioOscuro = new Color(55, 105, 55);
 	Color primarioClaro = new Color(155, 255, 155);
 	Color secundario = new Color(15, 15, 15);
 	Image monitor;
 	Image telefono;
 	Image muñeco;
 	Image libro;
 	Image mesa;
 	Image carpetas;
 
 	public UI(PanelDeJuego pdj) {
 		
 		this.pdj = pdj;
 		this.unidad = pdj.tamañoDeBaldosa;
 		this.anchoDeLinea = pdj.tamañoDeBaldosa/16;
 	
 		try {
 			InputStream is = getClass().getResourceAsStream("/fuentes/MaruMonica.ttf");
 			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
 			monitor = configurarImagen("/mobiliario/monitor", 5);
 			telefono = configurarImagen("/mobiliario/telefono", 4);
 			muñeco = configurarImagen("/mobiliario/muñeco", 4);
 			libro = configurarImagen("/mobiliario/libro", 4);
 			mesa = configurarImagen("/mobiliario/mesa", 2);
 			carpetas = configurarImagen("/mobiliario/carpetas", 4);
 			
 		} catch (FontFormatException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
 
 	public void dibujar(Graphics2D g2) {
 
 		this.g2 = g2;
 
 		g2.setFont(maruMonica);
 		g2.setStroke(new BasicStroke(anchoDeLinea));
 		g2.setColor(Color.white);
 		g2.setFont(g2.getFont().deriveFont(Font.BOLD,16f));
 
 	}
 	
 	public void dibujarPantallaDeTitulo() {
 	}
 	
 	public void dibujarPantallaDeJuego() {
 		dibujarFondo();
 		dibujarEscritorio();
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
 	
 	public void dibujarConversorDeMoneda() {
 		g2.setColor(primarioOscuro);
 		g2.fillRoundRect(unidad*1, unidad*5, unidad*4, unidad*2, unidad/8, unidad/8);
 		g2.setColor(primario);
 		g2.fillRoundRect(unidad*2, unidad*5, unidad*4, unidad*2, unidad/8, unidad/8);
 		g2.setColor(secundario);
 		g2.fillRect(unidad*2 + (unidad/4), unidad*5 + (unidad/4), unidad*4 - (unidad/2), unidad*2 - (unidad/2));
 	}
 	
 	public Font getMaruMonica() {
 		
 		return this.maruMonica;
 	}
 	
 	private void dibujarFondo() {
 	}
 	
 	private void dibujarEscritorio() {
 		g2.drawImage(mesa, 0, pdj.altoDePantalla - (unidad*4), null);
 		g2.drawImage(carpetas, unidad*14 + (unidad/2), unidad*6 + (unidad/2), null);
 		g2.drawImage(telefono, unidad - (unidad/2), unidad*6, null);
 		g2.drawImage(muñeco, unidad*2 + (unidad/2), unidad*9, null);
 		g2.drawImage(libro, unidad*11, unidad*9 + (unidad/2), null);
 		g2.drawImage(monitor, unidad*4 + (unidad/2), unidad*6 + (unidad/2), null);
 		
 	}
 	
 	private void drawCustomRectangle(int x, int y, int base, int altura) {
        int topWidth = (int) (base * 0.60);  // Lado superior = 3/4 de la base
        int xOffset = (base - topWidth) / 2; // Para centrar el lado superior

        int[] xPoints = { x, x + base, x + base - xOffset, x + xOffset };
        int[] yPoints = { y + altura, y + altura, y, y };

        g2.fillPolygon(xPoints, yPoints, 4);
    }
 	
 	private BufferedImage configurarImagen(String rutaImagen, int escala) throws IOException {
        Utilidades uTool = new Utilidades();
        BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream(rutaImagen + ".png"));
        return uTool.escalarImagen(imagen, imagen.getWidth() / 2 * escala, imagen.getHeight() / 2 * escala);
    }
 	
 }