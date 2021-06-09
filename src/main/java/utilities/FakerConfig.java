package utilities;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class FakerConfig {
    private Locale locale = new Locale("en");
    private Faker faker = new Faker(locale);
    private String firstName, lastName;
    
    public static FakerConfig getData() {
	return new FakerConfig();
    }
    
    public String getFirstName() {
	this.firstName = faker.address().firstName();
	return firstName;
    }
    
    public String getLastName() {
	this.lastName = faker.address().lastName();
	return lastName;
    }
    
    public String getEmail(String firstName, String lastName) {
	
	List<String> hostName = Arrays.asList("yahoo.com", "att.net", "comcast.net", "facebook.com", "gmail.com");
	Random rand = new Random();
	int index = rand.nextInt(hostName.size());
	//System.out.println("========== random hostName: " + hostName.get(index));
	String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +  hostName.get(index);
	return email;
    }
    
    public String getEmail() {
	return faker.internet().emailAddress();
    }
    
    public String getPassword() {
	return faker.internet().password();
    }
    
    public String getAddress() {
	return faker.address().streetAddress();
    }
    
    public String getCity() {
	return faker.address().city();
    }
    
    public String getPhone() {
	return faker.phoneNumber().phoneNumber();
    }
}
