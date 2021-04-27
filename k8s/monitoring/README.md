# Deploy the Prometheus operator on minikube

## Install the prometheus stack

```
kubectl create namespace monitoring
helm install prometheus prometheus-community/kube-prometheus-stack --namespace monitoring --values=prometheus-kube-stack.values.yml
```
