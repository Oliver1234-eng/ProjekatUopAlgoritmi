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
	private JMenu vozaciMeni = new JMenu("CRUD vozaci");
	private JMenuItem vozaci = new JMenuItem("CRUD Vozaci");
	private JMenu voznjeMeni = new JMenu("CRUD voznje");
	private JMenuItem voznje = new JMenuItem("CRUD Voznje");
	private JMenu dispeceriMeni = new JMenu("CRUD dispeceri");
	private JMenuItem dispeceri = new JMenuItem("CRUD Dispeceri");
	
	private TaksiSluzba taksiSluzba;
	private Dispecer prijavljeni;
//	private Musterija imeMusterije;
//	private Vozac imeVozaca;
	
	public GlavniProzorDispecer(TaksiSluzba taksiSluzba, Dispecer prijavljeni) {
		this.taksiSluzba = taksiSluzba;
		this.prijavljeni = prijavljeni;
//		this.imeMusterije = imeMusterije;
//		this.imeVozaca = imeVozaca;
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
		glavniMeniDispecer.add(voznjeMeni);
		voznjeMeni.add(voznje);
		glavniMeniDispecer.add(dispeceriMeni);
		dispeceriMeni.add(dispeceri);
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
