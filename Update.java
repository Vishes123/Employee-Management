package Jdbc_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update extends JFrame {
    Update(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(174, 88, 120));
        //panel.setSize(895,395);
        panel.setBounds(5,5,980,390);
        panel.setLayout(null);
        add(panel);

        JLabel id = new JLabel("Id");
        id.setBounds(50,50,50,30);
        id.setForeground(Color.black);
        id.setFont(new Font("System",Font.BOLD,18));
        panel.add(id);
       /* JTextField t1 = new JTextField();
        t1.setBounds(150,50,150,30);
        t1.setForeground(Color.black);
        panel.add(t1);*/
        Choice choice = new Choice();
        choice.setBounds(150,50,150,30);
        choice.setForeground(Color.black);
        panel.add(choice);
        try {
            Con1 cs = new Con1();
            ResultSet resultSet = cs.statement.executeQuery("select * from AddEmployee");
            while (resultSet.next()){
                choice.add(resultSet.getString("Id"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel Name = new JLabel("Name");
        Name.setBounds(50,100,80,30);
        Name.setForeground(Color.black);
        Name.setFont(new Font("System",Font.BOLD,18));
        panel.add(Name);
        JTextField t2 = new JTextField();
        t2.setBounds(150,100,150,30);
        t2.setForeground(Color.black);
        panel.add(t2);

        JLabel post = new JLabel("Post");
        post.setBounds(50,150,80,30);
        post.setForeground(Color.black);
        post.setFont(new Font("System",Font.BOLD,18));
        panel.add(post);
        JTextField t3 = new JTextField();
        t3.setBounds(150,150,150,30);
        t3.setForeground(Color.black);
        panel.add(t3);

        JLabel sl = new JLabel("Salary");
        sl.setBounds(50,200,80,30);
        sl.setForeground(Color.black);
        sl.setFont(new Font("System",Font.BOLD,18));
        panel.add(sl);
        JTextField t4 = new JTextField();
        t4.setBounds(150,200,150,30);
        t4.setForeground(Color.black);
        panel.add(t4);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50,250,80,30);
        gender.setForeground(Color.black);
        gender.setFont(new Font("System",Font.BOLD,18));
        panel.add(gender);

        JLabel gender1 = new JLabel();
        gender1.setBounds(150,250,80,30);
        gender1.setForeground(Color.black);
        gender1.setFont(new Font("System",Font.BOLD,18));
        panel.add(gender1);

        JButton Check = new JButton("Check");
        Check.setBounds(80,330,80,30);
        Check.setForeground(Color.white);
        Check.setBackground(Color.black);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // if (e.getSource() == Check) {
                    String id =choice.getSelectedItem();
                    String q = "select * from AddEmployee where Id = '"+id+"'";
                    try {
                        Con1 c = new Con1();
                        ResultSet resultSet = c.statement.executeQuery(q);
                        while (resultSet.next()) {
                            //id.setText(resultSet.getString("Id"));
                            t2.setText(resultSet.getString("Name"));
                            t3.setText(resultSet.getString("Post"));
                            t4.setText(resultSet.getString("Salary"));
                            gender1.setText(resultSet.getString("Gender"));
                        }

                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
        //}



        });

        JButton Check1 = new JButton("Back");
        Check1.setBounds(190,330,80,30);
        Check1.setForeground(Color.white);
        Check1.setBackground(Color.black);
        panel.add(Check1);
        Check1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==Check1){
                    setVisible(false);
                }
            }
        });

        JButton up = new JButton("Update");
        up.setBounds(300,330,80,30);
        up.setForeground(Color.white);
        up.setBackground(Color.black);
        panel.add(up);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==up){
                    try {
                        Con1 c = new Con1();
                        String salary=t4.getText();
                        c.statement.executeUpdate("Update  AddEmployee set Salary ='"+salary+"'");
                        JOptionPane.showMessageDialog(null,"Update Successfully");
                        setVisible(false);




                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
            }
        });

        JButton Remove = new JButton("Remove");
        Remove.setFont(new Font("System",Font.BOLD,12));
        Remove.setForeground(Color.white);
        Remove.setBackground(Color.black);
        Remove.setBounds(420,330,80,30);
        panel.add(Remove);
        Remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==Remove){
                  if (t2.getText().equals("")){
                      JOptionPane.showMessageDialog(null,"Click Check Button firs");
                  }else {
                      try {
                          Con1 c = new Con1();
                          c.statement.executeUpdate("delete from AddEmployee where Id = '"+choice.getSelectedItem()+"' ");
                          JOptionPane.showMessageDialog(null,"Successful Removing");
                          setVisible(false);

                      }catch (Exception E){
                          E.printStackTrace();
                      }
                  }
                }
            }
        });



        setSize(900,400);
        setUndecorated(true);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Update();
    }
}
