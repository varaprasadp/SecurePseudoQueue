# SecurePseudoQueue

**Technologies used**

1.  Java 8
2.  Spring boot
3.  h2 database for local storage
4.  Postgresql for storage on cloud
5.  Heroku for web hosting

Developed two microservices namely EncryptionMS and DecryptionnMS
Used Base64 for encryption and decryption

**Steps to run in Local**

1.  Unzip and import the projects.
2.  Run maven build
3.  Go to main methods and run the applications as 'java application'/'spring boot application'
4.  Encryption micro service starts at port 8080.
5.  [EncryptionMS](http://localhost:8080/ "EncryptionMS")
6.  [DecryptionMS](http://localhost:8081/ "DecryptionMS")
7.  To test the microservices, use post method and give [EncryptionMS](http://localhost:8080/ "EncryptionMS") as url and the body as raw json as give below.

```
{
"accountNumber": "123456789",
"type": "CREDIT",
"amount": "1000",
"currency": "INR",
"accountFrom": "987654321"
}
```

Now this Encryption microservice encrypts the data and sends the encrypted object to the Decryption Microservice which decrypts and saves the data in local memory and returns toString of that object.
And the database has a primary key called transactionNo which autopopulates so that we can give the same account number as many times as we want(any number of transactions can be performed with same account).
The path for the local storage given in the microservice is D:/data/transaction.
Please change the path according to your local availability of drives and permissions, we can change it in DecryptionMS application.properties.
If still there is some environmental issue like not having the drives or not having permissions to the drives please use "spring.datasource.url=jdbc:h2:mem:transactiondb" in the application properties of DecryptMS.
After the initial post call we need to change 'spring.jpa.hibernate.ddl-auto=create' to 'spring.jpa.hibernate.ddl-auto=update', otherwise the data stored in previous post call will be lost and everytime the post call happens data overwrites the previous one.

**Steps to check Deployed microservices**
To test the microservice use post method and give [EncryptionMS-heorku](https://encryption-ms.herokuapp.com/ "EncryptionMS") as url and the body as raw json mentioned above.
This posts the object to Encryption microservice and the object is encrypted there and then sent to Decryption microservice and there the object will be decrypted and saved in the postgressql database on cloud and toString object is returned.
[EncryptionMS-heorku](https://encryption-ms.herokuapp.com/ "EncryptionMS")
[DecryptionMS-heorku](https://decryption-ms.herokuapp.com/ "DecryptionMS")

**URLs**

1.  http://localhost:8080/ - EncryptionMS local
2.  http://localhost:8081/ - DecryptionMS local
3.  https://encryption-ms.herokuapp.com/ - EncryptionMS heroku
4.  https://decryption-ms.herokuapp.com/ - DecryptionMS heroku

**Object / body to be given in post call's**
{
"accountNumber": "123456789",
"type": "CREDIT",
"amount": "1000",
"currency": "INR",
"accountFrom": "987654321"
}

Github repo:
https://github.com/varaprasadp/SecurePseudoQueue
EncryptionMS - feature/encryptionMS
DecryptionMS - feature/decryptionMS
