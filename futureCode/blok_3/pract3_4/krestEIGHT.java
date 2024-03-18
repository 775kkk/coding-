package futureCode.blok_3.pract3_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class krestEIGHT extends JFrame{
    public JButton[][] buttons  = new JButton[8][8];
    public JLabel panel = new JLabel("");
    public boolean win = false;
    public void initializ(){
        setupGameBroad();
        setReturn();
    }
    private void setupGameBroad(){
        //инициализ игрового поля
        int rows = 8;
        int cols = 8;
        JPanel fieldbuttonPanel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                buttons[i][j] = new JButton("*");
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
        add(fieldbuttonPanel, BorderLayout.NORTH);
    }
    private void compOxod(JButton[][] buttons){
        Random random = new Random();
        int randomCol = random.nextInt(8);
        int randomRow = random.nextInt(8);
        if (!(buttons[randomRow][randomCol].getText().equals("*"))) {
            compOxod(buttons);
        }
        else{
            buttons[randomRow][randomCol].setText("O");
            if (!(win)){chekWinner(buttons);}
        }
    }
   
       
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
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttons[i][j].setText("*");  
                }
            }
            panel.setText("");
            win=false;
        }

    public krestEIGHT(){
        setTitle("Confrimation Dialog App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 700);
        initializ();
        
        add(panel,BorderLayout.CENTER);
        setVisible(true);
        
    }
    public void chekWinner(JButton[][] buttons){
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length-2; j++){
            //горизонтали
            if (buttons[i][j].getText().equals(buttons[i][j+1].getText()) && buttons[i][j+1].getText().equals(buttons[i][j+2].getText()) && !(buttons[i][j].getText().equals("*"))) {
                win = true;
                panel.setText("побеитель : "+ buttons[i][j].getText()); 
                break;
            }
    
            //вертикали
            if (buttons[j][i].getText().equals(buttons[j+1][i].getText()) && buttons[j+1][i].getText().equals(buttons[j+2][i].getText()) && !(buttons[j][i].getText().equals("*"))) {
                win = true;
                panel.setText("побеитель : "+ buttons[j][i].getText()); 
                break;
            }
        }}
        //диагонали
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !(buttons[1][1].getText().equals("*"))) {
            win = true;
            panel.setText("побеитель : "+ buttons[0][0].getText()); 
        } else if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !(buttons[1][1].getText().equals("*"))) {
            win = true;
            panel.setText("побеитель : "+ buttons[0][2].getText()); 
        }
          
        
       if (!(win)) {
        panel.setText("нет победителя");
       }
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new krestEIGHT();
            }
        });
    }

}