import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class krestsNuls extends JFrame{
    //игра крестики нолики, пишу практически поддиктовку тк вообще никак не ориентируюсь в библиотеках которые использую, нам о них ничего не рассказали, сразу с кодинга на них начали... это типа и есть средне специальное образование?
    //хорошо что они прям итоговый файл выкладывают на ряду с основным' материалом... иначе я бы день или 2+ потратил бы на это все... ладненько черпну хоть для типа архива...
    //private String[][] buttonsFieldZnak = new String[3][3];
    public JButton[][] buttons  = new JButton[3][3];
    public JLabel panel = new JLabel("");
    public boolean win = false;
    public void initializ(){
        setupGameBroad();
        //setupButtons();
        setReturn();//🕵️‍♂️
    }
    private void setupGameBroad(){//пока не сильно понимаю прямое назначение отличий привате от публик... видимо а точнее более вероятно что я еще не сталкивался с проблемой...
        //инициализ игрового поля
        int rows = 3;
        int cols = 3;
        //ваще хз ч эт пох я по своему сделаю buttons = new JButton[rows][cols];//нах нам две переменные с одинак занчением?

        // спавн кнопок в 3 строки в 3 столба
        JPanel fieldbuttonPanel = new JPanel(new GridLayout(rows, cols));//тут было тупа просто setLayont(new GridLayont(rows,cols) и внутри типа мне подчеркивало что незя ничо ставить// нах ты его зачеркнул дурак, я иного не шарю, списываю из файла...
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                buttons[i][j] = new JButton("*");
                //buttonsFieldZnak[i][j] = buttons[i][j].getText();
                buttons[i][j].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                buttons[i][j].setMinimumSize(new Dimension(50, 50));
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                buttons[i][j].setMaximumSize(new Dimension(50, 50));
                fieldbuttonPanel.add(buttons[i][j]);
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        JButton clickedButton = (JButton) e.getSource();
                        if ((clickedButton.getText().equals("*"))) {
                        clickedButton.setText("X");
                        if (!(win)){chekWinner(buttons);}
                        compOxod(buttons);                    
                        }
                    }
                });
            }
        }
        add(fieldbuttonPanel, BorderLayout.NORTH);//🧩🧩🧩
    }
    private void compOxod(JButton[][] buttons){
        Random random = new Random();
        int randomCol = random.nextInt(3);
        int randomRow = random.nextInt(3);
        if (!(buttons[randomRow][randomCol].getText().equals("*"))) {
            compOxod(buttons);
        }
        else{
            buttons[randomRow][randomCol].setText("O");
            if (!(win)){chekWinner(buttons);}
        }
    }
    // private void setupButtons(){
    //     //кнопки?
    //     JPanel xodbuttoPanel = new JPanel(new GridLayout(1, 2));
    //     JButton crossButton = new JButton("X");
    //     JButton circleButton = new JButton("O");
    //     xodbuttoPanel.add(crossButton);
    //     xodbuttoPanel.add(circleButton);
    //      //там в ФОТОГРАФИИ файла вообще какойто пиздец там ваще джапплет и типа два файла с одинаковым названием один джапплет другой джфрейм бляяяяяяя
    //     add(xodbuttoPanel, BorderLayout.SOUTH);
    // }
       
            private void setReturn(){
            JPanel xodbuttoPanel = new JPanel(new GridLayout(1, 1));
            JButton ButtonZanovo = new JButton("Заново?");
            xodbuttoPanel.add(ButtonZanovo);
            add(xodbuttoPanel, BorderLayout.SOUTH);
            ButtonZanovo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    restartX();
                }
            });
        }
        public void restartX(){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("*");  
                }
            }
            panel.setText("");
            win=false;
        }

    public krestsNuls(){
        setTitle("Confrimation Dialog App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180, 350);
        //setupButtons();
        //setupGameBroad();
        initializ();
        
        add(panel,BorderLayout.CENTER);
        setVisible(true);
        
    }
    public void chekWinner(JButton[][] buttons){
        for (int i = 0; i < buttons.length; i++) {
            //горизонтали
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText()) && !(buttons[i][0].getText().equals("*"))) {
                win = true;
                panel.setText("побеитель : "+ buttons[i][0].getText()); // Пометить победителя, если есть
                break;
            }
    
            //вертикали
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()) && !(buttons[0][i].getText().equals("*"))) {
                win = true;
                panel.setText("побеитель : "+ buttons[0][i].getText()); // Пометить победителя, если есть
                break;
            }
        }
    // мы с нейронкой старались, я думал она писала как я думаю... я серьезно через форы я предложил и пример привел, ток с диагоналями не получилось
        //диагонали
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !(buttons[1][1].getText().equals("*"))) {
            win = true;
            panel.setText("побеитель : "+ buttons[0][0].getText()); // Пометить победителя, если есть
        } else if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !(buttons[1][1].getText().equals("*"))) {
            win = true;
            panel.setText("побеитель : "+ buttons[0][2].getText()); // Пометить победителя, если есть
        }
          
        
       if (!(win)) {
        panel.setText("нет победителя");
       }
        
    }
    // public void changePanelText(String winner){
    //     panel.setText(""+ winner);
    // }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new krestsNuls();
            }
        });
    }

}