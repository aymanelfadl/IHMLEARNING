package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Aerienne;
import metier.Cargaison;
import metier.Routiere;
import metier.SocieteTransport;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRef;
	private JTextField txtDistance;
	
	SocieteTransport metier;
	JTable tableCargaison;
	CargaisonModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCar frame = new JCar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
	/**
	 * Create the frame.
	 */
	public JCar() {
		metier=new SocieteTransport();
		model=new CargaisonModel();
		metier.lireFichierCargaison("gi.data");
		model.setData(metier.consultercargaisons());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reference : ");
		lblNewLabel.setBounds(26, 6, 73, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDistance = new JLabel("Distance :");
		lblDistance.setBounds(228, 6, 73, 16);
		contentPane.add(lblDistance);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(36, 38, 73, 16);
		contentPane.add(lblType);
		
		txtRef = new JTextField();
		txtRef.setBounds(97, 1, 116, 26);
		contentPane.add(txtRef);
		txtRef.setColumns(10);
		
		txtDistance = new JTextField();
		txtDistance.setColumns(10);
		txtDistance.setBounds(311, 1, 116, 26);
		contentPane.add(txtDistance);
		
		JRadioButton rdbAerienne = new JRadioButton("Aerienne");
		rdbAerienne.setBounds(90, 34, 108, 23);
		contentPane.add(rdbAerienne);
		
		JRadioButton rdbtnRoutiere = new JRadioButton("Routiere");
		rdbtnRoutiere.setBounds(294, 34, 108, 23);
		contentPane.add(rdbtnRoutiere);
		
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnRoutiere);
		btnGroup.add(rdbAerienne);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String ref = txtRef.getText();
			     String distanceText = txtDistance.getText();
			        if (!ref.isEmpty() && !distanceText.isEmpty()) {
			            try {
			                double distance = Double.parseDouble(distanceText);
			                Cargaison c = rdbAerienne.isSelected() ? new Aerienne(ref, distance) : new Routiere(ref, distance);

			                metier.ajouterCargaison(c);
			                model.setData(metier.consultercargaisons());
			                
			            } catch (NumberFormatException ex) {
			                showErrorDialog("Invalid distance value. Please enter a valid number.");
			            }
			        } else {
			            showErrorDialog("The inputs are empty!");
			        }
			    }
		});
		btnAjouter.setBounds(26, 66, 117, 29);
		contentPane.add(btnAjouter);
		
		tableCargaison=new JTable(model);
		
		JScrollPane jsp = new JScrollPane(tableCargaison);
		jsp.setBounds(26, 107, 400, 134);
		contentPane.add(jsp);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableCargaison.getSelectedRow();
				System.out.println(index);
				if(index != -1) {
					String Ref = (String) tableCargaison.getValueAt(index, 0);
					Cargaison c = metier.consulterCargaisonParRef(Ref);
					metier.supprimerCargaison(c);
					System.out.print(c.getReference());	
					model.removeRow(index);
				}else {
                    showErrorDialog("No row selected for deletion");
                }
			}
		});
		btnDelete.setBounds(152, 66, 116, 28);
		contentPane.add(btnDelete);
	}
}
