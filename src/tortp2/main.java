package tortp2;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.Semaphore;

public class main {
	static ArrayList<vertex> verteces = new ArrayList<vertex>();
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<vertex> verteces = new ArrayList<vertex>();
		try {

			vertex v = new vertex(0, 1, 2, 0, 0, 0, 0);
			vertex v1 = new vertex(1, 2, 4, 9, 2, 0, 2);
			vertex v2 = new vertex(2, 1, 3, 3, 2, 0, 3);
			vertex v3 = new vertex(3, 2, 4, 0, 1, 0, 2);
			vertex v4 = new vertex(4, 0, 0, 2, 2, 1, 3);
			verteces.add(v);
			verteces.add(v1);
			verteces.add(v2);
			verteces.add(v3);
			verteces.add(v4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClientVertex client = new ClientVertex(verteces);
		Thread clientThread = new Thread(client);
		clientThread.start();

		DatagramSocket socket = new DatagramSocket(9090);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		int i = 0;
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			socket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			double v = Double.valueOf(sentence);
			int distance = (int) v;
			//System.out.print("le voisin de " + i + " est " + verteces.get(i).NV1 + " et la distance entre nous est ");
			verteces.get(verteces.get(i).NV1).getDistance(i,distance);
			//System.out.println();
			//System.out.print("le voisin de " + i + " est " + verteces.get(i).NV2 + " et la distance entre nous est ");
			verteces.get(verteces.get(i).NV2).getDistance(i,distance);
			//Thread.sleep(1000);
			//System.out.println();
			i++;
		}
	}
}
