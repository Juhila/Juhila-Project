<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>My Cart</title>


<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/padding.css" />
<link rel="stylesheet" href="resources/css/slider.css" />

<link rel="stylesheet" href="resources/css/error.css" />
<link rel="stylesheet" href="resources/css/header.css" />
<link rel="stylesheet" href="resources/css/browse.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="resources/js/angular.min.js" ></script>
<script type="text/javascript" src="resources/js/jquery.min.js" ></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>



</head>
<body>

<nav class="navbar navbar-fixed-top">
  <div class="container-fluid navv">
   

    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
       <span class="glyphicon glyphicon-menu-hamburger colorr"></span>
        <%-- --<span class="icon-bar bgcolorr"></span>
        <span class="icon-bar bgcolorr"></span>
        <span class="icon-bar bgcolorr"></span> --%>
      </button>
      <a class="navbar-brand colorr mystyle" href="#">Electronics
      <i class="fa fa-refresh fa-spin"></i>
      </a>
    </div>
    
<div class="collapse navbar-collapse bgcolorr" id="myNavbar">
 
 <ul class="nav navbar-nav">
<form class="navbar-form navbar-left">
      <div class="input-group">
        <input  type="text" class="form-control" placeholder="Search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    </ul>
  


<ul class="nav navbar-nav navbar-right">
       
        <li><a class="colorr" href="#"><span class="glyphicon glyphicon-home colorr"></span>Home</a></li>
         <li><a class="colorr" href="#"><span class="glyphicon glyphicon-user colorr"></span>Sign Up</a></li>
        
        <li><a class="colorr" href="#"><span class="glyphicon glyphicon-log-in colorr"></span> Login</a></li>
  <li><a class="colorr" href="#"><span class="glyphicon glyphicon-shopping-cart colorr"></span> My Cart</a></li>
      </ul>
</div>
  </div>
</nav>

 