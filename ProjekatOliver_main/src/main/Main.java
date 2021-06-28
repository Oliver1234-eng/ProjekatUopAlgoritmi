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
