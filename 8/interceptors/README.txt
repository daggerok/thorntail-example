./mvnw -pl :interceptors -Pstart

killall -9 java ; ./mvnw -pl :interceptors ; bash ./8/interceptors/target/*-thorntail.jar

http :8080 who=cares
http :8080 name=Maksimko
