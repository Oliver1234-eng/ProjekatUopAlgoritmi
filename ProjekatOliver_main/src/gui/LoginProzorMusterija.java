package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import taksiSluzba.TaksiSluzba;

public class LoginProzorMusterija extends JFrame {
	
	private JLabel lblPozdrav = new JLabel("Dobrodosli. Molimo da se prijavite. MUSTERIJA");
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime: ");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka: ");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnPrijaviSe = new JButton("Prijavi se");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
	
	public LoginProzorMusterija(TaksiSluzba taksiSluzba) {
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
		
		txtKorisnickoIme.setText("TestMusterija");
		pfLozinka.setText("testMusterija123");
		
		getRootPane().setDefaultButton(btnPrijaviSe);
		
	}
	
	public void initActionsDispecer() {
		btnNazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzorMusterija.this.dispose();
				LoginProzorMusterija.this.setVisible(false);
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
					Musterija prijavljenaMusterija = taksiSluzba.loginMusterija(korisnickoIme, lozinka);
					if (prijavljenaMusterija == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						LoginProzorMusterija.this.dispose();
						LoginProzorMusterija.this.setVisible(false);
						GlavniProzorMusterija glavniProzorMusterija = new GlavniProzorMusterija(taksiSluzba, prijavljenaMusterija);
						glavniProzorMusterija.setVisible(true);
					}
				}
				
			}
			
		});	
		
	}

}