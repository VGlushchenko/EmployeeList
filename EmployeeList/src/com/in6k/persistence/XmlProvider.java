package com.in6k.persistence;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.in6k.domain.EmployeeModel;

public class XmlProvider implements DataProvider {

    public XmlProvider() {
    }
    
    @Override
    public void save(Identifier identifier) throws IOException {
       
    	 try {
            FileOutputStream fos = new FileOutputStream("C:\\\\xml\\" + identifier.getIdentifier() + ".xml");

            try {
                XMLEncoder xmlEncoder = new XMLEncoder(fos);

                try {
                    xmlEncoder.writeObject(identifier);
                    xmlEncoder.flush();
                }
                finally {
                    xmlEncoder.close();
                }
            } finally {
                fos.close();
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public EmployeeModel loadFromFile(File file){
    	FileInputStream fstream;
    	EmployeeModel e;
		try {
			fstream = new FileInputStream(file);
			XMLDecoder xmlDecoder = new XMLDecoder(fstream);
	        e = (EmployeeModel)xmlDecoder.readObject();        
	        xmlDecoder.close();
		} catch (FileNotFoundException e1) {
			return null;
		}        
        return e;
    }
    
    @Override
	public Collection<Identifier> load() throws IOException, SQLException {
		File dir = new File("C:\\\\xml\\");
        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xml");
            }
        });
        
        Collection<Identifier> employeeList = new ArrayList<Identifier>();
        
        for(File file : files) {
        	EmployeeModel em = loadFromFile(file);
        	employeeList.add(em);        	 
        }
        
        return employeeList;
	}

}
