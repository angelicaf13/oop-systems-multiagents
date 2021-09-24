// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import java.util.Iterator;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Collection;
import javax.swing.JPanel;

class SimulationPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private Collection<GraphicalElement> shapes;
    private int width;
    private int height;
    private Color bgColor;
    
    protected SimulationPanel(final int _width, final int _height, final Color _bgColor) {
        this.bgColor = _bgColor;
        this.width = _width;
        this.height = _height;
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.reset();
    }
    
    protected void reset() {
        this.shapes = new LinkedList<GraphicalElement>();
        this.repaint();
    }
    
    protected void addGraphicalElement(final GraphicalElement e) {
        synchronized (this.shapes) {
            this.shapes.add(e);
        }
        // monitorexit(this.shapes)
        this.repaint();
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(this.bgColor);
        g2d.fillRect(0, 0, this.width, this.height);
        synchronized (this.shapes) {
            for (final GraphicalElement e : this.shapes) {
                e.paint(g2d);
            }
        }
        // monitorexit(this.shapes)
        g2d.dispose();
    }
}
