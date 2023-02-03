package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProyectoCajeroEntrada {

	private JFrame frame;
	private JButton btnRegistrarseInicio;
	private JLabel lblBOOBA;
	private JPanel panelInicio;
	private JButton btnIniciarInicio;
	private JLabel lblBienvanidaInicio;
	private JPanel panelRegistro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoCajeroEntrada window = new ProyectoCajeroEntrada();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProyectoCajeroEntrada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 659, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 643, 359);
		frame.getContentPane().add(panelInicio);
		panelInicio.setLayout(null);
		
		lblBOOBA = new JLabel("BOOBA");
		lblBOOBA.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblBOOBA.setBounds(89, 57, 200, 64);
		panelInicio.add(lblBOOBA);
		
		btnRegistrarseInicio = new JButton("Registrarse");
		btnRegistrarseInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
					Registro registro = new Registro();
					registro.setVisible(true);
			}
		});
		btnRegistrarseInicio.setBounds(456, 33, 145, 30);
		panelInicio.add(btnRegistrarseInicio);
		
		btnIniciarInicio = new JButton("Iniciar");
		btnIniciarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnIniciarInicio.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnIniciarInicio.setBounds(456, 255, 145, 72);
		panelInicio.add(btnIniciarInicio);
		
		lblBienvanidaInicio = new JLabel("Compra de entradas");
		lblBienvanidaInicio.setBounds(198, 171, 248, 108);
		panelInicio.add(lblBienvanidaInicio);
	
	}
}
