<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/head.jsp" %>
<!--Session-->
<c:choose>
    <c:when test = "${sessionScope['usuarioSession'].isAdmin() == true}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded/encuesta/graficarEncuesta" />
    </c:when>
    <c:when test = "${sessionScope['usuarioSession'].isAdmin() == false}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded/encuesta/insertarEncuesta" />
    </c:when>
</c:choose>
<body class="flex flex-col items-center justify-center w-screen h-screen bg-gray-200 text-gray-700">
<h1 class="font-bold text-2xl">Encuestas App <i class="fa-solid fa-book"></i></h1>
<form class="flex flex-col bg-white rounded shadow-lg p-12 mt-12" action="../../register" method="post">
    <label class="font-semibold text-xs" for="nickname">Nickname</label>
    <input class="flex items-center h-12 px-4 w-64 bg-gray-200 mt-2 rounded focus:outline-none focus:ring-2"
           name="nickname"
           type="text">
    <label class="font-semibold text-xs mt-3" for="clave">Clave</label>
    <input class="flex items-center h-12 px-4 w-64 bg-gray-200 mt-2 rounded focus:outline-none focus:ring-2"
           name="clave"
           type="password">
    <button class="flex items-center justify-center h-12 px-6 w-64 bg-blue-600 mt-8 rounded font-semibold text-sm text-blue-100 hover:bg-blue-700">
        Registarse
    </button>
</form>
<a href="../../index.jsp"
   class="text-blue-600 hover:text-blue-700 focus:text-red-700 transition duration-200 ease-in-out">Iniciar Sesion</a>
</body>