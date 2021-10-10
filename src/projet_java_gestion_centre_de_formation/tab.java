package projet_java_gestion_centre_de_formation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class tab extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tab frame = new tab();
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
	
	public tab() {
		setTitle("Les Salles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 725, 377);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Salle1", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("se1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance1_s1 obj1= new salle1.Seance1_s1();
				obj1.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(95, 158, 160));
		btnNewButton_3.setIcon(new ImageIcon("galerie\\home1.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home2 obj =new Home2();
	             obj.setVisible(true);
	             dispose();
			}
		});
		btnNewButton_3.setBounds(31, 45, 54, 52);
		panel.add(btnNewButton_3);
		btnNewButton.setBounds(233, 228, 59, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("se3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance3_s1 obj1= new salle1.Seance3_s1();
				obj1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(311, 228, 59, 31);
		panel.add(btnNewButton_1);
		
		JButton btnSeance = new JButton("se5");
		btnSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance5_s1 obj1= new salle1.Seance5_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance.setBounds(386, 228, 59, 31);
		panel.add(btnSeance);
		
		JButton btnSeance_1 = new JButton("se7");
		btnSeance_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance7_s1 obj1= new salle1.Seance7_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_1.setBounds(455, 228, 59, 31);
		panel.add(btnSeance_1);
		
		JButton btnSeance_2 = new JButton("se9");
		btnSeance_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance9_s1 obj1= new salle1.Seance9_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_2.setBounds(532, 228, 65, 31);
		panel.add(btnSeance_2);
		
		JButton btnSeance_3 = new JButton("se11");
		btnSeance_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance11_s1 obj1= new salle1.Seance11_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_3.setBounds(610, 228, 65, 31);
		panel.add(btnSeance_3);
		
		JButton button = new JButton("se2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance2_s1 obj1= new salle1.Seance2_s1();
				obj1.setVisible(true);
			}
		});
		button.setBounds(233, 278, 65, 31);
		panel.add(button);
		
		JButton btnSeance_4 = new JButton("se4");
		btnSeance_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance3_s1 obj1= new salle1.Seance3_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_4.setBounds(311, 278, 59, 31);
		panel.add(btnSeance_4);
		
		JButton btnSeance_5 = new JButton("se6");
		btnSeance_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance6_s1 obj1= new salle1.Seance6_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_5.setBounds(386, 278, 59, 31);
		panel.add(btnSeance_5);
		
		JButton btnSeance_6 = new JButton("se8");
		btnSeance_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance8_s1 obj1= new salle1.Seance8_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_6.setBounds(455, 278, 59, 31);
		panel.add(btnSeance_6);
		
		JButton btnSeance_7 = new JButton("se10");
		btnSeance_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance10_s1 obj1= new salle1.Seance10_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_7.setBounds(532, 278, 65, 31);
		panel.add(btnSeance_7);
		
		JButton btnSeance_8 = new JButton("se12");
		btnSeance_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance12_s1 obj1= new salle1.Seance12_s1();
				obj1.setVisible(true);
			}
		});
		btnSeance_8.setBounds(610, 278, 65, 31);
		panel.add(btnSeance_8);

		JLabel lblfond = new JLabel("New label");
		//lblfond.setIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\ss.jpg"));
		//new ImageIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\fff.png").getImage().getScaledInstance(629, 324, Image.SCALE_DEFAULT)));
		//lblfond.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\imagesprojetjava\\fff.jpeg").getImage().getScaledInstance(720, 351, Image.SCALE_DEFAULT)));
		lblfond.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\galerie\\ss.png").getImage().getScaledInstance(735, 351, Image.SCALE_DEFAULT)));
		lblfond.setBounds(0, 0, 733, 351);
		panel.add(lblfond);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Salle2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(95, 158, 160));
		button_2.setIcon(new ImageIcon("galerie\\home1.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home2 obj =new Home2();
	             obj.setVisible(true);
	             dispose();
			}
		});
		button_2.setBounds(31, 45, 54, 52);
		panel_1.add(button_2);
		
		JButton btnNewButton_2 = new JButton("se1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance1_s2 obj1= new salle2.Seance1_s2();
				obj1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(235, 232, 63, 29);
		panel_1.add(btnNewButton_2);
		
		JButton btnSe = new JButton("se3");
		btnSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance3_s2 obj1= new salle2.Seance3_s2();
				obj1.setVisible(true);
			}
		});
		btnSe.setBounds(308, 233, 63, 26);
		panel_1.add(btnSe);
		
		JButton btnSe_1 = new JButton("se2");
		btnSe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance2_s2 obj1= new salle2.Seance2_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_1.setBounds(235, 275, 63, 29);
		panel_1.add(btnSe_1);
		
		JButton btnSe_2 = new JButton("se4");
		btnSe_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance4_s2 obj1= new salle2.Seance4_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_2.setBounds(308, 276, 63, 26);
		panel_1.add(btnSe_2);
		
		JButton btnSe_3 = new JButton("se5");
		btnSe_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance5_s2 obj1= new salle2.Seance5_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_3.setBounds(382, 232, 63, 29);
		panel_1.add(btnSe_3);
		
		JButton btnSe_4 = new JButton("se6");
		btnSe_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance6_s2 obj1= new salle2.Seance6_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_4.setBounds(455, 275, 63, 29);
		panel_1.add(btnSe_4);
		
		JButton btnSe_5 = new JButton("se7");
		btnSe_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance7_s2 obj1= new salle2.Seance7_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_5.setBounds(455, 232, 63, 29);
		panel_1.add(btnSe_5);
		
		JButton btnSe_6 = new JButton("se8");
		btnSe_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance8_s2 obj1= new salle2.Seance8_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_6.setBounds(381, 275, 63, 29);
		panel_1.add(btnSe_6);
		
		JButton btnSe_7 = new JButton("se9");
		btnSe_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance9_s2 obj1= new salle2.Seance9_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_7.setBounds(530, 232, 63, 29);
		panel_1.add(btnSe_7);
		
		JButton btnSe_8 = new JButton("se10");
		btnSe_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance10_s2 obj1= new salle2.Seance10_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_8.setBounds(530, 276, 63, 29);
		panel_1.add(btnSe_8);
		
		JButton btnSe_9 = new JButton("se11");
		btnSe_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance11_s2 obj1= new salle2.Seance11_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_9.setBounds(612, 232, 63, 29);
		panel_1.add(btnSe_9);
		
		JButton btnSe_10 = new JButton("se12");
		btnSe_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle2.Seance12_s2 obj1= new salle2.Seance12_s2();
				obj1.setVisible(true);
			}
		});
		btnSe_10.setBounds(612, 275, 63, 29);
		panel_1.add(btnSe_10);
		JLabel lblfond2 = new JLabel("New label");
		//lblfond.setIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\ss.jpg"));
		//new ImageIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\fff.png").getImage().getScaledInstance(629, 324, Image.SCALE_DEFAULT)));
		lblfond2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\firas zarai\\Desktop\\galerie\\ss.png").getImage().getScaledInstance(735, 351, Image.SCALE_DEFAULT)));
		lblfond2.setBounds(0, 0, 720, 353);
		panel_1.add(lblfond2);
		
	}
}
