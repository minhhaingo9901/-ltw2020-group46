<%@ page import="nongsan.webmvc.model.User" %>
<%@ page import="nongsan.webmvc.dao.impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Kino
  Date: 1/20/2021
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma" , "no-cache");
    response.setHeader("Expires" , "0");
    UserDaoImpl userDao =new UserDaoImpl();
    if (session.getAttribute("username") != null){
        User user =new User();
        request.setAttribute("name",user);
        request.setAttribute("phone",user);
    }
%>
<!-- Start header section -->
<jsp:include page = "./header/mainHeader.jsp" flush = "true" />
<!-- / header section -->

<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${pageContext.request.contextPath}/view/client/assets/images/checkout-banner.png" alt="banner thanh toán">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Thanh toán</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Thông tin thanh toán</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="checkout">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="checkout-area">
                    <form action="${pageContext.request.contextPath}/view/client/transaction" method="post">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="checkout-left">
                                    <div class="panel-group" >
                                        <c:if test="${sessionScope.username == null}">
                                            <p> Bạn cần đăng nhập để thanh toán! Đăng nhập <a href="${pageContext.request.contextPath}/view/client/login" style="color: #754110">tại đây!</a></p>
                                        </c:if>
                                        <c:if test="${sessionScope.username != null}">
                                            <!-- Shipping Address -->
                                            <div class="panel panel-default aa-checkout-billaddress">
                                                <div class="panel-heading">
                                                    <h4 class="panel-title" style="color:#754110">
                                                        Địa chỉ giao hàng
                                                    </h4>
                                                </div>
                                                <div id="collapseFour">
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="aa-checkout-single-bill">
                                                                    <input type="text" placeholder="Họ Tên*" required="required" name="transaction_name" value="" autofocus>
                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="aa-checkout-single-bill">
                                                                    <input type="email" placeholder="Email*" required="required" name="transaction_email" value="" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="aa-checkout-single-bill">
                                                                    <input type="tel" placeholder="Số điện thoại*" required="required" name="transaction_phone" value="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="aa-checkout-single-bill">
                                                                    <textarea cols="8" rows="3" required="required" placeholder="Địa chỉ*" name="transaction_address" ></textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="aa-checkout-single-bill">
                                                                    <textarea cols="8" rows="3" placeholder="Ghi chú" name="transaction_mess"></textarea>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="aa-checkout-single-bill">
                                                                    <input type="date" placeholder="Password" name="transaction_created" id="the-date" style="display: none">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row" style="display: none">
                                                            <div class="col-md-12">
                                                                <div class="aa-checkout-single-bill">
                                                                    <input type="text" placeholder="userid_session" name="transaction_usersession" value="${username }">

                                                                    <input type="text" placeholder="totalmoney_session" name="transaction_amount" value="${sumprice}">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="checkout-right">
                                    <h4>Thông tin đơn hàng</h4>
                                    <div class="aa-order-summary-area">
                                        <table class="table table-responsive">
                                            <thead>
                                            <tr>
                                                <th>Sản phẩm</th>
                                                <th>Số tiền</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${order.items}" var="item">
                                                <tr>
                                                    <td>${item.product.name } <strong> x  ${item.qty}</strong></td>
                                                    <td>${item.price}00 VNĐ</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>Tạm tính</th>
                                                <td>${sumprice} VNĐ</td>
                                            </tr>
                                            <tr>
                                                <th>Thuế</th>
                                                <td>0 VNĐ</td>
                                            </tr>
                                            <tr>
                                                <th>Tổng cộng</th>
                                                <td><strong>${sumprice} VNĐ</strong></td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <h4>Hình thức thanh toán</h4>
                                    <div class="aa-payment-method">
                                    <label for="cashdelivery"><input type="radio" id="cashdelivery" name="transaction_payment" checked value="0"> Thanh toán khi nhận hàng (COD) </label>
                                    <label for="credit-card"><input type="radio" id="credit-card" name="transaction_payment" value="1" > Thanh toán bằng Thẻ tín dụng/Thẻ ghi nợ </label>
                                    <img src="${pageContext.request.contextPath}/view/client/assets/img/visa.png" border="0" alt="thanh toàn bằng thẻ tín dụng/thẻ ghi nợ">
                                    <img src="${pageContext.request.contextPath}/view/client/assets/img/master-card.jpg" border="0" alt="thanh toàn bằng thẻ tín dụng/thẻ ghi nợ">
                                    <label for="atm"><input type="radio" id="atm" name="transaction_payment" value="1" > Thanh toán bằng thể ngân hàng (ATM) </label>
                                    <label for="momo"><input type="radio" id="momo" name="transaction_payment" value="1" > Ví điện tử Momo/ZaloPay </label>
                                    <img src="${pageContext.request.contextPath}/view/client/assets/img/momo.png" border="0" alt="thanh toán bằng momo">
                                    <img src="${pageContext.request.contextPath}/view/client/assets/img/zalopay.png" border="0" alt="thanh toán bằng zalopay">
                                    <input type="submit" value="Đặt hàng" class="aa-browse-btn">
                                </div>
                                    <c:if test="${sessionScope.username == null && sessionScope.order == null}">
                                        <br>
                                        <p style="color: red">Bạn đã đặt hàng thành công!</p>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->
<!--  end content-->
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
<!--  footer-->
<jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->




