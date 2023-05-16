# NeoflexProject
The test task for Neoflex is a project that calculates the amount of vacation pay. It is need 3 parameters: BigDecimal salary, String startDate (In format "yyyy-mm-dd") and String endDate (In format "yyyy-mm-dd") 

For use this project you can use simple URL with some data, for example:

http://localhost:8080/calculate?salary=30000&startDate=2023-05-16&endDate=2023-06-16

*This link has 3 parametrs (salary=30000 ; startDate=2023-05-16 ; endDate=2023-06-16)

![image](https://github.com/Gyrf921/NeoflexProject/assets/56046587/a66e7f4e-4b3b-41b9-adf9-10da60a6c3d9)

Or use Swagger URL:
http://localhost:8080/swagger-ui/index.html
* startDate and endDate should be in the format "yyyy-mm-dd", for example "2023-05-15"
** If you try to use a different format, you will not be able to get the correct result

![image](https://github.com/Gyrf921/NeoflexProject/assets/56046587/a19e36f9-acbc-4de3-9adb-83d8bcb635de)


Percentage of test coverage 100%:

![image](https://github.com/Gyrf921/NeoflexProject/assets/56046587/b12e6a54-2e06-47d8-8a62-7eb830bdb2d8)

![image](https://github.com/Gyrf921/NeoflexProject/assets/56046587/09bdccfc-89c5-4570-908f-9ca81900102e)

*There is one testing method in the project that verifies the correctness of the calculation of vacation pay



