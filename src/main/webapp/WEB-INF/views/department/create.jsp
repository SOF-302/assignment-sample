<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
    <%@include file="/WEB-INF/views/common/navigator.jsp"%>
    <div class="form-group">&nbsp;</div>

    <div class="container">

        <h1>Department <small>Create screen</small></h1>
        <div class="form-group">&nbsp;</div>

        <!-- BEGIN CREATE FORM -->
        <div>
            <spring:url value="/department/create" var="formAction"></spring:url>
            <form:form action="${formAction}" method="POST" modelAttribute="departmentCreateForm">

                <div class="form-group row">
                    <label for="code" class="col-sm-2 col-form-label"><strong>Code</strong></label>
                    <div class="col-sm-10">
                        <form:input path="code" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="code"/></div>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"><strong>Name</strong></label>
                    <div class="col-sm-10">
                        <form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="name"></form:errors></div>
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"></label>
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-success"><i class="far fa-save"></i> Submit</button>
                        <a href="<spring:url value="/department"/>" class="btn btn-warning"><i class="fas fa-angle-left"></i> Back</a>
                    </div>
                </div>

            </form:form>
        </div>
        <!-- END CREATE FORM -->

    </div>
</body>
</html>