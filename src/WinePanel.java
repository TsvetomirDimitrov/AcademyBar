import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class WinePanel extends JPanel implements ActionListener {
	public BarFrame root;
	private JTable table;
	private int tableNum;
	private DefaultTableModel tableModel;
	private ArrayList<String> selectedWine = new ArrayList<String>();

	public WinePanel(BarFrame root, int tableNum) {
		setBackground(SystemColor.textHighlight);
		this.root = root;
		this.tableNum = tableNum;

		JButton sovBlanSmallButton = new JButton("Sauvignon 375 ml");
		sovBlanSmallButton.setBackground(SystemColor.control);
		sovBlanSmallButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sovBlanSmallButton.addActionListener(this);

		JButton sovBlanBigButton = new JButton("Sauvignon 750 ml");
		sovBlanBigButton.setBackground(SystemColor.control);
		sovBlanBigButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sovBlanBigButton.addActionListener(this);

		JButton roseTangraSmallButton = new JButton("Ros\u00E9 Tangra 375 ml");
		roseTangraSmallButton.setBackground(SystemColor.control);
		roseTangraSmallButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roseTangraSmallButton.addActionListener(this);

		JButton roseTangraBigButton = new JButton("Ros\u00E9 Tangra 750 ml");
		roseTangraBigButton.setBackground(SystemColor.control);
		roseTangraBigButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roseTangraBigButton.addActionListener(this);

		JButton roseGayardSmallButton = new JButton("Ros\u00E9 Gayard 375 ml");
		roseGayardSmallButton.setBackground(SystemColor.control);
		roseGayardSmallButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roseGayardSmallButton.addActionListener(this);

		JButton roseGayardBigButton = new JButton("Ros\u00E9 Gayard 750 ml");
		roseGayardBigButton.setBackground(SystemColor.control);
		roseGayardBigButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roseGayardBigButton.addActionListener(this);

		JButton pixelsSmallButton = new JButton("Pixels Ros\u00E9 375 ml");
		pixelsSmallButton.setBackground(SystemColor.control);
		pixelsSmallButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pixelsSmallButton.addActionListener(this);

		JButton pixelsBigButton = new JButton("Pixels Ros\u00E9 750 ml");
		pixelsBigButton.setBackground(SystemColor.control);
		pixelsBigButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pixelsBigButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		JButton eraseButton = new JButton("Erase");
		eraseButton.setBackground(SystemColor.control);
		eraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() > 0) {
					tableModel.removeRow(selectedWine.size() - 1);
					selectedWine.remove(selectedWine.size() - 1);
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
					selectedWine.clear();
					root.changeToProductPanel(tableNum, "Wine Panel");
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
					for (String string : selectedWine) {
						root.chosenProducts.add(string);
						root.tables.get(tableNum).addAll(root.chosenProducts);
						System.out.println(string);
					}
					int continueAdding = JOptionPane.showConfirmDialog(null,
							"Would you like to add more products to order?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (continueAdding == JOptionPane.YES_OPTION) {
						root.changeToProductPanel(tableNum, "Wine Panel");
					} else {
						root.showLoginScreen("Wine Panel");
					}
				}
				// root.changeToHome("Wine Panel");
			}
		});
		enterButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(191).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(sovBlanSmallButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(roseTangraSmallButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(roseGayardSmallButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(pixelsSmallButton, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(sovBlanBigButton, GroupLayout.PREFERRED_SIZE, 167,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(roseTangraBigButton, GroupLayout.PREFERRED_SIZE,
																167, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(roseGayardBigButton, GroupLayout.PREFERRED_SIZE,
																167, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(eraseButton, GroupLayout.PREFERRED_SIZE, 169,
																GroupLayout.PREFERRED_SIZE)
														.addGap(101).addComponent(cancelButton,
																GroupLayout.PREFERRED_SIZE, 168,
																GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(enterButton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(pixelsBigButton, GroupLayout.DEFAULT_SIZE, 167,
																Short.MAX_VALUE))))))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(44)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sovBlanSmallButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(roseTangraSmallButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(roseGayardSmallButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(pixelsSmallButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sovBlanBigButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(roseTangraBigButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(roseGayardBigButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(pixelsBigButton, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(119)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(eraseButton, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(enterButton, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE).addComponent(
								cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

		selectedWine.add(selected.getText());
		Object[] row = new Object[1];
		row[0] = selected.getText().toString();
		tableModel.addRow(row);

	}

}
