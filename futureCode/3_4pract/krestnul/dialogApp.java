package krestnul;
import javax.swing.*;
import java.awt.*;
import krestnul.ConfrimationDialogApp.*;// ёйоу я сам придумал подключить тк в файле непонятно один ли это файл или нет xD))
public class dialogApp extends JFrame{
    private JButton[][] buttons;
    public dialogApp(){
        setTitle("Confrimation Dialog App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupGameBroad();
        setupButtons();
        pack();
    }
    
}
