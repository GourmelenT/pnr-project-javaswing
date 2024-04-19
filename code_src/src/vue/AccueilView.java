package vue;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.plaf.nimbus.*;

public class AccueilView extends JFrame {
    JPanel header; // Tete de la page
    JPanel contenu; // Centre de la page
    JLabel titre;
    JButton utilisateurs;
    JButton visualiser;
    JButton ajouter;

    public AccueilView(){
        setSize(1940,1080);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                int clickMe = JOptionPane.showConfirmDialog(AccueilView.this, "Etes-vous sur de vouloir quitter ?", "Fermer", JOptionPane.YES_NO_OPTION); // Affiche une boite question
                if(clickMe == JOptionPane.YES_OPTION)AccueilView.this.dispose();
            }
        });
    
        try {
            // Police d'ecriture            
            Font WC_Mano = Font.createFont(Font.TRUETYPE_FONT, new File("../font/WCManoNegraBoldBta.ttf")).deriveFont(40f);
            Font AVENIR = Font.createFont(Font.TRUETYPE_FONT, new File("../font/Metropolis-Light.otf")).deriveFont(20f);

            // Nouveau panel
            this.header = new JPanel();
            header.setLayout(new BorderLayout());
            this.contenu = new JPanel();


            //Ajout des couleurs
            Color couleur1 = new Color(0,147,110);
            Color couleur2 = new Color(107,172,154);
            Color trans = new Color(Color.TRANSLUCENT);
            header.setBackground(couleur1);

            // Donne une dimension
            header.setSize(new Dimension(1920,240));
            contenu.setSize(new Dimension(1920,1080));
            contenu.setBackground(couleur2);

            // Insertion image
            JPanel PanelIMG = new JPanel ();
            BufferedImage image = ImageIO.read(new File("../image/logo.jpg"));
            JLabel logo = new JLabel(new ImageIcon(image));
            PanelIMG.setBackground(couleur1);
            PanelIMG.add(logo);
            header.add(PanelIMG, BorderLayout.WEST);

            // Titre
            JPanel panelBar = new JPanel(new BorderLayout());
            titre = new JLabel("BASE DE DONNEE Parc Naturel Regional du golf du Morbihan");
            titre.setFont(WC_Mano);  // Donne une police au text titre
            panelBar.add(titre);

            // Bar de menu pour de 
            JPanel bar = new JPanel(new BorderLayout());

            // Bouton utilisateur 
            JPanel paButtonL = new JPanel(new BorderLayout());
            utilisateurs = new JButton("UTILISATEURS");
            utilisateurs.setFont(AVENIR); 
            utilisateurs.setBackground(Color.GRAY);
            utilisateurs.setSize(140,40);
            paButtonL.setBackground(couleur1);
            paButtonL.add(utilisateurs);
            bar.add(paButtonL, BorderLayout.WEST);
            

            JPanel paButtonR = new JPanel();
            visualiser = new JButton("VISUALISER");
            visualiser.setFont(AVENIR);
            visualiser.setBackground(Color.GRAY);
            visualiser.setSize(140,40);
            paButtonR.add(visualiser);

            ajouter = new JButton("AJOUTER");
            ajouter.setFont(AVENIR);
            ajouter.setBackground(Color.GRAY);
            ajouter.setSize(140,40);
            paButtonR.add(ajouter);
            paButtonR.setBackground(couleur1);
            bar.add(paButtonR, BorderLayout.EAST);

            bar.setBackground(couleur1);
            panelBar.setBackground(couleur1);
            panelBar.add(bar, BorderLayout.SOUTH);
            header.add(panelBar);
            add(header);
            add(contenu);
            add(createCenter());

        } catch (IOException e) {
            System.out.println("erreur");
        } catch(FontFormatException f){
            System.out.println("erreur font");
        }
        
    }

    public JPanel createCenter(){
        JPanel panel = new JPanel (new FlowLayout());
        
        JLabel login = new JLabel("Login");
        login.setPreferredSize(new Dimension(60, 20));
        panel.add(login);

        JTextField loginField = new JTextField("Entrer votre pseudo...");
        loginField.setPreferredSize(new Dimension(200, 40));
        panel.add(loginField);

        JLabel password = new JLabel("Password");
        password.setPreferredSize(new Dimension(60, 20));
        panel.add(password);

        JTextField passwordField = new JTextField("Entrer votre mot de passe...");
        passwordField.setPreferredSize(new Dimension(200, 40));
        panel.add(passwordField);

        JButton valider = new JButton("Valider");
        valider.addMouseListener(new MouseAdapter()/*Favorise MouseAdapter()*/{
            public void mouseEntered(MouseEvent e) {
                valider.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                valider.setForeground(Color.BLACK);
            }
        });
        valider.setPreferredSize(new Dimension(140, 40));
        panel.add(valider);
        
        return panel;
    }
    
    public static void main(String[] args) throws Exception { 
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new AccueilView().setVisible(true);
                
            }
        });
    }
}
