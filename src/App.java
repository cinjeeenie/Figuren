import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

    public static void main(String[] args) {
        // Array um die Figuren zu speichern
        Figur[] figuren = new Figur[10];
        // fünf Personen und fünf Katzen erstellen
        for (int i = 0; i < 5; i++) {
            figuren[i] = new Person();
            figuren[i + 5] = new Cat();
        }

        // Sortieren der Figuren nach der Höhe
        Arrays.sort(figuren, new Comparator<Figur>() {
            @Override
            public int compare(Figur f1, Figur f2) {
                return Integer.compare(f1.getHeight(), f2.getHeight());
            }
        });

        // Erstellen eines JFrames und JPanels
        JFrame frame = new JFrame();
        int spaceBetweenFigurs = (int) (Math.random() * (15 - 5 + 1) + 5);
        int totalWidthPanel = spaceBetweenFigurs * (figuren.length + 1);
        int maxHeightPanel = 0;

        for (Figur f : figuren) {
            totalWidthPanel += f.getWidth();
            if (f.getHeight() > maxHeightPanel) {
                maxHeightPanel = f.getHeight();
            }
        }

        int finalMaxHeightPanel = maxHeightPanel;
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int offsetLeft = spaceBetweenFigurs;
                for (Figur f : figuren) {
                    f.paintOnGraphics(g, offsetLeft, finalMaxHeightPanel);
                    offsetLeft += spaceBetweenFigurs + f.getWidth();
                }
            }

        };

        panel.setPreferredSize(new Dimension(totalWidthPanel, maxHeightPanel));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}