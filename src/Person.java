import java.awt.Graphics;

public class Person extends Figur {

    private final int mainBodyWidth = 10;
    private final int mainBodyHeight = 10;
    private final int legsWidth = 4;
    private final int legsHeight = 10;
    private final int headRadius = 6;
    private final int neckWidth = 4;
    private final int neckHeight = 4;
    private final int armsHeight = 8;
    private final int armsWidth = 3;

    @Override
    public int getHeight() {
        // Formel aus Angabe
        return (int) ((legsHeight + mainBodyHeight + headRadius * 0.75 + neckHeight) * factor);
    }

    @Override
    public int getWidth() {
        return (armsWidth * 2 + mainBodyWidth) * factor;

    }

    @Override
    public void paintOnGraphics(Graphics g) {
        // Hier wird die Person gezeichnet
        // Zuerst wird der Kopf gezeichnet
        g.fillOval(offsetLeft, maxHeightPanel - (headRadius * factor), headRadius * factor,
                (int) (headRadius * factor * 0.75));

        // Der Hals wird gezeichnet
        g.fillRect(offsetLeft, maxHeightPanel - (headRadius * factor) - (neckHeight * factor), neckWidth * factor,
                neckHeight * factor);

        // Die Arme werden gezeichnet
        g.fillRect(offsetLeft - armsWidth * factor,
                maxHeightPanel - (headRadius * factor) - (neckHeight * factor) - (mainBodyHeight * factor),
                armsWidth * 2 * factor, armsHeight * factor);

        // Der Körper wird gezeichnet
        g.fillRect(offsetLeft,
                maxHeightPanel - (headRadius * factor) - (neckHeight * factor) - (mainBodyHeight * factor),
                mainBodyWidth * factor, mainBodyHeight * factor);

        // Die Beine werden gezeichnet
        g.fillRect(offsetLeft, maxHeightPanel - (headRadius * factor) - (neckHeight * factor)
                - (mainBodyHeight * factor) - (legsHeight * factor), legsWidth * factor, legsHeight * factor);
    }
}
