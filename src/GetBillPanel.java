import java.util.Collection;
import java.util.Iterator;
import java.util.Map; 
import java.util.HashMap;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class GetBillPanel extends JPanel{
	public BarFrame root;
	public int tableNum;
	public double total = 0;
	private DecimalFormat df2 = new DecimalFormat("#.##");
	
	public GetBillPanel(BarFrame root, int tableNum) {
		setBackground(SystemColor.textHighlight);
		this.root = root;
		this.tableNum = tableNum;
		
		getTotal();
		showLayout();
		

	}
	public void showLayout() {
		JLabel billLabel = new JLabel("Bill for table " + tableNum + " is " + df2.format(total) + " BGN.");
		billLabel.setForeground(SystemColor.text);
		billLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		billLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBackground(SystemColor.control);
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.welcomeFromBill();
				root.tables.get(tableNum).clear();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(280)
					.addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(287, Short.MAX_VALUE))
				.addComponent(billLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(235)
					.addComponent(billLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void getTotal() {
		for (String product : root.tables.get(tableNum)) {
			for (Map.Entry<String, Double> entry: root.products.entrySet()) {
				if(product.equals(entry.getKey())) {
					total+= entry.getValue();
				}
			}
		}
	}
}
