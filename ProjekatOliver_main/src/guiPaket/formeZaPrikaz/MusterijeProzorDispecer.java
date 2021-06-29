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

import guiPaket.FormeZaDodavanjeIIzmenu.DispeceriDispecerForma;
import guiPaket.FormeZaDodavanjeIIzmenu.MusterijeDispecerForma;
import main.Main;
import osobePaket.Dispecer;
import osobePaket.Musterija;
import taksiSluzbaPaket.TaksiSluzba;

public class MusterijeProzorDispecer extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnDodaj = new JButton();
	private JButton btnIzmeni = new JButton();
	private JButton btnObrisi = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable musterijaTabela;
	
	private TaksiSluzba taksiSluzba;
	
	public MusterijeProzorDispecer(TaksiSluzba taksiSluzba) {
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
		add(mainToolbar, BorderLayout.EAST);
		
		String[] zaglavlje = new String[] {"Redni broj", "Korisnicko ime", "Lozinka", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj telefona", "Obrisan"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneMusterije().size()][zaglavlje.length];
		
		for (int i = 0; i < taksiSluzba.sveNeobrisaneMusterije().size(); i++) {
			Musterija musterija = taksiSluzba.sveNeobrisaneMusterije().get(i);
			sadrzaj[i][0] = musterija.getIdKorisnika();
			sadrzaj[i][1] = musterija.getKorisnickoIme();
			sadrzaj[i][2] = musterija.getLozinka();
			sadrzaj[i][3] = musterija.getIme();
			sadrzaj[i][4] = musterija.getPrezime();
			sadrzaj[i][5] = musterija.getJMBG();
			sadrzaj[i][6] = musterija.getAdresa();
			sadrzaj[i][7] = musterija.getPol();
			sadrzaj[i][8] = musterija.getBrojTelefona();
			sadrzaj[i][9] = musterija.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		musterijaTabela = new JTable(tableModel);
		
		musterijaTabela.setRowSelectionAllowed(true);
		musterijaTabela.setColumnSelectionAllowed(false);
		musterijaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijaTabela.setDefaultEditor(Object.class, null);
		musterijaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(musterijaTabela);
		add(scrollPane, BorderLayout.CENTER);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(musterijaTabela.getModel());
        musterijaTabela.setRowSorter(sorter);

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
         
         musterijaTabela.setRowSorter(sorter);
         add(new JScrollPane(musterijaTabela), BorderLayout.CENTER);
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
				int red = musterijaTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Musterija musterija = taksiSluzba.getMusterijaPoKorisnickomImenu(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete musteriju?", 
							korisnickoIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					
					if (izbor == JOptionPane.YES_OPTION) {
						musterija.setObrisan(true);
						tableModel.removeRow(red);
						taksiSluzba.snimiMusteriju(Main.MUSTERIJE_FAJL);
					}
					
				}
			}
		});
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijeDispecerForma musterijeDispecerForma = new MusterijeDispecerForma(taksiSluzba, null);
				musterijeDispecerForma.setVisible(true);
			}
		});
		
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = musterijaTabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Musterija musterija = taksiSluzba.getMusterijaPoKorisnickomImenu(korisnickoIme);
					if (musterija == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja musterije sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						MusterijeDispecerForma musterijeDispecerForma = new MusterijeDispecerForma(taksiSluzba, musterija);
						musterijeDispecerForma.setVisible(true);	
					}
				}
			}
		});
		
	}

}
