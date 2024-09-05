package java_interesting;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MatrixRain extends JPanel {
    private final Random random = new Random();
    private final String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Устанавливаем черный фон
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        int c = 0;
        g.setColor(new Color(0, 255, 0));// Зеленый цвет
        // Рисуем символы
        for (int i = 0; i < getWidth() / 10; i++) {
            c++;
            //координаты снизу
            g.drawString(String.valueOf(c), i * 20, getHeight());
            // g.drawString(String.valueOf(i), i * 20, getHeight()-10);


            // createPlate(g,i);


            if (random.nextInt(2)==1) {

                createChain(i,g,c);

            }
            // continuationChain();


            //доcreate chain


            


            // int x = i * 20;

            
            // int y = random.nextInt(getHeight());//высота
            // char symbol = symbols.charAt(random.nextInt(symbols.length()));
            // g.drawString(String.valueOf(symbol), x, y);
        }
    }
    

    protected void createPlate(Graphics g,int i){


    }
    protected void createChain(){}

    public void createChain(int i, Graphics g,int c){
        int x = i * 10;
        int y = random.nextInt(10,50);//getHeight());//высота
        char symbol = '1';//symbols.charAt(random.nextInt(symbols.length()));
        g.drawString(String.valueOf(symbol), x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Matrix Rain");
        MatrixRain matrixRain = new MatrixRain();
        frame.add(matrixRain);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Timer для обновления анимации
        new Timer(150, e -> {
            matrixRain.repaint();
        }).start();
    }
}
