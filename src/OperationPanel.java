import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class OperationPanel extends JPanel implements ActionListener {
	public BarFrame root;
	public JButton newOrderButton;
	public JButton addToExistingOrderButton;
	public JButton getBillButton;
	private JButton exitButton;

	public OperationPanel(BarFrame root) {
		setBackground(SystemColor.textHighlight);
		this.root = root;

		showLayout();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton enter = (JButton) e.getSource();

		if (enter == newOrderButton) {
			root.operation = 0;
			root.showTablesPanel("Operation Panel");
		} else if (enter == addToExistingOrderButton) {
			root.operation = 1;
			root.showTablesPanel("Operation Panel");
		} else if (enter == getBillButton) {
			root.operation = 2;
			root.showTablesPanel("Operation Panel");
			
		}

	}

	public void showLayout() {
		newOrderButton = new JButton("New Order");
		newOrderButton.setBackground(SystemColor.control);
		newOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		newOrderButton.addActionListener(this);

		addToExistingOrderButton = new JButton("Add to existing order");
		addToExistingOrderButton.setBackground(SystemColor.control);
		addToExistingOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addToExistingOrderButton.addActionListener(this);

		getBillButton = new JButton("Get bill");
		getBillButton.setBackground(SystemColor.control);
		getBillButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getBillButton.addActionListener(this);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.showLoginScreen("Operation Panel");
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		exitButton.setBackground(SystemColor.menu);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(202)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
						.addComponent(getBillButton, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
						.addComponent(addToExistingOrderButton, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
						.addComponent(newOrderButton, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(217, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(137)
					.addComponent(newOrderButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addToExistingOrderButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBillButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		setLayout(groupLayout);
	}
}
