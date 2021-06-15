import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class BeerPanel extends JPanel implements ActionListener {
	public BarFrame root;
	private JTable table;
	private int tableNum;
	private DefaultTableModel tableModel;
	private ArrayList<String> selectedBeer = new ArrayList<String>();

	public BeerPanel(BarFrame root, int tableNum) {
		setBackground(SystemColor.textHighlight);
		this.root = root;
		this.tableNum = tableNum;

		JButton kamenitzaButton = new JButton("Kamenitza ");
		kamenitzaButton.setBackground(SystemColor.control);
		kamenitzaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		kamenitzaButton.addActionListener(this);

		JButton stelaButton = new JButton("Stella Artois");
		stelaButton.setBackground(SystemColor.control);
		stelaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		stelaButton.addActionListener(this);

		JButton staropramenButton = new JButton("Staropramen");
		staropramenButton.setBackground(SystemColor.control);
		staropramenButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		staropramenButton.addActionListener(this);

		JButton coronaXtraButton = new JButton("Corona Extra");
		coronaXtraButton.setBackground(SystemColor.control);
		coronaXtraButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		coronaXtraButton.addActionListener(this);

		JButton becksButton = new JButton("Becks");
		becksButton.setBackground(SystemColor.control);
		becksButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		becksButton.addActionListener(this);

		JButton zagorkaButton = new JButton("Zagorka");
		zagorkaButton.setBackground(SystemColor.control);
		zagorkaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		zagorkaButton.addActionListener(this);

		JButton shumenskoButton = new JButton("Shumensko");
		shumenskoButton.setBackground(SystemColor.control);
		shumenskoButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		shumenskoButton.addActionListener(this);

		JButton guinessButton = new JButton("Guiness");
		guinessButton.setBackground(SystemColor.control);
		guinessButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		guinessButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		JButton eraseButton = new JButton("Erase");
		eraseButton.setBackground(SystemColor.control);
		eraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() > 0) {
					tableModel.removeRow(selectedBeer.size() - 1);
					selectedBeer.remove(selectedBeer.size() - 1);
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
					selectedBeer.clear();
					root.changeToProductPanel(tableNum, "Beer Panel");
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
					for (String string : selectedBeer) {
						root.chosenProducts.add(string);
						root.tables.get(tableNum).addAll(root.chosenProducts);
						System.out.println(string);
					}
					int continueAdding = JOptionPane.showConfirmDialog(null,
							"Would you like to add more products to order?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (continueAdding == JOptionPane.YES_OPTION) {
						root.changeToProductPanel(tableNum, "Beer Panel");
					} else {
						root.showLoginScreen("Beer Panel");
					}
				}
				// root.changeToHome("Beer Panel");
			}
		});
		enterButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		String[] columns = { "Selected Products" };

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setEnabled(false);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);

		scrollPane.setViewportView(table);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(191).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10)
								.addComponent(kamenitzaButton, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(staropramenButton, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(becksButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGap(6).addComponent(shumenskoButton, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10)
								.addComponent(stelaButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(coronaXtraButton, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(zagorkaButton, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE)
								.addGap(6).addComponent(guinessButton, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(eraseButton, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
								.addGap(80)
								.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGap(83).addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 163,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(44)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE).addGap(55)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(kamenitzaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(staropramenButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(becksButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(shumenskoButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(stelaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(coronaXtraButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(zagorkaButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(guinessButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGap(81)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(eraseButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(enterButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addGap(48)));
		setLayout(groupLayout);
	}

	ArrayList<String> temp = new ArrayList<String>();

	int current = 0;

	public void actionPerformed(ActionEvent e) {
		JButton selected = (JButton) e.getSource();

		selectedBeer.add(selected.getText());
		Object[] row = new Object[1];
		row[0] = selected.getText().toString();
		tableModel.addRow(row);

	}

}
