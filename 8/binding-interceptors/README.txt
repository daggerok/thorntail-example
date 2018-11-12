./mvnw -pl :binding-interceptors -Pstart

killall -9 java ; ./mvnw -pl :binding-interceptors ; bash ./8/binding-interceptors/target/*-thorntail.jar

http :8080 who=cares
http :8080 name=Maksimko
