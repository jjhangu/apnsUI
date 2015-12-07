import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class f extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f frame = new f();
					frame.getContentPane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public f() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 556);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FILE = new JMenu("FILE");
		menuBar.add(FILE);
		
		JMenuItem EXIT = new JMenuItem("Exit");
		FILE.add(EXIT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		String country[]={"notnoop","javaapns"};
		JComboBox comboBox = new JComboBox(country);
		comboBox.setBounds(33, 56,90,20);  
		
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("true");
		rdbtnNewRadioButton.setBounds(152, 55, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("false");
		rdbtnNewRadioButton_1.setBounds(152, 80, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel label = new JLabel("\uB77C\uC774\uBE0C\uB7EC\uB9AC");
		label.setBounds(33, 31, 90, 20);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Produnction");
		lblNewLabel.setBounds(158, 34, 90, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblPnstoken = new JLabel("PNS_TOKEN");
		lblPnstoken.setBounds(33, 157, 90, 15);
		contentPane.add(lblPnstoken);
		
		textField = new JTextField();
		textField.setBounds(33, 182, 603, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(318, 34, 97, 23);
		contentPane.add(btnSend);
		
		JLabel lblCertificatePath = new JLabel("Certificate Path");
		lblCertificatePath.setBounds(33, 217, 121, 15);
		contentPane.add(lblCertificatePath);
		
		JButton btnNewButton = new JButton("\uBD88\uB7EC\uC624\uAE30");
		btnNewButton.setBounds(134, 213, 97, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 251, 603, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 312, 603, 175);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("\uB85C\uADF8");
		lblNewLabel_1.setBounds(33, 287, 57, 15);
		contentPane.add(lblNewLabel_1);
		

		
		
	}
}
