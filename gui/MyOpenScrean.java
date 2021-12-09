package gui;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import codes.Ex2;
import gui.pop.GetEdge;
import gui.pop.GetNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyOpenScrean extends JFrame implements ActionListener {
	static JTextField name;
	static JFrame f;
	static JButton button;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static JButton button4;
	private DirectedWeightedGraphAlgorithms graphAlgo;
	private MyPanel panel;




	static JLabel text;
	String ans;
	// default constructor

	//public MyOpenScrean(DirectedWeightedGraphAlgorithms ans ){
	//	panel = new MyPanel(ans.getGraph());

	//}
	public MyOpenScrean()
	{
		// create a new frame to store text field and button
		setTitle("Open Screan");
		setSize(1000,1000);
		setVisible(true);
		// create a label to display text
		text = new JLabel("Enter json file name or path");
		// create a new button
		button = new JButton("show graph G3");
		button1 = new JButton("show graph G2");
		button2 = new JButton("show graph G1");
		button3 = new JButton("graphG1");


		// addActionListener to button
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);



		// create a object of JTextField with 16 columns
		name = new JTextField(16);
    /*	name.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_ENTER){
					showgraph();
            	}
        	}
    	});*/

		// create a panel to add buttons and textfield
		JPanel p = new JPanel();
		// add buttons and textfield to panel
		//p.add(text);
	//	p.add(name);

		p.add(button);
		p.add(button1);
		p.add(button2);
		p.add(button3);

		// add panel to frame
		add(p);

		// set the size of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(true);
        setVisible(true);
	}

	// if the button is pressed
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if (s.equals("show graph G3")) {
			showgraphG3();
		}
		else if(s.equals("show graph G2")){
			showgraphG2();
		}
		else if(s.equals("show graph G1")){
			showgraphG1();

		}
		else if(s.equals("graphG1")){
			//new GetNode(graphAlgo.getGraph());

		}

	}
	// private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
	// 	if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
	// 		closeWindow();
	// 	 }
	// } 
	public void showgraphG3(){
		String h  = "data/G3.json";
		// set the text of the label to the text of the field
		Ex2.json_file = h;
		setVisible(false);
		this.dispose();
	}
	public void showgraphG2(){
		String h  = "data/G2.json";
		// set the text of the label to the text of the field
		Ex2.json_file = h;
		setVisible(false);
	//	this.dispose();
	}
	public void showgraphG1(){
		String h  = "data/G1.json";
		Ex2.json_file = h;
		setVisible(false);
		// this.dispose();
	}

}
