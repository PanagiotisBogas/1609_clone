package general.gui;

import javax.swing.JLabel;
import imageFactory.ImageFactory;
import javax.swing.JPanel;
import general.logic.Map;
import java.awt.Font;
import java.awt.GridLayout;


public abstract class GamePanel extends GeneralPanel{
	
	protected JLabel[][] matrix;
	protected JPanel panel;
	protected JLabel lblBg;
	protected JLabel lblTime;
	protected JLabel lblLevel;
	protected JLabel lblScore;
	protected Font fontLabels;
	protected JLabel lblKeyboard;
	protected JLabel lblMouse;
	
	public GamePanel(GUI gui, boolean isHorizontal) {
		super(gui);
		panel = new JPanel();		
		lblTime = new JLabel("Time: 00:00");
		lblLevel = new JLabel("Level: 00");
		lblScore = new JLabel("Score: 00000");
		lblBg = new JLabel("");
		lblKeyboard = new JLabel("");
		lblMouse = new JLabel("");
		
		if(isHorizontal)
			createHorizontal();
		else
			createVertical();
	}
		
	private void createHorizontal() {
		createCentralPanelHorizontal();
		createLabelsHorizontal();
	}
	
	private void createVertical() {
		createCentralPanelVertical();
		createLabelsVertical();
	}

	private void createLabelsVertical() {
		lblBg.setSize(gui.getImageFactory().getScreenResolution());
		lblBg.setLocation(0, 0);
		lblBg.setIcon(gui.getImageFactory().getMapVertical());
		add(lblBg);
		
		int x = (int) Math.round(160 * widthScaleFactor);
		int y = (int) Math.round(30 * heightScaleFactor);
		int w = (int) Math.round(500 * widthScaleFactor);
		int h = (int) Math.round(100 * heightScaleFactor);
		lblTime.setBounds(x,y,w,h);
		
		x = (int) Math.round(710 * widthScaleFactor);
		y = (int) Math.round(30 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblLevel.setBounds(x,y,w,h);
		
		x = (int) Math.round(1260 * widthScaleFactor);
		y = (int) Math.round(30 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblScore.setBounds(x,y,w,h);
		
		x = (int) Math.round((1920/2 - 775) * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(375 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblKeyboard.setBounds(x,y,w,h);
		
		x = (int) Math.round((1920/2 + 250) * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(102 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblMouse.setBounds(x,y,w,h);
		
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setFont(font.deriveFont(Math.round(80*widthScaleFactor)*1.0f));
		lblLevel.setFont(font.deriveFont(Math.round(80*widthScaleFactor)*1.0f));
		lblScore.setFont(font.deriveFont(Math.round(80*widthScaleFactor)*1.0f));
		lblTime.setForeground(gui.getImageFactory().getColorForeground());
		lblLevel.setForeground(gui.getImageFactory().getColorForeground());
		lblScore.setForeground(gui.getImageFactory().getColorForeground());
		add(lblTime);
		add(lblLevel);
		add(lblScore);
		add(lblKeyboard);
		add(lblMouse);
	}

	private void createCentralPanelVertical() {
		matrix = new JLabel[Map.COLUMN][Map.ROW];
		int cellWidth = gui.getImageFactory().getSquircle().getIconWidth();
		int cellHeight = gui.getImageFactory().getSquircle().getIconHeight();
		
		int x = (int) Math.round(((getWidth() - matrix[0].length * cellWidth) / 2));
		int y = (int) Math.round(((getHeight() - matrix.length * cellHeight) / 2));
		int w = (int) Math.round(matrix[0].length * cellWidth);
		int h = (int) Math.round(matrix.length * cellHeight);
		
		panel.setLayout(new GridLayout(Map.COLUMN, Map.ROW));
		panel.setBounds(x,y + cellHeight,w,h);
		panel.setBackground(gui.getImageFactory().getColorEmpty());
		
		add(panel);
		
		for(int r = matrix.length-1; r >= 0; r--) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new JLabel();
				matrix[r][c].setOpaque(true);
				panel.add(matrix[r][c]);
			}
	}


	
	private void createLabelsHorizontal() {
		lblBg.setSize(gui.getImageFactory().getScreenResolution());
		lblBg.setLocation(0, 0);
		lblBg.setIcon(gui.getImageFactory().getMapHorizontal());
		add(lblBg);
		
		int x = (int) Math.round(160 * widthScaleFactor);
		int y = (int) Math.round(30 * heightScaleFactor);
		int w = (int) Math.round(500 * widthScaleFactor);
		int h = (int) Math.round(100 * heightScaleFactor);
		lblTime.setBounds(x,y,w,h);
		
		x = (int) Math.round(710 * widthScaleFactor);
		y = (int) Math.round(30 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblLevel.setBounds(x,y,w,h);
		
		x = (int) Math.round(1260 * widthScaleFactor);
		y = (int) Math.round(30 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblScore.setBounds(x,y,w,h);
		
		x = (int) Math.round((1920 - 477)/2 * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(375 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblKeyboard.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920 - 477)/2 + 375) * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(102 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblMouse.setBounds(x,y,w,h);
		
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setFont(font.deriveFont(Math.round(80*widthScaleFactor)*1.0f));
		lblLevel.setFont(font.deriveFont(Math.round(80*widthScaleFactor)*1.0f));
		lblScore.setFont(font.deriveFont(Math.round(80*widthScaleFactor)*1.0f));
		lblTime.setForeground(gui.getImageFactory().getColorForeground());
		lblLevel.setForeground(gui.getImageFactory().getColorForeground());
		lblScore.setForeground(gui.getImageFactory().getColorForeground());
		add(lblTime);
		add(lblLevel);
		add(lblScore);
		add(lblKeyboard);
		add(lblMouse);
	}
	
	private void createCentralPanelHorizontal() {
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		int cellWidth = gui.getImageFactory().getSquircle().getIconWidth();
		int cellHeight = gui.getImageFactory().getSquircle().getIconHeight();
		
		int x = (int) Math.round(((getWidth() - matrix[0].length * cellWidth) / 2));
		int y = (int) Math.round(((getHeight() - matrix.length * cellHeight) / 2));
		int w = (int) Math.round(matrix[0].length * cellWidth);
		int h = (int) Math.round(matrix.length * cellHeight);
		
		panel.setLayout(new GridLayout(Map.ROW, Map.COLUMN));
		panel.setBounds(x,y,w,h);
		panel.setBackground(gui.getImageFactory().getColorEmpty());
		
		add(panel);
		
		for(int r = matrix.length-1; r >= 0; r--) 
			for(int c = 0; c < matrix[0].length; c++) {
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
	
	protected abstract void addControls();

	public abstract void lose();
	
	public abstract void win();
	
	public abstract void restart();
}
