<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="order" scope="request" class="useBean.cart.ProductOrder" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
</script>
</head>
<style type="text/css">
button#button21 {
    margin-top:20;
    float:right;
    line-height:3;
    position:relative;
    color:crimson;
}
</style>
</head>
<body>
  订单id      :           <span id="id"><%=order.getId()%></span><br>
   名称                    :           <span id="name"><%=order.getName() %></span><br>
   建立时间          :       <span id="password" ><%=order.getStart() %></span><br>
  书id                     :       <span id="password" ><%=order.getBookId() %></span><br>
  数量          :       <span id="password" ><%=order.getCount() %></span><br>
   建立的用户id:       <span id="password" ><%=order.getUserId() %></span><br>
   现在状态          :       <span id="password" ><%=order.getOrderStatus() %></span><br>
 
   <br>
   
</body>
</html>