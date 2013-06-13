package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.dao.DoctorDao;
import com.cd.careserver.po.Doctor;

public class DoctorDaoImpl extends BasicDao<Doctor> implements DoctorDao {
	private static final String SQL_FIND_ALL = "SELECT * FROM doctor";

	private static final String SQL_INSERT_DOCTOR = "INSERT INTO doctor(id,user_id,name,title,"
			+ "iden,nick_name,sex,age,cell_phone,phone,creation_time) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,now())";

	private static final String SQL_DELETE_DOCTOR = "DELETE FROM doctor WHERE id=?";

	private static final String SQL_UPDATE_DOCTOR = "UPDATE doctor SET user_id=?,name=?,title=?,"
			+ "iden=?,nick_name=?,sex=?,age=?,cell_phone=?,phone=? WHERE id=?";

	private static final String SQL_FIND_DOCTOR_BY_ID = "SELECT * FROM doctor WHERE id=?";

	private static final String SQL_FIND_BY_USER_ID = "SELECT * FROM doctor WHERE user_id=?";

	private static class DoctorMultiRowMapper implements MultiRowMapper<Doctor> {
		public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Doctor doctor = new Doctor();
			doctor.setId(rs.getString("id"));
			doctor.setUserId(rs.getString("user_id"));
			doctor.setName(rs.getString("name"));
			doctor.setTitle(rs.getString("title"));
			doctor.setIden(rs.getString("iden"));
			doctor.setNickName(rs.getString("nick_name"));
			doctor.setSex(rs.getInt("sex"));
			doctor.setAge(rs.getInt("age"));
			doctor.setCellPhone(rs.getString("cell_phone"));
			doctor.setPhone(rs.getString("phone"));
			doctor.setCreationTime(rs.getTimestamp("creation_time"));
			return doctor;
		}
	}

	private static class DoctorSingleRowMapper implements
			SingleRowMapper<Doctor> {
		public Doctor mapRow(ResultSet rs) throws SQLException {
			return new DoctorMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<Doctor> findAll() {
		return query(SQL_FIND_ALL, new DoctorMultiRowMapper());
	}

	public String insert(Doctor doctor) {
		doctor.setId(createId());
		if (update(
				SQL_INSERT_DOCTOR,
				new Object[] { doctor.getId(), doctor.getUserId(),
						doctor.getName(), doctor.getTitle(), doctor.getIden(),
						doctor.getNickName(), new Integer(doctor.getSex()),
						new Integer(doctor.getAge()), doctor.getCellPhone(),
						doctor.getPhone() }, new int[] { Types.CHAR,
						Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR,
						Types.VARCHAR, Types.INTEGER, Types.INTEGER,
						Types.VARCHAR, Types.VARCHAR }) > 0) {
			return doctor.getId();
		} else {
			return null;
		}
	}

	public String delete(String doctorId) {
		if (update(SQL_DELETE_DOCTOR, doctorId) > 0) {
			return doctorId;
		} else {
			return null;
		}
	}

	public String update(Doctor doctor) {
		if (update(
				SQL_UPDATE_DOCTOR,
				new Object[] { doctor.getUserId(), doctor.getName(),
						doctor.getTitle(), doctor.getIden(),
						doctor.getNickName(), new Integer(doctor.getSex()),
						new Integer(doctor.getAge()), doctor.getCellPhone(),
						doctor.getPhone(), doctor.getCreationTime(),
						doctor.getId() }, new int[] { Types.CHAR,
						Types.VARCHAR, Types.VARCHAR, Types.CHAR,
						Types.VARCHAR, Types.INTEGER, Types.INTEGER,
						Types.VARCHAR, Types.VARCHAR, Types.CHAR }) > 0) {
			return doctor.getId();
		} else {
			return null;
		}
	}

	public Doctor findById(String doctorId) {
		return (Doctor) query(SQL_FIND_DOCTOR_BY_ID, doctorId,
				new DoctorSingleRowMapper());
	}

	public Doctor findByUserId(String userId) {
		return (Doctor) query(SQL_FIND_BY_USER_ID, userId,
				new DoctorSingleRowMapper());
	}
}
