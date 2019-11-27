<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 李威
  Date: 2019/11/7
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jq/jquery-3.4.1.js"></script>
</head>
<body>

    <div id="div1">

    </div>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>编号</th>--%>
<%--            <th>名字</th>--%>
<%--        </tr>--%>

<%--        <c:forEach items="${pageInfo.list}" var="user">--%>
<%--            <tr>--%>
<%--                <td>${user.id}</td>--%>
<%--                <td>${user.sysUsername}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

<%--    <a href="/index?pageNum=1&pageSize=${pageInfo.pageSize}">首页</a>--%>
<%--    <a href="/index?pageNum=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">上一页</a>--%>
<%--    <a href="/index?pageNum=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">下页</a>--%>
<%--    <a href="/index?pageNum=${pageInfo.navigateLastPage}&pageSize=${pageInfo.pageSize}">尾页</a>--%>
<%--    <br>--%>
<%--    <c:forEach items="${pageInfo.navigatepageNums}" var="num">--%>
<%--        <a href="/index?pageNum=${num}&pageSize=${pageInfo.pageSize}">${num}</a>--%>
<%--    </c:forEach>--%>

    <br>
    请输入要删除的编号：<input type="text" id="id"/>
    请输入要添加的名字: <input type="text" id="name"/>
    <input type="button" value="提交事务" id="btn">
</body>

<script>
    $(function () {
        loadUser(1,3);
    })
    function loadUser(pageNum,pageSize){
        $.ajax({
            method:"get",
            url:"/index?pageNum="+pageNum+"&pageSize="+pageSize,
            dataType:"json"
        }).done(function (pageInfo) {
            var table = "<div id='div2'><table >";
            pageInfo.list.forEach(function (user) {
                table+="<tr>";
                table+="<td>"+user.id+"</td>";
                table+="<td>"+user.sysUsername+"</td>";
                table+="</tr>";
            })
            table+="</table><br>";
            table+="<input type='button' value='首页' class='bt' pageNum='1'pageSize='"+pageInfo.pageSize+"' />";
            table+="<input type='button' value='上一页' class='bt' pageNum='"+pageInfo.prePage+"'pageSize='"+pageInfo.pageSize+"' />";
            table+="<input type='button' value='下页' class='bt' pageNum='"+pageInfo.nextPage+"'pageSize='"+pageInfo.pageSize+"' />";
            table+="<input type='button' value='尾页' class='bt' pageNum='"+pageInfo.navigateLastPage+"'pageSize='"+pageInfo.pageSize+"' />";
            table+="</div>"
            $("#div2").remove();
            $("#div1").html(table);
            $(".bt").on('click',function () {
                //prop只能获取标签的固有属性
                //attr可以获取自定义属性
                loadUser($(this).attr("pageNum"),$(this).attr("pageSize"));
            })
        })
    }
    $("#btn").on('click',function () {
        var id = $("#id").val();
        var name = $("#name").val();
        $.ajax({
            method:"get",
            url:"/tx?id="+id+"&name="+name
        }).done(function () {
            alert("删除增加成功")
            loadUser(1,3);
        }).fail(function () {
            alert("删除增加失败")
        })
    })
</script>
</html>
