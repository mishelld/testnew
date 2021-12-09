package gui;

import api.EdgeData;
import codes.DirectedWeightedGraphImpl;
import codes.GeoLocationImpl;

import javax.swing.*;
import java.awt.*;

public class ShowGraph  extends JComponent {

    private DirectedWeightedGraphImpl graph;
    public ShowGraph(DirectedWeightedGraphImpl graph){
        this.graph = graph;
    }
    public void paint(Graphics g)
    {
        for(EdgeData edge: graph.getEdges().values()){
            int multiple = 10;
            GeoLocationImpl src = (GeoLocationImpl) graph.getNode(edge.getSrc()).getLocation();
            GeoLocationImpl dest = (GeoLocationImpl) graph.getNode(edge.getDest()).getLocation();
            double srcX = src.x()  ;
            double srcY = src.y() ;
            double destX = dest.x() *multiple;
            double destY = dest.y() * multiple;


            g.drawLine((int)srcX, (int) srcY, (int)destX, (int) destY);

        }

    }
//    public static void main(String[] a)
//    {
//
//        // creating object of JFrame(Window popup)
//        JFrame window = new JFrame();
//
//        // setting closing operation
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // setting size of the pop window
//        window.setBounds(30, 30, 200, 200);
//
//        // setting canvas for draw
//        window.getContentPane().add(new ShowGraph());
//
//        // set visibility
//        window.setVisible(true);
//    }
}
