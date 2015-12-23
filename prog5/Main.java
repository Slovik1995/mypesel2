package prog5;

import java.awt.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] arg) throws ClassNotFoundException, SQLException{
    	PESEL p1 = new PESEL("95012807336");
    	PESEL p2 = new PESEL("12345678915");
    	PESEL p3 = new PESEL("89345678915");
    	
    	Student s = new Student(p1);
    	
    	Kadry kadry = new Kadry();
    	//System.out.println(kadry.wyszukaj(p1).wynagrodzenieBrutto);
    	//System.out.println(kadry.wyszukaj(p2).wynagrodzenieBrutto);
    	//kadry.dodaj(p3);
    	//kadry.wypisz();
    	kadry.sortuj();
    	//kadry.zmienBrutto(p3);
    	/*
    	kadry.dodaj(p2);
    	kadry.dodaj(p3);
    	kadry.dodaj(p4);
    	
    	kadry.zmienBrutto(p1);
    	kadry.zmienBrutto(p2);
    	kadry.zmienBrutto(p3);
    	kadry.zmienBrutto(p4);
    	
    	//System.out.println(kadry.pobierzNetto(kadry.wyszukaj(p2).pesel));
    	
    	kadry.wypisz();
    	kadry.sortuj();
    	kadry.wypisz();
    	*/
    	
    }
}
