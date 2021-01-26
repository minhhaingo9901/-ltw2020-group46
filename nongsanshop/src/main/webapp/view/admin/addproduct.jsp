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
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm sản phẩm</div>
                <hr>
                <form method="post" action="${pageContext.request.contextPath}/admin/product/add" enctype="multipart/form-data" accept-charset="UTF-8">
                
               
                  <div class="form-group">
                    <label for="input-1">Tên sản phẩm</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tên sản phẩm" name="product-name">
                  </div>
                  
        
                  <div class="form-group">
	                  <label for="input-2">Danh mục</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-cate" aria-invalid="false">
	                    <c:forEach items="${catelist}" var="cate">
	                        <option value="${cate.id }">${cate.name }</option>
	                    </c:forEach>
	                    </select>
	                  </div>
	                </div>
	                 <div class="form-group">
                    <label for="input-1">Ngày</label> 
                    <input type="date" class="form-control" id="the-date" placeholder="Ngày đăng" name="product-day">
                  </div>
	                <div class="form-group">
                    <label for="input-1">Giá</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Giá" name="product-price">
                  </div>
                    <div class="form-group">
                        <label for="input-1">Số Lượng</label>
                        <input type="text" class="form-control" id="input-1" placeholder="Số Lượng" name="product-qty">
                    </div>

                    <div class="form-group">
	                  <label for="input-2">Trạng thái</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-status" required aria-invalid="false">
	                        <option value="1">Còn hàng</option>
	                        <option value="0">Hết hàng</option>
	                    </select>
	                  </div>
	                </div>
	                 <div class="form-group">
		                <label for="input-2">Giảm giá</label>
		                <div class="input-group">
		                <input type="text" class="form-control" placeholder="Giảm ... %" name="product-discount">
		                <div class="input-group-append">
		                <button class="btn btn-light" type="button">%</button>
		                </div>
		                </div>
	              </div>
                 <div class="form-group">
                  <label for="input-2" class="col-form-label">Mô tả</label>
                  <div>
                    <textarea class="form-control" rows="4" id="input-17" name="product-desc"></textarea>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="input-2" class="col-form-label">Nội dung</label>
                  <div>
                    <textarea class="form-control" rows="4" id="input-17" name="product-content"></textarea>
                  </div>
                </div>

                    <div class="form-group">
                        <label for="input-20">HÌNH ẢNH</label>
                        <div class="custom-file">
                            <p id="imgInfo">You have no image!</p>
                            <br /> <input type="file" id="imgInp" name="file" required><br />
                        </div>
                    </div>
               <div class="form-footer">
                    <button class="btn btn-danger"><i class="fa fa-times"></i><a href="${pageContext.request.contextPath}/admin/product/list">Hủy</a></button>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
<script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
</script>
<script>
    var loadFile = function (event) {
        var reader = new FileReader();
        reader.onload = function () {
            var output = document.getElementById('output');
            output.src = reader.result;
        };
        reader.readAsDataURL(event.target.files[0]);
    };// code display image upload
</script>
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

<script>
    $(document).ready(function() {
        $('#blah').hide();
        $("#imgInfo").show();

    });
</script>
<script type="text/javascript">
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#blah').attr('src', e.target.result);
                $('#blah').show();
                $("#imgInfo").hide();
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgInp").change(function() {
        readURL(this);
    });
</script>
</body>

</html>
