<html>
	<head>
		<title>Hello Twitter</title>
	</head>
	<body>
		<h3>Hello, <span th:text="${twitterProfile.name}">Some User</span>!</h3>

		<h4>These are your friends:</h4>${friend_1_name} with profile url ${fiend_1}
		<b>Screen Name before tweet<b>    ${screen_name_before}
		<b>Screen Name After tweet<b>     ${screen_name_after}

		<b>Tweet message. from............<b>     ${tweet_from}

		<ul>
			<li th:each="friend:${friends}" th:text="${friend.name}">Friend</li>
		</ul>
	</body>
</html>