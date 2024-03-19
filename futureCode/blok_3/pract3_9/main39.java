package futureCode.blok_3.pract3_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main39 extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;

    public main39(){
        setTitle("Простой чат-бот");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(new InputFieldActionListener());
        add(inputField, BorderLayout.SOUTH);
    }

    //АШАЛЕТЬ ЭТО ЧЕ РЕАЛЬНО ВНУТРЕННИЙ КЛАСС??
    private class InputFieldActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String userInput = inputField.getText();
            chatArea.append("Вы :"+userInput+"\n");
            String botResponse = getBotResponse(userInput);
            chatArea.append("Бот: "+botResponse+"\n");
            inputField.setText("");
        }
    }
    
    private String getBotResponse(String a){
        a=a.toLowerCase();
        if (a.contains("1")) {
            return "1 succsesful";
        }else{
            return "sory i ne ponymay";
        }
        // тут ответы заскриптованные
    }

    //Запуск
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            new main39().setVisible(true);
        }
    });
    }


}
