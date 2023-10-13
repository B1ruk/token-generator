#!/bin/bash

# Get the absolute path to the directory containing this script.
APP_DIR=$(pwd)

# Change to the directory containing the Gradlew script.
cd "$APP_DIR"

# Start the Spring Boot application.
./gradlew bootrun

# Change to the directory containing the React application.
cd "$APP_DIR/frontend/token-generator"

# Start the React application on port 8080.
npm start --port 8080
