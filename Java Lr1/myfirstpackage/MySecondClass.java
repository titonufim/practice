package myfirstpackage;
public class MySecondClass
{
	private int a, b;
	
	public MySecondClass(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public MySecondClass()
	{
		a = 0;
		b = 0;
	}
	
	public void setA(int a)
	{
		this.a = a;
	}
	
	public void setB(int b)
	{
		this.b = b;
	}
	
	public int getA()		
	{
       return a;
    }
	
	public int getb()		
	{
       return b;
    }
	
	public int multiplication()		// variant 3
	{
		return this.a*this.b;
	}
}
