package ihm;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import metier.Aerienne;
import metier.Cargaison;
import metier.Routiere;
import metier.SocieteTransport;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCargaison extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRef;
	private JTextField txtDist;
	
	
	private CargaisonModel model=new CargaisonModel();
	
	private JTable tableC;
SocieteTransport metier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCargaison frame = new JCargaison();
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
	public JCargaison() {
		metier=new SocieteTransport();
		metier.lireFichierCargaison("gi.data");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reference  :");
		lblNewLabel.setBounds(6, 11, 90, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDistance = new JLabel("Distance :");
		lblDistance.setBounds(268, 6, 75, 16);
		contentPane.add(lblDistance);
		
		txtRef = new JTextField();
		txtRef.setBounds(103, 6, 130, 26);
		contentPane.add(txtRef);
		txtRef.setColumns(10);
		
		txtDist = new JTextField();
		txtDist.setColumns(10);
		txtDist.setBounds(342, 1, 130, 26);
		contentPane.add(txtDist);
		
		JRadioButton rdbRoutiere = new JRadioButton("Routiere");
		rdbRoutiere.setBounds(145, 34, 141, 23);
		contentPane.add(rdbRoutiere);
		
		JRadioButton rdbtnAerienne = new JRadioButton("Aerienne");
		rdbtnAerienne.setBounds(291, 34, 141, 23);
		contentPane.add(rdbtnAerienne);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(16, 39, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		
		model=new CargaisonModel();

		tableC=new JTable(model);
		JScrollPane jsp = new JScrollPane(tableC);
		jsp.setBounds(26, 73, 446, 183);
		contentPane.add(jsp);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ref=txtRef.getText();
				if (isNumeric(txtDist.getText()) && !txtRef.getText().equals("")) {
						double dis=Double.valueOf(txtDist.getText());
				
				
				Cargaison c=null;
				
				if(rdbtnAerienne.isSelected())  c= new Aerienne(ref,dis) ;
				if(rdbRoutiere.isSelected())  c= new Routiere(ref,dis) ;
				
				metier.ajouterCargaison(c);
				model.setData(metier.consultercargaisons());
				}else {
					 JOptionPane d = new JOptionPane();
						d.showMessageDialog(null, "Distance Not Number",  "le titre", JOptionPane.INFORMATION_MESSAGE);
						
						
				}
			}
		});

		btnNewButton.setBounds(383, 33, 117, 29);
		contentPane.add(btnNewButton);

		
		
	}
	
	
	
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}
