<%--
  Created by IntelliJ IDEA.
  User: Kino
  Date: 12/29/2020
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<!-- start header top  -->
<div class="aa-header-top">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-header-top-area">
                    <!-- start header top left -->
                    <div class="aa-header-top-left">
                        <div class="cellphone hidden-xs">
                            <p><span class="fas fa-home"></span>Website bán hàng nông sản</p>
                        </div>
                        <!-- start language -->
                        <div class="aa-language">
                            <div class="dropdown">
                                <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <img src="${url}/img/flag/vietnam.png" alt="english flag">Việt Nam
                                </a>

                            </div>
                        </div>
                        <!-- / language -->

                        <!-- start cellphone -->
                        <!--                <div class="cellphone hidden-xs">
                                          <p><span class="fa fa-phone"></span>00-62-658-658</p>
                                        </div>-->
                        <!-- / cellphone -->
                    </div>
                    <!-- / header top left -->
                    <div class="aa-header-top-right">
                        <ul class="aa-head-top-nav-right">

                            <c:if test="${not empty USERMODEL}">
                                <li>
                                    <a><strong>Chào</strong> ${USERMODEL.name}</a>
                                </li>
                                <a href='<c:url value="/dang-xuat?action=logout"/>'>Đăng xuất</a>
                                </li>
                            </c:if>

                            <c:if test="${empty USERMODEL}">
                                <li class="hidden-xs">
                                    <a href='<c:url value="/dang-ky"/>'>Đăng ký</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a>
                                </li>
                            </c:if>

                            <!--  data-toggle="modal" data-target="#login-modal" -->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- / header top  -->

