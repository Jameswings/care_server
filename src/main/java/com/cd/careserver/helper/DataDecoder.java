/**
 * 
 */
package com.cd.careserver.helper;

import java.io.RandomAccessFile;

import com.cd.careserver.vo.DataModel;

/**
 * @author shining.wu
 *
 */
public class DataDecoder{
	
	private int pixelsOf1cm = 40;

	private double tstep = 1.0 / (double) 500;

	private double plotZoom = 1.0 / ((double) pixelsOf1cm * 2.5);

	private int updateIndex = 0;

	public int dataIndex = 0;

	private String fileName;

	private RandomAccessFile raf;

	private float scale = 21.95f;
	
	public DataModel getData(String ecgFile) {
		
		scale = 859 / pixelsOf1cm;
		fileName = ecgFile;
		try {
			raf = new RandomAccessFile(fileName, "r");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			byte[] byteData = new byte[2048];
			int readCount = raf.read(byteData);
			int fileSize = (int) raf.length();
			byte[] bytetemp = new byte[fileSize];
			int rCount = 0;
			while (readCount != -1) {
				System.arraycopy(byteData, 0, bytetemp, rCount, readCount);
				rCount = rCount + readCount;
				readCount = raf.read(byteData);
			}
			byte[] ecgDataByte = new byte[rCount];
			System.arraycopy(bytetemp, 0, ecgDataByte, 0, rCount);
			System.out.println("bytetemp=------------------" + rCount);
			return decode(ecgDataByte);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private DataModel decode(byte[] bytetemp) {
		updateIndex = 0;
		int dleng = (int)(pixelsOf1cm * 2.5 * 30);
		
		int[] v1 = new int[dleng];
		int[] v3 = new int[dleng];
		int[] v5 = new int[dleng];
		
		for (int i = 0; i < bytetemp.length;) {
			byte e1data = bytetemp[i];
			int ecgmark = e1data & 0x80;

			if (ecgmark != 0) {
				i++;
				continue;
			}

			if (i + 5 >= bytetemp.length) {
				break;
			}

			byte e2data = bytetemp[i + 1];
			byte e3data = bytetemp[i + 2];
			byte e4data = bytetemp[i + 3];
			byte e5data = bytetemp[i + 4];
			byte e6data = bytetemp[i + 5];

			int data1 = (e1data & 0x3f) << 6 | (e2data & 0x3f);
			int data2 = (e3data & 0x3f) << 6 | (e4data & 0x3f);
			int data3 = (e5data & 0x3f) << 6 | (e6data & 0x3f);

			updateIndex = (int) (dataIndex * tstep / plotZoom);
			dataIndex++;
			if(updateIndex >= dleng){
				break;
			}
			v1[updateIndex] = (int) (data1 / scale);
			v3[updateIndex] = (int) (data2 / scale);
			v5[updateIndex] = (int) (data3 / scale);
			
			i = i + 6;
		}
		DataModel dataModel = new DataModel();
		System.out.println("updateIndex--------------"+updateIndex);
		if(updateIndex < (dleng -1)){
			int[] v11 = new int[updateIndex];
			System.arraycopy(v1, 0, v11, 0, updateIndex);
			dataModel.setV1(v11);
			int[] v33 = new int[updateIndex];
			System.arraycopy(v3, 0, v33, 0, updateIndex);
			dataModel.setV3(v33);	
			int[] v55 = new int[updateIndex];
			System.arraycopy(v5, 0, v55, 0, updateIndex);
			dataModel.setV5(v55);
		}else{
			dataModel.setV1(v1);
			dataModel.setV3(v3);
			dataModel.setV5(v5);
		}
		return dataModel;
	}
}
