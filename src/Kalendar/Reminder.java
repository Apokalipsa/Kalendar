package Kalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reminder {

	public static ArrayList<String> podsjetnik = new ArrayList<String>();
	public static File text = new File("reminderOfCalendar.txt");

	
	public static void ucitajReminder() {                        // ovom metodom otvaramo fajl

		Scanner otvoriFile;
		try {
			 otvoriFile= new Scanner(text);
			
			while ( otvoriFile.hasNextLine()) {
				
				podsjetnik.add( otvoriFile.nextLine());
			}

		} catch (FileNotFoundException e) {
			
			e.getMessage();

		} finally {

		}

	}

	public static void dodajReminder() {             

		Scanner input = new Scanner(System.in);
		
		System.out.print("  Dodajte podsjetnik: ");
		
		podsjetnik.add(input.nextLine());                      // ovom metodom cemo omoguciti korisniku da dodaje nove posjetnike( reminder)

		input.close();
	}

	    
	public static void ispisRemindera() {

		PrintWriter ucitavanjeFilea;
		try {
			ucitavanjeFilea = new PrintWriter(new FileOutputStream(text)); // ovom metodom vrsimo novi upis podsjetnika na fajl

			for (String unos : podsjetnik)
				
				ucitavanjeFilea.println(unos);

			ucitavanjeFilea.close();
			
		} catch (FileNotFoundException e) {
			
			e.getMessage();

		} finally {

		}

	}

}
