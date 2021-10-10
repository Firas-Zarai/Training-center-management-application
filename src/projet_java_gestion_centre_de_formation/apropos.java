package projet_java_gestion_centre_de_formation;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;


public class apropos extends JComponent implements ActionListener{
  JDialog F=new JDialog();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  JButton jButton1 = new JButton();
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JButton retour = new JButton();
  public apropos() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    titledBorder3 = new TitledBorder("");
    this.setBackground(UIManager.getColor("TextArea.selectionBackground"));
    this.setDoubleBuffered(true);
    this.setOpaque(true);
    this.setLayout(null);
    jPanel1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
    jPanel1.setEnabled(true);
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(36, 8, 382, 283));
    jPanel1.setLayout(null);
    jButton1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
    jButton1.setBackground(SystemColor.desktop);
    jButton1.setBounds(new Rectangle(13, 10, 200, 42));
    jButton1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 33));
    jButton1.setForeground(Color.white);
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setOpaque(true);
    jButton1.setHorizontalAlignment(SwingConstants.CENTER);
    jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
    jButton1.setIcon(null);
    jButton1.setText("ENET'COM");
    jLabel1.setFont(new java.awt.Font("Monospaced", 0, 16));
    jLabel1.setForeground(Color.white);
    jLabel1.setText("PROJET 2020/2021");
    jLabel1.setBounds(new Rectangle(34, 58, 164, 42));
    jLabel3.setFont(new java.awt.Font("Monospaced", 2, 12));
    jLabel3.setForeground(Color.white);
    jLabel3.setText("Version 1.0  12/02/2020");
    jLabel3.setBounds(new Rectangle(33, 111, 180, 30));
    jLabel4.setFont(new java.awt.Font("Monospaced", 2, 12));
    jLabel4.setForeground(Color.white);
    jLabel4.setText("Licence: Firas and Hatem Prod");
    jLabel4.setBounds(new Rectangle(15, 152, 212, 30));
    jLabel5.setFont(new java.awt.Font("Monospaced", 2, 12));
    jLabel5.setForeground(Color.white);
    jLabel5.setText("Programme protégé par copyright");
    jLabel5.setBounds(new Rectangle(8, 193, 219, 31));
    jLabel6.setFont(new java.awt.Font("Monospaced", 2, 12));
    jLabel6.setForeground(Color.white);
    jLabel6.setText("Compatible avec:WIN XP/7/8/10");
    jLabel6.setBounds(new Rectangle(2, 249, 215, 27));
    jLabel8.setFont(new java.awt.Font("Monospaced", 2, 12));
    jLabel8.setForeground(Color.white);
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel8.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel8.setText("2021-2020\r\n");
    jLabel8.setBounds(new Rectangle(47, 222, 128, 26));
    retour.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
    retour.setBounds(new Rectangle(190, 307, 78, 28));
    retour.setForeground(UIManager.getColor("ScrollBar.thumbHighlight"));
    retour.setText("Retour");
    retour.addActionListener(this);
    jPanel1.add(jButton1, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(jLabel1, null);
    this.add(retour, null);
    this.add(jPanel1, null);
    
    JLabel lblNewLabel = new JLabel("New label");
    lblNewLabel.setBounds(231, 32, 141, 240);
    lblNewLabel.setIcon(new ImageIcon("galerie\\enetcom.jpg"));
    jPanel1.add(lblNewLabel);

    F.getContentPane().add(this);
    F.setTitle("about");
    F.setSize(450,400);
    F.setLocation(300,300);
    F.show();
  }

//  public static void main(String[] args){
//    new apropos();
//  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==retour){
    	Home2 obj =new Home2();
        obj.setVisible(true);
        F.dispose();
    }
  }
}

