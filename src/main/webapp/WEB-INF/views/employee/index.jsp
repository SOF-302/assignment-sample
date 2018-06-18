<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
    function paging(pageNo) {
        $("#pageNo").val(pageNo);
        $("#searchForm").submit();
    }

    $(function(){

        // Clear search conditional
        $('#btnClear').click(function() {
            $("#pageNo").val('');
            $("#code").val('');
            $("#name").val('');
            $("#searchForm").submit();
        })
        
    })
</script>
</head>
<body>
    <%@include file="/WEB-INF/views/common/navigator.jsp"%>
    <div class="form-group">&nbsp;</div>

    <div class="container">

        <h1>Employee <small>List screen</small></h1>

        <!-- BEGIN TOP MESSAGE -->
        <div>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                 <strong>Holy guacamole!</strong> You should check in on some of those fields below.
                 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
            </div>
        </div>
        <!-- END TOP MESSAGE -->

        <!-- BEGIN SEARCH FORM -->
        <div>
            <spring:url value="/employee" var="listAction"></spring:url>
            <form:form modelAttribute="employeeSearchForm" method="GET" action="${listAction}" id="searchForm">
                 <form:hidden path="pn" id="pageNo"/>

                 <div class="row">
                    <div class="form-group col">
                         <label for="departmentId">Department: </label>
                         <form:select path="departmentId" cssClass="form-control" cssErrorClass="form-control is-invalid">
                            <form:option value="">--- Please select department ---</form:option>
                            <form:options items="${departments}" itemValue="id" itemLabel="name"/>
                         </form:select>
                         <div class="invalid-feedback"><form:errors path="departmentId"/></div>
                     </div>
                 </div>

                 <div class="row">
                    <div class="form-group col">
                         <label for="code">Code: </label>
                         <form:input path="code" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                         <div class="invalid-feedback"><form:errors path="code"/></div>
                     </div>
    
                     <div class="form-group col">
                         <label for="name">Name: </label>
                         <form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                         <div class="invalid-feedback"><form:errors path="name"/></div>
                     </div>
                 </div>

                 <button type="submit" class="btn btn-primary" id="btnSearch"><i class="fas fa-search"></i> Search</button>
                 <button type="reset" class="btn btn-warning" id="btnClear"><i class="fas fa-eraser"></i> Clear</button>
            </form:form>
        </div>
        <!-- END SEARCH FORM -->

        <div class="form-group">&nbsp;</div>

        <!-- BEGIN LIST TABLE -->
        <div>
            <div class="row">
                <div class="col">
                    <a href="<spring:url value="/employee/create"></spring:url>" class="btn btn-success">
                        <i class="fas fa-plus-square"></i> Create
                    </a>
                </div>
                <div class="col">
                    <jsp:include page="/WEB-INF/views/common/paging.jsp">
                        <jsp:param name="paging" value="${paging}" /> 
                    </jsp:include>
                </div>
            </div>
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>No.</th>
                        <th>Image</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th align="center">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${fn:length(listEmployees) > 0}">
                    <c:forEach items="${listEmployees}" var="employee" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${employee.photo}</td>
                        <td>${employee.code}</td>
                        <td>${employee.name}</td>
                        <td>${employee.departmentName}</td>
                        <td align="center">
                            <a href="<spring:url value="/employee/update/${employee.id}"></spring:url>">
                                <font color="green" size="15"><i class="fas fa-edit"></i></font>
                            </a>
                            <a href="<spring:url value="/employee/remove/${employee.id}"></spring:url>">
                                <font color="red" size="15"><i class="fas fa-trash-alt"></i></font>
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                    </c:if>
                </tbody>
            </table>
            <div class="row">
                <div class="col">
                    <a href="<spring:url value="/employee/create"></spring:url>" class="btn btn-success">
                        <i class="fas fa-plus-square"></i> Create
                    </a>
                </div>
                <div class="col">
                    <jsp:include page="/WEB-INF/views/common/paging.jsp">
                        <jsp:param name="paging" value="${paging}" /> 
                    </jsp:include>
                </div>
            </div>
        </div>
        <!-- END LIST TABLE -->

    </div>
</body>
</html>