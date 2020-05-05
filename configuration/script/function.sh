azure-run() {
  mvn clean package azure-functions:run
}

azure-deploy() {
  mvn clean package azure-functions:deploy
}
