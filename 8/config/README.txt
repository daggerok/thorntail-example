run main class:
org.wildfly.swarm.Swarm

./mvnw -pl :config -Pstart
killall -9 java ; ./mvnw -pl :config ; bash ./8/config/target/*-thorntail.jar

http get :8080 who=cares
http :8080 who=cares
http post :8080
http :8080
