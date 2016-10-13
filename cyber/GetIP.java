import java.sql.*;
import java.net.*;

public class GetIP{
	public static void main (String[] args)throws java.io.IOException {
		
		byte[] ipAddr = {0x12,0x23};
		byte[] buf = {0x12,0x23};
		int [] ip = {0,0,0,0};
		String hostname = " ";
		String hostadd = " ";
		try { InetAddress addr = InetAddress.getLocalHost();
	
				ipAddr = addr.getAddress();
				hostadd = addr.getHostAddress();	
				hostname = addr.getHostName();	
	
			}catch (UnknownHostException e){}
	
			try {
				String s = new sun.misc.BASE64Encoder().encode(ipAddr);
				buf = new sun.misc.BASE64Decoder().decodeBuffer(s);
			}catch (java.io.IOException e) {}
			System.out.println(hostname);
			System.out.println(hostadd);
			System.out.println(" ");
					if (ipAddr[0] < 0) {ip[0] = (256 + ipAddr[0]);}
					else {ip[1] = ipAddr[1];}
						if (ipAddr[1] < 0) {ip[1] = (256 + ipAddr[1]);}
					else {ip[1] = ipAddr[1];}
						if (ipAddr[2] < 0) {ip[2] = (256 + ipAddr[2]);}
					else {ip[2] = ipAddr[2];}
						if (ipAddr[3] < 0) {ip[3] = (256 + ipAddr[3]);}
					else {ip[3] = ipAddr[3];}
					
			System.out.println(ip[0] +":"+ ip[1] +":"+ ip[2] +":"+ ip[3]);
           }
}

