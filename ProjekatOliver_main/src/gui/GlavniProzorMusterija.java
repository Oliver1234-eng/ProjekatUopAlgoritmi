package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.NarucivanjeVoznjeProzorMusterija;
import gui.formeZaPrikaz.VozaciProzorDispecer;
import osobe.Dispecer;
import osobe.Musterija;
import taksiSluzba.TaksiSluzba;

public class GlavniProzorMusterija extends JFrame {
	
	private JMenuBar glavniMeniMusterija = new JMenuBar();
	private JMenu narucivanjeVoznje = new JMenu("Naruci voznju");
	private JMenuItem naruciVoznju = new JMenuItem("Narucivanje voznje");

	
	private TaksiSluzba taksiSluzba;
	private Musterija prijavljeni;
	
	public GlavniProzorMusterija(TaksiSluzba taksiSluzba, Musterija prijavljeni) {
		this.taksiSluzba = taksiSluzba;
		this.prijavljeni = prijavljeni;
		setTitle("Musterija: " + prijavljeni.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenuDispecer();
		initActions();
	}
	
	public void initMenuDispecer() {
		setJMenuBar(glavniMeniMusterija);
		glavniMeniMusterija.add(narucivanjeVoznje);
		narucivanjeVoznje.add(naruciVoznju);

	}
	
	public void initActions() {
		
		naruciVoznju.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				NarucivanjeVoznjeProzorMusterija narucivanjeVoznjeProzorMusterija = new NarucivanjeVoznjeProzorMusterija(taksiSluzba);
				narucivanjeVoznjeProzorMusterija.setVisible(true);
			}
		});
		
	}

}