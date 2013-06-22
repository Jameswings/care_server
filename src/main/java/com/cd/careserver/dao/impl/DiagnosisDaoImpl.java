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

	private static final String SQL_INSERT_DIAGNOSIS = "INSERT INTO diagnosis(id,message,"
			+ "customer_id,doctor_id,ecg_id,status,creation_time) "
			+ "VALUES(?,?,?,?,?,?,now())";

	private static final String SQL_DELETE_DIAGNOSIS = "DELETE FROM diagnosis WHERE id=?";

	private static final String SQL_UPDATE_DIAGNOSIS = "UPDATE diagnosis SET message=?,"
			+ "customer_id=?,doctor_id=?,ecg_id=?,status=? WHERE id=?";

	private static final String SQL_FIND_DIAGNOSIS_BY_ID = "SELECT * FROM diagnosis WHERE id=?";

	private static final String SQL_FIND_BY_ECG_ID_AND_DOCTOR_ID = "SELECT * FROM diagnosis WHERE ecg_id=? AND doctor_id=?";

	private static class DiagnosisMultiRowMapper implements
			MultiRowMapper<Diagnosis> {
		public Diagnosis mapRow(ResultSet rs, int rowNum) throws SQLException {
			Diagnosis diagnosis = new Diagnosis();
			diagnosis.setId(rs.getString("id"));
			diagnosis.setMessage(rs.getString("message"));
			diagnosis.setCreationTime(rs.getTimestamp("creation_time"));
			diagnosis.setCustomerId(rs.getString("customer_id"));
			diagnosis.setDoctorId(rs.getString("doctor_id"));
			diagnosis.setEcgId(rs.getString("ecg_id"));
			diagnosis.setStatus(rs.getInt("status"));
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
		if (update(SQL_INSERT_DIAGNOSIS,
				new Object[] { diagnosis.getId(), diagnosis.getMessage(),
						diagnosis.getCustomerId(), diagnosis.getDoctorId(),
						diagnosis.getEcgId(),
						new Integer(diagnosis.getStatus()) }, new int[] {
						Types.CHAR, Types.VARCHAR, Types.CHAR, Types.CHAR,
						Types.CHAR, Types.INTEGER }) > 0) {
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
				new Object[] { diagnosis.getMessage(),
						diagnosis.getCustomerId(), diagnosis.getDoctorId(),
						diagnosis.getEcgId(),
						new Integer(diagnosis.getStatus()), diagnosis.getId() },
				new int[] { Types.VARCHAR, Types.CHAR, Types.CHAR, Types.CHAR,
						Types.INTEGER, Types.CHAR }) > 0) {
			return diagnosis.getId();
		} else {
			return null;
		}
	}

	public Diagnosis findById(String diagnosisId) {
		return (Diagnosis) query(SQL_FIND_DIAGNOSIS_BY_ID, diagnosisId,
				new DiagnosisSingleRowMapper());
	}

	@Override
	public Diagnosis findByEcgIdAndDoctorId(String diaId, String doctorId) {
		return (Diagnosis) query(SQL_FIND_BY_ECG_ID_AND_DOCTOR_ID,
				new String[] { diaId, doctorId },
				new DiagnosisSingleRowMapper());
	}
}
