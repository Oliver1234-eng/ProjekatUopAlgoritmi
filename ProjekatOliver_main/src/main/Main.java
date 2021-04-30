package main;

import automobil.Automobil;
import automobil.Model;
import automobil.Proizvodjac;
import automobil.VrstaAutomobila;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.OdeljenjeDispecer;
import osobe.Pol;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class Main {
	
	private static String DISPECERI_FAJL = "dispeceri.txt";
	private static String VOZACI_FAJL = "vozaci.txt";
	private static String MUSTERIJE_FAJL = "musterije.txt";
	private static String AUTOMOBILI_FAJL = "automobili.txt";
	private static String VOZNJE_FAJL = "voznje.txt";

	public static void main(String[] args) {
		
		TaksiSluzba taksiSluzba = new TaksiSluzba();
		
		taksiSluzba.ucitajDispecere(DISPECERI_FAJL);
		taksiSluzba.ucitajVozace(VOZACI_FAJL);
		taksiSluzba.ucitajMusterije(MUSTERIJE_FAJL);
		taksiSluzba.ucitajAutomobile(AUTOMOBILI_FAJL);
		taksiSluzba.ucitajVoznje(VOZNJE_FAJL);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA: ");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(taksiSluzba);
		System.out.println("----------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Dispecer testDispecer = new Dispecer("002", "TestDispecer", "testDispecer", "testDispecer", "testDispecer", "testDispecer", "testDispecer", Pol.muski, "0638293614", false, 50000.50 , 1, OdeljenjeDispecer.odeljenjeZaPrijemReklamacije);
		taksiSluzba.dodajDispecera(testDispecer);
		
		Musterija testMusterija = new Musterija("001", "TestMusterija", "testMusterija", "testMusterija", "testMusterija", "testMusterija", "testMusterija", Pol.zenski, "0639817921", false);
		taksiSluzba.dodajMusteriju(testMusterija);
		
		Automobil testAutomobil = new Automobil("001", Model.A8, Proizvodjac.AlfaRomeo, VrstaAutomobila.putnickiAutomobil, 2010, "NS-100-DJ", 12, false);
		taksiSluzba.dodajAutomobil(testAutomobil);
		
		Vozac testVozac = new Vozac("003", "TestVozac", "testVozac", "testVozac", "testVozac", "testVozac", "testVozac", Pol.muski, "0638924371", false, 60000.60, 10, testAutomobil);
		taksiSluzba.dodajVozaca(testVozac);
		
		Voznja testVoznja = new Voznja("001", "30.04.2021.", "polazak", "destinacija", testMusterija, testVozac, 40.0, "25min", StatusVoznje.KREIRANA, false);
		taksiSluzba.dodajVoznju(testVoznja);
		
		System.out.println("Snimanje dodanih podataka...");
		taksiSluzba.snimiDispecera(DISPECERI_FAJL);
		taksiSluzba.snimiMusteriju(MUSTERIJE_FAJL);
		taksiSluzba.snimiAutomobil(AUTOMOBILI_FAJL);
		taksiSluzba.snimiVozaca(VOZACI_FAJL);
		taksiSluzba.snimiVoznju(VOZNJE_FAJL);
		
		

	}
	
	public static void ispisiSvePodatke(TaksiSluzba taksiSluzba) {
		
		for (Dispecer dispecer: taksiSluzba.getDispeceri()) {
			System.out.println(dispecer + "\n");
		}
		
		for (Vozac vozac : taksiSluzba.getVozaci()) {
			System.out.println(vozac + "\n");
		}
		
		for (Musterija musterija : taksiSluzba.getMusterije()) {
			System.out.println(musterija + "\n");
		}
		
		for (Automobil automobil : taksiSluzba.getAutomobili()) {
			System.out.println(automobil + "\n");
		}
		
		for (Voznja voznja : taksiSluzba.getVoznje()) {
			System.out.println(voznja + "\n");
		}
		
	}

}
