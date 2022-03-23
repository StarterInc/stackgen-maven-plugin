# stackgen-maven-plugin
The Maven Plugin for StackGen CodeGen

To generate your StackGen project during Maven Build

Here is an example configruation:

``````
<plugins>
            <!-- -->
            <plugin>
                <groupId>io.starter</groupId>
                <artifactId>stackgen-maven-plugin</artifactId>
                <version>0.9.31-SNAPSHOT</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>

                    </execution>
                </executions>

                <configuration>

                    <starterIgniteSecureKey>W3ngNBCp80mgG0wwjTslfeQoG2hQa9ryqbemTEX01Wg\=</starterIgniteSecureKey>


                    <dbUrl>jdbc:mysql://db-dev.stackgen.io</dbUrl>
                    <dbName>sg-dev</dbName>
                    <dbDriver>com.mysql.cj.jdbc.Driver</dbDriver>
                    <dbPassword>${sg.db.password}</dbPassword>


                    <lang>java-spring</lang>
                    <orgPackage>io.happypath</orgPackage>
                    <adminUser>admin</adminUser>
                    <adminPassword>pass</adminPassword>
                    <artifactId>HappyPathRevenge</artifactId>
                    <asrtifactVersion>1.0.0-SNAPSHOT</asrtifactVersion>
                    <dbGenDropTable>false</dbGenDropTable>
                    <templateDir>/Users/johnmcmahon/workspace/sg-template-java_spring_mybatis_react_redux/src/main/java/spring-boot</templateDir>
                    <javaGenFolderName>/generated-sources/src/test/java</javaGenFolderName>
                    <dbName>HappyPath</dbName>
                    <genOutputFolder>${project.basedir}/generated-sources</genOutputFolder>
                    <inputSpec>simple_cms.yml</inputSpec>

                    <REACT_APP_NAME>HAPPYREVENGER</REACT_APP_NAME>
                    <REACT_TEMPLATE_FOLDER>/Users/johnmcmahon/workspace/sg-template-java_spring_mybatis_react_redux/src/main/react</REACT_TEMPLATE_FOLDER>
                    <REACT_APP_OUTPUT_FOLDER>${project.basedir}/generated-sources</REACT_APP_OUTPUT_FOLDER>

                    <dbGenDropTable>true</dbGenDropTable>

                    <skipBackendGen>false</skipBackendGen>
                    <skipDbGen>false</skipDbGen>
                    <skipJavaGen>false</skipJavaGen>
                    <skipMybatisGen>false</skipMybatisGen>
                    <skipReactGen>false</skipReactGen>

                </configuration>
            </plugin>

        </plugins>

```