<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/head.jsp" %>
<!--Session-->
<c:choose>
    <c:when test="${empty sessionScope['usuarioSession']}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded"/>
    </c:when>
    <c:when test="${sessionScope['usuarioSession'].isAdmin() == false}">
        <c:redirect url="http://localhost:8080/laboratorioFinal_war_exploded/encuesta/insertarEncuesta"/>
    </c:when>
</c:choose>
<body class="bg-gray-100 font-family-karla flex">
<%@ include file="../../Common/navigation.jsp" %>
<div class="w-full flex flex-col h-screen overflow-y-hidden">
    <%@ include file="../../Common/header.jspf" %>
    <div class="w-full mt-4 flex justify-center items-center">
        <div class="overflow-x-auto relative">

            <div class="grid grid-cols-2 gap-2">
                <div>
                    <canvas id="pie-chart-genero" width="800" height="450"></canvas>
                </div>
                <div>
                    <canvas id="pie-chart-deportes" width="800" height="450"></canvas>
                </div>
            </div>

            <script>
                new Chart(document.getElementById("pie-chart-genero"), {
                    type: 'doughnut',
                    data: {
                        labels: ["Femenino", "Masculino"],
                        datasets: [{
                            label: "Generos encuesta",
                            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                            data: [<c:out value="${datosGenero.getFemenino()}"/>, <c:out value="${datosGenero.getMasculino()}"/>]
                        }]
                    },
                    options: {
                        title: {
                            display: true,
                            text: 'Generos de la encuesta'
                        }
                    }
                });


                new Chart(document.getElementById("pie-chart-deportes"), {
                    type: 'doughnut',
                    data: {
                        labels: ["Futbol", "Basketball", "Jockey", "Baseball", "Golf"],
                        datasets: [{
                            label: "Deportes encuesta",
                            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                            data: [<c:out value="${datosDeportes.getFutbol()}"/>,
                                <c:out value="${datosDeportes.getBasketball()}"/>,
                                <c:out value="${datosDeportes.getJockey()}"/>,
                                <c:out value="${datosDeportes.getBaseball()}"/>,
                                <c:out value="${datosDeportes.getGolf()}"/>
                            ]
                        }]
                    },
                    options: {
                        title: {
                            display: true,
                            text: 'Deportes de la encuesta'
                        }
                    }
                });
            </script>

            <script>
                $(document).ready(function () {
                    $('#dataTable').DataTable({
                        "lengthChange": false
                    });
                });
            </script>
        </div>
    </div>
</div>
</body>
<html/>