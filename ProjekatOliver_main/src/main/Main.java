package main;

import automobilPaket.Automobil;
import automobilPaket.Model;
import automobilPaket.Proizvodjac;
import automobilPaket.VrstaAutomobila;
import guiPaket.LoginProzorDispecer;
import guiPaket.LoginProzorMusterija;
import guiPaket.LoginProzorVozac;
import guiPaket.formeZaPrikaz.DispeceriProzorDispecer;
import guiPaket.formeZaPrikaz.VozaciProzorDispecer;
import guiPaket.formeZaPrikaz.VoznjeProzorDispecer;
import osobePaket.Dispecer;
import osobePaket.Musterija;
import osobePaket.OdeljenjeDispecer;
import osobePaket.Pol;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;
import voznjaPaket.StatusVoznje;
import voznjaPaket.Voznja;
import binarnaPretragaPaket.IDSorterDispecer;

public class Main {
	
	public static String DISPECERI_FAJL = "dispeceri1.txt";
	public static String AUTOMOBILI_FAJL = "automobili.txt";
	public static String VOZACI_FAJL = "vozaci.txt";
	public static String MUSTERIJE_FAJL = "musterije.txt";
	public static String VOZNJE_FAJL = "voznje.txt";

	public static void main(String[] args) {
		
		/* NAPOMENE:
		 * Kako sam gledao u specifikaciji, kreiranje, pregled i izmena entiteta iz AISP nosi 20 poena, a tu funkcionalnost
		 * smo trebali raditi i iz UOP-a. Ja sam to uradio kroz Swing, tako sto u glavnom meniju dispecera ima JMenu
		 * CRUD dispeceri, CRUD vozaci itd. pa tamo ima mogucnosti za pregled, kreiranje, izmenu i brisanje entiteta.
		 * Taj nacin je odgovaralo na UOP-u, posto sam dobio maksimalne poene za to na kontrolnoj tacki, a nadam se i kod
		 * Vas da ce to biti ok. Ja sam za ovaj predmet dodao za svaki slucaj i CRUD za musterije i automobile (to ja iz
		 * UOP-a nisam trebao jer radim sam). Takodje, u klasi TaksiSluzba imam napisane i neke metode za konzolnu
		 * izmenu i brisanje svih entiteta, ali nisam ih koristio posto sam odmah uradio da funkcionise kroz Swing.
		 * 
		 * Sto se tice ostalih funkcionalnosti za AISP, napravio sam pakete u kojima sam implementirao svoje strukture
		 * (nepotpune) za SingleLinkedList i za HashMap, na osnovu onoga kako smo na vezbama radili.
		 * 
		 * Sortiranja sam radio pomocu RowSorter, pretrage preko filtriranja tabela, tako sto u input moze da se unese
		 * bilo koji kriterijum, za bilo koju kolonu. Binarnu pretragu sam takodje implementirao, koristeci 
		 * Comparator i while petlju.
		 * 
		 * Aukciju sam ja osmislio kao neki hint page kod dispecera. Znaci dispecer, kad se uloguje, ima JMenu za Aukciju
		 * u kome mu se prikazuju svi neobrisani vozaci, i moze da klikne na dugme "Info o vozacima", i onda mu se
		 * prikazu za svakog vozaca broj voznji, ukupna kilometraza, prosecna kilometraza po voznji, starost vozila,
		 * ocena, da li je pet friendly itd. pa na osnovu ovih informacija da dispecer odluci kom ce vozacu da
		 * dodeli voznju.
		 * 
		 * Za sumirane statistike u meniju dispecera (samo tu statistiku sam trebao uraditi jer sam radim) sam uneo
		 * staticke podatke na dnevnom, nedeljnom, mesecnom i godisnjem nivou za poslovanje ove taksi sluzbe.
		 */
		
		TaksiSluzba taksiSluzba = new TaksiSluzba();
		
		//UCITAVANJE PODATAKA
		
		taksiSluzba.ucitajDispecere(DISPECERI_FAJL);
		taksiSluzba.ucitajAutomobile(AUTOMOBILI_FAJL);
		taksiSluzba.ucitajVozace(VOZACI_FAJL);
		taksiSluzba.ucitajMusterije(MUSTERIJE_FAJL);
		taksiSluzba.ucitajVoznje(VOZNJE_FAJL);
		
		//BINARNA PRETRAGA
		
		System.out.println(taksiSluzba.pronadjiDispeceraBinarnaPretraga(1));
		System.out.println(taksiSluzba.pronadjiAutomobilBinarnaPretraga(2));
		System.out.println(taksiSluzba.pronadjiVozacaBinarnaPretraga(3));
		System.out.println(taksiSluzba.pronadjiMusterijuBinarnaPretraga(1));
		System.out.println(taksiSluzba.pronadjiVoznjuBinarnaPretraga(1));
		
		//LOGIN PROZORI ZA SVAKU ULOGU KORISNIKA
		
		LoginProzorDispecer loginProzorDispecer = new LoginProzorDispecer(taksiSluzba);
		loginProzorDispecer.setVisible(true);
		
		LoginProzorVozac loginProzorVozac = new LoginProzorVozac(taksiSluzba);
		loginProzorVozac.setVisible(true);
		
		LoginProzorMusterija loginProzorMusterija = new LoginProzorMusterija(taksiSluzba);
		loginProzorMusterija.setVisible(true);
		
		//CRUD za dispecere, vozace i voznje
	
		DispeceriProzorDispecer dispeceriProzorDispecer = new DispeceriProzorDispecer(taksiSluzba);
		dispeceriProzorDispecer.setVisible(false);
		
		VozaciProzorDispecer vozaciProzorDispecer = new VozaciProzorDispecer(taksiSluzba);
		vozaciProzorDispecer.setVisible(false);
		
		VoznjeProzorDispecer voznjeProzorDispecer = new VoznjeProzorDispecer(taksiSluzba);
		voznjeProzorDispecer.setVisible(false);

}}
