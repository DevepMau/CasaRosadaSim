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
 
 	PanelDeJuego pdj;
 	Graphics2D g2;
 	Font maruMonica;
 	int unidad;
 	int anchoDeLinea;
 	Color blancoLinea  = new Color(255, 255, 255);
 	Color azulMecanico  = new Color(72, 82, 98);
 	Color negroTransparente = new Color(0, 0, 0, 205);
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
 		}
 
 	}
 	
 	public void dibujarPantallaDeTitulo() {
 	}
 	
 	public void dibujarPantallaDeJuego() {
 		dibujarFondo();
 		interfazDeReservas();
 		interfazDeFecha();
 		//infoSobrereservas();
 	}
 	
 	public void dibujarPantallaDePausa() {
 	}
 	
 	public void dibujarPantallaDeDialogo() {
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
 	
 	private void infoSobrereservas() {
 		
 		int alto = unidad*3 + unidad/2;
 		int ancho = unidad*7;
 		int posX = anchoDeLinea;
 		int posY = unidad + (unidad/2);
 		
 		String exportaciones = formato.format(pdj.data.getIngresoExportaciones())+ " M";
 		String inversiones = formato.format(pdj.data.getIngresoInversiones())+ " M";
 		String importaciones = formato.format(pdj.data.getGastoImportaciones())+ " M";
 		String cuotaDeDeuda = formato.format(pdj.data.getPagoDeuda())+ " M";
 		String variacionSemanal = formato.format(pdj.data.variacionSemanal())+ " M";
 		
 		dibujarSubVentana(posX, posY, ancho, alto);
 		
 		g2.setStroke(new BasicStroke());
 		g2.setFont(g2.getFont().deriveFont(Font.BOLD,24f));
 		g2.setColor(blancoLinea);
 		g2.drawString("Exportaciones: ", posX*2, posY + unidad/2 + anchoDeLinea);
 		g2.drawString("Inversiones: ", posX*2, posY + unidad + anchoDeLinea);
 		g2.drawString("Importaciones: ", posX*2, posY + unidad + (unidad/2) + anchoDeLinea);
 		g2.drawString("Cuota de deuda: ", posX*2, posY + unidad*2 + anchoDeLinea);
 		g2.drawString("Total: ", posX*2, posY + unidad*3 + anchoDeLinea);
 		
 		g2.setColor(Color.green);
 		g2.drawString(exportaciones, ancho - anchoDeLinea*2 - (anchoDeTexto(exportaciones)), posY + unidad/2 + anchoDeLinea);
 		g2.drawString(inversiones, ancho - anchoDeLinea*2 - (anchoDeTexto(inversiones)), posY + unidad + anchoDeLinea);
 		g2.setColor(Color.red);
 		g2.drawString(importaciones, ancho - anchoDeLinea*2 - (anchoDeTexto(importaciones)), posY + unidad + (unidad/2) + anchoDeLinea);
 		g2.drawString(cuotaDeDeuda, ancho - anchoDeLinea*2 - (anchoDeTexto(cuotaDeDeuda)), posY + unidad*2 + anchoDeLinea);
 		if(pdj.data.variacionSemanal() >= 0) {
 			g2.setColor(Color.green);
 		}
 		g2.drawString(variacionSemanal, ancho - anchoDeLinea*2 - (anchoDeTexto(variacionSemanal)), posY + unidad*3 + anchoDeLinea);
 		g2.setColor(blancoLinea);
 		
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
 	
 	private int anchoDeTexto(String texto) {
		 
 		return (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();

 	}
 	
 	private void dibujarSubVentana(int x, int y, int width, int height) {
 		 
 		g2.setColor(negroTransparente);
 		g2.fillRoundRect(x, y, width, height, 2, 2);
 		
 		g2.setColor(azulMecanico);
 		g2.setStroke(new BasicStroke(anchoDeLinea));
 		g2.drawRoundRect(x, y, width-10, height-10, 2, 2);
 		
 		g2.setStroke(new BasicStroke());
 
 	}
 	
 }