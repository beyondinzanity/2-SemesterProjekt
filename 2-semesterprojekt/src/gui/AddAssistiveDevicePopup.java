package gui;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.List;
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

public class AddAssistiveDevicePopup extends JFrame {
	private CreateRentalPanel createRentalPanel = new CreateRentalPanel();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAssistiveDevicePopup frame = new AddAssistiveDevicePopup();
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
	public AddAssistiveDevicePopup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List userSearchList = new List();
		userSearchList.setBounds(10, 48, 464, 260);
		contentPane.add(userSearchList);
		
		Button acceptButton = new Button("Accepter");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Add assistiveDevice to CreateRentalPanel and save selected
				System.out.println("Selected Index: " + userSearchList.getSelectedIndex());
			}
		});
		acceptButton.setBounds(404, 314, 70, 22);
		contentPane.add(acceptButton);
		
		Button cancelButton = new Button("Annuller");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Close Window
				//frame.setVisible(false);
			}
		});
		cancelButton.setBounds(328, 314, 70, 22);
		contentPane.add(cancelButton);
		
		TextField userSearchTxt = new TextField();
		userSearchTxt.setBounds(10, 20, 388, 22);
		contentPane.add(userSearchTxt);
		
		Button searchButton = new Button("S\u00F8g");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userSearchList.removeAll();
					for (AssistiveDevice q : createRentalPanel.getRentalController().getAssistiveDeviceController().findAssistiveDevices(userSearchTxt.getText())) {
						System.out.println(q.getHmiNumber() + ", " + q.getName() + ", " + q.getType());
						
						for (AssistiveDeviceInstance i : q.getDeviceInstanceList()) {
							System.out.println("\t" + i.getBarcode() + ", " + i.getRegisteredDate() + ", " + i.getNote());
							userSearchList.add(q.toString() + " - " + i.toString());
						}
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
		searchButton.setActionCommand("S\u00F8g");
		searchButton.setBounds(404, 20, 70, 22);
		contentPane.add(searchButton);
	}
}
