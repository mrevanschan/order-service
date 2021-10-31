# order-service


To run microservice in stand-alone mode, run the following in project root(exposed calls, not secured):
```
$ mvn spring-boot:run
```


Push image to docker hub for image pull for istio service mesh setup(No calls exposed,secured)
run the following code from root:
```
$ mvn clean package
$ docker -t order-service:latest .
$ docker tag order-generator:lastest evanschan/order-service
$ docker push evanschan/order-service
```

note that I used my own Docker Hub repository for the istio service mesh image pull.
