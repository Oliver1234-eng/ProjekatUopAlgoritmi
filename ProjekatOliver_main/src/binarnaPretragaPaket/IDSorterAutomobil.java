package binarnaPretragaPaket;

import java.util.Comparator;

import automobilPaket.Automobil;

public class IDSorterAutomobil implements Comparator<Automobil> {
	
	public int compare(Automobil a1, Automobil a2) {
		return a1.getIdAutomobila() - a2.getIdAutomobila();
	}

}
