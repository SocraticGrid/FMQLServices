/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.fmql.services.fmqlservices.patient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.socraticgrid.patientdataservices.MainRetriever;
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
@ContextConfiguration(locations={"classpath:Test-FMQLDataSourceTest.xml"})

public class DataSourceTest extends TestCase  implements ApplicationContextAware
{
    
    public DataSourceTest()
    {
    }
   
    private ApplicationContext ctx;
//    {
//        // Had to instantiate this directly cause ContextConfiguration annotation didn't work..unk.
//        this.ctx = new ClassPathXmlApplicationContext("classpath:Test-FMQLDataSourceTest.xml");
//    }
    
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
        System.out.println("\n=========================\nTESTING getFmqlEndpoint");
        
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        String result = instance.getFmqlEndpoint();
        
        System.out.println("EP="+result);
        
        
    }

    /**
     * Test of setFmqlEndpoint method, of class DataSource.
     */
    @Test
    public void testSetFmqlEndpoint()
    {
        System.out.println("\n=========================\nTESTING setFmqlEndpoint");
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
        System.out.println("\n=========================\nTESTING isDomainSupported");
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
        System.out.println("\n=========================\nTESTING getDomainQueryMap");
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
        System.out.println("\n=========================\nTESTING testSetDomainQueryMap");
        Map<String, String> domainQueryMap = null;
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        instance.setDomainQueryMap(domainQueryMap);
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class DataSource.
     * NOTE:  weirdly, "focused" test or debug test on this test passes ok.
     *        But, an overall "test file" fails on building the endpoint+query URL string.
     */
    @Test
    public void testGetData() throws IOException
    {
        System.out.println("\n=========================\nTESTING testGetData");
        String domain = "demographics";
        String id = "1006387";
        
        DataSource source = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        
        InputStream result = source.getData(domain, id, null);
        

        //System.out.println(IOUtils.toString(result, "UTF-8"));
        
    }
    
    /**
     *   Running Focused Test is ok:  
     *      ep+query= http://10.255.167.112/fmqlEP?fmql=DESCRIBE+2-1006387
     * 
     *   ??? Running Test File fails with:  java.net.MalformedURLException
     *      ep+query= ?fmql=DESCRIBE+2-100638
     * 
     * @throws IOException 
     */
    @Test
    public void testRetrieveFMQLData() throws IOException {
        
        System.out.println("\n=========================\nTESTING testRetrieveFMQLData");
        String domain = "demographics";
        String id = "1006387";
        
        MainRetriever retriever = (MainRetriever) ctx.getBean("FMQLRetriever");
        
        //Transformer trans = retriever.getTransformer(); //OPTIONAL

        InputStream result =  retriever.getDataAsStream("FMQL", domain, id, null);
        
        //System.out.println(IOUtils.toString(result, "UTF-8"));
    }
    
    @Test
    public void testStaticBypassOfTransform() throws IOException {
        
        System.out.println("\n=========================\nTESTING testStaticBypassOfTransform");
        String domain = "allergies";
        String id = "1006387";
        
        MainRetriever retriever = (MainRetriever) ctx.getBean("FMQLRetriever");
      
        InputStream result =  retriever.getDataAsStream("FMQLStaticTransformByPass", domain, id, null);
        
        //System.out.println(IOUtils.toString(result, "UTF-8"));
    }
    
    @Test
    public void testStaticXMLSource() throws IOException {
        
        System.out.println("\n=========================\nTESTING testStaticXMLSource");
        String domain = "demographics";
        String id = "1006387";
        
        MainRetriever retriever = (MainRetriever) ctx.getBean("FMQLRetriever");
      
        InputStream result =  retriever.getDataAsStream("FMQLStaticXML", domain, id, null);
        
        //System.out.println(IOUtils.toString(result, "UTF-8"));
    }
}
