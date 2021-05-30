package gui.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.Main;
import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.OdeljenjeDispecer;
import osobe.Pol;
import taksiSluzba.TaksiSluzba;

public class DispeceriDispecerForma extends JFrame {
	
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
	private JLabel lblBrojTelefonskeLinije = new JLabel("Broj telefonske linije: ");
	private JTextField txtBrojTelefonskeLinije = new JTextField(20);
	private JLabel lblOdeljenjeDispecer = new JLabel("Odeljenje: ");
	private JComboBox<OdeljenjeDispecer> cbOdeljenjeDispecer = new JComboBox<OdeljenjeDispecer>(OdeljenjeDispecer.values());
	private JButton btnOK = new JButton("OK");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
	private Dispecer dispecer;
	
	public DispeceriDispecerForma(TaksiSluzba taksiSluzba, Dispecer dispecer) {
		this.taksiSluzba = taksiSluzba;
		this.dispecer = dispecer;
		
		if (dispecer == null) {
			setTitle("Dodavanje dispecera");
		} else {
			setTitle("Izmena dispecera -" + dispecer.getKorisnickoIme());
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
		
		if(dispecer != null) {
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
		add(lblBrojTelefonskeLinije);
		add(txtBrojTelefonskeLinije);
		add(lblOdeljenjeDispecer);
		add(cbOdeljenjeDispecer);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnNazad);
		
		
	}
	
	private void initActions() {
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//VALIDACIJA 
				if(validacija()) {
					String redniBrojKorisnika = txtRedniBrojKorisnika.getText().trim();
					String korisnickoIme = txtKorisnickoIme.getText().trim();
					String lozinka = new String(pfLozinka.getPassword()).trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String JMBG = txtJMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brojTelefona = txtBrojTelefona.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					int brojTelefonskeLinije = Integer.parseInt(txtBrojTelefonskeLinije.getText().trim());
					OdeljenjeDispecer odeljenjeDispecer = (OdeljenjeDispecer)cbOdeljenjeDispecer.getSelectedItem();
					
					//DODAVANJE
					if (dispecer == null) {
						Dispecer noviDispecer = new Dispecer(redniBrojKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, false, plata, brojTelefonskeLinije, odeljenjeDispecer);
						taksiSluzba.dodajDispecera(noviDispecer);
						
					} else {    //IZMENA
						
						dispecer.setIdKorisnika(redniBrojKorisnika);
						dispecer.setKorisnickoIme(korisnickoIme);
						dispecer.setLozinka(lozinka);
						dispecer.setIme(ime);
						dispecer.setPrezime(prezime);
						dispecer.setJMBG(JMBG);
						dispecer.setAdresa(adresa);
						dispecer.setPol(pol);
						dispecer.setBrojTelefona(brojTelefona);
						dispecer.setPlata(plata);
						dispecer.setBrojTelefonskeLinije(brojTelefonskeLinije);
						dispecer.setOdeljenjeDispecer(odeljenjeDispecer);
						
					}
					
					taksiSluzba.snimiDispecera(Main.DISPECERI_FAJL);
					DispeceriDispecerForma.this.dispose();
					DispeceriDispecerForma.this.setVisible(false);
					
				}
					
			}
		});
		
	}
	
	private void popuniPolja() {
		
		txtRedniBrojKorisnika.setText(dispecer.getRedniBrojKorisnika());
		txtRedniBrojKorisnika.setEditable(false);
		txtKorisnickoIme.setText(dispecer.getKorisnickoIme());
		txtKorisnickoIme.setEditable(false);
		pfLozinka.setText(dispecer.getLozinka());
		txtIme.setText(dispecer.getIme());
		txtPrezime.setText(dispecer.getPrezime());
		txtJMBG.setText(dispecer.getJMBG());
		txtAdresa.setText(dispecer.getAdresa());
		cbPol.setSelectedItem(dispecer.getPol());
		cbPol.setEnabled(false);
		txtBrojTelefona.setText(dispecer.getBrojTelefona());
		txtPlata.setText(String.valueOf(dispecer.getPlata()));
		txtBrojTelefonskeLinije.setText(String.valueOf(dispecer.getBrojTelefonskeLinije()));
		cbOdeljenjeDispecer.setSelectedItem(dispecer.getOdeljenjeDispecer());
		
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
		} else if (dispecer == null) {
			String korisnickoIme = txtKorisnickoIme.getText().trim();
			Dispecer pronadjeniDispecer = taksiSluzba.getDispecerPoKorisnickomImenu(korisnickoIme);
			if (pronadjeniDispecer != null) {
				poruka += "- Dispecer sa tim korisnickim imenom vec postoji\n";
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
			Integer.parseInt(txtBrojTelefonskeLinije.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- Broj telefonske linije mora biti broj \n";
			ok = false;
			
		}
		
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}