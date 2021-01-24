<%--
  Created by IntelliJ IDEA.
  User: Kino
  Date: 1/20/2021
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!-- Start header section -->
<jsp:include page = "./header/mainHeader.jsp" flush = "true" />
<!-- / header section -->
<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${pageContext.request.contextPath}/view/client/assets/images/banner-product.png" alt="banner sản phẩm">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Thông tin tài  khoản</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
                    <li><a href="${pageContext.request.contextPath}/view/client/account">Tài khoản</a></li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<section id="aa-myaccount">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-myaccount-area">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Thông tin tài khoản</h5>
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th scope="col" type="hiden">Mã Tài Khoản</th>
                                                <th scope="col">Họ Tên</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Tên Đăng Nhập</th>
                                                <th scope="col">Hành động</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${accountuser}" var="user">
                                                <tr>
                                                    <td scope="row">${user.id}</td>
                                                    <td>${user.id}</td>
                                                    <td>${user.email}</td>
                                                    <td>${user.phone}</td>
                                                    <td>${user.username}</td>

                                                    <td>
                                                        <button class="btn btn-success"><a href="${pageContext.request.contextPath}/view/client/edit?id=${user.id}">Sửa</a></button>
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
        </div>
    </div>
</section>

<!--  footer-->
<jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
