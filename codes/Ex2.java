package codes;

import api.*;

import gui.Frame;
import gui.MyFrame;
import gui.MyOpenScrean;
import gui.OpenScreen;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is the main class for Ex2 - your implementation will be tested
 * using this class.
 */

public class Ex2 {
    public static String json_file;// = "data/G1.json";

    public static void main(String[] args) {
         DirectedWeightedGraphAlgorithms graphAlgo = new DirectedWeightedGraphAlgorithmsImpl();

        graphAlgo.init(getGrapg(json_file));
        do {
            MyOpenScrean openScrean = new MyOpenScrean();
            while (openScrean.isActive()|| openScrean.isVisible());
            System.out.println(json_file);
             try {
                DirectedWeightedGraphImpl graph = readGRaphFromJson(json_file);
                graphAlgo.init(graph);
             } catch (Exception e) {
                 String message = "File name not found :( \n Please try again:";
                 JOptionPane.showMessageDialog(new JFrame(), message, "File Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
         } while (graphAlgo.getGraph() == null);
         new MyFrame(graphAlgo);
       // runGUI("data/G2.json");



    }

    /**
     * This static function will be used to test your implementation
     *
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     **/
    public static DirectedWeightedGraph getGrapg(String json_file) {
        DirectedWeightedGraph graph;
        try {
            graph = readGRaphFromJson(json_file);
        } catch (Exception e) {
            e.printStackTrace();
            graph = new DirectedWeightedGraphImpl();
        }
        return graph;
    }

    /**
     * This static function will be used to test your implementation
     *
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraph graph = getGrapg(json_file);
        DirectedWeightedGraphAlgorithms graphAlgo = new DirectedWeightedGraphAlgorithmsImpl();
        graphAlgo.init(graph);
        return graphAlgo;
    }

    /**
     * This static function will run your GUI using the json fime.
     *
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     */
    public static void runGUI(String json_file) {

        DirectedWeightedGraphAlgorithms graphAlgo = getGrapgAlgo(json_file);
        new Frame(graphAlgo);
      //  new GUI((DirectedWeightedGraph) graphAlgo);

    }


    public static DirectedWeightedGraphImpl readGRaphFromJson(String json_file)
            throws FileNotFoundException, IOException, ParseException {
        DirectedWeightedGraphImpl ans = new DirectedWeightedGraphImpl();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(json_file));
        JSONObject jobj = (JSONObject) obj;
        JSONArray edges = (JSONArray) jobj.get("Edges");
        JSONArray nodes = (JSONArray) jobj.get("Nodes");
        for (Object o : nodes) {
            JSONObject temp = (JSONObject) o;
            NodeData n = new NodeDataImpl(Integer.parseInt(temp.get("id").toString()), temp.get("pos").toString());
            ans.addNode(n);
        }
        for (Object o : edges) {
            JSONObject temp = (JSONObject) o;
            if ((temp.get("src") != null) && temp.get("dest") != null && temp.get("w") != null) {
                int src = Integer.parseInt(temp.get("src").toString());
                int dest = Integer.parseInt(temp.get("dest").toString());
                double w = Double.parseDouble(temp.get("w").toString());
                ans.connect(src, dest, w);
            }
        }
        return ans;
    }
}