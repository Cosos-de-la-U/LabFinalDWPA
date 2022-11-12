<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/head.jsp" %>
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
            <!--Search stuff-->
            <form action="listarEncuesta" method="post">
                <div class="m-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2" for="categoriaJuego">
                        Fecha
                    </label>
                    <!--Select-->
                    <div class="relative">
                        <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
                            <svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="currentColor"
                                 viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M6 2a1 1 0 00-1 1v1H4a2 2 0 00-2 2v10a2 2 0 002 2h12a2 2 0 002-2V6a2 2 0 00-2-2h-1V3a1 1 0 10-2 0v1H7V3a1 1 0 00-1-1zm0 5a1 1 0 000 2h8a1 1 0 100-2H6z"
                                      clip-rule="evenodd"></path>
                            </svg>
                        </div>
                        <input datepicker type="text" name="fecha" datepicker-format="yyyy-mm-dd"
                               class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                               placeholder="Escoja una fecha">
                    </div>
                    <div class="">
                        <button class="mt-3 bg-blue-500 p-1 items-center rounded text-white">
                            Buscar <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </div>
                </div>
            </form>
            <!--Search stuff-->
            <table id="dataTable" class="table w-full text-sm text-left text-gray-500 dark:text-green-400">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="py-5 px-6">
                        Nombre
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Genero
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Deporte
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Temas
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Estudio
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Fecha
                    </th>
                    <th scope="col" class="py-5 px-6">
                        Hora
                    </th>
                    <th scope="col" class="py-5 px-6">
                    </th>
                    <th scope="col" class="py-5 px-6">
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="encuesta" items="${listaEncuesta}">
                    <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getNombre()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getSexo()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getDeporte()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getTemafavorito()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getNivelestudio()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getFecha()}"/>
                        </td>
                        <td class="py-5 px-20">
                            <c:out value="${encuesta.getHora()}"/>
                        </td>
                        <td class="py-5 px-6">
                            <a href="borrarEncuesta?idencuesta=<c:out value='${encuesta.getIdencuesta()}' />">
                                <i class="fa-solid fa-trash" style="color: red"></i>
                            </a>
                        </td>
                        <td class="py-5 px-6">
                            <a href="editarEncuesta?idencuesta=<c:out value='${encuesta.getIdencuesta()}' />">
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