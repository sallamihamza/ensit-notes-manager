package Login;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class ClassePage extends JFrame {

    Connection cnx=null;
    
    PreparedStatement prepared=null;
    ResultSet resultat=null;
    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField classefiled;
	private JTextField niveaufiled;
	private JTable table;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassePage frame = new ClassePage("adminName");
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
	public ClassePage(String adminName) {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 1230, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setForeground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-11, 128, 2000, 3);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\2700165_4275d.jpg"));
		lblNewLabel.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(419, 128, 3, 600);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\2700165_4275d.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("Tableau de gestion des classes");
		lblNewLabel_1.setBounds(360, 53, 493, 33);
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 31));
		
		classefiled = new JTextField();
		classefiled.setBounds(152, 336, 224, 20);
		classefiled.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nom classe :");
		lblNewLabel_4.setBounds(70, 339, 72, 14);
		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD, 13));
		
		
		JLabel lblNewLabel_6 = new JLabel("Supprimer");
		lblNewLabel_6.setBounds(128, 638, 66, 14);
		lblNewLabel_6.setFont(new Font("Bell MT", Font.BOLD, 13));
		
		niveaufiled = new JTextField();
		niveaufiled.setBounds(152, 385, 224, 20);
		niveaufiled.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(15, 578, 89, 49);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nom_classe = classefiled.getText();
		        String niveau= niveaufiled.getText();
		       // String classe = classeComboBox.getSelectedItem().toString();
		        if (nom_classe.isEmpty() || niveau.isEmpty()) {//classe.equals("Sélectionner")
		            JOptionPane.showMessageDialog(null, "Certains champs sont vides", "Erreur", JOptionPane.ERROR_MESSAGE);
		        } else {
		            try {
		                cnx = ConnexsionMysql.ConnexsionDB();
		                prepared = cnx.prepareStatement(
		                    "INSERT INTO classes (nom_classe, niveau) VALUES (?, ?)"
		                );
		                prepared.setString(1, nom_classe);
		                prepared.setString(2, niveau);

		                int rowsInserted = prepared.executeUpdate();

		                if (rowsInserted > 0) {
		                    JOptionPane.showMessageDialog(null, "Classe ajouté avec succès");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Échec de l'ajout de classe", "Erreur", JOptionPane.ERROR_MESSAGE);
		                }

		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		            } finally {
		                try {
		                    if (resultat != null) resultat.close();
		                    if (prepared != null) prepared.close();
		                    if (cnx != null) cnx.close();
		                } catch (Exception ex) {
		                    System.out.println("Erreur lors de la fermeture des ressources: " + ex.getMessage());
		                }
		            }
		        }
		    }
		});

        
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\9758439 (1).png"));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                	JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée pour la suppression.","Erreur", JOptionPane.ERROR_MESSAGE);
               
                    return;
                }

                String id = table.getModel().getValueAt(selectedRow, 0).toString();
                cnx = ConnexsionMysql.ConnexsionDB();

                if (cnx == null) {
                    System.err.println("Database connection is not initialized.");
                    return;
                }

                String deleteSql = "DELETE FROM classes WHERE id_classe= ?";

                try {
                    prepared = cnx.prepareStatement(deleteSql);
                    prepared.setString(1, id);

	                int rowsInserted = prepared.executeUpdate();

	                if (rowsInserted > 0) {
	                    JOptionPane.showMessageDialog(null, "Classe supprimé avec succès.");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Échec de suppression de classe.", "Erreur", JOptionPane.ERROR_MESSAGE);
	                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (prepared != null) prepared.close();
                        if (cnx != null) cnx.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
		btnNewButton_1.setBounds(118, 578, 89, 49);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\6861362 (1).png"));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int ligne = table.getSelectedRow();
                if (ligne == -1) {
                	JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée pour modification.","Erreur", JOptionPane.ERROR_MESSAGE);
             
                    return;
                }
		        String id = (String) table.getModel().getValueAt(ligne, 0).toString();
	                String nom_class = classefiled.getText();
	                String niveau = niveaufiled.getText();
	                cnx = ConnexsionMysql.ConnexsionDB();

	                String updateSql = "UPDATE classes SET   nom_classe = ?,niveau = ? WHERE id_classe = ?";

	                try {
	                	
	                    prepared = cnx.prepareStatement(updateSql);
	                    prepared.setString(1, nom_class);
	                    prepared.setString(2, niveau);
	                    prepared.setString(3, id);
		                int rowsInserted = prepared.executeUpdate();

		                if (rowsInserted > 0) {
		                    JOptionPane.showMessageDialog(null, "classe modifié avec succès.");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Échec de modification de classe.", "Erreur", JOptionPane.ERROR_MESSAGE);
		                }

	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                } finally {
	                    try {
	                        if (prepared != null) prepared.close();
	                        if (cnx != null) cnx.close();
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            }
			
		});
		btnNewButton_2.setBounds(217, 578, 89, 49);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\download (1).jpg"));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                	JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée pour l'impression.","Erreur", JOptionPane.ERROR_MESSAGE);
             
                    return;
                }

                StringBuilder record = new StringBuilder();
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(selectedRow, col);
                    record.append(table.getColumnName(col)).append(": ").append(value).append("\n");
                }

                JTextArea textArea = new JTextArea(record.toString());
                try {
                    boolean printComplete = textArea.print();
                    if (printComplete) {
                    	JOptionPane.showMessageDialog(null, "Impression de la ligne sélectionnée terminée.");
                        
                    } 
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        });
		btnNewButton_3.setBounds(320, 578, 89, 49);
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\813078 (1).png"));
		
		JLabel lblNewLabel_11 = new JLabel("Niveau :");
		lblNewLabel_11.setBounds(86, 388, 56, 14);
		lblNewLabel_11.setFont(new Font("Bell MT", Font.BOLD, 13));
		
		JLabel lblNewLabel_12= new JLabel("Modifier");
		lblNewLabel_12.setBounds(237, 638, 56, 14);
		lblNewLabel_12.setFont(new Font("Bell MT", Font.BOLD, 13));

		JLabel lblNewLabel_13= new JLabel("Table des classes :");
		lblNewLabel_13.setBounds(440, 163, 189, 27);
		lblNewLabel_13.setFont(new Font("Bell MT", Font.BOLD, 20));
		
		JLabel lblNewLabel_15= new JLabel("Imprimer");
		lblNewLabel_15.setBounds(340, 638, 56, 14);
		lblNewLabel_15.setFont(new Font("Bell MT", Font.BOLD, 13));
		
		JLabel lblNewLabel_14= new JLabel("Ajouter");
		lblNewLabel_14.setBounds(36, 638, 46, 14);
		lblNewLabel_14.setFont(new Font("Bell MT", Font.BOLD, 13));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 5, 77, 33);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\5368475 (4).png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Accueil");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                AdminPage ad = new AdminPage(adminName);
                ad.setVisible(true);
                setVisible(false);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\1177455 (2).png"));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tableau des étudiants");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtudiantsPage frame = null;
				try {
					frame = new EtudiantsPage(adminName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				setVisible(false);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\5850276 (2).png"));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tableau des utilisateurs");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\6977344 (3).png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Fermer");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\1828665.png"));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 196, 731, 440);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(1049, 149, 56, 41);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\4856659.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Connection cnx = null;
		        Statement st = null;
		        ResultSet resultat = null;

		        try {
		            cnx = ConnexsionMysql.ConnexsionDB();
		            String sql = "SELECT * FROM classes";
		            st = cnx.createStatement();
		            resultat = st.executeQuery(sql);

		            ResultSetMetaData rsmd = (ResultSetMetaData) resultat.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table.getModel();

		            // Clear previous rows
		            model.setRowCount(0);

		            // Set column names if not already set
		            if (model.getColumnCount() == 0) {
		                int cols = rsmd.getColumnCount();
		                String[] colName = new String[cols];
		                for (int i = 0; i < cols; i++) {
		                    colName[i] = rsmd.getColumnName(i + 1);
		                }
		                model.setColumnIdentifiers(colName);
		            }

		            
		            while (resultat.next()) {
		                String id_classe = resultat.getString(1);
		                String nom_classe = resultat.getString(2);
		                String niveau = resultat.getString(3);

		                String[] row = {id_classe, nom_classe,niveau};
		                model.addRow(row);  // Add row to table
		            }

		            st.close();
		            cnx.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error fetching data: " + e1.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		table = new JTable();

		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		        int ligne = table.getSelectedRow();
		        String id = (String) table.getModel().getValueAt(ligne, 0).toString();
		        cnx = ConnexsionMysql.ConnexsionDB();

		        String sqll = "SELECT * FROM classes WHERE id_classe = '" + id + "'";
		        try {
		            prepared = cnx.prepareStatement(sqll);
		            resultat = prepared.executeQuery();

		            if (resultat.next()) {
		                classefiled.setText(resultat.getString("nom_classe"));
		                niveaufiled.setText(resultat.getString("niveau"));
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		table.getModel().addTableModelListener(new TableModelListener() {
		    public void tableChanged(TableModelEvent e) {
		        int row = e.getFirstRow();
		        int column = e.getColumn();

		        // Check if the row and column indices are valid
		        if (row == TableModelEvent.HEADER_ROW || column == TableModelEvent.ALL_COLUMNS) {
		            return; // Ignore header changes or invalid column index
		        }

		        // Ensure the row is within bounds
		        if (row < 0 || row >= table.getRowCount()) {
		            return; // Invalid row index
		        }

		        // Ensure the column is within bounds
		        if (column < 0 || column >= table.getColumnCount()) {
		            return; // Invalid column index
		        }

		        // Get column name from the table model
		        String columnName = table.getColumnName(column);

		        // Get the new value in the cell
		        Object newValue = table.getValueAt(row, column);

		        // Call updateDatabase method
		        updateDatabase(row, columnName, newValue);
		    }
		});



		scrollPane.setViewportView(table);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setBounds(1115, 149, 56, 41);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\nettoyer.png"));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel())	;	
				}
		});
		contentPane.setLayout(null);
		contentPane.add(menuBar);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton_1);
		contentPane.add(classefiled);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_14);
		contentPane.add(lblNewLabel_15);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_12);
		contentPane.add(lblNewLabel_11);
		contentPane.add(niveaufiled);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_13);
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_5);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setBounds(237, 22, 77, 83);
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\3557635 (1).png"));
		contentPane.add(lblNewLabel_16);
		
		textField = new JTextField();
		textField.setBounds(816, 163, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setBounds(993, 149, 46, 41);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = textField.getText().toLowerCase();
                DefaultTableModel newModel = new DefaultTableModel(new String[]{"id_classe", "nom_classe", "niveau"}, 0);

                for (int i = 0; i < table.getRowCount(); i++) {
                    String fullName = table.getValueAt(i, 1).toString().toLowerCase() + " " + table.getValueAt(i, 2).toString().toLowerCase();
                    if (fullName.contains(searchText)) {
                        Object[] row = new Object[table.getColumnCount()];
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            row[j] = table.getValueAt(i, j);
                        }
                        newModel.addRow(row);
                    }
                }
                table.setModel(newModel);
            }
        });
		btnSearch.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\7626086 (3).png"));
		contentPane.add(btnSearch);
	}
	private void updateDatabase(int row, String columnName, Object newValue) {
	    String id_classe = (String) table.getValueAt(row, 0);  // Assuming the first column is the student ID

	    // Build SQL query based on the column that changed
	    String sql = "UPDATE classes SET " + columnName + " = ? WHERE id_classe = ?";

	    try (Connection cnx = ConnexsionMysql.ConnexsionDB();
	         PreparedStatement pstmt = cnx.prepareStatement(sql)) {

	        pstmt.setObject(1, newValue);  // Set the new value
	        pstmt.setString(2, id_classe);  // Set the student ID for the WHERE clause

	        // Execute the update
	        int rowsUpdated = pstmt.executeUpdate();
	        if (rowsUpdated > 0) {
	        	JOptionPane.showMessageDialog(null, "Mise à jour du tableau réussie.");
	        } else {
	        	JOptionPane.showMessageDialog(null, "Échec de la mise à jour de l'enregistrement.","Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
