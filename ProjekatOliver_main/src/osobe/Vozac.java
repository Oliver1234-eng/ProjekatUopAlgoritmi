package osobe;

import automobil.Automobil;

public class Vozac extends Korisnik {
	
	private double plata;
	private int brojClanskeKarte;
	private Automobil automobil;
	
	public Vozac(String redniBrojKorisnika, String korisnickoIme, String lozinka, String ime, String prezime, String JMBG,
			String adresa, Pol pol, String brojTelefona, boolean obrisan, double plata, int brojClanskeKarte,
			Automobil automobil) {
		super(redniBrojKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, obrisan);
		this.plata = plata;
		this.brojClanskeKarte = brojClanskeKarte;
		this.automobil = automobil;
	}
	
	public Vozac() {
		super();
		this.plata = 0;
		this.brojClanskeKarte = 0;
		this.automobil = new Automobil();
	}

	public double getPlata() {
		return plata;
	}
	
	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public int getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	
	public void setBrojClanskeKarte(int brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	
	public Automobil getAutomobil() {
		return automobil;
	}
	
	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

	@Override
	public String toString() {
		return "Vozac [plata=" + plata + ", brojClanskeKarte=" + brojClanskeKarte + ", automobil=" + automobil
				+ ", RedniBrojKorisnika=" + redniBrojKorisnika + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka
				+ ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}

}
