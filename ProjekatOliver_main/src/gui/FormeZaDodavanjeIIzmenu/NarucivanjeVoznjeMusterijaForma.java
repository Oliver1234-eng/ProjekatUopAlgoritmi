package gui.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Main;
import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class NarucivanjeVoznjeMusterijaForma extends JFrame {
	
	private JLabel lblIdVoznje = new JLabel("ID voznje: ");
	private JTextField txtIdVoznje = new JTextField(20);
	private JLabel lblDatumIVremePorudzbine = new JLabel("Datum porudzbine: ");
	private JTextField txtDatumIVremePorudzbine = new JTextField(20);
	private JLabel lblAdresaPolaska = new JLabel("Adresa polaska: ");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije: ");
	private JTextField txtAdresaDestinacije = new JTextField(20);
	private JLabel lblImeMusterije = new JLabel("Ime musterije: ");
	private JComboBox<String> cbImeMusterije = new JComboBox<String>();
	private JLabel lblImeVozaca = new JLabel("Ime vozaca: ");
	private JComboBox<String> cbImeVozaca = new JComboBox<String>();
	private JLabel lblBrojPredjenihKilometara = new JLabel("Broj predjenih km: ");
	private JTextField txtBrojPredjenihKilometara = new JTextField(20);
	private JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje: ");
	private JTextField txtTrajanjeVoznje = new JTextField(20);
	private JLabel lblStatusVoznje = new JLabel("Status voznje: ");
	private JComboBox<StatusVoznje> cbStatusVoznje = new JComboBox<StatusVoznje>(StatusVoznje.values());
	private JButton btnNaruci = new JButton("Naruci");
	
	private TaksiSluzba taksiSluzba;
	private Voznja voznja;
	
	public NarucivanjeVoznjeMusterijaForma(TaksiSluzba taksiSluzba, Voznja voznja) {
		this.taksiSluzba = taksiSluzba;
		this.voznja = voznja;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][]20[]" );
		setLayout(layout);
		
		for (Musterija musterija : taksiSluzba.sveNeobrisaneMusterije()) {
			cbImeMusterije.addItem(musterija.getKorisnickoIme());
		}
		
		for (Vozac vozac : taksiSluzba.sviNeobrisaniVozaci()) {
			cbImeVozaca.addItem(vozac.getKorisnickoIme());
		}
		
//		if (voznja != null) {
//			popuniPolja();
//		}
		
		add(lblIdVoznje);
		add(txtIdVoznje);
		add(lblDatumIVremePorudzbine);
		add(txtDatumIVremePorudzbine);
		add(lblAdresaPolaska);
		add(txtAdresaPolaska);
		add(lblAdresaDestinacije);
		add(txtAdresaDestinacije);
		add(lblImeMusterije);
		add(cbImeMusterije);
		add(lblImeVozaca);
		add(cbImeVozaca);
		add(lblBrojPredjenihKilometara);
		add(txtBrojPredjenihKilometara);
		add(lblTrajanjeVoznje);
		add(txtTrajanjeVoznje);
		add(lblStatusVoznje);
		add(cbStatusVoznje);
		add(new JLabel());
		add(btnNaruci);
		
		int random = (int)(Math.random() * 999999 + 100000);
		String voznjaId = Integer.toString(random);
		txtIdVoznje.setText(voznjaId);
		txtIdVoznje.setEditable(false);
		cbImeMusterije.setEnabled(false);
		cbImeVozaca.setEnabled(false);
		double brojPredjenihKilometara = 0;
		String brojKilometara = Double.toString(brojPredjenihKilometara);
		txtBrojPredjenihKilometara.setText(brojKilometara);
		txtBrojPredjenihKilometara.setEditable(false);
		txtTrajanjeVoznje.setText("0");
		txtTrajanjeVoznje.setEditable(false);
		cbStatusVoznje.setEnabled(false);
		
	}
	
	private void initActions() {
		
		btnNaruci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//VALIDACIJA
				if (validacija()) {
					String idVoznje = txtIdVoznje.getText().trim();
					String datumIVremePorudzbine = txtDatumIVremePorudzbine.getText().trim();
					String adresaPolaska = txtAdresaPolaska.getText().trim();
					String adresaDestinacije = txtAdresaDestinacije.getText().trim();
					String imeMusterije = cbImeMusterije.getSelectedItem().toString();
					Musterija musterija = taksiSluzba.getMusterijaPoKorisnickomImenu(imeMusterije);
					String imeVozaca = cbImeVozaca.getSelectedItem().toString();
					Vozac vozac = taksiSluzba.getVozacPoKorisnickomImenu(imeVozaca);
					double brojPredjenihKilometara = Double.parseDouble(txtBrojPredjenihKilometara.getText().trim());
					String trajanjeVoznje = txtTrajanjeVoznje.getText().trim();
					StatusVoznje statusVoznje = (StatusVoznje)cbStatusVoznje.getSelectedItem();
					
					//DODAVANJE
					if (voznja == null) {
						txtIdVoznje.setEditable(false);
						Voznja novaVoznja = new Voznja(idVoznje, datumIVremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojPredjenihKilometara, trajanjeVoznje, statusVoznje, false);
						taksiSluzba.dodajVoznju(novaVoznja);
						txtIdVoznje.setEditable(false);
					}
					
				    JOptionPane.showMessageDialog(null, "Voznja je uspesno narucena!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					taksiSluzba.snimiVoznju(Main.VOZNJE_FAJL);
					NarucivanjeVoznjeMusterijaForma.this.dispose();
					NarucivanjeVoznjeMusterijaForma.this.setVisible(false);
					
				}
				
			}
		});
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo ispravite sledece greske prilikom unosa: \n";
		
		if (txtIdVoznje.getText().trim().equals("")) {
			poruka += "- Unesite ID voznje \n";
			ok = false;
		}
		
		if (txtDatumIVremePorudzbine.getText().trim().equals("")) {
			poruka += "- Unesite datum porudzbine \n";
			ok = false;
		}
		
		if (txtAdresaPolaska.getText().trim().equals("")) {
			poruka += "- Unesite adresu polaska \n";
			ok = false;
		}
		
		if (txtAdresaDestinacije.getText().trim().equals("")) {
			poruka += "- Unesite adresu destinacije \n";
			ok = false;
		}
		
		try {
			Double.parseDouble(txtBrojPredjenihKilometara.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- Broj predjenih kilometara mora biti broj \n";
			ok = false;
			
		}
		
		if (txtTrajanjeVoznje.getText().trim().equals("")) {
			poruka += "- Unesite trajanje voznje \n";
			ok = false;
		}
		
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
