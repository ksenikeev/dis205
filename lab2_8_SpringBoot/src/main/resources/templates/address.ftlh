<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
        <h2>Результаты поиска</h2>
        <form action="/address" method="post">
            <div>
                name: <input id="name" type="text" name="name" value="${name}"/>
            </div>
            <input id="page" type="hidden" name="page" value="1"/>
            <div>
                <input type="submit" value="Найти">
            </div>
        </form>

        <div>
            <#list lst as address>
                <div>
                    - ${address.fullpath}
                </div>
            </#list>
        </div>


        <div>
            <#list 1..3 as x>
                <span><a id="link_${x}" href="#" onclick="find(${x})">${x}</a></span>
            </#list>
        </div>


        <script>
            function find(page) {
                let url='/address?page=' + page + '&name=' + document.getElementById("name").value;
                document.getElementById("link_" + page).href = url;
            }
        </script>
</body>
</html>