package UI;
import java.awt.*;
import javax.swing.*;
public class StatsGUI extends JFrame{
	private JPanel content;
	private JLabel msgLabel = new JLabel("Health: 0");
	private JLabel msgLabel2 = new JLabel("Items: none");
	private JTextArea msgLabel3 = new JTextArea("");
	
	/**
	 * 
	 * @param message
	 */
	public void setStatHealth(String message){
		msgLabel.setText(message);
	}
	
	/**
	 * 
	 * @param message
	 */
	public void setStatItem(String message){
		msgLabel2.setText(message);
	}
	
	/**
	 * 
	 * @param message
	 */
	public void setStatNem(String message) {
		msgLabel3.setText(message);
	}
	
	/**
	 * Constructor, sets the alignments, sizes, etc. for all the ui components and then adds them to the content pane. 
	 */
	public StatsGUI() {
		super("Stats");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setPreferredSize(new Dimension(440, 450));
		
		msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		msgLabel.setPreferredSize(new Dimension(440,150));
		msgLabel.setFont(msgLabel.getFont().deriveFont(30.0f));
		content.add(msgLabel);
		
		msgLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		msgLabel2.setPreferredSize(new Dimension(440,150));
		msgLabel2.setFont(msgLabel2.getFont().deriveFont(20.0f));
		content.add(msgLabel2);
		
		msgLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
		msgLabel3.setPreferredSize(new Dimension(440,300));
		msgLabel3.setFont(msgLabel3.getFont().deriveFont(20.0f));
		msgLabel3.setWrapStyleWord(true);
	    msgLabel3.setLineWrap(true);
	    msgLabel3.setOpaque(false);
	    msgLabel3.setEditable(false);
	    msgLabel3.setFocusable(false);
	    msgLabel3.setBackground(UIManager.getColor("Label.background"));
	    msgLabel3.setBorder(UIManager.getBorder("Label.border"));
		content.add(msgLabel3);
		
		super.getContentPane().add(content);
		
	}
	
}
