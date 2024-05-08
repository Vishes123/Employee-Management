package Jdbc_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Emplye_From extends JFrame {
    Emplye_From(){
        JPanel panel = new JPanel();
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(174, 88, 120));
        panel.setLayout(null);
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(174, 88, 120));
        //panel1.setBounds(3,4,1500,700);
        panel1.setBounds(5,5,270,820);
        panel1.setLayout(null);
        add(panel1);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Employee.jpeg"));
        Image i = img1.getImage().getScaledInstance(500,400 , Image.SCALE_DEFAULT) ;
        ImageIcon  imageIcon = new ImageIcon(i);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(300,100,500,400);
        panel.add(label);

        JLabel h = new JLabel("Employee Management");
        h.setFont(new Font("Tahoma",Font.BOLD,25));
        h.setForeground(Color.white);
        h.setBounds(360,5,300,50);
        panel.add(h);

        JButton submit = new JButton("ADD-STAFF");
        submit.setFont(new Font("System",Font.BOLD,12));
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setBounds(40,60,170,40);
        panel1.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource()==submit){
                        new Add_Employe();
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton Cheack = new JButton("STAFF-INFO");
        Cheack.setFont(new Font("System",Font.BOLD,12));
        Cheack.setForeground(Color.white);
        Cheack.setBackground(Color.black);
        Cheack.setBounds(40,120,170,40);
        panel1.add(Cheack);
        Cheack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource()==Cheack){
                        new Employe_Info();
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setFont(new Font("System",Font.BOLD,12));
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(40,180,170,40);
        panel1.add( update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==update){
                    new Update();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setFont(new Font("System",Font.BOLD,12));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(70,600,100,40);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==back){
                    setVisible(false);
                }
            }
        });





        setSize(1800,700);
        setUndecorated(false);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Emplye_From();

    }
}
