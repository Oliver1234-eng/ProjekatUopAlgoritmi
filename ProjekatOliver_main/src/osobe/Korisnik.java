package osobe;

public abstract class Korisnik {
	
	protected int idKorisnika;
	protected String korisnickoIme;
	protected String lozinka;
	protected String ime;
	protected String prezime;
	protected String JMBG;
	protected String adresa;
	protected Pol pol;
	protected String brojTelefona;
	protected boolean obrisan;
	
	public Korisnik(int idKorisnika, String korisnickoIme, String lozinka, String ime, String prezime, String JMBG,
			String adresa, Pol pol, String brojTelefona, boolean obrisan) {
		super();
		this.idKorisnika = idKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = JMBG;
		this.adresa = adresa;
		this.pol = pol;
		this.brojTelefona = brojTelefona;
		this.obrisan = obrisan;
	}
	
	public Korisnik() {
		super();
		this.idKorisnika = 0;
		this.korisnickoIme = "";
		this.lozinka = "";
		this.ime = "";
		this.prezime = "";
		this.JMBG = "";
		this.adresa = "";
		this.pol = Pol.zenski;
		this.brojTelefona = "";
		this.obrisan = false;
	}

	public int getIdKorisnika() {
		return idKorisnika;
	}
	
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getJMBG() {
		return JMBG;
	}
	
	public void setJMBG(String JMBG) {
		this.JMBG = JMBG;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public Pol getPol() {
		return pol;
	}
	
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	public String getBrojTelefona() {
		return brojTelefona;
	}
	
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}
	
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Korisnik \nID korisnika: " + idKorisnika +
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
