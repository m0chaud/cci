package cci.ch7.ood.prob2;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 
 */
public class Respondent extends Employee {

	Manager manager;

	public Respondent(String name){
		super(name,Role.RESPONDENT.name());
	}
	/* (non-Javadoc)
	 * @see cci.ch7.ood.prob2.Employee#employeeGreeting()
	 */
	@Override
	public void employeeGreeting() {
		// TODO Auto-generated method stub
		System.out.println( " Hi, My Name is " + getName() + ". I am " + getRole() + ". I will help with your issue.");
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		dispatchCall();
	}
}