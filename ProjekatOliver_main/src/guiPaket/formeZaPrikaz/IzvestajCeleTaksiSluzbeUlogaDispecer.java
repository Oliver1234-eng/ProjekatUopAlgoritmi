package guiPaket.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import guiPaket.FormeZaDodavanjeIIzmenu.DnevniIzvestajiUlogaDispecer;
import guiPaket.FormeZaDodavanjeIIzmenu.MesecniIzvestajiUlogaDispecer;
import guiPaket.FormeZaDodavanjeIIzmenu.NedeljniIzvestajiUlogaDispecer;
import taksiSluzbaPaket.TaksiSluzba;

public class IzvestajCeleTaksiSluzbeUlogaDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDnevniIzvestaj = new JButton("Dnevni izvestaji");
	private JButton btnNedeljniIzvestaj = new JButton("Nedeljni izvestaji");
	private JButton btnMesecniIzvestaj = new JButton("Mesecni izvestaji");
	
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
		mainToolbar.add(btnNedeljniIzvestaj);
		mainToolbar.add(btnMesecniIzvestaj);
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
		
		btnDnevniIzvestaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DnevniIzvestajiUlogaDispecer dnevniIzvestajiUlogaDispecer = new DnevniIzvestajiUlogaDispecer(taksiSluzba, null);
				dnevniIzvestajiUlogaDispecer.setVisible(true);
			}
		});
		
		btnNedeljniIzvestaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				NedeljniIzvestajiUlogaDispecer nedeljniIzvestajiUlogaDispecer = new NedeljniIzvestajiUlogaDispecer(taksiSluzba, null);
				nedeljniIzvestajiUlogaDispecer.setVisible(true);
			}
		});
		
		btnMesecniIzvestaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MesecniIzvestajiUlogaDispecer mesecniIzvestajiUlogaDispecer = new MesecniIzvestajiUlogaDispecer(taksiSluzba, null);
				mesecniIzvestajiUlogaDispecer.setVisible(true);
			}
		});
	}

}
