/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.fmql.services.fmqlservices.patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.socraticgrid.documenttransformer.Transformer;
import org.socraticgrid.patientdataservices.DataRetriever;
import org.socraticgrid.patientdataservices.DataSourceBinding;
import org.socraticgrid.patientdataservices.MainRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jerry Goodnough
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "/applicationContext.xml" and "/applicationContext-test.xml"
// in the root of the classpath

// UNK: THIS ContextConfiguration NOTATION NOT WORKING.
//@ContextConfiguration(locations={"classpath:Test-FMQLDataSourceTest.xml"})


public class DataSourceTest extends TestCase  implements ApplicationContextAware
{

    public DataSourceTest()
    {
    }
   
    private ApplicationContext ctx;
    {
        // Had to instantiate this directly cause ContextConfiguration annotation didn't work..unk.
        this.ctx = new ClassPathXmlApplicationContext("classpath:Test-FMQLDataSourceTest.xml");
    }
    
    public void setApplicationContext(ApplicationContext context)
    {
        this.ctx = context;
    }


    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of getFmqlEndpoint method, of class DataSource.
     */
    @Test
    public void testGetFmqlEndpoint()
    {
        System.out.println("getFmqlEndpoint");
        
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        String result = instance.getFmqlEndpoint();
        
        System.out.println("EP="+result);
        
        String expResult = "http://caregraf.org";
        assertEquals(expResult, result);
    }

    /**
     * Test of setFmqlEndpoint method, of class DataSource.
     */
    @Test
    public void testSetFmqlEndpoint()
    {
        System.out.println("setFmqlEndpoint");
        String fmqlEndpoint = "";
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        instance.setFmqlEndpoint(fmqlEndpoint);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isDomainSupported method, of class DataSource.
     */
    @Test
    public void testIsDomainSupported()
    {
        System.out.println("isDomainSupported");
        String domain = "demographics";
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        
        boolean expResult = false;
        boolean result = instance.isDomainSupported(domain);
        
        if (result)
            System.out.println("Domain "+domain+" is supported");
        else
            
            System.out.println("Domain "+domain+" is NOT upported");
        
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDomainQueryMap method, of class DataSource.
     */
    @Test
    public void testGetDomainQueryMap()
    {
        System.out.println("getDomainQueryMap");
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        Map expResult = null;
        Map result = instance.getDomainQueryMap();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDomainQueryMap method, of class DataSource.
     */
    @Test
    public void testSetDomainQueryMap()
    {
        System.out.println("setDomainQueryMap");
        Map<String, String> domainQueryMap = null;
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        instance.setDomainQueryMap(domainQueryMap);
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class DataSource.
     */
    @Test
    public void testGetData()
    {
        System.out.println("TESTING testGetData");
        String domain = "demographics";
        String id = "1006387";
        
        DataSource source = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        
        InputStream result = source.getData(domain, id);
        
        
        System.out.println(result);
        
        //InputStream expResult = null;
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testRetrieveFMQLData() {
        
        System.out.println("TESTING testRetrieveFMQLData");
        String domain = "demographics";
        String id = "1006387";
        
        MainRetriever retriever = (MainRetriever) ctx.getBean("SampleRetriever");
        
        //Transformer trans = retriever.getTransformer(); //OPTIONAL
        
        //DataSourceBinding sourceBinding = retriever.getDataSources().get("FMQL");

        InputStream result =  retriever.getDataAsStream("FMQL", domain, id);
        
        System.out.println(result);
    }
    
    @Test
    public void testStaticBypassOfTransform() throws IOException {
        
        System.out.println("TESTING testStaticBypassOfTransform");
        String domain = "allergies";
        String id = "1006387";
        
        MainRetriever retriever = (MainRetriever) ctx.getBean("SampleStaticTransform");
      
        InputStream result =  retriever.getDataAsStream("FMQL", domain, id);
        
        System.out.println(IOUtils.toString(result, "UTF-8"));
    }
    
}
