<%--
  Created by IntelliJ IDEA.
  User: Ngo Minh Hai
  Date: 1/6/2021
  Time: 3:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<!-- Start header section -->
<jsp:include page = "./header/mainHeader.jsp" flush = "true" />

<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${pageContext.request.contextPath}/view/client/assets/images/archive-banner.png" alt="banner blog">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Đăng nhập</h2>
                <ul class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
                    <li style="color:#fff">Đăng nhập</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->
<!-- Cart view section -->
<section id="aa-myaccount">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-myaccount-area">
                    <div class="row">
                        <div class="col-md-8 col-md-push-2">
                            <div class="aa-myaccount-login">
                                <h4>Đăng nhập</h4>
                                <form action='<c:url value="/dang-nhap"/>' id="formLogin" method="post" class="aa-login-form" name="loginform">
<%--                                    Ten dang nhap--%>
                                    <label for="username">Tên đăng nhập<span>*</span></label>
                                    <input type="text" placeholder="Username" id="username" name="username"
                                           oninvalid="this.setCustomValidity('Vui lòng nhập Tên đăng nhập')" required autofocus>
<%--                                     Mat khau--%>
                                    <label for="password">Mật khẩu<span>*</span></label>
                                    <input  type="password" placeholder="Password" id="password" name="password" required>
                                    <input type="button" onclick="showPass()" id="showPassword" value="Hiển thị" class="btn-show-pass" />
                                    <p class="rememberme">
                                        <input type="checkbox" id="rememberme" name="remember" value="Ghi nhớ">
                                        <label for="rememberme">Ghi nhớ</label>
                                        <span class="forget-pass"><a href="forgot-password.html">Quên mật khẩu?</a></span>
                                    </p>
                                    <input type="hidden" value="" id="action" name="action">
<%--                                    Dang nhap--%>
                                    <button type="submit" class="aa-browse-btn">ĐĂNG NHẬP</button>
                                    <div class="register-with">- Hoặc -</div>
                                    <button style="width: 49%;float: left"  type="submit" class="btn-sign-up-google">
                                        <img class="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg" alt="icon google"/>Google
                                    </button>
                                    <button style="width: 49%;float: right" type="submit" class="btn-sign-up-facebook">
                                        <span style="font-size: 0.55rem;"><i class="fab fa-facebook-f fa-4x facebook-icon"></i></span>Facebook
                                    </button>
                                    <div class="title-span">Bạn là thành viên mới? <a style="color: #337ab7;" href="register.html">Đăng ký</a>.</div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->

<!--  end content-->
<script>
    let isBool = true;

    function showPass(){
        if(isBool){
            document.getElementById("password").setAttribute("type","text");
            isBool=false;
            document.getElementById("showPassword").value = "Ẩn";
        }else {
            document.getElementById("password").setAttribute("type","password");
            isBool=true;
            document.getElementById("showPassword").value = "Hiển thị";
        }
    }
</script>
<!--  footer-->
<jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->