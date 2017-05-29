package cci.ch7.ood.prob2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 
 */
public class Manager extends Employee {

	Director director;
	List<Respondent> respondents = new ArrayList<Respondent>();

	public Manager(String name){
		super(name,Role.MANAGER.name());
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

	public List<Respondent> getRespondents() {
		return respondents;
	}

	public void setRespondents(List<Respondent> respondents) {
		this.respondents = respondents;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
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
