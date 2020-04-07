package frame;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;



public class DoctorHome extends JFrame implements ActionListener
{
 
	private JButton btnAll,btnHome;
	private JTextField searchfld;
	private JPanel panel;
	private JTable docTable1;
	private JScrollPane docTableSP1;

	String d;
	User user;
	UserRepo ur;
	DoctorRepo dr;
	
	public DoctorHome(String d)
	{
		super("Welcom Doctor");
		this.setSize(1000,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	    panel = new JPanel();
		panel.setLayout(null);
		
		ur = new UserRepo();
		dr = new DoctorRepo();

		this.d = d;
		
		String data[][] = {{"", ""}};
		
		String head[] = {"Patient Name", "Age"};
		
		docTable1 = new JTable(data,head);
		docTableSP1 = new JScrollPane(docTable1);
		docTableSP1.setBounds(280, 100, 450, 350);
		docTable1.setEnabled(false);
		panel.add(docTableSP1);
		
		btnHome = new JButton("Home");
	    btnHome.setBounds(800,20,120,40);
	    //btnHome.setFont(fntmain);
	    //tnHome.setForeground(Color.WHITE);
	    //btnHome.setBackground(backColor);
	    btnHome.addActionListener(this);
	    panel.add(btnHome);

	
	    btnAll = new JButton("GetAll");
		btnAll.setBounds(380,460,120,40);
	    btnAll.addActionListener(this);
		panel.add(btnAll);
		
		/*searchfld = new JTextField();
		searchfld.setBounds(30,460,300,40);
		panel.add(searchfld);
		*/
		
	    this.add(panel);
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(btnAll.getText()))
		{
			String data[][] = dr.getP(d);
			String head[] = {"Patient Name", "Age"};

			panel.remove(docTableSP1);

			docTable1 = new JTable(data,head);
			docTableSP1 = new JScrollPane(docTable1);
			docTableSP1.setBounds(280, 100, 450, 350);
			docTable1.setEnabled(false);
			panel.add(docTableSP1);

			panel.revalidate();
			panel.repaint();
		}
		else if(ae.getSource()==btnHome)
		{
			Login g1 = new Login();
			this.setVisible(false);
		}

		}
	
	
 }
		
