import java.awt.Graphics;
import java.util.Random;

public abstract class Figur {

    // Zufallszahl von 7 bis 16 generieren
    protected final int factor = new Random().nextInt((16 - 7) + 1) + 7;

    // protected damit die Klasse von anderen Klassen geerbt werden kann
    protected int offsetLeft;
    protected int maxHeightPanel;

    // abstrakte Methoden, die in den Unterklassen implementiert werden müssen
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void paintOnGraphics(Graphics g);

    // Methode paintOnGraphics mit drei Parametern
    public void paintOnGraphics(Graphics g, int offsetLeft, int maxHeightPanel) {
        this.offsetLeft = offsetLeft;
        this.maxHeightPanel = maxHeightPanel;
        paintOnGraphics(g);
    }

    public int getFactor() {
        return this.factor;
    }

}
