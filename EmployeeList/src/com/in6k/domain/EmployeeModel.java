package com.in6k.domain;

import java.io.IOException;
import java.util.Collection;

import com.in6k.form.EmployeeForm;
import com.in6k.persistence.Identifier;
import com.in6k.persistence.ProviderFactory;

public class EmployeeModel implements Identifier {
    String name;
    String lastName;
    String email;
    String password;
    String birthDate;

    ProviderFactory.ProviderType providerType;
    
    public EmployeeModel(){
    }
    
    public EmployeeModel(ProviderFactory.ProviderType providerType){
    	 this.providerType = providerType;
    }

    public EmployeeModel(EmployeeForm ef, ProviderFactory.ProviderType providerType) {
        name = ef.getName();
        lastName = ef.getLastName();
        email = ef.getEmail();
        password = ef.getPassword();
        birthDate = ef.getBirthDate();
        
        this.providerType = providerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public void save() throws IOException {
        ProviderFactory.create(providerType).save(this);
    }
    
    public Collection<EmployeeModel> load() throws IOException {
    	return ProviderFactory.create(providerType).load();
    }

	@Override
	public String getIdentifier() {
		return this.getEmail();
	}
}
