<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>TestApp</title>
</head>
<body>
   <h2>GET RSS Feeds<b>Enter UserID to be Deleted</b></h2>
   <form action="getTweets/" method="POST">
     <label for="tweeterID">userID</label>
     <input type="tweeterID" name="tweeterID" id="tweeterID"><br>
     <input type="submit" value="Submit">
   </form>
</body>
</html>