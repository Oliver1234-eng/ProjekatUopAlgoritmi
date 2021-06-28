package guiPaket.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import main.Main;
import net.miginfocom.swing.MigLayout;
import osobePaket.Musterija;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;
import voznjaPaket.StatusVoznje;
import voznjaPaket.Voznja;

public class PrihvatanjeOdbijanjeVoznjeUlogaVozacForma extends JFrame {
	
	private JLabel lblObavestenje = new JLabel("Dobar dan. Molimo Vas da prihvatite ili odbijete odabranu voznju");
	private JLabel lblUputstvo = new JLabel("Potrebno je promeniti status voznje na PRIHVACENA ili na ODBIJENA");
	private JLabel lblIdVoznje = new JLabel("ID voznje: ");
	private JTextField txtIdVoznje = new JTextField(20);
	private JLabel lblDatumIVremePorudzbine = new JLabel("Datum porudzbine: ");
	private JCalendar calendarDatumIVremePorudzbine = new JCalendar();
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
	private JButton btnPrihvatiOdbij = new JButton("Prihvati ili odbij");
	
	private TaksiSluzba taksiSluzba;
	private Voznja voznja;
	
	public PrihvatanjeOdbijanjeVoznjeUlogaVozacForma(TaksiSluzba taksiSluzba, Voznja voznja) {
		this.taksiSluzba = taksiSluzba;
		this.voznja = voznja;
		
		setTitle("Prihvatanje/odbijanje voznje -" + voznja.getIdVoznje());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][]20[]" );
		setLayout(layout);
		
		for (Musterija musterija : taksiSluzba.sveNeobrisaneMusterije()) {
			cbImeMusterije.addItem(musterija.getKorisnickoIme());
		}
		
		for (Vozac vozac : taksiSluzba.sviNeobrisaniVozaci()) {
			cbImeVozaca.addItem(vozac.getKorisnickoIme());
		}
		
		if (voznja != null) {
			popuniPolja();
		}
		
		add(lblObavestenje, "span 2");
		add(lblUputstvo, "span 2");
		add(lblIdVoznje);
		add(txtIdVoznje);
		add(lblDatumIVremePorudzbine);
		add(calendarDatumIVremePorudzbine);
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
		add(btnPrihvatiOdbij);
		
//		int random = (int)(Math.random() * 999999 + 100000);
//		String voznjaId = Integer.toString(random);
//		txtIdVoznje.setText(voznjaId);
//		txtIdVoznje.setEditable(false);
		txtIdVoznje.setEditable(false);
		txtAdresaPolaska.setEditable(false);
		txtAdresaDestinacije.setEditable(false);
		cbImeMusterije.setEnabled(false);
		cbImeVozaca.setEnabled(false);
		double brojPredjenihKilometara = 0;
		String brojKilometara = Double.toString(brojPredjenihKilometara);
		txtBrojPredjenihKilometara.setText(brojKilometara);
		txtBrojPredjenihKilometara.setEditable(false);
		txtTrajanjeVoznje.setText("0");
		txtTrajanjeVoznje.setEditable(false);
		
	}
	
	private void initActions() {
		
		btnPrihvatiOdbij.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//VALIDACIJA
				if (validacija()) {
					int idVoznje = Integer.parseInt(txtIdVoznje.getText().trim());
					Date datumIVremePorudzbine = calendarDatumIVremePorudzbine.getDate();
					String adresaPolaska = txtAdresaPolaska.getText().trim();
					String adresaDestinacije = txtAdresaDestinacije.getText().trim();
					String imeMusterije = cbImeMusterije.getSelectedItem().toString();
					Musterija musterija = taksiSluzba.getMusterijaPoKorisnickomImenu(imeMusterije);
					String imeVozaca = cbImeVozaca.getSelectedItem().toString();
					Vozac vozac = taksiSluzba.getVozacPoKorisnickomImenu(imeVozaca);
					double brojPredjenihKilometara = Double.parseDouble(txtBrojPredjenihKilometara.getText().trim());
					String trajanjeVoznje = txtTrajanjeVoznje.getText().trim();
					StatusVoznje statusVoznje = (StatusVoznje)cbStatusVoznje.getSelectedItem();
					
					//IZMENA
					if (voznja != null) {
						
						voznja.setIdVoznje(idVoznje);
						voznja.setDatumIVremePorudzbine(datumIVremePorudzbine);
						voznja.setAdresaPolaska(adresaPolaska);
						voznja.setAdresaDestinacije(adresaDestinacije);
						voznja.setImeMusterije(musterija);
						voznja.setImeVozaca(vozac);
						voznja.setBrojPredjenihKilometara(brojPredjenihKilometara);
						voznja.setTrajanjeVoznje(trajanjeVoznje);
						voznja.setStatusVoznje(statusVoznje);
					}
						
					JOptionPane.showMessageDialog(null, "Voznja je uspesno prihvacena/odbijena!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					taksiSluzba.snimiVoznju(Main.VOZNJE_FAJL);
					PrihvatanjeOdbijanjeVoznjeUlogaVozacForma.this.dispose();
					PrihvatanjeOdbijanjeVoznjeUlogaVozacForma.this.setVisible(false);
					
				}
				
			}
		});
		
	}
	
	private void popuniPolja() {
		
		txtIdVoznje.setText(String.valueOf(voznja.getIdVoznje()));
		txtIdVoznje.setEditable(false);
		txtAdresaPolaska.setText(voznja.getAdresaPolaska());
		txtAdresaDestinacije.setText(voznja.getAdresaDestinacije());
		cbImeMusterije.setSelectedItem(voznja.getImeMusterije());
		cbImeMusterije.setEnabled(false);
		cbImeVozaca.setSelectedItem(voznja.getImeVozaca());
		txtBrojPredjenihKilometara.setText(String.valueOf(voznja.getBrojPredjenihKilometara()));
		txtTrajanjeVoznje.setText(voznja.getTrajanjeVoznje());
		cbStatusVoznje.setSelectedItem(voznja.getStatusVoznje());
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo ispravite sledece greske prilikom unosa: \n";
		
		if (txtIdVoznje.getText().trim().equals("")) {
			poruka += "- Unesite ID voznje \n";
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
