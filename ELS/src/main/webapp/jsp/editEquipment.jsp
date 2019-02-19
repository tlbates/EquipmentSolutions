<%-- 
    Document   : editEquipment
    Created on : Feb 18, 2019, 10:46:49 AM
    Author     : tylerbates
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ELS - Manage Equipment</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Manage Equipment</h1>
                <hr/>
                <div class="navbar">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/viewLeases">View Leases</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/viewEquipment">View Equipment</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/viewCustomers">View Customers</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/manageLeases">Manage Leases</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/manageEquipment">Manage Equipment</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/manageCustomers">Manage Customers</a></li>
                    </ul>    
                </div>
            </div>
            <div class="row">
                <h2 class="text-center">Equipment To Edit</h2>
                <div class="col-md-6 text-center">
                    <p>Make: <c:out value="${equipment.make}"/></p>
                    <p>Model: <c:out value="${equipment.model}"/></p>
                    <p>Vin No.: <c:out value="${equipment.vinNum}"/></p>
                    <p>Year: <c:out value="${equipment.year}"/></p>
                    <p>Tag No.: <c:out value="${equipment.tagNum}"/></p>
                    <p>GPS No.: <c:out value="${equipment.gpsNum}"/></p>
                    <p>Purchase Date: <c:out value="${equipment.purchaseDate}"/></p>
                    <p>Available: <c:out value="${equipment.available}"/></p>
                    <p>Active: <c:out value="${equipment.active}"/></p>
                </div>
                <div class="col-md-6">
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="editEquipment">
                        <input type="number" name="idEquip" value="${equipment.idEquip}" hidden required/>
                        <div class="form-group">
                            <label for="make">Make: </label>
                            <input type="text" class="form-control" name="make" placeholder="Make" required/>
                        </div>
                        <div class="form-group">
                            <label for="model">Model: </label>
                            <input type="text" class="form-control" name="model" placeholder="Model" required/>
                        </div>
                        <div class="form-group">
                            <label for="year">Year: </label>
                            <input type="number" class="form-control" min="1" max="9999"
                                   name="year" placeholder="Year" required/>
                        </div>
                        <div class="form-group">
                            <label for="vinNum">Vin No.: </label>
                            <input type="text" class="form-control" name="vinNum" placeholder="Vin No." required/>
                        </div>
                        <div class="form-group">
                            <label for="purchaseDate">Purchase Date: </label>
                            <input type="date" class="form-control" name="purchaseDate" required/>
                        </div>
                        <div class="form-group">
                            <label for="available">Available: </label>
                            <input type="radio" class="form-control" name="available" value="yes" checked>Yes<br>
                            <input type="radio" class="form-control" name="available" value="no">No<br>
                        </div>
                        <div class="form-group">
                            <label for="active">Active: </label>
                            <input type="radio" class="form-control" name="active" value="yes" checked>Yes<br>
                            <input type="radio" class="form-control" name="active" value="no">No<br>
                        </div>
                        <div class="form-group">
                            <label for="gpsNum">GPS No.: </label>
                            <input type="text" class="form-control" name="gpsNum" placeholder="GPS No." required/>
                        </div>
                        <div class="form-group">
                            <label for="tagNum">Tag No.: </label>
                            <input type="text" class="form-control" name="tagNum" placeholder="Tag No." required/>
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

