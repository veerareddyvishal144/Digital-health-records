import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;  
import java.net.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
class  Signup
{
	Vector<Integer> vec=new Vector<Integer>(2);
	Vector<Integer> vec1=new Vector<Integer>(2);

	JLabel labelP,labelP1;
	String las[]={"Name","Email ID","Blood Group","Contact","Login_Password","Gender","Designation","DOB","DOJ(Date of Join)","Gross Salary","Division","Grade_Pay"};
	public static JFrame f1=new JFrame("Sign_Up Portal");
	JButton b1,b97;
	JPanel main;
	JPanel p1,for1,for2;
	JLabel extra;
	JLabel extra1;
	JPanel extraP;
	JPanel p2[];
	JLabel lie1,lie2;
	JPanel extraP1;
	JPanel corner;
	JPanel temp[];
	JLabel l1[];
	JLabel tf[];
	JLabel l45[];
	JButton ac1,fa1;
	JComboBox jcb1,jcb2,jcb3,jcb0,jcb5,jdob1,jdob2,jdob3,jdoj1,jdoj2,jdoj3;
String las512[]={"--Choose--","Female","Male","Prefer not to say"};
String dob2[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
String las1024[]={"--Select--","Systems Manager","Senior Engineer","Junior Engineer","Senior Programmer","FA/CAO","GM","Class_4"};	
String las256[]={"--Select--","A+","A-","B+","B-","O+","O-","AB+","AB-"};
	String las11[]={"--Select DIVISON--","SCR","NR","ER","WR","SWR","CR","NFR"};
        String las111[]={"--Select PAY Scale--","PB1S: 4440-7440(GP-1600)","PB1S: 4440-7440(GP-1650)","PB1: 5200-20200(GP-1600)","PB2: 9300-34800(GP-4600)","PB3: 15600-39100(GP-7600)","PB4: 37400-67000(GP-10000)","HAG2: 67000-79000","APEX1: 90000/- FIXED","MEMBER OF PARLIAMENT"};
	JPanel nh;
public	Signup()
	{
		ac1=new JButton("Bank Account & Family info.");
		lie1=new JLabel(" ");
	lie2=new JLabel(" ");
		for1=new JPanel();
		for1.setLayout(new FlowLayout(FlowLayout.LEFT));
		for2=new JPanel();
		for2.setLayout(new FlowLayout(FlowLayout.CENTER));
		for(int i=1;i<=31;i++)
		{
			vec.addElement(i);
		}
		Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
		for(int i=1940;i<=year;i++)
		{
			vec1.addElement(i);
		}
	b97=new JButton("Home");
	
JLabel kj=new JLabel("Sign_Up Portal");
extraP=new JPanel();
extraP.setBackground(Color.white);
extraP1=new JPanel();
extraP1.setBackground(Color.white);
extraP.setLayout(new FlowLayout(FlowLayout.LEFT));
extraP1.setLayout(new FlowLayout(FlowLayout.LEFT));
extra =new JLabel(":");
extra1 =new JLabel(":");
jcb1=new JComboBox(las11);
jcb3=new JComboBox(las256);
		jcb2=new JComboBox(las111);
		jdob1=new JComboBox(vec);
jdob2=new JComboBox(dob2);
jdob3=new JComboBox(vec1);
		jdoj1=new JComboBox(vec);
jdoj2=new JComboBox(dob2);
		jdoj3=new JComboBox(vec1);
jcb0=new JComboBox(las512);
jcb5=new JComboBox(las1024);
		main=new JPanel();
		corner =new JPanel();
corner.setBackground(Color.white);
		corner.setLayout(new FlowLayout(FlowLayout.RIGHT));
		b1=new JButton("Submit");
		temp=new JPanel[15];
		l45=new JLabel[15];
		l1=new JLabel[15];
		tf=new JLabel[15];
		p2=new JPanel[15];
f1.setBackground(Color.white);
p1=new JPanel();
p1.setBackground(Color.white);
p1.setLayout(new GridLayout(15,1,0,1));
main.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));	
main.setBackground(Color.white);
f1.setLayout(new BorderLayout());
f1.setVisible(true);
f1.setResizable(false);
f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
jcb1.setPrototypeDisplayValue("Bits Pilani Hyb campus is awesome but not as great as");
jcb2.setPrototypeDisplayValue("Bits Pilani Hyb campus is awesome but not as great as");
jcb3.setPrototypeDisplayValue("Bits Pilani Hyb campus is awesome but not as great as");
jcb0.setPrototypeDisplayValue("Bits Pilani Hyb campus is awesome but not as great as");
jcb5.setPrototypeDisplayValue("Bits Pilani Hyb campus is awesome but not as great as");
JLabel ko1=new JLabel("/");
JLabel ko2=new JLabel("/");
JLabel ko3=new JLabel("/");
JLabel ko4=new JLabel("/");
for(int i=0;i<12;i++)
	{
l45[i]=new JLabel(":");
temp[i]=new JPanel();
temp[i].setBackground(Color.white);
p2[i]=new JPanel();
p2[i].setBackground(Color.white);
p2[i].setLayout(new GridLayout(1,2));
temp[i].setLayout(new FlowLayout(FlowLayout.LEFT));
l1[i]=new JLabel(las[i]);
l1[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
tf[i]=new JLabel("");
temp[i].add(l45[i]);
temp[i].add(tf[i]);
p2[i].add(l1[i]);
p2[i].add(temp[i]);
p1.add(p2[i]);
}
JPanel south=new JPanel();
south.setLayout(new BorderLayout());
south.add(corner,"West");
south.setBackground(Color.white);
corner.add(b1);
corner.add(b97);
JButton hya=new JButton("BITS");
p1.add(ac1);
p1.add(corner);
main.add(p1);
f1.add(main,"Center");
// f1.add(south,"South");
f1.add(labelP,"North");
ac1.setFont(ac1.getFont().deriveFont(18.0f));
b97.setFont(b97.getFont().deriveFont(18.0f));
b1.setFont(b1.getFont().deriveFont(18.0f));
	} 
public static void main(String args[])
{
Signup kil=new Signup();
}
}	

