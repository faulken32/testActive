# testActive

comile 

mvn -DskipTests=true clean install

start java -jar target/test-0.0.1-SNAPSHOT.jar 



exec exemple : 

curl -X POST --location "http://localhost:8080/api/bill" \
    -H "Content-Type: application/json" \
    -d "{
          \"type\" : \"CAR\",
          \"start\" : \"2017-12-27T09:05:30.523\",
          \"end\"  : \"2017-12-27T11:05:30.523\"
        
        }"
