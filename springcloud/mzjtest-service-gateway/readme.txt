利用Sleuth进行服务跟踪
这个工程既是服务提供者，也是消费者

测试网关：
http://localhost:8083/api-test/test
http://localhost:8083/api-test/test?accessToken=1

错误：o.s.c.n.z.filters.post.SendErrorFilter : Error during filtering
解决：通过在配置文件中添加
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 60000