package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class Signup extends JFrame implements ActionListener
{
	private JLabel lblup, lblfname, lbllname, lblgender, lblage, lblcontactinfo, lbladdress, lblsetusername, lblpass, lblimage,lblimgHome,lblBack;
	private JButton btnsubmit, btnreset,btnHome;
	private JTextField fnamefld, lnamefld, agefld, contactinfofld, addressfld, setusernamefld,ganderfld;
	private JPasswordField passfld;
	//private JComboBox combobox;
	private Color colorsubmit, colorreset,backColor;
	private Font gfont, gfont2,txtFont,fntmain;
	private ImageIcon img,imgHome;
	Login g1;
	private JPanel panel;

	PatientRepo pr ;//= new PatientRepo();
	UserRepo ur;

	public Signup(Login g1)
	{
	   	super("Appointment System");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.g1 = g1;


		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

        pr = new PatientRepo();
        ur = new UserRepo();


		gfont = new Font("Tahoma", Font.BOLD , 15);
	    gfont2 = new Font("Tahoma", Font.BOLD , 15);
	    fntmain = new Font("Agency FB",Font.BOLD,13);
	    txtFont = new Font("Times Roman New",Font.BOLD,14);

	    backColor = new Color(83, 126, 106);

	    lblBack = new JLabel();
	    lblBack.setBackground(backColor);
	    lblBack.setOpaque(true);
	    lblBack.setBounds(0,0,1000,30);
	    panel.add(lblBack);

	    btnHome = new JButton("Home");
	    btnHome.setBounds(700,0,70,30);
	    btnHome.setFont(fntmain);
	    btnHome.setForeground(Color.WHITE);
	    btnHome.setBackground(backColor);
	    btnHome.addActionListener(this);
	    panel.add(btnHome);

        lblup = new JLabel("Patient Sign Up");
		lblup.setBounds(100,50,450,30);
		lblup.setForeground(Color.BLACK);
		lblup.setFont(gfont);
		panel.add(lblup);


		lblfname = new JLabel("Full Name");
		lblfname.setBounds(270,110,150,30);
		lblfname.setForeground(Color.BLACK);
		lblfname.setFont(gfont);
		panel.add(lblfname);


		lblgender = new JLabel("Gender");
        lblgender.setBounds(270,160,150,30);
        lblgender.setForeground(Color.BLACK);
		lblgender.setFont(gfont);
		panel.add(lblgender);

		lblage = new JLabel("Age");
        lblage.setBounds(620,160,150,30);
        lblage.setForeground(Color.BLACK);
		lblage.setFont(gfont);
		panel.add(lblage);


		lblcontactinfo = new JLabel("Contact No");
        lblcontactinfo.setBounds(270,220,150,30);
        lblcontactinfo.setForeground(Color.BLACK);
		lblcontactinfo.setFont(gfont);
		panel.add(lblcontactinfo);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(270,270,150,30);
        lbladdress.setForeground(Color.BLACK);
		lbladdress.setFont(gfont);
		panel.add(lbladdress);



		lblpass = new JLabel("Password");
		lblpass.setBounds(230,640,200,30);
		lblpass.setForeground(Color.BLACK);
		lblpass.setFont(gfont);
		panel.add(lblpass);

		fnamefld = new JTextField();
		fnamefld.setBounds(460,110,290,35);
		fnamefld.setFont(txtFont);
		fnamefld.setBackground(Color.WHITE);
		panel.add(fnamefld);


		//String items[] = {"Male", "Female", "Others"};

		ganderfld = new JTextField();
		ganderfld.setBounds(460, 160, 110, 35);
		ganderfld.setFont(txtFont);
		panel.add(ganderfld);

		agefld = new JTextField();
		agefld.setBounds(680,160,70,35);
		agefld.setFont(txtFont);
		agefld.setBackground(Color.WHITE);
		panel.add(agefld);

		contactinfofld = new JTextField();
		contactinfofld.setBounds(460,220,290,35);
		contactinfofld.setFont(txtFont);
		contactinfofld.setBackground(Color.WHITE);
		panel.add(contactinfofld);

		addressfld = new JTextField();
		addressfld.setBounds(460,270,290,70);
		addressfld.setFont(txtFont);
		addressfld.setBackground(Color.WHITE);
		panel.add(addressfld);



		btnsubmit = new JButton("Submit");
		btnsubmit.setBounds(460,370,130,45);
		colorsubmit = new Color(16,94,32);
		btnsubmit.setBackground(colorsubmit);
		btnsubmit.setForeground(Color.WHITE);
		btnsubmit.setFont(gfont2);
   		btnsubmit.addActionListener(this);
		panel.add(btnsubmit);

		btnreset = new JButton("Reset");
		btnreset.setBounds(620,370,130,45);
		colorreset = new Color(89,25,25);
		btnreset.setBackground(colorreset);
		btnreset.setForeground(Color.WHITE);
		btnreset.setFont(gfont2);
    	btnreset.addActionListener(this);
		panel.add(btnreset);

		img = new ImageIcon("Patient.jpg");
		lblimage = new JLabel(img);
		lblimage.setBounds(5, 40, 130, 80);
		panel.add(lblimage);

	    this.add(panel);
      this.setVisible(true);


	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(btnreset.getText()))
		{
			fnamefld.setText("");
			agefld.setText("");
			contactinfofld.setText("");
			addressfld.setText("");
			ganderfld.setText("");
		}
		else if(ae.getSource() == btnsubmit)
		{
        Patient p = new Patient();
        User u = new User();
        Random rd = new Random();

        int x = rd.nextInt(9999999)+10000000;
        String id = "pnt"+fnamefld.getText();
        String Password = String.valueOf(x);

        p.setPId(id);
        p.setPName(fnamefld.getText());
        p.setPPassword(Password);
        //p.setPGander(ganderfld.getItemAt(combobox.getSelectedIndex()));
        p.setPGander(ganderfld.getText());
        p.setPAge(agefld.getText());
        p.setPAddress(addressfld.getText());
        p.setPContact(contactinfofld.getText());

        u.setUserId(id);
  		u.setPassword(x+"");
  		u.setStatus(2);

        pr.insertInDB(p);
  		ur.insertUser(u);
  		JOptionPane.showMessageDialog(this, "Inserted, Id: "+id+" and Password: "+x);
  		
  		fnamefld.setText("");
		agefld.setText("");
		contactinfofld.setText("");
		addressfld.setText("");
		ganderfld.setText("");
    }
    else if(ae.getSource()==btnHome)
    {
    	Login g1 = new Login();
		this.setVisible(false);
    }
	}//actionPerformed
}//class
