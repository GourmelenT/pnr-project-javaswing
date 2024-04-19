package loginPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.*;
import javax.swing.text.FlowView;

public class Graphique extends JFrame{

    public Graphique() {
    super("Une interface d'enfer");

    this.setSize(600, 400);                         // Donne une taille a ma fenetre
    this.setLocationRelativeTo(null);               // Centre la fenetre
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Ferme ma fenetre
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent event) {
            int clickMe = JOptionPane.showConfirmDialog(Graphique.this, "Etes-vous sur de vouloir quitter ?", "Fermer", JOptionPane.YES_NO_OPTION); // Affiche une boite question
            if(clickMe == JOptionPane.YES_OPTION)Graphique.this.dispose();
        }
    });

    JPanel contentPane = (JPanel) this.getContentPane();  // La fenetre

    contentPane.add(createCenter());
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


   public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Graphique().setVisible(true);
            }
        });
    }

}

