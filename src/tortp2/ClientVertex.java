package tortp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ClientVertex implements Runnable  {
	private ArrayList<vertex> verteces;
	Semaphore sem;
	ClientVertex(ArrayList<vertex> verteces){
		this.verteces = verteces;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("class 2 "+verteces.size());
			DatagramSocket clientSocket = new DatagramSocket(0);
	        byte[] sendData ;    
	        byte[] receiveData = new byte[1024];
	        InetAddress serverAddress = InetAddress.getByName("localhost");
				for (int i = 0; i <verteces.size();i++) {
					if(i==0) {
						String stringSendData = String.valueOf(0);
				        sendData = stringSendData.getBytes();
				        verteces.get(i).DistanceToS=0;
				        //System.out.println(stringSendData);
				        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
				        clientSocket.send(sendPacket);
				        }else {
						String stringSendData = String.valueOf(verteces.get(i).DistanceToS);
				        sendData = stringSendData.getBytes();
				        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
				        clientSocket.send(sendPacket);
					}
					Thread.sleep(2000);
				}
		}catch(Exception e) {
		
		}
		
	}

}
