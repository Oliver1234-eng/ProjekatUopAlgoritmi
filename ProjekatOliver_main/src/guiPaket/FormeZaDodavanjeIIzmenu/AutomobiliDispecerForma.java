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

import automobilPaket.Automobil;
import automobilPaket.Model;
import automobilPaket.Proizvodjac;
import automobilPaket.VrstaAutomobila;
import main.Main;
import net.miginfocom.swing.MigLayout;
import osobePaket.Musterija;
import osobePaket.Pol;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;
import voznjaPaket.StatusVoznje;
import voznjaPaket.Voznja;

public class AutomobiliDispecerForma extends JFrame {
	
	private JLabel lblIdAutomobila = new JLabel("ID automobila: ");
	private JTextField txtIdAutomobila = new JTextField(20);
	private JLabel lblModel = new JLabel("Model: ");
	private JComboBox<Model> cbModel = new JComboBox<Model>(Model.values());
	private JLabel lblProizvodjac = new JLabel("Proizvodjac: ");
	private JComboBox<Proizvodjac> cbProizvodjac = new JComboBox<Proizvodjac>(Proizvodjac.values());
	private JLabel lblVrstaAutomobila = new JLabel("Vrsta automobila: ");
	private JComboBox<VrstaAutomobila> cbVrstaAutomobila = new JComboBox<VrstaAutomobila>(VrstaAutomobila.values());
	private JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje: ");
	private JTextField txtGodinaProizvodnje = new JTextField(20);
	private JLabel lblBrojRegistarskeOznake = new JLabel("Broj registarske oznake: ");
	private JTextField txtBrojRegistarskeOznake = new JTextField(20);
	private JLabel lblBrojTaksiVozila = new JLabel("Broj taksi vozila: ");
	private JTextField txtBrojTaksiVozila = new JTextField(20);
	private JButton btnOK = new JButton("OK");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
	private Automobil automobil;
	
	public AutomobiliDispecerForma(TaksiSluzba taksiSluzba, Automobil automobil) {
		this.taksiSluzba = taksiSluzba;
		this.automobil = automobil;
		
		if (automobil == null) {
			setTitle("Dodavanje automobila");
		} else {
			setTitle("Izmena automobila -" + automobil.getIdAutomobila());
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][]20[]" );
		setLayout(layout);
		
		if (automobil != null) {
			popuniPolja();
		}
		
		add(lblIdAutomobila);
		add(txtIdAutomobila);
		add(lblModel);
		add(cbModel);
		add(lblProizvodjac);
		add(cbProizvodjac);
		add(lblVrstaAutomobila);
		add(cbVrstaAutomobila);
		add(lblGodinaProizvodnje);
		add(txtGodinaProizvodnje);
		add(lblBrojRegistarskeOznake);
		add(txtBrojRegistarskeOznake);
		add(lblBrojTaksiVozila);
		add(txtBrojTaksiVozila);
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
					int idAutomobila = Integer.parseInt(txtIdAutomobila.getText().trim());
					Model model = (Model)cbModel.getSelectedItem();
					Proizvodjac proizvodjac = (Proizvodjac)cbProizvodjac.getSelectedItem();
					VrstaAutomobila vrstaAutomobila = (VrstaAutomobila)cbVrstaAutomobila.getSelectedItem();
					int godinaProizvodnje = Integer.parseInt(txtGodinaProizvodnje.getText().trim());
					String brojRegistarskeOznake = txtBrojRegistarskeOznake.getText().trim();
					int brojTaksiVozila = Integer.parseInt(txtBrojTaksiVozila.getText().trim());
					
					//DODAVANJE
					if (automobil == null) {
						Automobil noviAutomobil = new Automobil(idAutomobila, model, proizvodjac, vrstaAutomobila, godinaProizvodnje, brojRegistarskeOznake, brojTaksiVozila, false);
						taksiSluzba.dodajAutomobil(noviAutomobil);
					} else {   //IZMENA
						
						automobil.setIdAutomobila(idAutomobila);
						automobil.setModel(model);
						automobil.setProizvodjac(proizvodjac);
						automobil.setVrstaAutomobila(vrstaAutomobila);
						automobil.setGodinaProizvodnje(godinaProizvodnje);
						automobil.setBrojRegistarskeOznake(brojRegistarskeOznake);
						automobil.setBrojTaksiVozila(brojTaksiVozila);
					}
					
					taksiSluzba.snimiAutomobil(Main.AUTOMOBILI_FAJL);
					AutomobiliDispecerForma.this.dispose();
					AutomobiliDispecerForma.this.setVisible(false);
					
				}
				
			}
		});
		
	}
	
	private void popuniPolja() {
		
		txtIdAutomobila.setText(String.valueOf(automobil.getIdAutomobila()));
		txtIdAutomobila.setEditable(false);
		cbModel.setSelectedItem(automobil.getModel());
		cbModel.setEnabled(false);
		cbProizvodjac.setSelectedItem(automobil.getProizvodjac());
		cbProizvodjac.setEnabled(false);
		cbVrstaAutomobila.setSelectedItem(automobil.getModel());
		cbVrstaAutomobila.setEnabled(false);
		txtGodinaProizvodnje.setText(String.valueOf(automobil.getGodinaProizvodnje()));
		txtGodinaProizvodnje.setEditable(false);
		txtBrojRegistarskeOznake.setText(automobil.getBrojRegistarskeOznake());
		txtBrojRegistarskeOznake.setEditable(false);
		txtBrojTaksiVozila.setText(String.valueOf(automobil.getBrojTaksiVozila()));
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo ispravite sledece greske prilikom unosa: \n";
		
		try {
			Integer.parseInt(txtIdAutomobila.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- ID automobila mora biti broj \n";
		}
		
		try {
			Integer.parseInt(txtGodinaProizvodnje.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- Godina proizvodnje mora biti broj \n";
		}
		
		if (txtBrojRegistarskeOznake.getText().trim().equals("")) {
			poruka += "- Unesite broj registarske oznake \n";
		}
		
		try {
			Integer.parseInt(txtBrojTaksiVozila.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "- Broj taksi vozila mora biti broj \n";
		}
		
		if (ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
