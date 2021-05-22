package gui;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databases.DataAccessException;

public class SearchAssistiveDevice extends JFrame {

	private JPanel contentPane;
	private JPanel createRentalPane = new CreateRentalPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchAssistiveDevice frame = new SearchAssistiveDevice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public SearchAssistiveDevice() throws DataAccessException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Button button = new Button("S\u00F8g Hj\u00E6lpemiddel");
		button.setBounds(27, 25, 119, 22);
		contentPane.add(button);

		Button button_1 = new Button("S\u00F8g Beboer");
		button_1.setBounds(152, 25, 115, 22);
		contentPane.add(button_1);

		Button button_2 = new Button("Opret Udl\u00E5n");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(createRentalPane);
			}
		});

		button_2.setBounds(27, 53, 240, 22);
		contentPane.add(button_2);

		TextField textField = new TextField();
		textField.setBounds(27, 94, 292, 22);
		contentPane.add(textField);

		Button button_3 = new Button("S\u00F8g");
		button_3.setBounds(325, 94, 52, 22);
		contentPane.add(button_3);

		List list = new List();
		list.setBounds(27, 122, 350, 332);
		contentPane.add(list);

		Label label = new Label("BEBOER");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBounds(463, 53, 105, 22);
		contentPane.add(label);

		Label label_1 = new Label("HJ\u00C6LPEMIDDEL");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_1.setBounds(463, 250, 160, 22);
		contentPane.add(label_1);

		Label label_2 = new Label("//TODO_LOGIN_INFO");
		label_2.setBounds(740, 10, 133, 22);
		contentPane.add(label_2);

		Label label_3 = new Label("NAVN");
		label_3.setBounds(454, 291, 85, 22);
		contentPane.add(label_3);

		Label label_4 = new Label("TYPE");
		label_4.setBounds(454, 319, 75, 22);
		contentPane.add(label_4);

		Label label_5 = new Label("STATUS");
		label_5.setBounds(454, 347, 62, 22);
		contentPane.add(label_5);

		Label label_6 = new Label("HMI");
		label_6.setBounds(454, 375, 85, 22);
		contentPane.add(label_6);

		Label label_7 = new Label("NAVN");
		label_7.setBounds(595, 83, 62, 22);
		contentPane.add(label_7);

		Label label_8 = new Label("CPR-NR");
		label_8.setBounds(595, 111, 62, 22);
		contentPane.add(label_8);

		Label label_9 = new Label("ADRESSE");
		label_9.setBounds(595, 139, 62, 22);
		contentPane.add(label_9);

		Label label_10 = new Label("BOLIG NUMMER");
		label_10.setBounds(595, 167, 85, 22);
		contentPane.add(label_10);

		Label label_11 = new Label("KOMMUNE");
		label_11.setBounds(595, 195, 62, 22);
		contentPane.add(label_11);

		Label label_12 = new Label("ID #");
		label_12.setBounds(618, 224, 62, 22);
		contentPane.add(label_12);

		Button button_4 = new Button("Tilf\u00F8j hj\u00E6lpemiddel");
		button_4.setBounds(454, 432, 124, 22);
		contentPane.add(button_4);

		Button button_5 = new Button("Annuller udlejning");
		button_5.setBounds(596, 471, 115, 22);
		contentPane.add(button_5);

		Button button_6 = new Button("Gem Udlejning");
		button_6.setBounds(728, 471, 115, 22);
		contentPane.add(button_6);

		TextField textField_1 = new TextField();
		textField_1.setBounds(545, 291, 133, 22);
		contentPane.add(textField_1);

		TextField textField_2 = new TextField();
		textField_2.setBounds(545, 319, 133, 22);
		contentPane.add(textField_2);

		TextField textField_4 = new TextField();
		textField_4.setBounds(545, 347, 133, 22);
		contentPane.add(textField_4);

		TextField textField_5 = new TextField();
		textField_5.setBounds(545, 375, 133, 22);
		contentPane.add(textField_5);

		TextField textField_6 = new TextField();
		textField_6.setBounds(686, 167, 166, 22);
		contentPane.add(textField_6);

		TextField textField_7 = new TextField();
		textField_7.setBounds(686, 195, 166, 22);
		contentPane.add(textField_7);

		TextField textField_8 = new TextField();
		textField_8.setBounds(686, 83, 166, 22);
		contentPane.add(textField_8);

		TextField textField_9 = new TextField();
		textField_9.setBounds(686, 111, 166, 22);
		contentPane.add(textField_9);

		TextField textField_10 = new TextField();
		textField_10.setBounds(686, 139, 166, 22);
		contentPane.add(textField_10);

		Label label_14 = new Label("EJER");
		label_14.setBounds(454, 403, 62, 22);
		contentPane.add(label_14);

		TextField textField_11 = new TextField();
		textField_11.setBounds(545, 403, 133, 22);
		contentPane.add(textField_11);

		TextArea textArea = new TextArea();
		textArea.setBounds(684, 291, 200, 163);
		contentPane.add(textArea);

		Label label_13 = new Label("NOTE");
		label_13.setBounds(686, 266, 62, 22);
		contentPane.add(label_13);

	}
}
