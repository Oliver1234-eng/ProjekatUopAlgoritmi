package osobePaket;

public class Dispecer extends Korisnik {
	
	private double plata;
	private int brojTelefonskeLinije;
	private OdeljenjeDispecer odeljenjeDispecer;
	
	public Dispecer(int idKorisnika, String korisnickoIme, String lozinka, String ime, String prezime, String jMBG,
			String adresa, Pol pol, String brojTelefona, boolean obrisan, double plata, int brojTelefonskeLinije,
			OdeljenjeDispecer odeljenjeDispecer) {
		super(idKorisnika, korisnickoIme, lozinka, ime, prezime, jMBG, adresa, pol, brojTelefona, obrisan);
		this.plata = plata;
		this.brojTelefonskeLinije = brojTelefonskeLinije;
		this.odeljenjeDispecer = odeljenjeDispecer;
	}
	
	public Dispecer() {
		super();
		this.plata = 0;
		this.brojTelefonskeLinije = 0;
		this.odeljenjeDispecer = OdeljenjeDispecer.odeljenjeZaPrijemReklamacije;
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

	public OdeljenjeDispecer getOdeljenjeDispecer() {
		return odeljenjeDispecer;
	}

	public void setOdeljenjeDispecer(OdeljenjeDispecer odeljenjeDispecer) {
		this.odeljenjeDispecer = odeljenjeDispecer;
	}

	@Override
	public String toString() {
		return "Dispecer [plata=" + plata + ", brojTelefonskeLinije=" + brojTelefonskeLinije + ", odeljenjeDispecer="
				+ odeljenjeDispecer + ", idKorisnika=" + idKorisnika + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol="
				+ pol + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}
	
	
	
	

}
