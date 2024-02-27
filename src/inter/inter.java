package inter;

import bean.Charitybean;
import bean.charity;
import bean.charityrequest;
import bean.fakecheck;
import bean.transfer;

import bean.publicreg;

public interface inter {
	
	public int creg(Charitybean cb);
	
	public int preg(publicreg pb);
	
	public boolean plog(publicreg pl);
	
	public int creq(charityrequest cr);
	
	public int ches(charity ck);
	
	public boolean clog(Charitybean cl);
	
	public int trans(transfer tr);
	
	

}
