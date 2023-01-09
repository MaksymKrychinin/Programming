<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${list!=null}"><div class="book-container">
    <c:forEach items="${list}" var="author">
        <div class="author">
            <p>Author: ${author.author}</p>
            <div class="book">
                <c:forEach items="${author.bookList}" var="book">
                    <p>Book Name: ${book.nameOfBook}</p>
                    <p>HashTags: ${book.keyWords}</p>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</div>
    ${list=null}
</c:if>