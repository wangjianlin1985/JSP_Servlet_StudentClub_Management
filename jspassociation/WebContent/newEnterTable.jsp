<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/7/16
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<html>
<head>
    <title>新建报名表</title>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/bootstrap.css"  rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>
<!--<div class="container">-->


<!--<div class="col-md-6">-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3>新建报名表</h3>
        <small>请勾选您需要的条目</small>
    </div>

    <div class="panel-body">
        <form action="createEnter">
            <%--<div class="form-group">--%>
                <%--<label for="desc">社团介绍</label>--%>
                <%--<textarea name="content" class="form-control" rows="3" maxlength="400" placeholder="请输入社团介绍，不超过400字" id="desc"></textarea>--%>
            <%--</div>--%>

            <div class="checkbox">
                <label>
                    <input name="need" type="checkbox" id="name" value="0">姓名
                </label>
            </div>

            <div class="checkbox">
                <label>
                    <input  name="need"type="checkbox" id="sex" value="1">性别
                </label>
            </div>

            <div class="checkbox">
                <label>
                    <input readonly="readonly" name="need" type="checkbox" id="grade" value="2" checked>年级
                </label>
            </div>

            <div class="checkbox">
                <label>
                    <input  name="need"type="checkbox" id="QQ" value="3">QQ号
                </label>
            </div>

            <div class="checkbox">
                <label>
                    <input  name="need"type="checkbox" id="tele" value="4"> 手机号
                </label>
            </div>

            <div class="checkbox">
                <label>
                    <input  name="need"type="checkbox" id="email" value="5">邮箱
                </label>
            </div>
                <input  name="rec_id"type="hidden"  value=<%=request.getParameter("rec_id")%>>
                <%System.out.println("ssssss"+request.getParameter("rec_id"));%>
                <input  name="org_id"type="hidden"  value=<%=request.getParameter("org_id")%>>
            <input type="submit" class="btn btn-primary"></input>
            <!--<button class="btn btn-primary">完成</button>-->
        </form>
    </div>
</div>

<!--<div class="row" style="margin-bottom: 20px">-->
<!--<h2>新建报名表</h2>-->
<!--<small>请勾选您需要的条目</small>-->
<!--</div>-->
<!--<div class="form-group">-->
<!--<label for="desc">社团介绍</label>-->
<!--<textarea class="form-control" rows="3" maxlength="400" placeholder="请输入社团介绍，不超过400字" id="desc"></textarea>-->
<!--</div>-->

<!--<div class="checkbox">-->
<!--<label>-->
<!--<input type="checkbox" id="name">姓名-->
<!--</label>-->
<!--</div>-->

<!--<div class="checkbox">-->
<!--<label>-->
<!--<input type="checkbox" id="sex">性别-->
<!--</label>-->
<!--</div>-->

<!--<div class="checkbox">-->
<!--<label>-->
<!--<input type="checkbox" id="grade">年级-->
<!--</label>-->
<!--</div>-->

<!--<div class="checkbox">-->
<!--<label>-->
<!--<input type="checkbox" id="QQ">QQ号-->
<!--</label>-->
<!--</div>-->

<!--<div class="checkbox">-->
<!--<label>-->
<!--<input type="checkbox" id="tele">手机号-->
<!--</label>-->
<!--</div>-->

<!--<div class="checkbox">-->
<!--<label>-->
<!--<input type="checkbox" id="email">邮箱-->
<!--</label>-->
<!--</div>-->

<!--<button class="btn btn-primary">完成</button>-->
<!--</div>-->
<!--<div class="col-md-offset-1 col-md-2">-->
<!--<div id="left-name"></div>-->
<!--<div id="left-sex"></div>-->
<!--<div id="left-QQ"></div>-->
<!--<div id="left-tele"></div>-->
<!--<div id="left-email"></div>-->
<!--</div>-->
<!--</div>-->

<!--<script>-->
<!--function checkbox_click(leftId) {-->
<!--if($(this).checked){-->
<!--$(#leftId).innerHTML=""-->
<!--}-->
<!--}-->
<!--</script>-->

</body>
</html>
