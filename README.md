Here this project consist of mainly 6 microservices and those are,

  1/  User service (banking-core-user-service) : 
  This service includes all the operations under the User such as registrations and retrieval. Additionally, this API consumes keycloak REST API to register and manage the user base while using the local PostgreSQL database as well.
  
    2/ Fund transfer service (banking-core-fund-transfer-service):
  This is the service that handles all the fund transfers between accounts and this API will push messages to a centralized RabbitMQ queue to use from the Notification service.
    
   3/ Payment service (banking-core-payments-service):
   This service will include all the API endpoints to process Utility payments in this project and that will push notification messages to RabbitMQ as well.
  
   4/ Notification service :
   This API is registered under the service registry but consumes all the messages from RabbitMQ and pushes necessary notifications to the end users.
  
  5/  Banking core service :
  This is the banking core service that acts as a dummy banking core with accounts, users, transaction details, and processors for banking transactions.
