<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${translate!=null}">
    <div>
        <p>${translate.language} </p>
        <p>${translate.languageToTranslate} </p><br>
        <p>${translate.word} </p>
        <p>${translate.wordTranslate} </p>
    </div>
    ${translate=null}
</c:if>
<c:if test="${vocabularyList!=null}">
    <div>
        <c:forEach items="${vocabularyList}" var="list">
            <div>
                <p>Word :${list.word} </p>
                <p>Info :${list.wordInfo} </p>
            </div>
        </c:forEach>
    </div>
    ${vocabularyList=null}
</c:if>