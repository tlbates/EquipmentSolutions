<%-- 
    Document   : manageCustomers
    Created on : Feb 18, 2019, 12:10:08 PM
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewCustomers">View Customers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageLeases">Manage Leases</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/manageEquipment">Manage Equipment</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/manageCustomers">Manage Customers</a></li>
                </ul>    
            </div>
            </div>
                <div class="row">
                    <div class="col-md-6">
                        <h2>Current Customers</h2>
                        <table class="table-bordered table-hover">
                            <tr>
                                <th>Name</th>
                                <th>City</th>
                                <th>State</th>
                            </tr>
                            <c:forEach var="current" items="${customers}">
                                <tr>
                                    <td><c:out value="${current.name}"/></td>
                                    <td><c:out value="${current.city}"/></td>
                                    <td><c:out value="${current.state}"/></td>
                                    <td><a href="customerToEdit?idCustomer=${current.idCustomer}">
                                            Edit
                                        </a>
                                    </td>
                                    <td><a href="deleteCustomer?idCustomer=${current.idCustomer}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col-md-6">
                        <form class="form-horizontal" 
                                  role="form" method="POST" 
                                  action="addCustomer">
                            <div class="form-group">
                                <label for="name">Name: </label>
                                <input type="text" class="form-control" name="name" placeholder="Name" required/>
                            </div>
                            <div class="form-group">
                                <label for="address">Address: </label>
                                <input type="text" class="form-control" name="address" placeholder="Address" required/>
                            </div>
                            <div class="form-group">
                                <label for="city">City: </label>
                                <input type="text" class="form-control" name="city" placeholder="City" required/>
                            </div>
                            <div class="form-group">
                                <label for="state">State: </label>
                                <input type="text" class="form-control" name="state" placeholder="State" required/>
                            </div>
                            <div class="form-group">
                                <label for="zip">ZIP: </label>
                                <input type="text" class="form-control" name="zip" placeholder="ZIP" required/>
                            </div>
                            <div class="form-group">
                                <label for="insurance">Insurance Carrier: </label>
                                <input type="text" class="form-control" name="insurance" placeholder="Insurance Carrier" required/>
                            </div>
                            <div class="form-group">
                                <label for="policyNum">Policy Number: </label>
                                <input type="text" class="form-control" name="policyNum" placeholder="Policy No." required/>
                            </div>
                            <div class="form-group">
                                <label for="policyExp">Policy Expiration: </label>
                                <input type="date" class="form-control" name="policyExp" required/>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
