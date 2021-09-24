// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.Image;

public class ImageElement extends CenteredGraphicalElement
{
    private Image image;
    private double width;
    private double height;
    private ImageObserver observer;
    
    public ImageElement(final int x, final int y, final String fileName, final int width, final int height, final ImageObserver obs) {
        super(x, y);
        this.image = Toolkit.getDefaultToolkit().getImage(fileName);
        this.width = width;
        this.height = height;
        this.observer = obs;
    }
    
    @Override
    public void paint(final Graphics2D g2d) {
        final int imageWidth = this.image.getWidth(this.observer);
        final int imageHeight = this.image.getHeight(this.observer);
        final AffineTransform affineT = AffineTransform.getTranslateInstance(this.getX(), this.getY());
        affineT.concatenate(AffineTransform.getScaleInstance(this.width / imageWidth, this.height / imageHeight));
        g2d.drawImage(this.image, affineT, this.observer);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.image.toString()) + " image";
    }
}
