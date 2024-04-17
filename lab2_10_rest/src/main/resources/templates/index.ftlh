<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>

    <h2>Главная страница</h2>

    <form id="newperson">
        <input id="personid" type="hidden" name="id"/>
        <div>
            name: <input id="personname" type="text" name="name"/>
        </div>
        <div>
            birth date: <input id="birthDate" type="date" name="birthDate"/>
        </div>
        <div>
           passport: <input id="passport" type="text" name="passport"/>
        </div>
        <div>
            <input type="submit" value="Сохранить">
        </div>
    </form>

    <script>
        newperson.onsubmit = async (e) => {
            e.preventDefault();

            let response = await fetch('/person/rest/save', {
              method: 'POST',
              body: new FormData(newperson)
            });

            let result = await response.json();

            personid.value = result.id;
            personname.value = result.name;
            birthDate.value = result.birthDate;
            passport.value = result.passport;

        };
    </script>


    <div>
        <div>field 1: <input id="field1" type="text"/></div>
        <div>field 2: <input id="field2" type="text"/></div>
        <div>field 3: <input id="field3" type="text"/></div>
        <div>field 4: <input id="field4" type="text"/></div>
        <div>field 5: <input id="field5" type="text"/></div>
        <div><button onclick="send_fields()">Отправить</button></div>
    </div>

    <script>
        async function send_fields() {
            let fields = {
                field1: field1.value,
                field2: field2.value,
                field3: field3.value,
                field4: field4.value,
                field5: field5.value
            }

            let response = await fetch('/person/fields/post', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify(fields)
            });

            let result = await response.json();

        }
    </script>

</body>
</html>