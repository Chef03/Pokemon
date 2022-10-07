package assignment2.windows;

import assignment2.PokeType;
import assignment2.Pokemon;

import javax.swing.*;
import java.awt.*;

public class Prompt extends JFrame {

    private final int HEIGHT = 400;
    private final int WIDTH = 400;
    private final Color BACKGROUND_COLOR = Color.gray;
    private final Font DEFAULT_FONT = new Font("Fira Code", Font.PLAIN, 18);
    private final JTextField nameField;
    private final JTextField hpField;

    private final JComboBox selectBox;
    private final MainScreen MainContainer;

    public Prompt(MainScreen mainContainer) {

        super("Add pokemon");

        this.setFont(DEFAULT_FONT);
        this.setLayout(new GridLayout(0, 1));
        this.setSize(WIDTH, HEIGHT);
        this.nameField = this.addInputField("Name");
        this.hpField = this.addInputField("HP");
        this.selectBox = this.addPokemonTypes(PokeType.values());
        this.initializeAddButton();
        this.MainContainer = mainContainer;
        this.setVisible(true);

    }

    public JTextField addInputField(String label) {

        JPanel panel = new JPanel(new GridLayout(0, 1));
//        panel.setBackground(BACKGROUND_COLOR);
        panel.add(new JLabel(label, SwingConstants.CENTER));
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(100, 100));
        field.setSize(WIDTH, 10);
        panel.add(field);
        this.add(panel);
        return field;


    }

    public JComboBox addPokemonTypes(PokeType[] types) {

        JComboBox<String> box = new JComboBox<>();
        for (PokeType type : types) {
            box.addItem(type.toString());
        }
        this.add(box);
        return box;

    }


    private void initializeAddButton() {

        Button button = new Button("Add");
        button.addActionListener(e -> this.handleAdd());
        this.add(button);

    }

    private void handleAdd() {

        String pokemonName = this.nameField.getText();
        int hp = Integer.parseInt(this.hpField.getText());
        String type = (String) this.selectBox.getSelectedItem();
        this.MainContainer.addPokemon(new Pokemon(pokemonName, hp, type));
        this.dispose();

    }


}
