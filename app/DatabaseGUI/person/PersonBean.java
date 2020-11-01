package person;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class PersonBean {
	   static final String JDBC_DRIVER =
	      "com.mysql.jdbc.Driver";
	   static final String DB_URL =
	      "jdbc:mysql://127.0.0.1/etud?relaxAutoCommit=true";
	   static final String DB_USER = "user";
	   static final String DB_PASS = "password";
	   private CachedRowSet rowSet = null;
	   public PersonBean() {
	      try {
	         Class.forName(JDBC_DRIVER);
	         rowSet = new CachedRowSetImpl();
	         rowSet.setUrl(DB_URL);
	         rowSet.setUsername(DB_USER);
	         rowSet.setPassword(DB_PASS);
	         rowSet.setCommand("SELECT * FROM Person");
	         rowSet.execute();
	      }
	      catch (SQLException | ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	   }
	   public Person create(Person p) {
	      try {
	         rowSet.moveToInsertRow();
	         rowSet.updateInt("personId", p.getPersonId());
	         rowSet.updateString("firstName", p.getFirstName());
	         rowSet.updateString("middleName", p.getMiddleName());
	         rowSet.updateString("lastName", p.getLastName());
	         rowSet.updateString("email", p.getEmail());
	         rowSet.updateString("phone", p.getPhone());
	         rowSet.insertRow();
	         rowSet.moveToCurrentRow();
	         rowSet.acceptChanges();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	            p = null;
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person update(Person p) {
	      try {
	         rowSet.updateString("firstName", p.getFirstName());
	         rowSet.updateString("middleName", p.getMiddleName());
	         rowSet.updateString("lastName", p.getLastName());
	         rowSet.updateString("email", p.getEmail());
	         rowSet.updateString("phone", p.getPhone());
	         rowSet.updateRow();
	         rowSet.moveToCurrentRow();
	         rowSet.acceptChanges();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person delete() {
	      Person p = new Person();
	      try {
	         rowSet.moveToCurrentRow();
	         rowSet.deleteRow();
	         rowSet.acceptChanges();
		 if (rowSet.first() == false) {
			 p.setPersonId(-1);
			 p.setFirstName("empty");
			 p.setMiddleName("empty");
			 p.setLastName("empty");
			 p.setEmail("empty");
			 p.setPhone("empty");
		}
		else {
			 rowSet.first();
			 p.setPersonId(rowSet.getInt("personId"));
			 p.setFirstName(rowSet.getString("firstName"));
			 p.setMiddleName(rowSet.getString("middleName"));
			 p.setLastName(rowSet.getString("lastName"));
			 p.setEmail(rowSet.getString("email"));
			 p.setPhone(rowSet.getString("phone"));
		}
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e) { }
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person moveFirst() {
	      Person p = new Person();
	      try {
	         if (rowSet.first() == false) {
			 p.setPersonId(-1);
			 p.setFirstName("empty");
			 p.setMiddleName("empty");
			 p.setLastName("empty");
			 p.setEmail("empty");
			 p.setPhone("empty");
		}
		else {
			 rowSet.first();
			 p.setPersonId(rowSet.getInt("personId"));
			 p.setFirstName(rowSet.getString("firstName"));
			 p.setMiddleName(rowSet.getString("middleName"));
			 p.setLastName(rowSet.getString("lastName"));
			 p.setEmail(rowSet.getString("email"));
			 p.setPhone(rowSet.getString("phone"));
		}
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person moveLast() {
	      Person p = new Person();
	      try {
	         rowSet.last();
	         p.setPersonId(rowSet.getInt("personId"));
	         p.setFirstName(rowSet.getString("firstName"));
	         p.setMiddleName(rowSet.getString("middleName"));
	         p.setLastName(rowSet.getString("lastName"));
	         p.setEmail(rowSet.getString("email"));
	         p.setPhone(rowSet.getString("phone"));

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person moveNext() {
	      Person p = new Person();
	      try {
	         if (rowSet.next() == false)
	            rowSet.previous();
	         p.setPersonId(rowSet.getInt("personId"));
	         p.setFirstName(rowSet.getString("firstName"));
	         p.setMiddleName(rowSet.getString("middleName"));
	         p.setLastName(rowSet.getString("lastName"));
	         p.setEmail(rowSet.getString("email"));
	         p.setPhone(rowSet.getString("phone"));

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person movePrevious() {
	      Person p = new Person();
	      try {
	         if (rowSet.previous() == false)
	            rowSet.next();
	         p.setPersonId(rowSet.getInt("personId"));
	         p.setFirstName(rowSet.getString("firstName"));
	         p.setMiddleName(rowSet.getString("middleName"));
	         p.setLastName(rowSet.getString("lastName"));
	         p.setEmail(rowSet.getString("email"));
	         p.setPhone(rowSet.getString("phone"));

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return p;
	   }

	   public Person getCurrent() {
	      Person p = new Person();
	      try {
		 rowSet.moveToCurrentRow();
		 p.setPersonId(rowSet.getInt("personId"));
		 p.setFirstName(rowSet.getString("firstName"));
		 p.setMiddleName(rowSet.getString("middleName"));
		 p.setLastName(rowSet.getString("lastName"));
		 p.setEmail(rowSet.getString("email"));
		 p.setPhone(rowSet.getString("phone"));
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      }
	      return p;
	   }
	}
