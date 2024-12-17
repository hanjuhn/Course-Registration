package control;


import java.rmi.RemoteException;
import java.util.Vector;

import remoteInterface.IDirectory;
import valueObject.VDirectory;

public class CDirectory extends CControl implements IDirectory{
	
	private IDirectory iDirectory;
	
	public CDirectory() throws Exception {
		super();
		this.iDirectory = (IDirectory) this.registry.lookup(IDirectory.OBJECT_NAME);
	}
	
	public Vector<VDirectory> getData(String fileName) throws RemoteException{
		System.out.println("*Client: "+ this.getClass().getSimpleName() +"getUser started");
		Vector<VDirectory> vDrectories = this.iDirectory.getData(fileName);
		return vDrectories;
	}

}
