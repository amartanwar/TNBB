package generic;	
import  java.sql.Connection;			
import  java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.sql.Statement;	

public class  SqlServerConnector {				
    	public static void  main(String[] args) throws   SQLException, ClassNotFoundException
    	{			
    		
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
    		   
                String dbUrl ="jdbc:sqlserver://otbsqlserver;database=MAG_TotalViewQA;user=development;password=jk";
            	Connection con = DriverManager.getConnection(dbUrl);
                if (con != null)
                {
                    System.out.println("Connected");
                }

                
//				//Query to Execute		
				String query = "select top 3 *  from customer_profile;";	
              

      		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
     			
        	// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);		
         		int columns=rs.getMetaData().getColumnCount();
//         		rs.last();
         		int rows = rs.getRow();
         	
         		System.out.println(rows);
      
         		
         	// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String AccountNumber = rs.getString(2);								        
                            String CompanyName = rs.getString(8);	
                            String CustomerId = rs.getString(1);	
                            System. out.println("CustomerId "+CustomerId);		
                            System. out.println("AccountNumber "+AccountNumber);	
                            System. out.println("CompanyName "+CompanyName);	
                    }	
				
		//Dumping result into object
				
				Object[][] resultSet = new Object[rows][columns];
		        int row = 0;
		        while (rs.next())
		        {
		            for (int i = 0; i < columns; i++) 
		            {
		                resultSet[row][i] = rs.getObject(i+1);
		            }
		            row++;
		        }
				
          //closing DB Connection		
      			con.close();			
		}
    	
}