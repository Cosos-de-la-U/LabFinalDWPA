<c:if test = "${!empty sessionScope['usuarioSession']  && sessionScope['usuarioSession'].isAdmin() == true}">
    <%@ include file="Admin/adminAside.jspf" %>
</c:if>
<c:if test = "${!empty sessionScope['usuarioSession']  && sessionScope['usuarioSession'].isAdmin() == false}">
    <%@ include file="User/userAside.jspf" %>
</c:if>