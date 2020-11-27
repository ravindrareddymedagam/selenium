All the libraries are downloaded from maven repository including selenium and chrome driver
Step Definition location and the other primary metadata required to run the test are placed in pom.xml inside test phase
To execute this scenario locally 
Naviagte to the project location from command prompt where pom.xml is present (selenium\WeatherReporting)
execute the maven vefiy goal as below
Ex my project is localted at E:\Work\JAVA_QA\Workspace\selenium\WeatherReporting
1)Goto cmd 
2)cd E:\Work\JAVA_QA\Workspace\selenium\WeatherReporting
3)E:
4)mvn verify
once run is completed test reports are genarated under target folder 
target\cucumber-report-html\cucumber-html-reports\overview-features.html




