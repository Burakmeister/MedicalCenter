package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.ResearchDao;
import mapped.Research;

public class ResearchCreatePanel extends JPanel{
	
	private JPanel prevPanel;
	
	private JTextArea descriptionArea = new JTextArea(10, 50);
	private JTextField titleField = new JTextField(20);
	private JLabel titleText = new JLabel("Tytuł:"), 
			descriptionText = new JLabel("Opis:");
	private JButton returnButton = new JButton("Cofnij"),
			saveButton = new JButton("Zapisz");
	
	private Font font = new Font("TimesRoman", Font.BOLD, 50);
	private Font descFont = new Font("TimesRoman", Font.BOLD, 25);
	
	public ResearchCreatePanel(JPanel panel) {
		this.prevPanel = panel;
		this.setBackground(new Color(50, 50, 150));
		setFocusable(true);
		requestFocus(); 
		init();
		initComposition();
		initListeners();
	}

	private void initListeners() {
		this.returnButton.addActionListener((e)->{
			Main frame = (Main) (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (JComponent) e.getSource());
			frame.getContentPane().removeAll();
			frame.getContentPane().add(this.prevPanel);
			frame.revalidate();
			frame.repaint();
			if(this.prevPanel instanceof AdministratorPanel) {
				AdministratorPanel panel = (AdministratorPanel) prevPanel;
				panel.setProjectsList();
			}
		});
		this.saveButton.addActionListener((e)->{
			ResearchDao rDao = new ResearchDao();
			if(!"".equals(titleField.getText())){
				if(rDao.getAll().contains(new Research(titleField.getText()))) {
					JOptionPane.showMessageDialog(null, "Istnieje już projekt o podanej nazwie", "", JOptionPane.WARNING_MESSAGE);
				}else {
					if(!"".equals(this.descriptionArea.getText())) {
						rDao.create(new Research(this.titleField.getText(), this.descriptionArea.getText()));
					}else {
						rDao.create(new Research(this.titleField.getText()));
					}
					JOptionPane.showMessageDialog(null, "Dodano projekt", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Projekt musi zawierać nazwę", "", JOptionPane.WARNING_MESSAGE);
			}
		});
	}

	private void initComposition() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(layout);
		
		gbc.insets = new Insets(50,0,50,50);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(this.titleText, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(this.titleField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(this.descriptionText, gbc);

		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(this.descriptionArea, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		add(this.saveButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(this.returnButton, gbc);
	}

	private void init() {
		this.descriptionArea.setBackground(Color.white);
		this.descriptionArea.setForeground(Color.black);
		this.descriptionArea.setFont(descFont);
		this.descriptionArea.setLineWrap(true);
		this.descriptionArea.setWrapStyleWord(true);
		
		this.saveButton.setBackground(Color.black);
		this.saveButton.setForeground(Color.white);
		this.saveButton.setFont(font);
		
		this.returnButton.setBackground(Color.black);
		this.returnButton.setForeground(Color.white);
		this.returnButton.setFont(font);
		
		this.titleField.setFont(font);
		this.titleField.setBackground(Color.white);
		this.titleField.setForeground(Color.black);
		
		this.titleText.setFont(font);
		this.titleText.setForeground(Color.black);
		
		this.descriptionText.setFont(font);
		this.descriptionText.setForeground(Color.black);
	}

}
