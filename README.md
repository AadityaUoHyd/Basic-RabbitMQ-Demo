# Basic tutorial to understand how to use AMQP messaging via RabbitMQ in a Spring Boot application (by Aaditya Bachchu Chatterjee). 

- RabbitMQ is a messaging broker - an intermediary for messaging. It gives our applications a 
common platform to send and receive messages, and our messages a safe place to live until received.
It's a software where queues are defined, to which applications connect in order to transfer a message(s).

- PRODUCER -> EXCHANGE -> QUEUE -> CONSUMER. 

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