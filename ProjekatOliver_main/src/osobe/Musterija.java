package osobe;

public class Musterija extends Korisnik {
	
	public Musterija() {
		super();
		
	}

	public Musterija(String redniBrojKorisnika, String korisnickoIme, String lozinka, String ime, String prezime, String JMBG,
			String adresa, Pol pol, String brojTelefona, boolean obrisan) {
		super(redniBrojKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, obrisan);
		
	}

	@Override
	public String toString() {
		return "Musterija [RedniBrojKorisnika=" + redniBrojKorisnika + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka
				+ ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}

}
