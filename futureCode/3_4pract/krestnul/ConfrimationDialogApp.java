package krestnul;
import javax.swing.*;
import java.awt.*;

public class ConfrimationDialogApp extends JApplet{
    //игра крестики нолики, пишу практически поддиктовку тк вообще никак не ориентируюсь в библиотеках которые использую, нам о них ничего не рассказали, сразу с кодинга на них начали... это типа и есть средне специальное образование?
    //хорошо что они прям итоговый файл выкладывают на ряду с основным' материалом... иначе я бы день или 2+ потратил бы на это все... ладненько черпну хоть для типа архива...
    private JButton[][] buttons;
    public void initializ(){
        setupGameBroad();
        setupButtons();
    }
    @SuppressWarnings("removal")
    private void setupGameBroad(){//пока не сильно понимаю прямое назначение отличий привате от публик... видимо а точнее более вероятно что я еще не сталкивался с проблемой...
        //инициализ игрового поля
        int rows = 3;
        int cols = 3;
        buttons = new JButton[rows][cols];//нах нам две переменные с одинак занчением?

        // спавн кнопок в 3 строки в 3 столба
        setLayout(new GridBagLayout(rows, cols));// нах ты его зачеркнул дурак, я иного не шарю, списываю из файла...
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j]=new JButton();
                add(buttons[i][j]);
            }
        }
    }

    private void setupButtons(){
        //кнопки?
        JButton crossButton = new JButton("X");
        JButton circleButton = new JButton("O");
        add(crossButton);
        add(circleButton);
         
    }

}