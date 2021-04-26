package osobe;

public class Musterija extends Korisnik {
	
	@Override
	public String toString() {
		return "Musterija \nID korisnika: " + idKorisnika +
				"\nKorisnicko ime " + korisnickoIme +
				"\nLozinka" + lozinka +
				"\nIme " + ime + 
				"\nPrezime: " + prezime +
				"\nJMBG: " + JMBG +
				"\nAdresa: " + adresa +
				"\nPol: " + pol +
				"\nBroj telefona: " + brojTelefona +
				"\nObrisan: " + obrisan;
	}

}
