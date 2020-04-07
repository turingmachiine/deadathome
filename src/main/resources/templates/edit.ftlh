<#include "base.ftlh"/>
<#macro title><@spring.message 'edit.page.main'/></#macro>

<#macro content>
    <div class="maincontent bg--white pt--80 pb--55">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-12">
                <div class="wn__single__product">
                    <div class="row justify-content-center">
                        <div class="product__info__main">
                            <h1><@spring.message 'edit.page.main'/></h1>
                            <form class="account__form" action="/edit" method="post" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col-lg-6 col-12">
                                        <div class="image-container">
                                            <#if user.profilePic?has_content>
                                                <img src="/files/${user.profilePic.storageFileName}" id="imgProfile" class="img-thumbnail" />
                                            <#else>
                                                <img src="/assets/images/userpic.png" id="imgProfile" class="img-thumbnail" />
                                            </#if>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-12">
                                        <div class="input__box">
                                            <label>Email<span>*</span></label>
                                            <input type="email" name="email" value="${user.email}">
                                        </div>
                                        <div class="input__box">
                                            <label><@spring.message 'sign.page.form.first_name'/><span>*</span></label>
                                            <input type="text" name="firstName" value="${user.firstName}">
                                        </div>
                                        <div class="input__box">
                                            <label><@spring.message 'sign.page.form.last_name'/><span>*</span></label>
                                            <input type="text" name="lastName" value="${user.lastName}">
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                                                <div class="form__btn1">
                                                    <input type="file" style="display: none;" name="profilePic" id="profilePicture" name="file" />
                                                    <button type="button" id="btnChangePicture"><@spring.message 'edit.page.change_photo'/></button>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                                                <div class="form__btn">
                                                    <button type="submit"><@spring.message 'edit.page.btn_sbt'/></button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#macro>
<@main/>