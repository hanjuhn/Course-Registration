package control;

import model.Dao;
import model.MLogin;
import remoteInterface.ILogin;
import valueObject.VLogin;
import valueObject.VResult;

public class CLogin extends CControl implements ILogin {
	
	public CLogin(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	public VResult login(VLogin vLogin) {
		VResult vResult = null;
		
		MLogin mLogin = (MLogin) dao.getARow("UserId", vLogin.getUserId(), MLogin.class);
		if (mLogin != null) {
			if (vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				vResult = new VResult();
			} else {
				// password mismatch
			}
		} else {
			// no userId
		}		
		return vResult;
	}
}