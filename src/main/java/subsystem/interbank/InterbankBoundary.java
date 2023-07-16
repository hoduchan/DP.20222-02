package subsystem.interbank;

import common.exception.UnrecognizedException;
import utils.ApplicationProgrammingInterface;
/**
 * singleton: day la mot class chi co cac method ho tro,
 * nen dung singleton de toi uu bo nho
 *  */
public class InterbankBoundary {

	String query(String url, String data) {
		String response = null;
		try {
			response = ApplicationProgrammingInterface.post(url, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UnrecognizedException();
		}
		return response;
	}

}
