md src\main\resources\static
echo timestamp=%date:~0,10% %time:~0,8% >src\main\resources\static\index.html
echo version=1.2 >>src\main\resources\static\index.html
gradlew clean build
