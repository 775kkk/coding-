import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextConfrim extends JFrame {
    JTextField textt = new JTextField();

    public TextConfrim() {
        setTitle("Подтверждение текста");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        JLabel panel = new JLabel("Инпутните текстик");
        add(panel, BorderLayout.WEST);

        textt.setBounds(20, 20, 40, 30);
        add(textt);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        JButton clicButton = new JButton("confrim \u2713");
        buttonPanel.add(clicButton);
        add(buttonPanel, BorderLayout.SOUTH);
        clicButton.addMouseListener(adapter);
    }

    MouseAdapter adapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Ты ввел : " + textt.getText());
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextConfrim();
            }
        });
    }
}