package com.in6k.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public interface DataProvider {

    public void save(Identifier model) throws IOException;
	public Collection<Identifier> load() throws IOException, SQLException;
}