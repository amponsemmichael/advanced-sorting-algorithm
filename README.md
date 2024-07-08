#Sorting Algorithm Project
This project demonstrates various sorting algorithms implemented in a Jakarta Servlet web application. Users can input an array and select a sorting algorithm to see the sorted results.

#Table of Contents
Project Overview
Technologies Used
Sorting Algorithms Implemented
Setup Instructions

#Usage
Contributing
License
Project Overview
This web application allows users to input an array of numbers and select a sorting algorithm from a dropdown menu. The application will then display the sorted array.

#Technologies Used
Jakarta Servlet API
Apache Tomcat
Maven
HTML/CSS for the frontend

#Sorting Algorithms Implemented
The following sorting algorithms are available in the application:
Quick Sort
Bubble Sort
Heap Sort
Radix Sort
Selection Sort
Merge Sort
Setup Instructions
Follow these steps to set up and run the project locally:

#Clone the Repository:
sh
Copy code
git clone https://github.com/amponsemmichael/advanced-sorting-algorithm.git
cd sorting-algo
Build the Project:

sh
Copy code
mvn clean install or mvn clean package
Deploy to Apache Tomcat:

Copy the generated sorting-algorithm-1.0-SNAPSHOT.war file from the target directory to the webapps directory of your Apache Tomcat installation.
Start Apache Tomcat.
Access the Application:
Open your web browser and navigate to http://localhost:8080/sorting-algorithm-1.0-SNAPSHOT.

#Usage
Input Array: Enter a comma-separated list of numbers in the input field.
Select Sorting Algorithm: Choose a sorting algorithm from the dropdown menu.
Sort: Click the "Sort" button to see the sorted array.
Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

#License
This project is licensed under the MIT License.

