package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import osobe.Dispecer;
import osobe.Musterija;
import taksiSluzba.TaksiSluzba;

public class GlavniProzorMusterija extends JFrame {
	
	private JMenuBar glavniMeniMusterija = new JMenuBar();
	private JMenu proba = new JMenu("proba");
	private JMenuItem Proba = new JMenuItem("Proba");
	private JMenu test = new JMenu("test");
	private JMenuItem Test = new JMenuItem("Test");
//	private JMenu voznjeMeni = new JMenu("voznje");
//	private JMenuItem voznje = new JMenuItem("Voznje");
	
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
		glavniMeniMusterija.add(proba);
		proba.add(Proba);
		glavniMeniMusterija.add(test);
		test.add(Test);
//		glavniMeniDispecer.add(voznjeMeni);
//		voznjeMeni.add(voznje);
	}
	
	public void initActions() {
		
	}

}