<%-- 
    Document   : viewCustomers
    Created on : Feb 19, 2019, 12:47:43 PM
    Author     : tylerbates
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ELS - Manage Customers</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
            <h1>Manage Customers</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewLeases">View Leases</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewEquipment">View Equipment</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/viewCustomers">View Customers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageLeases">Manage Leases</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageEquipment">Manage Equipment</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageCustomers">Manage Customers</a></li>
                </ul>    
            </div>
            </div>
                <div class="row">
                    <div class="col-md-12">
                        <h2>Current Customers</h2>
                        <table class="table-bordered table-hover">
                            <tr>
                                <th>Name</th>
                                <th>Address</th>
                                <th>City</th>
                                <th>State</th>
                                <th>ZIP</th>
                                <th>Insurance Carrier</th>
                                <th>Policy Number</th>
                                <th>Policy Expiration</th>
                            </tr>
                            <c:forEach var="current" items="${customers}">
                                <tr>
                                    <td><c:out value="${current.name}"/></td>
                                    <td><c:out value="${current.address}"/></td>
                                    <td><c:out value="${current.city}"/></td>
                                    <td><c:out value="${current.state}"/></td>
                                    <td><c:out value="${current.zip}"/></td>
                                    <td><c:out value="${current.insurance}"/></td>
                                    <td><c:out value="${current.policyNum}"/></td>
                                    <td><c:out value="${current.policyExp}"/></td>
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