package principal;
 
 import java.awt.BasicStroke;
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.FontFormatException;
 import java.awt.Graphics2D;
 import java.io.IOException;
 import java.io.InputStream;
 import java.text.NumberFormat;
 import java.util.Locale;

 
 public class UI {
	 
	final int TIMER_VALOR = 50;
 
 	PanelDeJuego pdj;
 	Graphics2D g2;
 	Font maruMonica;
 	int unidad;
 	int anchoDeLinea;
 	int timerTransicion = TIMER_VALOR;
 	int valorDeCambio = 1;
 	public boolean oscureciendo = true;
 	int alpha = 0; // Transparencia inicial
 	public Color blancoLinea  = new Color(255, 255, 255);
 	public Color azulMecanico  = new Color(72, 82, 98);
 	public Color negroTransparente = new Color(0, 0, 0, 205);
 	public boolean textoCompleto = false;
 	public String nombreDePNJ = "";
 	public String dialogoActual = "";
 	public String dialogoMostrado = "";
 	public int cont = 0;
 	NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US); // Cambia "US" según el país
 
 	public UI(PanelDeJuego pdj) {
 		
 		this.pdj = pdj;
 		this.unidad = pdj.tamañoDeBaldosa;
 		this.anchoDeLinea = pdj.tamañoDeBaldosa/8;
 		formato.setMaximumFractionDigits(0);
 	
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
 		g2.setStroke(new BasicStroke());
 		g2.setColor(Color.white);
 		g2.setFont(g2.getFont().deriveFont(Font.BOLD,16f));
 		switch(pdj.estadoDeJuego) {
 		case 1 -> dibujarPantallaDeJuego();
 		case 2 -> dibujarPantallaDePausa();
 		case 3 -> dibujarPantallaDeDialogo();
 		}
 		cambioDeEscenaEfecto();
 
 	}
 	
 	public void dibujarPantallaDeTitulo() {
 	}
 	
 	public void dibujarPantallaDeJuego() {
 		dibujarFondo();
 		interfazDeReservas();
 	}
 	
 	public void dibujarPantallaDePausa() {
 	}
 	
 	public void dibujarPantallaDeDialogo() {
 		
 		interfazDeReservas();
 		interfazDeFecha();

		int x = pdj.tamañoDeBaldosa*2;
		int y = pdj.tamañoDeBaldosa*8 + (pdj.tamañoDeBaldosa/2);
		int width = pdj.anchoDePantalla - (pdj.tamañoDeBaldosa*4);
		int height = pdj.tamañoDeBaldosa*3 + (pdj.tamañoDeBaldosa/2);

		dibujarSubVentana(x, y, width, height);
		
		g2.fillRect(x, y, pdj.tamañoDeBaldosa*3, pdj.tamañoDeBaldosa/2);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
		
		g2.setColor(blancoLinea);
		
		g2.drawString(nombreDePNJ, x + pdj.tamañoDeBaldosa/4, y + pdj.tamañoDeBaldosa/3);
		
		x += pdj.tamañoDeBaldosa;
		y += pdj.tamañoDeBaldosa;
		
		if(!textoCompleto) {
			
			if(cont < dialogoActual.length()) {
				
				if(pdj.raton.CLICK && pdj.botonOn) {
					
					dialogoMostrado = dialogoActual;
					cont = dialogoActual.length();
					pdj.resetDelay();
				}
				else {
					
					dialogoMostrado += dialogoActual.charAt(cont);
					cont++;	
				}
				
			}
			else {
				textoCompleto = true;
			}
		}

		if(!dialogoActual.isEmpty()) {
			for(String line : dialogoMostrado.split("\n")) {
				g2.drawString(line, x - 20, y + 5);
				y += 30;
			}
		}

	}
 	
 	public void setearDialogo() {
 		
 		textoCompleto = false;
 		dialogoMostrado = "";
 	 	cont = 0;
 	 	pdj.resetDelay();
 	 	
 	}
 	
 	public void cambioDeEscenaEfecto() {
 	    if (pdj.transicionOn) {
 	        g2.setColor(new Color(0, 0, 0, alpha));
 	        g2.fillRect(0, 0, pdj.anchoDePantalla, pdj.altoDePantalla);

 	        if (oscureciendo) {
 	            alpha += 15;
 	            if (alpha >= 255) {
 	                alpha = 255;
 	                oscureciendo = false;
 	            }
 	        } else {
 	            alpha -= 15;
 	            if (alpha <= 0) {
 	                alpha = 0;
 	                pdj.transicionOn = false;
 	                oscureciendo = true;
 	            }
 	        }
 	    }
 	}
 	
 	private void dibujarFondo() {
 	}
 	
 	private void interfazDeReservas() {
 		
 		int alto = unidad + anchoDeLinea;
 		int ancho = unidad*6;
 		int posX = anchoDeLinea;
 		int posY = unidad/4;
 		
 		String texto = formato.format(pdj.data.getReservas())+ " M";
 		
 		dibujarSubVentana(posX, posY, ancho, alto);

 		g2.setStroke(new BasicStroke());
 		g2.setFont(g2.getFont().deriveFont(Font.BOLD,36f));
 		g2.setColor(blancoLinea);
 		g2.drawString(texto, obtenerXParaTextoCentrado(texto, ancho), posY + unidad/2 + anchoDeLinea*2);
 	}
 	
 	public void interfazDeFecha() {
 		
 		String semanaTexto = "Semana "+pdj.data.getSemana();
 		String mesTexto = nombreDeMes(pdj.data.getMes())+" "+pdj.data.getAño();
 		int alto = unidad + unidad/2;
 		int ancho = unidad*3 + unidad/2;
 		int posX = pdj.anchoDePantalla - ancho;
 		int posY = unidad/4;
 		
 		dibujarSubVentana(posX, posY, ancho, alto);
 		
 		g2.setFont(g2.getFont().deriveFont(Font.BOLD,20f));
 		g2.setColor(blancoLinea);
 		g2.drawString(semanaTexto, posX + obtenerXParaTextoCentrado(semanaTexto, ancho), posY + unidad);
 		g2.drawString(mesTexto, posX + obtenerXParaTextoCentrado(mesTexto, ancho), posY + unidad/2);
 		
 	}
 	
 	public Font getMaruMonica() {
 		
 		return this.maruMonica;
 	}
 	
 	private String nombreDeMes(int i) {
 		String mes = "";
 		switch(i) {
 		case 1 -> mes = "Enero";
 		case 2 -> mes = "Febrero";
 		case 3 -> mes = "Marzo";
 		case 4 -> mes = "Abril";
 		case 5 -> mes = "Mayo";
 		case 6 -> mes = "Junio";
 		case 7 -> mes = "Julio";
 		case 8 -> mes = "Agosto";
 		case 9 -> mes = "Septiembre";
 		case 10 -> mes = "Octubre";
 		case 11 -> mes = "Noviembre";
 		case 12 -> mes = "Diciembre";
 		}
 		return mes;
 	}
 	
 	private int obtenerXParaTextoCentrado(String texto, int espacioDeUbicacion) {
 		 
 		int longitud = (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();
 		int x = espacioDeUbicacion / 2 - longitud / 2;
 		return x;
 
 	}
 	
 	/*/private int anchoDeTexto(String texto) {
		 
 		return (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();

 	}/*/
 	
 	private void dibujarSubVentana(int x, int y, int width, int height) {
 		 
 		g2.setColor(negroTransparente);
 		g2.fillRoundRect(x, y, width, height, 2, 2);
 		
 		g2.setColor(azulMecanico);
 		g2.setStroke(new BasicStroke(anchoDeLinea));
 		g2.drawRoundRect(x, y, width-10, height-10, 2, 2);
 		
 		g2.setStroke(new BasicStroke());
 
 	}
 	
 }