<%--
  Created by IntelliJ IDEA.
  User: zhangqx02
  Date: 2019/10/14
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>15个常用JavaScript正则表达式</title>
    <script type="text/javascript">
        /**
         * 用户名正则，4到16位（字母，数字，下划线，减号）
         */
        function userNamePattern() {
            var uPattern =/^[a-zA-Z0-9_-]{4,16}$/;
            var userName = document.getElementById("userName").value;
            var uTest = uPattern.test(userName);
            var up = document.getElementById("userNameResult");
            up.innerHTML = uTest;
        }
        /**
         * 密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
         */
        function passWordPattern() {
            var pwPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
            var passWord = document.getElementById("passWord").value;
            var pwTest = pwPattern.test(passWord);
            var pwp = document.getElementById("passWordResult");
            pwp.innerHTML = pwTest;

        }

        /**
         * 正整数正则
         */
        function positiveNumberPattern() {
            var pnPattern = /^\d+$/;
            var positiveNumber = document.getElementById("positiveNumber").value;
            var pnTest = pnPattern.test(positiveNumber);
            var pnp = document.getElementById("positiveNumberResult");
            pnp.innerHTML = pnTest;
        }
        /**
         * 负整数正则
         */
        function negtiveNumberPattern() {
            var nnPattern = /^-\d+$/;
            var negtiveNumber = document.getElementById("negtiveNumber").value;
            var nnTest = nnPattern.test(negtiveNumber);
            var nnp = document.getElementById("negtiveNumberResult");
            nnp.innerHTML = nnTest;
        }

        /**
         * 整数正则
         */
        function integerNumberPattern() {
            var inPattern = /^-?\d+$/;
            var integerNumber = document.getElementById("integerNumber").value;
            var inTest = inPattern.test(integerNumber);
            var inp = document.getElementById("integerNumberResult");
            inp.innerHTML = inTest;
        }

        /**
         * 正数正则
         */
        function posNumberPattern() {
            /**
             * 如果我我们进行明确的规定：
             * 1.如果出现小数点，小数点前后必须有数字
             * 2.大于1的数不能以0开头
             * 3.小于1的数字只能以一个0开头
             * 4.0有两种表示方法，带小数点和不带小数点
             * /^(0|[1-9])+(\.\d+)?$/
             */
            var pnPattern = /^\d+\.?\d+$/;
            var posNumber = document.getElementById("posNumber").value;
            var pnTest = pnPattern.test(posNumber);
            var pnp = document.getElementById("posNumberResult");
            pnp.innerHTML = pnTest;
        }

        /**
         * 负数正则
         */
        function negNumberPattern() {
            var nnPattern = /^-\d+\.?\d+$/;
            var negNumber = document.getElementById("negNumber").value;
            var nnTest = nnPattern.test(negNumber);
            var nnp = document.getElementById("negNumberResult");
            nnp.innerHTML = nnTest;
        }
        /**
         * 数字正则
         */
        function numberPattern() {
            var inPattern = /^-?\d+\.?\d+$/;
            var number = document.getElementById("number").value;
            var inTest = inPattern.test(number);
            var inp = document.getElementById("numberResult");
            inp.innerHTML = inTest;
        }

        /**
         * Email正则
         */
        function emailPattern() {
            var emailPattern =/^([-A-Za-z0-9_.]+)@([-A-Za-z0-9_.]+)\.([A-Za-z]{2,4})$/;
            var email= document.getElementById("email").value;
            var emTest = emailPattern.test(email);
            var emp = document.getElementById("emailResult");
            emp.innerHTML = emTest;
        }
        /**
         * 手机号正则
         */
        function phoneNumberPattern() {
            var pmPattern =/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;
            var phoneNumber= document.getElementById("phoneNumber").value;
            var pmTest = pmPattern.test(phoneNumber);
            var pmp = document.getElementById("phoneNumberResult");
            pmp.innerHTML = pmTest;
        }
        /**
         * 身份证号正则
         */
        function IDCardPattern() {
            /**
             * 1. "^[1-9](\\d{5})"：这个正则表示了身份证号的前6位。身份证号码没有0开头的，所以第一位数字匹配1~9，后五位匹配5个数字即可
             * 2. "^"表示匹配输入字符串开始的位置。
             * 3. "(18|19|20)\d{2}":这个正则表示了身份证号的第7~10位。(18|19|20)匹配年份的开头，现在的基本没有19世纪出生的人了，但
             * 是现在还匹配了20世纪和21世纪出生的人。后面匹配了任意两个数字，构成完整的年份。所以这个正则表示了1900~2099年之间的所有年份。
             * 4. "((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)"：这个正则用来匹配第11~14位日期。
             * 4.1 ((0[1-9])|10|11|12)匹配了12个月份。
             * 4.2 (([0-2][1-9])|10|20|30|31)匹配了01~31号。这里没有对大小月和2月的日期进行处理，后面会处理。
             * 5. "(\\d{3})"：这个正则用来匹配所在地派出所的代码和性别代码。匹配随机的三位数字。如果可以获得输入号码的人的性别，可以用第
             * 17位校验输入号码者的性别是否正确。
             * 6. "(\\d|X|x)$"：这个正则用来匹配最后一个校验位。匹配0~9的任意一个数字或者字母X。"$"表示匹配输入字符串结尾的位置。
             *
             * @type {RegExp}
             */
            var IDCPattern =/^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
            var IDCard= document.getElementById("IDCard").value;
            var IDCTest = IDCPattern.test(IDCard);
            var IDCp = document.getElementById("IDCardResult");
            IDCp.innerHTML = IDCTest;
        }

        /**
         * URL正则
         */
        function URLPattern() {
            var URLPattern =/^((https?|ftp|file):\/\/)?([-\da-z.]+)\.([a-z.]{2,6})([-\/\w .]*)*\/?$/;
            var URL= document.getElementById("URL").value;
            var URLTest = URLPattern.test(URL);
            var URLp = document.getElementById("URLResult");
            URLp.innerHTML = URLTest;
        }

        /**
         * IPv4地址正则
         */
        function IPv4Pattern() {
            /**
             * IPV4地址由4个组数字组成，每组数字之间以.分隔，每组数字的取值范围是0-255。
             * IPV4必须满足以下四条规则：
             * 1、任何一个1位或2位数字，即0-99；
             * 2、任何一个以1开头的3位数字，即100-199；
             * 3、任何一个以2开头、第2位数字是0-4之间的3位数字，即200-249；
             * 4、任何一个以25开头，第3位数字在0-5之间的3位数字，即250-255。
             * @type {RegExp}
             */
            var IPv4Pattern =/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
            var IPv4= document.getElementById("IPv4").value;
            var IPv4Test = IPv4Pattern.test(IPv4);
            var IPv4p = document.getElementById("IPv4Result");
            IPv4p.innerHTML = IPv4Test;
        }

        /**
         * 十六进制颜色正则
         */
        function RGBHexPattern() {
            var RGBHexPattern =/^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$/;
            var RGBHex= document.getElementById("RGBHex").value;
            var RGBHexTest = RGBHexPattern.test(RGBHex);
            var RGBHexp = document.getElementById("RGBHexResult");
            RGBHexp.innerHTML = RGBHexTest;
        }

        /**
         * 日期正则，简单判定,未做月份及日期的判定
         */
        function date1Pattern() {
            var date1Pattern =/^\d{4}(-)\d{1,2}(-)\d{1,2}$/;
            var date1= document.getElementById("date1").value;
            var date1Test = date1Pattern.test(date1);
            var date1p = document.getElementById("date1Result");
            date1p.innerHTML = date1Test;
        }
        /**
         * 日期正则，复杂判定
         */
        function date2Pattern() {
            var date2Pattern =/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
            var date2= document.getElementById("date2").value;
            var date2Test = date2Pattern.test(date2);
            var date2p = document.getElementById("date2Result");
            date2p.innerHTML = date2Test;
        }

        /**
         * QQ号正则，5至11位
         */
        function QQPattern() {
            var QQPattern =/^[1-9]\d{4,10}/;
            var QQ = document.getElementById("QQ").value;
            var QQTest = QQPattern.test(QQ);
            var QQp = document.getElementById("QQResult");
            QQp.innerHTML = QQTest;
        }


        /**
         * 微信号正则，6至20位，以字母开头，字母，数字，减号，下划线
         */
        function wxPattern() {
            /**
             * 微信号正则，6至20位，以字母开头，字母，数字，减号，下划线
             * @type {RegExp}
             *
             */
            var wxPattern =/^[a-zA-Z]([a-zA-Z0-9_-]{5,19})$/;
            var wx = document.getElementById("wx").value;
            var wxTest = wxPattern.test(wx);
            var wxp = document.getElementById("wxResult");
            wxp.innerHTML = wxTest;
        }

        /**
         *车牌号正则
         */
        function carCardPattern() {
            var carCardPattern =/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
            var carCard = document.getElementById("carCard").value;
            var carCardTest = carCardPattern.test(carCard);
            var carCardp = document.getElementById("carCardResult");
            carCardp.innerHTML = carCardTest;
        }

        /**
         * 包含中文正则
         */
        function chinesePattern() {
            var chinesePattern =/[\u4E00-\u9FA5]/;
            var chinese = document.getElementById("chinese").value;
            var chineseTest = chinesePattern.test(chinese);
            var chinesep = document.getElementById("chineseResult");
            chinesep.innerHTML = chineseTest;
        }

    </script>
    <style>
        #container{
            margin-left: 20%;
            margin-right: 20%;
        }
        .divStyle {
            margin-bottom: 20px;
        }
        .hrStyle{
            border:1px dashed #987cb9;
            width:100%;
            color:#987cb9;
            SIZE:1px;
        }
    </style>
</head>
<body>
<div id="container">
    <div class="divStyle">
        <h3>1 用户名正则</h3>
        <p>用户名正则，4到16位（字母，数字，下划线，减号）</p>
        <input id="userName"/>
        <input type="button" value="确定" onclick="userNamePattern()"><br>
        结果:<p id="userNameResult"></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>2 密码强度正则</h3>
        <p>密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符</p>
        <input id="passWord"/>
        <input type="button" value="确定" onclick="passWordPattern()"><br>
        结果:<p id = "passWordResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <div>
            <h3>3 整数正则</h3>
            <div>
                <p>3.1 正整数</p>
                <input id="positiveNumber"/>
                <input type="button" value="确定" onclick="positiveNumberPattern()"><br>
                结果:<p id = "positiveNumberResult" ></p>
            </div>
            <br>
            <div>
                <p>3.2 负整数</p>
                <input id="negtiveNumber"/>
                <input type="button" value="确定" onclick="negtiveNumberPattern()"><br>
                结果:<p id = "negtiveNumberResult" ></p>
            </div>
            <br>
            <div>
                <p>3.3 整数</p>
                <input id="integerNumber"/>
                <input type="button" value="确定" onclick="integerNumberPattern()"><br>
                结果:<p id = "integerNumberResult" ></p>
            </div>
        </div>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <div>
            <h3>4 数字正则</h3>
            <div>
                <p>4.1 正数</p>
                <input id="posNumber"/>
                <input type="button" value="确定" onclick="posNumberPattern()"><br>
                结果:<p id = "posNumberResult" ></p>
            </div>
            <br>
            <div>
                <p>4.2 负数</p>
                <input id="negNumber"/>
                <input type="button" value="确定" onclick="negNumberPattern()"><br>
                结果:<p id = "negNumberResult" ></p>
            </div>
            <br>
            <div>
                <p>4.3 数字</p>
                <input id="number"/>
                <input type="button" value="确定" onclick="numberPattern()"><br>
                结果:<p id = "numberResult" ></p>
            </div>
        </div>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>5 Email正则</h3>
        <p>Email正则</p>
        <input id="email"/>
        <input type="button" value="确定" onclick="emailPattern()"><br>
        结果:<p id = "emailResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>6 手机号正则</h3>
        目前中国大陆三家电信运营商号段:<br>
               中国移动：134/135/136/137/138/139/150/151/152/157/159/187/188<br>
               中国联通：130/131/132/155/156/186/185<br>
               中国电信：133/153/189/180<br>
        <input id="phoneNumber"/>
        <input type="button" value="确定" onclick="phoneNumberPattern()"><br>
        结果:<p id = "phoneNumberResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>7 身份证号正则</h3>
        <p>身份证号（18位）正则</p>
        <input id="IDCard"/>
        <input type="button" value="确定" onclick="IDCardPattern()"><br>
        结果:<p id = "IDCardResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>8 URL正则</h3>
        <p>URL正则</p>
        <input id="URL"/>
        <input type="button" value="确定" onclick="URLPattern()"><br>
        结果:<p id = "URLResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>9 IPv4地址正则</h3>
        <p>IPv4地址正则</p>
        <input id="IPv4"/>
        <input type="button" value="确定" onclick="IPv4Pattern()"><br>
        结果:<p id = "IPv4Result" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>10 十六进制颜色正则</h3>
        <p>RGB Hex颜色正则</p>
        <input id="RGBHex"/>
        <input type="button" value="确定" onclick="RGBHexPattern()"><br>
        结果:<p id = "RGBHexResult" ></p>
    </div>
    <hr class="hrStyle">
    <div class="divStyle">
        <div>
            <h3>11 日期正则</h3>
            <div>
                <p>11.1 日期正则，简单判定,未做月份及日期的判定</p>
                <input id="date1"/>
                <input type="button" value="确定" onclick="date1Pattern()"><br>
                结果:<p id = "date1Result" ></p>
            </div>
            <br>
            <div>
                <p>11.2 日期正则，复杂判定</p>
                <input id="date2"/>
                <input type="button" value="确定" onclick="date2Pattern()"><br>
                结果:<p id = "date2Result" ></p>
            </div>
        </div>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>12 QQ正则</h3>
        <p>QQ号正则，5至11位</p>
        <input id="QQ"/>
        <input type="button" value="确定" onclick="QQPattern()"><br>
        结果:<p id = "QQResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>13 微信号正则</h3>
        <p>微信号正则，6至20位，以字母开头，字母，数字，减号，下划线</p>
        <input id="wx"/>
        <input type="button" value="确定" onclick="wxPattern()"><br>
        结果:<p id = "wxResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>14 车牌号正则</h3>
        <p>车牌号正则</p>
        <input id="carCard"/>
        <input type="button" value="确定" onclick="carCardPattern()"><br>
        结果:<p id = "carCardResult" ></p>
    </div>
    <hr class="hrStyle">

    <div class="divStyle">
        <h3>15 包含中文正则</h3>
        <p>包含中文的正则</p>
        <input id="chinese"/>
        <input type="button" value="确定" onclick="chinesePattern()"><br>
        结果:<p id = "chineseResult" ></p>
    </div>
</div>
</body>
</html>