<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<nav aria-label="page navigation">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="javascript:paging(${paging.first})" aria-label="First page">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">First</span>
            </a>
        </li>
         <c:forEach var ="index" begin ="${paging.from}" end ="${paging.to}">
            <c:if test="${index != paging.currentPage}">
                <li class="page-item"><a class="page-link" href="javascript:paging(${index})">${index}</a></li>
            </c:if>
            <c:if test="${index == paging.currentPage}">
                <li class="page-item active"><a class="page-link" href="javascript:paging(${index})">${index}</a></li>
            </c:if>
        </c:forEach>
        <li class="page-item">
            <a class="page-link" href="javascript:paging(${paging.last})" aria-label="Last">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Last</span>
            </a>
        </li>
    </ul>
</nav>