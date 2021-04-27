# Demo app K8S objects

To deploy the demo app, use the following command:

```
kubectl apply -k .
```

## Exposing the demo app with the ingress

```
kubectl apply -f ./olss-app.ingress.yaml
```

## Registering the demo app for prometheus metrics scraping

```
kubectl apply -f ./olss-app.servicemonitor.yaml
```
