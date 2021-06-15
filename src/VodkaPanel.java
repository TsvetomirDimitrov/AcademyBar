import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class VodkaPanel extends JPanel implements ActionListener {
	public BarFrame root;
	private JTable table;
	private int tableNum;
	private DefaultTableModel tableModel;
	private ArrayList<String> selectedVodka = new ArrayList<String>();

	public VodkaPanel(BarFrame root, int tableNum) {
		this.root = root;
		this.tableNum = tableNum;

		setBackground(SystemColor.textHighlight);
		this.root = root;
		this.tableNum = tableNum;

		JButton finlandia50Button = new JButton("Finlandia 50 ml");
		finlandia50Button.setBackground(SystemColor.control);
		finlandia50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		finlandia50Button.addActionListener(this);

		JButton finlandia100Button = new JButton("Finlandia 100 ml");
		finlandia100Button.setBackground(SystemColor.control);
		finlandia100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		finlandia100Button.addActionListener(this);

		JButton finlandiaBottleButton = new JButton("Finlandia Bottle");
		finlandiaBottleButton.setBackground(SystemColor.control);
		finlandiaBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		finlandiaBottleButton.addActionListener(this);

		JButton sobieski50Button = new JButton("Sobieski 50 ml");
		sobieski50Button.setBackground(SystemColor.control);
		sobieski50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sobieski50Button.addActionListener(this);

		JButton sobieski100Button = new JButton("Sobieski 100 ml");
		sobieski100Button.setBackground(SystemColor.control);
		sobieski100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sobieski100Button.addActionListener(this);

		JButton sobieskiBottleButton = new JButton("Sobieski bottle");
		sobieskiBottleButton.setBackground(SystemColor.control);
		sobieskiBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sobieskiBottleButton.addActionListener(this);

		JButton absolut50Button = new JButton("Absolut 50 ml");
		absolut50Button.setBackground(SystemColor.control);
		absolut50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		absolut50Button.addActionListener(this);

		JButton absolut100Button = new JButton("Absolut 100 ml");
		absolut100Button.setBackground(SystemColor.control);
		absolut100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		absolut100Button.addActionListener(this);

		JButton absolutBottleButton = new JButton("Absolut Bottle");
		absolutBottleButton.setBackground(SystemColor.control);
		absolutBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		absolutBottleButton.addActionListener(this);

		JButton smirnoff50Button = new JButton("Smirnoff 50 ml");
		smirnoff50Button.setBackground(SystemColor.control);
		smirnoff50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		smirnoff50Button.addActionListener(this);

		JButton smirnoff100Button = new JButton("Smirnoff100 ml");
		smirnoff100Button.setBackground(SystemColor.control);
		smirnoff100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		smirnoff100Button.addActionListener(this);

		JButton smirnoffBottleButton = new JButton("Smirnoff Bottle");
		smirnoffBottleButton.setBackground(SystemColor.control);
		smirnoffBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		smirnoffBottleButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		JButton eraseButton = new JButton("Erase");
		eraseButton.setBackground(SystemColor.control);
		eraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() > 0) {
					tableModel.removeRow(selectedVodka.size() - 1);
					selectedVodka.remove(selectedVodka.size() - 1);
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
					selectedVodka.clear();
					root.changeToProductPanel(tableNum, "Vodka Panel");
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
					for (String string : selectedVodka) {
						root.chosenProducts.add(string);
						root.tables.get(tableNum).addAll(root.chosenProducts);
						System.out.println(string);
					}
					int continueAdding = JOptionPane.showConfirmDialog(null,
							"Would you like to add more products to order?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if (continueAdding == JOptionPane.YES_OPTION) {
						root.changeToProductPanel(tableNum, "Vodka Panel");
					} else {
						root.showLoginScreen("VodkaPanel");
					}
				}
				// root.changeToHome("Vodka Panel");
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
												.addComponent(finlandia100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(sobieski100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(absolut100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														smirnoff100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(finlandia50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(sobieski50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(absolut50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(smirnoff50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(finlandiaBottleButton, GroupLayout.PREFERRED_SIZE,
																167, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(sobieskiBottleButton, GroupLayout.PREFERRED_SIZE,
																167, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(absolutBottleButton, GroupLayout.PREFERRED_SIZE,
																167, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(eraseButton, GroupLayout.PREFERRED_SIZE, 169,
																GroupLayout.PREFERRED_SIZE)
														.addGap(80).addComponent(cancelButton,
																GroupLayout.PREFERRED_SIZE, 191,
																GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(enterButton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(smirnoffBottleButton, GroupLayout.DEFAULT_SIZE,
																167, Short.MAX_VALUE))))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(44)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(finlandia50Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(sobieski50Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(absolut50Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(smirnoff50Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(finlandia100Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(sobieski100Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(absolut100Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(smirnoff100Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(smirnoffBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(absolutBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(sobieskiBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(finlandiaBottleButton, GroupLayout.PREFERRED_SIZE, 81,
								GroupLayout.PREFERRED_SIZE))
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

		selectedVodka.add(selected.getText());
		Object[] row = new Object[1];
		row[0] = selected.getText().toString();
		tableModel.addRow(row);

	}
}
