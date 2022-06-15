<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- link do meu CSS -->
    <link rel="stylesheet" href="./assets/CSS/style.css">

    <title>Health Track Login</title>

</head>

<body class="login-bg">
<div class="header-login">
    <div class="header-top-b">
        <a href="index.html" class="header-title-b"> Health Track
        </a>
    </div>
</div>

<div class="login-body">
    <div class="login-box">
        <h2>Login</h2>
        <form action="">
            <div class="input-box">
                <label for="email">Email:</label>
                <input required type="email" id="email">
                <% Object email = request.getAttribute("email");%>
            </div>
            <div class="input-box">
                <label>
                    Senha:
                    <input required type="password">
                </label>
                <% Object senha = request.getAttribute("senha");%>
            </div>
            <div>
                <button class="submit">
                    Login
                </button>
            </div>
            <div>
                <a href="cadastro.html">Não tenho cadastro</a>
            </div>
        </form>
    </div>

</div>
</body>
</html>
