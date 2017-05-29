package cci.ch7.ood.prob2;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 
 */
enum Role{
	RESPONDENT,
	MANAGER,
	DIRECTOR
}
abstract public class Employee implements Runnable{

	String name;
	String role;
	boolean isFree;

	abstract public void employeeGreeting();

	public Employee(String name, String role){
		setName(name);
		setRole(role);
		setFree(true);
	}
	public void dispatchCall(){
		
		employeeGreeting();
		
		setFree(false);
		
		System.out.println(" Employee on Call: " + toString());
		
		int iCount = 0;
		try{
			while(true){
				Thread.sleep(5*1000);
				iCount++;
				if(iCount > 5) break;
			}
		}
		catch(Exception e){

		}
		
		completeCall();
	}

	public void completeCall(){
		setFree(true);
		System.out.println(" Good Bye. Thank You for contacting us " + toString() );
		System.out.println(" Call Completed: " + toString() );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + ", isFree=" + isFree + "]";
	}

}
