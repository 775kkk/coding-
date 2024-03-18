package futureCode.blok_3.pract3_5;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import org.w3c.dom.events.MouseEvent;
public class _MouseAdapter_nulltrucatch extends MouseAdapter{
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
        // относится как возможная часть решения к vasted_daughter_TextConfrim
        // бршено
        }
}

