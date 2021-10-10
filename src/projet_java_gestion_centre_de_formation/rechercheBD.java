package projet_java_gestion_centre_de_formation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class rechercheBD extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnomcleint;
	private JTextField textFieldprenomclient;
	private JTextField textFieldcin;
	private JTextField textFieldnomf;
	private JTextField textFieldmail;
	private JTextField textFieldnomfor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rechercheBD frame = new rechercheBD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JTable table;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	public rechercheBD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cnx =  ConnexionMySQL.ConnexionDB();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(583, 11, 404, 579);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "recherche client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(28, 24, 339, 148);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldnomcleint = new JTextField();
		textFieldnomcleint.setBounds(140, 28, 189, 29);
		panel.add(textFieldnomcleint);
		textFieldnomcleint.setColumns(10);
		
		textFieldprenomclient = new JTextField();
		textFieldprenomclient.setColumns(10);
		textFieldprenomclient.setBounds(140, 68, 189, 29);
		panel.add(textFieldprenomclient);
		
		textFieldcin = new JTextField();
		textFieldcin.setColumns(10);
		textFieldcin.setBounds(140, 108, 189, 29);
		panel.add(textFieldcin);
		
		JLabel nomclient = new JLabel("Nom");
		nomclient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomclient.setBounds(20, 35, 56, 14);
		panel.add(nomclient);
		
		JLabel Prenom = new JLabel("Prenom");
		Prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Prenom.setBounds(20, 75, 46, 14);
		panel.add(Prenom);
		
		JLabel Cin = new JLabel("CIN");
		Cin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Cin.setBounds(20, 115, 46, 14);
		panel.add(Cin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "recherche formateur", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(28, 197, 339, 148);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldnomf = new JTextField();
		textFieldnomf.setColumns(10);
		textFieldnomf.setBounds(140, 38, 189, 29);
		panel_1.add(textFieldnomf);
		
		textFieldmail = new JTextField();
		textFieldmail.setColumns(10);
		textFieldmail.setBounds(140, 91, 189, 29);
		panel_1.add(textFieldmail);
		
		JLabel NomFor = new JLabel("Nom Formateur");
		NomFor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomFor.setBounds(24, 44, 90, 14);
		panel_1.add(NomFor);
		
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Email.setBounds(24, 97, 46, 14);
		panel_1.add(Email);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "recherche formation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(28, 356, 339, 99);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textFieldnomfor = new JTextField();
		textFieldnomfor.setColumns(10);
		textFieldnomfor.setBounds(140, 37, 189, 29);
		panel_2.add(textFieldnomfor);
		
		JLabel NomFormation = new JLabel("Nom Formation");
		NomFormation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NomFormation.setBounds(26, 43, 123, 14);
		panel_2.add(NomFormation);
		table = new JTable();
		JButton Buttonclient = new JButton("");
		Buttonclient.setIcon(new ImageIcon("galerie\\find.png"));
		Buttonclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldnomcleint.getText().toString();
				String prenom = textFieldprenomclient.getText().toString();
				String cin = textFieldcin.getText().toString();
				String sql= "select * from clients where CIN= ? and Nom= ? and Prenom= ? ";
				try {
					
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, cin);
						prepared.setString(2, nom);
						prepared.setString(3, prenom);
					    resultat=prepared.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(resultat));
					    textFieldnomcleint.setText("");
					    textFieldprenomclient.setText("");
					    textFieldcin.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		scrollPane.setViewportView(table);
		Buttonclient.setBounds(443, 63, 62, 61);
		contentPane.add(Buttonclient);
		
		JButton buttonformateur = new JButton("");
		buttonformateur.setIcon(new ImageIcon("galerie\\find.png"));
		buttonformateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldnomf.getText().toString();
				String mail = textFieldmail.getText().toString();
				String sql= "select * from formateurs where NomFor= ? and Email= ?";
				try {
					
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.setString(2, mail);
					    resultat=prepared.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(resultat));
					    textFieldnomf.setText("");
					    textFieldmail.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		scrollPane.setViewportView(table);
		buttonformateur.setBounds(443, 238, 62, 61);
		contentPane.add(buttonformateur);
		
		JButton buttonformation = new JButton("");
		buttonformation.setIcon(new ImageIcon("galerie\\find.png"));
		buttonformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldnomfor.getText().toString();
				String sql= "select * from formations where NomF=?";
				try {
					
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
					    resultat=prepared.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(resultat));
					    textFieldnomfor.setText("");
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		scrollPane.setViewportView(table);
		buttonformation.setBounds(443, 375, 62, 61);
		contentPane.add(buttonformation);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("galerie\\back.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home2 obj =new Home2();
	             obj.setVisible(true);
	             dispose();
			}
		});
		btnNewButton.setBounds(443, 517, 62, 55);
		contentPane.add(btnNewButton);
		JLabel lblFond = new JLabel("");
		lblFond.setIcon(new ImageIcon(new ImageIcon("galerie\\bo.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT)));
		lblFond.setBounds(0, 0, 987, 586);
		contentPane.add(lblFond);
	}
}
