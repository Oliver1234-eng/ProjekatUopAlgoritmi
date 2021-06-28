package voznjaPaket;

import java.util.Date;

import osobe.Musterija;
import osobe.Vozac;

public class Voznja {
	
	private int idVoznje;
	private Date datumIVremePorudzbine;
	private String adresaPolaska;
	private String adresaDestinacije;
	private Musterija imeMusterije;
	private Vozac imeVozaca;
	private double brojPredjenihKilometara;
	private String trajanjeVoznje;
	private StatusVoznje statusVoznje;
	private boolean obrisan;
	
	public Voznja(int idVoznje, Date datumIVremePorudzbine, String adresaPolaska, String adresaDestinacije,
			Musterija imeMusterije, Vozac imeVozaca, double brojPredjenihKilometara, String trajanjeVoznje,
			StatusVoznje statusVoznje, boolean obrisan) {
		super();
		this.idVoznje = idVoznje;
		this.datumIVremePorudzbine = datumIVremePorudzbine;
		this.adresaPolaska = adresaPolaska;
		this.adresaDestinacije = adresaDestinacije;
		this.imeMusterije = imeMusterije;
		this.imeVozaca = imeVozaca;
		this.brojPredjenihKilometara = brojPredjenihKilometara;
		this.trajanjeVoznje = trajanjeVoznje;
		this.statusVoznje = statusVoznje;
		this.obrisan = obrisan;
	}
	
	public Voznja() {
		super();
		this.idVoznje = 0;
		this.datumIVremePorudzbine = new Date();
		this.adresaPolaska = "";
		this.adresaDestinacije = "";
		this.imeMusterije = new Musterija();
		this.imeVozaca = new Vozac();
		this.brojPredjenihKilometara = 0;
		this.trajanjeVoznje = "";
		this.statusVoznje = StatusVoznje.KREIRANA;
		this.obrisan = false;
	}

	public int getIdVoznje() {
		return idVoznje;
	}

	public void setIdVoznje(int idVoznje) {
		this.idVoznje = idVoznje;
	}

	public Date getDatumIVremePorudzbine() {
		return datumIVremePorudzbine;
	}

	public void setDatumIVremePorudzbine(Date datumIVremePorudzbine) {
		this.datumIVremePorudzbine = datumIVremePorudzbine;
	}

	public String getAdresaPolaska() {
		return adresaPolaska;
	}

	public void setAdresaPolaska(String adresaPolaska) {
		this.adresaPolaska = adresaPolaska;
	}

	public String getAdresaDestinacije() {
		return adresaDestinacije;
	}

	public void setAdresaDestinacije(String adresaDestinacije) {
		this.adresaDestinacije = adresaDestinacije;
	}

	public Musterija getImeMusterije() {
		return imeMusterije;
	}

	public void setImeMusterije(Musterija imeMusterije) {
		this.imeMusterije = imeMusterije;
	}

	public Vozac getImeVozaca() {
		return imeVozaca;
	}

	public void setImeVozaca(Vozac imeVozaca) {
		this.imeVozaca = imeVozaca;
	}

	public double getBrojPredjenihKilometara() {
		return brojPredjenihKilometara;
	}

	public void setBrojPredjenihKilometara(double brojPredjenihKilometara) {
		this.brojPredjenihKilometara = brojPredjenihKilometara;
	}

	public String getTrajanjeVoznje() {
		return trajanjeVoznje;
	}

	public void setTrajanjeVoznje(String trajanjeVoznje) {
		this.trajanjeVoznje = trajanjeVoznje;
	}

	public StatusVoznje getStatusVoznje() {
		return statusVoznje;
	}

	public void setStatusVoznje(StatusVoznje statusVoznje) {
		this.statusVoznje = statusVoznje;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Voznja [idVoznje=" + idVoznje + ", datumIVremePorudzbine=" + datumIVremePorudzbine + ", adresaPolaska="
				+ adresaPolaska + ", adresaDestinacije=" + adresaDestinacije + ", imeMusterije=" + imeMusterije
				+ ", imeVozaca=" + imeVozaca + ", brojPredjenihKilometara=" + brojPredjenihKilometara
				+ ", trajanjeVoznje=" + trajanjeVoznje + ", statusVoznje=" + statusVoznje + ", obrisan=" + obrisan
				+ "]";
	}
	
	
	
	
}
