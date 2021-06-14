package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Bean;

public class SQLconnection {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	public static boolean connectSQL() {

		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception Driver " + ex.getMessage());
			return false;
		}

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_project", DatabaseLogin.getuName(),
					DatabaseLogin.getuPass());

			System.out.println("Successfully Connected to the database!");
			return true;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}

	/*
	 * public static ArrayList<Bean> stateSQL(String text, ArrayList<Bean>
	 * sql_project) {
	 * 
	 * try { String requestQuery =
	 * "SELECT `merchants_name`, `merchants_phone` FROM `merchants` WHERE `merchants_name` LIKE ?"
	 * ;
	 * 
	 * System.out.println(requestQuery);
	 * 
	 * stmt = conn.prepareStatement(requestQuery);
	 * 
	 * stmt.setString(1, "%" + text + "%");
	 * 
	 * rs = stmt.executeQuery();
	 * 
	 * if (rs.next()) {
	 * 
	 * 
	 * } rs.close(); conn.endRequest(); conn.close();
	 * 
	 * return sql_project;
	 * 
	 * } catch (SQLException ex) { System.out.println("SQLException: " +
	 * ex.getMessage()); System.out.println("SQLState: " + ex.getSQLState());
	 * System.out.println("VendorError: " + ex.getErrorCode()); } return null;
	 * 
	 * }
	 */

	public static ArrayList<Bean> ikeaSQL(String Name, ArrayList<Bean> sql_project) {

		try {
			
			String requestQuery = "SELECT * FROM `ikea_names` WHERE MATCH(`name`, `description`, `Column_3`, `Column_4`, `Column_5`) AGAINST (? IN BOOLEAN MODE)";
			//String requestQuery = "SELECT `name`, `description`, `Column_3`, `Column_4`, `Column_5` FROM `ikea_names` WHERE `name` LIKE ?";
			System.out.println(requestQuery);

			stmt = conn.prepareStatement(requestQuery);

			stmt.setString(1, "%" + Name + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Bean bases = new Bean();
				
		
			

				bases.setIkeaName(rs.getString("name"));
				bases.setDescription(rs.getString("description"));
				bases.setColumnThree(rs.getString("Column_3"));
				bases.setColumnFour(rs.getString("Column_4"));
				bases.setColumnFive(rs.getString("Column_5"));

				sql_project.add(bases);
				System.out.println(bases);
				
				
				
				
			}
			/*
			 * rs.close(); conn.endRequest(); conn.close();
			 */

			return sql_project;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}


	
	public static ArrayList<Bean> bearSQL(String Name, ArrayList<Bean> sql_project) {

		try {

			// String requestQuery = "SELECT `Character`, `Origin`, `Creator`, `Notes` FROM
			// `bearbase` WHERE MATCH `Character`, `Origin`, `Creator`, `Notes` AGAINST ?";

			// String requestQuery = "SELECT `Character`, `Origin`, `Creator`, `Notes` FROM
			// `bearbase` WHERE `Character`, `Origin`, `Creator`, `Notes` LIKE ?";
			// String requestQuery= "SELECT `Character`, `Origin`, `Creator`, `Notes` FROM
			// `bearbase` WHERE MATCH `Character`, `Origin`, `Creator`, `Notes` AGAINST ?
			// WITH QUERY EXPANSION";
			
			
			
			
			
			String requestQuery = "SELECT * FROM `bearbase` WHERE MATCH(`Character`, `Origin`, `Creator`, `Notes`) AGAINST (? IN BOOLEAN MODE)";
			//String requestQuery = "SELECT `Character`, `Origin`, `Creator`, `Notes` FROM `bearbase` WHERE `Character` OR `Origin` OR `Creator` OR `Notes` LIKE ?";
			System.out.println(requestQuery);

			stmt = conn.prepareStatement(requestQuery);

			stmt.setString(1, "%" + Name + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Bean bases = new Bean();

				bases.setBearName(rs.getString("Character"));
				bases.setOrigin(rs.getString("Origin"));
				bases.setNotes(rs.getString("Creator"));
				bases.setNotes(rs.getString("Notes"));

				sql_project.add(bases);
				System.out.println(bases);
			}
			/*
			 * rs.close(); conn.endRequest(); conn.close();
			 */

			return sql_project;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return null;

	}
	
	
	
	public static ArrayList<Bean> masterscplistSQL(String Name, ArrayList<Bean> sql_project) {

		try {


			
			/*String requestQuery = "SELECT * FROM `masterscplist` WHERE MATCH(`id`, `SCP`, `Title`, `rating`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, , `Author`, `Leaked_info`, `humanoid`, `structure`, `animal`, `computer`, `autonomous`, `cognitohazard`, `Artifact_Location_or_Sentient`, `extradimensional`, `Summary`, `Gender`, `Ethnicity_Origins`) AGAINST (? IN BOOLEAN MODE)";*/
			
			
			
			
			//KOMMENTAR TILL MARCUS! Query sökningen nedan känns i praktiskt och fungerar inte fullt ut. I samråd med en annan person så gjorde jag om databasen till fulltext index. Detta skulle göra den enklare sökbar, enligt denna person. jag tycker ändå att det känns opraktiskt och inte rätt. Har du någon idé eller tips på hur jag sköter detta? Det var lite enklare för ikea och bear. 
			
			
			String requestQuery = "SELECT * FROM `masterscplist` WHERE MATCH( `Title`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, `Author`, `Leaked_info`, `Artifact_Location_or_Sentient`, `Summary`, `Gender`, `Ethnicity_Origins`) AGAINST (? IN BOOLEAN MODE)";
			//String requestQuery = "SELECT `Character`, `Origin`, `Creator`, `Notes` FROM `bearbase` WHERE `Character` OR `Origin` OR `Creator` OR `Notes` LIKE ?";
			System.out.println(requestQuery);

			stmt = conn.prepareStatement(requestQuery);

			stmt.setString(1, "%" + Name + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Bean bases = new Bean();

				//KOMMENTAR TILL MARCUS. Nedan är koden för att lägga till infon. Jag har lite problem med int och float och fick inte ut detta i index.jsp på ett lämpligt sätt. Har jag gjort rätt eller finns det något sätt att sköta detta smidigare?
				
				
				//bases.setId(rs.getInt("id"));
				//bases.setSCP(rs.getFloat("SCP"));
				bases.setTitle(rs.getString("Title"));
				//bases.setRating(rs.getFloat("rating"));
				bases.setClassification(rs.getString("Classification"));
				bases.setType(rs.getString("Type"));
				bases.setRelated_GOI_s(rs.getString("Related_GOI_s"));
				bases.setLocation_Notes(rs.getString("Location_Notes"));
				bases.setAuthor(rs.getString("Author"));
				bases.setLeaked_info(rs.getString("Leaked_info"));
				//bases.setHumanoid(rs.getInt("humanoid"));
				//bases.setStructure(rs.getInt("structure"));
				//bases.setAnimal(rs.getInt("animal"));
				//bases.setComputer(rs.getInt("computer"));
				//bases.setAutonomous(rs.getInt("autonomous"));
				//bases.setCognitohazard(rs.getInt("cognitohazard"));
				bases.setArtifact_Location_or_Sentient(rs.getString("Artifact_Location_or_Sentient"));
				//bases.setExtradimensional(rs.getInt("extradimensional"));
				bases.setSummary(rs.getString("Summary"));
				bases.setGender(rs.getString("Gender"));
				bases.setEthnicity_Origins(rs.getString("Ethnicity_Origins"));

				sql_project.add(bases);
				System.out.println(bases);
			}
			/*
			 * rs.close(); conn.endRequest(); conn.close();
			 */

			return sql_project;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return null;

	}
	


	/*
	 * public static ArrayList<Bean> stateSQL(String Name, ArrayList<Bean>
	 * sql_project) {
	 * 
	 * try {
	 * 
	 * //String requestQuery =
	 * "SELECT * FROM `bearbase` ORDER BY `bearbase`.`Character` ASC"; //String
	 * requestQuery = "SELECT `Character` FROM `bearbase` WHERE `Character` LIKE ?";
	 * 
	 * //String requestQuery =
	 * "SELECT `Character`, `Origin` FROM `bears` WHERE `Character` LIKE ?";
	 * 
	 * //String
	 * requestQuery="SELECT * FROM `bearbase` ORDER BY `Character`,`Origin`";
	 * 
	 * //String
	 * requestQuery="SELECT * FROM `sql_project` ORDER BY `bearbase`.`Character`";
	 * 
	 * //String requestQuery="SELECT * FROM `sql_project` WHERE `Character` LIKE ?";
	 * //String
	 * requestQuery="SELECT `Character`, `Creator`, `Notes`, `Origin` FROM `bearbase` WHERE `Character` LIKE ?"
	 * ; //String
	 * requestQuery="SELECT * FROM `bearbase` ORDER BY `bearbase`.`Character` LIKE"
	 * +;
	 * 
	 * String requestQuery =
	 * "SELECT `Character`, `Origin`, `Creator`, `Notes` FROM `bearbase` WHERE `Character` LIKE ?"
	 * ; //String requestQuery = "SELECT * FROM `sql_project` WHERE * LIKE ?";
	 * //String requestQuery =
	 * "SELECT * FROM `bearbase`, `ikea_names`, `masterscplist` WHERE `Character` LIKE ?"
	 * ;
	 * 
	 * System.out.println(requestQuery);
	 * 
	 * stmt = conn.prepareStatement(requestQuery);
	 * 
	 * stmt.setString(1, "%" + Name + "%");
	 * 
	 * 
	 * rs = stmt.executeQuery();
	 * 
	 * 
	 * 
	 * while (rs.next()) {
	 * 
	 * 
	 * Bean bases = new Bean();
	 * 
	 * bases.setBearName(rs.getString("Character"));
	 * bases.setOrigin(rs.getString("Origin"));
	 * bases.setNotes(rs.getString("Notes"));
	 * bases.setCreator(rs.getString("Creator"));
	 * bases.setIkeaName(rs.getString("named"));
	 * bases.setDescription(rs.getString("description"));
	 * bases.setColumnThree(rs.getString("Column_3"));
	 * 
	 * 
	 * 
	 * sql_project.add(bases); System.out.println(bases); } rs.close();
	 * conn.endRequest(); conn.close();
	 * 
	 * 
	 * 
	 * return sql_project;
	 * 
	 * } catch (SQLException ex) { System.out.println("SQLException: " +
	 * ex.getMessage()); System.out.println("SQLState: " + ex.getSQLState());
	 * System.out.println("VendorError: " + ex.getErrorCode()); } return null;
	 * 
	 * }
	 */
}