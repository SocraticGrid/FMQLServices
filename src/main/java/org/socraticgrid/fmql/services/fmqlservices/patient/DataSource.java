/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.fmql.services.fmqlservices.patient;

import java.io.InputStream;
import java.util.Map;

/**
 *
 * @author Jerry Goodnough
 */
public class DataSource extends org.socraticgrid.patientdataservices.BaseDataSource
{

    public DataSource()
    {
    }
    
    private String fmqlEndpoint;

    /**
     * Get the value of fmqlEndpoint
     *
     * @return the value of fmqlEndpoint
     */
    public String getFmqlEndpoint()
    {
        return fmqlEndpoint;
    }

    /**
     * Set the value of fmqlEndpoint
     *
     * @param fmqlEndpoint new value of fmqlEndpoint
     */
    public void setFmqlEndpoint(String fmqlEndpoint)
    {
        this.fmqlEndpoint = fmqlEndpoint;
    }

    @Override
    public boolean isDomainSupported(String domain)
    {
        return this.domainQueryMap.containsKey(domain); 
    }
    
    
    private Map<String, String> domainQueryMap;

    /**
     * Get the value of domainQueryMap
     *
     * @return the value of domainQueryMap
     */
    public Map<String, String> getDomainQueryMap()
    {
        return domainQueryMap;
    }

    /**
     * Set the value of domainQueryMap
     *
     * @param domainQueryMap new value of domainQueryMap
     */
    public void setDomainQueryMap(Map<String, String> domainQueryMap)
    {
        this.domainQueryMap = domainQueryMap;
    }


    @Override
    public InputStream getData(String domain, String id)
    {
        String query = domainQueryMap.get(domain);
        String realQuery=String.format(query,id);
        
        //Use the new real query string and the endpoint to query fmwl.
        
        return super.getData(domain, id); //To change body of generated methods, choose Tools | Templates.
    }

}
