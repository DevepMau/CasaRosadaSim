package principal;

import java.awt.event.*;

public class Raton implements MouseListener, MouseMotionListener {
	
	public int posX;
	public int posY;
	
    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Clic en: (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Botón presionado en: (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Botón liberado en: (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       System.out.println("Ratón entró en la ventana");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Ratón salió de la ventana");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Ratón movido a: (" + e.getX() + ", " + e.getY() + ")");
        posX = e.getX();
        posY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Arrastrando el ratón a: (" + e.getX() + ", " + e.getY() + ")");
    }
}
