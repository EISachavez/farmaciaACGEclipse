package farmaciaACGeclipse;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import farmaciaACGeclipse.dto.PedidoDTO;

public class Resumen extends JFrame {

	JFrame frmResumenDelPedido;
	private PedidoDTO pedido;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resumen window = new Resumen();
					window.frmResumenDelPedido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Resumen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {				
		frmResumenDelPedido = new JFrame();
		frmResumenDelPedido.setTitle("Resumen del pedido");
		frmResumenDelPedido.getContentPane().setBackground(new Color(61, 58, 90));
		frmResumenDelPedido.getContentPane().setLayout(null);
		
		
		
		JButton btnCancelar = new JButton("Cancelar pedido");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmResumenDelPedido.dispose();
			}
		});
		btnCancelar.setForeground(new Color(192, 192, 192));
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setBounds(211, 226, 162, 30);
		frmResumenDelPedido.getContentPane().add(btnCancelar);
		
		JButton btnNewButton = new JButton("Confirmar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pedido enviado con las siguientes caracteristicas: ");
		        pedido.pedidoToString();
		        
		        Pedidos pedidos = new Pedidos();
		        pedidos.frmPedidosFarmaciaAcg.setVisible(true);
		        frmResumenDelPedido.dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(461, 226, 162, 30);
		frmResumenDelPedido.getContentPane().add(btnNewButton);
		frmResumenDelPedido.setBounds(100, 100, 850, 352);
		frmResumenDelPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
		
		String direccionP = "";
		String direccionS = "";
		
		JLabel lblPedido = new JLabel("Pedido al distribuidor " + pedido.getDistribuidor());
		lblPedido.setForeground(new Color(192, 192, 192));
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedido.setFont(new Font("Arial", Font.BOLD, 22));
		lblPedido.setBounds(0, 11, 834, 39);
		frmResumenDelPedido.getContentPane().add(lblPedido);
		
		JLabel lblDetalle = new JLabel(pedido.getCantidadMedicamento() + " unidades del " + pedido.getTipoMedicamento() + " " + pedido.getNombreMedicamento());
		lblDetalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalle.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDetalle.setForeground(new Color(192, 192, 192));
		lblDetalle.setBounds(0, 77, 834, 30);
		frmResumenDelPedido.getContentPane().add(lblDetalle);	
		
		if(pedido.getSucursalPrincipal() != null && pedido.getSucursalSecundaria() != null){
			direccionP = "Para la farmacia situada en " + pedido.getSucursalPrincipal();
			direccionS = "y para la situada en " + pedido.getSucursalSecundaria();
        } else if(pedido.getSucursalPrincipal() != null && pedido.getSucursalSecundaria() == null){
        	direccionP = "Para la farmacia situada en " + pedido.getSucursalPrincipal();
        } else if(pedido.getSucursalPrincipal() == null && pedido.getSucursalSecundaria() != null){
        	direccionP = "Para la farmacia situada en " + pedido.getSucursalSecundaria();
        } 
		
		JLabel lblPrincipal = new JLabel(direccionP);
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setForeground(Color.LIGHT_GRAY);
		lblPrincipal.setFont(new Font("Arial", Font.PLAIN, 17));
		lblPrincipal.setBounds(0, 118, 834, 30);
		frmResumenDelPedido.getContentPane().add(lblPrincipal);
		
		JLabel lblSecundaria = new JLabel(direccionS);
		lblSecundaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecundaria.setForeground(Color.LIGHT_GRAY);
		lblSecundaria.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSecundaria.setBounds(0, 150, 834, 30);
		frmResumenDelPedido.getContentPane().add(lblSecundaria);
	}

}
