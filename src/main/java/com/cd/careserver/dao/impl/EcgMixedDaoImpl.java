package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.james.common.utils.DateUtils;
import org.james.common.utils.Validators;
import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MapRowMapper;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;
import org.james.common.utils.dao.SqlHandler;

import com.cd.careserver.condition.EcgCondition;
import com.cd.careserver.dao.EcgMixedDao;
import com.cd.careserver.vo.EcgInfo;

public class EcgMixedDaoImpl extends BasicDao<EcgInfo> implements EcgMixedDao {

	private static final String FIND_BY_CUSTOMER_ID = "SELECT e.*, r.* "
			+ "FROM ecg_data AS e LEFT JOIN doctor_ecg AS r ON e.id = r.ecg_id";

	private static final String FIND_ALL = "SELECT e.*, r.*, cu.* "
			+ "FROM ecg_data AS e LEFT JOIN doctor_ecg AS r ON e.id = r.ecg_id "
			+ " INNER JOIN doc_cus AS dc ON e.customer_id = dc.customer_id "
			+ " INNER JOIN customer AS cu ON e.customer_id = cu.id ";

	private static final String COUNT_BY_CONDITION_GROUP_BY_DATE = "SELECT DATE_FORMAT(e.creation_time,'%Y-%m-%d') AS date, count(1) AS number "
			+ " FROM ecg_data AS e LEFT JOIN doctor_ecg AS r ON e.id = r.ecg_id INNER JOIN doc_cus AS dc ON e.customer_id = dc.customer_id"
			+ " WHERE dc.doctor_id=? AND r.id IS NULL ";

	private static class EcgMultiRowMapper implements MultiRowMapper<EcgInfo> {
		public EcgInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EcgInfo ecgData = new EcgInfo();
			ecgData.setId(rs.getString("e.id"));
			ecgData.setCustomerId(rs.getString("e.customer_id"));
			ecgData.setFileLocation(rs.getString("e.file_location"));
			ecgData.setCreationTime(rs.getTimestamp("e.creation_time"));

			ecgData.setDeId(rs.getString("r.id"));
			ecgData.setDeAnnotation(rs.getString("r.annotation"));
			ecgData.setDeCreationTime(rs.getTimestamp("r.creation_time"));
			ecgData.setDeCustomerId(rs.getString("r.customer_id"));
			ecgData.setDeDoctorId(rs.getString("r.doctor_id"));
			ecgData.setDeStatus(rs.getInt("r.status"));
			ecgData.setDeType(rs.getInt("r.type"));

			ecgData.setCuAge(rs.getInt("cu.age"));
			ecgData.setCuCellPhone(rs.getString("cu.cell_phone"));
			ecgData.setCuCreationTime(rs.getTimestamp("cu.creation_time"));
			ecgData.setCuIden(rs.getString("cu.iden"));
			ecgData.setCuName(rs.getString("cu.name"));
			ecgData.setCuNickname(rs.getString("cu.nick_name"));
			ecgData.setCuPhone(rs.getString("cu.phone"));
			ecgData.setCuSex(rs.getInt("cu.sex"));

			return ecgData;
		}
	}

	private static class EcgSingleRowMapper implements SingleRowMapper<EcgInfo> {
		public EcgInfo mapRow(ResultSet rs) throws SQLException {
			return new EcgMultiRowMapper().mapRow(rs, 1);
		}
	}

	@SuppressWarnings("unchecked")
	private static class EcgMapRowMapper<K, V> implements MapRowMapper<K, V> {
		public K mapRowKey(ResultSet rs, int rowNum) throws SQLException {
			return (K) rs.getString("date");
		}

		public V mapRowValue(ResultSet rs, int rowNum) throws SQLException {
			return (V) Integer.valueOf(rs.getInt("number"));
		}
	}

	public List<EcgInfo> findByCondition(EcgCondition con) {
		SqlHandler handler = new SqlHandler(FIND_ALL, false);
		handler.and("dc.doctor_id=?", con.getDoctorId(), Types.VARCHAR,
				!Validators.isEmpty(con.getDoctorId()));
		if (Validators.isDate(con.getStartDate())) {
			handler.and("e.creation_time >= ?",
					DateUtils.string2Date(con.getStartDate()), Types.TIMESTAMP,
					true);
		}
		if (Validators.isDate(con.getEndDate())) {
			handler.and("e.creation_time < ?", DateUtils.addDay(
					DateUtils.string2Date(con.getStartDate()), 1),
					Types.TIMESTAMP, true);
		}
//		handler.and("r.id IS NULL", con.isUnRead());
//		handler.and("cu.name LIKE ?", "%" + con.getQ() + "%", !Validators.isEmpty(con.getQ()));
		return query(handler.getSQL(), handler.getArgs(),
				handler.getArgTypes(), new EcgMultiRowMapper());
	}

	public Map<String, Integer> countUnreadNumber(String docId) {
		return queryForMap(COUNT_BY_CONDITION_GROUP_BY_DATE
				+ " GROUP BY DATE_FORMAT(e.creation_time,'%Y-%m-%d')",
				new String[] { docId }, new EcgMapRowMapper<String, Integer>());
	}
}
