import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GameGUI extends JFrame {
	private String fileName;
	private JTextField entry = new JTextField(20);
	private JLabel msgLabel = new JLabel("The Descent");
	private JLabel msgLabel2 = new JLabel("You step into the first room. Click anywhere to continue");
	private JButton guessBtn;
	private BackgroundImage background;
	private JPanel content;
	
	/**
	 * sets the labels message
	 * @param message
	 */
	public void setMessage(String message){
		msgLabel2.setText(message);
	}
	
	/**
	 * gets what's in the label
	 * @return
	 */
	public String getMsgLabel2 () {
		return this.msgLabel2.toString();
	}
	
	/**
	 * clears the input field.
	 */
	public void clearField() {
		entry.setText("");
	}
	
	/**
	 * changes the name of the file being used for the background and effectively redraws the frame.
	 * @param aFileName
	 */
	public void setBackground (String aFileName) {
		fileName = aFileName;
		try {
			content.removeAll();
			msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			msgLabel.setFont(msgLabel.getFont().deriveFont(30.0f));
			content.add(msgLabel);
			
			background = (new BackgroundImage(fileName));
			background.setPreferredSize(new Dimension(1100,618));
			content.add(background);
			
			msgLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
			msgLabel2.setPreferredSize(new Dimension(1100,150));
			msgLabel2.setFont(msgLabel2.getFont().deriveFont(20.0f));
			content.add(msgLabel2);
			
			entry.setAlignmentX(Component.CENTER_ALIGNMENT);
			entry.setPreferredSize(new Dimension (1100,100));
			content.add(entry);
			
			guessBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			content.add(guessBtn);
			
		}catch (IOException e) {
			System.out.println("oops");
		}
	}

	/**
	 * 
	 * @return entry  returns the entry textfield.
	 */
  public JTextField getEntry() {
		return entry;
	}

  /**
   * 
   * @return guessBtn   returns the button guessBtn.
   */
  	public JButton getGuessBtn() {
		return guessBtn;
	}

	/**
	 * Constructor, sets the alignments, sizes, etc. for all the ui components and then adds them to the content pane.
	 */
	public GameGUI() {
		super("Game");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setPreferredSize(new Dimension(1084, 900));
		
		msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		msgLabel.setFont(msgLabel.getFont().deriveFont(30.0f));
		content.add(msgLabel);
		try {
			fileName = "titlescreen.jpg";
			background = (new BackgroundImage(fileName));
			background.setPreferredSize(new Dimension(1100,618));
			content.add(background);
		}catch (IOException e) {
			System.out.println("oops");
		}
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon("taskbar.png").getImage());
		this.setIconImages(icons);
		
		msgLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		msgLabel2.setPreferredSize(new Dimension(1100,150));
		msgLabel2.setFont(msgLabel2.getFont().deriveFont(20.0f));
		content.add(msgLabel2);
		
		entry.setAlignmentX(Component.CENTER_ALIGNMENT);
		entry.setPreferredSize(new Dimension (1100,100));
		content.add(entry);
		
		guessBtn = new JButton("Answer");
		guessBtn.setActionCommand("Answer");
		guessBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(guessBtn);
		
		super.getContentPane().add(content);
		
	}	
  
}