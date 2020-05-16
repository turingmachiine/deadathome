<#include "base.ftlh">

<#macro title><@spring.message 'root.page.link_create_post'/></#macro>
<#macro connect></#macro>
<#macro content>
    <h2 class="contact__title text-center"><@spring.message 'root.page.link_create_post'/></h2>
    <section class="wn_contact_area bg--white pt--80 pb--40">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-12">
                    <div class="contact-form-wrap">
                        <form action="/create_post" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <div class="single-contact-form">
                                <input type="text" name="title" placeholder=<@spring.message 'create.page.name'/>>
                            </div>
                            <div class="single-contact-form message">
                                <textarea name="text" placeholder=<@spring.message 'create_post.page.post'/>></textarea>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="single-contact-form space-between">
                                        <select class="select-form" name="houseName">
                                            <option><@spring.message 'create_post.page.none'/></option>
                                            <#list houses as h>
                                                <option> ${h.name}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                                    <div class="form__btn1">
                                        <input type="file" style="display: none;" name="file" id="profilePicture" name="file" />
                                        <button type="button" id="btnChangePicture"><@spring.message 'edit.page.change_photo'/></button>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                                    <div class="form__btn1">
                                        <button type="submit"><@spring.message 'create.page.create'/></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="form-output">
                        <p class="form-messege">
                    </div>
                </div>
                <div class="col-lg-4 col-12">
                    <div class="image-container">
                        <img src="/assets/images/blog/blog-3/1.jpg" id="imgProfile" class="img-thumbnail">
                    </div>
                </div>
            </div>
        </div>
    </section>

</#macro>
<@main/>