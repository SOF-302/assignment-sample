<%@page pageEncoding="UTF-8"%>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=""><spring:message code="common.logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="<c:url value="/"/>"><spring:message code="navigator.homepage"/></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="<c:url value="/department"/>"><spring:message code="navigator.department"/></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="<c:url value="/employee"/>"><spring:message code="navigator.employee"/></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="<c:url value="/"/>"><spring:message code="navigator.recording"/></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="<c:url value="/"/>"><spring:message code="navigator.statistic"/></a>
            </li>
        </ul>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item "><a class="nav-link" href="?lang=en">EN</a></li>
            <li class="nav-item "><a class="nav-link" href="?lang=vn">VN</a></li>
            <li class="nav-item "><a class="nav-link" href="<c:url value="/auth/logout"/>">Logout</a></li>
        </ul>
    </div>
</nav>
</div>