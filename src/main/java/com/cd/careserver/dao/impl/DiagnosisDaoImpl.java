package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.dao.DiagnosisDao;
import com.cd.careserver.po.Diagnosis;

public class DiagnosisDaoImpl extends BasicDao<Diagnosis> implements
		DiagnosisDao {

	private static final String SQL_FIND_ALL = "SELECT * FROM diagnosis";

	private static final String SQL_INSERT_DIAGNOSIS = "INSERT INTO diagnosis(id,doctor_ecg_id,message,"
			+ "creation_time) " + "VALUES(?,?,?,now())";

	private static final String SQL_DELETE_DIAGNOSIS = "DELETE FROM diagnosis WHERE id=?";

	private static final String SQL_UPDATE_DIAGNOSIS = "UPDATE diagnosis SET doctor_ecg_id=?,message=?"
			+ " WHERE id=?";

	private static final String SQL_FIND_DIAGNOSIS_BY_ID = "SELECT * FROM diagnosis WHERE id=?";

	private static final String SQL_FIND_DIAGNOSISS_BY_IDS = "SELECT * FROM diagnosis WHERE id IN";

	private static class DiagnosisMultiRowMapper implements
			MultiRowMapper<Diagnosis> {
		public Diagnosis mapRow(ResultSet rs, int rowNum) throws SQLException {
			Diagnosis diagnosis = new Diagnosis();
			diagnosis.setId(rs.getString("id"));
			diagnosis.setDoctorEcgId(rs.getString("doctor_ecg_id"));
			diagnosis.setMessage(rs.getString("message"));
			diagnosis.setCreationTime(rs.getTimestamp("creation_time"));
			return diagnosis;
		}
	}

	private static class DiagnosisSingleRowMapper implements
			SingleRowMapper<Diagnosis> {
		public Diagnosis mapRow(ResultSet rs) throws SQLException {
			return new DiagnosisMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<Diagnosis> findAll() {
		return query(SQL_FIND_ALL, new DiagnosisMultiRowMapper());
	}

	public String insert(Diagnosis diagnosis) {
		diagnosis.setId(createId());
		if (update(SQL_INSERT_DIAGNOSIS, new Object[] { diagnosis.getId(),
				diagnosis.getDoctorEcgId(), diagnosis.getMessage() },
				new int[] { Types.CHAR, Types.CHAR, Types.VARCHAR }) > 0) {
			return diagnosis.getId();
		} else {
			return null;
		}
	}

	public String delete(String diagnosisId) {
		if (update(SQL_DELETE_DIAGNOSIS, diagnosisId) > 0) {
			return diagnosisId;
		} else {
			return null;
		}
	}

	public String update(Diagnosis diagnosis) {
		if (update(
				SQL_UPDATE_DIAGNOSIS,
				new Object[] { diagnosis.getDoctorEcgId(),
						diagnosis.getMessage(), diagnosis.getId() }, new int[] {
						Types.CHAR, Types.VARCHAR, Types.CHAR }) > 0) {
			return diagnosis.getId();
		} else {
			return null;
		}
	}

	public Diagnosis findById(String diagnosisId) {
		return (Diagnosis) query(SQL_FIND_DIAGNOSIS_BY_ID, diagnosisId,
				new DiagnosisSingleRowMapper());
	}
}
