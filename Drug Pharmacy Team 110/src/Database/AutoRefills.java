/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class AutoRefills 
{
    private int id;
    private Customer customer;
    private Item item;
    private int frequency; //int days
    private int daysUntil; //time before next refill, can go below 0 if a refill is delayed due to lack of inventory
    private int remainingRefills;
 
    public void registerNewAutoRefill() throws SQLException
    {
	Database.statement.executeUpdate
		("INSERT INTO auto_refills(iditem, idcustomer, frequency, daysuntil, remainingrefills)"
		+ "VALUES('" + item.getID() + "','" + customer.getID() + "','" + frequency + "','" + daysUntil + "','" + remainingRefills + "')");
    }
    //Post: Returns all auto refills where daysUntil <= 0
    ArrayList<AutoRefills> readAutoRefills() throws SQLException, ClassNotFoundException
    {
	ArrayList<AutoRefills> refills = new ArrayList<>();
	Item item;
	Customer customer;
	AutoRefills refill;
	
	Database.result2 = Database.statement2.executeQuery("SELECT idrefill, iditem, idcustomer, frequency, daysuntil, remainingrefills"
							+ " FROM sales WHERE (daysuntil <= '" + 0 + "')");
	
	while(Database.result2.next())
	{
	    refill = new AutoRefills(); 
	    customer = new Customer();
	    
	    refill.id = Database.result2.getInt(1);
	    item = Item.readItem(Database.result2.getInt(2)); //read the item id and create an item object with correct variables
	    customer.login(Database.result2.getInt(3)); //read the customer id and create a customer object with correct variables
	    refill.frequency = Database.result2.getInt(4);
	    refill.daysUntil = Database.result2.getInt(5);
	    refill.remainingRefills = Database.result2.getInt(6);
	    
	    refill.item = item; 
	    refill.customer = customer;
	    refills.add(refill);
	}
	
	return refills;
    }
    Item getItem()
    {
	return item;
    }
    Customer getCustomer()
    {
	return customer;
    }
    void setItem(Item item)
    {
	this.item = item;
    }
    void setCustomer(Customer customer)
    {
	this.customer = customer;
    }
    void setFrequency(int frequency)
    {
	this.frequency = frequency;
    }
    void setDaysUntil(int days)
    {
	this.daysUntil = days;
    }
    void setRemainingRefills(int remaining)
    {
	this.remainingRefills = remaining;
    }
}