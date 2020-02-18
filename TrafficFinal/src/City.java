import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class City extends JPanel {
	final int laneHeight=300;
	final int bound1=50;
	final int bound2=650;
	boolean s1,s2,s3,s4,s5,s6,s7=false;
	boolean r1,r2,r3,r4,r5,r6,r7=false;
	ArrayList<Vehicle> v=new ArrayList<Vehicle>();
	int bry1=60,brx2=310,bry3=150,brx4=395,bry5=445,bry6=445,bry7=445;
	/**
	 * Create the panel.
	 */
	public City() {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
	}
	public void addVehicle(Vehicle vehicle) {
		v.add(vehicle);
	}
	public void paint(Graphics g) {

		super.paintComponent(g);

		
		g.setColor(Color.GRAY);
		g.fillRect(350, 0, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getHeight();b+=40) {
				g.fillRect(375, b, 5, 30);
			}
		}
		
		
		
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 100, 870, 50);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 120, 30, 5);
			}
		}
		
		
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 400, 870, 50);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 420, 30, 5);
			}
		}
		
		
		g.setColor(Color.GRAY);
		g.fillRect(150, 400, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(173, b, 5, 30);
			}
		}
		
		
		
		g.setColor(Color.GRAY);
		g.fillRect(650, 400, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(673, b, 5, 30);
			}
		}
//		signal(372, 60,g,false,false,true,false);
//		signal(310, 117,g,false,false,true,true);
//		signal(372, 150,g,false,true,true,false);
//		signal(372, 360,g,false,true,true,false);
//		signal(395, 117,g,false,false,true,true);
//		signal(170, 445,g,true,false,true,false);
//		signal(372, 445,g,true,false,true,false);
//		signal(670, 445,g,true,false,true,false);	
		
		signal(372, 60,g,true,false,false,false);
		signal(310, 117,g,true,false,false,true);
		signal(372, 150,g,true,false,false,false);
		signal(372, 360,g,true,false,false,false);
		signal(395, 117,g,true,false,false,true);
		signal(170, 445,g,true,false,false,false);
		signal(372, 445,g,true,false,false,false);
		signal(670, 445,g,true,false,false,false);	
		
		
		
		for(int a=0;a<v.size();a++) {
			v.get(a).paintMe(g);
		}
		
	}
	public void signal(int x,int y, Graphics g,boolean red,boolean yellow,boolean green,boolean turn) {
		if(turn==false) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 10, 40);
//		g.fillRect(372, 60, 10, 60);
		
		if(red==true) {
			g.setColor(Color.RED);
			g.fillOval(x+1, y+10, 8, 8);
			
			}
		else if(yellow==true) {
			g.setColor(Color.YELLOW);
			g.fillOval(x+1, y+10, 8, 8);
			}
		else {
			g.setColor(Color.GREEN);
			g.fillOval(x+1, y+10, 8, 8);}}
		else {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, 40, 10);
//			g.fillRect(372, 60, 10, 60);
			if(red==true) {
				g.setColor(Color.RED);
				g.fillOval(x+10, y+1, 8, 8);
				}
			else if(yellow==true) {
				g.setColor(Color.YELLOW);
				g.fillOval(x+10, y+1, 8, 8);
				}
			else {
				g.setColor(Color.GREEN);
				g.fillOval(x+10, y+1, 8, 8);}
			
		}
	}
	
	public void step() {
		for(int i=0;i<v.size();i++) {
			Vehicle vehicle=v.get(i);
			if(vehicle.turn1==true & !vehicle.road.equals("in")) {
				vehicle.setY(vehicle.getY()+vehicle.getSpeed());
				vehicle.setPosition(vehicle.getY()+vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				System.out.println(vehicle.road);
				
				
			}
			else if(vehicle.turn2==true & !vehicle.road.equals("in")){
				vehicle.setY(vehicle.getY()-vehicle.getSpeed());
				vehicle.setPosition(vehicle.getY()-vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				System.out.println(vehicle.road);
				
				}
			else if(vehicle.turn3==true & !vehicle.road.equals("in")){
				vehicle.setX(vehicle.getX()-vehicle.getSpeed());
				vehicle.setPosition(vehicle.getX()-vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				System.out.println(vehicle.road);
				System.out.println(vehicle.getX());
			
			}
			else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false & !vehicle.road.equals("in")) {
				vehicle.setX(vehicle.getX()+vehicle.getSpeed());
				vehicle.setPosition(vehicle.getX()+vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				System.out.println(vehicle.road);
			
			}
			else {
//				signal(372, 60,g1,true,false,false,false);
//				
			}	
		}
		}
	
	public void createCity(String s1,String s2,String s3) {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
	
	}	
	
	}

	


