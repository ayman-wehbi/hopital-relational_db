// Sheer Fiol, Ayman Wehbi


import java.util.*;
import java.io.*;

public class Phase2 {
	public static void main(String[] args){
		//Make sure you didn't forget to pass the table name
		if (args.length == 0){
			System.out.println("You forget to pass a table name!");			
			return;
		}
		
		String tableName = args[0]; // store the table name in a variable
	
		try{
			File infile = new File(String.format("%s.csv", tableName)); // In this project, the table names will match the input .csv files.	
			FileWriter outfile = new FileWriter(String.format("%s.sql", tableName)); // We will also name our output .sql files accordingly.
			
			Scanner ins = new Scanner(infile);
			while (ins.hasNextLine()){ //read through the file line-by-line
				String line = ins.nextLine();				
				String output = getSQLInsert(tableName, line); // I created a separate method to generate my insert statements.				
				outfile.write(output);
			}
			outfile.close();
			ins.close();
	
		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());			
		}		
	}

	public static String getSQLInsert(String tableName, String line){
		
		String insertTemplate = "INSERT INTO " + tableName + " VALUES("; //I used placeholders to simply place my table name and correctly formatted values into an insert statement.

		String[] list = line.split(",");
		
			for(int i =0; i < list.length; i++){
				try{
					insertTemplate += Integer.parseInt(list[i].trim());
				}catch(NumberFormatException e){
					if(list[i].trim().equals("NULL")){
						insertTemplate += "NULL";
					}else
				    	insertTemplate += addQuotes(list[i].trim());
					
				}
				insertTemplate += ", ";
			}
		insertTemplate = insertTemplate.substring(0, insertTemplate.length() - 2);
		insertTemplate += ");\n";
		//This is where it is up to you to properly format values for you insert statements.

		return insertTemplate;
	}

	public static String addQuotes(String s){
			return new StringBuilder().append('\'').append(s).append('\'').toString();
		}
		
}