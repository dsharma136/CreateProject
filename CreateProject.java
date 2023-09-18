import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateProject
{
	private static int address = 0;
	private static String number1 = "Hello";
	private static String [] total = new String[100];
	private static String [] sum = new String[100];

	public static void main(String [] args)
	{
		CreateProject cp = new CreateProject();
		cp.medicalHelp();
		cp.mentalHelp();
		cp.displayInformation();
	}
	public void medicalHelp()
	{
		Scanner inputGetter = new Scanner(System.in);

		System.out.println("Enter the five digit zipcode of your address if you live in Cupertino: "); 
		address = inputGetter.nextInt();

		String address1 = Integer.toString(address); 
				
		int number = number1.length();

		if(address1.length() != number)
		{
			System.out.println("NEXT TIME, PLEASE ENTER A VALID ZIP CODE.");
			System.exit(1);
		}

		int counter = 0;
		try {
		      File myObj = new File("medical.txt");
		      Scanner myReader = new Scanner(myObj);

		      while (myReader.hasNextLine()) 
		      {
		      	String data = myReader.nextLine();
		      
		      	int num = data.length(); 
		      	int firstNum = num;
		      	int secondNum = num - 5;

				String answer = data.substring(secondNum,firstNum); 
				int conversion = Integer.parseInt(answer); 

				int finalAnswer = conversion - address;
				
				
				if(finalAnswer <= 50 && finalAnswer >= -50)
				{
					total[counter] = data;
					counter++;
				}

		      }
		      myReader.close();
		    }

		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 

	}
	public void mentalHelp()
	{
		int y = 0;
		try {
		      File rehab = new File("rehabilitation.txt");
		      Scanner reader = new Scanner(rehab);

		      while (reader.hasNextLine()) 
		      {
		      	String rehabdata = reader.nextLine();
		      
		      	int length = rehabdata.length(); 
		      	int thirdNum = length;
		      	int fourthNum = length - 5;

				String zip = rehabdata.substring(fourthNum,thirdNum); 
				int convo = Integer.parseInt(zip); 
				int finalZip = convo - address;
				
				
				if(finalZip <= 50 && finalZip >= -50)
				{
					sum[y] = rehabdata;
					y++;
				}

		      }
		      reader.close();
		    }

		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 
	}
	public void displayInformation()
	{
		System.out.println("\n");
		System.out.println("These are the hospitals that are closest to you.");

		for(int x = 0; x < total.length; x++)
		{
			if(total[x] == null)
			{
				break;
			}

			System.out.println(total[x]);
		}

		System.out.println("\n");
		System.out.println("These are the rehabilitation centers that are closest to you.");


		for(int y = 0; y < sum.length; y++)
		{
			if(sum[y] == null)
			{
				break;
			}
			System.out.println(sum[y]);
		}
	}
}