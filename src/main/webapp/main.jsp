<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<style>
  /* Style cho nút đăng xuất */
  .logout-btn {
    position: absolute;
    top: 10px;
    right: 10px;
    padding: 5px 10px;
    background-color: #f44336; /* Màu nền đỏ */
    color: white; /* Màu chữ trắng */
    border: none;
    border-radius: 3px;
    cursor: pointer;
    font-size: 14px;
  }

  .logout-btn:hover {
    background-color: #d32f2f; /* Màu nền đỏ đậm khi hover */
  }
</style>
</head>
<body>
  <button class="logout-btn" onclick="location.href='logout.jsp';">Đăng xuất</button>
</body>
</html>
