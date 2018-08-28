import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * Class BallDemo - provides a demonstration of the
 * BouncingBall and Canvas classes. 
 *
 * @author Felipe Douglas
 * @version 2018.08.27
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;

    /**
     * Create a BallDemo object.
     * Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WIDTH, HEIGHT);
        myCanvas.setVisible(true);
    }
 
    /**
     * Simulate x bouncing balls
     */
    public void bounce(int balls)
    {
        Dimension size = myCanvas.getSize();
        int DimX = 20;
        int DimY = 20;
        int ground = size.height - (2*DimY) - 5;   // position of the ground line
        int xStart = DimX;    // x-start of the ground line
        int xLimit = size.width - (DimX);   // x-limit of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(xStart, ground, xLimit, ground);

        // crate and show the balls
        if(balls > 0)
        {
            ArrayList<BouncingBall> bolas = new ArrayList<BouncingBall>();
            Color[] array = {Color.blue, Color.red, Color.pink, Color.white, Color.gray, Color.green};
            Random random = new Random();
            for(int i = 0; i < balls; i++)
            {
                int randColor = random.nextInt(6);
                int randX = random.nextInt(size.width);
                int randY = random.nextInt(size.height/2);
                bolas.add(new BouncingBall(randX, randY, 16, array[randColor] , ground, myCanvas));
            }

            // Make them bounce until both have gone beyond the xLimit.
            boolean finished = false;
            while(!finished) 
            {
                myCanvas.wait(50);           // small delay
                Iterator<BouncingBall> it = bolas.iterator();
                while(it.hasNext())
                {
                    BouncingBall ball = it.next();
                    ball.move();      
                    // stop once ball has travelled a certain distance on x axis
                    if(ball.getXPosition() >= size.width - 36)
                    {
                        ball.erase();
                        it.remove();
                        if(it.hasNext())
                        {
                            ball = it.next();
                        }
                    }
                }
                if(bolas.size() == 0)
                {
                    finished = true;
                }
            }
        }
    }
    /**
     * Draws a frame on the canvas.
     * @see Yellow rectangle on the canvas.
     */
    public void drawFrame()
    {
        Dimension size = myCanvas.getSize();
        // Make sure that the canvas has no other frame
        myCanvas.erase();
        int DimX = 20;
        int DimY = 20;
        // Creates Dimension object to save the size of the canvas
        myCanvas.setForegroundColor(Color.black);
        //Creates the frame
        Rectangle frame = new Rectangle(DimX, DimY, size.width - (2*DimX), size.height - (2*DimY));
        // Draws the frame
        myCanvas.draw(frame);
    }
}
