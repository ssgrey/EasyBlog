<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp">
    <c:param name="title" value="新文章"></c:param>
</c:import>

<body>

<div class="container">

    <c:import url="accountbar.jsp"></c:import>

    <div class="row">

        <div class="col-md-12">
            <%--Error message--%>
            <c:if test="${not empty error_message}">
                <div class="alert alert-danger" role="alert">
                    <p>${requestScope.error_message}</p>
                </div>
            </c:if>

            <form role="form" method="post">
                <div class="form-group">
                    <label for="inputTitle">标题:</label>
                    <input type="text" class="form-control" id="inputTitle" name="title" value="${title}">
                </div>
                <div class="form-group">
                    <label for="inputBody">内容:</label>
                    <textarea class="form-control" id="inputBody" name="body" rows="10"></textarea>
                </div>
                <div class="form-group">
                    <label for="inputTags">标签:</label>

                    <p class="help-block">请用逗号分隔</p>
                    <input type="text" class="form-control" id="inputTags" name="tags" value="${tags}">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
