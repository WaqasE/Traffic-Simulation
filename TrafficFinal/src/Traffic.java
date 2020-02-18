import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Traffic extends JFrame implements Runnable,ActionListener {
	private Vehicle vehicle[]=new Vehicle[20]; 
	private City c=new City();
	private JPanel contentPane;
	private boolean running=false;
	JButton btnRun = new JButton("Run\r\n");
	JButton btnStop = new JButton("Stop");
	private int total=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traffic frame = new Traffic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Traffic() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 629);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(c);
		
		addVehicle();
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStop.setBounds(40, 217, 89, 23);
		btnStop.addActionListener(this);
		contentPane.add(btnStop);
		
		
		
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRun.setBounds(40, 154, 89, 23);
		btnRun.addActionListener(this);
			
		contentPane.add(btnRun);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(40, 325, 89, 23);
		 btnSave.setVisible(false);
		contentPane.add(btnSave);
		
		JButton btnOpen = new JButton("Open\r\n");
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpen.setBounds(40, 271, 89, 23);
		btnOpen.setVisible(false);
		contentPane.add(btnOpen);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBounds(40, 217, 89, 23);
		btnEdit.setVisible(false);
		contentPane.add(btnEdit);
		
		JButton btnNewButton_2 = new JButton("Create");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(40, 154, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(56, 11, 99, 35);
		lblMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblMenu.setForeground(Color.WHITE);
		contentPane.add(lblMenu);
		
		JButton btnNewButton = new JButton("City\r\n");
		
		btnNewButton.setBounds(10, 81, 84, 23);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sim");
		
		btnNewButton_1.setBounds(104, 81, 75, 23);
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 20));
		contentPane.add(btnNewButton_1);
		
		JLabel lblMode = new JLabel("Mode:Sim");
		lblMode.setForeground(Color.WHITE);
		lblMode.setFont(new Font("Cambria", Font.BOLD, 20));
		lblMode.setBounds(10, 388, 119, 23);
		contentPane.add(lblMode);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Cambria", Font.BOLD, 20));
		lblStatus.setBounds(10, 432, 119, 23);
		contentPane.add(lblStatus);
		
		JLabel lblCityDefault = new JLabel("City: Default");
		lblCityDefault.setForeground(Color.WHITE);
		lblCityDefault.setFont(new Font("Cambria", Font.BOLD, 16));
		lblCityDefault.setBounds(31, 466, 108, 23);
		contentPane.add(lblCityDefault);
		
		JLabel lblVehicles = new JLabel("Vehicles:");
		lblVehicles.setForeground(Color.WHITE);
		lblVehicles.setFont(new Font("Cambria", Font.BOLD, 16));
		lblVehicles.setBounds(31, 500, 99, 23);
		contentPane.add(lblVehicles);
		
		JLabel label = new JLabel(String.valueOf(total));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Cambria", Font.BOLD, 16));
		label.setBounds(104, 500, 67, 23);
		contentPane.add(label);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnRun.setVisible(true);
				btnStop.setVisible(true);
				
				btnOpen.setVisible(false);
				btnSave.setVisible(false);
				btnEdit.setVisible(false);
				btnNewButton_2.setVisible(false);
				lblMode.setText("Mode: Sim");
				lblCityDefault.setVisible(true);
				lblVehicles.setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				btnRun.setVisible(false);
				btnStop.setVisible(false);
			
				btnOpen.setVisible(true);
				btnSave.setVisible(true);
				btnEdit.setVisible(true);
				btnNewButton_2.setVisible(true);
				lblStatus.setVisible(false);
				lblMode.setText("Mode: City");
				lblCityDefault.setVisible(false);
				lblVehicles.setVisible(false);
			}
		});
		
	}
	

	public void run() {
		while(running==true) {
			c.step();
			c.repaint();
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(btnRun)) {
			if(running==false) {
				running=true;
				Thread t=new Thread(this);
				t.start();
				
				
			}
			}
		if(event.getSource().equals(btnStop)) {
			running=false;
		}
	}
	public void addVehicle() {
	
		vehicle[total]=new Bike(185, 560);
		vehicle[total].turn2();
		c.addVehicle(vehicle[total]);
		total++;
		
		vehicle[total]=new Car(385, 560);
		vehicle[total].turn2();
		c.addVehicle(vehicle[total]);
		total++;
		
		vehicle[total]=new Bike(685, 560);
		vehicle[total].turn2();
		c.addVehicle(vehicle[total]);
		total++;
		
		vehicle[total]=new Car(354, 0);
		vehicle[total].turn1();
		c.addVehicle(vehicle[total]);
		total++;
		
		vehicle[total]=new Bus(0, 404);
		c.addVehicle(vehicle[total]);
		;
		total++;
		
		vehicle[total]=new Car(820, 135);
		c.addVehicle(vehicle[total]);
		vehicle[total].turn3();
		total++;
		
		vehicle[total]=new Bike(0, 104);
		c.addVehicle(vehicle[total]);
		total++;
		
		vehicle[total]=new Car(354, 150);
		c.addVehicle(vehicle[total]);
		vehicle[total].turn1();
		total++;
		
		vehicle[total]=new Bike(385, 370);
		c.addVehicle(vehicle[total]);
		vehicle[total].turn2();
		total++;
		
		
		
	}
	public void changeRate(int s) {
		
		for(int i=0;i<=total;i++) {
			vehicle[total].setSpeed(100);
		}
	}
}

