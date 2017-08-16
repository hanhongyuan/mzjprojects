title client-ha-lb1

cd target
java -jar mzjtest-eureka-client-0.0.1-SNAPSHOT.jar --spring.profiles.active=ha --server.port=8081 -Xmx512m

cd ..