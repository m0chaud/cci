package cci.ch7.ood.prob2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 1. Initialize Respondent, Managers, Directors
 * 2. ManageCall, check for free employee and assign.
 * 3. Spawn thread as dispatchCall has sleep to simulate call attendance
 */
public class CallCenter {
	
	final int maxRespondent = 6;
	final int maxManager = 2;
	final int maxDirector = 1;
	
	List<Respondent> respondents = new ArrayList<Respondent>();
	List<Manager> managers = new ArrayList<Manager>();
	List<Director> directors = new ArrayList<Director>();		

	public CallCenter(){

		String name;
		for(int i = 0 ; i < maxRespondent ; i ++){
			name = "r"+i;
			Respondent r = new Respondent(name);
			respondents.add(r);
		}

		for(int i = 0 ; i < maxManager ; i ++){
			name = "m"+i;
			Manager m = new Manager(name);
			managers.add(m);
		}
		for(int i = 0 ; i < maxDirector ; i++){
			name = "d" + i;
			Director d = new Director(name);
			directors.add(d);
		}
	}
	
	public Call manageCall(Call call){
		Call referenceCall = call;
		Thread t;
		for(int i = 0 ; i < respondents.size() ; i++ ){
			Respondent r = respondents.get(i);
			if(r.isFree()){
				referenceCall.setHandler(r);
				r.setFree(false);
				referenceCall.setAttended(true);
				t = new Thread(r);
				t.start();
				respondents.remove(i);
				respondents.add(i, r);
				break;
			}
		}
		
		if(!referenceCall.isAttended()){
			for(int i = 0; i < managers.size() ; i++){
				Manager m = managers.get(i);
				if(m.isFree()){
					referenceCall.setAttended(true);
					referenceCall.setHandler(m);
					m.setFree(false);
					t = new Thread(m);
					t.start();
					managers.remove(i);
					managers.add(i,m);
					break;
				}
			}
		}
		
		if(!referenceCall.isAttended()){
			for(int i = 0 ; i < directors.size(); i++){
				Director d = directors.get(i);
				if(d.isFree()){
					referenceCall.setAttended(true);
					referenceCall.setHandler(d);
					d.setFree(false);
					t = new Thread(d);
					t.start();
					directors.remove(i);
					directors.add(i, d);
					break;
				}
			}
		}

		return referenceCall;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize Respondent and Managers
		CallCenter callCenter = new CallCenter();
		List<Call> calls = new ArrayList<Call>();
		
		Call call;
		for(int i = 0 ; i < 11; i++){
			call = new Call();
			call.setCustomerName("c"+i);
			call = callCenter.manageCall(call);
			calls.add(call);
		}
		
		for(Call c : calls){
			System.out.println(c.toString());
		}
	}

}
