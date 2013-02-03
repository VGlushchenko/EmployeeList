package com.in6k.persistence;

import java.io.IOException;
import java.util.Collection;

import com.in6k.domain.EmployeeModel;

public class DbProvider implements DataProvider {

	@Override
	public void save(com.in6k.persistence.Identifier model) throws IOException {
	}

	@Override
	public Collection<EmployeeModel> load() throws IOException {
		return null;
	}
}
