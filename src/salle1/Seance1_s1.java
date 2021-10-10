package salle1;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import projet_java_gestion_centre_de_formation.ConnexionMySQL;
import java.awt.Color;



public class Seance1_s1 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JLabel lblFormation= new JLabel("Formation :");
	private JLabel lblFormateur= new JLabel("Formateur :");
	private JList<String> list;
	
		public Seance1_s1() {
			super ("Lundi de 8h à 12h");
			this.setSize(541,290);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			cnx =  ConnexionMySQL.ConnexionDB();
			
	        JPanel contentPane = (JPanel) getContentPane();
	        
	        JScrollPane projectScrollPane = new JScrollPane(createLeftPanel());
	        projectScrollPane.setPreferredSize( new Dimension( 150, 0 ) );
	        
	       
	        
	        JScrollPane editorScrollPane = new JScrollPane( createRightPanel() );
	        
	        
	        JSplitPane mainSplitPane = new JSplitPane(
	                JSplitPane.HORIZONTAL_SPLIT, projectScrollPane, editorScrollPane );
	        contentPane.add( mainSplitPane /*, BorderLayout.CENTER */ );    

		
		
		}
private JPanel createRightPanel() {
			
			JPanel panel= new JPanel();
			panel.setBackground(Color.ORANGE);
			panel.setLayout(null);
			lblFormation.setBounds(0, 0, 500, 100);
			panel.add(lblFormation);
			lblFormateur.setBounds(0, 100, 566, 140);
			panel.add(lblFormateur);
			
			JLabel lblNewLabel = new JLabel(nomFormation());
			lblNewLabel.setBounds(139, 0, 500, 100);
			panel.add(lblNewLabel);
			
			
			JLabel lblNewLabel_1 = new JLabel(nomFormateur());
			lblNewLabel_1.setBounds(117, 165, 234, 37);
			panel.add(lblNewLabel_1);
			
	
			
			return panel;
		}
		
		private JPanel createLeftPanel() {
			JPanel panel = new JPanel();
			panel.setBackground(Color.GREEN);
			//panel.setLayout(null);
			list= new JList<String>();
			panel.add(list);
			listeClients();
			
			return panel;
		}
	
		
		public String nomFormation() {
			String sql = "select NomF from formations where salle='salle1' and Jour='Lundi' and Horaire='8h à 12h'";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("NomF").toString();
					return nom;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		public String nomFormateur() {
			String sql = "select NomFor, Email from formateurs where NomF in (select NomF from formations where salle='salle1' and Jour='Lundi' and Horaire='8h à 12h')";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("NomFor").toString();
					String email = resultat.getString("Email").toString();
					String formateur= nom.concat( " "+" : "+email);
					return formateur;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		public void listeClients() {
			DefaultListModel<String> dlm= new DefaultListModel<String>();
			String sql = "select Nom, Prenom from clients where NomF in (select NomF from formations where salle='salle1' and Jour='Lundi' and Horaire='8h à 12h')";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("Nom").toString();
					String prenom = resultat.getString("Prenom").toString();
					String client= nom.concat( " "+prenom);
					
					dlm.addElement(client);
					list.setModel(dlm);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
		public static void main(String[] args) throws Exception {
			  UIManager.setLookAndFeel( new NimbusLookAndFeel() );
			  Seance1_s1 frame = new Seance1_s1();
		        frame.setVisible(true);

		}
}