Schema Evolution — User Signup Events
Project Name: UserSignupPipeline
Goal:
Handle changes in user event structure without breaking consumers.

Tech Stack:
-Java 17
-Spring Boot
-Kafka + Confluent Schema Registry
-Avro
-spring-cloud-stream (optional)

How It Works:
Service A produces user.signup.v1 event with fields: name, email.
Service B consumes and logs/stores.
You evolve schema by adding phoneNumber.
Rules to Follow:
Kafka-Specific:

Register schema in Schema Registry
Ensure BACKWARD compatibility
Code Quality:

Use Avro-generated DTOs
Keep schema evolution history
Testing:

Unit: Schema serialization test
Integration: Consume old → evolve → consume new
Negative: Register incompatible schema → catch exception
