package gui;

import api.DirectedWeightedGraphAlgorithms;
import codes.Ex2;

import javax.swing.*;

public class G3 extends  JFrame{
    private DirectedWeightedGraphAlgorithms graphAlgo;
    private MyPanel panel;

    public G3(DirectedWeightedGraphAlgorithms ans){
        super();
        graphAlgo = ans;
        panel = new MyPanel(ans.getGraph());
        panel.init(Ex2.getGrapgAlgo("data/G3.json").getGraph());
        panel.repaint();
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }
}

