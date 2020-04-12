# SpringCloudS_Demo
学习spring cloud 
### eureka-server
使用eureka插件创建一个 eureka 服务与注册发现项目

### eureka-client
普通的service项目，在启动时，会自动将自己注册进入eureka

### eureka-consumer
可以理解为普通项目的网关层，或是服务的调用方，当收到外部请求时，通过http请求从eureka-server 拿到service（eureka-client） 服务 的节点列表，然后每次向不同的service节点发送请求

### eureka-consumer-ribbon
与eureka-consumer 类似，有一点不同的时，在该服务中向service（eureka-client）节点请求时，无需手动获取所有service的节点列表了，而是 通过注入的 RestTemplate/WebClient 内嵌了ribbon，调用的url只要填写http://eureka-client/dc ，在发送请求时，ribbon 就会自动的将域名部分更换为service的节点IP 加端口，自动完成 负载均衡。

### 启动顺序
- 启动 eureka-server
- 启动 eureka-client
- 启动 eureka-consumer
- 启动 eureka-consumer-ribbon
