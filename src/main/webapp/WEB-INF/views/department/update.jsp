<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
    <%@include file="/WEB-INF/views/common/navigator.jsp"%>

    <div class="container">

        <h1>Department <small>Update screen</small></h1>

        <!-- BEGIN CREATE FORM -->
        <div>
            <spring:url value="/department/update" var="updateAction"></spring:url>
            <form:form action="${updateAction}" method="POST" modelAttribute="departmentUpdateForm">
                <form:hidden path="id"/>

                <div class="form-group row">
                    <label for="code" class="col-sm-2 col-form-label">Code</label>
                    <div class="col-sm-10">
                        <form:input path="code" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <form:input path="name" cssClass="form-control"/>
                    </div>
                </div>

                 <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
        <!-- END CREATE FORM -->

    </div>
</body>
</html>