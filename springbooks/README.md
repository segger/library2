# springbooks

Minimal spring boot app serving REST API for books stored in firestore 

## Run locally
Add `spring.cloud.gcp.firestore.project-id` and `spring.cloud.gcp.firestore.credentials.location` to `application.properties`

```
./gradlew bootRun
```

## Run on App Engine

```
./gradlew build
gcloud app deploy build/libs/springbooks-0.0.1-SNAPSHOT.jar
```
