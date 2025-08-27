# Cat API Tests

## How to run tests:

Put your API token in: src/main/resources/application.properties:

api.key=YOUR_TOKEN

## Run tests with Maven:

mvn clean install

## CI Integration (Jenkins):

1. Create a new Jenkins job.

2. Configure build step to run Maven command:

    mvn clean install

3. Add post-build action to generate Allure report using results from:

    target/allure-results