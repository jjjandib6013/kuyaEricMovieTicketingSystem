import javax.swing.*;
import java.util.ArrayList;

public class PaymentWindow {
    JFrame frame = new JFrame("Payment");
    JTextField cardNumberField = new JTextField();
    JTextField nameField = new JTextField();
    JPasswordField cvvField = new JPasswordField();
    JButton payButton = new JButton("Pay");
    JLabel totalLabel = new JLabel();
    double totalAmount;

    public PaymentWindow(String movie, ArrayList<String> seats, double totalAmount) {
        this.totalAmount = totalAmount;

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 50, 100, 25);
        cardNumberField.setBounds(150, 50, 150, 25);

        JLabel nameLabel = new JLabel("Name on Card:");
        nameLabel.setBounds(50, 100, 100, 25);
        nameField.setBounds(150, 100, 150, 25);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(50, 150, 100, 25);
        cvvField.setBounds(150, 150, 50, 25);

        totalLabel.setText("Total: Php" + totalAmount);
        totalLabel.setBounds(50, 200, 200, 25);

        payButton.setBounds(150, 230, 100, 25);
        payButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Payment successful! Enjoy your movie.");
            frame.dispose();
        });

        frame.add(cardNumberLabel);
        frame.add(cardNumberField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(cvvLabel);
        frame.add(cvvField);
        frame.add(totalLabel);
        frame.add(payButton);

        frame.setVisible(true);
    }
}
