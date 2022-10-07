package assignment2.windows;
import assignment2.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class InfoScreen extends JFrame {

    private final Pokemon pokemon;

    InfoScreen(Pokemon pokemon) {

        super("Pokemon Info");
        this.setLayout(new GridLayout(0, 1));
        this.setSize(400, 400);
        this.pokemon = pokemon;
        this.initializeData();
        this.setVisible(true);

    }

    private void initializeData() {

        JLabel label = new JLabel();

        try {
            label.setIcon(new ImageIcon(new URL(this.pokemon.getAnimation())));
        }
        catch(MalformedURLException e) {
                System.out.println("Animation was not found");
        }

        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);

        String info = String.format("<html>Name: %s<br />Type: %s <br /> Skill: %s</html>",
                pokemon.getName(),
                pokemon.getType(),
                pokemon.getSkill() != null ? pokemon.getSkill().getName() : "None"
        );
        JLabel pokemonName = new JLabel(info);
        pokemonName.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(pokemonName);

        JPanel barInfo = new JPanel();
        JLabel barStatus = new JLabel(String.format("HP: %d/%d", pokemon.getCurrentHP(), pokemon.getMAX_HP()));
        barInfo.add(barStatus);

        JProgressBar bar = new JProgressBar();
        bar.setMinimum(0);
        bar.setMaximum(this.pokemon.getMAX_HP());
        bar.setValue(this.pokemon.getCurrentHP());
        barInfo.add(bar);

        this.add(barInfo);


    }

}
