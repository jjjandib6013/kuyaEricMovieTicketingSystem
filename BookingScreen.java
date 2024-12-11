import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BookingScreen {
    JFrame frame = new JFrame("Booking Screen");
    JTextField buyerField = new JTextField();
    JSpinner ticketSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    JLabel totalLabel = new JLabel("Total: Php0");
    JButton seatSelectButton = new JButton("Select Seats");

    public BookingScreen(String movie) {
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel buyerLabel = new JLabel("Buyer Name:");
        buyerLabel.setBounds(50, 50, 100, 25);
        buyerField.setBounds(150, 50, 150, 25);

        JLabel ticketLabel = new JLabel("Tickets:");
        ticketLabel.setBounds(50, 100, 100, 25);
        ticketSpinner.setBounds(150, 100, 50, 25);

        totalLabel.setBounds(50, 150, 200, 25);

        seatSelectButton.setBounds(50, 200, 150, 25);
        seatSelectButton.addActionListener(e -> {
            frame.dispose();
            new SeatSelection(movie, (int) ticketSpinner.getValue());
        });

        frame.add(buyerLabel);
        frame.add(buyerField);
        frame.add(ticketLabel);
        frame.add(ticketSpinner);
        frame.add(totalLabel);
        frame.add(seatSelectButton);
        frame.setVisible(true);

        ticketSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int tickets = (int) ticketSpinner.getValue();
                totalLabel.setText("Total: Php" + (tickets * 200));
            }
        });
    }
}
    