package models;

import javax.swing.JFrame;

public class MaFenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaFenetre() {

		this.setSize(800,800);
		this.setLocation(300, 0);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("EVITATOR D'ASTEROÏDES 3000");
		this.setVisible(true);
		
	}

}
