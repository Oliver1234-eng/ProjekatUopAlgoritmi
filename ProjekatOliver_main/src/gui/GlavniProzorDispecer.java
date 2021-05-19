package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import osobe.Dispecer;
import taksiSluzba.TaksiSluzba;

public class GlavniProzorDispecer extends JFrame {
	
	private JMenuBar glavniMeniDispecer = new JMenuBar();
	private JMenu vozaciMeni = new JMenu("vozaci");
	private JMenuItem vozaci = new JMenuItem("Vozaci");
	private JMenu automobiliMeni = new JMenu("automobili");
	private JMenuItem automobili = new JMenuItem("Automobili");
	private JMenu voznjeMeni = new JMenu("voznje");
	private JMenuItem voznje = new JMenuItem("Voznje");
	
	private TaksiSluzba taksiSluzba;
	private Dispecer prijavljeni;
	
	public GlavniProzorDispecer(TaksiSluzba taksiSluzba, Dispecer prijavljeni) {
		this.taksiSluzba = taksiSluzba;
		this.prijavljeni = prijavljeni;
		setTitle("Dispecer: " + prijavljeni.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenuDispecer();
		initActions();
	}
	
	public void initMenuDispecer() {
		setJMenuBar(glavniMeniDispecer);
		glavniMeniDispecer.add(vozaciMeni);
		vozaciMeni.add(vozaci);
		glavniMeniDispecer.add(automobiliMeni);
		automobiliMeni.add(automobili);
		glavniMeniDispecer.add(voznjeMeni);
		voznjeMeni.add(voznje);
	}
	
	public void initActions() {
		
	}

}
