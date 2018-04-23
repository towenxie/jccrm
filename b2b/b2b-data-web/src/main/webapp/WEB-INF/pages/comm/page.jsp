<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<%
    long time = System.currentTimeMillis();
    request.setAttribute("time", time);
%>

<!--footer begin-->
<div class="pages pages0 wow fadeInDown" align="center">
    <nav>
        <ul class="pagination">
            <li><a href="javascript:go2Page_${time}(1)">首页</a></li>
            <c:if test="${page.pageNo eq 1}">
                <li class="disabled"><a href="javascript:void()">上一页</a></li>
            </c:if>
            <c:if test="${page.pageNo gt 1}">
                <li><a href="javascript:go2Page_${time}(${page.pageNo-1 })">上一页</a></li>
            </c:if>
            <c:if test="${page.pageNo - 1 gt 3}">
                <li><a>...</a></li>
            </c:if>
            <c:forEach begin="1" end="${page.totalPage}" var="pageNo">
                <c:if test="${page.pageNo-pageNo le 3&&page.pageNo-pageNo ge -3}">
                    <li class="${page.pageNo eq pageNo?'active':'' }"><a href="javascript:go2Page_${time}(${pageNo});">${pageNo}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${page.totalPage - page.pageNo gt 3}">
                <li><a>...</a></li>
            </c:if>
            <c:if test="${page.pageNo eq page.totalPage}">
                <li class="disabled"><a href="javascript:void()">下一页</a></li>
            </c:if>
            <c:if test="${page.pageNo lt page.totalPage}">
                <li><a href="javascript:go2Page_${time}(${page.pageNo+1 })">下一页</a></li>
            </c:if>
            <li><a href="javascript: go2Page_${time}(${page.totalPage})">尾页</a></li>
            <li class="page-text"><a href="javascript:()">共${page.totalRecord}条记录</a></li>
            <style>
                .pagination> .page-text a{color:#777;}
                .pagination> .page-text a:hover{background: none;color:#777;}
                .pagination> .page-text a:focus{background: none;color:#777;}
            </style>

        </ul>
    </nav>
</div>
<!--footer end-->
<div class="clear"></div>
<script type="text/javascript">
    function go2Page_${time}(pageNo) {
        console.info(pageNo + "===")
        if (pageNo == undefined || pageNo == null || pageNo == "") {
            pageNo = 1;
        }
        if (isNaN(pageNo)) {
            alert("请输入数字");
            return;
        }
        if (pageNo <= 0) {
            alert('数字非法，请输入大于0的整数');
            $("#pn").val('');
            return;
        }
        if (pageNo > ${page.totalPage}) {
            alert("页码无效");
            return;
        }
        $("#pageNo").val(pageNo);

        ${not empty page.functionStr?page.functionStr:"queryResult();"}

    }
</script>