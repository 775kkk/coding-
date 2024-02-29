package futureCode.pract3_5;


import javax.swing.JOptionPane;
import org.w3c.dom.events.MouseEvent;
// ❗️  ❗️  ❗️ ВАЖНО ❗️  ❗️  ❗️ 
// ❗️Почемуто отображается криво, растяните окно❗️ 
//
import java.awt.event.MouseAdapter;
import futureCode.pract3_3.TextConfrim;
public class vasted_daughter_TextConfrim extends TextConfrim {
   // clicButton.addMouseListener(adapter);
   MouseAdapter adapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try{//тут
                if (textt.getText().equals("")) {
                    throw new NULLinputException("");
                }
            JOptionPane.showMessageDialog(null, "Ты ввел : " + textt.getText());
            }catch(NULLinputException a){
                JOptionPane.showMessageDialog(null,"Ты ничего не ввел");
            }
        
        }
// ❗️❗️❗️ КАРОЧЕ ЭТОТ АДАПТЕР ЕМАЕ НИКАК НЕ ИЗМЕНИТЬ ЧЕРЕЗ ДОЧЕРНИЙ ФАЙЛ❗️❗️❗️


        
    };
    public void mouseClicked(MouseEvent e) {
            try{//тут
                if (textt.getText().equals("")) {
                    throw new NULLinputException("");
                }
            JOptionPane.showMessageDialog(null, "Ты ввел : " + textt.getText());
            }catch(NULLinputException a){
                JOptionPane.showMessageDialog(null,"Ты ничего не ввел");
            }
        }
    
    



    public static void main(String[] args) {
        vasted_daughter_TextConfrim TextConfrim = new vasted_daughter_TextConfrim();
        
    }
}
