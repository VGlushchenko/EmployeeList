package com.in6k.persistence;

import java.io.IOException;
import java.util.Collection;

import com.in6k.domain.EmployeeModel;


public interface DataProvider {

    public void save(Identifier model) throws IOException;
    //public EmployeeModel load();
	public Collection<EmployeeModel> load() throws IOException;
}
