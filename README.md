# Text Ingester


## Building

`./gradlew build`


`cd docker`

`./prepare_build_docker.sh`

`cd build_context`
`docker build -t text-ingester .`


## Running

`cd ..`

`./run_docker.sh`


### Kafka cluster in docker

https://github.com/adambirse/kafka-spring-boot


`curl -d '{"text":"value"}' -H "Content-Type: application/json" -X POST http://localhost:8080/text`