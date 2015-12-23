package prog5;
import prog5.PESEL;
import prog5.Pracownik;

public class Student extends Pracownik{
	
	public Student(PESEL p){
		super(p);
	}

	
	public double obliczNetto(){
		return wynagrodzenieBrutto*2000;
	}
	
	
	
}
