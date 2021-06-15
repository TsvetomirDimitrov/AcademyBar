import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NonAlcoholPanel extends JPanel implements ActionListener {

	public BarFrame root;
	private JTable table;
	private int tableNum;
	private DefaultTableModel tableModel;
	private ArrayList<String> selectedNonAlcohol = new ArrayList<String>();

	public NonAlcoholPanel(BarFrame root, int tableNum) {
		setBackground(SystemColor.textHighlight);
		this.root = root;
		this.tableNum = tableNum;

		JButton colaButton = new JButton("Coca Cola");
		colaButton.setBackground(SystemColor.control);
		colaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		colaButton.addActionListener(this);

		JButton fantaButton = new JButton("Fanta\r\n ");
		fantaButton.setBackground(SystemColor.control);
		fantaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fantaButton.addActionListener(this);

		JButton spriteButton = new JButton("Sprite");
		spriteButton.setBackground(SystemColor.control);
		spriteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spriteButton.addActionListener(this);

		JButton waterButton = new JButton("Water");
		waterButton.setBackground(SystemColor.control);
		waterButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		waterButton.addActionListener(this);

		JButton freshButton = new JButton("Orange Fresh");
		freshButton.setBackground(SystemColor.control);
		freshButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		freshButton.addActionListener(this);

		JButton nesteaButton = new JButton("Nestea");
		nesteaButton.setBackground(SystemColor.control);
		nesteaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nesteaButton.addActionListener(this);

		JButton coffeeButton = new JButton("Coffee");
		coffeeButton.setBackground(SystemColor.control);
		coffeeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		coffeeButton.addActionListener(this);

		JButton cappuccinoButton = new JButton("Cappuccino");
		cappuccinoButton.setBackground(SystemColor.control);
		cappuccinoButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cappuccinoButton.addActionListener(this);

		JButton mochaButton = new JButton("Mochaccino");
		mochaButton.setBackground(SystemColor.control);
		mochaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mochaButton.addActionListener(this);

		JButton turkCoffeeButton = new JButton("Turkish Coffee");
		turkCoffeeButton.setBackground(SystemColor.control);
		turkCoffeeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		turkCoffeeButton.addActionListener(this);

		JButton decafButton = new JButton("Decaf Coffee");
		decafButton.setBackground(SystemColor.control);
		decafButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		decafButton.addActionListener(this);

		JButton iceCoffee = new JButton("Ice Coffee");
		iceCoffee.setBackground(SystemColor.control);
		iceCoffee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iceCoffee.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		JButton eraseButton = new JButton("Erase");
		eraseButton.setBackground(SystemColor.control);
		eraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() > 0) {
					tableModel.removeRow(selectedNonAlcohol.size() - 1);
					selectedNonAlcohol.remove(selectedNonAlcohol.size() - 1);
				} else {
					JOptionPane.showMessageDialog(null, "nothing to erase", "error", JOptionPane.OK_OPTION);
				}
			}
		});
		eraseButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(SystemColor.control);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel the order?",
						"Warning", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					selectedNonAlcohol.clear();
					root.changeToProductPanel(tableNum, "Non Alcohol Panel");
				}
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton enterButton = new JButton("Enter");
		enterButton.setBackground(SystemColor.control);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to add selected products to order?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					for (String string : selectedNonAlcohol) {
						root.chosenProducts.add(string);
						root.tables.get(tableNum).addAll(root.chosenProducts);
						System.out.println(string);
					}
					int continueAdding = JOptionPane.showConfirmDialog(null,
							"Would you like to add more products to order?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (continueAdding == JOptionPane.YES_OPTION) {
						root.changeToProductPanel(tableNum, "Non Alcohol Panel");
					} else {
						root.showLoginScreen("Non Alcohol Panel");
					}
				}
				// root.changeToHome("Non Alcohol Panel");
			}
		});
		enterButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(191).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(fantaButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(freshButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(cappuccinoButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														decafButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(colaButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(waterButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(coffeeButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(turkCoffeeButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(spriteButton, GroupLayout.PREFERRED_SIZE,
																		167, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(nesteaButton, GroupLayout.PREFERRED_SIZE,
																		167, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(mochaButton, GroupLayout.PREFERRED_SIZE,
																		167, GroupLayout.PREFERRED_SIZE))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(eraseButton, GroupLayout.PREFERRED_SIZE,
																		169, GroupLayout.PREFERRED_SIZE)
																.addGap(74).addComponent(cancelButton,
																		GroupLayout.PREFERRED_SIZE, 195,
																		GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(enterButton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(iceCoffee, GroupLayout.DEFAULT_SIZE, 167,
																Short.MAX_VALUE))))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(44)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(colaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(waterButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(coffeeButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(turkCoffeeButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fantaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(freshButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cappuccinoButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(decafButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(iceCoffee, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(mochaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(nesteaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(spriteButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGap(32)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(eraseButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		String[] columns = { "Selected Products" };

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setEnabled(false);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);

		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}

	ArrayList<String> temp = new ArrayList<String>();

	int current = 0;

	public void actionPerformed(ActionEvent e) {
		JButton selected = (JButton) e.getSource();

		selectedNonAlcohol.add(selected.getText());
		Object[] row = new Object[1];
		row[0] = selected.getText().toString();
		tableModel.addRow(row);

	}
}
