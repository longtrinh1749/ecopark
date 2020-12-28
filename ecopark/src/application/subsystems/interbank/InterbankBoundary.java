package application.subsystems.interbank;

import java.io.IOException;

import application.utils.RestAPI;

//this class call rest api
public class InterbankBoundary implements InterbankInterface {
	
	@Override
	public String processTransaction(String url, String data) {
		// TODO Auto-generated method stub
		try {
			return RestAPI.post(url, data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Internal Error";
		}
	}
}
