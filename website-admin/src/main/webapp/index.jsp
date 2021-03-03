<%@include file="/jsp/base/pageBase.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<shiro:authenticated>
    <jsp:forward page="/system/desktop/init"></jsp:forward>
</shiro:authenticated>
<shiro:guest>
    <jsp:forward page="/www/login/init"></jsp:forward>
</shiro:guest>