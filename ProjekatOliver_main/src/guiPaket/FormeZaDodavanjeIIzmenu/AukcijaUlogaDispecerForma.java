package guiPaket.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;

public class AukcijaUlogaDispecerForma extends JFrame {
	
	private JLabel lblVozac1 = new JLabel("TEST VOZAC 1");
	private JLabel lblVozac1UkupanBrojVoznji = new JLabel("Ukupan broj voznji: ");
	private JLabel lblVozac1UkupnaKilometraza = new JLabel("Ukupna kilometraza: ");
	private JLabel lblVozac1ProsecnaKilometrazaPoVoznji = new JLabel("Prosecna kilometraza: ");
	private JLabel lblVozac1UkupnoTrajanjeVoznji = new JLabel("Ukupno trajanje voznji: ");
	private JLabel lblVozac1ProsecnoTrajanjeVoznji = new JLabel("Prosecno trajanje voznji: ");
	private JLabel lblVozac1UkupnaZarada = new JLabel("Ukupna zarada: ");
	private JLabel lblVozac1ProsecnaZarada = new JLabel("Prosecna zarada: ");
	private JLabel lblVozac11 = new JLabel("PODATAK");
	private JLabel lblVozac11UkupanBrojVoznji = new JLabel("PODATAK");
	private JLabel lblVozac11UkupnaKilometraza = new JLabel("PODATAK");
	private JLabel lblVozac11ProsecnaKilometrazaPoVoznji = new JLabel("PODATAK");
	private JLabel lblVozac11UkupnoTrajanjeVoznji = new JLabel("PODATAK");
	private JLabel lblVozac11ProsecnoTrajanjeVoznji = new JLabel("PODATAK");
	private JLabel lblVozac11UkupnaZarada = new JLabel("PODATAK");
	private JLabel lblVozac11ProsecnaZarada = new JLabel("PODATAK");
	
	private JLabel lblVozac2 = new JLabel("TEST VOZAC 2");
	private JLabel lblVozac2UkupanBrojVoznji = new JLabel("Ukupan broj voznji: ");
	private JLabel lblVozac2UkupnaKilometraza = new JLabel("Ukupna kilometraza: ");
	private JLabel lblVozac2ProsecnaKilometrazaPoVoznji = new JLabel("Prosecna kilometraza: ");
	private JLabel lblVozac2UkupnoTrajanjeVoznji = new JLabel("Ukupno trajanje voznji: ");
	private JLabel lblVozac2ProsecnoTrajanjeVoznji = new JLabel("Prosecno trajanje voznji: ");
	private JLabel lblVozac2UkupnaZarada = new JLabel("Ukupna zarada: ");
	private JLabel lblVozac2ProsecnaZarada = new JLabel("Prosecna zarada: ");
	private JLabel lblVozac22 = new JLabel("PODATAK");
	private JLabel lblVozac22UkupanBrojVoznji = new JLabel("PODATAK");
	private JLabel lblVozac22UkupnaKilometraza = new JLabel("PODATAK");
	private JLabel lblVozac22ProsecnaKilometrazaPoVoznji = new JLabel("PODATAK");
	private JLabel lblVozac22UkupnoTrajanjeVoznji = new JLabel("PODATAK");
	private JLabel lblVozac22ProsecnoTrajanjeVoznji = new JLabel("PODATAK");
	private JLabel lblVozac22UkupnaZarada = new JLabel("PODATAK");
	private JLabel lblVozac22ProsecnaZarada = new JLabel("PODATAK");
	
	private JLabel lblVozac3 = new JLabel("TEST VOZAC 3");
	private JLabel lblVozac3UkupanBrojVoznji = new JLabel("Ukupan broj voznji: ");
	private JLabel lblVozac3UkupnaKilometraza = new JLabel("Ukupna kilometraza: ");
	private JLabel lblVozac3ProsecnaKilometrazaPoVoznji = new JLabel("Prosecna kilometraza: ");
	private JLabel lblVozac3UkupnoTrajanjeVoznji = new JLabel("Ukupno trajanje voznji: ");
	private JLabel lblVozac3ProsecnoTrajanjeVoznji = new JLabel("Prosecno trajanje voznji: ");
	private JLabel lblVozac3UkupnaZarada = new JLabel("Ukupna zarada: ");
	private JLabel lblVozac3ProsecnaZarada = new JLabel("Prosecna zarada: ");
	private JLabel lblVozac33 = new JLabel("TEST VOZAC 3");
	private JLabel lblVozac33UkupanBrojVoznji = new JLabel("PODATAK");
	private JLabel lblVozac33UkupnaKilometraza = new JLabel("PODATAK");
	private JLabel lblVozac33ProsecnaKilometrazaPoVoznji = new JLabel("PODATAK");
	private JLabel lblVozac33UkupnoTrajanjeVoznji = new JLabel("PODATAK");
	private JLabel lblVozac33ProsecnoTrajanjeVoznji = new JLabel("PODATAK");
	private JLabel lblVozac33UkupnaZarada = new JLabel("PODATAK");
	private JLabel lblVozac33ProsecnaZarada = new JLabel("PODATAK");
	
	private JButton btnZatvori = new JButton("Zatvori");
	
	private TaksiSluzba taksiSluzba;
	private Vozac vozac;
	
	public AukcijaUlogaDispecerForma(TaksiSluzba taksiSluzba, Vozac vozac) {
		this.taksiSluzba = taksiSluzba;
		this.vozac = vozac;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
//		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][][][][][][][][][][][][][][][][]20[]" );
		setLayout(layout);
		
		add(lblVozac1);
		add(lblVozac1UkupanBrojVoznji);
		add(lblVozac1UkupnaKilometraza);
		add(lblVozac1ProsecnaKilometrazaPoVoznji);
		add(lblVozac1UkupnoTrajanjeVoznji);
		add(lblVozac1ProsecnoTrajanjeVoznji);
		add(lblVozac1UkupnaZarada);
		add(lblVozac1ProsecnaZarada);
		add(lblVozac11);
		add(lblVozac11UkupanBrojVoznji);
		add(lblVozac11UkupnaKilometraza);
		add(lblVozac11ProsecnaKilometrazaPoVoznji);
		add(lblVozac11UkupnoTrajanjeVoznji);
		add(lblVozac11ProsecnoTrajanjeVoznji);
		add(lblVozac11UkupnaZarada);
		add(lblVozac11ProsecnaZarada);
		add(new JLabel());
		add(new JLabel());
		
		add(lblVozac2);
		add(lblVozac2UkupanBrojVoznji);
		add(lblVozac2UkupnaKilometraza);
		add(lblVozac2ProsecnaKilometrazaPoVoznji);
		add(lblVozac2UkupnoTrajanjeVoznji);
		add(lblVozac2ProsecnoTrajanjeVoznji);
		add(lblVozac2UkupnaZarada);
		add(lblVozac2ProsecnaZarada);
		add(lblVozac22);
		add(lblVozac22UkupanBrojVoznji);
		add(lblVozac22UkupnaKilometraza);
		add(lblVozac22ProsecnaKilometrazaPoVoznji);
		add(lblVozac22UkupnoTrajanjeVoznji);
		add(lblVozac22ProsecnoTrajanjeVoznji);
		add(lblVozac22UkupnaZarada);
		add(lblVozac22ProsecnaZarada);
		add(new JLabel());
		add(new JLabel());
		
		add(lblVozac3);
		add(lblVozac3UkupanBrojVoznji);
		add(lblVozac3UkupnaKilometraza);
		add(lblVozac3ProsecnaKilometrazaPoVoznji);
		add(lblVozac3UkupnoTrajanjeVoznji);
		add(lblVozac3ProsecnoTrajanjeVoznji);
		add(lblVozac3UkupnaZarada);
		add(lblVozac3ProsecnaZarada);
		add(lblVozac33);
		add(lblVozac33UkupanBrojVoznji);
		add(lblVozac33UkupnaKilometraza);
		add(lblVozac33ProsecnaKilometrazaPoVoznji);
		add(lblVozac33UkupnoTrajanjeVoznji);
		add(lblVozac33ProsecnoTrajanjeVoznji);
		add(lblVozac33UkupnaZarada);
		add(lblVozac33ProsecnaZarada);
		add(new JLabel());
		add(btnZatvori);
		
		
	}
	
//	private void initActions() {
//		
//		btnZatvori.addActionListener(new ActionListener() {
//			@Override
//			public void ActionPerformed(ActionEvent e) {
//				
//				AukcijaUlogaDispecerForma.this.dispose();
//				AukcijaUlogaDispecerForma.this.setVisible(false);
//			}
//		});
//	}
	

}
