package com.xzf.commoncrud;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
	T handle(ResultSet resultSet);
}
