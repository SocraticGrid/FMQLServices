/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.fmql.services.fmqlservices.patient;

import java.io.InputStream;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Jerry Goodnough
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "/applicationContext.xml" and "/applicationContext-test.xml"
// in the root of the classpath
@ContextConfiguration(locations={"classpath:Test-FMQLDataSourceTest.xml"})
public class DataSourceTest extends TestCase  implements ApplicationContextAware
{

    public DataSourceTest()
    {
    }
   
    private ApplicationContext ctx;
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
        String expResult = "";
        String result = instance.getFmqlEndpoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDomainSupported method, of class DataSource.
     */
    @Test
    public void testIsDomainSupported()
    {
        System.out.println("isDomainSupported");
        String domain = "";
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        boolean expResult = false;
        boolean result = instance.isDomainSupported(domain);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class DataSource.
     */
    @Test
    public void testGetData()
    {
        System.out.println("getData");
        String domain = "";
        String id = "";
        DataSource instance = (DataSource) ctx.getBean("SampleFMQLPatientDataSource");
        InputStream expResult = null;
        InputStream result = instance.getData(domain, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
