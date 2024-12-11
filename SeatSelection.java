import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatSelection {
    JFrame frame = new JFrame("Seat Selection");
    ArrayList<String> selectedSeats = new ArrayList<>();
    JButton[] seatButtons = new JButton[20];
    int tickets;

    public SeatSelection(String movie, int tickets) {
        this.tickets = tickets;

        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(4, 5, 10, 10));

        for (int i = 0; i < 20; i++) {
            seatButtons[i] = new JButton("Seat " + (i + 1));
            int index = i;
            seatButtons[i].addActionListener(e -> {
                if (selectedSeats.size() < tickets) {
                    selectedSeats.add("Seat " + (index + 1));
                    seatButtons[index].setEnabled(false);
                    if (selectedSeats.size() == tickets) {
                        frame.dispose();
                        new PaymentWindow(movie, selectedSeats, tickets * 200);
                    }
                }
            });
            frame.add(seatButtons[i]);
        }

        frame.setVisible(true);
    }
}
