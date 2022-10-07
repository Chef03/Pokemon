package assignment2.windows;
import assignment2.PokeType;
import assignment2.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainScreen extends JFrame {


    private final int HEIGHT = 600;
    private final int WIDTH = 600;
    private final String windowTitle;
    private static final String MYSTERY_IMAGE = "tinyurl.com/5evfwkxn" ;
    private final ArrayList<Pokemon> pokemons;

    public MainScreen(String title) {

        super();
        this.pokemons = new ArrayList<>();
        this.windowTitle = title;
        this.setTitle(this.windowTitle);
        this.setLayout(new GridLayout(0, 5));
        this.setSize(WIDTH, HEIGHT);
        this.addButton();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void addPokemon(Pokemon pokemon) {

        pokemons.add(pokemon);
        this.getContentPane().removeAll();

        for(Pokemon x : this.pokemons) {

            JButton button = new JButton();
            JLabel label = new JLabel();
            try {
                label.setIcon(new ImageIcon(new URL(x.getThumbnailURL())));
            }
            catch(MalformedURLException e) {
                try {
                    label.setIcon(new ImageIcon(new URL(MYSTERY_IMAGE)));
                }
                catch(MalformedURLException exception){
                    System.out.println("mystery icon failed to load");
                }
            }

            label.setText(x.getName());
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);
            button.add(label);
            button.addActionListener(e -> new InfoScreen(x));
            this.add(button);

        }

        this.addButton();
        this.repaint();
        this.setVisible(true);

    }
    public void addButton() {

        Button button =new Button("Add pokemon");
        button.addActionListener(e -> new Prompt(this));
        this.add(button);

    }

}
