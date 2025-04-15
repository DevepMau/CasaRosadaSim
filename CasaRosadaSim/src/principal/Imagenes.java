package principal;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagenes {
	
	//OFICINA
	public BufferedImage[] netbook = new BufferedImage[2];
	public BufferedImage[] telefono = new BufferedImage[2];
	public BufferedImage[] muñeco = new BufferedImage[2];
	public BufferedImage[] carpetas = new BufferedImage[2];
	public BufferedImage[] libro = new BufferedImage[2];
	public BufferedImage[] cursor = new BufferedImage[2];
	public BufferedImage mesa;
	
	//TELEFONO
	public BufferedImage[] contacto = new BufferedImage[2];
	
	//PERSONAJES
	public BufferedImage[] capote = new BufferedImage[4];

	public Imagenes() {
        try {
            inicializarImagenes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inicializarImagenes() throws IOException { 
   
    	//OFICINA
    	netbook[0] = configurarImagen("/mobiliario/netbook1", 5);
    	netbook[1] = configurarImagen("/mobiliario/netbook2", 5);
		telefono[0] = configurarImagen("/mobiliario/telefono1", 4);
		telefono[1] = configurarImagen("/mobiliario/telefono2", 4);
		muñeco[0] = configurarImagen("/mobiliario/muñeco1", 4);
		muñeco[1] = configurarImagen("/mobiliario/muñeco2", 4);
		libro[0] = configurarImagen("/mobiliario/libro1", 4);
		libro[1] = configurarImagen("/mobiliario/libro2", 4);
		carpetas[0] = configurarImagen("/mobiliario/carpetas1", 4);
		carpetas[1] = configurarImagen("/mobiliario/carpetas2", 4);
		cursor[0] = configurarImagen("/cursores/mano_click", 4);
		cursor[1] = configurarImagen("/cursores/mano_normal", 4);
		mesa = configurarImagen("/mobiliario/mesa", 2);
		
		//TELEFONO
		contacto[0] = configurarImagen("/interfaz/contacto1", 2);
		contacto[1] = configurarImagen("/interfaz/contacto2", 2);
		
		//PERSONAJES
		capote[0] = configurarImagen("/personajes/capoteNormal", 5);
		capote[1] = configurarImagen("/personajes/capoteFeliz", 5);
		capote[2] = configurarImagen("/personajes/capoteTriste", 5);
		capote[3] = configurarImagen("/personajes/capoteIcono", 2);
    	
    }

    private BufferedImage configurarImagen(String rutaImagen, int escala) throws IOException {
        Utilidades uTool = new Utilidades();
        BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream(rutaImagen + ".png"));
        return uTool.escalarImagen(imagen, imagen.getWidth() / 2 * escala, imagen.getHeight() / 2 * escala);
    }
}