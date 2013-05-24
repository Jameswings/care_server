package com.cd.careserver.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;

public class EcgDecoder {
	public static void main1(String[] args) throws Exception{
		URL u = new URL("ftp://jamescheung: @183.45.31.253/ftp/2013-04-22_22-22-59.dat");
		byte[] b = new byte[4096];
		
		URLConnection urlconn = u.openConnection();
		InputStream raf = urlconn.getInputStream();
		
//		new FileOutputStream(new File("/"));
	}
	
	
	public static void main(String[] args) throws Exception {
		List<List<Integer>> ecgList = new ArrayList<List<Integer>>();
		List<Integer> ecg1 = new ArrayList<Integer>();
		List<Integer> ecg2 = new ArrayList<Integer>();
		List<Integer> ecg3 = new ArrayList<Integer>();
		
		FTPClient client = new FTPClient();
        FileOutputStream fos = null;

        try {
            client.connect("183.45.31.253");
            client.login("jamescheung", " ");

            //
            // The remote filename to be downloaded.
            //
            String filename = "2013-04-22_22-22-59.dat";
            fos = new FileOutputStream(filename);

            //
            // Download file from FTP server
            //
            
            client.retrieveFile("/ftp/" + filename, fos);
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
		
		
		byte[] b = new byte[4096];
		File f = new File("2013-04-22_22-22-59.dat");
		RandomAccessFile raf = new RandomAccessFile(f, "r");
		
//		URL u = new URL("ftp://jamescheung: @183.45.31.253/ftp/2013-04-22_22-22-59.dat");
//		URLConnection urlconn = u.openConnection();
//		
//		InputStream raf = urlconn.getInputStream();
		
		int length = 0;
		
		while (-1 != raf.read(b)) {
			length += b.length;
	        for (int i = 0; i < b.length;) {
	            byte e1data = b[i];
	            int ecgmark = e1data & 0x80;
	            
	            if (ecgmark != 0) {
	                i++;
	                continue;
	            }
	            
	            if (i + 5 >= b.length) {
	                break;
	            }
	            
	            byte e2data = b[i + 1];
	            byte e3data = b[i + 2];
	            byte e4data = b[i + 3];
	            byte e5data = b[i + 4];
	            byte e6data = b[i + 5];
	                   
	            int data1 = (e1data & 0x3f) << 6 | (e2data & 0x3f);
	            int data2 = (e3data & 0x3f) << 6 | (e4data & 0x3f);
	            int data3 = (e5data & 0x3f) << 6 | (e6data & 0x3f);
	            
	            ecg1.add(260 - (int)(data1 / 20));
	            ecg2.add(460 - (int)(data2 / 20));
	            ecg3.add(660 - (int)(data3 / 20));
	            
	            i = i + 6;
	        }
		}
		
		System.out.println("file size: " + length);
		System.out.println("ECG1: " + ecg1.size());
		System.out.println("ECG2: " + ecg2.size());
		System.out.println("ECG3: " + ecg3.size());
		
		List<Integer> fEcg1 = new ArrayList<Integer>();
		List<Integer> fEcg2 = new ArrayList<Integer>();
		List<Integer> fEcg3 = new ArrayList<Integer>();
		// filter
		int points = 1280;
		int num = ecg1.size() / points;
		for (int i = 0; i < ecg1.size(); i++){
			if (fEcg1.size() == points){
				break;
			}
			
			if (i % num == 0){
				fEcg1.add(ecg1.get(i));
				fEcg2.add(ecg2.get(i));
				fEcg3.add(ecg3.get(i));
			}
		}
		
		System.out.println("filtered: ECG1: " + fEcg1);
		System.out.println("filtered: ECG2: " + fEcg2);
		System.out.println("filtered: ECG3: " + fEcg3);
	}
	
}
