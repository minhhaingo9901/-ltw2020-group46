
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value = "/view/admin/assets" var="url"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Admin web nông sản</title>

  <link href="${url}/css/pace.min.css" rel="stylesheet" />
  <script src="${url}/js/pace.min.js"></script>
  <link rel="stylesheet" href="${url}/plugins/summernote/dist/summernote-bs4.css"/>
  <link rel="icon" href="${url}/images/favicon.ico" type="image/x-icon">
  <link href="${url}/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
  <link href="${url}/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
  <link href="${url}/css/bootstrap.min.css" rel="stylesheet" />
  <link href="${url}/css/animate.css" rel="stylesheet" type="text/css" />
  <link href="${url}/css/icons.css" rel="stylesheet" type="text/css" />
  <link href="${url}/css/sidebar-menu.css" rel="stylesheet" />
  <link href="${url}/css/app-style.css" rel="stylesheet" />


</head>

<body class="bg-theme bg-theme1">


<!-- start loader -->
<div id="pageloader-overlay" class="visible incoming">
  <div class="loader-wrapper-outer">
    <div class="loader-wrapper-inner">
      <div class="loader"></div>
    </div>
  </div>
</div>

<div id="wrapper">
  <div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
    <div class="brand-logo">
      <a href="${pageContext.request.contextPath}/admin/homepage">
        <img src="${url}/images/logo-icon.png" class="logo-icon" alt="logo icon">
        <h5 class="logo-text">Admin Web Nông Sản</h5>
      </a>
    </div>
    <ul class="sidebar-menu do-nicescrol">
      <li class="sidebar-header">MENU ADMIN</li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/homepage">
          <i class="zmdi zmdi-view-dashboard"></i> <span>Tổng quan</span>
        </a>
      </li>

      <li>
        <a href="${pageContext.request.contextPath}/admin/admin/list">
          <i class="zmdi zmdi-account-box"></i> <span>Quản lí Admin</span>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/user/list">
          <i class="zmdi zmdi-accounts"></i> <span>Quản lí User</span>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/cate/list">
          <i class="zmdi zmdi-grid"></i> <span>Chuyên Mục</span>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/product/list">
          <i class="zmdi zmdi-widgets"></i> <span>Danh Sách Sản Phẩm</span>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/order/list">
          <i class="zmdi zmdi-shopping-cart"></i> <span>Đơn Hàng</span>
        </a>
      </li>

      <li>
        <a href="${pageContext.request.contextPath}/admin/order/list-detail">
          <i class="zmdi zmdi-shopping-cart"></i> <span>Chi Tiết Đơn Hàng</span>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/review/list">
          <i class="zmdi zmdi-calendar-check"></i> <span>Review</span>
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/new/list">
          <i class="icon-envelope-open"></i> <span>Tin tức</span>
        </a>
      </li>
    </ul>
  </div>
  <header class="topbar-nav">
    <nav class="navbar navbar-expand fixed-top">
      <ul class="navbar-nav mr-auto align-items-center">
        <li class="nav-item">
          <a class="nav-link toggle-menu" href="javascript:void();">
            <i class="icon-menu menu-icon"></i>
          </a>
        </li>
      </ul>

      <ul class="navbar-nav align-items-center right-nav-link">
        <li class="nav-item">
          <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
              <span class="user-profile"><img src="${pageContext.request.contextPath}/view/admin/assets/images/avatar-admin.png" class="img-circle"
                                              alt="user avatar"></span>
          </a>
          <ul class="dropdown-menu dropdown-menu-right">
            <li class="dropdown-item user-details">
              <a href="javaScript:void();">
                <div class="media">
                  <div class="avatar"><img class="align-self-start mr-3" src="${pageContext.request.contextPath}/view/admin/assets/images/avatar-admin.png"
                                           alt="user avatar"></div>
                  <div class="media-body">
                    <h6 class="mt-2 user-title">Webnongsan</h6>
                    <b> Admin:  <%=session.getAttribute("username") %></b>
                  </div>
                </div>
              </a>
            </li>

            <li class="dropdown-divider"></li>
            <li class="dropdown-item"><i class="icon-power mr-2"></i><a href="${pageContext.request.contextPath}/admin/logout"> Đăng xuất</a></li>
          </ul>
        </li>
      </ul>
    </nav>
  </header>
  <div class="clearfix"></div>
    <div class="content-wrapper">
      <div class="container-fluid">
        <!--End Row-->


        <div class="row">
 
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Chi tiết đơn hàng</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                       <th scope="col">ID Đơn Hàng</th>
                        <th scope="col">ID Sản Phẩm</th>
                        <th scope="col">Tên Sản Phẩm</th>
                        <th scope="col">Giá</th>
                         <th scope="col">Số lượng</th>
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${orderedlist}" var="orderedlist">
                      <tr>
                        <td scope="row">${orderedlist.id}</td>
                         <td>${orderedlist.transaction_id}</td>
                        <td>${orderedlist.product_id}</td>
                        <c:forEach items="${products}" var="products">
                        <c:if test="${products.id == orderedlist.product_id}">
	                        <td>${products.name}</td>
	                        <td>${products.price} VNĐ</td>
                        </c:if>
                        </c:forEach>
                         <td>${orderedlist.qty}</td>
                          
                     </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
  <div class="right-sidebar">
    <div class="switcher-icon">
      <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
    </div>
    <div class="right-sidebar-content">
      <p class="mb-0">Màu nền admin</p>
      <hr>
      <ul class="switcher">
        <li id="theme1"></li>
        <li id="theme2"></li>
        <li id="theme3"></li>
        <li id="theme4"></li>
        <li id="theme5"></li>
        <li id="theme6"></li>
      </ul>
      <p class="mb-0">Màu nền gradient</p>
      <hr>
      <ul class="switcher">
        <li id="theme7"></li>
        <li id="theme8"></li>
        <li id="theme9"></li>
        <li id="theme10"></li>
        <li id="theme11"></li>
        <li id="theme12"></li>
        <li id="theme13"></li>
        <li id="theme14"></li>
        <li id="theme15"></li>
      </ul>
    </div>
  </div>
</div>
<script src="${url}/js/jquery.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/plugins/simplebar/js/simplebar.js"></script>
<script src="${url}/js/sidebar-menu.js"></script>
<script src="${url}/js/jquery.loading-indicator.js"></script>
<script src="${url}/js/app-script.js"></script>
<script src="${url}/plugins/Chart.js/Chart.min.js"></script>
<script src="${url}/js/index.js"></script>
<script src="${url}/plugins/summernote/dist/summernote-bs4.min.js"></script>
</body>

</html>