package imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import dbcon.Dbconn;

import bean.Charitybean;
import bean.charity;
import bean.charityrequest;
import bean.fakecheck;
import bean.transfer;

import bean.publicreg;
import inter.inter;

public class imple implements inter{

	Connection con;
	@Override
	public int creg(Charitybean cb) {
		int reg=0;
		 
		 con=Dbconn.create();
		 
		 		try {
		 			
		 			PreparedStatement ps=con.prepareStatement("INSERT INTO `scam`.`charityreg` VALUES(id,?,?,?,?,?,?,?,?,?)");
		 			ps.setString(1,cb.getCname());
		 			ps.setString(2,cb.getCemail());
		 			ps.setString(3,cb.getContact());
		 			ps.setString(4,cb.getAbout());
		 			ps.setString(5,cb.getCity());
		 			ps.setString(6,cb.getState());
		 			ps.setString(7,cb.getPassword());
		 			ps.setString(8,cb.getPicture());
		 			ps.setString(9,"Verification");

		 				reg=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		return reg;
	}
	@Override
	public int preg(publicreg pb) {
		int reg=0;
		 
		 con=Dbconn.create();
		 
		 		try {
		 			
		 			PreparedStatement ps=con.prepareStatement("INSERT INTO `scam`.`pubreg` VALUES(id,?,?,?,?,?,?,?,?)");
		 			ps.setString(1,pb.getPname());
		 			ps.setString(2,pb.getPemail());
		 			ps.setString(3,pb.getMobilenumber());;
		 			ps.setString(4,pb.getPassword());
		 			ps.setString(5,pb.getConpass());
		 			ps.setString(6,pb.getGender());
		 			ps.setString(7,pb.getPic());
		 			
		 			ps.setString(8,"Register");

		 				reg=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		return reg;
	}
	@Override
	public boolean plog(publicreg pl) {

		boolean log=false;
		 con=Dbconn.create();
		
		 try {
				PreparedStatement ps=con.prepareStatement("SELECT * FROM `scam`.`pubreg` where email=? and password=?");
				ps.setString(1,pl.getPemail());
				ps.setString(2,pl.getPassword());
				ResultSet rs=ps.executeQuery();
				log=rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return log;

	}
	@Override
	public int creq(charityrequest cr) {
		int reg=0;
		 
		 con=Dbconn.create();
		 
		 		try {
		 			
		 			PreparedStatement ps=con.prepareStatement("INSERT INTO `scam`.`Charityreq` VALUES(id,?,?,?,?,?,?,?)");
		 			ps.setString(1,cr.getRname());
		 			ps.setString(2,cr.getRemail());
		 			ps.setString(3,cr.getCemail());
		 			ps.setString(4,cr.getPurpose());
		 			ps.setString(5,cr.getContact());
		 			ps.setString(6,cr.getCharityname());
		 			ps.setString(7, "Request");
		 		
		 			
		 		

		 				reg=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		return reg;
}
	@Override
	public int ches(charity ck) {
		int reg=0;
		 
		 con=Dbconn.create();
		 
		 		try {
		 			
		 			PreparedStatement ps=con.prepareStatement("INSERT INTO `scam`.`checkdetails` VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 			ps.setString(1,ck.getCheckno());
		 			ps.setString(2,ck.getCheckword());
		 			ps.setString(3,ck.getDate());
		 			ps.setString(4,ck.getCharityname());
		 			ps.setString(5,ck.getDescription());
		 			ps.setString(6,ck.getAmount());
		 			ps.setString(7,ck.getCemail());
		 			ps.setString(8,ck.getCity());
		 			ps.setString(9,ck.getPic());
		 			ps.setString(10,ck.getEncryptedchecno());
		 			ps.setString(11,"Donation");
		 			ps.setString(12,ck.getPemail());
		 			ps.setString(13, ck.getAddress());
		 			
		 			reg=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		return reg;
	}
	@Override
	public boolean clog(Charitybean cl) {
		// TODO Auto-generated method stub
		
		
		boolean log=false;
		 con=Dbconn.create();
		
		 try {
				PreparedStatement ps=con.prepareStatement("SELECT * FROM `scam`.`charityreg` where cemail=? and password=? and status='Verified' ");
				ps.setString(1, cl.getCemail());
				ps.setString(2, cl.getPassword());

				ResultSet rs=ps.executeQuery();
				log=rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return log;
	}
	@Override
	public int trans(transfer tr) {
		// TODO Auto-generated method stub
		
		
		int reg=0;
		 
		 con=Dbconn.create();
		 
		 		try {
		 			
		 			PreparedStatement ps=con.prepareStatement("INSERT INTO `scam`.`transmoney` VALUES(id,?,?,?,?,?,?,?,?)");
		 			ps.setString(1, tr.getPemail());
		 			ps.setString(2, tr.getCemail());
		 			ps.setString(3, tr.getCheckno());
		 			ps.setString(4, tr.getAmountinword());
		 			ps.setString(5, tr.getDate());
		 			ps.setString(6, tr.getAmount());
		 			ps.setString(7, tr.getPhash());
		 			ps.setString(8, tr.getAhash());
		 		
		 			
		 		

		 				reg=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		return reg;
}
}
