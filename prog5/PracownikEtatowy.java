package prog5;

import prog5.PESEL;
import prog5.Pracownik;

public class PracownikEtatowy extends Pracownik{
	
	public PracownikEtatowy(PESEL p){
		super(p);
	}

	public double obliczNetto(){
		return wynagrodzenieBrutto*1000;
	}
}
