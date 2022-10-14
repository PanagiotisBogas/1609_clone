package games.collect.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import games.collect.logic.Game_Collect;
import general.gui.GamePanel;
import gui.GUI;
import gui.GameOverPanel;


public class Panel_Collect extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Game_Collect game;
	
	public Panel_Collect(GUI gui) {
		super(gui, false);
		game = new Game_Collect(this);
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard6());
	}
	
	protected void keyLeft() {
		game.moveLeft();
	}

	protected void keyRight() {
		game.moveRight();
	}
	
	@Override
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "FINISH", lblScore.getText(), lblTime.getText()));
	}
	
	@Override
	public void win() {
		//No win.
	}
	
	@Override
	public void restart() {
		gui.setPanel(new Panel_Collect(gui));
	}
	
	@Override
	protected void addControls() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!game.isPause()) {
					if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
						keyLeft();
					}
					if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						keyRight();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					game.pause();
				}
			}
		});
	}
}