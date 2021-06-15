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

public class WhiskeyPanel extends JPanel implements ActionListener {

	public BarFrame root;
	private JTable table;
	private int tableNum;
	private DefaultTableModel tableModel;
	private ArrayList<String> selectedWhiskey = new ArrayList<String>();

	public WhiskeyPanel(BarFrame root, int tableNum) {
		setBackground(SystemColor.textHighlight);
		this.root = root;
		this.tableNum = tableNum;

		JButton jameson50Button = new JButton("Jameson 50 ml");
		jameson50Button.setBackground(SystemColor.control);
		jameson50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jameson50Button.addActionListener(this);

		JButton jameson100Button = new JButton("Jameson 100 ml");
		jameson100Button.setBackground(SystemColor.control);
		jameson100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jameson100Button.addActionListener(this);

		JButton jamesonBottleButton = new JButton("Jameson Bottle");
		jamesonBottleButton.setBackground(SystemColor.control);
		jamesonBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jamesonBottleButton.addActionListener(this);

		JButton bush50Button = new JButton("Bushmills 50 ml");
		bush50Button.setBackground(SystemColor.control);
		bush50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bush50Button.addActionListener(this);

		JButton bush100Button = new JButton("Bushmills 100 ml");
		bush100Button.setBackground(SystemColor.control);
		bush100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bush100Button.addActionListener(this);

		JButton bushBottleButton = new JButton("Bushmills bottle");
		bushBottleButton.setBackground(SystemColor.control);
		bushBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bushBottleButton.addActionListener(this);

		JButton paddy50Button = new JButton("Paddy 50 ml");
		paddy50Button.setBackground(SystemColor.control);
		paddy50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paddy50Button.addActionListener(this);

		JButton paddy100Button = new JButton("Paddy 100 ml");
		paddy100Button.setBackground(SystemColor.control);
		paddy100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paddy100Button.addActionListener(this);

		JButton paddyBottleButton = new JButton("Paddy Bottle");
		paddyBottleButton.setBackground(SystemColor.control);
		paddyBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paddyBottleButton.addActionListener(this);

		JButton jackD50Button = new JButton("Jack 50 ml");
		jackD50Button.setBackground(SystemColor.control);
		jackD50Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jackD50Button.addActionListener(this);

		JButton jackD100Button = new JButton("Jack 100 ml");
		jackD100Button.setBackground(SystemColor.control);
		jackD100Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jackD100Button.addActionListener(this);

		JButton jackDBottleButton = new JButton("Jack Bottle");
		jackDBottleButton.setBackground(SystemColor.control);
		jackDBottleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jackDBottleButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		JButton eraseButton = new JButton("Erase");
		eraseButton.setBackground(SystemColor.control);
		eraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableModel.getRowCount() > 0) {
					tableModel.removeRow(selectedWhiskey.size() - 1);
					selectedWhiskey.remove(selectedWhiskey.size() - 1);
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
					selectedWhiskey.clear();
					root.changeToProductPanel(tableNum, "Whiskey Panel");
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
					for (String string : selectedWhiskey) {
						root.chosenProducts.add(string);
						root.tables.get(tableNum).addAll(root.chosenProducts);
						System.out.println(string);
					}
					int continueAdding = JOptionPane.showConfirmDialog(null, "Would you like to add more products to order?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if(continueAdding == JOptionPane.YES_OPTION) {
						root.changeToProductPanel(tableNum, "Whiskey Panel");
					} else {
						root.showLoginScreen("Whiskey Panel");
					}
				}
				//root.changeToHome("Whiskey Panel");
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
												.addComponent(jameson100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(bush100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(paddy100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jackD100Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(jameson50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(bush50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(paddy50Button, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jackD50Button,
														GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(eraseButton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jamesonBottleButton, GroupLayout.DEFAULT_SIZE,
																167, Short.MAX_VALUE))
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(bushBottleButton,
																		GroupLayout.PREFERRED_SIZE, 167,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(
																		paddyBottleButton, GroupLayout.PREFERRED_SIZE,
																		167, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED))
														.addGroup(Alignment.TRAILING, groupLayout
																.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE,
																		160, GroupLayout.PREFERRED_SIZE)
																.addGap(91)))
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(enterButton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jackDBottleButton, GroupLayout.DEFAULT_SIZE, 167,
																Short.MAX_VALUE))))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(44)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jameson50Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(bush50Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(paddy50Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(jackD50Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jameson100Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(bush100Button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(paddy100Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jackD100Button, GroupLayout.PREFERRED_SIZE, 81,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jackDBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(paddyBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(bushBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(jamesonBottleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
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

		selectedWhiskey.add(selected.getText());
		Object[] row = new Object[1];
		row[0] = selected.getText().toString();
		tableModel.addRow(row);

	}
}
