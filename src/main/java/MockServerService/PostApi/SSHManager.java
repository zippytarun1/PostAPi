package MockServerService.PostApi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.LocalPortForwarder;

/**
 * 
 * Ashish.Sharma
 *
 */
public class SSHManager {

	private static Connection connection = null;
	private static List<LocalPortForwarder> lpf = null;
	LocalPortForwarder temp=null;

	

	private synchronized void ssh(String sship, String sshusername) throws Exception {
		try {
			connection = new Connection(sship, 22);
			connection.connect();

            String path = "C://Users//tarun.kakkar//Desktop//Keys//openssh";
			File key = new File(path);
			 boolean  isAuthenticated = connection.authenticateWithPublicKey(
					sshusername, key, null);
			if (isAuthenticated == false) {
				throw new IOException("Authentication failed.");
			}
			System.out.println("SSH connection created successfully !!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public  void closeConnection() {
		try {
			
			connection.close();
			temp.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("SSH connection closed !!!");

	}
	private  void forwardLocalPort(Integer localport, String remotehost,
			Integer remoteport) throws InterruptedException {
		
		try {
			temp = connection.createLocalPortForwarder(
					localport, remotehost, remoteport);
			lpf.add(temp);
		} catch (IOException e) {
			 e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	public  void myStart(String sship, String user, String dbip,
			int dbport,int remoteport) throws Exception {
		lpf = new ArrayList<LocalPortForwarder>();
		ssh(sship, user);
		forwardLocalPort(dbport, dbip, remoteport);
	}
	
}

