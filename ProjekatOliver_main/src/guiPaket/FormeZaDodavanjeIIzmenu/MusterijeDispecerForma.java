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

import main.Main;
import net.miginfocom.swing.MigLayout;
import osobePaket.Dispecer;
import osobePaket.Musterija;
import osobePaket.OdeljenjeDispecer;
import osobePaket.Pol;
import taksiSluzbaPaket.TaksiSluzba;

public class MusterijeDispecerForma extends JFrame {
	
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
	private JButton btnOK = new JButton("OK");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
	private Musterija musterija;
	
	public MusterijeDispecerForma(TaksiSluzba taksiSluzba, Musterija musterija) {
		this.taksiSluzba = taksiSluzba;
		this.musterija = musterija;
		
		if (musterija == null) {
			setTitle("Dodavanje musterije");
		} else {
			setTitle("Izmena musterije -" + musterija.getKorisnickoIme());
		}
		
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
		
		if(musterija != null) {
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
					int idKorisnika = Integer.parseInt(txtRedniBrojKorisnika.getText().trim());
					String korisnickoIme = txtKorisnickoIme.getText().trim();
					String lozinka = new String(pfLozinka.getPassword()).trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String JMBG = txtJMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brojTelefona = txtBrojTelefona.getText().trim();
					
					//DODAVANJE
					if (musterija == null) {
						Musterija novaMusterija = new Musterija(idKorisnika, korisnickoIme, lozinka, ime, prezime, JMBG, adresa, pol, brojTelefona, false);
						taksiSluzba.dodajMusteriju(novaMusterija);
						
					} else {    //IZMENA
						
						musterija.setIdKorisnika(idKorisnika);
						musterija.setKorisnickoIme(korisnickoIme);
						musterija.setLozinka(lozinka);
						musterija.setIme(ime);
						musterija.setPrezime(prezime);
						musterija.setJMBG(JMBG);
						musterija.setAdresa(adresa);
						musterija.setPol(pol);
						musterija.setBrojTelefona(brojTelefona);
						
					}
					
					taksiSluzba.snimiMusteriju(Main.MUSTERIJE_FAJL);
					MusterijeDispecerForma.this.dispose();
					MusterijeDispecerForma.this.setVisible(false);
					
				}
					
			}
		});
		
	}
	
	private void popuniPolja() {
		
		txtRedniBrojKorisnika.setText(String.valueOf(musterija.getIdKorisnika()));
		txtRedniBrojKorisnika.setEditable(false);
		txtKorisnickoIme.setText(musterija.getKorisnickoIme());
		txtKorisnickoIme.setEditable(false);
		pfLozinka.setText(musterija.getLozinka());
		txtIme.setText(musterija.getIme());
		txtPrezime.setText(musterija.getPrezime());
		txtJMBG.setText(musterija.getJMBG());
		txtAdresa.setText(musterija.getAdresa());
		cbPol.setSelectedItem(musterija.getPol());
		cbPol.setEnabled(false);
		txtBrojTelefona.setText(musterija.getBrojTelefona());
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo ispravite sledece greske prilikom unosa: \n";
		
		try {
			Integer.parseInt(txtRedniBrojKorisnika.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- ID mora biti broj \n";
			ok = false;
		}
		
		if (txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime \n";
			ok = false;
		} else if (musterija == null) {
			String korisnickoIme = txtKorisnickoIme.getText().trim();
			Musterija pronadjenaMusterija = taksiSluzba.getMusterijaPoKorisnickomImenu(korisnickoIme);
			if (pronadjenaMusterija != null) {
				poruka += "- Musterija sa tim korisnickim imenom vec postoji\n";
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
		
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
