package io.starter.stackgen.maven;

import io.starter.ignite.generator.ReactConfigurator;
import io.starter.ignite.generator.ReactGenerator;
import io.starter.ignite.generator.StackGenConfigurator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Run StackGen CodeGen via Maven
 * <p>
 * <p>
 * java"; @Parameter(default = "")
 * String doit"; @Parameter(default = "")
 * String modelDaoPackage=io.starter.StackGenUI.model.dao"; @Parameter(default = "")
 * String javaGenFolderName=''"; @Parameter(default = "")
 * String gDstarterIgniteSecureKey=asdfasdf="; @Parameter(default = "")
 * String dbUrl=jdbc:mysql://db-dev.stackgen.io"; @Parameter(default = "")
 * String dbName=sg-dev"; @Parameter(default = "")
 * String dbUser=testuser"; @Parameter(default = "")
 * String dbPassword=abababab!"; @Parameter(default = "")
 * String dbDriver=com.mysql.cj.jdbc.Driver"; @Parameter(default = "")
 * String schemaName=stackgen"; @Parameter(default = "")
 * String schemaFile=starter_ignite.yml"; @Parameter(default = "")
 * String artifactId=StackGenUI"; @Parameter(default = "")
 * String REACT_APP_NAME=StackGenUI"; @Parameter(default = "")
 * String adminUser=super"; @Parameter(default = "")
 * String adminPassword=castl3burn"; @Parameter(default = "")
 * String developerOrganizationUrl=stackgen.io"; @Parameter(default = "")
 * String mergePluginGen=false"; @Parameter(default = "")
 * String iteratePluginGen=false"; @Parameter(default = "")
 * String overwriteMode=true"; @Parameter(default = "")
 * String skipDbGen=false"; @Parameter(default = "")
 * String dbGenDropTable=true"; @Parameter(default = "")
 * String skipJavaGen=false"; @Parameter(default = "")
 * String skipMybatisGen=false"; @Parameter(default = "")
 * String skipBackendGen=false"; @Parameter(default = "")
 * String skipReactGen=false"; @Parameter(default = "")
 * String artifactVersion=0.9.31-SNAPSHOT"; @Parameter(default = "")
 * String StackGenVersion=0.9.31-SNAPSHOT"; @Parameter(default = "")
 * String REACT_APP_OUTPUT_FOLDER=/stackgen-UI/src/"; @Parameter(default = "")
 * String REACT_APP_NAME=StackGenUI"; @Parameter(default = "")
 * String REACT_TEMPLATE_FOLDER=/sg-template-java_spring_mybatis_react_redux/src/main/react/"; @Parameter(default = "")
 * String templateDir=/sg-template-java_spring_mybatis_react_redux/src/main/java/spring-boot/"; @Parameter(default = "")
 * String genOutputFolder=/automator/stackgen-core -jar target/stackgen-0.9.31-SNAPSHOT-exec.jar
 */

@Mojo(name = "generate",
        defaultPhase = LifecyclePhase.GENERATE_SOURCES,
        threadSafe = true)
public class StackGenMojo extends AbstractMojo {

    @Parameter
    String orgPackage;

    @Parameter
    String lang;

    @Parameter
    String starterIgniteSecureKey;

    @Parameter
    String dbUrl;

    @Parameter
    String dbName;

    @Parameter
    String dbUser;

    @Parameter
    String dbPassword;

    @Parameter
    String dbDriver;

    @Parameter
    String schemaName;

    @Parameter
    String inputSpec;

    @Parameter
    String artifactId;

    @Parameter(defaultValue = "1.0.0-SNAPSHOT")
    String artifactVersion;

    @Parameter(defaultValue = "0.9.31-SNAPSHOT")
    String StackGenVersion;

    @Parameter
    String adminUser;
    @Parameter
    String adminPassword;

    @Parameter
    String developerOrganizationUrl;

    @Parameter
    boolean mergePluginGen = false;

    @Parameter
    boolean iteratePluginGen = false;

    @Parameter
    boolean overwriteMode = true;

    @Parameter
    boolean skipDbGen = false;

    @Parameter
    boolean dbGenDropTable = true;

    @Parameter
    boolean skipJavaGen = false;

    @Parameter
    boolean skipMybatisGen = false;

    @Parameter
    boolean skipBackendGen = false;

    @Parameter
    boolean skipReactGen = false;

    @Parameter(defaultValue = "model.dao")
    String modelDaoPackage;

    @Parameter(defaultValue = "/src/generated-sources/main/java")
    String javaGenFolderName;

    @Parameter(defaultValue = "MyNewStackGenApp")
    String REACT_APP_NAME;

    @Parameter
    String REACT_APP_OUTPUT_FOLDER;

    @Parameter(defaultValue = "sg-template-java_spring_mybatis_react_redux/src/main/react/")
    String REACT_TEMPLATE_FOLDER;

    @Parameter(defaultValue = "/spring-boot/", required = true)
    String templateDir;

    @Parameter(defaultValue = "/genOutputFolder")
    String genOutputFolder;

    /**
     * Generate Stack
     *
     * @throws MojoExecutionException
     */

    public void execute() throws MojoExecutionException {
        getLog().info("StackGen CodeGen Maven Plugin: init");
        try {
            getLog().info("StackGen Maven Plugin CodeGen of: "
                    + this.artifactId
                    + " project will output to: " + this.genOutputFolder);

            StackGenConfigurator config = ReactConfigurator.configureFromPOJO(this, null);

            // configure
            System.setProperty("StackGenVersion", "0.9.31-SNAPSHOT");

            new ReactGenerator(
                    config)
                    .generateApp();
        } catch (Exception e) {
            e.printStackTrace();
            throw new MojoExecutionException(e.getMessage(), e);
        }
        getLog().info("StackGen CodeGen Maven Plugin: done");
    }

}
