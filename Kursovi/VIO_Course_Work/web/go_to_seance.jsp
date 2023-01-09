<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Seance ${requestScope.seance.header}</title>
</head>
<body>
<p><a href="controller?action=main">Main page</a></p>

    <jstl:out value="Seance №${requestScope.seance.id}: ${requestScope.seance.header}"/>

    <jstl:if test="${not empty sessionScope.user}">
        <form method="post" action="controller?action=edit_seance">
            <input type="hidden" name="id" value="${requestScope.seance.id}"/>
            <input type="text" name="header" placeholder="New header of seance"/>
            <input type="submit" value="Edit seance`s info"/>
        </form>

        <form method="post" action="controller?action=delete_seance">
            <input type="hidden" name="id" value="${requestScope.seance.id}"/>
            <input type="submit" value="Delete this seance"/>
        </form>
    </jstl:if>

    <jstl:if test="${(not empty sessionScope.user)&&requestScope.seance.numberOfPlaces>0}">
        <jstl:out value="Place №${requestScope.seance.tickets.size()+1}"/>
        <form method="post" action="controller?action=add_ticket">
            <input type="hidden" name="id" value="${requestScope.seance.id}"/>
            <p><input type="text" name="cost" placeholder="Cost"/>
            <input type="submit" value="Add ticket"/></p>
        </form>
        <jstl:out value="---------------------------------------------------------------------"/>
    </jstl:if>

    <jstl:forEach items="${requestScope.seance.tickets}" var="ticket">

        <jstl:if test="${(not empty sessionScope.user)&&ticket.buy!=true}">
            <p><jstl:out value="Ticket for place №${ticket.number}, cost: ${ticket.cost}. "/></p>
            <form method="post" action="controller?action=edit_ticket">
                <input type="hidden" name="id" value="${requestScope.seance.id}"/>
                <input type="hidden" name="idTicket" value="${ticket.number}"/>
                <p><input type="text" name="cost" placeholder="New cost"/>
                <input type="submit" value="Edit tickets`s info"/></p>
            </form>

            <form method="post" action="controller?action=delete_ticket">
                <input type="hidden" name="id" value="${requestScope.seance.id}"/>
                <input type="hidden" name="idTicket" value="${ticket.number}"/>
                <input type="submit" value="Delete this ticket"/>
            </form>
        </jstl:if>

        <jstl:if test="${(empty sessionScope.user)&&ticket.buy!=true}">
            <p><jstl:out value="Ticket for place №${ticket.number}, cost: ${ticket.cost}. "/></p>
            <form method="post" action="controller?action=buy_ticket">
                <input type="hidden" name="id" value="${requestScope.seance.id}"/>
                <input type="hidden" name="idTicket" value="${ticket.number}"/>
                <input type="text" name="name" placeholder="Input your name"/>
                <input type="submit" value="Buy this ticket"/>
            </form>
        </jstl:if>

    </jstl:forEach>

    <jstl:forEach items="${requestScope.pTickets}" var="pTicket">
        <p><jstl:out value="Ticket №${pTicket.number} purchased by ${pTicket.userName}"/></p>
    </jstl:forEach>

</body>
</html>
