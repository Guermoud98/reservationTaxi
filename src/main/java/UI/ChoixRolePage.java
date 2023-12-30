package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoixRolePage extends JFrame {
    public ChoixRolePage() {
        // Configuration de la fenêtre
        setTitle("Application de Resérvation d'un Taxi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chargement de l'image en arrière-plan
        ImageIcon backgroundIcon = new ImageIcon("carImage.png"); // Remplacez "background_image.jpg" par le chemin de votre image
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        setContentPane(backgroundLabel);

        // Texte "Choisir votre rôle"
        JLabel label = new JLabel("Choisir votre rôle");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        // Bouton "Conducteur"
        JButton conducteurButton = new JButton("Conducteur");
        conducteurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton "Conducteur" est cliqué
                System.out.println("Bouton Conducteur cliqué");
            }
        });

        // Bouton "Passager"
        JButton passagerButton = new JButton("Passager");
        passagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton "Passager" est cliqué
                System.out.println("Bouton Passager cliqué");
            }
        });

        // Ajout des composants à la fenêtre
        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));
        backgroundLabel.add(Box.createVerticalGlue());
        backgroundLabel.add(label);
        backgroundLabel.add(Box.createVerticalStrut(20));
        backgroundLabel.add(conducteurButton);
        backgroundLabel.add(Box.createVerticalStrut(10));
        backgroundLabel.add(passagerButton);
        backgroundLabel.add(Box.createVerticalGlue());

        // Affichage de la fenêtre
        setVisible(true);
    }


}

