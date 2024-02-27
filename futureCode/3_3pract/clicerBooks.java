import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clicerBooks extends JFrame {
    int bookCount = 0;
    JLabel panel = new JLabel("Прочитано : " + bookCount);
    JButton clicButton = new JButton("я точно прочитал одну книгу \u2713");

    public clicerBooks() {
        setTitle("читательский дневник");
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

    MouseAdapter adapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            bookCount++;
            updateTEXT();
        }
    };

    public void updateTEXT() {
        panel.setText("я прочитал : " + bookCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new clicerBooks();
            }
        });
    }
}