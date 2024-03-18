package futureCode.blok_3.pract3_3;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clicer extends JFrame {
    public int ClicCount;
    public JLabel panel = new JLabel("результат : " + ClicCount);
    public JButton clicButton = new JButton("кликай");
    public int getCount() {
        return ClicCount;
    }
    public JLabel getPanel() {
        return panel;
    }
    public JButton getCliButton() {
        return clicButton;
    }

    public clicer() {
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
            ClicCount++;
            updateTEXT();
        }
    };

    public void updateTEXT() {
        panel.setText("результат : " + ClicCount);
        clicButton.setText("" + ClicCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new clicer();
            }
        });
    }
}