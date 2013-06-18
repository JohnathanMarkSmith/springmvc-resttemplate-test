<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href='http://fonts.googleapis.com/css?family=Finger+Paint' rel='stylesheet' type='text/css'>

<style>
    h2 {
        font-family: 'Finger Paint', cursive;
    }

    p {
        font-family: 'Finger Paint', cursive;
    }
</style>

<body>
<h2>Hello World Page from Spring MVC Controller!!</h2>

<p>
    Thanks for clicking on the link and making the controller do some work.....

<p>
    This Example was created by <b>${user}</b>
</p>
<b><i><a href="http://www.JohnathanMarkSmith.com">http://www.JohnathanMarkSmith.com</a></i></b>

</body>
</html>
