import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

/**
 * An illustration of the methods of the Canvas class.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2010.11.30
 */
public class CanvasDemo
{
    private Canvas myCanvas;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;

    /**
     * Create a CanvasDemo object.
     * Creates a fresh canvas and makes it visible.
     */
    public CanvasDemo()
    {
        myCanvas = new Canvas("Canvas Demo", WIDTH, HEIGHT);
        myCanvas.setVisible(true);
    }
    
    /**
     * Demonstrate some of the drawing operations that are
     * available on a Canvas object.
     */
    public void drawDemo()
    {
        myCanvas.setFont(new Font("helvetica", Font.BOLD, 14));
        myCanvas.setForegroundColor(Color.red);

        myCanvas.drawString("We can draw text, ...", 20, 30);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.black);
        myCanvas.drawString("...draw lines...", 60, 60);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawLine(200, 20, 300, 50);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(220, 100, 370, 40);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.green);
        myCanvas.drawLine(290, 10, 320, 120);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawString("...and shapes!", 110, 90);

        myCanvas.setForegroundColor(Color.red);

        // the shape to draw and move
        int xPos = 10;
        Rectangle rect = new Rectangle(xPos, 150, 30, 20);

        // move the rectangle across the screen
        for(int i = 0; i < 200; i ++) {
            myCanvas.draw(rect);
            myCanvas.wait(10);
            myCanvas.eraseOutline(rect);
            xPos++;
            rect.setLocation(xPos, 150);
        }
        // at the end of the move, draw and fill once more so that it remains visible
        myCanvas.fill(rect);
    }

}
