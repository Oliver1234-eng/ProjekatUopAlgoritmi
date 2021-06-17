package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.DispeceriProzorDispecer;
import gui.formeZaPrikaz.VozaciProzorDispecer;
import gui.formeZaPrikaz.VoznjeProzorDispecer;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;

public class GlavniProzorDispecer extends JFrame {
	
	private JMenuBar glavniMeniDispecer = new JMenuBar();
	private JMenu CRUDvozaciMeni = new JMenu("CRUD vozaci");
	private JMenuItem vozaci = new JMenuItem("Vozaci");
	private JMenu CRUDvoznjeMeni = new JMenu("CRUD voznje");
	private JMenuItem voznje = new JMenuItem("Voznje");
	private JMenu CRUDdispeceriMeni = new JMenu("CRUD dispeceri");
	private JMenuItem dispeceri = new JMenuItem("Dispeceri");
	private JMenu prikazSvihVoznji = new JMenu("Prikaz svih voznji");
	private JMenuItem prikazVoznji = new JMenuItem("Prikazi sve voznje");
	private JMenu dodeljivanjeVoznjeVozacu = new JMenu("Dodeljivanje voznje vozacu");
	private JMenuItem dodelaVoznje = new JMenuItem("Dodeli voznju vozacu");
	
	private TaksiSluzba taksiSluzba;
	private Dispecer prijavljeni;
	
	public GlavniProzorDispecer(TaksiSluzba taksiSluzba, Dispecer prijavljeni) {
		this.taksiSluzba = taksiSluzba;
		this.prijavljeni = prijavljeni;
		setTitle("Dispecer: " + prijavljeni.getKorisnickoIme());
		setSize(500, 500);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenuDispecer();
		initActions();
	}
	
	public void initMenuDispecer() {
		setJMenuBar(glavniMeniDispecer);
		glavniMeniDispecer.add(CRUDvozaciMeni);
		CRUDvozaciMeni.add(vozaci);
		glavniMeniDispecer.add(CRUDvoznjeMeni);
		CRUDvoznjeMeni.add(voznje);
		glavniMeniDispecer.add(CRUDdispeceriMeni);
		CRUDdispeceriMeni.add(dispeceri);
		glavniMeniDispecer.add(prikazSvihVoznji);
		prikazSvihVoznji.add(prikazVoznji);
		glavniMeniDispecer.add(dodeljivanjeVoznjeVozacu);
		dodeljivanjeVoznjeVozacu.add(dodelaVoznje);
	}
	
	public void initActions() {
		
		vozaci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VozaciProzorDispecer vozaciProzorDispecer = new VozaciProzorDispecer(taksiSluzba);
				vozaciProzorDispecer.setVisible(true);
			}
		});
		
		voznje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VoznjeProzorDispecer voznjeProzorDispecer = new VoznjeProzorDispecer(taksiSluzba);
				voznjeProzorDispecer.setVisible(true);
			}
		});
		
		dispeceri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DispeceriProzorDispecer dispeceriProzorDispecer = new DispeceriProzorDispecer(taksiSluzba);
				dispeceriProzorDispecer.setVisible(true);
			}
		});
		
	}

}
