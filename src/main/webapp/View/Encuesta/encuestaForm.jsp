<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/head.jsp" %>
<c:choose>
    <c:when test = "${empty sessionScope['usuarioSession']}">
            <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded" />
    </c:when>
</c:choose>
<body class="bg-gray-100 font-family-karla flex">
<%@ include file="../../Common/navigation.jsp" %>
<div class="w-full flex flex-col h-screen overflow-y-hidden">
    <%@ include file="../../Common/header.jspf" %>
    <!--Starts-->
    <div class="w-full flex justify-center items-center">
        <!-- Did get the path-->
        <c:if test="${encuesta != null}">
        <form action="actualizarEncuesta" method="post"
              class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
            </c:if>
            <!--Didn't get the path-->
            <c:if test="${encuesta == null}">
            <form action="insertarEncuesta" method="post"
                  class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
                </c:if>

                <h2>
                    <!-- Didn't get the path-->
                    <c:if test="${encuesta != null}">
                        Ver y Editar Encuesta
                    </c:if>
                    <!-- Didn get the path-->
                    <c:if test="${encuesta == null}">
                        Agregar Encuesta
                    </c:if>
                </h2>

                <div class="grid grid-cols-2 gap-6">
                    <div>
                        <div class="">
                            <c:if test="${encuesta != null}">
                                <label class="" for="idencuesta" hidden>
                                </label>
                                <input class=""
                                       name="idencuesta"
                                       value="<c:out value='${encuesta.getIdencuesta()}' />"
                                       type="text" placeholder="ID" hidden>
                            </c:if>
                        </div>

                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2" for="nombre">
                                Nombre
                            </label>
                            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                   name="nombre"
                                   value="<c:out value='${encuesta.getNombre()}' />"
                                   type="text" placeholder="" required="required"
                            <c:if test="${!empty encuesta && sessionScope['usuarioSession'].isAdmin() == false}">
                                   disabled
                            </c:if>
                            >

                        </div>

                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2" for="genero">
                                Genero
                            </label>
                            <c:forEach items="${generos}" var="genero">
                                <ul class="items-center w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 sm:flex dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                                    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
                                        <div class="flex items-center pl-3">
                                            <input id="horizontal-list-radio-license" type="radio"
                                                   value="${genero}" name="genero"
                                                   class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500"
                                                   required
                                            <c:if test="${genero == encuesta.getSexo()}">
                                                   checked
                                            </c:if>
                                            <c:if test="${!empty encuesta && sessionScope['usuarioSession'].isAdmin() == false}">
                                                   disabled
                                            </c:if>
                                            >
                                            <label for="horizontal-list-radio-license"
                                                   class="py-3 ml-2 w-full text-sm font-medium text-gray-900 dark:text-gray-300">${genero} </label>
                                        </div>
                                    </li>
                                </ul>
                            </c:forEach>
                        </div>

                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2" for="deporte">
                                Deportes
                            </label>
                            <c:forEach items="${deportes}" var="deporte">
                                <ul class="items-center w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 sm:flex dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                                    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
                                        <div class="flex items-center pl-3">
                                            <input id="horizontal-list-radio-license" type="radio"
                                                   value="${deporte}" name="deporte"
                                                   class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500"
                                                   required
                                            <c:if test="${deporte == encuesta.getDeporte()}">
                                                   checked
                                            </c:if>
                                            <c:if test="${!empty encuesta && sessionScope['usuarioSession'].isAdmin() == false}">
                                                   disabled
                                            </c:if>
                                            >
                                            <label for="horizontal-list-radio-license"
                                                   class="py-3 ml-2 w-full text-sm font-medium text-gray-900 dark:text-gray-300">${deporte} </label>
                                        </div>
                                    </li>
                                </ul>
                            </c:forEach>
                        </div>
                    </div>

                    <div>
                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2" for="nivel">
                                Nivel de estudios
                            </label>
                            <select name="nivel"
                                    class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                    required>
                                <option value="">-- Selecione nivel de estudios--</option>
                                <c:forEach items="${niveles}" var="nivel">
                                    <option value="${nivel}"
                                            <c:if test="${nivel == encuesta.getNivelestudio()}">
                                                selected
                                            </c:if>
                                            <c:if test="${!empty encuesta && sessionScope['usuarioSession'].isAdmin() == false}">
                                                disabled
                                            </c:if>
                                    >${nivel}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2" for="tema">
                                Temas
                            </label>
                            <c:forEach items="${temas}" var="tema">
                                <ul class="items-center w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 sm:flex dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                                    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
                                        <div class="flex items-center pl-3">
                                            <input id="horizontal-list-radio-license" type="radio"
                                                   value="${tema}" name="tema"
                                                   class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500"
                                                   required
                                            <c:if test="${tema == encuesta.getTemafavorito()}">
                                                   checked
                                            </c:if>
                                            <c:if test="${!empty encuesta && sessionScope['usuarioSession'].isAdmin() == false}">
                                                   disabled
                                            </c:if>
                                            >
                                            <label for="horizontal-list-radio-license"
                                                   class="py-3 ml-2 w-full text-sm font-medium text-gray-900 dark:text-gray-300">${tema} </label>
                                        </div>
                                    </li>
                                </ul>
                            </c:forEach>
                        </div>
                    </div>
                    <c:if test="${empty encuesta || sessionScope['usuarioSession'].isAdmin() == true}">
                        <div class="flex items-center justify-between">
                            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                    type="submit">
                                Guardar
                            </button>
                        </div>
                    </c:if>
                </div>

            </form>
    </div>
    <!--End-->
</div>
</body>