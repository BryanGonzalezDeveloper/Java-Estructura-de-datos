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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_Pila extends JFrame {

	private JPanel contentPane;
	ClsPila objPila=new ClsPila();
	private JTextField txtNum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Pila frame = new Gui_Pila();
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
	public Gui_Pila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero:");
		lblNewLabel.setBounds(37, 44, 95, 14);
		contentPane.add(lblNewLabel);
		
		txtNum = new JTextField();
		txtNum.setBounds(90, 41, 162, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 82, 113, 243);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnAdd = new JButton("Agregar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try
				{
					objPila.add(txtNum.getText());
					
					txtNum.setText("");
					list.setModel(objPila.Imprimir());
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnAdd.setBounds(262, 40, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnPeek = new JButton("Peek");
		btnPeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, objPila.peek());
			}
		});
		btnPeek.setBounds(407, 40, 89, 23);
		contentPane.add(btnPeek);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					JOptionPane.showMessageDialog(null, objPila.pop());
					list.setModel(objPila.Imprimir());
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
			}
		});
		btnPop.setBounds(407, 74, 89, 23);
		contentPane.add(btnPop);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					int indice=objPila.buscar(txtNum.getText());
					if(indice==-1)
					JOptionPane.showInternalMessageDialog(null, "El dato no se encuentra en la lista.");
					else
						JOptionPane.showInternalMessageDialog(null, "El dato se encuentra en el indice:"+indice);
					txtNum.setText("");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnBuscar.setBounds(265, 74, 89, 23);
		contentPane.add(btnBuscar);
	}
}
