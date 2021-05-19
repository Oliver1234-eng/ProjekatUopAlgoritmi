package main;

import automobil.Automobil;
import automobil.Model;
import automobil.Proizvodjac;
import automobil.VrstaAutomobila;
import gui.LoginProzorDispecer;
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
		
		LoginProzorDispecer loginProzorDispecer = new LoginProzorDispecer(taksiSluzba);
		loginProzorDispecer.setVisible(true);
		
//		System.out.println("PODACI UCITANI IZ DATOTEKA: ");
//		System.out.println("----------------------------------------------");
//		ispisiSvePodatke(taksiSluzba);
//		System.out.println("----------------------------------------------");
		
//		System.out.println("Dodavanje test podataka...");
//		Dispecer testDispecer = new Dispecer("001", "TestDispecer", "testDispecer123", "ImeDispecer", "PrezimeDispecer", "JMBGDispecer", "AdresaDispecer", Pol.muski, "0638293614", false, 50000.50 , 1, OdeljenjeDispecer.odeljenjeZaPrijemReklamacije);
//		taksiSluzba.dodajDispecera(testDispecer);
//		
//		Musterija testMusterija = new Musterija("001", "TestMusterija", "testMusterija123", "ImeMusterija", "PrezimeMusterija", "JMBGMusterija", "AdresaMusterija", Pol.zenski, "0639817921", false);
//		taksiSluzba.dodajMusteriju(testMusterija);
//		
//		Automobil testAutomobil = new Automobil("001", Model.A8, Proizvodjac.AlfaRomeo, VrstaAutomobila.putnickiAutomobil, 2010, "NS-153-HE", 1, false);
//		taksiSluzba.dodajAutomobil(testAutomobil);
//		
//		Vozac testVozac = new Vozac("001", "TestVozac", "testVozac123", "ImeVozac", "PrezimeVozac", "JMBGVozac", "AdresaVozac", Pol.muski, "0638924371", false, 60000.60, 10, testAutomobil);
//		taksiSluzba.dodajVozaca(testVozac);
//		
//		Voznja testVoznja = new Voznja("001", "30.04.2021.", "Adresapolazak", "Adresadestinacija", testMusterija, testVozac, 40.0, "25min", StatusVoznje.KREIRANA, false);
//		taksiSluzba.dodajVoznju(testVoznja);
//
		
//		Dispecer testDispecer2 = new Dispecer("002", "TestDispecer2", "testDispecer1234", "ImeDispecer2", "PrezimeDispecer2", "JMBGDispecer2", "AdresaDispecer2", Pol.muski, "0638293614", false, 55000.50 , 2, OdeljenjeDispecer.odeljenjeZaPrijemVoznji);
//		taksiSluzba.dodajDispecera(testDispecer2);
//		
//		Musterija testMusterija2 = new Musterija("002", "TestMusterija2", "testMusterija1234", "ImeMusterija2", "PrezimeMusterija2", "JMBGMusterija2", "AdresaMusterija2", Pol.zenski, "0639817921", false);
//		taksiSluzba.dodajMusteriju(testMusterija2);
//		
//		Automobil testAutomobil2 = new Automobil("002", Model.Clio, Proizvodjac.Renault, VrstaAutomobila.putnickiAutomobil, 2012, "NS-321-IA", 2, false);
//		taksiSluzba.dodajAutomobil(testAutomobil2);
//		
//		Vozac testVozac2 = new Vozac("002", "TestVozac2", "testVozac1234", "ImeVozac2", "PrezimeVozac2", "JMBGVozac2", "AdresaVozac2", Pol.muski, "0638924371", false, 55000.60, 10, testAutomobil2);
//		taksiSluzba.dodajVozaca(testVozac2);
//		
//		Voznja testVoznja2 = new Voznja("002", "01.05.2021.", "Adresapolazak2", "Adresadestinacija2", testMusterija2, testVozac2, 25.0, "20min", StatusVoznje.KREIRANA, false);
//		taksiSluzba.dodajVoznju(testVoznja2);
		
//		Dispecer testDispecer3 = new Dispecer("003", "TestDispecer3", "testDispecer12345", "ImeDispecer3", "PrezimeDispecer3", "JMBGDispecer3", "AdresaDispecer3", Pol.muski, "0638293614", false, 56000.50 , 3, OdeljenjeDispecer.odeljenjeZaPrijemVoznji);
//		taksiSluzba.dodajDispecera(testDispecer3);
//		
//		Musterija testMusterija3 = new Musterija("003", "TestMusterija3", "testMusterija12345", "ImeMusterija3", "PrezimeMusterija3", "JMBGMusterija3", "AdresaMusterija3", Pol.zenski, "0639817921", false);
//		taksiSluzba.dodajMusteriju(testMusterija3);
//		
//		Automobil testAutomobil3 = new Automobil("003", Model.Corsa, Proizvodjac.Opel, VrstaAutomobila.kombiVozilo, 2020, "NS-251-JS", 3, false);
//		taksiSluzba.dodajAutomobil(testAutomobil3);
//		
//		Vozac testVozac3 = new Vozac("003", "TestVozac3", "testVozac12345", "ImeVozac3", "PrezimeVozac3", "JMBGVozac3", "AdresaVozac3", Pol.muski, "0638924371", false, 58000.60, 12, testAutomobil3);
//		taksiSluzba.dodajVozaca(testVozac3);
//		
//		Voznja testVoznja3 = new Voznja("003", "02.05.2021.", "Adresapolazak3", "Adresadestinacija3", testMusterija3, testVozac3, 10.0, "5min", StatusVoznje.KREIRANA, false);
//		taksiSluzba.dodajVoznju(testVoznja3);
		
//		System.out.println("Snimanje dodanih podataka...");
//		taksiSluzba.snimiDispecera(DISPECERI_FAJL);
//		taksiSluzba.snimiMusteriju(MUSTERIJE_FAJL);
//		taksiSluzba.snimiAutomobil(AUTOMOBILI_FAJL);
//		taksiSluzba.snimiVozaca(VOZACI_FAJL);
//		taksiSluzba.snimiVoznju(VOZNJE_FAJL);
//	
//	}
	
//	public static void ispisiSvePodatke(TaksiSluzba taksiSluzba) {
//		
//		for (Dispecer dispecer: taksiSluzba.getDispeceri()) {
//			System.out.println(dispecer + "\n");
//		}
//		
//		for (Vozac vozac : taksiSluzba.getVozaci()) {
//			System.out.println(vozac + "\n");
//		}
//		
//		for (Musterija musterija : taksiSluzba.getMusterije()) {
//			System.out.println(musterija + "\n");
//		}
//		
//		for (Automobil automobil : taksiSluzba.getAutomobili()) {
//			System.out.println(automobil + "\n");
//		}
//		
//		for (Voznja voznja : taksiSluzba.getVoznje()) {
//			System.out.println(voznja + "\n");
//		}
//		
//	}

}}
