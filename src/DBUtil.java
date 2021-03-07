import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	static Connection conn = null;
	
	public static Connection getConnected() {
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/ProjectOopDB", "sa", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
		
	}//end method
	
	public static MyModel getAllModelCustomer() {
		
		conn = getConnected();
		String sql = "select * from CUSTOMER;";
		ResultSet result = null;
		MyModel model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
		
	}//end getAllModel

public static MyModel getAllModelOrders() {
		
		conn = getConnected();
		String sql = "select * from ORDERS;";
		ResultSet result = null;
		MyModel model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
		
	}//end getAllModel
public static MyModel getAllModelProduct() {
	
	conn = getConnected();
	String sql = "select * from PRODUCT;";
	ResultSet result = null;
	MyModel model = null;
	
	try {
		PreparedStatement state = conn.prepareStatement(sql);
		result = state.executeQuery();
		model = new MyModel(result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return model;
	
}//end getAllModel
	
	
	
	
	
	
	
}//end DBUtil
