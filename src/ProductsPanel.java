import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.SystemColor;

public class ProductsPanel extends JPanel implements ActionListener {

	public BarFrame root;
	public int tableNum;
	public ArrayList<String> chosenProducts = new ArrayList<String>();

	public JButton whiskeyButton;
	private JButton vodkaButton;
	private JButton wineButton;
	private JButton beerButton;
	private JButton nonAlcoholButton;
	private String products = "";
	private JButton chosenProduct;
	private JLabel orderAddedLabel;
	private JLabel tableNumberLabel;
	private JButton backButton;

	public ProductsPanel(BarFrame root, int tableNum) {
		setBackground(SystemColor.textHighlight);

		this.root = root;
		this.tableNum = tableNum;

		showLayout();

	}

	public void showLayout() {
		whiskeyButton = new JButton("Whiskey");
		whiskeyButton.setBackground(SystemColor.control);
		whiskeyButton.setHorizontalAlignment(SwingConstants.LEFT);
		whiskeyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		whiskeyButton.addActionListener(this);

		vodkaButton = new JButton("Vodka");
		vodkaButton.setBackground(SystemColor.control);
		vodkaButton.setHorizontalAlignment(SwingConstants.LEFT);
		vodkaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vodkaButton.addActionListener(this);

		wineButton = new JButton("Wine");
		wineButton.setBackground(SystemColor.control);
		wineButton.setHorizontalAlignment(SwingConstants.LEFT);
		wineButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		wineButton.addActionListener(this);

		beerButton = new JButton("Beer");
		beerButton.setBackground(SystemColor.control);
		beerButton.setHorizontalAlignment(SwingConstants.LEFT);
		beerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		beerButton.addActionListener(this);

		nonAlcoholButton = new JButton("Non Alcohol");
		nonAlcoholButton.setBackground(SystemColor.control);
		nonAlcoholButton.setHorizontalAlignment(SwingConstants.LEFT);
		nonAlcoholButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nonAlcoholButton.addActionListener(this);

		orderAddedLabel = new JLabel("");
		orderAddedLabel.setForeground(SystemColor.text);

		orderAddedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderAddedLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tableNumberLabel = new JLabel("");
		tableNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tableNumberLabel.setForeground(SystemColor.text);
		tableNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		if (root.operation == 0) {
			tableNumberLabel.setText("New order for table " + tableNum);
		} else {
			tableNumberLabel.setText("Add to existing order for table " + tableNum);
		}
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.showTablesPanel("Product Panel");
			}
		});
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backButton.setBackground(SystemColor.menu);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(252)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(orderAddedLabel, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableNumberLabel, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(vodkaButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(whiskeyButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(beerButton, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(wineButton, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(nonAlcoholButton, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(65))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(tableNumberLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(whiskeyButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(wineButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(nonAlcoholButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vodkaButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(beerButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(orderAddedLabel, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addGap(82))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(51))))
		);
		setLayout(groupLayout);
	}

	public void actionPerformed(ActionEvent e) {
		chosenProduct = (JButton) e.getSource();
		root.showSelectedProductPanel(chosenProduct.getText(), tableNum);
		
//		if (root.operation == 0) {
//			if (!root.tables.get(tableNum).isEmpty()) {
//				System.out.println("table is not empty");
//				return;
//			} else {
//				products = products + chosenProduct.getText() + ", ";
//				orderAddedLabel.setText(chosenProduct.getText() + " added to order.");
//				chosenProducts.add(chosenProduct.getText());
//
//			}
//		} else if (root.operation == 1) {
//			products = products + chosenProduct.getText() + ", ";
//			chosenProducts.add(chosenProduct.getText());
//			orderAddedLabel.setText(chosenProduct.getText() + " added to order.");
//			chosenProducts.add(chosenProduct.getText());
//
//		}
	}
}
