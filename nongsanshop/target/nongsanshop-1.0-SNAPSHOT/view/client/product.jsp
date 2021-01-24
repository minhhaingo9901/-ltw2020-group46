<%--
  Created by IntelliJ IDEA.
  User: Kino
  Date: 1/2/2021
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="nongsan.webmvc.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="nongsan.webmvc.dao.impl.ProductDaoImpl"%>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<!-- Start header section -->
<jsp:include page = "./header/mainHeader.jsp" flush = "true" />
<!-- / header section -->
<!-- catg header banner section -->

<section id="aa-catg-head-banner">

    <img src="${pageContext.request.contextPath}/view/client/assets/images/banner-product.png" alt="banner sản phẩm">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Sản phẩm</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Danh sách sản phẩm</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->
<!-- product category -->
<section id="aa-product-category">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
                <div class="aa-product-catg-content">

                    <div class="aa-product-catg-body">
                        <ul class="aa-product-catg">
                            <!-- start single product item -->
                            <%
                                int first = 0, last = 0, pages = 1;

                                if (request.getParameter("pages") != null) {
                                    pages = (int) Integer.parseInt(request.getParameter("pages"));
                                }
                                //Lấy tổng sản phẩm trong data bằng query select count(id) from name_table với JDBC Connect
                                int total = new ProductDaoImpl().getCount();

                                if (total <= 9) {
                                    first = 0;
                                    last = total;
                                } else {
                                    first = (pages - 1) * 9;
                                    last = 9;
                                }
                                //Lấy ra danh sách sản phẩm
                                List<Product> list = new ProductDaoImpl().getProduct(first, last);
                                for (Product product : list) {
                            %>
                            <li>
                                <figure>
                                    <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=<%=product.getId()%>"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/<%=product.getImage_link() %>" alt="<%=product.getName() %>"></a>
                                    <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=<%=product.getId() %>"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                                    <figcaption>
                                        <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=<%=product.getId() %>"><%=product.getName() %></a></h4>
                                        <span class="aa-product-price"><%=product.getPrice()%> VNĐ</span><span class="aa-product-price"></span>
                                    </figcaption>
                                </figure>
                                <!-- product badge -->
                                <span class="aa-badge aa-sale">-<%=product.getDiscount()%>%</span>

                            </li>

                            <%}%>
                        </ul>

                        <!-- / quick view modal -->
                    </div>
                </div>

                <%--PAGING--%>
                <ul class="pagination">
                    <%                //Button Previous
                        int back = 0;
                        if (pages == 0 || pages == 1) {
                            back = 1;//Luon la page 1
                        } else {
                            back = pages - 1;//Neu pages tu 2 tro len thi back tru 1
                        }
                    %>
                    <li ><a href="product?pages=<%=back%>"><i></i>Trang Trước</a></li>
                    <%
                        //Button Number pages
                        int loop = 0, num = 0;
                        if ((total / 9) % 2 == 0) {
                            num = total / 9;
                        } else {
                            num = (total + 1) / 9;
                        }
                        //Nếu total lẻ thêm 1
                        if (total % 2 != 0) {
                            loop = (total / 9) + 1;

                        } else {
                            //Nếu total chẵn nhỏ hơn fullpage và # fullPage thì thêm 1
                            if (total < (num * 9) + 9 && total != num * 9) {
                                loop = (total / 9) + 1;
                            } else {
                                //Nếu bằng fullPage thì không thêm
                                loop = (total / 9);
                            }
                        }
                        //Lap so pages
                        for (int i = 1; i <= loop; i++) {%>
                    <% if (pages == i) {%>

                    <li><span><a href="product?pages=<%=i%>"><%=i%></a></span></li>
                    <%} else {%>
                    <li class="arrow"><a href="product?pages=<%=i%>"><%=i%></a> </li>

                    <%}
                    }%>
                    <%
                        //Button Next
                        int next = 0;
                        //Nếu total lẻ
                        if (total % 2 != 0) {
                            if (pages == (total / 4) + 1) {
                                next = pages;//Khong next
                            } else {
                                next = pages + 1;//Co next
                            }
                        } else {
                            //Nếu total chẵn nhỏ hơn fullpage
                            //Và không fullPage thì thêm 1
                            if (total < (num * 4) + 4 && total != num * 4) {
                                if (pages == (total / 4) + 1) {
                                    next = pages;//Khong next
                                } else {
                                    next = pages + 1;//Co next
                                }
                            } else {
                                //Nếu fullPage đến trang cuối dừng
                                //Chưa tới trang cuối thì được next
                                if (pages == (total / 4)) {
                                    next = pages;//Khong next
                                } else {
                                    next = pages + 1;//Co next
                                }
                            }
                        }
                    %>
                    <li ><a href="product?pages=<%=next%>"><i class="next"></i>Trang Sau</a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
                <aside class="aa-sidebar">
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3>Danh mục</h3>
                        <ul class="aa-catg-nav">
                            <c:forEach items="${catelist}" var="cate">
                                <li><a href="${pageContext.request.contextPath}/view/client/product-id?id=${cate.id}">${cate.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <!-- single sidebar -->

                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3>Sản phẩm gần đây</h3>
                        <div class="aa-recently-views">
                            <ul>
                                <c:forEach items="${productlist}" var="product" end="2">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}" class="aa-cartbox-img"><img alt="img" src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}"></a>
                                        <div class="aa-cartbox-info">
                                            <h4><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                                            <c:choose>
                                                <c:when test="${product.discount == 0}">
                                                    <p>${product.price} VNĐ</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${productlist1}" var="product1">
                                                        <c:if test="${product1.id == product.id}">
                                                            <p>${product1.price} VNĐ</p>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- single sidebar -->

                </aside>


            </div>


        </div>

    </div>





</section>
<!-- / product category -->
<!--  end content-->

<!--  footer-->


<jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->

