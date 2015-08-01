package Kalendar;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KALENDAR {
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);                                      // trazimo unos za godinu i mjesec od korisnika
		
		System.out.print("Unesite godinu za koju zelite pogledati kalendar: ");
		int godina = input.nextInt();                                              // smjestamo unos u deklarisane promjenljive
		
		System.out.print("Unesite mjesec za koji zelite pogledati kalendar: ");
		int mjesec = input.nextInt();
		
		GregorianCalendar kalendar = new GregorianCalendar();                     // kreiramo objekat iz javine klase za kalenar
		
		int brojDana = 0;
		switch (mjesec) {                                                        // dodjeljujemo danima kalendara tacne brojeve
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			brojDana = 31;                                                   // svim mjesecima koji imaju 31 dan vrsimo dodjelu
			break;
		case 2:
			if (kalendar.isLeapYear(godina))                                // ako je godina prestupna postavljamo uslov
				brojDana = 29;
			else
				brojDana = 28;                                            // ako nije prestupna dodijelilo dane
			break;
		case 4:
		case 6:
		case 9:                                                         // ostalim koi imaju 30 dana vrsimo dodjelu
		case 11:
			brojDana = 30;
			break;
		default:
			System.out.println("Pograšna specifikacija mjeseca!");
			System.exit(-1);
		}
		
		                                                                // Kalendar poèinje od prvog dana datog meseca i godine
		kalendar.set(godina, mjesec - 1, 1); 
		                        
		naslovImenaDana(godina,mjesec);                               // pozivanje metode koja ce printati naslov kalendara
		int prviDan = kalendar.get(Calendar.DAY_OF_WEEK);            // pozivanje dana iz javine klase kalendar
		System.out.println("_______________________________");
		System.out.println("|PON|UTO|SRI|ÈET|PET|SUB|NED|");        // ispis dana ispod naslova kalendara
		System.out.println();
		
		tijeloKalendara(prviDan,brojDana);  //pozivanje prethodno kreirane metode koja ce isprintati tijelo kalendara
		
		Reminder.ucitajReminder();          // pozivamo se na metod koji ce otvoriti file
		
		System.out.println(" \n Ukoliko zelite podsjetnik pritisnite 0 ");
		String  posjetnik= input.nextLine();
		
		System.out.println("\n  Unije li ste ");
		for (String unos : Reminder.podsjetnik) {   // ispisujemo u konzoli unijeti korisnicki  podsjetnik
			System.out.println("--->  " +unos);
	
			Reminder.dodajReminder();              // pozivamo se na ponovni unos posjetnika
		}
			Reminder.ispisRemindera();           // ovom metodom vrsimo novi upis podsjetnika na fajl
		
	}
	public static boolean isLeapYear(int godina) {                                    // metoda za provjeru prestupne godine
		if ((godina % 400 == 0) || (godina % 4 == 0) || (godina % 100 != 0)) {
			return true;                                                             // ako jeste ona vraca true
			
		} else {
			return false;                                                          // ako nije prestupna vraca false
		}

	}
	public static String imenaMjeseca(int mjeseci) {      // metoda koja ce nam vratiti ime mjeseca
		String mjesec = "";                              // prazna varijabla koja sluzi za smjestaj nadjenog imena mjeseca
		switch (mjeseci) {

		case 1:
			mjesec = "Januar";
			break;
		case 2:
			mjesec = "Februar";
			break;
		case 3:
			mjesec = "Mart";
			break;
		case 4:
			mjesec = "April";
			break;
		case 5:
			mjesec = "Maj";
			break;
		case 6:
			mjesec = "Jun";
			break;
		case 7:
			mjesec = "Jul";                     // svakom case slucaju dodjeljujemo odgovarajuce ime mjeseca
			break;
		case 8:
			mjesec = "Avgust";
			break;
		case 9:
			mjesec = "Septembar";
			break;
		case 10:
			mjesec = "Oktobar";
			break;
		case 11:
			mjesec = "Novembar";
			break;
		case 12:
			mjesec = "Decembar";
			break;
		}
		return mjesec;                                       // 0utput nase metode

	}
	

	public static void naslovImenaDana(int godina, int mjeseci) {               // metoda koja vizuelno pravi naslov i pokazuje mjesec i godinu

		System.out.println("       " + imenaMjeseca(mjeseci) + " | " + godina);// pozivanje prethodne metode kreirane za  prikaz imena mjeseca

}
	
	public static void tijeloKalendara(int prviDan, int brojDana) {            // metoda koja ce printati kalendar

		int brojac = 0;                                                  
		// SUNDAY=1, MONDAY=2, ..., SATURDAY=7
		for (int i = Calendar.MONDAY; i <= Calendar.SATURDAY; i++) {        // kroz petlju prolazimo kroz dane iz javine klase kalendar
			if (prviDan == i)                                              // kazemo da je nas prvi dan jednak i tom clanu
				break;
			System.out.print(" ");                                       // i printamo prazan prostor
			brojac++;                                                   // brojac nam odredjuje koliko je tog prostora potrebno
		}
		for (int dan = 1; dan <= brojDana; dan++) {                   // dane pocinjemo da brojimo od 1 pa sve do dana koliko trazeni mjesec ima
			System.out.printf("%4d", dan);                          // uz odgovarajuci ramak upisujemo dane koji c eciniti tijelo kalendara
			brojac++;
			if (brojac == 7) {                                     // za svakih 7 dana prelazak stampanja u novi red
				System.out.println();
				brojac = 0;
			}
		}
		System.out.println();
		
}
}
