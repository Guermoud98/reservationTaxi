package UI;

import Business.*;
import DAO.IClientDAO;
import DAO.IClientDAOImplement;
import Session.ClientConnecte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ReservationPage extends JFrame {
    public ReservationPage() {
       /* setTitle("Page de Reservation");
        setSize(800, 600);
        JLabel label = new JLabel("BIENVENUE");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        setBackground(Color.black);
        // Ajout du label à la fenêtre
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);

        // Rendre la fenêtre visible
        setVisible(true);*/

            JFrame frame = new JFrame("Application de réservation de Taxi");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran

            JPanel panel = new JPanel(new GridBagLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    setBackground(Color.black);
                    //ImageIcon imageIcon = new ImageIcon("background.png");
                   // Image image = imageIcon.getImage();
                    //int x = getWidth() - image.getWidth(null); // Positionner l'image à droite
                   // int y = 0; // Modifier la position verticale de l'image (0 pour l'aligner en haut)
                   // g.drawImage(image, x, y, null);
                }
            };


            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Espacement entre les composants

            JLabel welcomeLabel = new JLabel("Hello!");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Agrandir la taille de la police
            welcomeLabel.setForeground(Color.WHITE);

            JLabel sourceLabel = new JLabel("Lieu de départ:");
            sourceLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Agrandir la taille de la police
            sourceLabel.setForeground(Color.WHITE);
            JTextField sourceField = new JTextField(20);
            sourceField.setPreferredSize(new Dimension(200, 30));
            sourceField.setFont(new Font("Arial", Font.BOLD, 16)); // Ajustez la taille de la police


            JLabel destinationLabel = new JLabel("Lieu de destination:");
            destinationLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Agrandir la taille de la police
            destinationLabel.setForeground(Color.WHITE);
            JTextField destinationField = new JTextField(20);
            destinationField.setPreferredSize(new Dimension(200, 30));
            destinationField.setFont(new Font("Arial", Font.BOLD, 16)); // Ajustez la taille de la police










            JButton reserveButton = new JButton("Réserver");
            reserveButton.setFont(new Font("Arial", Font.BOLD, 16)); // Agrandir la taille de la police

            JButton cancelButton = new JButton("Annuler");
            cancelButton.setFont(new Font("Arial", Font.BOLD, 16)); // Agrandir la taille de la police

            reserveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String source = sourceField.getText();
                    String destination = destinationField.getText();

                    // Créez un objet Client avec des valeurs fictives (à remplacer par la logique de récupération du client)
                    IClientDAO client = new IClientDAOImplement();
                    Client c = new Client();
                    c = (Client) client.getPersonneById(ClientConnecte.getClientId());
                    // Construisez le message pour afficher dans la boîte de dialogue
                    String message = "Détails de la réservation :\n\n" +
                            "Lieu de départ: " + source + "\n" +
                            "Lieu de destination: " + destination + "\n" +
                            "Confirmer la réservation ?";

                    // Affichez la boîte de dialogue avec les détails de la réservation
                    int choice = JOptionPane.showConfirmDialog(null, message, "Confirmation de Réservation", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        // Effectuez la réservation
                        GestionReservation gestionReservation = new GestionReservation();
                        gestionReservation.Reserver(source, destination, c);
                            // Si la réservation a réussi
                            String msg = "tarif sera : "+gestionReservation.CalculTarifEnFctDistance(source,destination)+"DH";
                            JOptionPane.showMessageDialog(null, "Réservation effectuée avec succès !\n"+msg);
                        } else {
                            // Si la réservation a échoué
                            JOptionPane.showMessageDialog(null, "Désolé, aucun taxi disponible pour le moment. Veuillez réessayer plus tard.");
                        }
                    }

            });


            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sourceField.setText("");
                    destinationField.setText("");
                }
            });

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            panel.add(welcomeLabel, gbc);

            gbc.gridy = 1;
            gbc.gridwidth = 1;
            panel.add(sourceLabel, gbc);

            gbc.gridx = 1;
            panel.add(sourceField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(destinationLabel, gbc);

            gbc.gridx = 1;
            panel.add(destinationField, gbc);


            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            panel.add(reserveButton, gbc);

            gbc.gridx = 1;
            panel.add(cancelButton, gbc);

            frame.getContentPane().add(panel);
            frame.setVisible(true);

    }
}
