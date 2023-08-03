import javax.swing.*;
import java.awt.*;

public class PianoKeyboard extends JFrame {

    public PianoKeyboard() {
        super("Piano Keyboard");
        setSize(1200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pianoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawKeyboard(g);
            }
        };
        add(pianoPanel);

        setVisible(true);
    }

    private void drawKeyboard(Graphics g) {
        int totalKeys = 88;
        int whiteKeyCount = 52;
        int blackKeyCount = 36;

        int keyWidth = getWidth() / whiteKeyCount;
        int whiteKeyHeight = getHeight();
        int blackKeyHeight = getHeight() / 2;

        // Draw white keys
        for (int i = 0; i < whiteKeyCount; i++) {
            int x = i * keyWidth;
            g.setColor(Color.WHITE);
            g.fillRect(x, 0, keyWidth, whiteKeyHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, 0, keyWidth, whiteKeyHeight);
        }

        // Draw black keys
        int[] blackKeyX = {keyWidth - keyWidth / 4,
                3 * keyWidth - keyWidth / 4, 4 * keyWidth - keyWidth / 4,
                6 * keyWidth - keyWidth / 4, 7 * keyWidth - keyWidth / 4, 8 * keyWidth - keyWidth / 4,
                10 * keyWidth - keyWidth / 4, 11 * keyWidth - keyWidth / 4,
                13 * keyWidth - keyWidth / 4, 14 * keyWidth - keyWidth / 4, 15 * keyWidth - keyWidth / 4,
                17 * keyWidth - keyWidth / 4, 18 * keyWidth - keyWidth / 4,
                20 * keyWidth - keyWidth / 4, 21 * keyWidth - keyWidth / 4, 22 * keyWidth - keyWidth / 4,
                24 * keyWidth - keyWidth / 4, 25 * keyWidth - keyWidth / 4,
                27 * keyWidth - keyWidth / 4, 28 * keyWidth - keyWidth / 4, 29 * keyWidth - keyWidth / 4,
                31 * keyWidth - keyWidth / 4, 32 * keyWidth - keyWidth / 4,
                34 * keyWidth - keyWidth / 4, 35 * keyWidth - keyWidth / 4, 36 * keyWidth - keyWidth / 4,
                38 * keyWidth - keyWidth / 4, 39 * keyWidth - keyWidth / 4,
                41 * keyWidth - keyWidth / 4, 42 * keyWidth - keyWidth / 4, 43 * keyWidth - keyWidth / 4,
                45 * keyWidth - keyWidth / 4, 46 * keyWidth - keyWidth / 4,
                48 * keyWidth - keyWidth / 4, 49 * keyWidth - keyWidth / 4, 50 * keyWidth - keyWidth / 4};

        for (int i = 0; i < blackKeyCount; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(blackKeyX[i], 0, keyWidth / 2, blackKeyHeight);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PianoKeyboard());
    }
}
