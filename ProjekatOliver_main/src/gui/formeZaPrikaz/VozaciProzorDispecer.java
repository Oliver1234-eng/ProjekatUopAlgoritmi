package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import automobil.Automobil;
import gui.FormeZaDodavanjeIIzmenu.DispeceriDispecerForma;
import gui.FormeZaDodavanjeIIzmenu.VozaciDispecerForma;
import main.Main;
import osobe.Dispecer;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;

public class VozaciProzorDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDodaj = new JButton();
	private JButton btnIzmeni = new JButton();
	private JButton btnObrisi = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable vozaciTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public VozaciProzorDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Vozaci");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	private void initGUI() {
		ImageIcon dodaj = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnDodaj.setIcon(dodaj);
		ImageIcon izmeni = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnIzmeni.setIcon(izmeni);
		ImageIcon obrisi = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnObrisi.setIcon(obrisi);
		
		mainToolbar.add(btnDodaj);
		mainToolbar.add(btnIzmeni);
		mainToolbar.add(btnObrisi);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlje = new String[] {"Redni broj", "Korisnicko ime", "Lozinka", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj telefona", "Obrisan", "Plata", "Broj clanske karte", "Automobil"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniVozaci().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sviNeobrisaniVozaci().size(); i++) {
			Vozac vozac = taksiSluzba.sviNeobrisaniVozaci().get(i);
//			Automobil auto = vozac.getAutomobil();
//			String idAutomobilaVozaca = auto.getIdAutomobila();
			
			sadrzaj[i][0] = vozac.getRedniBrojKorisnika();
			sadrzaj[i][1] = vozac.getKorisnickoIme();
			sadrzaj[i][2] = vozac.getLozinka();
			sadrzaj[i][3] = vozac.getIme();
			sadrzaj[i][4] = vozac.getPrezime();
			sadrzaj[i][5] = vozac.getJMBG();
			sadrzaj[i][6] = vozac.getAdresa();
			sadrzaj[i][7] = vozac.getPol();
			sadrzaj[i][8] = vozac.getBrojTelefona();
			sadrzaj[i][9] = vozac.isObrisan();
			sadrzaj[i][10] = vozac.getPlata();
			sadrzaj[i][11] = vozac.getBrojClanskeKarte();
//			sadrzaj[i][12] = idAutomobilaVozaca;
//			
			if (vozac.getAutomobil() != null) {
				sadrzaj[i][12] = vozac.getAutomobil().getIdAutomobila();
			} else {
				sadrzaj[i][12] = "";
			}
		
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		vozaciTabela = new JTable(tableModel);
		
		vozaciTabela.setRowSelectionAllowed(true);
		vozaciTabela.setColumnSelectionAllowed(false);
		vozaciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vozaciTabela.setDefaultEditor(Object.class, null);
		vozaciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(vozaciTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private void initActions() {
		
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = vozaciTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Vozac vozac = taksiSluzba.getVozacPoKorisnickomImenu(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete vozaca?", 
							korisnickoIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					
					if (izbor == JOptionPane.YES_OPTION) {
						vozac.setObrisan(true);
						tableModel.removeRow(red);
						taksiSluzba.snimiVozaca(Main.VOZACI_FAJL);
					}
				}
			}
		});
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VozaciDispecerForma vozaciDispecerForma = new VozaciDispecerForma(taksiSluzba, null);
				vozaciDispecerForma.setVisible(true);
			}
		});
		
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = vozaciTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Vozac vozac = taksiSluzba.getVozacPoKorisnickomImenu(korisnickoIme);
					if (vozac == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja dispecera sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						VozaciDispecerForma vozaciDispecerForma = new VozaciDispecerForma(taksiSluzba, vozac);
						vozaciDispecerForma.setVisible(true);	
					}
				}
			}
		});
		
		
	}
	
	

}