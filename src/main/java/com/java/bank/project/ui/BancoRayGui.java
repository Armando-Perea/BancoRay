package com.java.bank.project.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.java.bank.project.model.Cliente;
import com.java.bank.project.repo.impl.AdministrarCliente;
import com.java.bank.project.util.BancoRayUtils;
import com.java.bank.project.util.BankImageValidation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class BancoRayGui extends JFrame {

	public static JTabbedPane BankTabMainPane;
	public static JPanel BankPane;
	public static JTextField txtIdClienteConsulta;
	public static JTextField txtDisponibleConsulta;
	public static JTextField txtNoCuentaConsulta;
	public static JTextField txtNombreConsulta;
	public static JPasswordField txtNipConsulta;
	public static JLabel lblFotoCliente;
	Cliente cliente = new Cliente();
	public static Double saldoCliente=0.0;
	private JTextField txtReferencia;
	private JTextField txtTotalServicio;
	private JTextField textField;
	private JTextField txtTotalTransferencia;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoRayGui frame = new BancoRayGui();
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
	public BancoRayGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 700);
		BankPane = new JPanel();
		BankPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BankPane);
		BankPane.setLayout(new BorderLayout(0, 0));
		
		BankTabMainPane = new JTabbedPane(JTabbedPane.TOP);
		BankPane.add(BankTabMainPane, BorderLayout.CENTER);
		
		JPanel PanelAccesoBanca = new JPanel();
		PanelAccesoBanca.setBackground(Color.WHITE);
		BankTabMainPane.addTab("Acceso a Banca", null, PanelAccesoBanca, null);
		PanelAccesoBanca.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BancoRayGui.class.getResource("/com/java/bank/project/ui/BancoRayLogo.png")));
		lblNewLabel.setBounds(10, 11, 218, 99);
		PanelAccesoBanca.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Control de Acceso");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 36));
		lblNewLabel_1.setBounds(344, 61, 352, 88);
		PanelAccesoBanca.add(lblNewLabel_1);
		
		txtIdClienteConsulta = new JTextField();
		txtIdClienteConsulta.setBounds(153, 175, 79, 29);
		PanelAccesoBanca.add(txtIdClienteConsulta);
		txtIdClienteConsulta.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("IdCliente:");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(78, 170, 87, 37);
		PanelAccesoBanca.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("NoCuenta:");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(362, 280, 87, 37);
		PanelAccesoBanca.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Nombre Cliente:");
		lblNewLabel_4_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(328, 228, 121, 37);
		PanelAccesoBanca.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Disponible: $");
		lblNewLabel_4_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(359, 359, 100, 37);
		PanelAccesoBanca.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("NIP:");
		lblNewLabel_4_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_3_1.setBounds(242, 170, 37, 37);
		PanelAccesoBanca.add(lblNewLabel_4_3_1);
		
		txtDisponibleConsulta = new JTextField();
		txtDisponibleConsulta.setColumns(10);
		txtDisponibleConsulta.setBounds(469, 364, 106, 29);
		PanelAccesoBanca.add(txtDisponibleConsulta);
		
		txtNoCuentaConsulta = new JTextField();
		txtNoCuentaConsulta.setColumns(10);
		txtNoCuentaConsulta.setBounds(459, 285, 155, 29);
		PanelAccesoBanca.add(txtNoCuentaConsulta);
		
		txtNombreConsulta = new JTextField();
		txtNombreConsulta.setColumns(10);
		txtNombreConsulta.setBounds(459, 233, 155, 29);
		PanelAccesoBanca.add(txtNombreConsulta);
		
		txtNipConsulta = new JPasswordField();
		txtNipConsulta.setBounds(276, 175, 87, 29);
		PanelAccesoBanca.add(txtNipConsulta);
		
		JButton btnAccesar = new JButton("Accesar");
		btnAccesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setIdCliente(Integer.parseInt(txtIdClienteConsulta.getText()));
				cliente.setNip(Integer.parseInt(txtNipConsulta.getText()));
				cliente = AdministrarCliente.consultarCliente(cliente);
				System.out.println(cliente.toString());
				txtNombreConsulta.setText(cliente.getNombre());
				txtNoCuentaConsulta.setText(cliente.getNoCuenta().toString());
				txtDisponibleConsulta.setText(cliente.getSaldo().toString());
				saldoCliente = cliente.getSaldo();
				BankImageValidation.setSearchUpdateStudentImage(cliente.getFoto());
			}
		});
		btnAccesar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAccesar.setForeground(Color.WHITE);
		btnAccesar.setBackground(new Color(0, 0, 128));
		btnAccesar.setBounds(403, 174, 100, 30);
		PanelAccesoBanca.add(btnAccesar);
		
		lblFotoCliente = new JLabel("Foto Cliente");
		lblFotoCliente.setBounds(111, 216, 194, 257);
		PanelAccesoBanca.add(lblFotoCliente);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoRayGui.BankTabMainPane.setSelectedIndex(1);
			}
		});
		btnServicios.setForeground(Color.WHITE);
		btnServicios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnServicios.setBackground(new Color(0, 0, 128));
		btnServicios.setBounds(403, 428, 106, 43);
		PanelAccesoBanca.add(btnServicios);
		
		JButton btnTransferencias = new JButton("Transferencias");
		btnTransferencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoRayGui.BankTabMainPane.setSelectedIndex(2);
			}
		});
		btnTransferencias.setForeground(Color.WHITE);
		btnTransferencias.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTransferencias.setBackground(new Color(0, 0, 128));
		btnTransferencias.setBounds(561, 428, 106, 43);
		PanelAccesoBanca.add(btnTransferencias);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalir.setBackground(new Color(0, 0, 128));
		btnSalir.setBounds(709, 549, 106, 43);
		PanelAccesoBanca.add(btnSalir);
		
		JButton btnFotoConsulta = new JButton("Accesar");
		btnFotoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File imageFile;
				int result;
				BancoRayGui.lblFotoCliente.setIcon(null);
				BancoRayGui.lblFotoCliente.setText(null);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG AND PNG", "jpg","png","jpeg");
				JFileChooser fileChooserStudetPhoto = new JFileChooser(FileSystemView.getFileSystemView()); 
				fileChooserStudetPhoto.setFileFilter(filter);
				result = fileChooserStudetPhoto.showOpenDialog(null);
				if(JFileChooser.APPROVE_OPTION == result) {
					imageFile = fileChooserStudetPhoto.getSelectedFile();
					//LblStudentPhoto.setText(null);
					BankImageValidation.validateImagePath(imageFile);
				}
			}
		});
		btnFotoConsulta.setForeground(Color.WHITE);
		btnFotoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFotoConsulta.setBackground(new Color(0, 0, 128));
		btnFotoConsulta.setBounds(128, 501, 100, 30);
		PanelAccesoBanca.add(btnFotoConsulta);
		
		JPanel PanelPagoServicios = new JPanel();
		PanelPagoServicios.setBackground(Color.WHITE);
		BankTabMainPane.addTab("Pagar Servicios", null, PanelPagoServicios, null);
		PanelPagoServicios.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BancoRayGui.class.getResource("/com/java/bank/project/ui/BancoRayLogo.png")));
		lblNewLabel_2.setBounds(10, 11, 218, 99);
		PanelPagoServicios.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pago de Servicios");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 36));
		lblNewLabel_1_1.setBounds(344, 61, 352, 88);
		PanelPagoServicios.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TOTALPLAY", "TELMEX", "MOVISTAR", "TELCEL", "AT&T", "SAT", "CFE", "CONAGUA", "HERBALIFE", "JAFRA", "REFRENDO"}));
		comboBox.setBounds(344, 202, 309, 41);
		PanelPagoServicios.add(comboBox);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Servicio:");
		lblNewLabel_4_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1.setBounds(260, 203, 74, 37);
		PanelPagoServicios.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Referencia:");
		lblNewLabel_4_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1_1.setBounds(241, 272, 90, 37);
		PanelPagoServicios.add(lblNewLabel_4_2_1_1);
		
		txtReferencia = new JTextField();
		txtReferencia.setColumns(10);
		txtReferencia.setBounds(344, 272, 236, 29);
		PanelPagoServicios.add(txtReferencia);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("Total: $");
		lblNewLabel_4_2_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1.setBounds(269, 333, 65, 37);
		PanelPagoServicios.add(lblNewLabel_4_2_1_1_1);
		
		txtTotalServicio = new JTextField();
		txtTotalServicio.setColumns(10);
		txtTotalServicio.setBounds(344, 333, 119, 29);
		PanelPagoServicios.add(txtTotalServicio);
		
		JButton btnNewButton = new JButton("PAGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BancoRayUtils.validarFondos(saldoCliente, Double.parseDouble(txtTotalServicio.getText()))) {
					saldoCliente = 	BancoRayUtils.restarACuenta(saldoCliente, Double.parseDouble(txtTotalServicio.getText()));
					txtDisponibleConsulta.setText(saldoCliente.toString());
					JOptionPane.showMessageDialog(null, "Pago Realizado!");
					JOptionPane.showMessageDialog(null, "Disponible: $"+saldoCliente);
				}else {
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente: $"+saldoCliente);
				}
			}
		});
		btnNewButton.setBounds(344, 415, 124, 37);
		PanelPagoServicios.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		BankTabMainPane.addTab("Transferir", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(BancoRayGui.class.getResource("/com/java/bank/project/ui/BancoRayLogo.png")));
		lblNewLabel_3.setBounds(10, 11, 218, 99);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Transferencias");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_2.setFont(new Font("Century", Font.BOLD, 36));
		lblNewLabel_1_2.setBounds(392, 99, 293, 88);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("Referencia:");
		lblNewLabel_4_2_1_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2.setBounds(335, 341, 90, 37);
		panel.add(lblNewLabel_4_2_1_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(435, 346, 236, 29);
		panel.add(textField);
		
		JLabel lblNewLabel_4_2_1_1_1_1 = new JLabel("Total: $");
		lblNewLabel_4_2_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_1.setBounds(357, 400, 65, 37);
		panel.add(lblNewLabel_4_2_1_1_1_1);
		
		txtTotalTransferencia = new JTextField();
		txtTotalTransferencia.setColumns(10);
		txtTotalTransferencia.setBounds(435, 405, 119, 29);
		panel.add(txtTotalTransferencia);
		
		JButton btnBotonTransferir = new JButton("PAGAR");
		btnBotonTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BancoRayUtils.validarFondos(saldoCliente, Double.parseDouble(txtTotalTransferencia.getText()))) {
					saldoCliente = 	BancoRayUtils.restarACuenta(saldoCliente, Double.parseDouble(txtTotalTransferencia.getText()));
					txtDisponibleConsulta.setText(saldoCliente.toString());
					UUID uuid = UUID.randomUUID();
					JOptionPane.showMessageDialog(null, "Transferencia Realizada!");
					JOptionPane.showMessageDialog(null, "Guia Interbancaria: "+ uuid.toString());
					JOptionPane.showMessageDialog(null, "Disponible: $"+saldoCliente);
				}else {
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente: $"+saldoCliente);
				}
			}
		});
		btnBotonTransferir.setBounds(435, 461, 124, 37);
		panel.add(btnBotonTransferir);
		
		JLabel lblNewLabel_4_2_1_1_2_1 = new JLabel("CLABE:");
		lblNewLabel_4_2_1_1_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1.setBounds(369, 231, 56, 37);
		panel.add(lblNewLabel_4_2_1_1_2_1);
		
		JLabel lblNewLabel_4_2_1_1_2_2 = new JLabel("BANCO:");
		lblNewLabel_4_2_1_1_2_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_2.setBounds(360, 279, 65, 37);
		panel.add(lblNewLabel_4_2_1_1_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(435, 236, 236, 29);
		panel.add(textField_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CITY BANAMEX\t", "SANTANDER", "BANORTE", "INVEX", "BANCO AZTECA", "SCOTIABANK", "HSBC"}));
		comboBox_1.setBounds(435, 280, 173, 37);
		panel.add(comboBox_1);
	}
}
