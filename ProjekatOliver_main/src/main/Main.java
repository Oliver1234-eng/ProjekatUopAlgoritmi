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
		
		/* NAPOMENE
		 * Kao i za kt2, i sada sam ovde u main podesio sve prozore na setVisible(true), pa æe prilikom pokretanja
		 * sve da iskoce jedna preko druge, a moguce je jedan prozor ostaviti na true, a sve ostalo promeniti na false
		 * da samo jedan iskoci. Sve funkcionalnosti sam implementirao vezano za UOP deo i uradio navigaciju. Nova 
		 * dodavanja ili izmene nece biti odmah vidljive u tabelama, nego treba izaci pa opet uci da bi se
		 * osvezilo (a u txt fajlovima se odmah uocava svaka promena).
		 * 
		 * Dispecer dodeljuje voznju vozacu tako sto ga odabere iz liste na osnovu id-a (username). Jedino da napomenem
		 * unapred da, kada vozac prihvata/odbija voznju i kada ga zavrsava, onda mu se otvara forma i na toj formi se
		 * nekako ime vozaca vrati na default-nu vrednost (null), pa ga treba u toj listi ponovo odabrati 
		 * (svakako ostaje da je njemu dodeljena, nego u formi se ne znam iz kog razloga vrati na null vrednost).
		 * 
		 * Sto se ostatka tice, nemam nikakvih napomena. CRUD se moze pokrenuti kao prozor i ovde u main-u, ali i kod
		 * ulogovanog dispecera ima JMenu sa CRUD-om za vozace, voznje i dispecere i moze se i tako otvoriti, ali u oba
		 * slucaja radi posao.
		 */
		
		//LOGIN PROZORI ZA SVAKU ULOGU KORISNIKA
		
		LoginProzorDispecer loginProzorDispecer = new LoginProzorDispecer(taksiSluzba);
		loginProzorDispecer.setVisible(true);
		
		LoginProzorVozac loginProzorVozac = new LoginProzorVozac(taksiSluzba);
		loginProzorVozac.setVisible(true);
		
		LoginProzorMusterija loginProzorMusterija = new LoginProzorMusterija(taksiSluzba);
		loginProzorMusterija.setVisible(true);
		
		//CRUD za dispecere, vozace i voznje
	
		DispeceriProzorDispecer dispeceriProzorDispecer = new DispeceriProzorDispecer(taksiSluzba);
		dispeceriProzorDispecer.setVisible(true);
		
		VozaciProzorDispecer vozaciProzorDispecer = new VozaciProzorDispecer(taksiSluzba);
		vozaciProzorDispecer.setVisible(true);
		
		VoznjeProzorDispecer voznjeProzorDispecer = new VoznjeProzorDispecer(taksiSluzba);
		voznjeProzorDispecer.setVisible(true);

}}
