<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.java.Calculator, main.java.ResultDAO" %>
<% Object fileid = request.getParameter("calc_expr"); %>
<% if (fileid == null) { %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html>
              <head>
                  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
                  <link href="./css/style.css" rel="stylesheet">
                  <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
                  <script src="./js/costume.js"></script>
                  <title>HW_WebCalc</title>
              </head>
              <body>
                   <form action='' class="form">
                   <a id="history">История операций</a>
                   <ul>
                   <li>
                       <label for="calc_expr">Он-лайн калькулятор</label>
                       <input id="input_field" type="text" name="calc_expr" maxlength="100">
                       <span id="help">Введите формулу в данном поле </span>
                   </li>
      			 <li id="history_view">
      			 </li>
      			 <li>
                       <input type="submit" value="Рассчитать" >
                   </li>
      			 </ul>
                   </form>

              </body>
            </html>
<% } else if ("history".equals(String.valueOf(fileid))){ %>
<%= new ResultDAO("jdbc:postgresql://127.0.0.1:5432/webcalc", "root", "12345").getResults() %>
<% } else { %>
<%= new Calculator(new String().valueOf(fileid)).getResult() %>
<% } %>