package java_interesting.MR;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class mr2 extends JPanel {
    private final Random random = new Random();
    private final String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final ArrayList<SymbolCoords> symbolsList = new ArrayList<>();
    private final boolean[] SIIK = new boolean[40];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(0, 255, 0));

        for (SymbolCoords coord : symbolsList) {
            g.drawString(coord.symbol, coord.x, coord.y);
        }
    }

    public void updateSymbols() {
        for (int i = 0; i < getWidth() / 10; i++) {
            int ik2 = random.nextInt(100);

            // Логика обновления символов
            // Замените на свою реализацию

            if (ik2 < 40 && SIIK[i]) {
                SIIK[i] = false;
                String symbol = String.valueOf(symbols.charAt(random.nextInt(symbols.length())));
                symbolsList.add(new SymbolCoords(symbol, i * 20, 15));
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Matrix Rain");
        MatrixRain matrixRain = new MatrixRain();
        frame.add(matrixRain);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Timer(150, e -> {
            matrixRain.updateSymbols();
            matrixRain.repaint();
        }).start();
    }
}

class SymbolCoords {
    String symbol;
    int x;
    int y;

    SymbolCoords(String symbol, int x, int y) {
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }
}
