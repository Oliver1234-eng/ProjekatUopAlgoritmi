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
		
		LoginProzorDispecer loginProzorDispecer = new LoginProzorDispecer(taksiSluzba);
		loginProzorDispecer.setVisible(true);
		
		LoginProzorVozac loginProzorVozac = new LoginProzorVozac(taksiSluzba);
		loginProzorVozac.setVisible(true);
		
		LoginProzorMusterija loginProzorMusterija = new LoginProzorMusterija(taksiSluzba);
		loginProzorMusterija.setVisible(true);
	
		DispeceriProzorDispecer dispeceriProzorDispecer = new DispeceriProzorDispecer(taksiSluzba);
		dispeceriProzorDispecer.setVisible(false);
		
		VozaciProzorDispecer vozaciProzorDispecer = new VozaciProzorDispecer(taksiSluzba);
		vozaciProzorDispecer.setVisible(false);
		
		VoznjeProzorDispecer voznjeProzorDispecer = new VoznjeProzorDispecer(taksiSluzba);
		voznjeProzorDispecer.setVisible(false);

}}
