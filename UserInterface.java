import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class UserInterface extends JFrame implements ActionListener {
	private String textToShow;
	private JTextArea txaWords;
	
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miExit);
		JMenuItem miInfo = new JMenuItem("Info");
		miInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				JOptionPane.showMessageDialog(null,"Payton Dwyer");
				}
			});
		mnuHelp.add(miInfo);
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	
	public UserInterface() {
		setTitle("Web Scraper");
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panNorth = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Enter URL:");
		JTextField txtTextToAdd = new JTextField(20);
		JButton btnFetch = new JButton("Fetch");
		panNorth.add(label);
		panNorth.add(txtTextToAdd);
		panNorth.add(btnFetch);
		c.add(panNorth,BorderLayout.NORTH);
		JPanel panSouth = new JPanel(new FlowLayout());
		JButton btnSaveToText = new JButton("Save to text");
		JButton btnSaveToJson = new JButton("Save to json");
		panSouth.add(btnSaveToText);
		panSouth.add(btnSaveToJson);
		c.add(panSouth,BorderLayout.SOUTH);
		JPanel panCenter = new JPanel(new FlowLayout());
		JTextArea txaWords = new JTextArea();
		txaWords.setEditable(false);
		c.add(txaWords,BorderLayout.CENTER);
		setupMenu();
	}
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.setVisible(true);
	}

	public void actionPerformed(ActionEvent o) {
	}
}
