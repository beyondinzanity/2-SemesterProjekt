package gui;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.RentalController;
import databases.DataAccessException;
import model.Resident;

public class TabGui extends JFrame {
	private static RentalController rentalController;
	public static TextField rentalAssistiveDeviceTxt;
	public static TextField rentalAssistiveDeviceIdTxt;
	private ArrayList<String> ssnList = new ArrayList<>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabGui frame = new TabGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getMain() {
		return TabGui.this;
	}
	
	public static void addAssistiveDeviceInstance(int hmi, String barcode) throws DataAccessException, SQLException {
		rentalController.addAssistiveDeviceInstance(hmi, barcode);
	}
	
	public void addResident(String ssn) throws DataAccessException {
		rentalController.setResident(ssn);
	}
	
	public static RentalController getRentalController() {
		return rentalController;
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws DataAccessException 
	 */
	public TabGui() throws DataAccessException, SQLException {
		rentalController = new RentalController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 914, 449);
		contentPane.add(tabbedPane);
		
		JPanel SearchAssistiveDeviceTab = new JPanel();
		tabbedPane.addTab("S\u00F8g Hj\u00E6lpemiddel", null, SearchAssistiveDeviceTab, null);
		SearchAssistiveDeviceTab.setLayout(null);
		
		TextField userSearchTxt = new TextField();
		userSearchTxt.setBounds(10, 10, 260, 22);
		SearchAssistiveDeviceTab.add(userSearchTxt);
		
		List userSearchList = new List();
		userSearchList.setBounds(10, 38, 319, 356);
		SearchAssistiveDeviceTab.add(userSearchList);
		
		Button searchButton = new Button("S\u00F8g");
		searchButton.setBounds(276, 10, 53, 22);
		SearchAssistiveDeviceTab.add(searchButton);
		
		TextField textField = new TextField();
		textField.setBounds(664, 38, 220, 22);
		SearchAssistiveDeviceTab.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(664, 66, 220, 22);
		SearchAssistiveDeviceTab.add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(664, 94, 220, 22);
		SearchAssistiveDeviceTab.add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(664, 122, 220, 22);
		SearchAssistiveDeviceTab.add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(664, 150, 220, 22);
		SearchAssistiveDeviceTab.add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(524, 232, 154, 22);
		SearchAssistiveDeviceTab.add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(524, 260, 154, 22);
		SearchAssistiveDeviceTab.add(textField_6);
		
		TextField textField_7 = new TextField();
		textField_7.setBounds(524, 288, 154, 22);
		SearchAssistiveDeviceTab.add(textField_7);
		
		TextField textField_8 = new TextField();
		textField_8.setBounds(524, 316, 154, 22);
		SearchAssistiveDeviceTab.add(textField_8);
		
		TextField textField_9 = new TextField();
		textField_9.setBounds(524, 344, 154, 22);
		SearchAssistiveDeviceTab.add(textField_9);
		
		Button button = new Button("Tilf\u00F8j Hj\u00E6lpemiddel");
		button.setBounds(436, 372, 124, 22);
		SearchAssistiveDeviceTab.add(button);
		
		Button button_1 = new Button("Annuller udlejning");
		button_1.setBounds(668, 399, 106, 22);
		SearchAssistiveDeviceTab.add(button_1);
		
		Button button_2 = new Button("Gem udlejning");
		button_2.setBounds(791, 399, 106, 22);
		SearchAssistiveDeviceTab.add(button_2);
		
		JLabel lblNewLabel = new JLabel("BEBOER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(436, 10, 119, 22);
		SearchAssistiveDeviceTab.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HJ\u00C6LPEMIDDEL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(436, 200, 168, 21);
		SearchAssistiveDeviceTab.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAVN");
		lblNewLabel_2.setBounds(587, 42, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPR-NR");
		lblNewLabel_3.setBounds(587, 71, 51, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADDRESSE");
		lblNewLabel_4.setBounds(587, 98, 64, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BOLIG NR.");
		lblNewLabel_5.setBounds(587, 126, 64, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("KOMMUNE");
		lblNewLabel_6.setBounds(587, 154, 75, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("NAVN");
		lblNewLabel_7.setBounds(446, 236, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("TYPE");
		lblNewLabel_8.setBounds(446, 263, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("STATUS");
		lblNewLabel_9.setBounds(446, 291, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("HMI");
		lblNewLabel_10.setBounds(446, 316, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("EJER");
		lblNewLabel_11.setBounds(446, 344, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("ID #");
		lblNewLabel_12.setBounds(509, 178, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_12);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(703, 232, 181, 134);
		SearchAssistiveDeviceTab.add(textArea);
		
		JLabel lblNewLabel_13 = new JLabel("NOTE");
		lblNewLabel_13.setBounds(703, 208, 46, 14);
		SearchAssistiveDeviceTab.add(lblNewLabel_13);
		
		//RENTAL TAB!
		JPanel CreateRentalTab = new JPanel();
		tabbedPane.addTab("Opret Udl\u00E5n", null, CreateRentalTab, null);
		CreateRentalTab.setLayout(null);
		
		TextField rentalUserSearchTxt = new TextField();
		rentalUserSearchTxt.setBounds(10, 10, 260, 22);
		CreateRentalTab.add(rentalUserSearchTxt);

		List rentalUserSearchList = new List();
		rentalUserSearchList.setBounds(10, 38, 319, 356);
		CreateRentalTab.add(rentalUserSearchList);
		
		Button rentalSearchButton = new Button("S\u00F8g");
		rentalSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rentalUserSearchList.removeAll();
					for (Resident res : TabGui.getRentalController().findResidentBySsn(rentalUserSearchTxt.getText())) {
						rentalUserSearchList.add(res.getSsn() + " - " + res.getFname() + " " + res.getLname());
						ssnList.add(res.getSsn());
					}
					
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(); 
				}
				
				
			}
		});
		rentalSearchButton.setBounds(276, 10, 53, 22);
		CreateRentalTab.add(rentalSearchButton);
		
		
		TextField rentalResidentNameTxt = new TextField();
		rentalResidentNameTxt.setBounds(664, 38, 220, 22);
		CreateRentalTab.add(rentalResidentNameTxt);
		
		TextField rentalResidentSsnTxt = new TextField();
		rentalResidentSsnTxt.setBounds(664, 66, 220, 22);
		CreateRentalTab.add(rentalResidentSsnTxt);
		
		TextField rentalResidentAddressTxt = new TextField();
		rentalResidentAddressTxt.setBounds(664, 94, 220, 22);
		CreateRentalTab.add(rentalResidentAddressTxt);
		
		TextField rentalResidentApartmentNrTxt = new TextField();
		rentalResidentApartmentNrTxt.setBounds(664, 122, 220, 22);
		CreateRentalTab.add(rentalResidentApartmentNrTxt);
		
		TextField rentalResidentMunicipalityTxt = new TextField();
		rentalResidentMunicipalityTxt.setBounds(664, 150, 220, 22);
		CreateRentalTab.add(rentalResidentMunicipalityTxt);
		
		rentalAssistiveDeviceTxt = new TextField();
		rentalAssistiveDeviceTxt.setBounds(543, 232, 211, 22);
		CreateRentalTab.add(rentalAssistiveDeviceTxt);
		
		rentalAssistiveDeviceIdTxt = new TextField();
		rentalAssistiveDeviceIdTxt.setBounds(811, 232, 73, 22);
		CreateRentalTab.add(rentalAssistiveDeviceIdTxt);
		
		TextField rentalStartDateTxt = new TextField();
		rentalStartDateTxt.setBounds(543, 260, 135, 22);
		CreateRentalTab.add(rentalStartDateTxt);
		
		TextField rentalEndDateTxt = new TextField();
		rentalEndDateTxt.setBounds(543, 288, 135, 22);
		CreateRentalTab.add(rentalEndDateTxt);
		
		TextField rentalRentalIdTxt = new TextField();
		rentalRentalIdTxt.setBounds(543, 316, 135, 22);
		CreateRentalTab.add(rentalRentalIdTxt);
		
		Button rentalButton = new Button("Tilf\u00F8j Hj\u00E6lpemiddel");
		rentalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddAssistiveDevicePopup assistiveDevicePopup = null;
				try {
					assistiveDevicePopup = new AddAssistiveDevicePopup();
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assistiveDevicePopup.setVisible(true);
			}
		});
		rentalButton.setBounds(436, 372, 124, 22);
		CreateRentalTab.add(rentalButton);
		
		Button rentalButton_1 = new Button("Annuller udlejning");
		rentalButton_1.setBounds(668, 399, 106, 22);
		CreateRentalTab.add(rentalButton_1);
		
		Button rentalButton_2 = new Button("Gem udlejning");
		rentalButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalController.setDate(rentalStartDateTxt.getText(), rentalEndDateTxt.getText());

				System.out.println("Resident: " + rentalController.getRental().getResident());
				System.out.println("AssistiveDeviceInstance: " + rentalController.getRental().getAssistiveDeviceInstance());
				System.out.println("Employee: " + rentalController.getRental().getEmployee());
				System.out.println("StartDate: " + rentalController.getRental().getStartDate());
				System.out.println("EndDate: " + rentalController.getRental().getEndDate());
				System.out.println("RentalNumber: " + rentalController.getRental().getRentalNumber());
				
				try {
					rentalController.endRental();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		rentalButton_2.setBounds(791, 399, 106, 22);
		CreateRentalTab.add(rentalButton_2);
		
		JLabel rentalLblNewLabel = new JLabel("BEBOER");
		rentalLblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rentalLblNewLabel.setBounds(436, 10, 119, 22);
		CreateRentalTab.add(rentalLblNewLabel);
		
		JLabel rentalLblNewLabel_1 = new JLabel("HJ\u00C6LPEMIDDEL");
		rentalLblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rentalLblNewLabel_1.setBounds(436, 200, 168, 21);
		CreateRentalTab.add(rentalLblNewLabel_1);
		
		JLabel rentalLblNewLabel_2 = new JLabel("NAVN");
		rentalLblNewLabel_2.setBounds(587, 42, 75, 14);
		CreateRentalTab.add(rentalLblNewLabel_2);
		
		JLabel rentalLblNewLabel_3 = new JLabel("CPR-NR");
		rentalLblNewLabel_3.setBounds(587, 71, 79, 14);
		CreateRentalTab.add(rentalLblNewLabel_3);
		
		JLabel rentalLblNewLabel_4 = new JLabel("ADDRESSE");
		rentalLblNewLabel_4.setBounds(587, 98, 75, 14);
		CreateRentalTab.add(rentalLblNewLabel_4);
		
		JLabel rentalLblNewLabel_5 = new JLabel("BOLIG NR.");
		rentalLblNewLabel_5.setBounds(587, 126, 79, 14);
		CreateRentalTab.add(rentalLblNewLabel_5);
		
		JLabel rentalLblNewLabel_6 = new JLabel("KOMMUNE");
		rentalLblNewLabel_6.setBounds(587, 154, 75, 14);
		CreateRentalTab.add(rentalLblNewLabel_6);
		
		JLabel rentalLblNewLabel_7 = new JLabel("HJ\u00C6LPEMIDDEL");
		rentalLblNewLabel_7.setBounds(446, 236, 91, 14);
		CreateRentalTab.add(rentalLblNewLabel_7);
		
		JLabel rentalLblNewLabel_8 = new JLabel("START DATO");
		rentalLblNewLabel_8.setBounds(446, 264, 91, 14);
		CreateRentalTab.add(rentalLblNewLabel_8);
		
		JLabel rentalLblNewLabel_9 = new JLabel("SLUT DATO");
		rentalLblNewLabel_9.setBounds(446, 292, 91, 14);
		CreateRentalTab.add(rentalLblNewLabel_9);
		
		JLabel rentalLblNewLabel_10 = new JLabel("UDLEJNINGS ID");
		rentalLblNewLabel_10.setBounds(446, 320, 91, 14);
		CreateRentalTab.add(rentalLblNewLabel_10);
		
		JLabel rentalLblNewLabel_12 = new JLabel("ID #");
		rentalLblNewLabel_12.setBounds(558, 176, 46, 14);
		CreateRentalTab.add(rentalLblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("HMI");
		lblNewLabel_14.setBounds(768, 235, 37, 14);
		CreateRentalTab.add(lblNewLabel_14);
		
		Button button_3 = new Button("Tilf\u00F8j valgt person");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentalController.createRental();
				rentalController.setEmployee();
				int randomRentalNumber = (int) (System.currentTimeMillis() * -1);
				rentalController.setRentalNumber(randomRentalNumber);
				String ssn = ssnList.get(rentalUserSearchList.getSelectedIndex());
				try {
					addResident(ssn);
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rentalRentalIdTxt.setText(String.valueOf(randomRentalNumber));
				rentalResidentNameTxt.setText(rentalController.getRental().getResident().getFname() + " " + rentalController.getRental().getResident().getLname());
				rentalResidentSsnTxt.setText(rentalController.getRental().getResident().getSsn());
				rentalResidentAddressTxt.setText(rentalController.getRental().getResident().getStreetName());
				rentalResidentApartmentNrTxt.setText(String.valueOf(rentalController.getRental().getResident().getHouseNumber()));
				rentalResidentMunicipalityTxt.setText(rentalController.getRental().getResident().getResidencyList().get(rentalController.getRental().getResident().getResidencyList().size() - 1).getMunicipality().getName());
				
			}
		});
		button_3.setBounds(433, 172, 106, 22);
		CreateRentalTab.add(button_3);
		
		JPanel SearchResidentTab = new JPanel();
		tabbedPane.addTab("New tab", null, SearchResidentTab, null);
		SearchResidentTab.setLayout(null);
	}
	

}
