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
import com.java.bank.project.util.BankImageValidation;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class BancoRayEjecutivoGui extends JFrame {

	public static JPanel contentPane;
	public static JTextField txtIdClienteAlta;
	public static JPasswordField txtNipAlta;
	public static JTextField txtNombreCliente;
	public static JTextField txtNoCuenta;
	public static JTextField txtSaldo;
	public static JLabel lblFotoCliente;
	public static String fotoPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoRayEjecutivoGui frame = new BancoRayEjecutivoGui();
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
	public BancoRayEjecutivoGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Alta Cliente", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BancoRayEjecutivoGui.class.getResource("/com/java/bank/project/ui/BancoRayLogo.png")));
		lblNewLabel.setBounds(10, 11, 204, 77);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alta de Cliente");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 36));
		lblNewLabel_1_1.setBounds(195, 99, 295, 71);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("IdCliente:");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(293, 198, 87, 37);
		panel.add(lblNewLabel_4);
		
		txtIdClienteAlta = new JTextField();
		txtIdClienteAlta.setColumns(10);
		txtIdClienteAlta.setBounds(379, 203, 79, 29);
		panel.add(txtIdClienteAlta);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("NIP:");
		lblNewLabel_4_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_3_1.setBounds(335, 255, 37, 37);
		panel.add(lblNewLabel_4_3_1);
		
		txtNipAlta = new JPasswordField();
		txtNipAlta.setBounds(382, 260, 87, 29);
		panel.add(txtNipAlta);
		
		JLabel lblNewLabel_4_2 = new JLabel("Nombre Cliente:");
		lblNewLabel_4_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(251, 312, 121, 37);
		panel.add(lblNewLabel_4_2);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(382, 317, 155, 29);
		panel.add(txtNombreCliente);
		
		JLabel lblNewLabel_4_1 = new JLabel("NoCuenta:");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(294, 372, 87, 37);
		panel.add(lblNewLabel_4_1);
		
		txtNoCuenta = new JTextField();
		txtNoCuenta.setColumns(10);
		txtNoCuenta.setBounds(382, 377, 155, 29);
		panel.add(txtNoCuenta);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(366, 437, 106, 29);
		panel.add(txtSaldo);
		
		JLabel lblNewLabel_4_3 = new JLabel("Saldo: $");
		lblNewLabel_4_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(302, 432, 67, 37);
		panel.add(lblNewLabel_4_3);
		
		lblFotoCliente = new JLabel("Foto Cliente");
		lblFotoCliente.setBounds(82, 192, 132, 165);
		panel.add(lblFotoCliente);
		
		JButton btnGuardarCliente = new JButton("Guardar");
		btnGuardarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(Integer.parseInt(txtIdClienteAlta.getText()));
				cliente.setNip(Integer.parseInt(txtNipAlta.getText()));
				cliente.setNoCuenta(Integer.parseInt(txtNoCuenta.getText()));
				cliente.setNombre(txtNombreCliente.getText());
				cliente.setCuentaActiva(true);
				cliente.setSaldo(Double.parseDouble(txtSaldo.getText()));
				cliente.setFoto(fotoPath);
				AdministrarCliente.crearNuevoCliente(cliente);
			}
		});
		btnGuardarCliente.setForeground(Color.WHITE);
		btnGuardarCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCliente.setBackground(new Color(0, 0, 128));
		btnGuardarCliente.setBounds(347, 503, 100, 30);
		panel.add(btnGuardarCliente);
		
		JButton btnFotoAlta = new JButton("Buscar Foto");
		btnFotoAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File imageFile;
				int result;
				BancoRayEjecutivoGui.lblFotoCliente.setIcon(null);
				BancoRayEjecutivoGui.lblFotoCliente.setText(null);
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
		btnFotoAlta.setForeground(Color.WHITE);
		btnFotoAlta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFotoAlta.setBackground(new Color(0, 0, 128));
		btnFotoAlta.setBounds(74, 407, 100, 30);
		panel.add(btnFotoAlta);
		
		JButton btnNewButton = new JButton("Revisar Cartera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarCliente.revisarClientes();
			}
		});
		btnNewButton.setBounds(82, 503, 132, 30);
		panel.add(btnNewButton);
	}

}
