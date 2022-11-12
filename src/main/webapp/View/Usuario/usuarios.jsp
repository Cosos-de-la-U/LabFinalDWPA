<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/head.jsp" %>
<!--Session-->
<c:choose>
    <c:when test = "${empty sessionScope['usuarioSession']}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded" />
    </c:when>
    <c:when test = "${sessionScope['usuarioSession'].isAdmin() == false}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded/encuesta/insertarEncuesta" />
    </c:when>
</c:choose>
<body class="bg-gray-100 font-family-karla flex">
<%@ include file="../../Common/navigation.jsp" %>
<div class="w-full flex flex-col h-screen overflow-y-hidden">
    <%@ include file="../../Common/header.jspf" %>
    <div class="w-full mt-4 flex justify-center items-center">
        <div class="overflow-x-auto relative">
            </button>
            <table id="dataTable" class="table w-full text-sm text-left text-gray-500 dark:text-green-400">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="py-5 px-6">
                        Nickname
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Clave
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Admin
                    </th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="usuarios" items="${listaUsuario}">
                    <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                        <td class="py-5 px-20">
                            <c:out value="${usuarios.getNickname()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${usuarios.getClave()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${usuarios.isAdmin()}"/>
                        </td>
                        <td class="py-5 px-6">
                            <a href="borrarUsuarios?carnet=<c:out value='${usuarios.getIdusuario()}' />">
                                <i class="fa-solid fa-trash" style="color: red"></i>
                            </a>
                        </td>
                        <td class="py-5 px-6">
                            <a href="editarUsuarios?carnet=<c:out value='${usuarios.getIdusuario()}' />">
                                <i class="fa-solid fa-file-pen" style="color: #F7BD02"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('#dataTable').DataTable({
                "lengthChange": false
            });
        });
    </script>
</div>
</body>
<html/>