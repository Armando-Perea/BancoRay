package com.java.bank.project;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.java.bank.project.ui.BancoRayEjecutivoGui;
import com.java.bank.project.ui.BancoRayGui;

import lombok.extern.slf4j.Slf4j;

/**
 * NearSoftApp
 *
 */
public class BancoRayApp {
	
	public static  Logger logger = LogManager.getLogger(BancoRayApp.class);
	
	public static Map<String,String> aliasMap = new HashMap<String,String>();

	public static void main( String[] args )
    {
        //SpringApplication.run(BancoRayApp.class, args);
        BancoRayEjecutivoGui ejecutivo = new BancoRayEjecutivoGui();
        ejecutivo.setVisible(true);
        BancoRayGui banco = new BancoRayGui();
        banco.setVisible(true);
    }

}
