import java.awt.Graphics;

public class Cat extends Figur {

    private final int mainBodyWidth = 10;
    private final int mainBodyHeight = 4;
    private final int legsWidth = 2;
    private final int legsHeight = 4;
    private final int headRadius = 4;
    private final int earsHeight = 2;
    private final int earsWidth = 2;
    private final int tailWidth = 1;
    private final int tailHeight = 4;

    @Override
    public int getHeight() {
        // Formel aus Angabe
        return (legsHeight + mainBodyHeight + tailHeight) * factor;
    }

    @Override
    public int getWidth() {
        return (int) ((mainBodyWidth + headRadius * 0.75 + tailWidth) * factor);
    }

    @Override
    public void paintOnGraphics(Graphics g) {
        // Hier wird die Katze gezeichnet
        // Zuerst wird der Kopf gezeichnet
        g.fillOval(offsetLeft, maxHeightPanel - (headRadius * factor), headRadius * factor, headRadius * factor);

        // Der Körper wird gezeichnet
        g.fillRect(offsetLeft, maxHeightPanel - (headRadius * factor) - (mainBodyHeight * factor),
                mainBodyWidth * factor, mainBodyHeight * factor);

        // Die Beine werden gezeichnet
        g.fillRect(offsetLeft,
                maxHeightPanel - (headRadius * factor) - (mainBodyHeight * factor) - (legsHeight * factor),
                legsWidth * factor, legsHeight * factor);

        // Der Schwanz wird gezeichnet
        g.drawLine(offsetLeft + (mainBodyWidth * factor),
                maxHeightPanel - (headRadius * factor) - (mainBodyHeight * factor),
                offsetLeft + (mainBodyWidth * factor) + (tailWidth * factor),
                maxHeightPanel - (headRadius * factor) - (mainBodyHeight * factor) - (tailHeight * factor));
    }

}
