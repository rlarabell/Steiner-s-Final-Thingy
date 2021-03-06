/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Batch;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Brian
 */
public class ErrorReport 
{
    private final DateFormat format;
    private String fileName;
    private Date date;
    private PrintWriter writer;
    static ErrorReport error;
    
    private ErrorReport()
    {
	date = new Date();
	format = new SimpleDateFormat("MM-dd-yyyy");
	fileName = "Error Log " + format.format(date) + ".txt"; 
	try
	{
	    writer = new PrintWriter(fileName);
	} 
	catch (IOException e) 
	{
	    
	}
    }
    static ErrorReport getErrorReport() //use this to get an object for ErrorReport so it can be limited to 1 per run
    {
	
	if(error == null)
	{
	    error = new ErrorReport();
	    return error;
	}
	else
	{
	    return error;
	}
    }
    void writeHeader(String string)
    {
	writer.println("******************************************************************************************************");
	writer.println("***********************************" + string + "***********************************");
	writer.println("******************************************************************************************************\n");
	writer.flush();
    }
    
    void writeToLog(String string)
    {
	writer.println("ERROR: " + string);
	writer.flush();
    }
}