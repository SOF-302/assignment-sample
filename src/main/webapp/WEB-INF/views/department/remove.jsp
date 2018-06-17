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

        <h1>Department <small>Remove screen</small></h1>

        <!-- BEGIN TOP MESSAGE -->
        <div>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                 <strong>Warning!</strong> Please be sure that you want to delete this department!
            </div>
        </div>
        <div class="form-group">&nbsp;</div>
        <!-- END TOP MESSAGE -->

        <!-- BEGIN CREATE FORM -->
        <div>
            <spring:url value="/department/remove/${id}" var="formAction"></spring:url>
            <form:form action="${formAction}" method="POST" modelAttribute="departmentRemoveForm">

                <div class="form-group row">
                    <label for="code" class="col-sm-2 col-form-label"><strong>Code</strong></label>
                    <div class="col-sm-10">
                        <form:input path="code" cssClass="form-control" cssErrorClass="form-control is-invalid" readonly="true"/>
                        <div class="invalid-feedback"><form:errors path="code"/></div>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"><strong>Name</strong></label>
                    <div class="col-sm-10">
                        <form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"  readonly="true"/>
                        <div class="invalid-feedback"><form:errors path="name"></form:errors></div>
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"></label>
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Delete</button>
                        <a href="<spring:url value="/department"/>" class="btn btn-warning"><i class="fas fa-angle-left"></i> Back</a>
                    </div>
                </div>

            </form:form>
        </div>
        <!-- END CREATE FORM -->

    </div>
</body>
</html>