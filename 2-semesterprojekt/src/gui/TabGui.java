package gui;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.RentalController;
import databases.DataAccessException;

public class TabGui extends JFrame {
	RentalController rentalController;
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
	
	public void addAssistiveDeviceInstance(int hmi, String barcode) throws DataAccessException, SQLException {
		System.out.println("tabGui addAssistiveDevice");
		rentalController.addAssistiveDeviceInstance(hmi, barcode);
	}
	
	public RentalController getRentalController() {
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
		
		Button searchButton = new Button("S\u00F8g");
		searchButton.setBounds(276, 10, 53, 22);
		SearchAssistiveDeviceTab.add(searchButton);
		
		List list = new List();
		list.setBounds(10, 38, 319, 356);
		SearchAssistiveDeviceTab.add(list);
		
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
		
		Button rentalSearchButton = new Button("S\u00F8g");
		rentalSearchButton.setBounds(276, 10, 53, 22);
		CreateRentalTab.add(rentalSearchButton);
		
		List rentalList = new List();
		rentalList.setBounds(10, 38, 319, 356);
		CreateRentalTab.add(rentalList);
		
		TextField rentalTextField = new TextField();
		rentalTextField.setBounds(664, 38, 220, 22);
		CreateRentalTab.add(rentalTextField);
		
		TextField rentalTextField_1 = new TextField();
		rentalTextField_1.setBounds(664, 66, 220, 22);
		CreateRentalTab.add(rentalTextField_1);
		
		TextField rentalTextField_2 = new TextField();
		rentalTextField_2.setBounds(664, 94, 220, 22);
		CreateRentalTab.add(rentalTextField_2);
		
		TextField rentalTextField_3 = new TextField();
		rentalTextField_3.setBounds(664, 122, 220, 22);
		CreateRentalTab.add(rentalTextField_3);
		
		TextField rentalTextField_4 = new TextField();
		rentalTextField_4.setBounds(664, 150, 220, 22);
		CreateRentalTab.add(rentalTextField_4);
		
		TextField rentalTextField_5 = new TextField();
		rentalTextField_5.setBounds(543, 232, 211, 22);
		CreateRentalTab.add(rentalTextField_5);
		
		TextField rentalTextField_6 = new TextField();
		rentalTextField_6.setBounds(543, 260, 135, 22);
		CreateRentalTab.add(rentalTextField_6);
		
		TextField rentalTextField_7 = new TextField();
		rentalTextField_7.setBounds(543, 288, 135, 22);
		CreateRentalTab.add(rentalTextField_7);
		
		TextField rentalTextField_8 = new TextField();
		rentalTextField_8.setBounds(543, 316, 135, 22);
		CreateRentalTab.add(rentalTextField_8);
		
		Button rentalButton = new Button("Tilf\u00F8j Hj\u00E6lpemiddel");
		rentalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalController.createRental();
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
		rentalButton.setBounds(464, 372, 96, 22);
		CreateRentalTab.add(rentalButton);
		
		Button rentalButton_1 = new Button("Annuller udlejning");
		rentalButton_1.setBounds(668, 399, 106, 22);
		CreateRentalTab.add(rentalButton_1);
		
		Button rentalButton_2 = new Button("Gem udlejning");
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
		rentalLblNewLabel_8.setBounds(446, 264, 72, 14);
		CreateRentalTab.add(rentalLblNewLabel_8);
		
		JLabel rentalLblNewLabel_9 = new JLabel("SLUT DATO");
		rentalLblNewLabel_9.setBounds(446, 292, 72, 14);
		CreateRentalTab.add(rentalLblNewLabel_9);
		
		JLabel rentalLblNewLabel_10 = new JLabel("UDLEJNINGS ID");
		rentalLblNewLabel_10.setBounds(446, 320, 91, 14);
		CreateRentalTab.add(rentalLblNewLabel_10);
		
		JLabel rentalLblNewLabel_12 = new JLabel("ID #");
		rentalLblNewLabel_12.setBounds(509, 178, 46, 14);
		CreateRentalTab.add(rentalLblNewLabel_12);
		
		TextField textField_10 = new TextField();
		textField_10.setBounds(811, 232, 73, 22);
		CreateRentalTab.add(textField_10);
		
		JLabel lblNewLabel_14 = new JLabel("ID");
		lblNewLabel_14.setBounds(786, 235, 19, 14);
		CreateRentalTab.add(lblNewLabel_14);
		
		JPanel SearchResidentTab = new JPanel();
		tabbedPane.addTab("New tab", null, SearchResidentTab, null);
		SearchResidentTab.setLayout(null);
	}
}
