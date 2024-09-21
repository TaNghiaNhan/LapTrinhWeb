<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.resetbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.resetbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>

</head>
<body>
  <!-- Gửi yêu cầu đến servlet xử lý yêu cầu quên mật khẩu -->
  <form action="/SangThu2/forgotPassword" method="post">
    <div class="container">
      <h1>Forgot Password</h1>
      <p>Please enter your email to reset your password.</p>
      <hr>

      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" id="email" required>
      <hr>

      <button type="submit" class="resetbtn">Reset Password</button>
    </div>

    <div class="container signin">
      <span>Remember your password? <a href="login.jsp">Sign in</a></span>
    </div>
  </form>

  <script>
    // Kiểm tra nếu có password trong request thì hiển thị alert
    <%
      String password = (String) request.getAttribute("password");
      if (password != null) {
    %>
      alert("Your account password is: <%= password %>");
    <% } else if (request.getAttribute("errorMessage") != null) { %>
      alert("<%= request.getAttribute("errorMessage") %>");
    <% } %>
  </script>
</body>
</html>
