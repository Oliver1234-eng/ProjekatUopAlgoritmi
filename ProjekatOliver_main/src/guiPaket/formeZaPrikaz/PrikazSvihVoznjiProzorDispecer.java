package guiPaket.formeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import taksiSluzbaPaket.TaksiSluzba;
import voznjaPaket.Voznja;

public class PrikazSvihVoznjiProzorDispecer extends JFrame {
	
//	private JToolBar mainToolbar = new JToolBar();
	
	private DefaultTableModel tableModel;
	private JTable prikazVoznjiTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public PrikazSvihVoznjiProzorDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Prikaz svih voznji");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	private void initGUI() {
		
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
		prikazVoznjiTabela = new JTable(tableModel);
		
		prikazVoznjiTabela.setRowSelectionAllowed(true);
		prikazVoznjiTabela.setColumnSelectionAllowed(false);
		prikazVoznjiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prikazVoznjiTabela.setDefaultEditor(Object.class, null);
		prikazVoznjiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(prikazVoznjiTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private void initActions() {
		
	}

}
