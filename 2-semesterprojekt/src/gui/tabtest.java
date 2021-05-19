package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class tabtest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabtest frame = new tabtest();
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
	public tabtest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 421, 0 };
		gbl_panel.rowHeights = new int[] { 34, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JTextPane txtpnHelloWorld = new JTextPane();
		txtpnHelloWorld.setText("Hello world!");
		GridBagConstraints gbc_txtpnHelloWorld = new GridBagConstraints();
		gbc_txtpnHelloWorld.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnHelloWorld.fill = GridBagConstraints.BOTH;
		gbc_txtpnHelloWorld.gridx = 0;
		gbc_txtpnHelloWorld.gridy = 0;
		panel.add(txtpnHelloWorld, gbc_txtpnHelloWorld);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 173, 75, 0 };
		gbl_panel_1.rowHeights = new int[] { 19, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JTextPane txtpnGoodbyeWorld_1 = new JTextPane();
		txtpnGoodbyeWorld_1.setText("Goodbye world");
		GridBagConstraints gbc_txtpnGoodbyeWorld_1 = new GridBagConstraints();
		gbc_txtpnGoodbyeWorld_1.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnGoodbyeWorld_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtpnGoodbyeWorld_1.gridx = 0;
		gbc_txtpnGoodbyeWorld_1.gridy = 0;
		panel_1.add(txtpnGoodbyeWorld_1, gbc_txtpnGoodbyeWorld_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("button");
		btnNewButton.setBounds(331, 6, 85, 21);
		panel_2.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Click button --->");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(220, 10, 111, 17);
		panel_2.add(lblNewLabel);
	}
}
