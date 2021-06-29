package binarnaPretragaPaket;

import java.util.Comparator;

import osobePaket.Vozac;

public class IDSorterVozac implements Comparator<Vozac> {
	
	public int compare(Vozac v1, Vozac v2) {
		return v1.getIdKorisnika() - v2.getIdKorisnika();
	}

}
