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

import guiPaket.FormeZaDodavanjeIIzmenu.DodeljivanjeVoznjeVozacuUlogaDispecerForma;
import guiPaket.FormeZaDodavanjeIIzmenu.PrihvatanjeOdbijanjeVoznjeUlogaVozacForma;
import taksiSluzbaPaket.TaksiSluzba;
import voznjaPaket.Voznja;

public class PrihvatanjeOdbijanjeVoznjeUlogaVozac extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnIzmeni = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable voznjeTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public PrihvatanjeOdbijanjeVoznjeUlogaVozac(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Voznje");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	private void initGUI() {
		
		ImageIcon izmeni = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnIzmeni.setIcon(izmeni);
		
		mainToolbar.add(btnIzmeni);
		add(mainToolbar, BorderLayout.EAST);
		
		String[] zaglavlje = new String[] {"ID Voznje", "Datum i vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Ime musterije", "Ime vozaca", "Broj predjenih kilometara", "Trajanje voznje", "Status voznje", "Obrisan"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveDodeljeneVoznje().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sveDodeljeneVoznje().size(); i++) {
			Voznja voznja = taksiSluzba.sveDodeljeneVoznje().get(i);
	
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
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(voznjeTabela.getModel());
        voznjeTabela.setRowSorter(sorter);

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
         
         voznjeTabela.setRowSorter(sorter);
         add(new JScrollPane(voznjeTabela), BorderLayout.CENTER);
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
		
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = voznjeTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String idVoznjeString = tableModel.getValueAt(red, 0).toString();
					int idVoznje = Integer.parseInt(idVoznjeString);
					Voznja voznja = taksiSluzba.getVoznjaPoId(idVoznje);
					if (voznja == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja voznje sa tim ID-om", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						PrihvatanjeOdbijanjeVoznjeUlogaVozacForma prihvatanjeOdbijanjeVoznjeUlogaVozacForma = new PrihvatanjeOdbijanjeVoznjeUlogaVozacForma(taksiSluzba, voznja);
						prihvatanjeOdbijanjeVoznjeUlogaVozacForma.setVisible(true);
					}
				}
			}
		});
		
	}

}
