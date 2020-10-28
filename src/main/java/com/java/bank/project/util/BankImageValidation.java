package com.java.bank.project.util;

import java.awt.Image;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.java.bank.project.BancoRayApp;
import com.java.bank.project.ui.BancoRayEjecutivoGui;
import com.java.bank.project.ui.BancoRayGui;

public class BankImageValidation {
	
	private static final ImageIcon predefinedManClient = new ImageIcon(BancoRayApp.class.getResource("/com/java/bank/project/ui/MarioCasas.jpg"));
	private static final ImageIcon predefinedWomanClient = new ImageIcon(BancoRayApp.class.getResource("/com/java/bank/project/ui/ladygaga.jpg"));
	
	public static void validateImagePath(File imageFile) {
			try {
				if(imageFile!=null) {
					ImageIcon iconStudent = new ImageIcon(imageFile.toString());
					Icon iconPhoto = new ImageIcon(iconStudent.getImage().getScaledInstance(
					BancoRayEjecutivoGui.lblFotoCliente.getWidth(), BancoRayGui.lblFotoCliente.getHeight(), Image.SCALE_DEFAULT));
					BancoRayEjecutivoGui.lblFotoCliente.setIcon(iconPhoto);
					BancoRayEjecutivoGui.fotoPath = imageFile.toString();
				}
			}catch(Exception ex) {
				// Insertar error en tabla de errores
				System.out.println("Error at pic root: "+ex);
				JOptionPane.showMessageDialog(null, "Error al cargar Imagen, se cargará la predeterminada");
				//VitarMainService.LblStudentPhoto.setIcon(predefinedManPilot);
			}
		 
	}
	
	
	public static void setNewManPilotImage() {
		try {
			BancoRayGui.lblFotoCliente.setIcon(null);
			BancoRayGui.lblFotoCliente.setText(null);
			Icon iconPhoto = new ImageIcon(predefinedManClient.getImage().getScaledInstance(
					BancoRayGui.lblFotoCliente.getWidth(), BancoRayGui.lblFotoCliente.getHeight(), Image.SCALE_DEFAULT));
			BancoRayGui.lblFotoCliente.setIcon(iconPhoto);
			BancoRayGui.lblFotoCliente.setText("PredefinedManPilot");
		}catch(Exception ex) {
			// Insertar error en tabla de errores
			System.out.println("Error: "+ex);
			JOptionPane.showMessageDialog(null, "Error al cargar Imagen");
			BancoRayGui.lblFotoCliente.setIcon(null);
			//VitarMainService.lblNewStudentPicRoot.setText(null);
		}
	}
	
	public static void setSearchUpdateStudentImage(String imageFile) {
		try {
			
			if(!imageFile.isEmpty() && imageFile.equals("PredefinedWomanPilot")){
				BancoRayGui.lblFotoCliente.setIcon(predefinedWomanClient);
			}else if(!imageFile.isEmpty() && imageFile.equals("PredefinedManPilot")){
				BancoRayGui.lblFotoCliente.setIcon(predefinedManClient);
			}else if (!imageFile.isEmpty()) {
				File file = new File(imageFile);
				file = file.getParentFile();
				if(file.exists()) {
					BancoRayGui.lblFotoCliente.setIcon(null);
				ImageIcon iconStudent = new ImageIcon(imageFile);
				Icon iconPhoto = new ImageIcon(iconStudent.getImage().getScaledInstance(
						BancoRayGui.lblFotoCliente.getWidth(),BancoRayGui.lblFotoCliente.getHeight(), Image.SCALE_DEFAULT));
				BancoRayGui.lblFotoCliente.setIcon(iconPhoto);
				}
			}else {
				BancoRayGui.lblFotoCliente.setIcon(predefinedManClient);
			}
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
			BancoRayGui.lblFotoCliente.setIcon(predefinedManClient);
		}
	 
	}


}

