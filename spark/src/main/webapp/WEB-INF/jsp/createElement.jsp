<%--
  Created by IntelliJ IDEA.
  User: zhangqx02
  Date: 2019/8/13
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面创建子节点</title>

    　　<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<div>
    <div id="father" style="height: 200px;width: 400px;">
        <p id="p1">node1</p>
        <p id="p2">node2</p>
    </div>
    <button id='append'>appendChild</button>
    <button id='insert'>insertChild</button>
</div>


<script type="text/javascript">
    $(document).ready(function(){
        $("#append").on('click',function(){
            appendChild();
        });
        $('#insert').on('click',function(){
            insertChildMethod();
        });
    });
    function appendChild(){
        var father = document.getElementById("father");
        var child = document.createElement('p');
        child.innerHTML = "This is a test";
        father.appendChild(child);
    }

    function insertChildMethod(){
        var father = document.getElementById("father");
        var refChild = document.getElementById('p1');
        var child = document.createElement('p');
        child.innerHTML='This is a insert child';
        father.insertBefore(child,refChild.nextSibling);

    }




</script>
</body>
</html>