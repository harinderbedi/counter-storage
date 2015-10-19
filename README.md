Multimodule Spring Boot application

To Build and to create package

-Execute 'mvn clean package'
-Executeable war will be created in innometrics-webservice/target
-War can be deployed on any webserver
-Rest apis can be accessed on 

	http://<server>:<port>/<context>/counter/increment/<countername>
	http://<server>:<port>/<context>/counter/value/<countername>
	http://<server>:<port>/<context>/counter/list
	
	
	
	
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

