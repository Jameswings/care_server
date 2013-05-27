package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.dao.DoctorCustomerDao;
import com.cd.careserver.po.DoctorCustomer;

public class DoctorCustomerDaoImpl extends BasicDao<DoctorCustomer> implements
		DoctorCustomerDao {

	private static final String SQL_FIND_BY_DOCTOR_ID = "SELECT * FROM doc_cus WHERE doctor_id=?";
	
	private static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM doc_cus WHERE customer_id=?";
	
	private static class DoctorCustomerMultiRowMapper implements
			MultiRowMapper<DoctorCustomer> {
		public DoctorCustomer mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			DoctorCustomer doctorCustomer = new DoctorCustomer();
			doctorCustomer.setDoctorId(rs.getString("doctor_id"));
			doctorCustomer.setCustomerId(rs.getString("customer_id"));
			doctorCustomer.setMark(rs.getInt("mark"));
			doctorCustomer.setNote(rs.getString("note"));
			return doctorCustomer;
		}
	}

	private static class DoctorCustomerSingleRowMapper implements
			SingleRowMapper<DoctorCustomer> {
		public DoctorCustomer mapRow(ResultSet rs) throws SQLException {
			return new DoctorCustomerMultiRowMapper().mapRow(rs, 1);
		}
	}
	
	public List<DoctorCustomer> findByDoctorId(String docId) {
		return query(SQL_FIND_BY_DOCTOR_ID, docId, new DoctorCustomerMultiRowMapper());
	}
	
	public List<DoctorCustomer> findByCustomerId(String cusId) {
		return query(SQL_FIND_BY_CUSTOMER_ID, cusId, new DoctorCustomerMultiRowMapper());
	}
}
