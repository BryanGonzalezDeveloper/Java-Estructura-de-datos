package Arboles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_Arboles extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	ClsArbolBinario objArbol=new ClsArbolBinario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Arboles frame = new Gui_Arboles();
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
	public Gui_Arboles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dato:");
		lblNewLabel.setBounds(10, 23, 106, 14);
		contentPane.add(lblNewLabel);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(55, 20, 157, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 111, 116, 307);
		contentPane.add(scrollPane);
		
		JList Preorden = new JList();
		scrollPane.setViewportView(Preorden);
		
		JButton btnPreorden = new JButton("Preorden");
		btnPreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objArbol.modeloPreorden=new DefaultListModel<Integer>();
				Preorden.setModel(objArbol.preorden(objArbol.getRaiz()));
			}
		});
		scrollPane.setColumnHeaderView(btnPreorden);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(195, 111, 116, 307);
		contentPane.add(scrollPane_1);
		
		JList Inorden = new JList();
		scrollPane_1.setViewportView(Inorden);
		
		JButton btnInorden = new JButton("Inorden");
		btnInorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objArbol.modeloInorden=new DefaultListModel<Integer>();
				Inorden.setModel(objArbol.inorden(objArbol.getRaiz()));
			}
		});
		scrollPane_1.setColumnHeaderView(btnInorden);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(355, 111, 116, 307);
		contentPane.add(scrollPane_2);
		
		JList Posorden = new JList();
		scrollPane_2.setViewportView(Posorden);
		
		JButton btnPosorden = new JButton("Posorden");
		btnPosorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objArbol.modeloPosorden=new DefaultListModel<Integer>();
				Posorden.setModel(objArbol.posorden(objArbol.getRaiz()));
			}
		});
		scrollPane_2.setColumnHeaderView(btnPosorden);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				objArbol.insertar(Integer.parseInt(txtNumero.getText()));
				txtNumero.setText("");
			}
		});
		btnInsertar.setBounds(222, 19, 106, 23);
		contentPane.add(btnInsertar);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(objArbol.buscar(Integer.parseInt(txtNumero.getText())))
					JOptionPane.showMessageDialog(null, "Dato encontrado");
				else
					JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO.");
			}
		});
		btnBuscar.setBounds(222, 53, 106, 23);
		contentPane.add(btnBuscar);
	}
}
