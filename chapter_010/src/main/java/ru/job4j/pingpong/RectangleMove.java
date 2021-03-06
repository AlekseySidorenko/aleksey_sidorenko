package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove | Task Solution: Implement a program flow stopping mechanism [#1019]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.11.2018
 */
public class RectangleMove implements Runnable {

    private final Rectangle rect;

    /**
     * Constructor.
     */
    RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int x = 2;
        int y = 3;
        while (!Thread.currentThread().isInterrupted()) {
            if (this.rect.getX() <= 0 || this.rect.getX() >= 300) {
                x *= -1;
            }
            if (this.rect.getY() <= 0 || this.rect.getY() >= 300) {
                y *= -1;
            }
            this.rect.setX(this.rect.getX() + x);
            this.rect.setY(this.rect.getY() + y);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}