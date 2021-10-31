istioctl install
kubectl label namespace default istio-injection=enabled
kubectl apply -f order-service.yaml -f order-generator.yaml -f pizza-gateway.yaml