package prog5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Kadry {
    
    static Connection con=null;
    
    public Pracownik wyszukaj(PESEL p) throws ClassNotFoundException, SQLException{
    	
    	
    	
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pracownicy","root","");
		PreparedStatement statement;
		ResultSet result;
		
				String pesel = p.getPesel();
				pesel = pesel.trim();
				statement = con.prepareStatement("select * from pracownicy where pesel='"+pesel+"'");
				
				result = statement.executeQuery();
				
				while(result.next()){
					PESEL pes = new PESEL(result.getString(1));
					String znak = result.getString(3);
					if(znak.equals("s")){
							Student s = new Student(pes);
							s.wynagrodzenieBrutto = Double.parseDouble(result.getString(2));
							return s;
					}
					else {
						PracownikEtatowy pr = new PracownikEtatowy(pes);
						pr.wynagrodzenieBrutto = Double.parseDouble(result.getString(2));
						return pr;
					}
					
				}
				return null;
    }
    
    public void dodaj(PESEL p) throws ClassNotFoundException, SQLException{
    	
    	
    	Scanner scan = new Scanner(System.in);
    	String pes = p.getPesel();
		System.out.println("1.Podaj wynagrodzenie:");
		double wyn = scan.nextDouble();
		scan.nextLine();
	
		System.out.println("1.s - student, e - pracownik etatowy");
		String znak = scan.nextLine();
    	
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pracownicy","root","");
		Statement statement;
		ResultSet result;
		
			statement = con.createStatement();
			statement.executeUpdate("insert into pracownicy (pesel, brutto, id)"+
			" values ('"+pes+"',"+wyn+",'"+znak+"')");
    }
    
    
    
    public void zmienBrutto(PESEL p) throws ClassNotFoundException, SQLException{
    	Pracownik prac = wyszukaj(p);
    	if(prac!=null){
    		System.out.println("Podaj nowe wynagrodzenie:");
    		Scanner s = new Scanner(System.in);
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pracownicy","root","");
    		Statement statement;
    		ResultSet result;
    		
    			statement = con.createStatement();
    			statement.executeUpdate("update pracownicy set brutto = "+s.nextDouble()+" where pesel = '"+p.getPesel()+"'");
    	}
    }
    
    public double pobierzNetto(PESEL p) throws ClassNotFoundException, SQLException{
    	Pracownik prac = wyszukaj(p);
    	if(prac!=null){
    		return prac.obliczNetto();
    	}
    	return 0;	
    	
    }
    
    public void sortuj() throws ClassNotFoundException, SQLException{
    	

		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pracownicy","root","");
		PreparedStatement statement=null;
		ResultSet result;
		        System.out.println("Sortuj wed³ug:\n1.pesel\n2.kwota brutto");
		        Scanner scan = new Scanner(System.in);
		        int wybor = scan.nextInt();
		        System.out.println("Jak sortowaæ? :\n1.rosn¹co\n2.malej¹co");
		        
		        int wybor2 = scan.nextInt();
		        switch(wybor){
		        case 1:
		        		if(wybor2==1){
		        			statement = con.prepareStatement("select * from pracownicy order by pesel asc");
		        		}
		        		else{
		        			statement = con.prepareStatement("select * from pracownicy order by pesel desc");
		        		}
		        		
		        break;
		        case 2:
		        	if(wybor2==1){
	        			statement = con.prepareStatement("select * from pracownicy order by brutto asc");
	        		}
	        		else{
	        			statement = con.prepareStatement("select * from pracownicy order by brutto desc");
	        		}
		        	
		        }
				
				
				result = statement.executeQuery();
				while(result.next()){
					System.out.println(result.getString(1) + " " + result.getString(2));
				}
	
    }
    
    public void wypisz() throws ClassNotFoundException, SQLException{
    
	Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pracownicy","root","");
		
		PreparedStatement statement = con.prepareStatement("select * from pracownicy");
		
		ResultSet result = statement.executeQuery();
		
		StringBuilder s = new StringBuilder();
		while(result.next()){
			s.append(result.getString(1) + " " + result.getString(2)+"\n");
		}
		System.out.println(s.toString());
    	
    }
    
}
