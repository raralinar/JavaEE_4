<html>
<%@ page contentType="charset=UTF-8" language="java" %>
<body>
<form action="test" method="get">
  <input type="hidden" id="myValue" name="myValue" value="">
  <button type="button" onclick="sendValue()">Отправить значение</button>
</form>
<script>
function setValue() {
  var value = "Значение из JavaScript";
  document.getElementById("myInput").value = value;
}
function sendValue() {
  var value = "12345";

  // Создание объекта XMLHttpRequest
  var xhr = new XMLHttpRequest();

  // Установка метода запроса и URL-адреса сервлета
  xhr.open("POST", "http://localhost:8088/lab4/task4/test", true);

  // Установка заголовка Content-Type
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

  // Отправка запроса с данными
  xhr.send("myValue=" + encodeURIComponent(value));
}

</script>
</body>
</html>