package guiPaket.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import guiPaket.FormeZaDodavanjeIIzmenu.NarucivanjeVoznjeMusterijaForma;
import guiPaket.FormeZaDodavanjeIIzmenu.VoznjeDispecerForma;
import taksiSluzbaPaket.TaksiSluzba;

public class NarucivanjeVoznjeProzorMusterija extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDodaj = new JButton("Naruci voznju");
	
	private TaksiSluzba taksiSluzba;
	
	public NarucivanjeVoznjeProzorMusterija(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Naruci voznju: ");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		
		mainToolbar.add(btnDodaj);
		add(mainToolbar, BorderLayout.NORTH);
		
	}
	
	private void initActions() {
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NarucivanjeVoznjeMusterijaForma narucivanjeVoznjeMusterijaForma = new NarucivanjeVoznjeMusterijaForma(taksiSluzba, null);
				narucivanjeVoznjeMusterijaForma.setVisible(true);
			}
		});
		
	}
	

}
