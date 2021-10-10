package projet_java_gestion_centre_de_formation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.DefaultEditorKit;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;


public class Formations extends JFrame {
	private static final long serialVersionUID = -4939544011287453046L;
	JTable table;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	
	public Formations(){
		super("Gestion Des Formations");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		JPanel contentPane = (JPanel) this.getContentPane();
		getContentPane().setLayout(null);
		
		cnx = ConnexionMySQL.ConnexionDB();
		JMenuItem copy; // = new JMenuItem("copier"); //l'element copier
		JMenuItem cut; // = new JMenuItem("couper"); //l'element coper
		JMenuItem paste; // = new JMenuItem("coller"); //l'element coller
		Action alt = new DefaultEditorKit.CopyAction();
		Action actionCopier = new DefaultEditorKit.CopyAction();
		Action actionColler = new DefaultEditorKit.PasteAction();
		Action actionCouper = new DefaultEditorKit.CutAction();
		KeyStroke k = KeyStroke.getKeyStroke(KeyEvent.CTRL_MASK, KeyEvent.VK_C);
		KeyStroke k1 = KeyStroke.getKeyStroke(KeyEvent.CTRL_MASK, KeyEvent.VK_V);
		KeyStroke k2 = KeyStroke.getKeyStroke(KeyEvent.CTRL_MASK, KeyEvent.VK_X);
		KeyStroke k3 = KeyStroke.getKeyStroke(KeyEvent.ALT_MASK, KeyEvent.VK_F);
		copy = new JMenuItem(actionCopier);
		copy.setText("copier");
		cut = new JMenuItem(actionCouper);
		cut.setText("couper");
		paste = new JMenuItem(actionColler);
		paste.setText("coller");
		JMenu mnNewMenu_2 = new JMenu("Edit");
		mnNewMenu_2.add(copy);
		mnNewMenu_2.add(cut);
		mnNewMenu_2.add(paste);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		menuBar.add(mnNewMenu_2);
		
		
		JLabel NomF = new JLabel("Nom Formation : ");
		NomF.setFont(new Font("SansSerif", Font.BOLD, 15));
		NomF.setBounds(58, 95, 145, 27);
		contentPane.add(NomF);
		
		JLabel salle = new JLabel("salle : ");
		salle.setFont(new Font("SansSerif", Font.BOLD, 15));
		salle.setBounds(58, 306, 114, 27);
		contentPane.add(salle);
		
		JLabel Jour = new JLabel("jour : ");
		Jour.setFont(new Font("SansSerif", Font.BOLD, 15));
		Jour.setBounds(58, 201, 130, 32);
		contentPane.add(Jour);
		
		JLabel horaire = new JLabel("horaire : ");
		horaire.setFont(new Font("SansSerif", Font.BOLD, 15));
		horaire.setBounds(58, 258, 130, 22);
		contentPane.add(horaire);
		
	 JLabel Prix = new JLabel("prix : ");
	 Prix.setFont(new Font("SansSerif", Font.BOLD, 15));
		Prix.setBounds(58, 147, 130, 22);
		contentPane.add(Prix);
		
		JTextField NomTextField = new JTextField();
		NomTextField.setBounds(238, 94, 161, 27);
		contentPane.add(NomTextField);
		
		JTextField PrixTextField = new JTextField();
		PrixTextField.setBounds(238, 144, 161, 28);
		contentPane.add(PrixTextField);
		
		String Tab[]= {"salle1","salle2"};
		JComboBox <String> salleComboBox = new JComboBox<String>(Tab);
		salleComboBox.setBounds(238, 305, 161, 28);
		contentPane.add(salleComboBox);
		
		String Tab1[]= {"Lundi","Mardi","Mercredi","Jeudi","Vendredi", "Samedi"};
		JComboBox<String> jourComboBox = new JComboBox<String>(Tab1);
		jourComboBox.setBounds(238, 203, 161, 28);
		contentPane.add(jourComboBox);
		
		String Tab2[]= {"8h à 12h","13h à 16h"};
		JComboBox<String> HoraireComboBox = new JComboBox<String>(Tab2);
		HoraireComboBox.setBounds(237, 255, 162, 28);
		contentPane.add(HoraireComboBox);
		
		JButton btnRetour = new JButton("");
		btnRetour.setIcon(new ImageIcon("galerie\\back.png"));
		btnRetour.setBounds(393, 432, 61, 64);
		contentPane.add(btnRetour);
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home2 obj =new Home2();
	             obj.setVisible(true);
	             dispose();
			}});

		JButton btnSuppFormation = new JButton("");
		btnSuppFormation.setIcon(new ImageIcon("galerie\\delete.png"));
		btnSuppFormation.setBounds(187, 432, 61, 64);
		getContentPane().add(btnSuppFormation);
		
		
		btnSuppFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = NomTextField.getText().toString();
				String sql ="delete from formations where NomF= ?";
				try {
					if (!nom.equals("")) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, nom);
					prepared.execute();
					
					JOptionPane.showMessageDialog(null,"Formation supprimée"); 
					
					NomTextField.setText("");
					jourComboBox.setSelectedIndex(0);
					salleComboBox.setSelectedIndex(0);
					HoraireComboBox.setSelectedIndex(0);
					
					
			    }}
					
					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});

		
		JButton btnAjoutFormation = new JButton("");
		btnAjoutFormation.setIcon(new ImageIcon("galerie\\add.png"));
		btnAjoutFormation.setBounds(93, 432, 61, 64);
		getContentPane().add(btnAjoutFormation);
		btnAjoutFormation.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String nom = NomTextField.getText().toString();
				String prix = PrixTextField.getText().toString();
				String salle = salleComboBox.getSelectedItem().toString();
				String horaire = HoraireComboBox.getSelectedItem().toString();
				String jour = jourComboBox.getSelectedItem().toString();
				String sql ="insert into formations(NomF,Prix,Horaire,salle,Jour)  values (?,?,?,?,?)";
				try {
					if (!nom.equals("") && !prix.equals("") && !horaire.equals("") && !salle.equals("") && !jour.equals("")) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, nom);
					prepared.setString(2, prix);
					prepared.setString(3, horaire );
					prepared.setString(4, salle );
					prepared.setString(5, jour );
					
					prepared.execute();
					
					JOptionPane.showMessageDialog(null,"formation ajoutée"); 
					
					NomTextField.setText("");
					PrixTextField.setText(" ");
				
					
		
					}else 
					{
						JOptionPane.showMessageDialog(null,"il faut remplir tous les champs!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(517, 74, 404, 441);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne, 0).toString();
				String sql ="select * from formations where NomF='"+id+"'";
				try {
					prepared=cnx.prepareStatement(sql);
					resultat=prepared.executeQuery();
					
					if(resultat.next()) {
						NomTextField.setText(resultat.getString("NomF"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		

		JButton btnActualiser = new JButton("");
		btnActualiser.setIcon(new ImageIcon("galerie\\refresh.PNG"));
		btnActualiser.setBounds(295, 432, 61, 64);
		getContentPane().add(btnActualiser);
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateTable();
			}
		});
		
		JLabel lblFond = new JLabel("New label");
		lblFond.setIcon(new ImageIcon(new ImageIcon("galerie\\bo.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT)));
		lblFond.setBounds(0, 0, 1000, 600);
		contentPane.add(lblFond);
		}
	
	public void UpdateTable() {
		String sql= "select * from formations";
		try {
			prepared=cnx.prepareStatement(sql);
			resultat=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}


	public static void main(String[] args) throws Exception {
			// apply a look and feel
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			
			
			
			//start my window
			Formations myWindow= new Formations();
			myWindow.setVisible(true);

		}
}
