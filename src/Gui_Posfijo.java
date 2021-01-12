import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_Posfijo extends JFrame {

	private JPanel contentPane;
	private JTextField txtInfijo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Posfijo frame = new Gui_Posfijo();
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
	public Gui_Posfijo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Infijo:");
		lblNewLabel.setBounds(25, 31, 87, 14);
		contentPane.add(lblNewLabel);
		
		txtInfijo = new JTextField();
		txtInfijo.setBounds(124, 28, 202, 20);
		contentPane.add(txtInfijo);
		txtInfijo.setColumns(10);
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(124, 176, 300, 14);
		contentPane.add(lblResultado);
		JLabel lblPosfijo = new JLabel("");
		lblPosfijo.setBounds(124, 115, 300, 20);
		contentPane.add(lblPosfijo);
		
		JButton btnPosfijo = new JButton("Calcular");
		btnPosfijo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				//InfijoPosfijo objPosfijo=new InfijoPosfijo(txtInfijo.getText());
				//objPosfijo.generarPosfijo();
				//lblPosfijo.setText(objPosfijo.getPosfijo());
				//lblResultado.setText(objPosfijo.evaluarPosfijo(objPosfijo.getPosfijo()));
				
				//prueba 2
				try
				{
					String posfijo="";
					ClsSolucion objSolucion=new ClsSolucion();
					for (String elemento : objSolucion.generarPosfijo(txtInfijo.getText()))
						posfijo+=elemento;
					lblPosfijo.setText(posfijo);
					lblResultado.setText(objSolucion.calcular(txtInfijo.getText()));
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
				}
			}
		});
		btnPosfijo.setBounds(158, 59, 124, 23);
		contentPane.add(btnPosfijo);
		
		JLabel lblNewLabel_1 = new JLabel("Posfijo:");
		lblNewLabel_1.setBounds(10, 121, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado:");
		lblNewLabel_2.setBounds(10, 176, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
