import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class OnlineShop extends JFrame implements ActionListener {
	
	Connection conn = null;
	PreparedStatement state = null;
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel tabbedPane_Customer = new JPanel();
	
	JPanel tabbedPane_Product = new JPanel();
		
	JPanel tabbedPane_Orders = new JPanel();
	
	JPanel  reference1 = new JPanel();
	JPanel  reference2 = new JPanel();
	
public OnlineShop() {
		super("The project of Ivailo and Jivko ");
		this.setVisible(true);
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(tabbedPane);
		this.add(tabbedPane);
		
		//Customer 
		tabbedPane.add("Клиенти", tabbedPane_Customer);
		tabbedPane_Customer.add(upPanelCustomer);
		tabbedPane_Customer.add(midPanelCustomer);
		tabbedPane_Customer.add(downPanelCustomer);
		
		//upPanel
		upPanelCustomer.setLayout(new GridLayout(5, 2));
		upPanelCustomer.add(fnameCustomerLabel);
		upPanelCustomer.add(fnameCustomerTField);
		upPanelCustomer.add(lnameCustomerLabel);
		upPanelCustomer.add(lnameCustomerTField);
		upPanelCustomer.add(addressCustomerLabel);
		upPanelCustomer.add(addressCustomerTField);
		upPanelCustomer.add(phoneCustomerLabel);
		upPanelCustomer.add(phoneCustomerTField);
		upPanelCustomer.add(emailCustomerLabel);
		upPanelCustomer.add(emailCustomerTField);
		
		//midPanel
		midPanelCustomer.add(addBtnCustomer);
		midPanelCustomer.add(editBtnCustomer);
		midPanelCustomer.add(delBtnCustomer);
		
		//downPanel
		downPanelCustomer.add(scrollerCustomer);
		scrollerCustomer.setPreferredSize(new Dimension(550, 125));
		tableCustomer.setModel(DBUtil.getAllModelCustomer());
		
		//Product
		tabbedPane.add("Продукти", tabbedPane_Product);
		tabbedPane_Product.add(upPanelProduct);
		tabbedPane_Product.add(midPanelProduct);
		tabbedPane_Product.add(downPanelProduct);
		
		//upPanel
		upPanelProduct.setLayout(new GridLayout(2, 4));
		upPanelProduct.add(ProductFruiLabel);
		upPanelProduct.add(whatFrui);
		upPanelProduct.add(QuantityFruiLabel);
		upPanelProduct.add(howFrui);
		upPanelProduct.add(ProductVegetablesLabel);
		upPanelProduct.add(whatVegetables);
		upPanelProduct.add(QuantityVegetablesLabel);
		upPanelProduct.add(howVegetables);
		
		//midPanel
		midPanelProduct.add(addBtnProduct);
		midPanelProduct.add(editBtnProduct);
		midPanelProduct.add(delBtnProduct);
		
		//downPanel
		downPanelProduct.add(scrollerProduct);
		scrollerProduct.setPreferredSize(new Dimension(550, 125));
		tableProduct.setModel(DBUtil.getAllModelProduct());
		
		//Orders
		tabbedPane.add("Поръчки", tabbedPane_Orders);
		tabbedPane_Orders.add(upPanelOrders);
		tabbedPane_Orders.add(midPanelOrders);
		tabbedPane_Orders.add(downPanelOrders);
		
		//upPanel
		upPanelOrders.add(quantityOrdersLabel);
		upPanelOrders.add(quantityOrdersTField);
		upPanelOrders.add(priceOrdersLabel);
		upPanelOrders.add(priceOrdersTField);
		
		//midPanel
		midPanelOrders.add(addBtnOrders);
		midPanelOrders.add(editBtnOrders);
		midPanelOrders.add(delBtnOrders);
		
		//downPanel
		downPanelOrders.add(scrollerOrders);
		scrollerOrders.setPreferredSize(new Dimension(550, 125));
		tableOrders.setModel(DBUtil.getAllModelOrders());
		
		
		//Rreferences
		tabbedPane.add("Справка 1", reference1);
		tabbedPane.add("Справка 1", reference2);
		
	}//end of constructor

		//Customer
		JPanel upPanelCustomer = new JPanel();
		JPanel midPanelCustomer = new JPanel();
		JPanel downPanelCustomer = new JPanel();
		//upPanel
		JLabel fnameCustomerLabel = new JLabel("Име");
		JLabel lnameCustomerLabel = new JLabel("Фамилия");
		JLabel addressCustomerLabel = new JLabel("Адрес");
		JLabel phoneCustomerLabel = new JLabel("Телефон");
		JLabel emailCustomerLabel = new JLabel("E-mail");
		
		JTextField fnameCustomerTField = new JTextField(10);
		JTextField lnameCustomerTField = new JTextField(10);
		JTextField addressCustomerTField = new JTextField(10);
		JTextField phoneCustomerTField = new JTextField(10);
		JTextField emailCustomerTField = new JTextField(20);
		
		//midPanel
		JButton addBtnCustomer = new JButton("Добави1");
		JButton editBtnCustomer = new JButton("Промени1");
		JButton delBtnCustomer = new JButton("Изтрий1");
		
		//downPanel
		JTable tableCustomer = new JTable();
		JScrollPane scrollerCustomer = new JScrollPane(tableCustomer);
		
		//Product
		JPanel upPanelProduct = new JPanel();
		JPanel midPanelProduct = new JPanel();
		JPanel downPanelProduct = new JPanel();
		
		JPanel upPanelProduct2 = new JPanel();
		JPanel midPanelProduct2 = new JPanel();
		JPanel downPanelProduct2 = new JPanel();
		//upPanel
		//fruit
		JLabel ProductFruiLabel = new JLabel("Плодове:");
		String[] WHATFrui = {null, "Apple","Banana","Orange"};
		JComboBox whatFrui = new JComboBox(WHATFrui);
		JLabel QuantityFruiLabel = new JLabel("Количество:");
		String[] HOWfrui = {null, "1","2","3","4","5","6","7","8","9","10"};
		JComboBox howFrui = new JComboBox(HOWfrui);
	
		//vegetables
		JLabel ProductVegetablesLabel = new JLabel("Зеленчуци:");
		String[] WHATvegetables = {null, "Tomato","Cucumber","Broccoli"};
		JComboBox whatVegetables = new JComboBox(WHATvegetables);
		JLabel QuantityVegetablesLabel = new JLabel("Количество:");
		String[] HOWvegetables = {null, "1","2","3","4","5","6","7","8","9","10"};
		JComboBox howVegetables = new JComboBox(HOWvegetables);
		
		//midPanel
		JButton addBtnProduct = new JButton("Добави2");
		JButton editBtnProduct = new JButton("Промени2");
		JButton delBtnProduct = new JButton("Изтрий2");
		

		//downPanel
		JTable tableProduct = new JTable();
		JScrollPane scrollerProduct = new JScrollPane(tableProduct);
		
		//Orders
		JPanel upPanelOrders = new JPanel();
		JPanel midPanelOrders = new JPanel();
		JPanel downPanelOrders = new JPanel();
		
		//upPanel
		JLabel quantityOrdersLabel = new JLabel("Количество");
		JLabel priceOrdersLabel = new JLabel("Цена");
		
		JTextField quantityOrdersTField = new JTextField(10);
		JTextField priceOrdersTField = new JTextField(10);
		
		//midPanel
		JButton addBtnOrders = new JButton("Добави3");
		JButton editBtnOrders = new JButton("Промени3");
		JButton delBtnOrders = new JButton("Изтрий3");
		
		//downPanel
		JTable tableOrders = new JTable();
		JScrollPane scrollerOrders = new JScrollPane(tableOrders);
		
@Override
		public void actionPerformed(ActionEvent event) {
	
		String fname = fnameCustomerTField.getText();
		String lname = lnameCustomerTField.getText();
		String address = addressCustomerLabel.getText();
		String phone = phoneCustomerLabel.getText();
		String email = emailCustomerLabel.getText();
	
		conn = DBUtil.getConnected();
		if(conn == null) {
			return;
		}
		String sql ="insert into the products values (null,?,?,?,?,?);";
	
		try {
			state = conn.prepareStatement(sql);
			state.setString(1, fname);
			state.setString(2, lname);
			state.setString(3, address);
			state.setString(4, phone);
			state.setString(5, email);
			
			state.execute();
			tableCustomer.setModel(DBUtil.getAllModelCustomer());
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*String wF = whatFrui.getToolTipText();
		String hF = howFrui.getToolTipText();
		String wV = whatVegetables.getToolTipText();
		String hV = howVegetables.getToolTipText();
	
		conn = DBUtil.getConnected();
		if(conn == null) {
			return;
		}
		String sql2 ="insert into the products values (null,?,?,?,?);";
	
		try {
			state = conn.prepareStatement(sql2);
			state.setString(1, wF);
			state.setString(2, hF);
			state.setString(3, wV);
			state.setString(4, hV);
			
			state.execute();
			tableProduct.setModel(DBUtil.getAllModelProduct());
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	
	}//end of ActionEvent
}//end of class
