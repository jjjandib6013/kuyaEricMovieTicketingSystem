import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame("Login");
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    ImageIcon i = new ImageIcon("C:/Users/Gabe/Downloads/net.png");

    String[][] loginInfo = {{"user", "password"}, {"admin", "admin123"}};

    public LoginPage() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);

        userLabel.setBounds(50, 50, 100, 25);
        passLabel.setBounds(50, 100, 100, 25);
        userField.setBounds(150, 50, 150, 25);
        passField.setBounds(150, 100, 150, 25);
        loginButton.setBounds(125, 200, 100, 25);
        resetButton.setBounds(225, 200, 100, 25);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(userField);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setIconImage(i.getImage());
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userField.setText("");
            passField.setText("");
        }

        if (e.getSource() == loginButton) {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            boolean isValid = false;
            for (String[] credentials : loginInfo) {
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                frame.dispose();
                new MovieCatalog(); // Ensure MovieCatalog is properly imported and defined
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
