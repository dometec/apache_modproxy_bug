# Apache mod_proxy balancer bug test case 

This is a test case to see the (empty) POST request that the load balancer send to a live node after that, with the same request, the balances found a failure server.

# Bug Description
I've configured an Apache HTTPd as a load balancer to forward request towards two instances of ApplicationServer, using mod_proxy, mod_proxy_balancer and mod_lbmethod_byrequests. 
I started only one ApplicationServer.
When the mod_proxy sends a request to power off node understand that this is not alive and send the same request to other (live) node, but with an empty **body**.

The body of the POST Request is less 2KB (30 byte in this test case).

# Expected Behaviour
The second POST request, to the live node, SHOULD have the body.

# Steps to reproduce
I've prepared a test case with a Apache HTTPd and an application server (wildfly) using container and docker compose. Clone the repository and start the composer with:
- docker-compose up --build

When the Apache HTTPd and Wildfly are started, on another shell find the IP Address of Apache:
- docker inspect dockerstack_apache_1 | grep IPAddress | tail -n 1

And send POST requests to Apache (do it more time):

- curl -v --data "parameter=bodyexample" http://172.19.0.2/service/rest/testbody

You will see that, when the request is used by mod_proxy to understand that the first node was down, then it is forwarded the the live node without the body. And the ApplicationServer response if 400 BAR REQUEST instead of 200 OK.

# Version affected
 - HTTPd 2.4.41

# Workaround

Not found
