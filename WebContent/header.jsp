<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!--bootstrap CSS -->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    
    <%-- jQuery --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>


	<style type="text/css">
	body {
    background-color: #f8f8f8;
	}

	.container {
	    background-color: white;
	    box-shadow: 0 0 4px 0 rgba(0, 0, 0, .2);
	}

	#accountbar {
	    border-bottom: 2px solid #9F79EE;
	    margin-top: 10px;
	}
	
	#title {
	}
	</style>
    <link href="/favicon.ico" rel="icon" type="image/x-icon"/>
</script>
    <title>${param.title}</title>
</head>