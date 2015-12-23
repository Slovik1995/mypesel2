package prog5;

import prog5.PESEL;

public class PESEL {
	private String nrpesel;
	
	public PESEL(String nr){
		nrpesel = nr;
	}
	public String getPesel(){
		return nrpesel;
	}
	public static boolean check(PESEL p){
		String pesel = p.getPesel();
		
		if (pesel.length()!=11)
			return false;
		
		Character alfa='x';
		for(int i=0; i<11; i++){
			if(alfa.isDigit(pesel.charAt(i))==false)
				return false;	
		}
	
	int a = Integer.parseInt(pesel.substring(0, 1)); 
	int b = Integer.parseInt(pesel.substring(1, 2)); 
	int c = Integer.parseInt(pesel.substring(2, 3)); 
	int d = Integer.parseInt(pesel.substring(3, 4)); 
	int e = Integer.parseInt(pesel.substring(4, 5)); 
	int f = Integer.parseInt(pesel.substring(5, 6)); 
	int g = Integer.parseInt(pesel.substring(6, 7)); 
	int h = Integer.parseInt(pesel.substring(7, 8)); 
	int i = Integer.parseInt(pesel.substring(8, 9)); 
	int j = Integer.parseInt(pesel.substring(9, 10)); 
	
	int wyn = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j;
	int reszta = wyn % 10;
	if(reszta==0)
		if(pesel.charAt(10)!='0')
			return false;
	if(reszta!=0)
	{
		Character ch = pesel.charAt(10);
		String s = ch.toString();
		int uzupelnienie = 10-reszta;
		int cyfra11 = Integer.parseInt(s);
		if(cyfra11!=uzupelnienie)
			return false;
	}
	
	String str;
	int k;
	int mies;
	str=Character.toString(pesel.charAt(2));
	str+=Character.toString(pesel.charAt(3));
	k=Integer.parseInt(str);
	if(k>12) return false;
	mies=k;
	str=Character.toString(pesel.charAt(4));
	str+=Character.toString(pesel.charAt(5));
	k=Integer.parseInt(str);
	if((mies==1)||(mies==3)||(mies==5)||(mies==7)||(mies==8)||(mies==10)||(mies==12))
		{
			if(k>31)
			return false;
		}
	else if((mies==4)||(mies==6)||(mies==9)||(mies==11))
		{
			if(k>30)
				return false;
		}
	else{
		str=Character.toString(pesel.charAt(0));
		str+=Character.toString(pesel.charAt(1));
		int rok = Integer.parseInt(str);
		if(rok<2016)
			rok+=2000;
		else 
			rok+=1900;
		if(((rok%4==0)&&(rok%100!=0))||((rok%4==0)&&(rok%400==0)))
			{
			if(k>29)
				return false;
			}
		else if(k>28)
			return false;
		}
		
	 	
	return true;
	}
	
	
}
