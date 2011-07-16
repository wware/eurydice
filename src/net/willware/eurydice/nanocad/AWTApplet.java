package net.willware.eurydice.nanocad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;

import net.willware.eurydice.core.Structure;
import net.willware.eurydice.library.StructureLibrary;

/**
 * An applet to test AWT drawing using {@link AWTEngine}.
 */
public class AWTApplet extends JApplet implements MouseListener, MouseMotionListener  {

    /** The gr. */
    private Graphics gr;

    /** The struc. */
    private Structure struc = StructureLibrary.get("Aspirin");
    //private Structure struc = new DiamondRod();
    //private Structure struc = new Diamond();
    /** The oldx. */
    int oldx = -1;

    /** The oldy. */
    int oldy = -1;

    /** The is drawing quick. */
    boolean isDrawingQuick = false;

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;

    /* (non-Javadoc)
     * @see java.applet.Applet#init()
     */
    public void init() {
        setMinimumSize(new Dimension(640, 480));
        setBackground(Color.white);
        setForeground(Color.white);
        addMouseListener( this );
        addMouseMotionListener( this );
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    public void mouseEntered( MouseEvent e ) {
        // called when the pointer enters the applet's rectangular area
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    public void mouseExited( MouseEvent e ) {
        // called when the pointer leaves the applet's rectangular area
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed( MouseEvent e ) {
        // called after a button is pressed down
        oldx = e.getX();
        oldy = e.getY();
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    public void mouseReleased( MouseEvent e ) {  // called after a button is released
        isDrawingQuick = false;
        clearScreen();
        repaint();
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved( MouseEvent e ) {  // called during motion when no buttons are down
    }

    /**
     * Clear screen.
     */
    private void clearScreen() {
        Rectangle r = gr.getClipBounds();
        gr.setColor(getBackground());
        gr.fillRect(r.x, r.y, r.width, r.height);
    }

    /* (non-Javadoc)
     * @see java.awt.Container#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
        gr = g;
        AWTEngine ae = new AWTEngine(g);
        clearScreen();
        if (isDrawingQuick)
            ae.quickDraw(struc);
        else
            ae.draw(struc);
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    public void mouseClicked(MouseEvent e) {
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
        /*        double k = 0.003;
                int dx, dy;
                dx = e.getX() - oldx;
                dy = e.getY() - oldy;
                oldx += dx;
                oldy += dy;
                struc.getScreenSpace().rotateX(k * dx);
                struc.getScreenSpace().rotateY(k * dy);
                isDrawingQuick = true;
        */
        clearScreen();
        repaint();
    }

    /**
     * The main method.
     *
     * @param s command line arguments
     */
    public static void main(String s[]) {
        JFrame f = new JFrame("");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet = new AWTApplet();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(300, 200));
        f.setVisible(true);
    }
}
