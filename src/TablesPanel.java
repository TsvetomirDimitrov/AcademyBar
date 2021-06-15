import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.SystemColor;

public class TablesPanel extends JPanel implements ActionListener {
	public BarFrame root;
	public JButton firstTableButton;
	public JButton secondTableButton;
	public JButton thirdTableButton;
	public JButton fourthTableButton;
	public JButton fifthTableButton;
	public JButton sixthTableButton;
	public JButton tableNum;

	public TablesPanel(BarFrame root) {
		setBackground(SystemColor.textHighlight);
		this.root = root;

		showLayout();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tableNum = (JButton) e.getSource();
		int tableNumber = Integer.parseInt(tableNum.getText());
		if (root.operation == 0) {
			if (root.tables.get(tableNumber).isEmpty()) {
				root.changeToProductPanel((Integer.parseInt(tableNum.getText())), "Tables Panel");
			} else {
				JOptionPane.showMessageDialog(null, "Table " + tableNumber + " already has an existing order.",
						"Whoops", JOptionPane.OK_OPTION);
			}

		} else if (root.operation == 1) {

			if (root.tables.get(tableNumber).isEmpty()) {
				int option = JOptionPane.showConfirmDialog(null,
						"No existing order on table " + tableNumber + ". Would you like to create a new one?", "Whoops",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					root.operation = 0;
					root.changeToProductPanel((Integer.parseInt(tableNum.getText())), "Tables Panel");
				}
			} else {
				root.changeToProductPanel((Integer.parseInt(tableNum.getText())), "Tables Panel");
			}
		} else {
			double total = 0;
			for (String product : root.tables.get(Integer.parseInt(tableNum.getText()))) {
				for (Map.Entry<String, Double> entry : root.products.entrySet()) {
					if (product.equals(entry.getKey())) {
						total += entry.getValue();
					}
				}
			}
			if (total == 0) {
				JOptionPane.showMessageDialog(null, "Table " + tableNumber + " does not have any orders.", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				root.getBillPanel(tableNumber);
			}
		}

	}

	public void showLayout() {
		JLabel choseTableLabel = new JLabel("Chose Table");
		choseTableLabel.setForeground(SystemColor.text);
		choseTableLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		choseTableLabel.setHorizontalAlignment(SwingConstants.CENTER);

		firstTableButton = new JButton("1");
		firstTableButton.setBackground(SystemColor.control);
		firstTableButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		firstTableButton.addActionListener(this);

		secondTableButton = new JButton("2");
		secondTableButton.setBackground(SystemColor.control);
		secondTableButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		secondTableButton.addActionListener(this);

		thirdTableButton = new JButton("3");
		thirdTableButton.setBackground(SystemColor.control);
		thirdTableButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		thirdTableButton.addActionListener(this);

		fourthTableButton = new JButton("4");
		fourthTableButton.setBackground(SystemColor.control);
		fourthTableButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		fourthTableButton.addActionListener(this);

		fifthTableButton = new JButton("5");
		fifthTableButton.setBackground(SystemColor.control);
		fifthTableButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		fifthTableButton.addActionListener(this);

		sixthTableButton = new JButton("6");
		sixthTableButton.setBackground(SystemColor.control);
		sixthTableButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		sixthTableButton.addActionListener(this);

		JButton backButton = new JButton("Back");
		backButton.setBackground(SystemColor.control);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				root.backFromTables();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 24));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(192).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(firstTableButton, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(secondTableButton, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(thirdTableButton, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(fourthTableButton, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(fifthTableButton, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(sixthTableButton, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup().addGap(251).addComponent(choseTableLabel,
								GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(258).addComponent(backButton,
								GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(196, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(choseTableLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE).addGap(34)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(firstTableButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(secondTableButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(thirdTableButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fourthTableButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(fifthTableButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(sixthTableButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
				.addGap(136).addComponent(backButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(136, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
}
