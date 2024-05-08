package Jdbc_project;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employe_Info extends JFrame {
    Employe_Info(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(174, 88, 120));
        panel.setSize(998,698);
        panel.setLayout(null);
        add(panel);


        JTable table = new JTable();
        table.setFont(new Font("System",Font.PLAIN,18));
        table.setBackground(new Color(168, 241, 165));
        table.setBounds(5,40,990,300);
        table.setForeground(Color.black);
        panel.add(table);
        try {
            Con1 c = new Con1();
            String q ="select * from AddEmployee";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(400,400,100,40);
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
        new Employe_Info();

    }
}
