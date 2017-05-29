package cci.ch7.ood.prob2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 
 */
public class Director extends Employee {

	List<Manager> managers = new ArrayList<Manager>();
	
	public Director(String name){
		super(name,Role.DIRECTOR.name());
	}
	/* (non-Javadoc)
	 * @see cci.ch7.ood.prob2.Employee#employeeGreeting()
	 */
	@Override
	public void employeeGreeting() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println( " Hi, My Name is " + getName() + ". I am " + getRole() + ". I will help with your issue.");
	}


	public List<Manager> getManagers() {
		return managers;
	}


	public void setManagers(List<Manager> managers) {
		this.managers = managers;
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
