<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row" id="accountbar">
    <div class="col-md-12">
        <p class="text align-left">
            <c:choose>
                <c:when test="${not empty username}">
                    Welcome, <c:out value="${username}"/>! <a href="<c:url value="/logout" />">注销</a> | <a
                        href="<c:url value="/newpost" />">新文章</a>
                </c:when>
                <c:otherwise>
                    Have something to say? <a href="<c:url value="/login" />">登录</a> | <a
                        href="<c:url value="/signup" />">注册</a>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
</div>
<!-- 使用<c:url value="/signup" />可以将param重写进url -->
<div class="row" id="title">
    <div class="col-md-12">
        <div class="page-header">
            <h1><a href="<c:url value="/" />">EasyBlog</a></h1>
        </div>
    </div>
</div>