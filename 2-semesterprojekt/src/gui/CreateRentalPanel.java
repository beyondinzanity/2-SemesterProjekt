package gui;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RentalController;
import databases.DataAccessException;
import model.AssistiveDevice;
import model.AssistiveDeviceInstance;

public class CreateRentalPanel extends JPanel {
	private RentalController rentalController;
	
	public RentalController getRentalController() {
		return rentalController;
	}
	
	public void switchPanel(JPanel panel) {
		removeAll();
		add(panel);
		repaint();
		revalidate();
	}
	
	/**
	 * Create the panel.
	 */
	public CreateRentalPanel() {
		rentalController = new RentalController();
		setBounds(0, 0, 920, 550);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		Button button = new Button("S\u00F8g Hj\u00E6lpemiddel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switchPanel();
			}
		});
		button.setBounds(27, 25, 115, 22);
		add(button);
		
		Button button_1 = new Button("S\u00F8g Beboer");
		button_1.setBounds(152, 25, 115, 22);
		add(button_1);
		
		Button button_2 = new Button("Opret Udl\u00E5n");
		button_2.setBounds(27, 53, 240, 22);
		add(button_2);
		
		TextField userSearchTxt = new TextField();
		userSearchTxt.setBounds(27, 94, 292, 22);
		add(userSearchTxt);
		
		java.awt.List userSearchList = new java.awt.List();
		userSearchList.setBounds(27, 129, 350, 325);
		add(userSearchList);
		
		Button button_3 = new Button("S\u00F8g");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					userSearchList.removeAll();
					for (AssistiveDevice q : rentalController.getAssistiveDeviceController().findAssistiveDevices(userSearchTxt.getText())) {
						System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
						
						for (AssistiveDeviceInstance i : q.getDeviceInstanceList()) {
							System.out.println("\t" + i.getBarcode() + ", " + i.getRegisteredDate() + ", " + i.getNote());
							userSearchList.add(q.toString() + " - " + i.toString());
						}
					}
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_3.setBounds(325, 94, 52, 22);
		add(button_3);
		
		Label label = new Label("BEBOER");
		label.setBounds(463, 53, 105, 22);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(label);
		
		Label label_1 = new Label("UDL\u00C5N");
		label_1.setBounds(463, 250, 105, 22);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(label_1);
		
		Label label_2 = new Label("//TODO_LOGIN_INFO");
		label_2.setBounds(758, 10, 115, 22);
		add(label_2);
		
		Label label_3 = new Label("HJ\u00C6LPEMIDDEL");
		label_3.setBounds(454, 291, 85, 22);
		add(label_3);
		
		Label label_4 = new Label("START DATO");
		label_4.setBounds(454, 319, 85, 22);
		add(label_4);
		
		Label label_5 = new Label("SLUT DATO");
		label_5.setBounds(454, 347, 85, 22);
		add(label_5);
		
		Label label_6 = new Label("UDLEJNINGS ID");
		label_6.setBounds(454, 375, 85, 22);
		add(label_6);
		
		Label label_7 = new Label("NAVN");
		label_7.setBounds(595, 83, 62, 22);
		add(label_7);
		
		Label label_8 = new Label("CPR-NR");
		label_8.setBounds(595, 111, 62, 22);
		add(label_8);
		
		Label label_9 = new Label("ADRESSE");
		label_9.setBounds(595, 139, 62, 22);
		add(label_9);
		
		Label label_10 = new Label("BOLIG NUMMER");
		label_10.setBounds(595, 167, 85, 22);
		add(label_10);
		
		Label label_11 = new Label("KOMMUNE");
		label_11.setBounds(595, 195, 62, 22);
		add(label_11);
		
		Label label_12 = new Label("ID #");
		label_12.setBounds(618, 224, 62, 22);
		add(label_12);
		
		Button button_4 = new Button("Tilf\u00F8j hj\u00E6lpemiddel");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAssistiveDevicePopup assistiveDevicePopup = new AddAssistiveDevicePopup();
				assistiveDevicePopup.setVisible(true);
			}
		});
		button_4.setBounds(454, 432, 114, 22);
		add(button_4);
		
		Button button_5 = new Button("Annuller udlejning");
		button_5.setBounds(596, 471, 115, 22);
		add(button_5);
		
		Button button_6 = new Button("Gem Udlejning");
		button_6.setBounds(728, 471, 115, 22);
		add(button_6);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(545, 291, 190, 22);
		add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(545, 319, 133, 22);
		add(textField_2);
		
		Label label_13 = new Label("ID");
		label_13.setBounds(754, 291, 17, 22);
		add(label_13);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(777, 291, 75, 22);
		add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(545, 347, 133, 22);
		add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(545, 375, 133, 22);
		add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(686, 167, 166, 22);
		add(textField_6);
		
		TextField textField_7 = new TextField();
		textField_7.setBounds(686, 195, 166, 22);
		add(textField_7);
		
		TextField textField_8 = new TextField();
		textField_8.setBounds(686, 83, 166, 22);
		add(textField_8);
		
		TextField textField_9 = new TextField();
		textField_9.setBounds(686, 111, 166, 22);
		add(textField_9);
		
		TextField textField_10 = new TextField();
		textField_10.setBounds(686, 139, 166, 22);
		add(textField_10);
		
		

	}
}
