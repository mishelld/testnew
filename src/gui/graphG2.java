package gui;

import api.DirectedWeightedGraph;
import codes.Ex2;
import gui.pop.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphG2 extends JFrame implements ActionListener {
    static JFrame f1;
    static JButton button;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;




    static JLabel text;
    private MyPanel panel;

    private DirectedWeightedGraph graphAlgo;

    graphG2(DirectedWeightedGraph ans){
        super();
        graphAlgo = ans;
        panel = new MyPanel(ans);
        panel.init(Ex2.getGrapgAlgo("data/G2.json").getGraph());
        panel.repaint();

        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);

        button = new JButton("get node");
        button1 = new JButton("get edge");
        button2 = new JButton("size of nodes");
        button3= new JButton("is graph connected");
        button4= new JButton("load graph");
        button5= new JButton("remove edge");
        button6= new JButton("remove node");
        button7= new JButton("save");
        button8= new JButton("shortest path");
        button9= new JButton("shortest path dist");
        button10= new JButton("TSP");






        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);







        JPanel p1 = new JPanel();

        p1.add(button);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button10);


        add(p1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("get node")) {
            new GetNode(Ex2.getGrapg("data/G2.json"));
        }
        else if(s.equals("get edge")){
            new ShortestPathDist(Ex2.getGrapgAlgo("data/G2.json"));

        } else if(s.equals("size of nodes")){
            String message = "The Size Of The Nodes In The Graph is: " + Ex2.getGrapg("data/G2.json").nodeSize();
            JOptionPane.showMessageDialog(new JFrame(), message, "Size Of Nodes", JOptionPane.DEFAULT_OPTION);


        } else if(s.equals("size of edges")) {
            String message = "The Size Of The Nodes In The Graph is: " + Ex2.getGrapg("data/G2.json").edgeSize();
            JOptionPane.showMessageDialog(new JFrame(), message, "Size Of Nodes", JOptionPane.DEFAULT_OPTION);
        }
        else if(s.equals("is graph connected")){
            String message;

            if(Ex2.getGrapgAlgo("data/G2.json").isConnected()) {
                message = "The Graph Is Connected :)";
            }
            else {
                message = "The Graph Isn't Connected :(";
            }
            JOptionPane.showMessageDialog(new JFrame(), message, "Is The Graph Connected", JOptionPane.DEFAULT_OPTION);



        }
        else if(s.equals("load graph")){
            new Load(Ex2.getGrapgAlgo("data/G2.json"), panel);
        }
        else if(s.equals("remove edge")){
            new RemoveEdge(Ex2.getGrapg("data/G2.json"), panel);


        }
        else if(s.equals("remove node")){
            new RemoveNode(Ex2.getGrapg("data/G2.json"), panel);

        }
        else if(s.equals("save")){
            new Save(Ex2.getGrapgAlgo("data/G2.json"));
        }
        else if(s.equals("shortest path")){
            new ShortestPath(Ex2.getGrapgAlgo("data/G2.json"));

        }

        else if(s.equals("shortest path dist")) {
            new ShortestPathDist(Ex2.getGrapgAlgo("data/G2.json"));
        }
        else if(s.equals("TSP")){
            new TSP(Ex2.getGrapgAlgo("data/G2.json"));

        }
    }

}
