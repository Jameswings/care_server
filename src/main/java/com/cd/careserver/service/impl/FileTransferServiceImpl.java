package com.cd.careserver.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import com.cd.careserver.config.Config;
import com.cd.careserver.service.FileTransferService;

public class FileTransferServiceImpl implements FileTransferService {

	public String retrieveFtpFile(String cusId, String ftpLocation){
		FTPClient client = new FTPClient();
        FileOutputStream fos = null;
        String filename = ftpLocation.substring(ftpLocation.indexOf("/"));
        String fileLocation = "";
        try {
            client.connect(Config.getFtpUrl());
            client.login(Config.getFtpUsername(), Config.getFtpPassword());
            File f = new File(Config.getEcgLocalDir() + cusId);
            if (!f.exists()){
            	f.mkdirs();
            }
            fileLocation = Config.getEcgLocalDir() + cusId + "/" + filename;
            fos = new FileOutputStream(fileLocation);
            System.out.println(client.retrieveFile(ftpLocation, fos));
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return fileLocation;
	}
}
