package guiPaket.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;

public class DnevniIzvestajiUlogaDispecer extends JFrame {
	
	private JLabel lblDatum = new JLabel("DATUM 30.06.2021.");
	private JLabel lblDatum2 = new JLabel("");
	private JLabel lblUkupanBrojVoznji = new JLabel("UKUPAN BROJ VOZNJI: ");
	private JLabel lblUkupanBrojVoznji2 = new JLabel("9");
	private JLabel lblProsecnoTrajanjeVoznji = new JLabel("PROSECNO TRAJANJE VONJI: ");
	private JLabel lblProsecnoTrajanjeVoznji2 = new JLabel("46.89 min");
	private JLabel lblProsecanBrojKilometara = new JLabel("PROSECAN BROJ KM: ");
	private JLabel lblProsecanBrojKilometara2 = new JLabel("47.78 km");
	private JLabel lblSveukupnaZarada = new JLabel("SVEUKUPNA ZARADA");
	private JLabel lblSveukupnaZarada2 = new JLabel("87.800 din");
	private JLabel lblProsecnaZaradaPoVoznji = new JLabel("PROSECNA ZARADA PO VOZNJI");
	private JLabel lblProsecnaZaradaPoVoznji2 = new JLabel("9.755,55 din");
	
	private JLabel lblDatum3 = new JLabel("DATUM 01.07.2021.");
	private JLabel lblDatum4 = new JLabel("");
	private JLabel lblUkupanBrojVoznji3 = new JLabel("UKUPAN BROJ VOZNJI: ");
	private JLabel lblUkupanBrojVoznji4 = new JLabel("3");
	private JLabel lblProsecnoTrajanjeVoznji3 = new JLabel("PROSECNO TRAJANJE VONJI: ");
	private JLabel lblProsecnoTrajanjeVoznji4 = new JLabel("26.67 min");
	private JLabel lblProsecanBrojKilometara3 = new JLabel("PROSECAN BROJ KM: ");
	private JLabel lblProsecanBrojKilometara4 = new JLabel("30 km");
	private JLabel lblSveukupnaZarada3 = new JLabel("SVEUKUPNA ZARADA");
	private JLabel lblSveukupnaZarada4 = new JLabel("18.600 din");
	private JLabel lblProsecnaZaradaPoVoznji3 = new JLabel("PROSECNA ZARADA PO VOZNJI");
	private JLabel lblProsecnaZaradaPoVoznji4 = new JLabel("6.200 din");
	
	private JButton btnZatvori = new JButton("Zatvori");
	
	private TaksiSluzba taksiSluzba;
	private Vozac vozac;
	
	public DnevniIzvestajiUlogaDispecer(TaksiSluzba taksiSluzba, Vozac vozac) {
		this.taksiSluzba = taksiSluzba;
		this.vozac = vozac;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dnevni izvestaji");
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][][][]20[]" );
		setLayout(layout);
		
		add(lblDatum);
		add(lblDatum2);
		add(lblUkupanBrojVoznji);
		add(lblUkupanBrojVoznji2);
		add(lblProsecnoTrajanjeVoznji);
		add(lblProsecnoTrajanjeVoznji2);
		add(lblProsecanBrojKilometara);
		add(lblProsecanBrojKilometara2);
		add(lblSveukupnaZarada);
		add(lblSveukupnaZarada2);
		add(lblProsecnaZaradaPoVoznji);
		add(lblProsecnaZaradaPoVoznji2);
		add(new JLabel());
		add(new JLabel());
		
		add(lblDatum3);
		add(lblDatum4);
		add(lblUkupanBrojVoznji3);
		add(lblUkupanBrojVoznji4);
		add(lblProsecnoTrajanjeVoznji3);
		add(lblProsecnoTrajanjeVoznji4);
		add(lblProsecanBrojKilometara3);
		add(lblProsecanBrojKilometara4);
		add(lblSveukupnaZarada3);
		add(lblSveukupnaZarada4);
		add(lblProsecnaZaradaPoVoznji3);
		add(lblProsecnaZaradaPoVoznji4);
		
		add(new JLabel());
		add(btnZatvori);
		
		
	}
	
	private void initActions() {
		
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DnevniIzvestajiUlogaDispecer.this.dispose();
				DnevniIzvestajiUlogaDispecer.this.setVisible(false);
			}
		});
	}

}
