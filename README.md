# reactive-kotlin
## Setup
### OAuth
## Local
## Deploying to GCP
- Loosely followed this guide: https://codelabs.developers.google.com/spring-native-quickstart
- Build the native image locally:
  - `gradle bootBuildImage`
- Re-tag the image: 
  - `docker tag kotlin:0.0.1-SNAPSHOT us-east1-docker.pkg.dev/kotlin-404723/native-image-docker/kotlin:v1`
- Push the image: 
  - `docker push us-east1-docker.pkg.dev/kotlin-404723/native-image-docker/kotlin:v1`
- Deploy the image: 
  - `gcloud run deploy --image us-east1-docker.pkg.dev/kotlin-404723/native-image-docker/kotlin:v1`