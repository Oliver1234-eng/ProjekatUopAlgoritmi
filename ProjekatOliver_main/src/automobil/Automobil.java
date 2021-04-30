package automobil;

public class Automobil {
	
	private String idAutomobila;
	private Model model;
	private Proizvodjac proizvodjac;
	private VrstaAutomobila vrstaAutomobila;
	private int godinaProizvodnje;
	private String brojRegistarskeOznake;
	private int brojTaksiVozila;
	private boolean obrisan;
	
	public Automobil(String idAutomobila, Model model, Proizvodjac proizvodjac, VrstaAutomobila vrstaAutomobila,
			int godinaProizvodnje, String brojRegistarskeOznake, int brojTaksiVozila, boolean obrisan) {
		super();
		this.idAutomobila = idAutomobila;
		this.model = model;
		this.proizvodjac = proizvodjac;
		this.vrstaAutomobila = vrstaAutomobila;
		this.godinaProizvodnje = godinaProizvodnje;
		this.brojRegistarskeOznake = brojRegistarskeOznake;
		this.brojTaksiVozila = brojTaksiVozila;
		this.obrisan = obrisan;
	}
	
	public Automobil() {
		super();
		this.idAutomobila = "";
		this.model = Model.Corsa;
		this.proizvodjac = Proizvodjac.Opel;
		this.vrstaAutomobila = VrstaAutomobila.putnickiAutomobil;
		this.godinaProizvodnje = 0;
		this.brojRegistarskeOznake = "";
		this.brojTaksiVozila = 0;
		this.obrisan = false;
	}

	public String getIdAutomobila() {
		return idAutomobila;
	}
	
	public void setIdAutomobila(String idAutomobila) {
		this.idAutomobila = idAutomobila;
	}
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}
	
	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	public VrstaAutomobila getVrstaAutomobila() {
		return vrstaAutomobila;
	}
	
	public void setVrstaAutomobila(VrstaAutomobila vrstaAutomobila) {
		this.vrstaAutomobila = vrstaAutomobila;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public String getBrojRegistarskeOznake() {
		return brojRegistarskeOznake;
	}
	
	public void setBrojRegistarskeOznake(String brojRegistarskeOznake) {
		this.brojRegistarskeOznake = brojRegistarskeOznake;
	}
	
	public int getBrojTaksiVozila() {
		return brojTaksiVozila;
	}
	
	public void setBrojTaksiVozila(int brojTaksiVozila) {
		this.brojTaksiVozila = brojTaksiVozila;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}
	
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Automobil [idAutomobila=" + idAutomobila + ", model=" + model + ", proizvodjac=" + proizvodjac
				+ ", vrstaAutomobila=" + vrstaAutomobila + ", godinaProizvodnje=" + godinaProizvodnje
				+ ", brojRegistarskeOznake=" + brojRegistarskeOznake + ", brojTaksiVozila=" + brojTaksiVozila
				+ ", obrisan=" + obrisan + "]";
	}

}
