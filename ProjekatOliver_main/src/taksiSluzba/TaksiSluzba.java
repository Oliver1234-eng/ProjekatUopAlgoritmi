package taksiSluzba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import automobil.Automobil;
import automobil.Model;
import automobil.Proizvodjac;
import automobil.VrstaAutomobila;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.OdeljenjeDispecer;
import osobe.Pol;
import osobe.Vozac;
import voznja.StatusVoznje;
import voznja.Voznja;

public class TaksiSluzba {
	
	private ArrayList<Dispecer> dispeceri;
	private ArrayList<Automobil> automobili;
	private ArrayList<Vozac> vozaci;
	private ArrayList<Musterija> musterije;
	private ArrayList<Voznja> voznje;
	
	
	public TaksiSluzba() {
		this.dispeceri = new ArrayList<Dispecer>();
		this.automobili = new ArrayList<Automobil>();
		this.vozaci = new ArrayList<Vozac>();
		this.musterije = new ArrayList<Musterija>();
		this.voznje = new ArrayList<Voznja>();
	}
	
	public ArrayList<Dispecer> getDispeceri() {
		return dispeceri;
	}
	
	public void dodajDispecera(Dispecer dispecer) {
		this.dispeceri.add(dispecer);
	}
	
	public void obrisiDispecera(Dispecer dispecer) {
		this.dispeceri.remove(dispecer);
	}
	
	public ArrayList<Automobil> getAutomobili() {
		return automobili;
	}
	
	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}
	
	public void obrisiAutomobil(Automobil automobil) {
		this.automobili.remove(automobil);
	}
	
	public ArrayList<Vozac> getVozaci() {
		return vozaci;
	}
	
	public void dodajVozaca(Vozac vozac) {
		this.vozaci.add(vozac);
	}
	
	public void obrisiVozaca(Vozac vozac) {
		this.vozaci.remove(vozac);
	}
	
	public ArrayList<Musterija> getMusterije() {
		return musterije;
	}
	
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}
	
	public void obrisiMusteriju(Musterija musterija) {
		this.musterije.remove(musterija);
	}
	
	public ArrayList<Voznja> getVoznje() {
		return voznje;
	}
	
	public void dodajVoznju(Voznja voznja) {
		this.voznje.add(voznja);
	}
	
	public void obrisiVoznju(Voznja voznja) {
		this.voznje.remove(voznja);
	}
	
	public Dispecer getDispecerPoKorisnickomImenu(String korisnickoIme) {
		ArrayList<Dispecer> dispeceri = getDispeceri();
		for (Dispecer dispecer : dispeceri) {
			if (korisnickoIme.equals(dispecer.getKorisnickoIme())) {
				return dispecer;
			}
		}
		
		return null;
	}
	
	public Automobil getAutomobilPoID(String id) {
		ArrayList<Automobil> automobili = getAutomobili();
		for (Automobil automobil : automobili) {
			if (id.equals(automobil.getIdAutomobila())) {
				return automobil;
			}
		}
		
		return null;
	}
	
	public Vozac getVozacPoKorisnickomImenu(String korisnickoIme) {
		ArrayList<Vozac> vozaci = getVozaci();
		for (Vozac vozac : vozaci) {
			if (korisnickoIme.equals(vozac.getKorisnickoIme())) {
				return vozac;
			}
		}
		
		return null;
	}
	
	public Musterija getMusterijaPoKorisnickomImenu(String korisnickoIme) {
		ArrayList<Musterija> musterije = getMusterije();
		for (Musterija musterija : musterije) {
			if (korisnickoIme.equals(musterija.getKorisnickoIme())) {
				return musterija;
			}
		}
		
		return null;
	}
	
	public Voznja getVoznjePoID(String id) {
		ArrayList<Voznja> voznje = getVoznje();
		for (Voznja voznja : voznje) {
			if (id.equals(voznja.getIdVoznje())) {
				return voznja;
			}
		}
		
		return null;
	}
	
	public Dispecer loginDispecer(String korisnickoIme, String lozinka) {
		for (Dispecer dispecer : dispeceri) {
			if (dispecer.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
					dispecer.getLozinka().equalsIgnoreCase(lozinka) && !dispecer.isObrisan()) {
				
				return dispecer;
			}
		}
		return null;
	}
	
	public Vozac loginVozac(String korisnickoIme, String lozinka) {
		for (Vozac vozac : vozaci) {
			if (vozac.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
					vozac.getLozinka().equalsIgnoreCase(lozinka) && !vozac.isObrisan()) {
				
				return vozac;
			}
		}
		return null;
	}
	
	public Musterija loginMusterija(String korisnickoIme, String lozinka) {
		for (Musterija musterija : musterije) {
			if (musterija.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
					musterija.getLozinka().equalsIgnoreCase(lozinka) && !musterija.isObrisan()) {
				
				return musterija;
			}
		}
		return null;
	}
	
	public ArrayList<Dispecer> sviNeobrisaniDispeceri() {
		ArrayList<Dispecer> neobrisaniDispeceri = new ArrayList<Dispecer>();
		for (Dispecer dispecer : dispeceri) {
			if (!dispecer.isObrisan()) {
				neobrisaniDispeceri.add(dispecer);
			}
		}
		return neobrisaniDispeceri;
	}
	
	public ArrayList<Automobil> sviNeobrisaniAutomobili() {
		ArrayList<Automobil> neobrisaniAutomobili = new ArrayList<Automobil>();
		for (Automobil automobil : automobili) {
			if (!automobil.isObrisan()) {
				neobrisaniAutomobili.add(automobil);
			}
		}
		return neobrisaniAutomobili;
	}
	
	public ArrayList<Vozac> sviNeobrisaniVozaci() {
		ArrayList<Vozac> neobrisaniVozaci = new ArrayList<Vozac>();
		for (Vozac vozac : vozaci) {
			if (!vozac.isObrisan()) {
				neobrisaniVozaci.add(vozac);
			}
		}
		return neobrisaniVozaci;
	}
	
	public ArrayList<Musterija> sveNeobrisaneMusterije() {
		ArrayList<Musterija> neobrisaneMusterije = new ArrayList<Musterija>();
		for (Musterija musterija : musterije) {
			if (!musterija.isObrisan()) {
				neobrisaneMusterije.add(musterija);
			}
		}
		return neobrisaneMusterije;
	} 
	
	public ArrayList<Voznja> sveNeobrisaneVoznje() {
		ArrayList<Voznja> neobrisaneVoznje = new ArrayList<Voznja>();
		for (Voznja voznja : voznje) {
			if (!voznja.isObrisan()) {
				neobrisaneVoznje.add(voznja);
			}
		}
		return neobrisaneVoznje;
	}
	
	public void ucitajDispecere(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String redniBrojKorisnika = split[0];
				String korisnickoIme = split[1];
				String lozinka = split[2];
				String ime = split[3];
				String prezime = split[4];
				String JMBG = split[5];
				String adresa = split[6];
				int polInt = Integer.parseInt(split[7]);
				Pol pol = Pol.values()[polInt];
				String brojTelefona = split[8];
				boolean obrisan = Boolean.parseBoolean(split[9]);
				String plataString = split[10];
				double plata = Double.parseDouble(plataString);
				String brojTelefonskeLinijeString = split[11];
				int brojTelefonskeLinije = Integer.parseInt(brojTelefonskeLinijeString);
				int odeljenjeDispecerInt = Integer.parseInt(split[12]);
				OdeljenjeDispecer odeljenjeDispecer = OdeljenjeDispecer.values()[odeljenjeDispecerInt];
				Dispecer dispecer = new Dispecer(redniBrojKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, obrisan, plata, brojTelefonskeLinije, odeljenjeDispecer);
				dispeceri.add(dispecer);
			}	
			
			reader.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ucitajAutomobile(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String idAutomobila = split[0];
				int modelInt = Integer.parseInt(split[1]);
				Model model = Model.values()[modelInt];
				int proizvodjacInt = Integer.parseInt(split[2]);
				Proizvodjac proizvodjac = Proizvodjac.values()[proizvodjacInt];
				int vrstaAutomobilaInt = Integer.parseInt(split[3]);
				VrstaAutomobila vrstaAutomobila = VrstaAutomobila.values()[vrstaAutomobilaInt];
				String godinaProizvodnjeString = split[4];
				int godinaProizvodnje = Integer.parseInt(godinaProizvodnjeString);
				String brojRegistarskeOznake = split[5];
				String brojTaksiVozilaString = split[6];
				int brojTaksiVozila = Integer.parseInt(brojTaksiVozilaString);
				boolean obrisan = Boolean.parseBoolean(split[7]);
				Automobil automobil = new Automobil(idAutomobila, model, proizvodjac, vrstaAutomobila, godinaProizvodnje, brojRegistarskeOznake, brojTaksiVozila, obrisan);
				automobili.add(automobil);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ucitajVozace(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String redniBrojKorisnika = split[0];
				String korisnickoIme = split[1];
				String lozinka = split[2];
				String ime = split[3];
				String prezime = split[4];
				String JMBG = split[5];
				String adresa = split[6];
				int polInt = Integer.parseInt(split[7]);
				Pol pol = Pol.values()[polInt];
				String brojTelefona = split[8];
				boolean obrisan = Boolean.parseBoolean(split[9]);
				String plataString = split[10];
				double plata = Double.parseDouble(plataString);
				String brojClanskeKarteString = split[11];
				int brojClanskeKarte = Integer.parseInt(brojClanskeKarteString);
				String idAutomobila = split[12];
				Automobil automobil = getAutomobilPoID(idAutomobila);
				Vozac vozac = new Vozac(redniBrojKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, obrisan, plata, brojClanskeKarte, automobil);
				vozaci.add(vozac);
			}	
			
			reader.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ucitajMusterije(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String redniBrojKorisnika = split[0];
				String korisnickoIme = split[1];
				String lozinka = split[2];
				String ime = split[3];
				String prezime = split[4];
				String JMBG = split[5];
				String adresa = split[6];
				int polInt = Integer.parseInt(split[7]);
				Pol pol = Pol.values()[polInt];
				String brojTelefona = split[8];
				boolean obrisan = Boolean.parseBoolean(split[9]);
				Musterija musterija = new Musterija(redniBrojKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, obrisan);
				musterije.add(musterija);
			}	
			
			reader.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ucitajVoznje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String idVoznje = split[0];
				String datumIVremePorudzbine = split[1];
				String adresaPolaska = split[2];
				String adresaDestinacije = split[3];
				String imeMusterije = split[4];
				Musterija musterija = getMusterijaPoKorisnickomImenu(imeMusterije);
				String imeVozaca = split[5];
				Vozac vozac = getVozacPoKorisnickomImenu(imeVozaca);
				String brojPredjenihKilometaraString = split[6];
				double brojPredjenihKilometara = Double.parseDouble(brojPredjenihKilometaraString);
				String trajanjeVoznje = split[7];
				int statusVoznjeInt = Integer.parseInt(split[8]);
				StatusVoznje statusVoznje = StatusVoznje.values()[statusVoznjeInt];
				boolean obrisan = Boolean.parseBoolean(split[9]);
				Voznja voznja = new Voznja(idVoznje, datumIVremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojPredjenihKilometara, trajanjeVoznje, statusVoznje, obrisan);
				voznje.add(voznja);	
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void snimiDispecera(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Dispecer dispecer : dispeceri) {
				
				content += dispecer.getRedniBrojKorisnika() + "|" + dispecer.getKorisnickoIme() + "|"
						+ dispecer.getLozinka() + "|" + dispecer.getIme() + "|"
						+ dispecer.getPrezime() + "|" + dispecer.getJMBG() + "|" + dispecer.getAdresa() + "|"
						+ dispecer.getPol().ordinal() + "|" + dispecer.getBrojTelefona() + "|" + dispecer.isObrisan() + "|"
						+ dispecer.getPlata() + "|" + dispecer.getBrojTelefonskeLinije() + "|"
						+ dispecer.getOdeljenjeDispecer().ordinal() + "\n";
			}
			
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void snimiAutomobil(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Automobil automobil : automobili) {
				
				content += automobil.getIdAutomobila() + "|" + automobil.getModel().ordinal() + "|"
						+ automobil.getVrstaAutomobila().ordinal() + "|" + automobil.getProizvodjac().ordinal() + "|"
						+ automobil.getGodinaProizvodnje() + "|" + automobil.getBrojRegistarskeOznake() + "|" 
						+ automobil.getBrojTaksiVozila() + "|"+ automobil.isObrisan() + "\n";
			}
			
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void snimiVozaca(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Vozac vozac : vozaci) {
				
				content += vozac.getRedniBrojKorisnika() + "|" + vozac.getKorisnickoIme() + "|"
						+ vozac.getLozinka() + "|" + vozac.getIme() + "|"
						+ vozac.getPrezime() + "|" + vozac.getJMBG() + "|" + vozac.getAdresa() + "|"
						+ vozac.getPol().ordinal() + "|" + vozac.getBrojTelefona() + "|" + vozac.isObrisan() + "|"
						+ vozac.getPlata() + "|" + vozac.getBrojClanskeKarte() + "|"
						+ vozac.getAutomobil().getIdAutomobila() + "\n";
			}
			
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void snimiMusteriju(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Musterija musterija : musterije) {
				
				content += musterija.getRedniBrojKorisnika() + "|" + musterija.getKorisnickoIme() + "|"
						+ musterija.getLozinka() + "|" + musterija.getIme() + "|"
						+ musterija.getPrezime() + "|" + musterija.getJMBG() + "|" + musterija.getAdresa() + "|"
						+ musterija.getPol().ordinal() + "|" + musterija.getBrojTelefona() + "|"
						+ musterija.isObrisan() + "\n";
			}
			
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void snimiVoznju(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String content = "";
			for (Voznja voznja : voznje) {
				
				content += voznja.getIdVoznje() + "|" + voznja.getDatumIVremePorudzbine() + "|"
						+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|"
						+ voznja.getImeMusterije().getKorisnickoIme() + "|" + voznja.getImeVozaca().getKorisnickoIme() + "|" 
						+ voznja.getBrojPredjenihKilometara() + "|" + voznja.getTrajanjeVoznje() + "|"
						+ voznja.getStatusVoznje().ordinal() + "|"+ voznja.isObrisan() + "\n";
			}
			
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
}

