<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Tag 4</h3>
<c:forEach var="product" items="${products }">
	id: ${product.id}
	<br>
	name: ${product.name}
	<br>
	price: ${product.price}
	<br>
	=========================
	<br>
</c:forEach>