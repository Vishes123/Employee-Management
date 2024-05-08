package Jdbc_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Employe extends JFrame {
    Add_Employe(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(174, 88, 120));
        panel.setSize(998,698);
        panel.setLayout(null);
        add(panel);

        JLabel l1 = new JLabel("Add-Employee");
        l1.setFont(new Font("System",Font.BOLD,22));
        l1.setForeground(Color.white);
        l1.setBounds(400,10,180,60);
        panel.add(l1);

        JLabel l2 = new JLabel("Id");
        l2.setFont(new Font("System",Font.PLAIN,22));
        l2.setForeground(Color.white);
        l2.setBounds(80,60,180,60);
        panel.add(l2);
        JTextField t1 = new JTextField();
        t1.setForeground(Color.black);
        t1.setBounds(200,75,180,30);
        panel.add(t1);

        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("System",Font.PLAIN,22));
        l3.setForeground(Color.white);
        l3.setBounds(80,130,180,60);
        panel.add(l3);
        JTextField t2 = new JTextField();
        t2.setForeground(Color.black);
        t2.setBounds(200,137,180,30);
        panel.add(t2);

        JLabel l4 = new JLabel("Post");
        l4.setFont(new Font("System",Font.PLAIN,22));
        l4.setForeground(Color.white);
        l4.setBounds(80,190,180,60);
        panel.add(l4);
        JTextField t3 = new JTextField();
        t3.setForeground(Color.black);
        t3.setBounds(200,197,180,30);
        panel.add(t3);

        JLabel l5 = new JLabel("Salary");
        l5.setFont(new Font("System",Font.PLAIN,22));
        l5.setForeground(Color.white);
        l5.setBounds(80,240,180,60);
        panel.add(l5);
        JTextField t4 = new JTextField();
        t4.setForeground(Color.black);
        t4.setBounds(200,250,180,30);
        panel.add(t4);


        JLabel l6 = new JLabel("Gender");
        l6.setFont(new Font("System",Font.PLAIN,22));
        l6.setForeground(Color.white);
        l6.setBounds(500,60,100,40);
        panel.add(l6);
        JRadioButton radioButton = new JRadioButton("Male");
        radioButton .setFont(new Font("System",Font.PLAIN,18));
        radioButton .setForeground(Color.white);
        radioButton .setBounds(600,60,90,40);
        radioButton.setBackground(new Color(56, 4, 38));
        panel.add(radioButton );
        JRadioButton radioButton1 = new JRadioButton("Female");
        radioButton1 .setFont(new Font("System",Font.PLAIN,18));
        radioButton1 .setForeground(Color.white);
        radioButton1 .setBounds(690,60,100,40);
        radioButton1.setBackground(new Color(56, 4, 38));
        panel.add(radioButton1 );
        ButtonGroup buttonGroup= new ButtonGroup();
        buttonGroup.add(radioButton);
        buttonGroup.add(radioButton1);

        JButton Add = new JButton("SUBMIT");
        Add.setBackground(Color.black);
        Add.setForeground(Color.white);
        Add.setBounds(300,350,100,40);
        panel.add(Add);
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==Add){
                    String Id = t1.getText();
                    String Name = t2.getText();
                    String Post =t3.getText();
                    String Salary= t4.getText();
                    String Gender=null;
                    if (radioButton.isSelected()){
                        Gender="Male";
                    } else if (radioButton1.isSelected()) {
                        Gender="Female";

                    }
                    try {
                        if (t1.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"Fill the Id First");
                        } else if (t2.getText().equals("")) {
                            JOptionPane.showMessageDialog(null,"Fill the name first");

                        } else if (t3.getText().equals("")) {
                            JOptionPane.showMessageDialog(null,"Fill the Post first");
                        } else {
                            Con1 c = new Con1();
                            String q = "insert into AddEmployee value('"+Id+"','"+Name+"','"+Post+"','"+Salary+"','"+Gender+"')";
                            c.statement.executeUpdate(q);
                            JOptionPane.showMessageDialog(null,"Successfully Added");
                            setVisible(false);

                        }

                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(500,350,100,40);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==back){
                    setVisible(false);
                }
            }
        });






        setSize(1000,500);
        setUndecorated(true);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);




    }
    public static void main(String[] args) {
        new Add_Employe();
    }
}
