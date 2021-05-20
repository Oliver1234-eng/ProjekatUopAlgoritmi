package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import osobe.Vozac;
import taksiSluzba.TaksiSluzba;

public class GlavniProzorVozac extends JFrame {
	
	private JMenuBar glavniMeniVozac = new JMenuBar();
	private JMenu proba = new JMenu("proba");
	private JMenuItem Proba = new JMenuItem("Proba");
	private JMenu test = new JMenu("test");
	private JMenuItem Test = new JMenuItem("Test");
//	private JMenu voznjeMeni = new JMenu("voznje");
//	private JMenuItem voznje = new JMenuItem("Voznje");
	
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
		glavniMeniVozac.add(proba);
		proba.add(Proba);
		glavniMeniVozac.add(test);
		test.add(Test);
//		glavniMeniDispecer.add(voznjeMeni);
//		voznjeMeni.add(voznje);
	}
	
	public void initActions() {
		
	}

}
