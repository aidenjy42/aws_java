package 단위평가.단위2;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Company {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
}

public class CompanyMain {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Company company = new Company(
				100, 
				"Apple", 
				"Apple Computer Inc. 1 infinite Loop",
				"Cupertino",
				"CA",
				"95014" );
		
		String str = gson.toJson(company);
		System.out.println(str);
	
	}

}
