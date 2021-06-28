package guiPaket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;

public class LoginProzorVozac extends JFrame {
	
	private JLabel lblPozdrav = new JLabel("Dobrodosli. Molimo da se prijavite. VOZAC");
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime: ");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka: ");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnPrijaviSe = new JButton("Prijavi se");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
	
	public LoginProzorVozac(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
		setTitle("Prijava na sistem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGuiDispecer();
		initActionsDispecer();
		pack();
	}
	
	public void initGuiDispecer() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblPozdrav, "span 2");
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(pfLozinka);
		add(new JLabel());
		add(btnPrijaviSe, "split 2");
		add(btnNazad);
		
		txtKorisnickoIme.setText("TestVozac");
		pfLozinka.setText("testVozac123");
		
		getRootPane().setDefaultButton(btnPrijaviSe);
		
	}
	
	public void initActionsDispecer() {
		btnNazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzorVozac.this.dispose();
				LoginProzorVozac.this.setVisible(false);
			}
		});
		
		btnPrijaviSe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String lozinka = new String(pfLozinka.getPassword()).trim();
				
				if(korisnickoIme.equals("") || lozinka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);	
				} else {
					Vozac prijavljeniVozac = taksiSluzba.loginVozac(korisnickoIme, lozinka);
					if (prijavljeniVozac == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						LoginProzorVozac.this.dispose();
						LoginProzorVozac.this.setVisible(false);
						GlavniProzorVozac glavniProzorVozac = new GlavniProzorVozac(taksiSluzba, prijavljeniVozac);
						glavniProzorVozac.setVisible(true);
					}
				}
				
			}
			
		});	
		
	}

}
