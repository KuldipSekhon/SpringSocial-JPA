<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>TestApp</title>
</head>
<body>
   <h2>GET RSS Feeds<b>Enter UserID to be Deleted</b></h2>
   <form action="feeds/RssFeed_FB" method="POST">
     <label for="userID">userID</label>
     <input type="userID" name="userID" id="userID"><br>
     <input type="submit" value="Submit">
   </form>
</body>
</html>