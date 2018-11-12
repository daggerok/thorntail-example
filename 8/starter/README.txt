run main class:
org.wildfly.swarm.Swarm

./mvnw -pl :starter -Pstart
killall -9 java ; ./mvnw -pl :starter ; bash ./8/starter/target/*-thorntail.jar

http get :8080 who=cares
http :8080 who=cares
http post :8080
http :8080
