package prog5;
import prog5.PESEL;
import prog5.Pracownik;

public abstract class Pracownik {
	 PESEL pesel;
	 double wynagrodzenieBrutto;
	 
	 public Pracownik(PESEL p){
		 pesel = p;
	 }
	 
	 public abstract double obliczNetto();
	 
	 public boolean equals(Object o){
		 if(this.obliczNetto()==((Pracownik)o).obliczNetto())
			 return true;
		 return false;
	 }
	 
}
