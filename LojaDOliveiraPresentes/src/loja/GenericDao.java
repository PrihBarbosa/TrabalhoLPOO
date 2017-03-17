package loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;


public class GenericDao {
	private String databaseUrl;
	private String tableName;
	Connection connection;
	Statement statement;
	
	public GenericDao(String tableName) throws SQLException {
		DriverManager.registerDriver(new org.sqlite.JDBC());
		this.databaseUrl = Config.getUrl();
		this.tableName = tableName;
	}
	
	public  ArrayList<String> all() throws SQLException {
		connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
		statement = connection.createStatement();
		
		ArrayList<String> result = new ArrayList<String>();
		ResultSet resultSet = statement.executeQuery("select * from " + tableName);
		int numberOfColumns = resultSet.getMetaData().getColumnCount();
		
		while(resultSet.next()) {
			String stringResult = "";
			int i;
			for(i = 1 ; i < numberOfColumns ; i++) {
				stringResult += resultSet.getString(i);
				stringResult += ",";
			}
			stringResult += resultSet.getString(i);
			result.add(stringResult);
		}
		
		statement.close();
		connection.close();
		return result;
	}
	
	private Object fixString(Object value) {
		return (value instanceof String || value instanceof Character) ? "'" + value + "'" : value;  	
	}
	
	public ArrayList<String> findBy(Map<String, Object> mapping) throws SQLException {
		connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
		statement = connection.createStatement();
		
		int i;
		/* Where clause */
		String whereClause = "";
		Object keys[] = mapping.keySet().toArray();
		for(i = 0 ; i < keys.length - 1 ; i++) {
			whereClause = whereClause + keys[i] + " = " + fixString(mapping.get(keys[i])) + " AND ";
		}
		whereClause = whereClause + keys[i] + " = " + fixString(mapping.get(keys[i]));
		
		ArrayList<String> result = new ArrayList<String>();
		ResultSet resultSet = statement.executeQuery("select * from " + tableName + " where " + whereClause);
		int numberOfColumns = resultSet.getMetaData().getColumnCount();
		
		while(resultSet.next()) {
			String stringResult = "";
			for(i = 1 ; i < numberOfColumns ; i++) {
				stringResult += resultSet.getString(i);
				stringResult += ",";
			}
			stringResult += resultSet.getString(i);
			result.add(stringResult);
		}
		
		statement.close();
		connection.close();
		
		return result;
	}
	
	public boolean insert(Map<String, Object> mapping){
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);;
			statement = connection.createStatement();
			String clause = "INSERT INTO "+this.tableName+" (";
			Object keys[] = mapping.keySet().toArray();
			for(int i=0; i < keys.length; i++)
			{
				if(i == (keys.length) -1)
					clause = clause + keys[i] +")";
				else
					clause = clause + keys[i]+", ";
			}
			clause = clause + " VALUES (";
			for(int i=0; i < keys.length; i++)
			{
				if(i == (keys.length) -1)
					clause = clause + fixString(mapping.get(keys[i])) + ")";
				else
					clause = clause + fixString(mapping.get(keys[i])) + ", ";
			}
			//System.out.println(clause);
			statement.execute(clause);
			//System.out.println("Da generic deu "+result);
			statement.close();
			connection.close();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}/*fim do insert*/
	
	public boolean remove(Map<String, Object> mapping){
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
			statement = connection.createStatement();
			
			int i;
			/* Where clause */
			String whereClause = "";
			Object keys[] = mapping.keySet().toArray();
			for(i = 0 ; i < keys.length - 1 ; i++) {
				whereClause = whereClause + keys[i] + " = " + fixString(mapping.get(keys[i])) + " AND ";
			}
			whereClause = whereClause + keys[i] + " = " + fixString(mapping.get(keys[i]));
			String clause = "DELETE FROM " + tableName + " WHERE " + whereClause;
			statement.execute(clause);
			statement.close();
			connection.close();
			return true;
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean update(Map<String, Object> map1, Map<String, Object> map2)
	{
		try{
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
			Statement statement = connection.createStatement();
			int i;
			String whereClause = "";
			Object keys[] = map1.keySet().toArray();
			for(i = 0 ; i < keys.length - 1 ; i++) {
				whereClause = whereClause + keys[i] + " = " + fixString(map1.get(keys[i])) + " AND ";
			}
			whereClause = whereClause + keys[i] + " = " + fixString(map1.get(keys[i]));
			String clause = "UPDATE "+this.tableName+" SET ";
			String setClause = "";
			Object keys2[] = map2.keySet().toArray();
			for(int j=0; j < keys2.length; j++)
			{
				if(j == (keys2.length)-1)
					setClause = setClause +keys2[j]+" = "+ fixString(map2.get(keys2[j])) + "";
				else
					setClause = setClause +keys2[j]+" = "+ fixString(map2.get(keys2[j])) + ", ";
			}
			clause = clause+setClause+" WHERE "+whereClause+"";
			statement.execute(clause);
			statement.close();
			connection.close();
			return true;
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
}
