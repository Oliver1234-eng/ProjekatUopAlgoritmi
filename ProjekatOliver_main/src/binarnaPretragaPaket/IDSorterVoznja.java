package binarnaPretragaPaket;

import java.util.Comparator;

import voznjaPaket.Voznja;

public class IDSorterVoznja implements Comparator<Voznja> {
	
	public int compare(Voznja v1, Voznja v2) {
		return v1.getIdVoznje() - v2.getIdVoznje();
	}

}
