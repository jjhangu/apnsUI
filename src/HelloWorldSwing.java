
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class HelloWorldSwing extends JFrame implements ActionListener{
	JRadioButton rb1,rb2;
	JMenuBar mb;  
	JMenu file,edit,help;  
	JMenuItem cut,copy,paste,selectAll, exit;  
	
	public HelloWorldSwing() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	//
    	JButton btn=new JButton("전송");  
    	btn.setBounds(300,100,100, 40);  
    	
    	btn.addActionListener(this );
    	add(btn);
    	
    	setSize(1000, 800);
    	
    	
    	// 선택 라이브러리
    	
    	rb1=new JRadioButton("true");  
    	rb1.setBounds(100,50,100,30);  
    	rb1.setSelected(true);
    	  
    	rb2=new JRadioButton("false");  
    	rb2.setBounds(100,100,100,30);  

    	ButtonGroup bg=new ButtonGroup();  
    	bg.add(rb1);bg.add(rb2);  
    	
    	
    	add(rb1);
    	add(rb2);
    	
    	// 텍스트 area
    	JTextArea area=new JTextArea(300,300);  
        area.setBounds(10,450,300,300);  
          
        area.setBackground(Color.white);  
        area.setForeground(Color.black); 
        add(area);
        
        
     // 텍스트 filePath
    	JTextArea filePath=new JTextArea(300,300);  
    	filePath.setBounds(10,200,300,50);  
          
    	filePath.setBackground(Color.white);  
    	filePath.setForeground(Color.black); 
        add(filePath);
    	
        String country[]={"notnoop","javaapns"};  
        // combobox
        JComboBox cb=new JComboBox(country);  
        cb.setBounds(50, 50,90,20);  
        add(cb);
        
        /// menu
        
        // file
        exit = new JMenuItem("exit");
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("exit");
				System.exit(1);
				
			}
		});
        // edit
        cut=new JMenuItem("cut");  
        copy=new JMenuItem("copy");  
        paste=new JMenuItem("paste");  
        selectAll=new JMenuItem("selectAll");
          
        mb=new JMenuBar();  
        mb.setBounds(0,0,400,40);  
        
        file=new JMenu("File");  
        edit=new JMenu("Edit");  
        help=new JMenu("Help");  
        
        file.add(exit);
        
          
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);  
        mb.add(file);mb.add(edit);mb.add(help);  
        
        add(mb);
        
    	setLayout(null);
    	setVisible(true);
    	
	}
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new HelloWorldSwing();
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(rb1.isSelected()){  
			JOptionPane.showMessageDialog(this,"notnoop");  
			}  
			if(rb2.isSelected()){  
			JOptionPane.showMessageDialog(this,"javaapns");  
			}  
			
			JFileChooser fc=new JFileChooser();  
			int i=fc.showOpenDialog(this);  
			          
			if(i==JFileChooser.APPROVE_OPTION){  
			File f=fc.getSelectedFile();  
			String filepath=f.getPath();  
			  
			System.out.println(filepath);
			//displayContent(filepath);  
			              
			}  
	}
}
