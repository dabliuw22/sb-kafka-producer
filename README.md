# Spring Boot Kafka Producer

Proyecto spring boot que utiliza integración con kafka para comunicación asíncrona con microservicio consumer. Kafka funciona como intermediario para los mensajes entre el microservicio producer y consumer. Aspectoas a tener en cuenta:

1. [Descargar](https://www.apache.org/dyn/closer.cgi?path=/kafka/1.1.0/kafka_2.11-1.1.0.tgz) kafka.

2. Descomprimir e ingresar a la carpeta:

3. Correr zookeeper:
```
$ ./bin/zookeeper-server-start.sh ./config/zookeeper.properties
```
4. Correr kafka:
```
$ ./bin/kafka-server-start.sh ./config/server.properties
```

5. Correr el proyecto producer