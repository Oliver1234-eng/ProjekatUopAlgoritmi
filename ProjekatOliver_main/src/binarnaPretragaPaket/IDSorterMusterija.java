package binarnaPretragaPaket;

import java.util.Comparator;

import osobePaket.Musterija;

public class IDSorterMusterija implements Comparator<Musterija> {
	
	public int compare(Musterija m1, Musterija m2) {
		return m1.getIdKorisnika() - m2.getIdKorisnika();
	}

}
