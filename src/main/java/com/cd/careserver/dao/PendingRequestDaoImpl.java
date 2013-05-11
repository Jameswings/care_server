package com.cd.careserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.cd.careserver.po.PendingRequest;

public class PendingRequestDaoImpl extends BasicDao<PendingRequest> implements
		PendingRequestDao {

	private static final String SQL_FIND_ALL = "SELECT * FROM pending_request";

	private static final String SQL_INSERT_PENDINGREQUEST = "INSERT INTO pending_request(id,type,message,"
			+ "cmd,from_type,from_id,to_type,to_id,creation_time) "
			+ "VALUES(?,?,?,?,?,?,?,?,?)";

	private static final String SQL_DELETE_PENDINGREQUEST = "DELETE FROM pending_request WHERE id=?";

	private static final String SQL_UPDATE_PENDINGREQUEST = "UPDATE pending_request SET type=?,message=?,"
			+ "cmd=?,from_type=?,from_id=?,to_type=?,to_id=?,creation_time=? WHERE id=?";

	private static final String SQL_FIND_PENDINGREQUEST_BY_ID = "SELECT * FROM pending_request WHERE id=?";

	private static class PendingRequestMultiRowMapper implements
			MultiRowMapper<PendingRequest> {
		public PendingRequest mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PendingRequest pendingRequest = new PendingRequest();
			pendingRequest.setId(rs.getString("id"));
			pendingRequest.setType(rs.getInt("type"));
			pendingRequest.setMessage(rs.getString("message"));
			pendingRequest.setCmd(rs.getString("cmd"));
			pendingRequest.setFromType(rs.getInt("from_type"));
			pendingRequest.setFromId(rs.getString("from_id"));
			pendingRequest.setToType(rs.getInt("to_type"));
			pendingRequest.setToId(rs.getString("to_id"));
			pendingRequest.setCreationTime(rs.getTimestamp("creation_time"));
			return pendingRequest;
		}
	}

	private static class PendingRequestSingleRowMapper implements
			SingleRowMapper<PendingRequest> {
		public PendingRequest mapRow(ResultSet rs) throws SQLException {
			return new PendingRequestMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<PendingRequest> findAll() {
		return query(SQL_FIND_ALL, new PendingRequestMultiRowMapper());
	}

	public String insert(PendingRequest pendingRequest) {
		pendingRequest.setId(createId());
		pendingRequest.setCreationTime(new Date());
		if (update(
				SQL_INSERT_PENDINGREQUEST,
				new Object[] { pendingRequest.getId(),
						new Integer(pendingRequest.getType()),
						pendingRequest.getMessage(), pendingRequest.getCmd(),
						new Integer(pendingRequest.getFromType()),
						pendingRequest.getFromId(),
						new Integer(pendingRequest.getToType()),
						pendingRequest.getToId(),
						pendingRequest.getCreationTime() }, new int[] {
						Types.CHAR, Types.INTEGER, Types.VARCHAR,
						Types.VARCHAR, Types.INTEGER, Types.CHAR,
						Types.INTEGER, Types.CHAR, Types.TIMESTAMP }) > 0) {
			return pendingRequest.getId();
		} else {
			return null;
		}
	}

	public String delete(String pendingRequestId) {
		if (update(SQL_DELETE_PENDINGREQUEST, pendingRequestId) > 0) {
			return pendingRequestId;
		} else {
			return null;
		}
	}

	public String update(PendingRequest pendingRequest) {
		if (update(
				SQL_UPDATE_PENDINGREQUEST,
				new Object[] { new Integer(pendingRequest.getType()),
						pendingRequest.getMessage(), pendingRequest.getCmd(),
						new Integer(pendingRequest.getFromType()),
						pendingRequest.getFromId(),
						new Integer(pendingRequest.getToType()),
						pendingRequest.getToId(),
						pendingRequest.getCreationTime(),
						pendingRequest.getId() }, new int[] { Types.INTEGER,
						Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
						Types.CHAR, Types.INTEGER, Types.CHAR, Types.TIMESTAMP,
						Types.CHAR }) > 0) {
			return pendingRequest.getId();
		} else {
			return null;
		}
	}

	public PendingRequest findById(String pendingRequestId) {
		return (PendingRequest) query(SQL_FIND_PENDINGREQUEST_BY_ID,
				pendingRequestId, new PendingRequestSingleRowMapper());
	}
}
