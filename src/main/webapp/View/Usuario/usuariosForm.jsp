<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/head.jsp" %>
<!--Session-->
<c:choose>
    <c:when test="${empty sessionScope['usuarioSession']}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded"/>
    </c:when>
</c:choose>
<body class="bg-gray-100 font-family-karla flex">
<%@ include file="../../Common/navigation.jsp" %>
<div class="w-full flex flex-col h-screen overflow-y-hidden">
    <%@ include file="../../Common/header.jspf" %>
    <!--Starts-->
    <div class="w-full flex justify-center items-center">
        <!-- Did get the path-->
        <form action="actualizarUsuario" method="post"
              class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
            <!--Didn't get the path-->
            <h2>
                Editar Usuarios
            </h2>
            <!--Start-->
                <!--Start First col-->
                <div class="mb-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2" for="nom_usuario">
                        Nickname
                    </label>
                    <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                           name="nickname"
                           value="${sessionScope['usuarioSession'].getNickname()}"
                           type="text" placeholder="" required="required" maxlength="30">
                </div>
                <div class="mb-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2" for="ape_usuario">
                        Clave
                    </label>
                    <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                           name="clave"
                           value="${sessionScope['usuarioSession'].getClave()}"
                           type="text" placeholder="" required="required" maxlength="30">
                </div>
                <div class="flex items-center justify-between">
                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                            type="submit">
                        Guardar
                    </button>
                </div>
        </form>
    </div>
    <!--End-->
</div>
</body>