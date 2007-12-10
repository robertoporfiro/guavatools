package jarden.ws.testing;

import jarden.ws.testing.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Contains config info for an individual test.
 * We want to make each test as flexible as possible.   
 * @author GBEVVH8
 *
 */
public class Test {
    
    private Collection<Validator> validators = new ArrayList<Validator>();
    
    private String id;
    private String endpoint;
    private String requestXMLPath;
    private String name;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addValidator(Validator validator){
        this.validators.add(validator);
    }

  
    public Collection<Validator> getValidators() {
        return validators;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getRequestXMLPath() {
        return requestXMLPath;
    }

    public void setRequestXMLPath(String requestXMLPath) {
        this.requestXMLPath = requestXMLPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
