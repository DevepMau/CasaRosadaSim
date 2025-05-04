package principal;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;

public class Raton implements MouseListener, MouseMotionListener {
	
	PanelDeJuego pdj;
	private Cursor cursorNormal;
	private Cursor cursorClick;
	public int posX;
	public int posY;
	public boolean CLICK;
	
    public Raton(PanelDeJuego pdj) {
		this.pdj = pdj;
		
		Point hotspot = new Point(8, 4);
        cursorNormal = Toolkit.getDefaultToolkit().createCustomCursor(pdj.img.cursor[1], hotspot, "CursorNormal");
        cursorClick = Toolkit.getDefaultToolkit().createCustomCursor(pdj.img.cursor[0], hotspot, "CursorClick");

	}

	@Override
    public void mouseClicked(MouseEvent e) {
    	//CLICK = true;
    	//System.out.println("clicked");
    }

	@Override
	public void mousePressed(MouseEvent e) {
		CLICK = true;
	    pdj.setCursor(cursorClick);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	    CLICK = false;
	    pdj.setCursor(cursorNormal);
	}

    @Override
    public void mouseEntered(MouseEvent e) {
    	pdj.setCursor(cursorNormal);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        pdj.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	CLICK = false;
        posX = e.getX();
        posY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	//CLICK = true;
    	pdj.setCursor(cursorClick);
    }
}
