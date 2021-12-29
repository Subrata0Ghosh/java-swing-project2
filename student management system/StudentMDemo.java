import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;//for action listener

public class StudentMDemo extends JFrame implements ActionListener{
    private Container c;
    private JLabel label1,label2,label3,label4,label5;//titleLabel,fnLabel,lnLabel,phoneLabel,gpaLabel;
    private JTextField tf1,tf2,tf3,tf4;//fntf;lntf,phonetf,gpatf;
    private JButton btn1,btn2,btn3,btn4;//add,update,delete,clear
    private Font font;
    private JScrollPane scroll;
    private JTable table;//for table
    private DefaultTableModel model;//coloum amd row chara table create korar jonno
    private String[] cols={"First Name","Last Name","Phone No.","CGPA"};//inisialize string type data for coloum
    private String[] rows=new String[4];//inisialize string type data for coloum.coloum er 4 ta details neber jonno 4


    StudentMDemo()//constracter
    {
        b();//method
    }

    //above method description
    public void b()
    {
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        font=new Font("Arial",Font.BOLD,16);//create font 

        label1=new JLabel();
        label1.setText("Student Registration");
        label1.setFont(font);
        label1.setBounds(140,10,250,50);
        c.add(label1);
        
 //jlabel,textfield,btn for 1st name
        label2=new JLabel("First Name:  ");
        label2.setBounds(10,80,140,30);
        label2.setFont(font);
        c.add(label2);
        
        tf1=new JTextField();//textfield
        tf1.setBounds(110,80,200,30);
        tf1.setFont(font);
        c.add(tf1);

        btn1=new JButton("Add");
        btn1.setBounds(400,80,100,30);
        btn1.setFont(font);    
        c.add(btn1);  
        
 //jlabel,textfield,btn for lastname
        label3=new JLabel("Last Name:  ");
        label3.setBounds(10,130,150,30);
        label3.setFont(font);
        c.add(label3);
        
        tf2=new JTextField();//textfield
        tf2.setBounds(110,130,200,30);
        tf2.setFont(font);
        c.add(tf2);

        btn2=new JButton("Uptate");
        btn2.setBounds(400,130,100,30);
        btn2.setFont(font);    
        c.add(btn2);
        
//jlabel,textfield,btn for phone no
        label4=new JLabel("Phone No:  ");
        label4.setBounds(10,180,150,30);
        label4.setFont(font);
        c.add(label4);
        
        tf3=new JTextField();//textfield
        tf3.setBounds(110,180,200,30);
        tf3.setFont(font);
        c.add(tf3);

        btn3=new JButton("Delete");
        btn3.setBounds(400,180,100,30);
        btn3.setFont(font);    
        c.add(btn3);

 //jlabel,textfield,btn for gpa
        label5=new JLabel("CGPA :  ");
        label5.setBounds(10,230,150,30);
        label5.setFont(font);
        c.add(label5);
        
        tf4=new JTextField();//textfield
        tf4.setBounds(110,230,200,30);
        tf4.setFont(font);
        c.add(tf4);

        btn4=new JButton("Clear");
        btn4.setBounds(400,230,100,30);
        btn4.setFont(font);    
        c.add(btn4);

//create table
        table=new JTable();

//create default model class     
        model=new  DefaultTableModel(); //private DefaultTableModel model;   
        model.setColumnIdentifiers(cols);     //set coloum
        //modify table=change bg color,text etc of table
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.pink);//selected row bg color
        table.setBackground(Color.white);
        table.setRowHeight(30);

        scroll=new JScrollPane(table);//add table to scroll pane
        scroll.setBounds(10,360,750,265);
        c.add(scroll);

//add  action listener to all 4 btn
        btn1.addActionListener(this);//'btn1=add btn'
        btn4.addActionListener(this);//'btn4=clear btn'
        btn3.addActionListener(this);//btn3=delete btn
        btn2.addActionListener(this);//btn2=update btn


//mouse adapter/mouse listener for update btn
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){//mouse click kore je row t select korbo
                int numberOfRow=table.getSelectedRow();//sei row ta ke nebe & store in 'numberofRow'

                String f_name=model.getValueAt(numberOfRow,0).toString();//0 no. coloum er koto number row user select koreche seta model theke nebe & convert the vale in string then store it in f_name. 
                String l_name=model.getValueAt(numberOfRow,1).toString();//1 no. coloum er koto number row user select koreche seta model theke nebe & convert the vale in string then store it in l_name.
                String phone=model.getValueAt(numberOfRow,2).toString();//2 no. coloum er koto number row user
                String cgpa=model.getValueAt(numberOfRow,3).toString();

             //je data ta pelam seta set korbo textfield e  
             //selected row and coloum e je text chilo seta set korbo 4 te textfield e 
                tf1.setText(f_name);
                tf2.setText(l_name);
                tf3.setText(phone);
                tf4.setText(cgpa);   
            }

        });        
    }
//add action listener    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn1){//jodi btn1 hoi.identifying btn
            //4 text field data add hobe table e
            rows[0]=tf1.getText();//rows '0' number index e textfield-1 e inputed data given by user store hobe
            rows[1]=tf2.getText();
            rows[2]=tf3.getText();
            rows[3]=tf4.getText();
            //add row to table .107 no line  model er description ache
            model.addRow(rows);
        }
        else if(e.getSource()==btn4){//jodi btn4 hoi
            //clear btn e click korle text field clear hoe jabe
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
        }
        else if(e.getSource()==btn3){//jodi btn3 hoi
            //delete btn press korle selected row number ta nebe
            int numofRow = table.getSelectedRow();//getselected method retern int value
                    if(numofRow>=0){//row jodi select kora na thake ba row value -1 hoi tahole delete korte per bo na so 'numofRow>=0'
                        model.removeRow(numofRow);
                    }
                    else{//row jodi select kora na thake
                        JOptionPane.showMessageDialog(null,"no row hasbeen selected or no row exits");
                    }
        }
        else if(e.getSource()==btn2){//jodi btn2=update e user click kore 
            int numberOfRow = table.getSelectedRow();

            //user row select korar por textfield theke text change korar por sei text gulo nebe
           String f_name= tf1.getText();//tf1 er text gulo nia f_name e store korbe
           String l_name= tf2.getText();//tf2 er text gulo nia l_name e store korbe
           String phone= tf3.getText();
           String cgpa= tf4.getText();

           //gettext set to model.model is a default table model.'numberOfRow'=tabel er selected row ta stored here
           model.setValueAt(f_name,numberOfRow,0);//model e set value at(1st txt field,koto no row,koto no coloum)
           model.setValueAt(l_name,numberOfRow,1);
           model.setValueAt(phone,numberOfRow,2);
           model.setValueAt(cgpa,numberOfRow,3);

        }
    }

public static void main(String[]args)
   {
     StudentMDemo a=new StudentMDemo();
     a.setVisible(true);//to visible app
     a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     a.setSize(780,690);//jframe size
     a.setLocationRelativeTo(null);//jframe ta center e dekhabe
     a.setTitle("Student Management System");
    }
}
