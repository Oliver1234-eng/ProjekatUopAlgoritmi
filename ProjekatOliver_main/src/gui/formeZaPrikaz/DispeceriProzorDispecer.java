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

import gui.FormeZaDodavanjeIIzmenu.DispeceriDispecerForma;
import main.Main;
import osobe.Dispecer;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;

public class DispeceriProzorDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDodaj = new JButton();
	private JButton btnIzmeni = new JButton();
	private JButton btnObrisi = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable dispeceriTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public DispeceriProzorDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Dispeceri");
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
		
		String[] zaglavlje = new String[] {"Redni broj", "Korisnicko ime", "Lozinka", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj telefona", "Obrisan", "Plata", "Broj telefonske linije", "Odeljenje"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniDispeceri().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sviNeobrisaniDispeceri().size(); i++) {
			Dispecer dispecer = taksiSluzba.sviNeobrisaniDispeceri().get(i);
			sadrzaj[i][0] = dispecer.getRedniBrojKorisnika();
			sadrzaj[i][1] = dispecer.getKorisnickoIme();
			sadrzaj[i][2] = dispecer.getLozinka();
			sadrzaj[i][3] = dispecer.getIme();
			sadrzaj[i][4] = dispecer.getPrezime();
			sadrzaj[i][5] = dispecer.getJMBG();
			sadrzaj[i][6] = dispecer.getAdresa();
			sadrzaj[i][7] = dispecer.getPol();
			sadrzaj[i][8] = dispecer.getBrojTelefona();
			sadrzaj[i][9] = dispecer.isObrisan();
			sadrzaj[i][10] = dispecer.getPlata();
			sadrzaj[i][11] = dispecer.getBrojTelefonskeLinije();
			sadrzaj[i][12] = dispecer.getOdeljenjeDispecer();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		dispeceriTabela = new JTable(tableModel);
		
		dispeceriTabela.setRowSelectionAllowed(true);
		dispeceriTabela.setColumnSelectionAllowed(false);
		dispeceriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dispeceriTabela.setDefaultEditor(Object.class, null);
		dispeceriTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(dispeceriTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private void initActions() {

		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = dispeceriTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Dispecer dispecer = taksiSluzba.getDispecerPoKorisnickomImenu(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete dispecera?", 
							korisnickoIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					
					if (izbor == JOptionPane.YES_OPTION) {
						dispecer.setObrisan(true);
						tableModel.removeRow(red);
						taksiSluzba.snimiDispecera(Main.DISPECERI_FAJL);
					}
					
				}
			}
		});
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DispeceriDispecerForma dispeceriDispecerForma = new DispeceriDispecerForma(taksiSluzba, null);
				dispeceriDispecerForma.setVisible(true);
			}
		});
		
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = dispeceriTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Dispecer dispecer = taksiSluzba.getDispecerPoKorisnickomImenu(korisnickoIme);
					if (dispecer == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja dispecera sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						DispeceriDispecerForma dispeceriDispecerForma = new DispeceriDispecerForma(taksiSluzba, dispecer);
						dispeceriDispecerForma.setVisible(true);	
					}
				}
			}
		});
		
		
	}

}
