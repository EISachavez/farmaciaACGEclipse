package farmaciaACGeclipse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import farmaciaACGeclipse.dto.PedidoDTO;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pedidos {

	private JFrame frmPedidosFarmaciaAcg;
	private JTextField tfNombre;
	private JTextField tfCantidad;
	private final ButtonGroup buttonGroupDistribuidor = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos window = new Pedidos();
					window.frmPedidosFarmaciaAcg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPedidosFarmaciaAcg = new JFrame();
		frmPedidosFarmaciaAcg.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 15));
		frmPedidosFarmaciaAcg.getContentPane().setBackground(new Color(64, 128, 128));
		frmPedidosFarmaciaAcg.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Pedidos Farmacia ACG");
		lblTitulo.setFocusable(false);
		lblTitulo.setForeground(new Color(192, 192, 192));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(0, 11, 569, 48);
		frmPedidosFarmaciaAcg.getContentPane().add(lblTitulo);
		
		JLabel lblnombre = new JLabel("Nombre del medicamento:");
		lblnombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblnombre.setBounds(31, 90, 234, 22);
		frmPedidosFarmaciaAcg.getContentPane().add(lblnombre);
		
		JLabel lblCantidad = new JLabel("Cantidad solicitada:");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblCantidad.setBounds(31, 190, 234, 22);
		frmPedidosFarmaciaAcg.getContentPane().add(lblCantidad);
		
		JLabel lblTipo = new JLabel("Tipo de medicamento:");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTipo.setBounds(31, 141, 234, 22);
		frmPedidosFarmaciaAcg.getContentPane().add(lblTipo);
		
		JLabel lblDistribuidor = new JLabel("Distribuidor:");
		lblDistribuidor.setFont(new Font("Arial", Font.BOLD, 14));
		lblDistribuidor.setBounds(31, 242, 234, 22);
		frmPedidosFarmaciaAcg.getContentPane().add(lblDistribuidor);
		
		JLabel lblSucursal = new JLabel("Sucursal que solicita:");
		lblSucursal.setFont(new Font("Arial", Font.BOLD, 14));
		lblSucursal.setBounds(31, 297, 234, 22);
		frmPedidosFarmaciaAcg.getContentPane().add(lblSucursal);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		tfNombre.setBounds(228, 88, 311, 29);
		frmPedidosFarmaciaAcg.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
		        if(!Character.isDigit(tecla)){
		            e.consume();
		        }
			}
		});
		tfCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(228, 188, 311, 29);
		frmPedidosFarmaciaAcg.getContentPane().add(tfCantidad);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccione --", "analgésico", "analéptico", "anestésico", "antiácido", "antidepresivo", "antibióticos"}));
		cbTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		cbTipo.setBounds(228, 138, 311, 29);
		frmPedidosFarmaciaAcg.getContentPane().add(cbTipo);
		
		JRadioButton rdbtnCofarma = new JRadioButton("Cofarma");
		buttonGroupDistribuidor.add(rdbtnCofarma);
		rdbtnCofarma.setBackground(new Color(64, 128, 128));
		rdbtnCofarma.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnCofarma.setBounds(228, 243, 86, 23);
		frmPedidosFarmaciaAcg.getContentPane().add(rdbtnCofarma);
		
		JRadioButton rdbtnEmpsephar = new JRadioButton("Empsephar");
		buttonGroupDistribuidor.add(rdbtnEmpsephar);
		rdbtnEmpsephar.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnEmpsephar.setBackground(new Color(64, 128, 128));
		rdbtnEmpsephar.setBounds(316, 242, 109, 23);
		frmPedidosFarmaciaAcg.getContentPane().add(rdbtnEmpsephar);
		
		JRadioButton rdbtnCemefar = new JRadioButton("Cemefar");
		buttonGroupDistribuidor.add(rdbtnCemefar);
		rdbtnCemefar.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnCemefar.setBackground(new Color(64, 128, 128));
		rdbtnCemefar.setBounds(430, 242, 109, 23);
		frmPedidosFarmaciaAcg.getContentPane().add(rdbtnCemefar);
		
		JCheckBox chckbxPrincipal = new JCheckBox("Principal");
		chckbxPrincipal.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxPrincipal.setBackground(new Color(64, 128, 128));
		chckbxPrincipal.setBounds(228, 298, 97, 23);
		frmPedidosFarmaciaAcg.getContentPane().add(chckbxPrincipal);
		
		JCheckBox chckbxSecundaria = new JCheckBox("Secundaria");
		chckbxSecundaria.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxSecundaria.setBackground(new Color(64, 128, 128));
		chckbxSecundaria.setBounds(358, 298, 97, 23);
		frmPedidosFarmaciaAcg.getContentPane().add(chckbxSecundaria);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showOptionDialog(null, "¿Desea limpiar el formulario?", "Limpiar formulario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Cancelar", "Aceptar"}, "Cancelar");
		        if(opcion == 1){
		            tfNombre.setText("");
		            cbTipo.setSelectedIndex(0);
		            tfCantidad.setText("");
		            buttonGroupDistribuidor.clearSelection();
		            chckbxPrincipal.setSelected(false);
		            chckbxSecundaria.setSelected(false);                    
		        }
			}
		});
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setBackground(new Color(128, 0, 0));
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnBorrar.setBounds(122, 387, 133, 42);
		frmPedidosFarmaciaAcg.getContentPane().add(btnBorrar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$";
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(tfNombre.getText());
		        
		        if(!matcher.matches()){
		            JOptionPane.showMessageDialog(null, "El valor de nombre del medicamento no es correcto o contiene caracteres invalidos.", "Error de nombre", JOptionPane.ERROR_MESSAGE);            
		            return;
		        }
		        
		        if(cbTipo.getSelectedIndex() <= 0){
		            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de medicamento.", "Error de tipo de medicamento", JOptionPane.ERROR_MESSAGE);            
		            return;
		        }
		        
		        if(tfCantidad.getText().isEmpty() || Integer.parseInt(tfCantidad.getText()) <= 0){
		            JOptionPane.showMessageDialog(null, "Debe digitar una cantidad mayor a cero.", "Error de cantidad de medicamento", JOptionPane.ERROR_MESSAGE);            
		            return;
		        }
		        
		        if(!rdbtnCemefar.isSelected() && !rdbtnCofarma.isSelected() && !rdbtnEmpsephar.isSelected()){
		            JOptionPane.showMessageDialog(null, "Debe seleccionar el distribuidor del medicamento.", "Error de distribuidor", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        if(!chckbxPrincipal.isSelected() && !chckbxSecundaria.isSelected()){
		            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una sucursal solicitante.", "Error de sucursal", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		                
		        PedidoDTO pedido = new PedidoDTO();
		        pedido.setNombreMedicamento(tfNombre.getText());
		        pedido.setTipoMedicamento(cbTipo.getSelectedItem().toString());
		        pedido.setCantidadMedicamento(tfCantidad.getText());
		        if(rdbtnCemefar.isSelected()){
		            pedido.setDistribuidor("Cemefar");
		        } else if(rdbtnCofarma.isSelected()){
		            pedido.setDistribuidor("Cofarma");
		        } else if(rdbtnEmpsephar.isSelected()){
		            pedido.setDistribuidor("Empsephar");
		        }
		        
		        if(chckbxPrincipal.isSelected()){
		            pedido.setSucursalPrincipal("Calle de la Rosa n. 28");
		        }
		        
		        if(chckbxSecundaria.isSelected()){
		            pedido.setSucursalSecundaria("Calle Alcazabilla n. 3");
		        }
		        
		        Resumen resumen = new Resumen();
		        resumen.setPedido(pedido);
		        resumen.frmResumenDelPedido.setVisible(true);
		        frmPedidosFarmaciaAcg.dispose();
		        
		        
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConfirmar.setBackground(new Color(0, 255, 0));
		btnConfirmar.setBounds(333, 387, 133, 42);
		frmPedidosFarmaciaAcg.getContentPane().add(btnConfirmar);
		frmPedidosFarmaciaAcg.setTitle("Pedidos Farmacia ACG");
		frmPedidosFarmaciaAcg.setResizable(false);
		frmPedidosFarmaciaAcg.setName("pedidos");
		frmPedidosFarmaciaAcg.setBounds(100, 100, 585, 493);
		frmPedidosFarmaciaAcg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
