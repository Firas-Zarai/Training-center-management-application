package projet_java_gestion_centre_de_formation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class Home2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home2 frame = new Home2();
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
	public Home2() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 391);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("options");
		menuBar.add(mnNewMenu);
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("gestion clients");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients obj =new Clients();
	            obj.setVisible(true);
	            dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("gestion Formateurs");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formateurs obj =new Formateurs();
	            obj.setVisible(true);
	            dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("gestion Formations");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formations obj =new Formations();
                obj.setVisible(true);
                dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu.addSeparator();
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Quitter");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ClikedButton = JOptionPane.showConfirmDialog(
						Home2.this, 
						"Etes-vous sûre de quitter?" , "Confirm exit", JOptionPane.YES_NO_OPTION);
				if (ClikedButton == JOptionPane.YES_OPTION)
					dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Edit");
		mnNewMenu_2.add(copy);
		mnNewMenu_2.add(cut);
		mnNewMenu_2.add(paste);
		
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("about");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apropos obj =new apropos();
	            obj.setVisible(true);
	            dispose();}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel gestion = new JPanel();
		gestion.setBorder(new TitledBorder(null, "Espace gestion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		gestion.setBounds(10, 101, 257, 200);
		contentPane.add(gestion);
		gestion.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("gestion formations");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formations obj =new Formations();
	            obj.setVisible(true);
	            dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("galerie\\formation.png"));
		btnNewButton_2.setBounds(20, 128, 207, 44);
		gestion.add(btnNewButton_2);
		
		JButton btnGestionFormateur = new JButton("gestion formateurs");
		btnGestionFormateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formateurs obj =new Formateurs();
	            obj.setVisible(true);
	            dispose();
			}
		});
		btnGestionFormateur.setIcon(new ImageIcon("galerie\\formateur.PNG"));
		btnGestionFormateur.setBounds(20, 73, 207, 44);
		gestion.add(btnGestionFormateur);
		
		JButton btnGestionEtudiant = new JButton("gestion clients");
		btnGestionEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients obj =new Clients();
	            obj.setVisible(true);
	            dispose();
			}
		});
		
		btnGestionEtudiant.setIcon(new ImageIcon("galerie\\client.PNG"));
		btnGestionEtudiant.setBounds(20, 23, 207, 44);
		gestion.add(btnGestionEtudiant);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Affichage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(277, 101, 229, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button_1 = new JButton("les salles");
		button_1.setIcon(new ImageIcon("galerie\\class.PNG"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab obj =new tab();
	            obj.setVisible(true);
	            dispose();
				
			}
		});
		button_1.setBounds(20, 34, 192, 44);
		panel.add(button_1);
		
		JButton btnfind = new JButton("Recherche");
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercheBD obj =new rechercheBD();
	            obj.setVisible(true);
	            dispose();
				
			}
		});
		btnfind.setIcon(new ImageIcon("galerie\\find.png"));
		btnfind.setBounds(20, 89, 192, 44);
		panel.add(btnfind);
		
		JLabel lblNewLabel_1 = new JLabel("centredeformation");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon("galerie\\tc.png").getImage().getScaledInstance(620, 90, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(0, 0, 620, 90);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("QUITTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ClikedButton = JOptionPane.showConfirmDialog(
						Home2.this, 
						"Etes-vous sûre de quitter?" , "Confirm exit", JOptionPane.YES_NO_OPTION);
				if (ClikedButton == JOptionPane.YES_OPTION)
					dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("galerie\\out.png"));
		btnNewButton.setBounds(483, 283, 127, 36);
		contentPane.add(btnNewButton);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
				int ClikedButton = JOptionPane.showConfirmDialog(
						Home2.this, 
						"Etes-vous sûre de quitter?" , "Confirm exit", JOptionPane.YES_NO_OPTION);
				if (ClikedButton == JOptionPane.YES_OPTION)
					dispose();
			};
		});
	}
	}

