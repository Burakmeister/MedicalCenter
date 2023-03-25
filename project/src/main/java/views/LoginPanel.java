package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.UserDao;
import mapped.User;

public class LoginPanel extends JPanel{
	
	private JButton logInButton = new JButton("Zaloguj"),
			registerButton= new JButton("Rejestracja");
	private JLabel nicknameText = new JLabel("Login:"),
			passwordText = new JLabel("Hasło:");
	private JTextField nicknameField = new JTextField(10);
	private JPasswordField passwordField = new JPasswordField(10);
	private Font font = new Font("TimesRoman", Font.BOLD, 50);
	
	private RegisterPanel registerPanel;
	
	public LoginPanel() {
		init();
		this.setBackground(new Color(50, 50, 150));
		setFocusable(true);
		requestFocus(); 
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(50,50,50,50);
		setLayout(layout);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(nicknameText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(passwordText, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(nicknameField, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(passwordField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(logInButton, gbc);
		
		gbc.insets = new Insets(0,50,50,50);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		add(registerButton, gbc);
	
	}
	
	private void init() {
		UserDao uDao = new UserDao();
		this.passwordField.setEditable(true);
		this.passwordField.setFont(font);
		this.nicknameField.setEditable(true);
		this.nicknameField.setFont(font);
		
		this.passwordText.setFont(font);
		this.passwordText.setForeground(Color.black);
		this.nicknameText.setFont(font);
		this.nicknameText.setForeground(Color.black);

		logInButton.setFont(font);
		logInButton.setBackground(Color.black);
		logInButton.setForeground(Color.WHITE);
		logInButton.addActionListener((e)->{
			User user = uDao.getUser(nicknameField.getText(), new String(passwordField.getPassword()));
			if(user!=null) {
				Main frame = (Main) (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (JComponent) e.getSource());
				frame.getContentPane().removeAll();
				switch(user.getAccessLevel()) {
				case 0:
					frame.getContentPane().add(new PatientPanel(this, user));
					break;
				default:
					frame.getContentPane().add(new AdministratorPanel());
					break;
				}
				frame.revalidate();
				frame.repaint();
			}else {
				JOptionPane.showMessageDialog(null, "Nieprawidłowe dane", "", JOptionPane.WARNING_MESSAGE);
			}
			this.passwordField.setText("");
			this.nicknameField.setText("");
		});
		
		registerButton.setFont(font);
		registerButton.setBackground(Color.black);
		registerButton.setForeground(Color.WHITE);
		registerButton.addActionListener((e)->{
			if(registerPanel == null)
				registerPanel = new RegisterPanel(this);
			Main frame = (Main) (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (JComponent) e.getSource());
			frame.getContentPane().removeAll();
			frame.getContentPane().add(registerPanel);
			frame.revalidate();
			frame.repaint();
		});
	}
}
