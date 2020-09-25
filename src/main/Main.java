package main;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static int rec(int i)
	{
		
		while(i<100)
		{
			System.out.println("i = "+i);
			i=i*2;
			System.out.println("i*2 = "+i);
				
			if(i> 100)
			{
				System.out.println("fin de recursivite");
				return i;
			}
			else
			{
				System.out.println("new recursive");
				rec(i);
				return i;
				
			}
			
		}
		return i;
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		boolean ouv = true;
		System.out.println("ouverte : "+ouv);
		
		TimeUnit.SECONDS.sleep(3);
		ouv = false;
		System.out.println("ouverte : "+ouv);
		*/
		
		
		
		
		/*
		System.out.println("porte ouverte : "+p.isPorteOuverte());
		while(p.isPorteOuverte())
		{
			System.out.println("ouveeeeeerte");
		}
		if(!p.isPorteOuverte())
		{
			System.out.println("la porte est fermé");
		}
		System.out.println("porte ouverte : "+p.isPorteOuverte());
		*/
		
		//int i=1;
		//rec(i);
		
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(int i=0;i<=10;i++)
		{
			if(i==3 || i==6)
				liste.add(0);
			else
				liste.add(i);
		}
		
		for(int i=0;i<=10;i++)
		{
			System.out.println(liste.get(0)+" size: "+liste.size());
			liste.remove(0);
		}
		
		
		 
	}

}
