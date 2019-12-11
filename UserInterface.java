import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 * This class models the data taken from the website.
 * It includes private data, getters and setters, constructors both default and non default,
 * and also a toString function.
 * @author Payton Dwyer
 *
 */

class ReefFish {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ReefFish() {
		name = "";
	}
	public ReefFish(String name) {
		setName(name);
	}
	@Override
	public String toString() {
		return String.format("%s" + "\n", name);
	}
}

/**
 * This class serves as the main model that for the User Interface.
 * It has private data members and includes action listeners for components that rely on user interaction.  
 * @author Payton Dwyer
 *
 */

public class UserInterface extends JFrame {
	private String textToShow;
	private JTextArea txaWords;
	private ArrayList<ReefFish> Fish;
	
	/**
	 * This function sets up the menu bar at the top of the user interface.
	 * It includes a File option with an exit option as well as a help option with a message about the author.
	 * It responds to the user clicking the various options.
	 */
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
				JOptionPane.showMessageDialog(null,"Author: Payton Dwyer");
				}
			});
		mnuHelp.add(miInfo);
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	
	
	/**
	 * This function sets up the main part of the User Interface.
	 * It sets a title and bounds for the User Interface. 
	 * It includes action listeners for the various buttons that the user can use.
	 * The fetch button links to the SiteScraper class to fetch the information from the site.
	 * The file choosers are also included so the user can name the file they wish to export to.
	 */
	public UserInterface() {
		setTitle("Web Scraper");
		this.Fish = Fish;
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panNorth = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Enter URL:");
		JTextField UrlToFetch = new JTextField(30);
		JTextArea txaWords = new JTextArea();
		txaWords.setEditable(false);
		JButton btnFetch = new JButton("Fetch");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ReefFish> Fish = SiteScraper.Scraper(UrlToFetch.getText());
				for (ReefFish r : Fish) {
					textToShow = textToShow + r.toString();
				}
				txaWords.setText(textToShow);
				System.out.print(textToShow);
			}
		});
		JPanel panSouth = new JPanel(new FlowLayout());
		JButton btnSaveToText = new JButton("Save to text");
		btnSaveToText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser(new File("c:\\"));
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						if (FishWriter.writeFishToTextFile(jfc.getSelectedFile(),Fish)) {
						JOptionPane.showMessageDialog(null, "List of Fish saved!");
						} else {
						JOptionPane.showMessageDialog(null, "List of Fish was not saved.");
					}
				}	
				} catch (Exception ex) {
					System.out.println("Could not save the file");
				}
			}
		});
		JButton btnSaveToJson = new JButton("Save to json");
		btnSaveToJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser(new File("c:\\"));
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						if (FishWriter.writeAssessmentsToJSON(jfc.getSelectedFile(), Fish)) {
						JOptionPane.showMessageDialog(null, "List of Fish saved to JSON!");
					} else {
						JOptionPane.showMessageDialog(null, "List of Fish was not saved.");
					}
				}	
				} catch (Exception ex) {
					System.out.println("Could not save the file");
				}
			}
		});
		panNorth.add(label);
		panNorth.add(UrlToFetch);
		panNorth.add(btnFetch);
		c.add(panNorth,BorderLayout.NORTH);
		panSouth.add(btnSaveToText);
		panSouth.add(btnSaveToJson);
		c.add(panSouth,BorderLayout.SOUTH);
		c.add(txaWords,BorderLayout.CENTER);
		setupMenu();
	}
	
	/**
	 * Main body of the application that will launch the user interface and show it to the screen.
	 * @param args
	 */
	
	public static void main(String[] args) {
		ArrayList<ReefFish> Fish = new ArrayList<ReefFish>();
		UserInterface UI = new UserInterface();
		UI.setVisible(true);
			
	}
}
