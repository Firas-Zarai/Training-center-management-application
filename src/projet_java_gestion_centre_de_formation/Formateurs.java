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

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Formateurs extends JFrame {
	private static final long serialVersionUID = -4939544011287453046L;
    JComboBox<String> MatiereComboBox;
	
	JTable table;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	
	public Formateurs(){
		super("Gestion Des Formateurs");
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
		
		JLabel NomFor = new JLabel("NomFor : ");
		NomFor.setFont(new Font("SansSerif", Font.BOLD, 18));
		NomFor.setBounds(58, 95, 114, 27);
		contentPane.add(NomFor);
		
		JLabel Email = new JLabel("Email : ");
		Email.setFont(new Font("SansSerif", Font.BOLD, 18));
		Email.setBounds(58, 158, 114, 27);
		contentPane.add(Email);
		
	/*	JLabel SalaireProf = new JLabel("Salaire : ");
		SalaireProf.setBounds(58, 216, 130, 32);
		contentPane.add(SalaireProf);*/
		
		JLabel NomMat = new JLabel("Nom Matiere : ");
		NomMat.setFont(new Font("SansSerif", Font.BOLD, 18));
		NomMat.setBounds(58, 238, 130, 22);
		contentPane.add(NomMat);
		
		JTextField NomTextField = new JTextField();
		NomTextField.setBounds(238, 94, 161, 28);
		contentPane.add(NomTextField);
		
		JTextField EmailTextField = new JTextField();
		EmailTextField.setBounds(238, 157, 161, 28);
		contentPane.add(EmailTextField);
		
		/*JTextField salaireTextField = new JTextField();
		salaireTextField.setBounds(238, 220, 154, 28);
		contentPane.add(salaireTextField);*/
		
		MatiereComboBox = new JComboBox<String>();
		MatiereComboBox.setBounds(237, 235, 162, 28);
		contentPane.add(MatiereComboBox);
		remplirFormation();
		
		//precedent
		JButton btnRetour = new JButton("");
		btnRetour.setIcon(new ImageIcon("galerie\\back.PNG"));
		btnRetour.setBounds(371, 416, 65, 66);
		contentPane.add(btnRetour);
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home2 obj =new Home2();
	             obj.setVisible(true);
	             dispose();
			}});

		JButton btnSuppFormateur = new JButton("");
		btnSuppFormateur.setIcon(new ImageIcon("galerie\\delete.png"));
		btnSuppFormateur.setBounds(190, 416, 65, 66);
		getContentPane().add(btnSuppFormateur);
		
		btnSuppFormateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = NomTextField.getText().toString();
				String email = EmailTextField.getText().toString();
				String sql ="delete from formateurs where NomFor= ? and Email=? ";
				try {
					if (!nom.equals("") && !email.equals("") ) { 
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, nom);
					prepared.setString(2, email);
					
					prepared.execute();
					
					JOptionPane.showMessageDialog(null,"formateur supprimé"); 
					
					NomTextField.setText("");
					EmailTextField.setText("");}}
					
					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
				
		
		});
		
		JButton btnAjoutFormateur = new JButton("");
		btnAjoutFormateur.setIcon(new ImageIcon("galerie\\add.png"));
		btnAjoutFormateur.setBounds(84, 416, 65, 66);
		getContentPane().add(btnAjoutFormateur);
		btnAjoutFormateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = NomTextField.getText().toString();
				String email = EmailTextField.getText().toString();
				String sql ="insert into formateurs (NomFor,Email,NomF) values (?,?,?)";
				try {
					if (!nom.equals("") && !email.equals("") ) { //&& !salaire.equals("")
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, nom);
					prepared.setString(2, email);
					prepared.setString(3, MatiereComboBox.getSelectedItem().toString());
					prepared.execute();
					JOptionPane.showMessageDialog(null,"Professeur ajoutée");
					
					NomTextField.setText("");
					EmailTextField.setText("");
					MatiereComboBox.setSelectedIndex(0);
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
		scrollPane.setBounds(517, 28, 404, 487);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne, 0).toString();
				String sql ="select * from formateurs where NomFor='"+id+"'";
				try {
					prepared=cnx.prepareStatement(sql);
					resultat=prepared.executeQuery();
					
					if(resultat.next()) {
						NomTextField.setText(resultat.getString("NomFor"));
						EmailTextField.setText(resultat.getString("Email"));
						
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
		btnActualiser.setBounds(283, 416, 65, 66);
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
		String sql= "select * from formateurs ";
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
				MatiereComboBox.addItem(nom);
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
			Formateurs myWindow= new Formateurs();
			myWindow.setVisible(true);

		}
}

