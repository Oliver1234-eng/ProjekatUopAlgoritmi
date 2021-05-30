package main;

import automobil.Automobil;
import automobil.Model;
import automobil.Proizvodjac;
import automobil.VrstaAutomobila;
import gui.LoginProzorDispecer;
import gui.LoginProzorMusterija;
import gui.LoginProzorVozac;
import gui.formeZaPrikaz.DispeceriProzorDispecer;
import gui.formeZaPrikaz.VozaciProzorDispecer;
import gui.formeZaPrikaz.VoznjeProzorDispecer;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.OdeljenjeDispecer;
import osobe.Pol;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class Main {
	
	public static String DISPECERI_FAJL = "dispeceri.txt";
	public static String AUTOMOBILI_FAJL = "automobili.txt";
	public static String VOZACI_FAJL = "vozaci.txt";
	public static String MUSTERIJE_FAJL = "musterije.txt";
	public static String VOZNJE_FAJL = "voznje.txt";

	public static void main(String[] args) {
		TaksiSluzba taksiSluzba = new TaksiSluzba();
		
		taksiSluzba.ucitajDispecere(DISPECERI_FAJL);
		taksiSluzba.ucitajAutomobile(AUTOMOBILI_FAJL);
		taksiSluzba.ucitajVozace(VOZACI_FAJL);
		taksiSluzba.ucitajMusterije(MUSTERIJE_FAJL);
		taksiSluzba.ucitajVoznje(VOZNJE_FAJL);
		
		/*NAPOMENE:
		 
		 Napravio sam 3 login prozora, posebno za prijavu dispecera, posebno za prijavu vozaca i posebno
		 za prijavu musterija. To su ti prozori LoginProzorDispecer, LoginProzorVozac i LoginProzorMusterija.
		 Kod svakog od ta 3 prozora (kada se startuje) sam ja setovao tekst za username i password postojece osobe, pa treba samo
		 pritisnuti taster ENTER ili button Prijavi se i prikaze se odgovarajuci meni, u zavisnosti od toga da li
		 je u pitanju login za dispecera, vozaca ili musteriju. 
		 
		 Sto se tice CRUD-a, ja radim sam projekat, pa sam imao da uradim CRUD za dispecere, vozace i voznje putem
		 telefona. To sam ja odradio preko Swinga. To su ti prozori DispeceriProzorDispecer, VozaciProzorDispecer
		 i VoznjeProzorDispecer. Rec dispecer se spominje kod sva ta 3 prozora posto sam ja prvobitno ovaj CRUD
		 odradio tako da se dispecer uloguje i onda da mu se prikazu JMenuItem-i za prikaz dispecera, vozaca i voznji i
		 klikom na svaku od tih Item-a se prikazu svi dispeceri, odnosno vozaci, odnosno voznje i postoje mogucnosti za
		 njihovo dodavanje, izmenu i brisanje. To moze jos uvek da se tako proveri, ali sam ovde u main klasi izdvojio i
		 posebno ta 3 prozora i kad se startuje program onda se odmah prikazu ti entiteti, sa mogucnoscu dodavanja,
		 izmene i brisanja.
		 
		 Jos da napomenem, ukoliko Vi proveravate da li radi, kada se dodaje ili menja jedan entitet, promena se
		 ne prikaze odmah u Swingu, nego treba jos jednom pokrenuti program da bi se osvezilo i onda ce se sve
		 promene prikazati kako u Swingu, tako i u tekstualnim fajlovima.
		 
		 */
		
		/* POKRETANJE:
		Ovde u main klasi sam ostavio ovih ukupno 6 prozora (3 login i 3 CRUD), i postavio sam za svaku
		setVisible(true), odnosno prilikom pokretanja programa ce se svih 6 prozora prikazati jedan preko drugog.
		Da se to ne bi desilo, moze taj setVisible osobina da se promeni npr. kod 5 prozora na false, a kod 1 prozora 
		da ostane true, pa ce se samo taj jedan odredjeni prozor prikazati, i onda funkcionalnost svakog od tih
		prozora se moze pojedinacno proveravati.
		
		 */
		
		
		
		LoginProzorDispecer loginProzorDispecer = new LoginProzorDispecer(taksiSluzba);
		loginProzorDispecer.setVisible(true);
		
		LoginProzorVozac loginProzorVozac = new LoginProzorVozac(taksiSluzba);
		loginProzorVozac.setVisible(true);
		
		LoginProzorMusterija loginProzorMusterija = new LoginProzorMusterija(taksiSluzba);
		loginProzorMusterija.setVisible(true);
	
		DispeceriProzorDispecer dispeceriProzorDispecer = new DispeceriProzorDispecer(taksiSluzba);
		dispeceriProzorDispecer.setVisible(true);
		
		VozaciProzorDispecer vozaciProzorDispecer = new VozaciProzorDispecer(taksiSluzba);
		vozaciProzorDispecer.setVisible(true);
		
		VoznjeProzorDispecer voznjeProzorDispecer = new VoznjeProzorDispecer(taksiSluzba);
		voznjeProzorDispecer.setVisible(true);

}}
