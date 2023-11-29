package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final String title = "Javalar";
	private static MainWindow instance;
	private GamePanel gamePanel;
	private ButtonPanel buttonPanel;

	private MainWindow() {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 700);
		this.setLocation(100, 50);
		this.setResizable(false);
		this.addPanels();
		this.setVisible(true);
	}

	public static MainWindow getInstance() {
		if(instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}
	private void addPanels() {
		JPanel contentPane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.8;
		c.weighty = 1.0;
		this.gamePanel = new GamePanel();
		contentPane.add(this.gamePanel, c);
		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 1;
		d.gridy = 0;
		d.weightx = 0.2;
		d.weighty = 1.0;
		this.buttonPanel = new ButtonPanel();
		contentPane.add(this.buttonPanel, d);
		this.setContentPane(contentPane);
	}

	public GamePanel getGamePanel() {
		return this.gamePanel;
	}

	public ButtonPanel getButtonPanel() {
		return this.buttonPanel;
	}
}
