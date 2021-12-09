package gui;
import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import codes.NodeDataImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Panel extends JPanel {

    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private double unitX;
    private double unitY;
    private Dimension screenSize ;

    public DirectedWeightedGraph graph;

    //constructor
    public Panel(DirectedWeightedGraph ans) {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.graph = ans;
        findEdge();
        unitX = screenSize.getWidth() / Math.abs(maxX - minX) * 0.975;
        unitY = screenSize.getHeight() / Math.abs(maxY - minY) * 0.9;
    }

    //find edge to use for the draw
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

    //draw the components edges and nodes(verticals)
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawEdges(g);
        drawNodes(g);
    }

    //draw nodes (verticals) on the panel
    public void drawNodes(Graphics g) {
        Iterator<NodeData> iter = graph.nodeIter();
        while (iter.hasNext()) {
            NodeData node = iter.next();
            // draw the node
            int x = (int) ((node.getLocation().x() - minX) * unitX);
            int y = (int) ((node.getLocation().y() - minY) * unitY);
            g.setColor(Color.red);
            g.fillOval(x, y, 24, 24);
            g.setColor(Color.WHITE);
             g.drawString("" + node.getKey(), x + 8, y + 15);
        }
    }

    //draw the Edge by using arrow and lines
   public void drawEdges(Graphics g) {
        Iterator<EdgeData> iter = graph.edgeIter();
        while (iter.hasNext()) {
            EdgeData edge = iter.next();
            //src
            double srcX = graph.getNode(edge.getSrc()).getLocation().x();
            srcX = ((srcX - minX) * unitX) + 12;
            double srcY = graph.getNode(edge.getSrc()).getLocation().y();
            srcY = ((srcY - minY) * unitY) + 12;
            //dest
            double destX = graph.getNode(edge.getDest()).getLocation().x();
            destX = ((destX - minX) * unitX) + 12;
            double destY = graph.getNode(edge.getDest()).getLocation().y();
            destY = ((destY - minY) * unitY) + 12;

            g.setColor(Color.black);
            //g.drawLine((int)srcX, (int)srcY, (int)destX, (int)destY);
             drawArrowLine(g, (int) srcX, (int) srcY, (int) destX, (int) destY, 30, 7);
            //System.out.println(edge);
        }
    }

    // draw lines for the Edges
    public void drawLines(Graphics g) {
        for (int i = 0; i < screenSize.width * maxX; i += unitX) {
            g.drawLine(i, 0, i, (int) screenSize.getHeight());
        }
        for (int i = 0; i < screenSize.getHeight() * maxY; i += unitY) {
            g.drawLine(0, i, (int) screenSize.getWidth(), i);
        }
    }

    private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1;
        yn = xn * sin + yn * cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }

}
