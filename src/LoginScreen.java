import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginScreen extends JPanel {

	public BarFrame root;
	private JPasswordField passwordField;
	private char[] input;

	public LoginScreen(BarFrame root) {
		setBackground(SystemColor.textHighlight);
		setForeground(Color.WHITE);
		this.root = root;
		showLayout();

	}

	public void showLayout() {

		JLabel loginLabel = new JLabel("Waitress Login");
		loginLabel.setForeground(SystemColor.text);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(SystemColor.control);
		btnEnter.setForeground(SystemColor.desktop);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input = passwordField.getPassword();
				checkPassword();
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 24));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setEchoChar('*');
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(253)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField).addComponent(loginLabel, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(268).addComponent(btnEnter,
								GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(292, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(114).addComponent(loginLabel).addGap(18)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(322, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	public void checkPassword() {
		boolean isFound = false;
		String pass = new String(input);
		for (Waitresses waitress : root.waitress) {
			if (pass.equals(waitress.password)) {
				root.showOperationPanel();
				isFound = true;
				break;
			}

		}
		if (!isFound) {
			JOptionPane.showMessageDialog(null, "User does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
