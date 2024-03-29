registrycenter  -----8888

provider  ------9001
服务提供者，并且在 Eureka Server 完成注册，大致思路是先通过 Spring Boot 搭建一个微服务应用，
再通过 Eureka Client 将其注册到 Eureka Server，
创建 Eureka Client 的过程与创建 Eureka Server 十分相似

consumer  ------9002
服务消费者 consumer，调用 provider 相关接口，实现思路是先通过 Spring Boot 搭建一个微服务应用，
再通过 Eureka Client 将其注册到 Eureka Server。此时的 provider 和 consumer 从代码的角度看并没有区别，
都是 Eureka 客户端，我们人为地从业务角度对它们进行区分，provider 提供服务，consumer 调用服务，
具体的实现需要结合 RestTemplate 来完成，即在服务消费者 consumer 中通过 RestTemplate
来调用服务提供者 provider 的相关接口。

geteway   ------9000
Zuul
API 网关可以对所有的 API 请求进行管理维护，相当于为系统开放出一个统一的接口，
所有的外部请求只需要访问这个统一入口即可，系统内部再通过 API 网关去映射不同的微服务。
对于开发者而言就不需要关注具体的微服务 URL 了，直接访问 API 网关接口即可

ribbon  ------- 9090

什么是 Ribbon？
Spring Cloud 提供了实现负载均衡的解决方案：Spring Cloud Ribbon，
Ribbon 是 Netflix 发布的负载均衡器，
而 Spring Cloud Ribbon 则是基于 Netflix Ribbon 实现的，
是一个用于对 HTTP 请求进行控制的负载均衡客户端。

feign   ------- 9010
与Ribbon一样，Feign也是由Netflix提供，Feign是一个提供模版的声明式Web服务客户端，
使用Feign可以简化Web Service客户端的编写，开发者可以通过简单的接口和注解来调用HTTP API，
进行开发Spring Cloud也提供了Feign的集成组件：Spring Cloud Feign，
它整合了Ribbon和Hystrix，具有可插拔，基于注解，负载均衡，服务熔断等多种便捷功能。

hystrix  ------9020
Hystrix 是 Netflix 的一个开源项目，是一个熔断器模型的具体实现，熔断器就类似于电路中的保险丝，
某个单元发生故障就通过烧断保险丝的方式来阻止故障蔓延，
微服务架构的容错机制也是这个原理。
Hystrix 的主要作用是当服务提供者发生故障无法访问时，向服务消费者返回 fallback 降级处理，从而响应时间过长或者直接抛出异常的情况。

nativeconfigserver    ------9030
Spring Cloud Config 可以将配置文件存放在本地，也可以存放在远程 Git 仓库中。拿远程 Git 仓库来说，
具体的操作思路是将所有的外部配置文件集中放置在 Git 仓库中，然后创建 Config Server，通过它来管理所有的配置文件，
需要更改某个微服务的配置信息时，只需要在本地进行修改，然后推送到远程 Git 仓库即可，所有的微服务实例都可以通过 Config Server 来读取对应的配置信息。

zipkin   ---------9090
Zipkin 是一个可以采集并且跟踪分布式系统中请求数据的组件，可以为开发者采集某个请求在多个微服务之间的追踪数据，并以可视化的形式呈现出来，
让开发者可以更加直观地了解到请求在各个微服务中所耗费的时间等信息。