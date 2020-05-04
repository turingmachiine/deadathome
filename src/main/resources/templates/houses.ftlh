<#include "base.ftlh">

<#macro title><@spring.message 'root.page.link_houses'/></#macro>
<#macro connect></#macro>
<#macro content>
    <div class="page-shop-sidebar left--sidebar bg--white section-padding--lg">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-12 order-2 order-lg-1 md-mt-40 sm-mt-40">
                    <div class="shop__sidebar">
                        <aside class="wedget__categories pro--range">
                            <h3 class="wedget__title"><@spring.message 'houses.page.search'/></h3>
                            <div class="single-contact-form">
                                <input type="text" id="query" oninput="f()" placeholder=<@spring.message 'houses.page.enter'/>>
                            </div>

                        </aside>
                    </div>
                </div>
                <div class="col-lg-9 col-12 order-1 order-lg-2">
                    <div class="row">
                        <div class="col-lg-12">
                        </div>
                    </div>
                    <div class="tab__container">
                        <div class="shop-grid tab-pane active" id="nav-list" role="tabpanel">
                            <div class="list__view__wrapper" id="res">
                                <!-- Start Single Product -->
                                <#list houses as h>
                                    <div class="list__view mb-2">
                                        <div class="thumb">
                                            <#if h.fileInfo?has_content>
                                                <a class="first__img" href="/house${h.id}"><img src="files/${h.fileInfo.storageFileName}" alt="${h.name}"></a>
                                            <#else>
                                                <a class="first__img" href="/house${h.id}"><img src="images/blog/blog-3/1.jpg" alt="product images"></a>
                                            </#if>
                                        </div>
                                        <div class="content">
                                            <h2><a href="/house${h.id}">${h.name}</a></h2>
                                            <#if h.houseClass.equals("EXCELLENT")>
                                                <ul class="rating d-flex">
                                                    <li class="on"><i class="fa fa-star-o"></i></li>
                                                    <li class="on"><i class="fa fa-star-o"></i></li>
                                                    <li class="on"><i class="fa fa-star-o"></i></li>
                                                    <li class="on"><i class="fa fa-star-o"></i></li>
                                                    <li class="on"><i class="fa fa-star-o"></i></li>
                                                    <li class="on"><i class="fa fa-star-o"></i></li>
                                                </ul>
                                            <#elseif h.houseClass.equals("NORMAL")>

                                            <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>

                                            </ul>
                                            <#else>
                                                <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                            </ul>
                                            </#if>
                                            <p>${h.description}</p>
                                        </div>
                                    </div>
                                </#list>
                                <!-- End Single Product -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="application/javascript">
        function f() {
                $.ajax({
                    url: "/searchHouses",
                    data: {"name": $("#query").val()},
                    dataType: "json",
                    success: function (msg) {
                        if (msg.length > 0) {
                            $("#res").html("");
                            for (var i = 0; i < msg.length; i++) {

                                if (msg[i].fileInfo != null) {
                                    $("#res").append("<div class=\"list__view mb-2\" id=\"resa" + msg[i].id + "\">\n" +
                                        "                                    <div class=\"thumb\">\n" + "<a class=\"first__img\" href=\"/house" + msg[i].id +
                                        "\"><img src=\"files/" + msg[i].fileInfo.storageFileName + "\"></a>");
                                } else {
                                    $("#res").append("<div class=\"list__view mb-2\" id=\"resa" + msg[i].id + "\">\n" +
                                        "                                    <div class=\"thumb\">\n" + "<a class=\"first__img\" href=\"/house" + msg[i].id +
                                        "\"><img src=\"/assets/images/blog/blog-3/1.jpg\"></a>");
                                }
                                $("#resa" + msg[i].id).append("<div class=\"content\" id=\"resal" + msg[i].id + "\">" +
                                    "<h2><a href=\"/house" + msg[i].id +
                                    "\">" + msg[i].name + "</a></h2>");
                                if (msg[i].houseClass == "EXCELLENT") {
                                    $("#resal" + msg[i].id).append("<ul class=\"rating d-flex\">\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "</ul>\n");
                                } else if (msg[i].houseClass == "NORMAL") {
                                    $("#resal" + msg[i].id).append("<ul class=\"rating d-flex\">\n" +
                                        "                                            <li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li><i class=\"fa fa-star-o\"></i></li>\n" +
                                    "</ul>\n");
                                } else {
                                    $("#resal" + msg[i].id).append("<ul class=\"rating d-flex\">\n" +
                                        "<li class=\"on\"><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "                                            <li><i class=\"fa fa-star-o\"></i></li>\n" +
                                        "</ul>\n");
                                }
                                $("#resal" + msg[i].id).append("<p>" + msg[i].description + "</p>")
                            }
                        } else {
                            $("#res").html("No results..");
                        }
                    }
                })
        }
    </script>


</#macro>
<@main/>