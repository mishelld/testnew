package gui;

import api.DirectedWeightedGraphAlgorithms;
import codes.Ex2;

import javax.swing.*;

public class G1 extends JFrame {
    private DirectedWeightedGraphAlgorithms graphAlgo;
    private MyPanel panel;

    public G1(DirectedWeightedGraphAlgorithms ans){
        super();
        graphAlgo = ans;
        panel = new MyPanel(ans.getGraph());
        panel.init(Ex2.getGrapgAlgo("data/G1.json").getGraph());
        panel.repaint();
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

}
