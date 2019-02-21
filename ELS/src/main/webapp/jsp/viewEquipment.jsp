<%-- 
    Document   : viewEquipment
    Created on : Feb 19, 2019, 12:42:51 PM
    Author     : tylerbates
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ELS - View Equipment</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
            <h1>View Equipment</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewLeases">View Leases</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/viewEquipment">View Equipment</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewCustomers">View Customers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageLeases">Manage Leases</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageEquipment">Manage Equipment</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageCustomers">Manage Customers</a></li>
                </ul>    
            </div>
            </div>
                <div class="row">
                    <div class="col-md-12">
                        <h2>Equipment</h2>
                        <table class="table-bordered table-hover">
                            <tr>
                                <th>Make</th>
                                <th>Model</th>
                                <th>Year</th>
                                <th>VIN Number</th>
                                <th>Purchase Date</th>
                                <th>Available</th>
                                <th>Active</th>
                                <th>GPS Number</th>
                                <th>Tag Number</th>
                            </tr>
                            <c:forEach var="current" items="${equipment}">
                                <tr>
                                    <td><c:out value="${current.make}"/></td>
                                    <td><c:out value="${current.model}"/></td>
                                    <td><c:out value="${current.year}"/></td>
                                    <td><c:out value="${current.vinNum}"/></td>
                                    <td><c:out value="${current.purchaseDate}"/></td>
                                    <td><c:out value="${current.available}"/></td>
                                    <td><c:out value="${current.active}"/></td>
                                    <td><c:out value="${current.gpsNum}"/></td>
                                    <td><c:out value="${current.tagNum}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

