package wikia;

import java.io.IOException;

import wikia.scenarios.Scenario1;
import wikia.scenarios.Scenario2;

public class Runner {

	static final String Broswer = "firefox";
	
	public static void main(String[] args) {
		Scenario1 rs1 = new Scenario1();
		Scenario2 rs2 = new Scenario2();

		try {
			rs1.Run(Broswer);
			rs2.Run(Broswer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
