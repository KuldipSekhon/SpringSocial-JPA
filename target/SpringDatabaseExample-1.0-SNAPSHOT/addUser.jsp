<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>TestApp</title>
</head>
<body>
   <h2><b>Add User Details</b></h2>
   <form action="addUser/" method="POST">
     <label for="firstname">FirstName</label>
     <input type="firstname" name="firstname" id="firstname"><br>
     <label for="lastname">LastName</label>
     <input type="lastname" name="password" id="lastname" ><br>
     <label for="id">ID</label>
      <input type="id" name="id" id="id" ><br>
     <input type="submit" value="Submit">
   </form>
</body>
</html>