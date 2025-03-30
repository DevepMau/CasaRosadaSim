package principal;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagenes {
	
	public BufferedImage notebook;
	public BufferedImage telefono;
	public BufferedImage muñeco;
	public BufferedImage carpetas;
	public BufferedImage libro;
	public BufferedImage mesa;

	public Imagenes() {
        try {
            inicializarImagenes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inicializarImagenes() throws IOException { 
   
    	notebook = configurarImagen("/mobiliario/monitor", 5);
		telefono = configurarImagen("/mobiliario/telefono", 4);
		muñeco = configurarImagen("/mobiliario/muñeco", 4);
		libro = configurarImagen("/mobiliario/libro", 4);
		mesa = configurarImagen("/mobiliario/mesa", 2);
		carpetas = configurarImagen("/mobiliario/carpetas", 4);
    	
    }

    private BufferedImage configurarImagen(String rutaImagen, int escala) throws IOException {
        Utilidades uTool = new Utilidades();
        BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream(rutaImagen + ".png"));
        return uTool.escalarImagen(imagen, imagen.getWidth() / 2 * escala, imagen.getHeight() / 2 * escala);
    }
}