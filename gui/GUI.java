package gui;

import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import codes.NodeDataImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;


public class GUI extends  JFrame {
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private double unitX;
    private double unitY;
    private Dimension screenSize;


    // private int FRAME_ZISE;
    // private double FRAME_SIZE;

    //static int GAME_UNITS;
    public DirectedWeightedGraph graph;

    //constructor
    public GUI(DirectedWeightedGraph ans) {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setBackground(Color.GRAY);
        this.setFocusable(true);
        this.graph = ans;
        findEdge();
    }
    private void findEdge() {
        Iterator<NodeData> n = graph.nodeIter();
        NodeData node = n.next();
        minX = node.getLocation().x();
        minY = node.getLocation().y();
        maxX = node.getLocation().x();
        maxY = node.getLocation().y();
        while (n.hasNext()) {
            node = n.next();
            minX = Math.min(minX, node.getLocation().x());
            minY = Math.min(minY, node.getLocation().y());

            maxX = Math.max(maxX, node.getLocation().x());
            maxY = Math.max(maxY, node.getLocation().y());
        }

    }


    public void paint(Graphics g) {

    Iterator<NodeData> iter = graph.nodeIter();
    while (iter.hasNext()) {
        NodeData node = iter.next();
        System.out.println(node.getLocation().x());
        g.setColor(Color.GREEN);
        g.fillOval((int) node.getLocation().x(), (int) node.getLocation().y(),30,30);


    }
}



    }
