package com.apns.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.apns.ui.callback.LogCallback;
import com.apns.ui.client.APNSNotnoopClient;
import com.apns.ui.log.UILogger;
import com.apns.ui.model.Props;
import com.google.gson.Gson;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;


public class PnsSender extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JPasswordField pwdD;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JTextField textField_2;
	final static Logger logger = Logger.getLogger(PnsSender.class);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			private PnsSender frame;

			public void run() {
				try {
					frame = new PnsSender();
					frame.getContentPane();
					frame.setVisible(true);
					
					UILogger.getInstance().setLogCallBack(new LogCallback() {
						
						@Override
						public void printLog(String str) {
							frame.textArea.append(str + "\n");
							frame.textArea.setCaretPosition(frame.textArea.getDocument().getLength());
						}
					});
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PnsSender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FILE = new JMenu("FILE");
		menuBar.add(FILE);
		
		JMenuItem mntmSave = new JMenuItem("Save Properties");
		mntmSave.addActionListener(new SaveL());
		FILE.add(mntmSave);
		
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new OpenL());
		FILE.add(mntmOpen);
		
		JMenuItem EXIT = new JMenuItem("Exit");
		EXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
		
		rdbtnNewRadioButton = new JRadioButton("true");
		rdbtnNewRadioButton.setBounds(152, 55, 121, 23);
		rdbtnNewRadioButton.setSelected(true);
		
		rdbtnNewRadioButton_1 = new JRadioButton("false");
		rdbtnNewRadioButton_1.setBounds(152, 80, 121, 23);

		
		ButtonGroup bg=new ButtonGroup();  
    	bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);  

		contentPane.add(rdbtnNewRadioButton);
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
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pnsToken =textField.getText().trim();
				String certPath =textField_1.getText().trim();
				String message = textField_2.getText().trim();
						
						
				String password = String.valueOf(pwdD.getPassword()); 
				boolean isProduction = false;
				
				if(pnsToken.equals("")){
					JOptionPane.showMessageDialog(contentPane, "PNS 토큰을 입력하세요");
					return;
				}
				if(certPath.equals("")){
					JOptionPane.showMessageDialog(contentPane, "인증서 경로를 입력하세요");
					return;
				}
								
				if(password.equals("")){
					JOptionPane.showMessageDialog(contentPane, "패스워드를 입력하세요");
				}
				
				
				if(rdbtnNewRadioButton.isSelected()){
					isProduction = true;
				}
				
				textArea.append(textArea.getText()  + "\n");
				
				ApnsService  apnsService =  APNSNotnoopClient.getInstance(isProduction, certPath, password);
				
				
				String payload  = APNS.newPayload().alertBody(  message).sound("default").build();
				
				apnsService.push(pnsToken, payload);			
				return;
			}
		});
		btnSend.setBounds(436, 30, 97, 23);
		contentPane.add(btnSend);
		
		JLabel lblCertificatePath = new JLabel("Certificate Path");
		lblCertificatePath.setBounds(33, 226, 121, 15);
		contentPane.add(lblCertificatePath);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 251, 603, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textArea = new JTextArea();
		
		textArea.setCaretPosition(textArea.getDocument().getLength());
		
		
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(33, 365, 1118, 366);
		jsp.setWheelScrollingEnabled(true);
		contentPane.add(jsp);
		
		JLabel lblNewLabel_1 = new JLabel("\uB85C\uADF8");
		lblNewLabel_1.setBounds(33, 340, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(283, 34, 90, 17);
		contentPane.add(lblNewLabel_2);
		
		pwdD = new JPasswordField();
		pwdD.setBounds(281, 56, 106, 21);
		contentPane.add(pwdD);
		
		JLabel lblNewLabel_3 = new JLabel("Message");
		lblNewLabel_3.setBounds(33, 282, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setBounds(33, 305, 603, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

	}
	
	class OpenL implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      JFileChooser c = new JFileChooser();
	      // Demonstrate "Open" dialog:
	      int rVal = c.showOpenDialog(PnsSender.this);
	      if (rVal == JFileChooser.APPROVE_OPTION) {
	    	  Gson gson = new Gson();

	    		try {

	    			BufferedReader br = new BufferedReader(
	    				new FileReader(c.getCurrentDirectory().toString() +"/" + c.getSelectedFile().getName()));

	    			//convert the json string back to object
	    			  Props obj =  gson.fromJson(br, Props.class);
	    			  
	    			System.out.println(obj);
	    			
	    			textField.setText(obj.getPnsToken());
	    			textField_1.setText(obj.getCertPath());
	    			textField_2.setText(obj.getMessage());
					
					if(obj.isProduction()){
						rdbtnNewRadioButton.setSelected(true);
					}
					
					pwdD.setText(obj.getPassword());
	    		} catch (IOException e1) {
	    			e1.printStackTrace();
	    		}

	      }
	      if (rVal == JFileChooser.CANCEL_OPTION) {
	        
	      }
	    }
	  }

	  class SaveL implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      JFileChooser c = new JFileChooser();
	      // Demonstrate "Save" dialog:
	      int rVal = c.showSaveDialog(PnsSender.this);
	      if (rVal == JFileChooser.APPROVE_OPTION) {
	    	  Props obj = new Props();
	    	  String pnsToken =textField.getText().trim();
				String certPath =textField_1.getText().trim();
				String message = textField_2.getText().trim();
						
						
				String password = String.valueOf(pwdD.getPassword()); 
				boolean isProduction = false;
				
				obj.setPnsToken(pnsToken);
				obj.setMessage(message);
				obj.setCertPath(certPath);
				obj.setProduction(isProduction);
				obj.setPassword(password);
	    	  Gson gson = new Gson();
	    		// convert java object to JSON format,
	    		// and returned as JSON formatted string
	    		String json = gson.toJson(obj);

	    		
	    		
	    		
	    		try {
	    			//write converted json data to a file named "file.json"
	    			FileWriter writer = new FileWriter(c.getCurrentDirectory().toString() +"/" + c.getSelectedFile().getName());
	    			writer.write(json);
	    			writer.close();
	    		} catch (IOException e1) {
	    			e1.printStackTrace();
	    		}
	    		System.out.println(json);
	      }
	      if (rVal == JFileChooser.CANCEL_OPTION) {
	       
	      }
	    }
	  }

}
