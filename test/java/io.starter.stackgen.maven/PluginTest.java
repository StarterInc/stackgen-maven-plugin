package io.starter.stackgen.maven;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Ignore;

import java.io.File;

public class PluginTest
        extends AbstractMojoTestCase
{
    /** {@inheritDoc} */
    @Override
    protected void setUp()
            throws Exception
    {
        // required
        super.setUp();

       // ...
    }

    /** {@inheritDoc} */
    @Override
    protected void tearDown()
            throws Exception
    {
        // required
        super.tearDown();

       // ...
    }

    /**
     * @throws Exception if any

    @Ignore
    public void testSomething()
            throws Exception {
        
        String path = "/pom.xml";

        File pom = getTestFile( path);

        System.err.println(pom.getAbsolutePath());
        assertNotNull( pom );
        assertTrue( pom.exists() );
        io.starter.stackgen.maven.StackGenMojo myMojo =
                (io.starter.stackgen.maven.StackGenMojo)
                lookupMojo( "generate", pom );

        assertNotNull( myMojo );
        myMojo.execute();

       // ...
    }*/
}