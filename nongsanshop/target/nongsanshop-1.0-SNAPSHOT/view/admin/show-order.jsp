
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
                                        <b> Admin:  <%=session.getAttribute("admin-username") %></b>
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
                <h5 class="card-title">Danh sách đơn hàng</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                       <th scope="col">Tài khoản User</th>
                        <th scope="col">Họ Tên</th>
                        <th scope="col">Email</th>
                        <th scope="col">SĐT</th>
                         <th scope="col">Địa chỉ</th>
                         <th scope="col">Ghi chú</th>
                         <th scope="col">Tổng tiền</th>
                         <th scope="col">Phương thức thanh toán</th>
                         <th scope="col">Trạng thái</th>
                          <th scope="col">Ngày tạo</th>
                           <th scope="col">Hành động</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${order}" var="order">
                      <tr>
                        <td scope="row">${order.id}</td>
                         <td>${order.user_session}</td>
                        <td>${order.user_name}</td>
                        <td>${order.user_mail}</td>
                        <td>${order.user_phone}</td>
                        <td>${order.address}</td>
                         <td>${order.message}</td>
                         <td>${order.amount} VNĐ</td>
                          <td>  <c:choose>
	                        <c:when test="${order.payment == 0}"> 
	                        	<c:out value="COD"/>
	                       	</c:when>
	                       	<c:otherwise>
						        <c:out value="Thẻ nội địa ATM"/>
						    </c:otherwise>
                       	</c:choose>
                          
                          </td>
                          <td>
                          	  <c:choose>
	                        <c:when test="${order.status == NULL}"> 
	                        	<c:out value="Chưa thanh toán"/>
	                       	</c:when>
	                       	<c:otherwise>
						        <c:out value="Đã thanh toán"/>
						    </c:otherwise>
                       	</c:choose>
                          </td>
                           <td>${order.created}</td>
                           
        				
        				 <td>
                         <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/order/delete?id=${order.id}">Xóa</a></button>
                         
                          <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/order/edit?id=${order.id}">Sửa</a></button>
                        </td>
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