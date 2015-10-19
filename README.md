Multimodule Spring Boot REST application
It is a thread safe application exposed rest apis to create, increment and fetch named counters.
Application is designed to handle concurrent requests.

-Rest apis can be accessed on 

	http://<server>:<port>/<context>/counter/increment/<countername>
	http://<server>:<port>/<context>/counter/value/<countername>
	http://<server>:<port>/<context>/counter/list
	
To Build and to create package
-Execute 'mvn clean package'
-Executeable war will be created in innometrics-webservice/target
-War can be deployed on any webserver like Tomcat
	
	
APIs exposed and description-

To increment a counter-
	http://<server>:<port>/<context>/counter/increment/<countername>

To get counter value
	http://<server>:<port>/<context>/counter/value/<countername>

To list all counters-
	http://<server>:<port>/<context>/counter/list



Technologies used-
Spring Boot
JAX-RS
Java 7
Junit 4

