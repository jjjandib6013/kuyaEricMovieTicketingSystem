import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MovieCatalog implements ActionListener {
    JFrame frame = new JFrame("Movie Catalog");
    JTextField searchField = new JTextField(15);
    JButton searchButton = new JButton("Search");
    JPanel moviePanel = new JPanel(new GridLayout(0, 3, 30, 30));
    String[] movies = {"Us", "Batman", "Oppenheimer", "Guardians Of The Galaxy", "Avengers", "Joker"};

    public MovieCatalog() {
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setForeground(Color.WHITE);
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.setBackground(Color.BLACK);

        searchButton.addActionListener(this);

        JLabel topDescription = new JLabel("New on our app");
        topDescription.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        topDescription.setHorizontalAlignment(SwingConstants.CENTER);
        topDescription.setForeground(Color.WHITE);

        moviePanel.setBackground(Color.BLACK);
        populateMovies(movies);

        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.BLACK);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(topDescription, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void populateMovies(String[] movieList) {
        moviePanel.removeAll();
        for (String movie : movieList) {
            JPanel movieCard = createMovieCard(movie);
            moviePanel.add(movieCard);
        }
        moviePanel.revalidate();
        moviePanel.repaint();
    }

    private JPanel createMovieCard(String movieTitle) {
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(200, 300));
        card.setBackground(Color.DARK_GRAY);
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel thumbnail = new JLabel();
        thumbnail.setOpaque(true);
        thumbnail.setBackground(Color.BLACK);
        thumbnail.setForeground(Color.WHITE);
        thumbnail.setHorizontalAlignment(SwingConstants.CENTER); 

        File imageFolder = new File("lib/");

        String expectedFileName = movieTitle + ".jpg";
        File imageFile = new File(imageFolder, expectedFileName);

        if (imageFile.exists()) {
            thumbnail.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
        } else {
            thumbnail.setText("No Image");
        }

        JLabel title = new JLabel(movieTitle, SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));

        card.add(thumbnail, BorderLayout.CENTER);
        card.add(title, BorderLayout.SOUTH);

        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "Selected: " + movieTitle);
                new BookingScreen(movieTitle);
            }
        });

        return card;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = searchField.getText().toLowerCase();
        String[] filteredMovies = java.util.Arrays.stream(movies)
                .filter(movie -> movie.toLowerCase().contains(query))
                .toArray(String[]::new);
        populateMovies(filteredMovies);
    }

    public static void main(String[] args) {
        new MovieCatalog();
    }
}
