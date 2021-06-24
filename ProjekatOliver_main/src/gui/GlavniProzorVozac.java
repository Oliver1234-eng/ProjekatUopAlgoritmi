package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.PrihvatanjeOdbijanjeVoznjeUlogaVozac;
import gui.formeZaPrikaz.VozaciProzorDispecer;
import gui.formeZaPrikaz.ZavrsavanjeVoznjeUlogaVozac;
import osobe.Dispecer;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;

public class GlavniProzorVozac extends JFrame {
	
	private JMenuBar glavniMeniVozac = new JMenuBar();
	private JMenu prihvatanjeIliOdbijanjeVoznje = new JMenu("Prihvati voznju");
	private JMenuItem prihvatiVoznju = new JMenuItem("Prihvatanje voznje");
	private JMenu zavrsavanjeVoznje = new JMenu("Zavrsi voznju");
	private JMenuItem zavrsiVoznju = new JMenuItem("Zavrsavanje voznje");
	
	private TaksiSluzba taksiSluzba;
	private Vozac prijavljeni;
	
	public GlavniProzorVozac(TaksiSluzba taksiSluzba, Vozac prijavljeni) {
		this.taksiSluzba = taksiSluzba;
		this.prijavljeni = prijavljeni;
		setTitle("Vozac: " + prijavljeni.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenuVozac();
		initActions();
	}
	
	public void initMenuVozac() {
		setJMenuBar(glavniMeniVozac);
		glavniMeniVozac.add(prihvatanjeIliOdbijanjeVoznje);
		prihvatanjeIliOdbijanjeVoznje.add(prihvatiVoznju);
		glavniMeniVozac.add(zavrsavanjeVoznje);
		zavrsavanjeVoznje.add(zavrsiVoznju);

	}
	
	public void initActions() {
		
		prihvatiVoznju.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PrihvatanjeOdbijanjeVoznjeUlogaVozac prihvatanjeOdbijanjeVoznjeUlogaVozac = new PrihvatanjeOdbijanjeVoznjeUlogaVozac(taksiSluzba);
				prihvatanjeOdbijanjeVoznjeUlogaVozac.setVisible(true);
			}
		});
		
		zavrsiVoznju.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ZavrsavanjeVoznjeUlogaVozac zavrsavanjeVoznjeUlogaVozac = new ZavrsavanjeVoznjeUlogaVozac(taksiSluzba);
				zavrsavanjeVoznjeUlogaVozac.setVisible(true);
			}
		});
		
	}

}