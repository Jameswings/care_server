package com.cd.careserver.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.dao.PendingResponseDao;
import com.cd.careserver.po.PendingResponse;

public class PendingResponseDaoImpl extends BasicDao<PendingResponse> implements
		PendingResponseDao {
	private static final String SQL_FIND_ALL = "SELECT * FROM pending_response";

	private static final String SQL_INSERT_PENDINGRESPONSE = "INSERT INTO pending_response(id,message,cmd,"
			+ "type,target_id,from_type,from_id,to_type,to_id,creation_time) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,now())";

	private static final String SQL_DELETE_PENDINGRESPONSE = "DELETE FROM pending_response WHERE id=?";

	// private static final String SQL_UPDATE_PENDINGRESPONSE =
	// "UPDATE pending_response SET message=?,cmd=?,"
	// +
	// "type=?,from_type=?,from_id=?,to_type=?,to_id=?,creation_time=? WHERE id=?";

	private static final String SQL_FIND_PENDINGRESPONSE_BY_ID = "SELECT * FROM pending_response WHERE id=?";
	
	private static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM pending_response WHERE customer_id=?";

	private static class PendingResponseMultiRowMapper implements
			MultiRowMapper<PendingResponse> {
		public PendingResponse mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PendingResponse pendingResponse = new PendingResponse();
			pendingResponse.setId(rs.getString("id"));
			pendingResponse.setMessage(rs.getString("message"));
			pendingResponse.setCmd(rs.getString("cmd"));
			pendingResponse.setType(rs.getInt("type"));
			pendingResponse.setTargetId(rs.getString("target_id"));
			pendingResponse.setFromType(rs.getInt("from_type"));
			pendingResponse.setFromId(rs.getString("from_id"));
			pendingResponse.setToType(rs.getInt("to_type"));
			pendingResponse.setToId(rs.getString("to_id"));
			pendingResponse.setCreationTime(rs.getTimestamp("creation_time"));
			return pendingResponse;
		}
	}

	private static class PendingResponseSingleRowMapper implements
			SingleRowMapper<PendingResponse> {
		public PendingResponse mapRow(ResultSet rs) throws SQLException {
			return new PendingResponseMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<PendingResponse> findAll() {
		return query(SQL_FIND_ALL, new PendingResponseMultiRowMapper());
	}

	public String insert(PendingResponse pendingResponse) {
		pendingResponse.setId(createId());
		if (update(
				SQL_INSERT_PENDINGRESPONSE,
				new Object[] { pendingResponse.getId(),
						pendingResponse.getMessage(), pendingResponse.getCmd(),
						new Integer(pendingResponse.getType()),
						pendingResponse.getTargetId(),
						new Integer(pendingResponse.getFromType()),
						pendingResponse.getFromId(),
						new Integer(pendingResponse.getToType()),
						pendingResponse.getToId() }, new int[] { Types.CHAR,
						Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
						Types.CHAR, Types.INTEGER, Types.CHAR, Types.INTEGER,
						Types.CHAR }) > 0) {
			return pendingResponse.getId();
		} else {
			return null;
		}
	}

	public String delete(String pendingResponseId) {
		if (update(SQL_DELETE_PENDINGRESPONSE, pendingResponseId) > 0) {
			return pendingResponseId;
		} else {
			return null;
		}
	}

	public PendingResponse findById(String pendingResponseId) {
		return (PendingResponse) query(SQL_FIND_PENDINGRESPONSE_BY_ID,
				pendingResponseId, new PendingResponseSingleRowMapper());
	}
	
	@Override
	public List<PendingResponse> findByCustomerId(String customerId) {
		return query(SQL_FIND_BY_CUSTOMER_ID, customerId, new PendingResponseMultiRowMapper());
	}	
}
