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
import osobePaket.Dispecer;
import osobePaket.Musterija;
import osobePaket.Vozac;
import taksiSluzbaPaket.TaksiSluzba;

public class LoginProzorDispecer extends JFrame {
	
	private JLabel lblPozdrav = new JLabel("Dobrodosli. Molimo da se prijavite. DISPECER");
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime: ");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka: ");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnPrijaviSe = new JButton("Prijavi se");
	private JButton btnNazad = new JButton("Nazad");
	
	private TaksiSluzba taksiSluzba;
//	private Musterija imeMusterije;
//	private Vozac imeVozaca;
	
	public LoginProzorDispecer(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
//		this.imeMusterije = imeMusterije;
//		this.imeVozaca = imeVozaca;
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
		
		txtKorisnickoIme.setText("TestDispecer");
		pfLozinka.setText("testDispecer123");
		
		getRootPane().setDefaultButton(btnPrijaviSe);
		
	}
	
	public void initActionsDispecer() {
		btnNazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzorDispecer.this.dispose();
				LoginProzorDispecer.this.setVisible(false);
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
					Dispecer prijavljeniDispecer = taksiSluzba.loginDispecer(korisnickoIme, lozinka);
					if (prijavljeniDispecer == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						LoginProzorDispecer.this.dispose();
						LoginProzorDispecer.this.setVisible(false);
						GlavniProzorDispecer glavniProzorDispecer = new GlavniProzorDispecer(taksiSluzba, prijavljeniDispecer);
						glavniProzorDispecer.setVisible(true);
					}
				}
				
			}
			
		});	
		
	}
	

}