<%@ page import="java.util.List" %>
<%@ page import="com.gojava6.airbnb.servlets.GetAppartmentsByCity" %>
<%@ page import="com.gojava6.airbnb.apartment.Apartment" %>
<%@ page import="com.gojava6.airbnb.dao.apartmentDao" %>
<%@ page import="com.gojava6.airbnb.user.User" %>
<%@ page import="com.gojava6.airbnb.services.UserService" %>

<%--
  Created by IntelliJ IDEA.
  User: shata
  Date: 20.10.2015
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!DOCTYPE html>--%>
<html lang="en">
<head>
  <title>airbnb</title>
  <meta charset="utf-8">
  <meta name="author" content="pixelhint.com">
  <meta name="description" content="La casa free real state fully responsive html5/css3 home page website template"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

  <link rel="stylesheet" type="text/css" href="css/reset.css">
  <link rel="stylesheet" type="text/css" href="css/responsive.css">

  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/main.js"></script>
</head>
<body>

<section class="hero">
  <header>
    <div class="wrapper">
      <a href="index.html"><img src="img/logo.png" class="logo" alt="" titl=""/></a>
      <a href="#" class="hamburger"></a>
      <nav>
        <ul>
          <li><a href="get_all_users.jsp">Get all users</a></li>
          <li><a href="registration_page.html">Registration</a></li>
        </ul>
        <a href="login_page.html" class="login_btn">Login</a>
      </nav>
    </div>
  </header><!--  end header section  -->

  <section class="caption">
    <h2 class="caption">airbnb</h2>
    <h3 class="properties">Appartements - Houses - Rooms</h3>
  </section>
</section><!--  end hero section  -->


<section class="search">
  <div class="wrapper">
    <form action="#" method="post">
      <input type="text" id="search" name="search" placeholder="Book your room right now!"  autocomplete="off"/>
      <input type="submit" id="submit_search" name="submit_search"/>
    </form>
    <a href="#" class="advanced_search_icon" id="advanced_search_btn"></a>
  </div>

  <div class="advanced_search">
    <div class="wrapper">
      <span class="arrow"></span>
      <form action="GetAppartmentsByCity" method="post">
        <input type="text" id="city" name="city" placeholder="Get Apartments by City"  autocomplete="off">
        <input type="submit" id="submit_search" name="submit_search"/>
        <div class="search_fields">
          <input type="text" class="float" id="check_in_date" name="check_in_date" placeholder="Check In Date"  autocomplete="off">

          <hr class="field_sep float"/>

          <input type="text" class="float" id="check_out_date" name="check_out_date" placeholder="Check Out Date"  autocomplete="off">
        </div>
        <div class="search_fields">
          <input type="text" class="float" id="min_price" name="min_price" placeholder="Min. Price"  autocomplete="off">

          <hr class="field_sep float"/>

          <input type="text" class="float" id="max_price" name="max_price" placeholder="Max. price"  autocomplete="off">
        </div>
      </form>
    </div>
  </div> <!-- end advanced search section  -->
</section><!--  end search section  -->


<section class="listings">
  <div class="wrapper">
    <ul class="properties_list">
      <%
        List<User> users = UserService.getAllUsers();
        for (User user : users) {
      %>
      <li>
        <a href="#">
          <img src="img/user.jpg" alt="" title="" class="property_img"/>
        </a>
        <span class="price"><%= user.getName() + " " + user.getSurname() %></span>
        <div class="property_details">
          <h1>
            <a href="#"><%= "E-mail: " + user.getEmail()%> <br> <%= "This user is a: " + user.getUserType() %></a>
          </h1>
          <h2><%= "id: " + user.getUserID() %> <span class="property_size">(some text)</span></h2>
        </div>
      </li>
      <%
        }
      %>
    </ul>
    <div class="more_listing">
      <a href="#" class="more_listing_btn">View More Listings</a>
    </div>
  </div>
</section>	<!--  end listing section  -->

<footer>
  <div class="wrapper footer">
    <ul>
      <li class="links">
        <ul>
          <li><a href="#">About</a></li>
          <li><a href="#">Support</a></li>
          <li><a href="#">Terms</a></li>
          <li><a href="#">Policy</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
      </li>

      <li class="links">
        <ul>
          <li><a href="#">Appartements</a></li>
          <li><a href="#">Houses</a></li>
          <li><a href="#">Rooms</a></li>
          <li><a href="#">Bed</a></li>
          <li><a href="#">...</a></li>
        </ul>
      </li>

      <li class="links">
        <ul>
          <li><a href="#">New York</a></li>
          <li><a href="#">Los Anglos</a></li>
          <li><a href="#">Miami</a></li>
          <li><a href="#">Washington</a></li>
          <li><a href="#">...</a></li>
        </ul>
      </li>

      <li class="about">
        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
        <ul>
          <li><a href="http://facebook.com/pixelhint" class="facebook" target="_blank"></a></li>
          <li><a href="http://twitter.com/pixelhint" class="twitter" target="_blank"></a></li>
          <li><a href="http://plus.google.com/+Pixelhint" class="google" target="_blank"></a></li>
          <li><a href="#" class="skype"></a></li>
        </ul>
      </li>
    </ul>
  </div>

  <div class="copyrights wrapper">
    Copyright В© 2015 <a href="http://pixelhint.com" target="_blank" class="ph_link" title="Download more free Templates"></a>. All Rights Reserved.
  </div>
</footer><!--  end footer  -->

</body>
</html>