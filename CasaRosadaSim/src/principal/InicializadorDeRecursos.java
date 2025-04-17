package principal;

import areas.AREA_Carpetas;
import areas.AREA_Libro;
import areas.AREA_Muñeco;
import areas.AREA_Notebook;
import areas.AREA_Oficina;
import areas.AREA_Telefono;
import objetos.ObjetoInteractivo;

public class InicializadorDeRecursos {

	PanelDeJuego pdj;

	public InicializadorDeRecursos(PanelDeJuego pdj) {
		this.pdj = pdj;
	}

	public void establecerObjetos() {
		pdj.mobiliario[0] = new ObjetoInteractivo(pdj.img.netbook);
		pdj.mobiliario[0].setearPosicionObjeto(pdj.tamañoDeBaldosa*4 + (pdj.tamañoDeBaldosa/2), pdj.tamañoDeBaldosa*6 + (pdj.tamañoDeBaldosa/2));
		
		pdj.mobiliario[1] = new ObjetoInteractivo(pdj.img.carpetas);
		pdj.mobiliario[1].setearPosicionObjeto(pdj.tamañoDeBaldosa*14 + (pdj.tamañoDeBaldosa/2), pdj.tamañoDeBaldosa*6 + (pdj.tamañoDeBaldosa/2));
		
		pdj.mobiliario[2] = new ObjetoInteractivo(pdj.img.telefono);
		pdj.mobiliario[2].setearPosicionObjeto( pdj.tamañoDeBaldosa - (pdj.tamañoDeBaldosa/2), pdj.tamañoDeBaldosa*6);
		
		pdj.mobiliario[3] = new ObjetoInteractivo(pdj.img.muñeco);
		pdj.mobiliario[3].setearPosicionObjeto( pdj.tamañoDeBaldosa*2 + (pdj.tamañoDeBaldosa/2), pdj.tamañoDeBaldosa*9);
		
		pdj.mobiliario[4] = new ObjetoInteractivo(pdj.img.libro);
		pdj.mobiliario[4].setearPosicionObjeto( pdj.tamañoDeBaldosa*11, pdj.tamañoDeBaldosa*9 + (pdj.tamañoDeBaldosa/2));
		
	}
	
	public void establecerNPCs() {


	}
	
	public void establecerAreas() {
		pdj.areas[0] = new AREA_Oficina(pdj);
		pdj.areas[1] = new AREA_Notebook(pdj);
		pdj.areas[2] = new AREA_Telefono(pdj);
		pdj.areas[3] = new AREA_Muñeco(pdj);
		pdj.areas[4] = new AREA_Libro(pdj);
		pdj.areas[5] = new AREA_Carpetas(pdj);

		
	}

}