@echo off

set APP_DIR=%cd%

cd "%APP_DIR%"
./gradlew bootrun

REM Start the React application.
cd "%APP_DIR%\frontend\token-generator"
npm start --port 8080


