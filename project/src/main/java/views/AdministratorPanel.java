package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import dao.PatientDao;
import dao.ResearchDao;
import mapped.Patient;
import mapped.Research;
import mapped.User;

public class AdministratorPanel extends JPanel{
	private User user;
	private LoginPanel loginPanel;
	
	private JList<Research> researchesJList;
	private JList<Patient> patientsJList;
	private DefaultListModel<Patient> patients = new DefaultListModel<>();
	private DefaultListModel<Research> researches = new DefaultListModel<>();
	
	private JTextArea descriptionArea = new JTextArea(10, 50);
	
	private JButton patientDetailsButton = new JButton("Szczegóły pacjenta"),
			saveButton = new JButton("Zapisz opis"),
			returnButton = new JButton("Wyloguj"),
			referralButton = new JButton("Wystaw skierowanie");
	
	private Font font = new Font("TimesRoman", Font.BOLD, 50);
	private Font descFont = new Font("TimesRoman", Font.BOLD, 25);

	
	public AdministratorPanel(LoginPanel loginPanel, User user) {
		this.user = user;
		this.loginPanel = loginPanel;
		ResearchDao rDao = new ResearchDao();
		for(Research res : rDao.getAll()) {
			this.researches.addElement(res);
		}
	    this.researchesJList = new JList<>(this.researches);
	    this.patientsJList = new JList<>(this.patients);
	    	    	    
		this.setBackground(new Color(50, 50, 150));
		setFocusable(true);
		requestFocus(); 
		init();
		initComposition();
	}
	
	private void initComposition() {
		this.researchesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.researchesJList.setFont(font);
		this.researchesJList.setBackground(Color.BLACK);
		this.researchesJList.setForeground(Color.white);
		this.researchesJList.addListSelectionListener((e)->{
			this.descriptionArea.setText(this.researches.get(this.researchesJList.getSelectedIndex()).getDescription());
			this.patients.removeAllElements();
			PatientDao dao = new PatientDao();
			this.patients.addAll(
					dao.getPatientsByResearchTitle(
							this.researches.get(this.researchesJList.getSelectedIndex()).toString()
							));
		});
		
		this.patientsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.patientsJList.setFont(font);
		this.patientsJList.setBackground(Color.BLACK);
		this.patientsJList.setForeground(Color.white);
		
		this.descriptionArea.setBackground(Color.white);
		this.descriptionArea.setForeground(Color.black);
		this.descriptionArea.setFont(descFont);
		this.descriptionArea.setLineWrap(true);
		this.descriptionArea.setWrapStyleWord(true);
	}

	private void init() {
		JScrollPane scrollPanel = new JScrollPane();
	    scrollPanel.setViewportView(this.researchesJList);
	    this.researchesJList.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scrollPane11 = new JScrollPane();
		scrollPane11.setViewportView(this.patientsJList);
	    this.patientsJList.setLayoutOrientation(JList.VERTICAL);
	      
	    scrollPanel.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().width/2.5), 
	    		Toolkit.getDefaultToolkit().getScreenSize().height/2));
	    scrollPane11.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().width/2.5), 
	    		Toolkit.getDefaultToolkit().getScreenSize().height/2));
	    
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(layout);
		gbc.insets = new Insets(50,50,50,50);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(scrollPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		add(this.descriptionArea, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(scrollPane11, gbc);
	}
}
