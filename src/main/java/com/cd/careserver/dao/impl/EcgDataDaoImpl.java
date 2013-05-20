package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.dao.EcgDataDao;
import com.cd.careserver.po.EcgData;

public class EcgDataDaoImpl extends BasicDao<EcgData> implements EcgDataDao {
	private static final String SQL_FIND_ALL = "SELECT * FROM ecg_data";

	private static final String SQL_INSERT_ECGDATA = "INSERT INTO ecg_data(id,customer_id,file_location,"
			+ "creation_time) " + "VALUES(?,?,?,?)";

	private static final String SQL_DELETE_ECGDATA = "DELETE FROM ecg_data WHERE id=?";

	private static final String SQL_UPDATE_ECGDATA = "UPDATE ecg_data SET customer_id=?,file_location=?,"
			+ "creation_time=? WHERE id=?";

	private static final String SQL_FIND_ECGDATA_BY_ID = "SELECT * FROM ecg_data WHERE id=?";

	private static class EcgDataMultiRowMapper implements
			MultiRowMapper<EcgData> {
		public EcgData mapRow(ResultSet rs, int rowNum) throws SQLException {
			EcgData ecgData = new EcgData();
			ecgData.setId(rs.getString("id"));
			ecgData.setCustomerId(rs.getString("customer_id"));
			ecgData.setFileLocation(rs.getString("file_location"));
			ecgData.setCreationTime(rs.getTimestamp("creation_time"));
			return ecgData;
		}
	}

	private static class EcgDataSingleRowMapper implements
			SingleRowMapper<EcgData> {
		public EcgData mapRow(ResultSet rs) throws SQLException {
			return new EcgDataMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<EcgData> findAll() {
		return query(SQL_FIND_ALL, new EcgDataMultiRowMapper());
	}

	public String insert(EcgData ecgData) {
		ecgData.setId(createId());
		if (update(SQL_INSERT_ECGDATA,
				new Object[] { ecgData.getId(), ecgData.getCustomerId(),
						ecgData.getFileLocation(), ecgData.getCreationTime() },
				new int[] { Types.CHAR, Types.CHAR, Types.VARCHAR,
						Types.TIMESTAMP }) > 0) {
			return ecgData.getId();
		} else {
			return null;
		}
	}

	public String delete(String ecgDataId) {
		if (update(SQL_DELETE_ECGDATA, ecgDataId) > 0) {
			return ecgDataId;
		} else {
			return null;
		}
	}

	public String update(EcgData ecgData) {
		if (update(
				SQL_UPDATE_ECGDATA,
				new Object[] { ecgData.getCustomerId(),
						ecgData.getFileLocation(), ecgData.getCreationTime(),
						ecgData.getId() }, new int[] { Types.CHAR,
						Types.VARCHAR, Types.TIMESTAMP, Types.CHAR }) > 0) {
			return ecgData.getId();
		} else {
			return null;
		}
	}

	public EcgData findById(String ecgDataId) {
		return (EcgData) query(SQL_FIND_ECGDATA_BY_ID, ecgDataId,
				new EcgDataSingleRowMapper());
	}

}
