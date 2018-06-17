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

        <h1>Department <small>List screen</small></h1>

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
            <spring:url value="/department" var="listAction"></spring:url>
            <form:form modelAttribute="departmentSearchForm" method="GET" action="${listAction}" id="searchForm">
                 <form:hidden path="pn" id="pageNo"/>
                 <div class="row">
                    <div class="form-group col">
                         <label for="exampleInputEmail1">Department code: </label>
                         <form:input path="code" cssClass="form-control" cssErrorClass="is-invalid"/>
                         <div class="invalid-feedback"><form:errors path="code"/></div>
                     </div>
    
                     <div class="form-group col">
                         <label for="exampleInputEmail1">Department name: </label>
                         <form:input path="name" cssClass="form-control"/>
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
                    <a href="<spring:url value="/department/create"></spring:url>" class="btn btn-success">
                        <i class="fas fa-plus-square"></i> Create
                    </a>
                </div>
                <div class="col">
                    <div class="float-right">
                        <jsp:include page="/WEB-INF/views/common/paging.jsp">
                            <jsp:param name="paging" value="${paging}" /> 
                        </jsp:include>
                    </div>
                </div>
            </div>
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>No.</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th align="center">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${fn:length(listDepartments) > 0}">
                    <c:forEach items="${listDepartments}" var="department" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${department.code}</td>
                        <td>${department.name}</td>
                        <td align="center">
                            <a href="<spring:url value="/department/update/${department.id}"></spring:url>">
                                <font color="green" size="15"><i class="fas fa-edit"></i></font>
                            </a>
                            <a href="<spring:url value="/department/remove/${department.id}"></spring:url>">
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
                    <a href="<spring:url value="/department/create"></spring:url>" class="btn btn-success">
                        <i class="fas fa-plus-square"></i> Create
                    </a>
                </div>
                <div class="col">
                    <div class="float-right">
                        <jsp:include page="/WEB-INF/views/common/paging.jsp">
                            <jsp:param name="paging" value="${paging}" /> 
                        </jsp:include>
                    </div>
                </div>
            </div>
        </div>
        <!-- END LIST TABLE -->

    </div>
</body>
</html>