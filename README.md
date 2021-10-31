# order-service


## Running standalone instance(No secured)
To run microservice in stand-alone mode, run the following in project root(exposed calls, not secured):
```
$ mvn spring-boot:run
```


## Running on istio service mesh(Secured)
Follow the instruction [here](https://www.google.com) if you want to use the docker image I prepared on my Docker Hub account, Otherwise replace "evanschan" from the following code and run them from root directory:
```
$ mvn clean package
$ docker -t order-service:latest .
$ docker tag order-generator:lastest evanschan/order-service
$ docker push evanschan/order-service
```
After pushing the docker image to your own repository, follow the instructions here  [here](https://www.google.com) to start the istio service mesh
