import javax.swing.*;
import java.awt.*;

public class PianoKeyboard extends JFrame {

    private static final int KEYBOARD_WIDTH = 1000;
    private static final int KEYBOARD_HEIGHT = 150;
    private static final int WHITE_KEY_WIDTH = 20;
    private static final int WHITE_KEY_HEIGHT = KEYBOARD_HEIGHT;
    private static final int BLACK_KEY_WIDTH = WHITE_KEY_WIDTH / 2;
    private static final int BLACK_KEY_HEIGHT = KEYBOARD_HEIGHT / 2;
    private static final int WHITE_KEY_COUNT = 52;
    private static final int BLACK_KEY_COUNT = 36;
    private int currentNote = -1; // -1 indicates no note is currently played


    public PianoKeyboard() {
        super("Piano Keyboard");
        setSize(KEYBOARD_WIDTH, KEYBOARD_HEIGHT);
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
        int whiteKeyWidth = KEYBOARD_WIDTH / WHITE_KEY_COUNT;

        // Draw white keys
        for (int i = 0; i < WHITE_KEY_COUNT; i++) {
            int x = i * whiteKeyWidth;
            if (i == currentNote) {
                g.setColor(Color.CYAN); // highlight the currently played note
            }
            else {
                g.setColor(Color.WHITE);
            }
            // g.setColor(Color.WHITE);
            g.fillRect(x, 0, whiteKeyWidth, WHITE_KEY_HEIGHT);
            g.setColor(Color.BLACK);
            g.drawRect(x, 0, whiteKeyWidth, WHITE_KEY_HEIGHT);
        }

        // Draw black keys
        int[] blackKeyX = {whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                3 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 4 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                6 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 7 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 8 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                10 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 11 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                13 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 14 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 15 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                17 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 18 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                20 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 21 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 22 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                24 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 25 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                27 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 28 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 29 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                31 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 32 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                34 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 35 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 36 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                38 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 39 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                41 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 42 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 43 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                45 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 46 * whiteKeyWidth - BLACK_KEY_WIDTH / 2,
                48 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 49 * whiteKeyWidth - BLACK_KEY_WIDTH / 2, 50 * whiteKeyWidth - BLACK_KEY_WIDTH / 2};

        for (int i = 0; i < BLACK_KEY_COUNT; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(blackKeyX[i], 0, BLACK_KEY_WIDTH, BLACK_KEY_HEIGHT);
        }
    }

    public void setCurrentNote(int note) {
        currentNote = note;
        repaint(); // trigger a repaint to update the highlighting
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PianoKeyboard());
    }
}
