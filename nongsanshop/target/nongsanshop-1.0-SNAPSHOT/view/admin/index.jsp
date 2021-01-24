<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value = "/view/admin/assets" var="url"/>
<%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("username") == null){
	  response.sendRedirect(request.getContextPath() + "/view/client/login");
  }
  %>
  <!-- Start header section -->
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

<body>


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
        <div class="card mt-3">
          <div class="card-content">
            <div class="row row-group m-0">
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h5 class="text-white mb-0">3 <span class="float-right"><i class="fa fa-shopping-cart"></i></span>
                  </h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:55%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Đơn hàng (theo tuần)<span class="float-right">+4.2% <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h5 class="text-white mb-0">230.000 <span class="float-right">VNĐ</span></h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:55%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Lợi nhuận (theo tuần)<span class="float-right">+1.2% <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h5 class="text-white mb-0">25 <span class="float-right"><i class="fa fa-eye"></i></span></h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:55%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Ghé trang (theo tuần)<span class="float-right">+5.2% <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body">
                  <h5 class="text-white mb-0">3 <span class="float-right"><i class="fa fa-envira"></i></span></h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:55%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Bán ra (theo tuần)<span class="float-right">+2.2% <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12 col-lg-4 col-xl-4">
            <div class="card">
              <div class="card-header">Danh mục bán chạy
              </div>
              <div class="card-body">
                <div class="chart-container-2">
                  <canvas id="chart2"></canvas>
                </div>
              </div>
              <div class="table-responsive">
                <table class="table align-items-center">
                  <tbody>
                    <tr>
                      <td><i class="fa fa-circle text-white mr-2"></i>Rau sạch</td>
                      <td>58.000 VNĐ</td>
                      <td>+55%</td>
                    </tr>
                    <tr>
                      <td><i class="fa fa-circle text-light-1 mr-2"></i>Củ quả</td>
                      <td>110.000 VNĐ</td>
                      <td>+25%</td>
                    </tr>
                    <tr>
                      <td><i class="fa fa-circle text-light-2 mr-2"></i>Hạt</td>
                      <td>215.500 VNĐ</td>
                      <td>+15%</td>
                    </tr>
                    <tr>
                      <td><i class="fa fa-circle text-light-3 mr-2"></i>Mật ong</td>
                      <td>310.000 VNĐ</td>
                      <td>+5%</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>

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