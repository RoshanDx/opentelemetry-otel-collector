# How to run?

1. Run ```make build-all```
2. After build complete, run ```docker-compose up```
3. Once all services are up, you can fire this api,
```curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Wick\"}" http://localhost:8081/api/v1/user```

## Jaeger [http://localhost:16686/]
1. Under Services, make sure you can view ```garuda-user``` and ```garuda-notification```
2. Make sure you view the traces and spans

## Prometheus [http://localhost:19090/targets?search]
1. Make sure you can see ```http://otel-collector:8889/metrics``` state UP

## Grafana [http://localhost:13000/explore?]
1. Make sure you can see your prometheus query, try to query, ```http_server_requests_count```
