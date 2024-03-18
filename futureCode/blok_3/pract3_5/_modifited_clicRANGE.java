package futureCode.blok_3.pract3_5;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class _modifited_clicRANGE extends JFrame {
    public int ClicCount;
    public JLabel panel = new JLabel("результат : " + ClicCount);
    public JButton clicButton = new JButton("кликай");
    public int maxClic = 7;

    public _modifited_clicRANGE() {
        setTitle("кликер");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(clicButton);
        add(buttonPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

        clicButton.addMouseListener(adapter);
    }

    public MouseAdapter adapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try{
                if (ClicCount>=maxClic) {
                    throw new ClikcException("Слишком много кликов");
                }
            ClicCount++;
            updateTEXT();
        }catch(ClikcException a){
            panel.setText("ОЧЕНЬ много кликов: " + ClicCount);
            clicButton.setText("🛠️");
        }
        }   
    };

    public void updateTEXT() {
        // try{// либо этот либо тот сверху в самом адаптере
        //     if (ClicCount>=7) {
        //         throw new ClikcException("Слишком много кликов");
        //     }
        panel.setText("результат : " + ClicCount);
        clicButton.setText("" + ClicCount);
        // }catch(ClikcException a){
        //     panel.setText("ОЧЕНЬ много кликов: " + ClicCount);
        //     clicButton.setText("🛠️");
        //     clicButton.removeMouseListener(adapter);
        // }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new _modifited_clicRANGE();
            }
        });
    }
}