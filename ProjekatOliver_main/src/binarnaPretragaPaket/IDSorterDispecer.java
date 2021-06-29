package binarnaPretragaPaket;

import java.util.Comparator;

import osobePaket.Dispecer;

public class IDSorterDispecer implements Comparator<Dispecer> {
	
	public int compare(Dispecer d1, Dispecer d2) {
		return d1.getIdKorisnika() - d2.getIdKorisnika();
	}

}
