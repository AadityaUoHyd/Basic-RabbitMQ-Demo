# Basic tutorial to understand how to use AMQP messaging via RabbitMQ in a Spring Boot application.

- RabbitMQ is a messaging broker - an intermediary for messaging. It gives our applications a 
common platform to send and receive messages, and our messages a safe place to live until received.
It's a software where queues are defined, to which applications connect in order to transfer a message(s).

# How to spin RabbitMq on Docker :

- Run this command on docker terminal:-
     docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management

# How to install RabbitMq-Server in Windows System: 

- Download and install ERlang http://erlang.org/download/otp_win64_22.3.exe

- Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe

- Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.3\sbin
Run command rabbitmq-plugins enable rabbitmq_management

- Open browser and enter http://localhost:15672/ to redirect to RabbitMQ Dashboard

- Also we can Open it with IP Address http://127.0.0.1:15672

- Login page default username and password is "guest"

- After successfully login you should see RabbitMQ Home page!

# PRODUCER -> EXCHANGE -> QUEUE -> CONSUMER. 

![](https://github.com/AadityaUoHyd/Basic-RabbitMQ-Demo/blob/master/RabbiTmq.png) 

- PRODUCER is suppose to give "routing-key" to EXCHANGE in order to send message to particular QUEUE where particluar 
CONSUMER which is bind to that QUEUE is waiting(or may receive when available) for receiving that message.

- Here 'Order' entity acting as Producer, and 'User' entity acting as Consumer.
- Here in this example, we are generating id randomly, and thus need to send name, qty & price in Postman with POST type. 

URL : http://localhost:9292/order/paradise <br>
{ <br>
	"name":"Chicken Briyani", <br>
	"qty":1, <br>
	"price":500 <br>
} <br>

- One can find the order inside 'Get Message' of 'Queues' navbar of RabbitMQ dashboard, once login there in case message not delivered & is still in queue.
But here, as 'User' acts as consumer and consumed our Order, thus we can see same message at console and not at RabbitMQ dashboard's Queues.

# Exchange Types:
	AMQP has 5 types of exchanges.

- Direct Exchange : The routing in direct exchange is simple — a message goes to the queues whose binding key exactly matches the routing key of the message.
The direct exchange type is useful to distinguish messages published to the same exchange using a simple string identifier.
![](https://github.com/AadityaUoHyd/Basic-RabbitMQ-Demo/blob/master/RabbitDirect.JPG)

- Fanout Exchange : A fanout exchange copies and routes a received message to all queues that are bound to it regardless of routing keys or patterns. 
The keys provided will simply be ignored. Fanout exchanges can be useful when the same message needs to be sent to one or more queues with consumers 
who may process the same message in different ways.
![](https://github.com/AadityaUoHyd/Basic-RabbitMQ-Demo/blob/master/RabbitFan.JPG)

- Topic Exchange : Topic exchange is similar to direct exchange, but the routing is done according to the routing pattern. Instead of using fixed routing key, 
it uses wildcards. Messages are routed to one or many queues based on a matching between a message routing key and pattern. The routing key must consist of list 
of words delimited by a period “.”.
![](https://github.com/AadityaUoHyd/Basic-RabbitMQ-Demo/blob/master/RabbitTopic.JPG)

- Headers Exchange : A headers exchange routes messages based on arguments containing headers and optional values. It uses the message 
header attributes for routing. A special argument named “x-match”, added in the binding between exchange and queue, specifies if all headers 
must match or just one. The “x-match” property can have two different values: “any” or “all”,where “all” is the default value. A value of “all” 
means all header pairs (key, value) must match, while value of “any” means at least one of the header pairs must match.
![](https://github.com/AadityaUoHyd/Basic-RabbitMQ-Demo/blob/master/RabbitHeader.JPG)

- Default Exchange : The default exchange is a pre-declared direct exchange that has no name. It is usually referred by an empty string. 
If you use default exchange your message is delivered to the queue with a name equal to the routing key of the message. Every queue is 
automatically bound to the default exchange with a routing key which is the same as the queue name.
![](https://github.com/AadityaUoHyd/Basic-RabbitMQ-Demo/blob/master/RabbitDefault.JPG)

#Note : If there is no matching queue for the message, the message is dropped. RabbitMQ provides an AMQP extension known as the “DEAD LETTER EXCHANGE”.

# Sources to learn :

   https://www.rabbitmq.com/tutorials/amqp-concepts.html 
