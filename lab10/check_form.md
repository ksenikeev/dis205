# Проверка формы на корректность данных

0. Отключение проверки
```html
<form ... novalidate> ... </form>
```

1. Проверка заполнения обязательных полей браузером
```html
Param1<span style="color:red">*</span>: <input type="text" name="param1" required>
```
2. Проверка браузером соответствие вводимого значения шаблону (регулярное выражение)
```html
<input type="text" name="phone" required pattern="(8|(\+7))[0-9]{10}">
```
3. Проверка браузером ограничений на значения
```html
maxlength="350" // type= textarea, password, url, tel, text, search
min="2" // type = date, time, week, range, number, month
max="23"
step = "2" // допустимый шаг в интервале
```
4. Проверка JS отдельного поля
```html
<input name="comment" oninput="validateComment(this)">

<script type="text/javascript">
function validateComment(this) {
    if (input.value.length < 20) {
        // необходимо вызвать setCustomValidity с сообщением об ошибке 
        input.setCustomValidity("Слишком короткий комментарий, маловато будет");   
    }
    else {
        // очищаем сообщение об ошибке
        input.setCustomValidity("");
    }
}
</script>
```
5. Проверка JS формы
```html
<form ... onsubmit="return validate()"> ... </form>
<script type="text/javascript">
    function validate() {
        if (true)// при успешной проверке
        return true;
        if (false)// при ошибках
        return false;
    }
</script>
```