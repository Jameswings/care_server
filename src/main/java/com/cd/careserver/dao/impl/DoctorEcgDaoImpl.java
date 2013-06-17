package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.dao.DoctorEcgDao;
import com.cd.careserver.po.DoctorEcg;

public class DoctorEcgDaoImpl extends BasicDao<DoctorEcg> implements
		DoctorEcgDao {
	private static final String SQL_FIND_ALL = "SELECT * FROM doctor_ecg";

	private static final String SQL_INSERT_DOCTORECG = "INSERT INTO doctor_ecg(id,doctor_id,ecg_id,"
			+ "customer_id,type,status,annotation,last_update,creation_time) "
			+ "VALUES(?,?,?,?,?,?,?,now(),now())";

	private static final String SQL_DELETE_DOCTORECG = "DELETE FROM doctor_ecg WHERE id=?";

	private static final String SQL_UPDATE_DOCTORECG = "UPDATE doctor_ecg SET doctor_id=?,ecg_id=?,"
			+ "customer_id=?,type=?,status=?,annotation=?,last_update=now() WHERE id=?";

	private static final String SQL_FIND_DOCTORECG_BY_ID = "SELECT * FROM doctor_ecg WHERE id=?";

	private static final String SQL_FIND_DOCTORECGS_BY_IDS = "SELECT * FROM doctor_ecg WHERE id IN";

	private static class DoctorEcgMultiRowMapper implements
			MultiRowMapper<DoctorEcg> {
		public DoctorEcg mapRow(ResultSet rs, int rowNum) throws SQLException {
			DoctorEcg doctorEcg = new DoctorEcg();
			doctorEcg.setId(rs.getString("id"));
			doctorEcg.setDoctorId(rs.getString("doctor_id"));
			doctorEcg.setEcgId(rs.getString("ecg_id"));
			doctorEcg.setCustomerId(rs.getString("customer_id"));
			doctorEcg.setType(rs.getInt("type"));
			doctorEcg.setStatus(rs.getInt("status"));
			doctorEcg.setAnnotation(rs.getString("annotation"));
			doctorEcg.setLastUpdate(rs.getTimestamp("last_update"));
			doctorEcg.setCreationTime(rs.getTimestamp("creation_time"));
			return doctorEcg;
		}
	}

	private static class DoctorEcgSingleRowMapper implements
			SingleRowMapper<DoctorEcg> {
		public DoctorEcg mapRow(ResultSet rs) throws SQLException {
			return new DoctorEcgMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<DoctorEcg> findAll() {
		return query(SQL_FIND_ALL, new DoctorEcgMultiRowMapper());
	}

	public String insert(DoctorEcg doctorEcg) {
		doctorEcg.setId(createId());
		if (update(
				SQL_INSERT_DOCTORECG,
				new Object[] { doctorEcg.getId(), doctorEcg.getDoctorId(),
						doctorEcg.getEcgId(), doctorEcg.getCustomerId(),
						new Integer(doctorEcg.getType()),
						new Integer(doctorEcg.getStatus()),
						doctorEcg.getAnnotation() }, new int[] { Types.CHAR,
						Types.CHAR, Types.CHAR, Types.CHAR, Types.INTEGER,
						Types.INTEGER, Types.VARCHAR }) > 0) {
			return doctorEcg.getId();
		} else {
			return null;
		}
	}

	public String delete(String doctorEcgId) {
		if (update(SQL_DELETE_DOCTORECG, doctorEcgId) > 0) {
			return doctorEcgId;
		} else {
			return null;
		}
	}

	public String update(DoctorEcg doctorEcg) {
		if (update(
				SQL_UPDATE_DOCTORECG,
				new Object[] { doctorEcg.getDoctorId(), doctorEcg.getEcgId(),
						doctorEcg.getCustomerId(),
						new Integer(doctorEcg.getType()),
						new Integer(doctorEcg.getStatus()),
						doctorEcg.getAnnotation(), doctorEcg.getId() },
				new int[] { Types.CHAR, Types.CHAR, Types.CHAR, Types.INTEGER,
						Types.INTEGER, Types.VARCHAR, Types.CHAR }) > 0) {
			return doctorEcg.getId();
		} else {
			return null;
		}
	}

	public DoctorEcg findById(String doctorEcgId) {
		return (DoctorEcg) query(SQL_FIND_DOCTORECG_BY_ID, doctorEcgId,
				new DoctorEcgSingleRowMapper());
	}
}
