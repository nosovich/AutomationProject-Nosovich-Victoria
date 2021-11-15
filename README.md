# AutomationProject-Nosovich-Victoria

##View available library updates - `mvn versions:display-dependency-updates`
`[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   com.codeborne:selenide ............................... 5.25.0 -> 6.0.3
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0
[INFO]
[INFO] The following dependencies in Plugin Dependencies have newer versions:
[INFO]   org.aspectj:aspectjweaver ......................... 1.9.6 -> 1.9.8.RC2
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.739 s
[INFO] Finished at: 2021-11-15T21:10:09+01:00
[INFO] ------------------------------------------------------------------------`



##Running tests from command line using mvn clean test - `mvn clean test -Dtest=Task_15`
`[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running Task_15.Task_15
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 18.311 s - in Task_15.Task_15
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  28.352 s
[INFO] Finished at: 2021-11-15T21:31:18+01:00
[INFO] ------------------------------------------------------------------------`



##Running testng.xml file from command line using mvn clean test:
###1. Add to testng.xml file in pom.xml file (will make it default)
`    <properties>
        <suite>src/test/resources/Task_16src/test/resources/Task_15.xml</suite>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M3</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>${suite}</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>`
###2.Run mvn clean test with testng.xml file -DsuiteXmlFile = yourDefault.xml
`[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.66 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  27.687 s
[INFO] Finished at: 2021-11-15T21:50:12+01:00
[INFO] ------------------------------------------------------------------------`


