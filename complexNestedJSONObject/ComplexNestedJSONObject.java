package complexNestedJSONObject;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import nestedJSONObject.EmployeeAddress;

public class ComplexNestedJSONObject {
	 EmployeeAddress employeeAddress;

	@Test
	public void CreateUser() throws JsonProcessingException {
		
		//Create request Payload
		
		NestedJSONPOJOClass requestPayload = new NestedJSONPOJOClass();
		requestPayload.setCompanyName("XYZ Ltd");
		requestPayload.setStreet("Btm Layout");
		requestPayload.setCity("Bangalore");
		requestPayload.setState("Karnataka");
		requestPayload.setPinCode(560076);
		
		List<String> banks = new ArrayList<String>();
		banks.add("SBI");
		banks.add("HDFC");
		banks.add("Axis");
		requestPayload.setBankAccount(banks);
		
		EmployeesPojoClass emp1 = new EmployeesPojoClass();
		EmployeesPojoClass emp2 = new EmployeesPojoClass();
		EmployeesPojoClass emp3 = new EmployeesPojoClass();
		EmployeesPojoClass emp4 = new EmployeesPojoClass();
		
		// Create First Employee Data
		emp1.setFirstname("Arif");
		emp1.setLastname("Hussain");
		emp1.setGender("Male");
		emp1.setAge(24);
		emp1.setSalary(45000.98);
		
		employeeAddress = new EmployeeAddress();
		employeeAddress.setStreet("Park Avenue");
		employeeAddress.setCity("Bandra");
		employeeAddress.setState("Maharastra");
		employeeAddress.setPinCode(400001);
		emp1.setAddress(employeeAddress);
		
		// Create Second Employee Data
		
		emp2.setFirstname("Akib");
		emp2.setLastname("Hussain");
		emp2.setGender("Male");
		emp2.setAge(24);
		emp2.setSalary(480001.98);
		
		employeeAddress = new EmployeeAddress();
		employeeAddress.setStreet("Mysore Palace");
		employeeAddress.setCity("Mysore");
		employeeAddress.setState("Karnataka");
		employeeAddress.setPinCode(560070);
		emp1.setAddress(employeeAddress);
		
		// Create Third Employee Data
		
		emp3.setFirstname("Asif");
		emp3.setLastname("Hussain");
		emp3.setGender("Male");
		emp3.setAge(24);
		emp3.setSalary(45000.98);
		
		
		employeeAddress.setStreet("Street Park");
		employeeAddress.setCity("Jail Road");
		employeeAddress.setState("Goa");
		employeeAddress.setPinCode(400009);
		emp1.setAddress(employeeAddress);
		
		// Create Fourth Employee Data
		
		emp4.setFirstname("zoya");
		emp4.setLastname("Hussain");
		emp4.setGender("Female");
		emp4.setAge(20);
		emp4.setSalary(34000.99);
		
		
		employeeAddress.setStreet("Dabar Gali");
		employeeAddress.setCity("ara");
		employeeAddress.setState("Bihar");
		employeeAddress.setPinCode(802312);
		emp1.setAddress(employeeAddress);
		
		List<EmployeesPojoClass> employee = new ArrayList<EmployeesPojoClass>();
		employee.add(emp1);
		employee.add(emp2);
		employee.add(emp3);
		employee.add(emp4);
		
		requestPayload.setEmployeeList(employee);
		ObjectMapper objectMapper = new ObjectMapper();
		String Payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("http://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(Payload);
		Response response = reqSpec.post();
		
		System.out.println("/n");
		System.out.println("--------------------Response Body--------------");
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),200, "Check For status code");
	}
}
