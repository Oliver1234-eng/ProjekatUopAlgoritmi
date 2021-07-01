package guiPaket.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import guiPaket.FormeZaDodavanjeIIzmenu.AukcijaUlogaDispecerForma;
import guiPaket.FormeZaDodavanjeIIzmenu.VozaciDispecerForma;
import main.Main;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;

public class AukcijaUlogaDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnVozac = new JButton("Info o vozacima");
	
	private DefaultTableModel tableModel;
	private JTable vozaciTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public AukcijaUlogaDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Vozaci");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	private void initGUI() {
		
		mainToolbar.add(btnVozac);
		add(mainToolbar, BorderLayout.EAST);
		
		String[] zaglavlje = new String[] {"Redni broj", "Korisnicko ime", "Lozinka", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj telefona", "Obrisan", "Plata", "Broj clanske karte", "Automobil"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniVozaci().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sviNeobrisaniVozaci().size(); i++) {
			Vozac vozac = taksiSluzba.sviNeobrisaniVozaci().get(i);
//			Automobil auto = vozac.getAutomobil();
//			String idAutomobilaVozaca = auto.getIdAutomobila();
			
			sadrzaj[i][0] = vozac.getIdKorisnika();
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
		
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(vozaciTabela.getModel());
        vozaciTabela.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(7, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(8, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(9, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(10, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(11, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(12, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        
        tableModel = new DefaultTableModel(sadrzaj, zaglavlje) {
        	
        public Class getColumnClass(int column) {
               Class returnValue;
               if((column >= 0) && (column < getColumnCount())) {
                  returnValue = getValueAt(0, column).getClass();
               } else {
                  returnValue = Object.class;
               }
               return returnValue;
            }
         };
         
         vozaciTabela.setRowSorter(sorter);
         add(new JScrollPane(vozaciTabela), BorderLayout.CENTER);
         JPanel panel = new JPanel(new BorderLayout());
         JLabel label = new JLabel("Kombinovana pretraga (po bilo cemu): ");
         panel.add(label, BorderLayout.WEST);
         final JTextField filterText = new JTextField("");
         panel.add(filterText, BorderLayout.CENTER);
         add(panel, BorderLayout.NORTH);
         JButton button = new JButton("Pretrazi");
         button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String text = filterText.getText();
               if(text.length() == 0) {
                  sorter.setRowFilter(null);
               } else {
                  try {
                     sorter.setRowFilter(RowFilter.regexFilter(text));
                  } catch(PatternSyntaxException pse) {
                        System.out.println("Bad regex pattern");
                  }
                }
            }
         });
         add(button, BorderLayout.SOUTH);
         setSize(400, 300);
         setLocationRelativeTo(null);
         setVisible(true);
		
	}
	
	private void initActions() {
			
		btnVozac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AukcijaUlogaDispecerForma aukcijaUlogaDispecerForma = new AukcijaUlogaDispecerForma(taksiSluzba, null);
				aukcijaUlogaDispecerForma.setVisible(true);
			}
		});
		
		
		
	}
	
	

}
