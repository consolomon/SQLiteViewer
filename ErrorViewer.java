package viewer;

import javax.swing.*;
import java.awt.*;

public class ErrorViewer extends JFrame {

    private JLabel errorText;
    private JButton okButton;

    public ErrorViewer(String message) {

        setTitle("Message");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        setResizable(false);
        setLocationRelativeTo(null);



        errorText = new JLabel(message);
        errorText.setPreferredSize(new Dimension(200, 90));

        add(errorText, BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(90, 30));

        add(okButton);

        setVisible(true);

        okButton.addActionListener(actionEvent -> {
            this.dispose();
        });


    }
}
