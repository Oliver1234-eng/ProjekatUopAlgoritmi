package guiPaket.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import automobilPaket.Automobil;
import main.Main;
import net.miginfocom.swing.MigLayout;
import osobePaket.Dispecer;
import osobePaket.Pol;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;

public class VozaciDispecerForma extends JFrame {
	
	private JLabel lblRedniBrojKorisnika = new JLabel("Redni broj korisnika: ");
	private JTextField txtRedniBrojKorisnika = new JTextField(20);
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime: ");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka: ");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new JLabel("Ime: ");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime: ");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJMBG = new JLabel("JMBG: ");
	private JTextField txtJMBG = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa: ");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol: ");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblBrojTelefona = new JLabel("Broj telefona: ");
	private JTextField txtBrojTelefona = new JTextField(20);
	private JLabel lblPlata = new JLabel("Plata: ");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblBrojClanskeKarte = new JLabel("Broj clanske karte: ");
	private JTextField txtBrojClanskeKarte = new JTextField(20);
	private JLabel lblAutomobil = new JLabel("Automobil: ");
	private JComboBox<String> cbAutomobili = new JComboBox<String>();
	private JButton btnOK = new JButton("OK");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
	private Vozac vozac;
	
	public VozaciDispecerForma(TaksiSluzba taksiSluzba, Vozac vozac) {
		this.taksiSluzba = taksiSluzba;
		this.vozac = vozac;
		
		if (vozac == null) {
			setTitle("Dodavanje vozaca");
		} else {
			setTitle("Izmena vozaca -" + vozac.getKorisnickoIme());
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][][]20[]" );
		setLayout(layout);
		
		for (Automobil automobil : taksiSluzba.sviNeobrisaniAutomobili()) {
			cbAutomobili.addItem(automobil.getBrojRegistarskeOznake());
		}
		
		if (vozac != null) {
			popuniPolja();
		}
		
		add(lblRedniBrojKorisnika);
		add(txtRedniBrojKorisnika);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(pfLozinka);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJMBG);
		add(txtJMBG);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cbPol);
		add(lblBrojTelefona);
		add(txtBrojTelefona);
		add(lblPlata);
		add(txtPlata);
		add(lblBrojClanskeKarte);
		add(txtBrojClanskeKarte);
		add(lblAutomobil);
		add(cbAutomobili);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnNazad);
		
	}
	
	private void initActions() {
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//VALIDACIJA
				if (validacija()) {
					int idKorisnika = Integer.parseInt(txtRedniBrojKorisnika.getText().trim());
					String korisnickoIme = txtKorisnickoIme.getText().trim();
					String lozinka = new String(pfLozinka.getPassword()).trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String JMBG = txtJMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brojTelefona = txtBrojTelefona.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					int brojClanskeKarte = Integer.parseInt(txtBrojClanskeKarte.getText().trim());
					String automobilID = cbAutomobili.getSelectedItem().toString();
					Automobil automobil = taksiSluzba.getAutomobilPoRegistarskomBroju(automobilID);
					
					//DODAVANJE
					if (vozac == null) {
						Vozac noviVozac = new Vozac(idKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, false, plata, brojClanskeKarte, automobil);
						taksiSluzba.dodajVozaca(noviVozac);
					} else {   //IZMENA
						
						vozac.setIdKorisnika(idKorisnika);
						vozac.setKorisnickoIme(korisnickoIme);
						vozac.setLozinka(lozinka);
						vozac.setIme(ime);
						vozac.setPrezime(prezime);
						vozac.setJMBG(JMBG);
						vozac.setAdresa(adresa);
						vozac.setPol(pol);
						vozac.setBrojTelefona(brojTelefona);
						vozac.setPlata(plata);
						vozac.setBrojClanskeKarte(brojClanskeKarte);
						vozac.setAutomobil(automobil);
					}
					
					taksiSluzba	.snimiVozaca(Main.VOZACI_FAJL);
					VozaciDispecerForma.this.dispose();
					VozaciDispecerForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtRedniBrojKorisnika.setText(String.valueOf(vozac.getIdKorisnika()));
		txtRedniBrojKorisnika.setEditable(false);
		txtKorisnickoIme.setText(vozac.getKorisnickoIme());
		txtKorisnickoIme.setEditable(false);
		pfLozinka.setText(vozac.getLozinka());
		txtIme.setText(vozac.getIme());
		txtPrezime.setText(vozac.getPrezime());
		txtJMBG.setText(vozac.getJMBG());
		txtAdresa.setText(vozac.getAdresa());
		cbPol.setSelectedItem(vozac.getPol());
		cbPol.setEnabled(false);
		txtBrojTelefona.setText(vozac.getBrojTelefona());
		txtPlata.setText(String.valueOf(vozac.getPlata()));
		txtBrojClanskeKarte.setText(String.valueOf(vozac.getBrojClanskeKarte()));
		cbAutomobili.setSelectedItem(vozac.getAutomobil());;
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo ispravite sledece greske prilikom unosa: \n";
		
		if (txtRedniBrojKorisnika.getText().trim().equals("")) {
			poruka += "- Unesite redni broj korisnika \n";
			ok = false;
		}
		
		if (txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime \n";
			ok = false;
		} else if (vozac == null) {
			String korisnickoIme = txtKorisnickoIme.getText().trim();
			Vozac pronadjeniVozac = taksiSluzba.getVozacPoKorisnickomImenu(korisnickoIme);
			if (pronadjeniVozac != null) {
				poruka += "- Vozac sa tim korisnickim imenom vec postoji\n";
				ok = false;
			}
			
		}
		
		String lozinka = new String(pfLozinka.getPassword()).trim();
		if(lozinka.equals("")) {
			poruka += "- Unesite lozinku \n";
			ok = false;
		}
		
		if (txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime \n";
			ok = false;
		}
		
		if (txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime \n";
			ok = false;
		}
		
		if (txtJMBG.getText().trim().equals("")) {
			poruka += "- Unesite JMBG \n";
			ok = false;
		}
		
		if (txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresa \n";
			ok = false;
		}
		
		if (txtBrojTelefona.getText().trim().equals("")) {
			poruka += "- Unesite broj telefona \n";
			ok = false;
		}
		
		try {
			Double.parseDouble(txtPlata.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- Plata mora biti broj \n";
			ok = false;
			
		}
		
		try {
			Integer.parseInt(txtBrojClanskeKarte.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- Broj clanske karte mora biti broj \n";
			ok = false;
		}
		
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
		
	}

}
