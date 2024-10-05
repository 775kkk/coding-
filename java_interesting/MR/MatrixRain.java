package java_interesting.MR;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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

         ArrayList<String[]> RL = new ArrayList<>();
         Boolean[] SIIK = new Boolean[40] ;
         for (int i = 0; i < 40; i++) {
            SIIK[i] = true;
        }

        for (int i = 0; i < getWidth() / 10; i++) {
            // c++;
            //координаты снизу
            // g.drawString(String.valueOf(c), i * 20, getHeight());
            // g.drawString(String.valueOf(i), getWidth(),getHeight() / 20);
            int ik2 = random.nextInt(1,100);
            
                for (String[] row : RL) {

                    int iK = 0;
                    String[] bykva = row[0].split("");
                    for (int j = 0; j < bykva.length; j++) {
                        iK++;
                        g.drawString(bykva[j], Integer.parseInt(row[1]), Integer.parseInt(row[2])-30*j);

                    }
                    if ((iK!=0) && (ik2>70)) {// если вообще была серия то тут мы ее продолжаем или не продожаем
                        row[2]= String.valueOf(Integer.parseInt(row[2])+15);
                        row[0]+=symbols.charAt(random.nextInt(symbols.length()));
                    }else{  
                        SIIK[Integer.parseInt(row[1])/20]=true;
                        // RL.remove(row);
                        //  RL.removeIf(array -> java.util.Arrays.equals(array, stringToRemove));
                    }//если закрываем серию то открываем данный столб для новых
            }
            int sv = random.nextInt(SIIK.length);
            if (ik2<40 && SIIK[sv]){
                SIIK[sv]=false;
                String[] a = {String.valueOf(symbols.charAt(random.nextInt(symbols.length()))),String.valueOf(sv*20),String.valueOf(15)};
                RL.add(a);
            }
        }


// Первичный спавн хаоса 
            // int x = i * 20;
            // int y = random.nextInt(getHeight());//высота
            // char symbol = symbols.charAt(random.nextInt(symbols.length()));
            // g.drawString(String.valueOf(symbol), x, y);
    }

    // почемуто всеравно не работает как надо, символы то накладываются друг над руга то нет, удалять строки о столбах из аррау ваще не надо почемуто
    // обновление не плавное, символыне плывут вниз почемуто а спавнятся пачкой и пропадают пачкой, ну скорее всего это вина самого механизма работы Jframe...
    // крч я побадался и пох...

    public static void main(String[] args) {
        JFrame frame = new JFrame("Matrix Rain");
        MatrixRain matrixRain = new MatrixRain();
        frame.add(matrixRain);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Timer для обновления анимации
        new Timer(400, e -> {
            matrixRain.repaint();
        }).start();
    }


}
