# CSC3045Assignment4

Once you've cloned this repo and opened it up in intelliJ, you'll need to: 
1. Access Project Structure 
2. Modules 
3. Select Dependencies
4. Add a .jar 
5. Select postgresql-42.6.0.jar

I originally built this as a maven project but for some reason it wasn't finding the postgres driver, so this is my solution 

## How to spin up the docker DB
```docker-compose up```

Then using dataGrip etc. access the db with: 

User: username  
Password: password
