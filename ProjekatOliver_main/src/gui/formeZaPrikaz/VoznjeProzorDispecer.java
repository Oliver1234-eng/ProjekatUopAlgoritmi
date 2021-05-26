package gui.formeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import osobe.Musterija;
import osobe.Vozac;
import taksiSluzba.TaksiSluzba;
import voznja.Voznja;

public class VoznjeProzorDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDodaj = new JButton();
	private JButton btnIzmeni = new JButton();
	private JButton btnObrisi = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable voznjeTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public VoznjeProzorDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Voznje");
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
		
		String[] zaglavlje = new String[] {"ID Voznje", "Datum i vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Ime musterije", "Ime vozaca", "Broj predjenih kilometara", "Trajanje voznje", "Status voznje", "Obrisan"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneVoznje().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sveNeobrisaneVoznje().size(); i++) {
			Voznja voznja = taksiSluzba.sveNeobrisaneVoznje().get(i);
	
			sadrzaj[i][0] = voznja.getIdVoznje();
			sadrzaj[i][1] = voznja.getDatumIVremePorudzbine();
			sadrzaj[i][2] = voznja.getAdresaPolaska();
			sadrzaj[i][3] = voznja.getAdresaDestinacije();
			
			if(voznja.getImeMusterije() != null) {
				sadrzaj[i][4] = voznja.getImeMusterije().getKorisnickoIme();
			} else {
				sadrzaj[i][4] = "";
			}
			
			if(voznja.getImeVozaca() != null) {
				sadrzaj[i][5] = voznja.getImeVozaca().getKorisnickoIme();
			} else {
				sadrzaj[i][5] = "";
			}
			
			sadrzaj[i][6] = voznja.getBrojPredjenihKilometara();
			sadrzaj[i][7] = voznja.getTrajanjeVoznje();
			sadrzaj[i][8] = voznja.getStatusVoznje();
			sadrzaj[i][9] = voznja.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		voznjeTabela = new JTable(tableModel);
		
		voznjeTabela.setRowSelectionAllowed(true);
		voznjeTabela.setColumnSelectionAllowed(false);
		voznjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		voznjeTabela.setDefaultEditor(Object.class, null);
		voznjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(voznjeTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private void initActions() {
		
		
	}
	
	
}