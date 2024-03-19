
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

        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(new InputFieldActionListener());
        // add(inputField, BorderLayout.SOUTH); (*)

        //добавлено #1 (*){{{{

        JPanel bottomPan = new JPanel(new GridLayout(2, 1));

        JPanel fieldbuttonPanel = new JPanel(new GridLayout(1, 2));

        JButton buttonClearChat = new JButton("Очистить чат");
        buttonClearChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                clearChat();
            }
        });
        // добавлено #2 (**){{{{
            JButton buttonSendMess = new JButton("Отправить");
            buttonSendMess.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    sendMess();
                }
            });

        // }}}}(**) #2    
        add(bottomPan, BorderLayout.SOUTH);
        bottomPan.add(inputField, BorderLayout.NORTH);
        bottomPan.add(fieldbuttonPanel, BorderLayout.SOUTH);
        fieldbuttonPanel.add(buttonClearChat);
        fieldbuttonPanel.add(buttonSendMess);// (**)
            
        // добавлено #3 (***){{{{
            chatArea.setBackground(new Color(50,210,205));
            getContentPane().setBackground(new Color(255,230,180));//#4
              Font forChatArea = new Font("SamsungOne-400", Font.PLAIN,15);
              Font otherFont = new Font("SamsungOne-400", Font.PLAIN,20);
              Font buttFont = new Font("SamsungOne-400", Font.BOLD,20);
            chatArea.setFont(forChatArea);
            inputField.setFont(otherFont);
            inputField.setBackground(new Color(20,184,160));
            buttonClearChat.setFont(buttFont);
            buttonSendMess.setFont(buttFont);
            buttonSendMess.setBackground(new Color(200,255,200));
            buttonClearChat.setBackground(new Color(200,255,200));
        // }}}}(***) #3
        chatArea.setForeground(Color.BLUE);
        inputField.setForeground(new Color(93,0,220));
    }

    private void clearChat(){
        chatArea.setText("");
    }   // }}}}(*) #1

    // добавлено #2 (**){{{{

        // так можно свои new ActionListener() к кнопкам приделывать
    // private class SendButtonActionListener implements ActionListener{
    //     @Override
    //     public void actionPerformed(ActionEvent e){
    //         sendMess();
    //     }
    //}
    
    private void sendMess(){
        String userInput = inputField.getText();
        chatArea.append("Вы :"+userInput+"\n");
        String botResponse = getBotResponse(userInput);
        chatArea.append("Бот: "+botResponse+"\n");
        inputField.setText("");
    }
    // }}}}(**) #2  

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
