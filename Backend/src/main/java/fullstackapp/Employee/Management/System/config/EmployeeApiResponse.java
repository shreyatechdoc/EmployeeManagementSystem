package fullstackapp.Employee.Management.System.config;

import org.springframework.http.HttpStatus;

public class EmployeeApiResponse {
private String response;
private HttpStatus status;
public EmployeeApiResponse() {
	super();
}
public EmployeeApiResponse(String response, HttpStatus status) {
	super();
	this.response = response;
	this.status = status;
}
public String getResponse() {
	return response;
}
public void setResponse(String response) {
	this.response = response;
}
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}

}
