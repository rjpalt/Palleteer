package palleteer.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import palleteer.domain.HawleItem;

//Tarvitsee lisätä "muokkaa" käsky

public class PalleteerDAO {

	private String dbPath;

	public PalleteerDAO() {

		this.dbPath = "jdbc:sqlite:C:/Users/konti/eclipse-workspace/Palleteer/src/palleteer/palleteerDB.db";

	}

	public ArrayList<HawleItem> list() throws SQLException {

		ArrayList<HawleItem> itemList = new ArrayList<HawleItem>();

		try (Connection con = connectAndSecureDB();
				ResultSet results = con.prepareStatement("SELECT * FROM palleteerDB").executeQuery()) {
			while (results.next()) {
				itemList.add(new HawleItem(results.getString("product_code"), results.getString("product_name"), results.getDouble("product_weight")));
			}
		}

		return itemList;

	}

	public void add (HawleItem item) throws SQLException {

		try (Connection con = connectAndSecureDB()) {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO palleteerDB (product_code, product_name, product_weight) VALUES (?, ?, ?)");
			stmt.setString(1, item.getProductId());
			stmt.setString(2, item.getName());
			stmt.setDouble(3, item.getWeight());
			stmt.executeUpdate();
		}

	}

	public void remove (HawleItem item) throws SQLException {

		try (Connection con = connectAndSecureDB()) {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM palleteerDB WHERE product_code = ?");
			stmt.setString(1, item.getProductId());
			stmt.executeUpdate();
		}
	}

	private Connection connectAndSecureDB() throws SQLException {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(dbPath);
       		System.out.println("Connection to SQLite has been established.");
		} catch (SQLException t) {
			System.out.println(t.getMessage());
		}

		if (conn == null) {

			try {
				conn = DriverManager.getConnection(dbPath);
				conn.prepareStatement("CREATE TABLE palleteerDB (product_code text primary key, product_name text, product_weight real)").execute();
				System.out.println("Creating a new table");
			} catch (SQLException t) {
				System.out.println(t.getMessage());
			}

		}

		return conn;

	}

}