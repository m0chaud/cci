package cci.ch7.ood.prob2;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 
 */
public class Call {
	
	String customerName;
	Employee handler;
	boolean isAttended;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Employee getHandler() {
		return handler;
	}
	public void setHandler(Employee handler) {
		this.handler = handler;
	}
	public boolean isAttended() {
		return isAttended;
	}
	public void setAttended(boolean isAttended) {
		this.isAttended = isAttended;
	}
	
	@Override
	public String toString() {
		return "Call [customerName=" + customerName + ", handler=" + handler + ", isAttended=" + isAttended + "]";
	}

}
