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
	private JLabel lblVozac11 = new JLabel("");
	private JLabel lblVozac1UkupanBrojVoznji = new JLabel("Ukupan broj voznji: ");
	private JLabel lblVozac11UkupanBrojVoznji = new JLabel("8");
	private JLabel lblVozac1UkupnaKilometraza = new JLabel("Ukupna kilometraza: ");
	private JLabel lblVozac11UkupnaKilometraza = new JLabel("330km");
	private JLabel lblVozac1ProsecnaKilometrazaPoVoznji = new JLabel("Prosecna kilometraza: ");
	private JLabel lblVozac11ProsecnaKilometrazaPoVoznji = new JLabel("41.25km");
	private JLabel lblVozac1UkupnoTrajanjeVoznji = new JLabel("Ukupno trajanje voznji: ");
	private JLabel lblVozac11UkupnoTrajanjeVoznji = new JLabel("302 min");
	private JLabel lblVozac1ProsecnoTrajanjeVoznji = new JLabel("Prosecno trajanje voznji: ");
	private JLabel lblVozac11ProsecnoTrajanjeVoznji = new JLabel("37.75 min");
	private JLabel lblVozac1UkupnaZarada = new JLabel("Ukupna zarada: ");
	private JLabel lblVozac11UkupnaZarada = new JLabel("67600 din");
	private JLabel lblVozac1ProsecnaZarada = new JLabel("Prosecna zarada: ");
	private JLabel lblVozac11ProsecnaZarada = new JLabel("8450 din");
	private JLabel lblVozac1PetFriendly = new JLabel("Pet-friendly: ");
	private JLabel lblVozac11PetFriendly = new JLabel("DA");
	private JLabel lblVozac1Ocena = new JLabel("Ocena: ");
	private JLabel lblVozac11Ocena = new JLabel("4.5");
	private JLabel lblVozac1StarostVozila = new JLabel("Starost vozila: ");
	private JLabel lblVozac11StarostVozila = new JLabel("2010. godiste");
	
	private JLabel lblVozac2 = new JLabel("TEST VOZAC 2");
	private JLabel lblVozac22 = new JLabel("");
	private JLabel lblVozac2UkupanBrojVoznji = new JLabel("Ukupan broj voznji: ");
	private JLabel lblVozac22UkupanBrojVoznji = new JLabel("3");
	private JLabel lblVozac2UkupnaKilometraza = new JLabel("Ukupna kilometraza: ");
	private JLabel lblVozac22UkupnaKilometraza = new JLabel("120 km");
	private JLabel lblVozac2ProsecnaKilometrazaPoVoznji = new JLabel("Prosecna kilometraza: ");
	private JLabel lblVozac22ProsecnaKilometrazaPoVoznji = new JLabel("40 km");
	private JLabel lblVozac2UkupnoTrajanjeVoznji = new JLabel("Ukupno trajanje voznji: ");
	private JLabel lblVozac22UkupnoTrajanjeVoznji = new JLabel("162 min");
	private JLabel lblVozac2ProsecnoTrajanjeVoznji = new JLabel("Prosecno trajanje voznji: ");
	private JLabel lblVozac22ProsecnoTrajanjeVoznji = new JLabel("54 min");
	private JLabel lblVozac2UkupnaZarada = new JLabel("Ukupna zarada: ");
	private JLabel lblVozac22UkupnaZarada = new JLabel("24600 din");
	private JLabel lblVozac2ProsecnaZarada = new JLabel("Prosecna zarada: ");
	private JLabel lblVozac22ProsecnaZarada = new JLabel("8200 din");
	private JLabel lblVozac2PetFriendly = new JLabel("Pet-friendly: ");
	private JLabel lblVozac22PetFriendly = new JLabel("NE");
	private JLabel lblVozac2Ocena = new JLabel("Ocena: ");
	private JLabel lblVozac22Ocena = new JLabel("4.2");
	private JLabel lblVozac2StarostVozila = new JLabel("Starost vozila: ");
	private JLabel lblVozac22StarostVozila = new JLabel("2020. godiste");
	
	private JLabel lblVozac3 = new JLabel("TEST VOZAC 3");
	private JLabel lblVozac33 = new JLabel("");
	private JLabel lblVozac3UkupanBrojVoznji = new JLabel("Ukupan broj voznji: ");
	private JLabel lblVozac33UkupanBrojVoznji = new JLabel("1");
	private JLabel lblVozac3UkupnaKilometraza = new JLabel("Ukupna kilometraza: ");
	private JLabel lblVozac33UkupnaKilometraza = new JLabel("70 km");
	private JLabel lblVozac3ProsecnaKilometrazaPoVoznji = new JLabel("Prosecna kilometraza: ");
	private JLabel lblVozac33ProsecnaKilometrazaPoVoznji = new JLabel("70 km");
	private JLabel lblVozac3UkupnoTrajanjeVoznji = new JLabel("Ukupno trajanje voznji: ");
	private JLabel lblVozac33UkupnoTrajanjeVoznji = new JLabel("90 min");
	private JLabel lblVozac3ProsecnoTrajanjeVoznji = new JLabel("Prosecno trajanje voznji: ");
	private JLabel lblVozac33ProsecnoTrajanjeVoznji = new JLabel("90 min");
	private JLabel lblVozac3UkupnaZarada = new JLabel("Ukupna zarada: ");
	private JLabel lblVozac33UkupnaZarada = new JLabel("14200 din");
	private JLabel lblVozac3ProsecnaZarada = new JLabel("Prosecna zarada: ");
	private JLabel lblVozac33ProsecnaZarada = new JLabel("14200 din");
	private JLabel lblVozac3PetFriendly = new JLabel("Pet-friendly: ");
	private JLabel lblVozac33PetFriendly = new JLabel("NE");
	private JLabel lblVozac3Ocena = new JLabel("Ocena: ");
	private JLabel lblVozac33Ocena = new JLabel("3.8");
	private JLabel lblVozac3StarostVozila = new JLabel("Starost vozila: ");
	private JLabel lblVozac33StarostVozila = new JLabel("2020. godiste");
	
	private JButton btnZatvori = new JButton("Zatvori");
	
	private TaksiSluzba taksiSluzba;
	private Vozac vozac;
	
	public AukcijaUlogaDispecerForma(TaksiSluzba taksiSluzba, Vozac vozac) {
		this.taksiSluzba = taksiSluzba;
		this.vozac = vozac;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Aukcija");
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]20[]" );
		setLayout(layout);
		
		add(lblVozac1);
		add(lblVozac11);
		add(lblVozac1UkupanBrojVoznji);
		add(lblVozac11UkupanBrojVoznji);
		add(lblVozac1UkupnaKilometraza);
		add(lblVozac11UkupnaKilometraza);
		add(lblVozac1ProsecnaKilometrazaPoVoznji);
		add(lblVozac11ProsecnaKilometrazaPoVoznji);
		add(lblVozac1UkupnoTrajanjeVoznji);
		add(lblVozac11UkupnoTrajanjeVoznji);
		add(lblVozac1ProsecnoTrajanjeVoznji);
		add(lblVozac11ProsecnoTrajanjeVoznji);
		add(lblVozac1UkupnaZarada);
		add(lblVozac11UkupnaZarada);
		add(lblVozac1ProsecnaZarada);
		add(lblVozac11ProsecnaZarada);
		add(lblVozac1PetFriendly);
		add(lblVozac11PetFriendly);
		add(lblVozac1Ocena);
		add(lblVozac11Ocena);
		add(lblVozac1StarostVozila);
		add(lblVozac11StarostVozila);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		
		add(lblVozac2);
		add(lblVozac22);
		add(lblVozac2UkupanBrojVoznji);
		add(lblVozac22UkupanBrojVoznji);
		add(lblVozac2UkupnaKilometraza);
		add(lblVozac22UkupnaKilometraza);
		add(lblVozac2ProsecnaKilometrazaPoVoznji);
		add(lblVozac22ProsecnaKilometrazaPoVoznji);
		add(lblVozac2UkupnoTrajanjeVoznji);
		add(lblVozac22UkupnoTrajanjeVoznji);
		add(lblVozac2ProsecnoTrajanjeVoznji);
		add(lblVozac22ProsecnoTrajanjeVoznji);
		add(lblVozac2UkupnaZarada);
		add(lblVozac22UkupnaZarada);
		add(lblVozac2ProsecnaZarada);
		add(lblVozac22ProsecnaZarada);
		add(lblVozac2PetFriendly);
		add(lblVozac22PetFriendly);
		add(lblVozac2Ocena);
		add(lblVozac22Ocena);
		add(lblVozac2StarostVozila);
		add(lblVozac22StarostVozila);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(lblVozac3);
		add(lblVozac33);
		add(lblVozac3UkupanBrojVoznji);
		add(lblVozac33UkupanBrojVoznji);
		add(lblVozac3UkupnaKilometraza);
		add(lblVozac33UkupnaKilometraza);
		add(lblVozac3ProsecnaKilometrazaPoVoznji);
		add(lblVozac33ProsecnaKilometrazaPoVoznji);
		add(lblVozac3UkupnoTrajanjeVoznji);
		add(lblVozac33UkupnoTrajanjeVoznji);
		add(lblVozac3ProsecnoTrajanjeVoznji);
		add(lblVozac33ProsecnoTrajanjeVoznji);
		add(lblVozac3UkupnaZarada);
		add(lblVozac33UkupnaZarada);
		add(lblVozac3ProsecnaZarada);
		add(lblVozac33ProsecnaZarada);
		add(lblVozac3PetFriendly);
		add(lblVozac33PetFriendly);
		add(lblVozac3Ocena);
		add(lblVozac33Ocena);
		add(lblVozac3StarostVozila);
		add(lblVozac33StarostVozila);
		add(new JLabel());
		add(new JLabel());
		
		add(new JLabel());
		add(btnZatvori);
		
		
	}
	
	private void initActions() {
		
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AukcijaUlogaDispecerForma.this.dispose();
				AukcijaUlogaDispecerForma.this.setVisible(false);
			}
		});
	}
	

}
