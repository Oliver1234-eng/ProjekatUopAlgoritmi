package osobePaket;

public class Musterija extends Korisnik {
	
	public Musterija(int idKorisnika, String korisnickoIme, String lozinka, String ime, String prezime, String jMBG,
			String adresa, Pol pol, String brojTelefona, boolean obrisan) {
		super(idKorisnika, korisnickoIme, lozinka, ime, prezime, jMBG, adresa, pol, brojTelefona, obrisan);
	}

	public Musterija() {
		super();
		
	}

	@Override
	public String toString() {
		return "Musterija [idKorisnika=" + idKorisnika + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka
				+ ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}
	
}
