<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>StudentDB+</title>
</head>


<body>

<!--  This is the page that the user sees-->

<h1>Awesome HS Student Directory</h1>
<h3>"Where 10 is always 2"</h3>

<form method = "post" action = "details">

  <label for="sid">Student ID:</label><br>
  <input type="text" id="sid" name="sid"><br>
  <label for="gid">Grade Level:</label><br>
  <input type="text" id="gid" name="gid"><br>
  <label for="fname">Student First Name:</label><br>
  <input type="text" id="fname" name="fname"><br>
  <label for="lname">Student Last Name:</label><br>
  <input type="text" id="lname" name="lname"><br><br>
  <input type = "submit" value = "Enter Data">
  
</form>


</body>
</html>


<!-- localhost:8080/home -->