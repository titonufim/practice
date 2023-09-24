import myfirstpackage.*;

class MyFirstClass 
{
	public static void main(String[] s)
	{
	MySecondClass o = new MySecondClass();
	
	System.out.println(o.multiplication());
	
 for (int i = 1; i <= 8; i++) 
 {
	 for (int j = 1; j <= 8; j++) 
	 {
		o.setA(i);
		o.setB(j);
		System.out.print(o.multiplication());
		System.out.print(" ");
	 }
	 System.out.println();
 }


	}
	
}

