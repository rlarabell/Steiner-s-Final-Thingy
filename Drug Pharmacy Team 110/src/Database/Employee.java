/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;

/**
 *
 * @author Brian
 */

public class Employee 
{
    private int id;
    private String name;
    private  boolean manager; //true if the user is a manager
    private boolean validated; //set to true if user login is successful and member fields are set
    
    public Employee() throws ClassNotFoundException, SQLException
    {
		validated = false;
    }
    //Post: sets member fields if login data matches database data
    public void login(int id, String password) throws SQLException, ClassNotFoundException
    {
		boolean validation = validateEmployee(id, password);
	
		if (validation)
		{
	 	   this.validated = true;
	 	   this.id = id;
	 	   this.manager = readManager(id);
	 	   this.name = readName(id);
		}
    }
    //Post: returns true if the username/password exist
    //	    otherwise returns false
    public boolean validateEmployee(int id, String passwordInput) throws SQLException
    { 
		String actualPassword;
	
		Database.result = Database.statement.executeQuery("select password from employee where idemployee = '" + id + "'");
	
		if (Database.result.next())
		{
	    	actualPassword = Database.result.getString(1);

			return actualPassword.equals(passwordInput);
		}

		else
	    	return false;
    }
    public String readName(int id) throws SQLException
    {
		Database.result = Database.statement.executeQuery("select name from employee where idemployee = '" + id + "'");
	
		if (Database.result.next())
			return Database.result.getString(1);

		else
	    	return null;
    }
    public boolean readManager(int id) throws SQLException
    {
		Database.result = Database.statement.executeQuery("select manager from employee where idemployee = '" + id + "'");
	
		if (Database.result.next())
	    	return Database.result.getBoolean(1);

		else
	    	return false;
    }
    public int getID()
    {
		return id;
    }
    public String getName()
    {
		return name;
    }
    public boolean getManager()
    {
		return manager;
    }
    public boolean checkValidation()
    {
		return validated;
    }
}