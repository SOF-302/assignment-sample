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
            <form action='<spring:url value="/department"></spring:url>' method="get">
                 <div class="row">
                    <div class="form-group col">
                         <label for="exampleInputEmail1">Department code: </label>
                         <input type="text" class="form-control" id="code" name="code" placeholder="ABC12345">
                     </div>
    
                     <div class="form-group col">
                         <label for="exampleInputEmail1">Department name: </label>
                         <input type="text" class="form-control" id="name" name="code" placeholder="Acounting">
                     </div>
                 </div>

                 <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
        <!-- END SEARCH FORM -->

        <!-- BEGIN LIST TABLE -->
        <div>
            <div class="row">
                <div class="col">
                    <a href="<spring:url value="/department/create"></spring:url>"><i class="fas fa-plus-square"></i>Create</a>
                </div>
                <div class="col">
                    <div class="pull-right">
                        <nav aria-label="Page navigation" class="pull-right">
                          <ul class="pagination">
                            <li class="page-item">
                              <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                              </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                              <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                              </a>
                            </li>
                          </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${fn:length(listDepartments) > 0}">
                    <c:forEach items="${listDepartments}" var="department" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${department.code}</td>
                        <td>${department.name}</td>
                        <td>
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
        </div>
        <!-- END LIST TABLE -->

    </div>
</body>
</html>