package osobe;

public class Dispecer extends Korisnik {
	
	private double plata;
	private int brojTelefonskeLinije;
	private OdeljenjeDispecer odeljenje;
	
	public Dispecer(int idKorisnika, String korisnickoIme, String lozinka, String ime, String prezime, String JMBG,
			String adresa, Pol pol, String brojTelefona, boolean obrisan, double plata, int brojTelefonskeLinije,
			OdeljenjeDispecer odeljenje) {
		super(idKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, obrisan);
		this.plata = plata;
		this.brojTelefonskeLinije = brojTelefonskeLinije;
		this.odeljenje = odeljenje;
	}
	
	public Dispecer() {
		super();
		this.plata = 0;
		this.brojTelefonskeLinije = 0;
		this.odeljenje = OdeljenjeDispecer.odeljenjeZaPrijemReklamacije;
	}
	
	public double getPlata() {
		return plata;
	}
	
	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public int getBrojTelefonskeLinije() {
		return brojTelefonskeLinije;
	}
	
	public void setBrojTelefonskeLinije(int brojTelefonskeLinije) {
		this.brojTelefonskeLinije = brojTelefonskeLinije;
	}
	
	public OdeljenjeDispecer getOdeljenje() {
		return odeljenje;
	}
	
	public void setOdeljenje(OdeljenjeDispecer odeljenje) {
		this.odeljenje = odeljenje;
	}

	@Override
	public String toString() {
		return "DISPECER \nID korisnika: " + idKorisnika +
				"\nKorisnicko ime " + korisnickoIme +
				"\nLozinka" + lozinka +
				"\nIme " + ime + 
				"\nPrezime: " + prezime +
				"\nJMBG: " + JMBG +
				"\nAdresa: " + adresa +
				"\nPol: " + pol +
				"\nBroj telefona: " + brojTelefona +
				"\nPlata: " + plata +
				"\nBroj telefonske linije: " + brojTelefonskeLinije +
				"\nOdeljenje: " + odeljenje +
				"\nObrisan: " + obrisan;
	}
	

}
