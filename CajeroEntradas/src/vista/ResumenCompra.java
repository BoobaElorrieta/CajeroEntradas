package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResumenCompra extends JFrame {

	private JPanel contentPane;	
	private static final long serialVersionUID = 1L;
	private JTextArea txtAreaEntradasSeleccionadas;
	private JTextArea txtAreaPrecioTotal;
	private JButton btnComprar;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public ResumenCompra() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResumenCompra = new JLabel("Resumen de Compra");
		lblResumenCompra.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResumenCompra.setBounds(214, 11, 231, 41);
		contentPane.add(lblResumenCompra);
		
		JLabel lblEntradasSeleccionadas = new JLabel("Entradas Seleccionadas");
		lblEntradasSeleccionadas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEntradasSeleccionadas.setBounds(90, 81, 175, 21);
		contentPane.add(lblEntradasSeleccionadas);
		
		txtAreaEntradasSeleccionadas = new JTextArea();
		txtAreaEntradasSeleccionadas.setEditable(false);
		txtAreaEntradasSeleccionadas.setBounds(10, 114, 324, 296);
		contentPane.add(txtAreaEntradasSeleccionadas);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total: ");
		lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecioTotal.setBounds(344, 119, 101, 15);
		contentPane.add(lblPrecioTotal);
		
		txtAreaPrecioTotal = new JTextArea();
		txtAreaPrecioTotal.setEditable(false);
		txtAreaPrecioTotal.setBounds(455, 117, 127, 20);
		contentPane.add(txtAreaPrecioTotal);
		
		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnComprar.setBounds(344, 349, 127, 61);
		contentPane.add(btnComprar);
		
		btnCancelar = new JButton("Cancelar Compra");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnCancelar.setBounds(492, 349, 158, 61);
		contentPane.add(btnCancelar);
	}
}
