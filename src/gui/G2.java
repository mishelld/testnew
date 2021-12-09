package gui;

import api.DirectedWeightedGraphAlgorithms;
import codes.Ex2;

import javax.swing.*;

public class G2 extends JFrame {
    private DirectedWeightedGraphAlgorithms graphAlgo;
    private MyPanel panel;

    public G2(DirectedWeightedGraphAlgorithms ans) {
        super();
        graphAlgo = ans;
        panel = new MyPanel(ans.getGraph());
        panel.init(Ex2.getGrapgAlgo("data/G2.json").getGraph());
        panel.repaint();
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }
}

