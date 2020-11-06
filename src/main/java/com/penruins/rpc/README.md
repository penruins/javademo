从单机走向分布式，产生了很多分布式的通信方式
    1. 最古老也是最有效，并且永不过时，TCP/UDP的二进制传输。事实上所有的通信方式归根结底都是TCP/UDP
    2. CORBA Common Object Request Broker Architecture 古老而复杂的 支持面向对象的通信协议
    3. Web Service (SOA SOAP RDDI WSDL...) 基于HTTP + XML 的标准化 Web API
    4. RestFul Representational State Transfer 回归简单化本源的Web API的事实标准 http + json
    5. RMI Remote Method Invocation   java内部的分布式通信协议
    6. JMS Java Message Service JavaEE中的消息框架标准，为很多MQ所支持
    7. RPC Remote Procedure Call 远程方法调用，这只是一个统称，重点在于方法调用（不支持对象的概念），具体实现甚至可以用RML RestFul等去实现
        但一般不用，因为RMI不能跨语言，而RestFul效率太低。多用于服务器集群间的通信，因此常使用更加高效 短小精悍的传输模式以提高效率
        
        
        
RPC通信协议
    http
    http 2.0 （gRPC）
    TCP 
        同步/异步 阻塞/非阻塞
    WebService