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

        <h1>Department <small>Create screen</small></h1>

        <!-- BEGIN CREATE FORM -->
        <div>
            <spring:url value="/department/create" var="createAction"></spring:url>
            <form:form action="${createAction}" method="POST" modelAttribute="departmentCreateForm">

                <div class="form-group row">
                    <label for="code" class="col-sm-2 col-form-label">Code</label>
                    <div class="col-sm-10">
                        <c:set var="codeHasError"><form:errors path="code"/></c:set>
                        <form:input path="code" cssClass="form-control ${not empty codeHasError ? 'is-invalid' : ''}"/>
                        <div class="invalid-feedback">${codeHasError}</div>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <c:set var="nameHasError"><form:errors path="name"/></c:set>
                        <form:input path="name" cssClass="form-control ${not empty nameHasError ? 'is-invalid' : ''}"/>
                        <div class="invalid-feedback"><form:errors path="name"></form:errors></div>
                    </div>
                </div>

                 <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        <!-- END CREATE FORM -->

    </div>
</body>
</html>