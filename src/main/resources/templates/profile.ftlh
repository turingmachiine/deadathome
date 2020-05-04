<#include "base.ftlh"/>

<#macro title>${user.firstName}</#macro>
<#macro connect></#macro>
<#macro content>
    <div class="maincontent bg--white pt--80 pb--55">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 col-12">
                    <div class="wn__single__product">
                        <div class="row">
                            <div class="col-lg-6 col-12">
                                <div class="wn__fotorama__wrapper">
                                    <div class="fotorama wn__fotorama__action" data-nav="thumbs">
                                        <#if user.profilePic?has_content>
                                            <img src="files/${user.profilePic.storageFileName}" class="rounded float-left">
                                        <#else>
                                            <img src="images/userpic.png" class="rounded float-left">
                                        </#if>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-12">
                                <div class="product__info__main">
                                    <h1>${user.firstName} ${user.lastName}</h1>
                                    <div class="product-reviews-summary d-flex">
                                        <div class="reviews-actions d-flex">
                                            <a href="#">${user.email}</a>
                                            <a href="#">${user.createdAt}</a>
                                        </div>
                                    </div>
                                    <div class="product__overview">
                                        <div class="form__btn1">
                                            <button type="button" onclick="document.location='/edit'"><@spring.message 'profile.page.edit'/></button>
                                        </div>
                                        <p></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="wn__related__product pt--80 pb--50">
                        <div class="section__title text-center">
                            <h2 class="title__be--2"><@spring.message 'profile.page.houses'/></h2>
                        </div>
                        <div class="row mt--60">
                            <div class="productcategory__slide--2 arrows_style owl-carousel owl-theme">
                                <#if houses?has_content>
                                    <#list houses as house>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                            <div class="product">
                                                <div class="row justify-content-between">
                                                    <div class=" col-4 product__thumb">
                                                        <#if house.image?has_content>
                                                            <a class="first__img" href="/house?id=${house.id}"><img src="${house.image}" alt="${house.name}"></a>
                                                        <#else>
                                                            <a class="first__img" href="/house?id=${house.id}"><img src="/assets/images/blog/blog-3/1.jpg" alt="product images"></a>
                                                        </#if>
                                                    </div>
                                                    <div class="col-8 product__content">
                                                        <h4><a href="/house?id=${house.id}">${house.name}</a></h4>
                                                        <#if house.houseClass.id == 1>
                                                            <ul class="rating d-flex">
                                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                            </ul>
                                                        <#elseif house.houseClass.id == 2>
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
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-12 md-mt-40 sm-mt-40">
                    <div class="shop__sidebar">
                        <aside class="wedget__categories poroduct--cat">
                            <h3 class="wedget__title"><@spring.message 'profile.page.posts'/></h3>
                            <ul>
                                <#if posts?has_content>
                                    <#list posts as p>
                                        <li><a href="/post?id=${p.id}">${p.title}</a></li>
                                    </#list>
                                </#if>
                            </ul>
                        </aside>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@main/>


