package entidades;

import java.awt.Graphics2D;

import principal.PanelDeJuego;

public class PNJ_Toto extends Entidad {

	public PNJ_Toto(PanelDeJuego pdj) {
		
		super(pdj);
		this.setNombre("Toto-chan");
		this.setImagenes(pdj.img.toto_cuerpo, pdj.img.toto_cabeza);
	}
	
	public void actualizar() {
		
		super.actualizar();
	}
	
	public void dibujar(Graphics2D g2) {
		
		super.dibujar(g2);
	}
	
	/////////////////////////////////////////////////////
	
	public void cargarMensajes(
			) {
		
		this.setMensajes(new String[10]);
		
		///////////////////////////////////////////////////////////////////////////////////////////\n/////////
		
		this.configurarMensajeByIndice(0, "Buenos días, Señor Presidente. Mi rostro no cambia, pero\n"
				                        + "mi interés económico sí.");
		
		this.configurarMensajeByIndice(1, "Anoche soñé con una licuadora gigante que convertía pla\n"
				                        + "-nes sociales en reservas del Banco Central. Fue… *sigh*.\n"
				                        + "Bueno, volvamos al trabajo.");
		
		this.configurarMensajeByIndice(2, "He modelado tres posibles escenarios para enfrentar el \n"
				                        + "déficit. Elija sabiamente, aunque yo igual voy a ejecutar\n"
				                        + "lo que me parezca mas conveniente para el pais.");
		
		this.configurarMensajeByIndice(3, "");
		
		this.configurarMensajeByIndice(4, "Entonces me retiro, Señor Presidente. Seguiré monitoreando\n"
				                        + "la economía… ");
		
		this.configurarMensajeByIndice(5, "Desde la terraza del BCRA. Necesito absorber sol para man\n"
				                        + "-tenerme activa. Moái-chuu~");
		
		this.configurarMensajeByIndice(6, FIN_DE_DIALOGO);
		
	}
	
	public void cargarOpciones() {
		
		setConjuntosDeOpciones(1);
		
		//////////////////////////////////////  //////////////////////////////////////////////////////\n/////////
		getOpciones().get(0)[0].setearOpcion("Cortar todos los subsidios y liberar el tipo de cambio.", 
				                             "Una decisión fría, brutal y ortodoxa. Me agrada. Su alma\n"
				                           + "huele a recesión, pero con metas claras");
		getOpciones().get(0)[1].setearOpcion("Subsidios limitados, ajuste gradual y diálogo con sectores.", 
				                             "Tibio. Ni carne ni soja. Pero al menos no me da arcadas\n"
				                           + "monetarias");
		getOpciones().get(0)[2].setearOpcion("Plan de estímulo. Emisión controlada y ayuda a los más vulnerables.", 
				                             "¿Usted quiere inflación o solo me está provocando? Esto\n"
				                           + "no es un simulador de caricias, Señor...");
	}

}
