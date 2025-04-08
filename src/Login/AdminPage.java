package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AdminPage extends JFrame {
	 private String adminName;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage("AdminName");
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
	public AdminPage(String un) {
		this.adminName = un;
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setForeground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JLabel lblNewLabel_1 = new JLabel("Tableau de Bord Administrateur");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 31));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnseignantPage frame = null;
				try {
					frame = new EnseignantPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\6977344 (1).png"));
		
		JButton btnNewButton1 = new JButton("");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassePage un = new ClassePage(adminName);
				un.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton1.setBackground(new Color(102, 205, 170));
		btnNewButton1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\3557635.png"));
		
		JButton btnNewButton_1 = new JButton("Gestion des utilisateurs");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnseignantPage frame = null;
				try {
					frame = new EnseignantPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 191, 255));
		btnNewButton_1.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 13));
		
		JButton btnNewButton_2 = new JButton("Gestion des classes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassePage frame = new ClassePage("adminName");
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 191, 255));
		btnNewButton_2.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 13));
		
		
		JButton btnNewButton_3 = new JButton("Gestion des étudiants");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtudiantsPage frame = null;
				try {
					frame = new EtudiantsPage(un);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBackground(new Color(0, 191, 255));
		btnNewButton_3.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\5752047 (2).png"));
		
		JLabel lblNewLabel2= new JLabel("New label");
		lblNewLabel2.setBackground(new Color(0, 255, 255));
		lblNewLabel2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\1177455 (1).png"));
		
		JButton btnNewButton2_1 = new JButton("");
		btnNewButton2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtudiantsPage frame = null;
				try {
					frame = new EtudiantsPage(un);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton2_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\5850276.png"));
		btnNewButton2_1.setBackground(new Color(102,205, 170));
		
		JButton btnNewButton_4 = new JButton("Déconnexion");
		btnNewButton_4.setBackground(new Color(250, 128, 114));
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\12559030 (1).png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoginScreen l = new LoginScreen();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("BIENVENUE, ADMIN");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel(un);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
					.addGap(76)
					.addComponent(lblNewLabel2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(btnNewButton2_1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addGap(42)
					.addComponent(btnNewButton1, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
					.addGap(33))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(116)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addGap(126)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(75))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(757, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton2_1, GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE)
						.addComponent(btnNewButton1, GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		

		
	}
}