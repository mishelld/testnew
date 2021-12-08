package gui;

//import api.NodeData;
import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;

public class Frame extends JFrame {
    private Panel panel;

    private DirectedWeightedGraphAlgorithms graphAlgo;

    public Frame(DirectedWeightedGraphAlgorithms ans) {
        super();
        graphAlgo = ans;
        panel = new Panel(ans.getGraph());
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    }