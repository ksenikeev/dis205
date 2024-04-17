<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <style>
        html{
            height: 100%;
        }
        body{
            display: flex;
            flex-direction: column;
            height: 100%;
        }
        .header{
           flex: 0 0 auto;
        }
        .main-content{
           flex: 1 0 auto;
        }
        .footer{
           flex: 0 0 auto;
           align-self:center;
        }

    </style>

    <title>Главная страница</title>
</head>
<body>
        <div class="header">
            <h2>Результаты поиска</h2>
            <form action="/address" method="post">
                <input id="page" type="hidden" name="page" value="1"/>
                <input id="name" type="text" name="name" value="${name}"/>
                <input type="submit" value="Найти">
            </form>
        </div>
        <div class="main-content">
            <div>
                <#list lst as address>
                    <div>
                        - ${address.fullpath}
                    </div>
                </#list>
            </div>
        </div>

        <div class="footer">
            <div>
                <#list pages as x>
                    <span><a id="link_${x}" href="#" onclick="find(${x})">${x}</a></span>
                </#list>
            </div>
            <div>&nbsp;</div>
        </div>

        <script>
            function find(page) {
                let url='/address?page=' + page + '&name=' + document.getElementById("name").value;
                document.getElementById("link_" + page).href = url;
            }
        </script>
</body>
</html>