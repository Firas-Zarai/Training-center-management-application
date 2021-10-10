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


public class Clients extends JFrame {
	private static final long serialVersionUID = -4939544011287453046L;
	JComboBox<String> FormationComboBox;
	
	JTable table;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	
	public Clients(){
		super("Gestion des Clients");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		JPanel contentPane = (JPanel) this.getContentPane();
		getContentPane().setLayout(null);
		
		cnx =  ConnexionMySQL.ConnexionDB();
		
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
		
		JLabel NomEtud = new JLabel("Nom : ");
		NomEtud.setFont(new Font("SansSerif", Font.BOLD, 17));
		NomEtud.setBounds(58, 95, 114, 27);
		contentPane.add(NomEtud);
		
		JLabel PrenomEtud = new JLabel("Prenom : ");
		PrenomEtud.setFont(new Font("SansSerif", Font.BOLD, 17));
		PrenomEtud.setBounds(58, 158, 114, 27);
		contentPane.add(PrenomEtud);
		
		JLabel Cin = new JLabel("CIN : ");
		Cin.setFont(new Font("SansSerif", Font.BOLD, 17));
		Cin.setBounds(58, 216, 130, 32);
		contentPane.add(Cin);
		
		JLabel MatEtud = new JLabel("NomF : ");
		MatEtud.setFont(new Font("SansSerif", Font.BOLD, 17));
		MatEtud.setBounds(58, 273, 130, 22);
		contentPane.add(MatEtud);
		
		JTextField NomTextField = new JTextField();
		NomTextField.setBounds(238, 94, 161, 28);
		contentPane.add(NomTextField);
		
		JTextField PrenomTextField = new JTextField();
		PrenomTextField.setBounds(238, 157, 161, 28);
		contentPane.add(PrenomTextField);
		
		JTextField CIN = new JTextField();
		CIN.setBounds(238, 220, 161, 28);
		contentPane.add(CIN);
		
		FormationComboBox = new JComboBox<String>();
		FormationComboBox.setBounds(238, 270, 162, 28);
		contentPane.add(FormationComboBox);
		remplirFormation();
		
		JButton btnRetour = new JButton("");
		btnRetour.setIcon(new ImageIcon("galerie\\back.png"));
		btnRetour.setBounds(423, 394, 68, 64);
		contentPane.add(btnRetour);
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home2 obj =new Home2();
	             obj.setVisible(true);
	             dispose();
			}});
			

		JButton btnSuppclient = new JButton("");
		btnSuppclient.setIcon(new ImageIcon("galerie\\delete.png"));
		btnSuppclient.setBounds(190, 394, 68, 64);
		getContentPane().add(btnSuppclient);
		
		btnSuppclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = NomTextField.getText().toString();
				String prenom = PrenomTextField.getText().toString();
				String cin = CIN.getText().toString();
				String sql ="delete from clients where CIN= ? and Nom= ? and Prenom= ? ";
				try {
					if (!cin.equals("") && !nom.equals("") && !prenom.equals("")) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, cin);
					prepared.setString(2, nom);
					prepared.setString(3, prenom);
					
					prepared.execute();
					
					JOptionPane.showMessageDialog(null,"Clients supprimé"); 
					
					CIN.setText("");
					NomTextField.setText("");
					PrenomTextField.setText("");
					FormationComboBox.setSelectedIndex(0);}}
					
					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			
		
		});
		
		
		JButton btnAjoutEtud = new JButton("");
		btnAjoutEtud.setIcon(new ImageIcon("galerie\\add.png"));
		btnAjoutEtud.setBounds(73, 394, 68, 64);
		getContentPane().add(btnAjoutEtud);
		btnAjoutEtud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = NomTextField.getText().toString();
				String prenom = PrenomTextField.getText().toString();
				String cin =  CIN.getText().toString();
				String sql ="insert into clients (Nom,Prenom,CIN, NomF) values (?,?,?,?)";
				
				try {
					if (!nom.equals("") && !prenom.equals("") && !cin.equals("")) {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, nom);
					prepared.setString(2, prenom);
					prepared.setString(3, cin);
					prepared.setString(4, FormationComboBox.getSelectedItem().toString());
					prepared.execute();
					
					JOptionPane.showMessageDialog(null,"Clients ajouté"); 
					
					NomTextField.setText("");
					PrenomTextField.setText("");
					CIN.setText("");
					FormationComboBox.setSelectedIndex(0);
					
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
		scrollPane.setBounds(517, 25, 433, 490);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne, 0).toString();
				String sql ="select * from clients where CIN='"+id+"'";
				try {
					prepared=cnx.prepareStatement(sql);
					resultat=prepared.executeQuery();
					
					if(resultat.next()) {
						NomTextField.setText(resultat.getString("Nom"));
						PrenomTextField.setText(resultat.getString("Prenom"));
						CIN.setText(resultat.getString("CIN"));
						
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
		btnActualiser.setBounds(309, 394, 68, 64);
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
		String sql= "select * from clients ";
		try {
			prepared=cnx.prepareStatement(sql);
			resultat=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	public void remplirFormation() {
		String sql = "select * from formations";
		
		try {
			prepared= cnx.prepareStatement(sql);
			resultat= prepared.executeQuery();
			
			while (resultat.next()) {
				String nom = resultat.getString("NomF").toString();
				FormationComboBox.addItem(nom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
			// apply a look and feel
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			
			
			
			//start my window
			Clients myWindow= new Clients();
			myWindow.setVisible(true);

		}
}
