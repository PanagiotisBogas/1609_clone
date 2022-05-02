package general.gui;

import javax.swing.JLabel;

import imageFactory.DarkImageFactory;
import imageFactory.ImageFactory;

import javax.swing.JPanel;

import general.logic.Map;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


public abstract class GeneralGamePanel extends GeneralPanel{
	
	private JLabel[][] matrix;
	private JPanel panel;
	private JLabel lblBg;
	protected JLabel lblTime;
	protected JLabel lblLevel;
	protected JLabel lblScore;
	private Font fontLabels;
	protected JLabel lblKeyboard;
	protected JLabel lblMouse;
	
	public GeneralGamePanel(GUI gui) {
		super(gui);
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		panel = new JPanel();		
		lblTime = new JLabel("Time: 00:00");
		lblLevel = new JLabel("Level: 00");
		lblScore = new JLabel("Score: 00000");
		lblBg = new JLabel("");
		lblKeyboard = new JLabel("");
		lblMouse = new JLabel("");
		
		
		createCentralPanel();
		createLabels();
	}
	
	private void createLabels() {
		lblBg.setSize(gui.getImageFactory().getScreenResolution());
		lblBg.setLocation(0, 0);
		lblBg.setIcon(gui.getImageFactory().getMap());
		add(lblBg);
		
		if(gui.getImageFactory().getScreenResolution().getWidth() == ImageFactory.DEFAULT_WIDTH) {
			lblTime.setBounds(160, 30, 500, 100);
			lblLevel.setBounds(710, 30, 500, 100);
			lblScore.setBounds(1260, 30, 500, 100);
			lblKeyboard.setBounds((1920-488)/2, 1080 - 180, 375, 150);
			lblMouse.setBounds((1920-488)/2 + 375, 1080 - 180, 113, 150);
			fontLabels = font.deriveFont(81f);
		}
		else {
			lblTime.setBounds(107, 20, 333, 66);
			lblLevel.setBounds(474, 20, 333, 66);
			lblScore.setBounds(841, 20, 333, 66);
			lblKeyboard.setBounds((1280-325)/2 -5, 720 - 105, 250, 100);
			lblMouse.setBounds((1280-325)/2 + 250 +5, 720 - 105, 75, 100);
			fontLabels = font.deriveFont(54f);
		}
		
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setFont(fontLabels);
		lblLevel.setFont(fontLabels);
		lblScore.setFont(fontLabels);
		lblTime.setForeground(gui.getImageFactory().getForegroundColor());
		lblLevel.setForeground(gui.getImageFactory().getForegroundColor());
		lblScore.setForeground(gui.getImageFactory().getForegroundColor());
		add(lblTime);
		add(lblLevel);
		add(lblScore);
		add(lblKeyboard);
		add(lblMouse);
	}
	
	private void createCentralPanel() {
		
		int width = (int) gui.getImageFactory().getScreenResolution().getWidth();
		int height = (int) gui.getImageFactory().getScreenResolution().getHeight();
		int panelWidth = (int) 800;
		int panelHeight = (int) 450;
		
		panel.setLayout(new GridLayout(Map.ROW, Map.COLUMN));
		panel.setSize(panelWidth, panelHeight);
		panel.setLocation((int)(width-panelWidth)/2, (int) (height-panelHeight)/2);
		panel.setBackground(gui.getImageFactory().getEmptyColor());
		add(panel);
		
		for(int r = Map.ROW-1; r >= 0; r--) 
			for(int c = 0; c < Map.COLUMN; c++) {
				matrix[r][c] = new JLabel();
				matrix[r][c].setOpaque(true);
				panel.add(matrix[r][c]);
			}
	}

	public void setPoints(String score) {
		lblScore.setText("Score: " + score);	
	}

	public void setTime(String time) {
		lblTime.setText("Time: " + time);
	}

	public void setLevel(String level) {
		lblLevel.setText("Level: " + level);
	}

	public void changeCell(JLabel graphicCell, int row, int column) {
		matrix[row][column].setIcon(graphicCell.getIcon());
		matrix[row][column].setBackground(graphicCell.getBackground());
	}

	public ImageFactory getImageFactory() {
		return gui.getImageFactory();
	}

	public abstract void lose();
	
	public abstract void win();
	
	public abstract void restart();
}
