package gui;

import api.DirectedWeightedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphG1 extends JFrame implements ActionListener {
    static JFrame f1;
    static JButton button;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JLabel text;
    public DirectedWeightedGraph graph;

    graphG1(){
        setTitle("graphG1");
        setSize(1000,1000);
        setVisible(true);
        text = new JLabel("Enter json file name or path");

        button = new JButton("get node");
        button1 = new JButton("get edge");
        button2 = new JButton("size of nodes");
        button3= new JButton("size of edges");

        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        JPanel p1 = new JPanel();

        p1.add(button);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);

        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("get node")) {
           /// new GetNode(graph);
            double node = graph.getNode(3).getLocation().x();
            JOptionPane.showMessageDialog(null,5);

        }
        else if(s.equals("get edge")){

        } else if(s.equals("size of nodes")){


        } else if(s.equals("size of edges")){


        }





    }

}
