package guiPaket.formeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import taksiSluzbaPaket.TaksiSluzba;

public class IzvestajCeleTaksiSluzbeUlogaDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDnevniIzvestaj = new JButton("Dodaj");
	private JButton btnMesecniIzvestaj = new JButton("Izmeni");
	private JButton btnGodisnjiIzvestaj = new JButton("Obrisi");
	
	private DefaultTableModel tableModel;
	private JTable ceoIzvestajTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public IzvestajCeleTaksiSluzbeUlogaDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Godisnji izvestaj");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	private void initGUI() {
		
		mainToolbar.add(btnDnevniIzvestaj);
		mainToolbar.add(btnMesecniIzvestaj);
		mainToolbar.add(btnGodisnjiIzvestaj);
		add(mainToolbar, BorderLayout.NORTH);
		
		String zaglavlje[] = {"Ukupan broj voznji", "Broj voznji narucenih putem telefona", "Broj aktivnih vozaca", "Prosecno trajanje voznje", "Prosecan broj km", "Sveukupna zarada", "Prosecna zarada po voznji"};
		Object sadrzaj[][] = {{"8", "8", "3", "50.25 min", "51.25 km", "83.600 din", "10.450 din"}};
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		ceoIzvestajTabela = new JTable(tableModel);
		
		ceoIzvestajTabela.setRowSelectionAllowed(true);
		ceoIzvestajTabela.setColumnSelectionAllowed(false);
		ceoIzvestajTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ceoIzvestajTabela.setDefaultEditor(Object.class, null);
		ceoIzvestajTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(ceoIzvestajTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	private void initActions() {
		
	}

}
