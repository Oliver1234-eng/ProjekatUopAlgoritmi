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

import automobilPaket.Automobil;
import guiPaket.FormeZaDodavanjeIIzmenu.AutomobiliDispecerForma;
import guiPaket.FormeZaDodavanjeIIzmenu.VoznjeDispecerForma;
import main.Main;
import taksiSluzbaPaket.TaksiSluzba;
import voznjaPaket.Voznja;

public class AutomobiliProzorDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDodaj = new JButton();
	private JButton btnIzmeni = new JButton();
	private JButton btnObrisi = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable automobiliTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public AutomobiliProzorDispecer(TaksiSluzba taksiSluzba) {
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
		add(mainToolbar, BorderLayout.EAST);
		
		String[] zaglavlje = new String[] {"ID Automobila", "Model", "Proizvodjac", "Vrsta automobila", "Godina proizvodnje", "Broj registarske oznake", "Broj taksi vozila", "Obrisan"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniAutomobili().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sviNeobrisaniAutomobili().size(); i++) {
			Automobil automobil = taksiSluzba.sviNeobrisaniAutomobili().get(i);
	
			sadrzaj[i][0] = automobil.getIdAutomobila();
			sadrzaj[i][1] = automobil.getModel();
			sadrzaj[i][2] = automobil.getProizvodjac();
			sadrzaj[i][3] = automobil.getVrstaAutomobila();
			sadrzaj[i][4] = automobil.getGodinaProizvodnje();
			sadrzaj[i][5] = automobil.getBrojRegistarskeOznake();
			sadrzaj[i][6] = automobil.getBrojTaksiVozila();
			sadrzaj[i][7] = automobil.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		automobiliTabela = new JTable(tableModel);
		
		automobiliTabela.setRowSelectionAllowed(true);
		automobiliTabela.setColumnSelectionAllowed(false);
		automobiliTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		automobiliTabela.setDefaultEditor(Object.class, null);
		automobiliTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(automobiliTabela);
		add(scrollPane, BorderLayout.CENTER);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(automobiliTabela.getModel());
        automobiliTabela.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(7, SortOrder.ASCENDING));
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
         
         automobiliTabela.setRowSorter(sorter);
         add(new JScrollPane(automobiliTabela), BorderLayout.CENTER);
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
		
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = automobiliTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String idAutomobilaString = tableModel.getValueAt(red, 0).toString();
					int idAutomobila = Integer.parseInt(idAutomobilaString);
					Automobil automobil = taksiSluzba.getAutomobilPoID(idAutomobila);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete ovaj automobil?", 
							idAutomobila + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					
					if (izbor == JOptionPane.YES_OPTION) {
						automobil.setObrisan(true);
						tableModel.removeRow(red);
						taksiSluzba.snimiAutomobil(Main.AUTOMOBILI_FAJL);
					}
				}
			}
		});
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AutomobiliDispecerForma automobiliDispecerForma = new AutomobiliDispecerForma(taksiSluzba, null);
				automobiliDispecerForma.setVisible(true);
			}
		});
		
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = automobiliTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String idAutomobilaString = tableModel.getValueAt(red, 0).toString();
					int idAutomobila = Integer.parseInt(idAutomobilaString);
					Automobil automobil = taksiSluzba.getAutomobilPoID(idAutomobila);
					if (automobil == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja automobila sa tim ID-om", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						AutomobiliDispecerForma automobiliDispecerForma = new AutomobiliDispecerForma(taksiSluzba, automobil);
						automobiliDispecerForma.setVisible(true);	
					}
				}
			}
		});
		
	}

}
