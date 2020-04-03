<#include "base.ftlh">

<#macro title>Post Creation</#macro>

<#macro content>
    <h2 class="contact__title text-center">Опубликуйте пост</h2>
    <section class="wn_contact_area bg--white pt--80 pb--40">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-12">
                    <div class="contact-form-wrap">
                        <form action="/create_post" method="post" enctype="multipart/form-data">
                            <div class="single-contact-form">
                                <input type="text" name="title" placeholder="Название">
                            </div>
                            <div class="single-contact-form message">
                                <textarea name="text" placeholder="Напишите ваш пост здесь.."></textarea>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="single-contact-form space-between">
                                        <select class="select-form" name="houseName">
                                            <option>Никакой</option>
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
                                        <button type="button" id="btnChangePicture">Изменить фотографию</button>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                                    <div class="form__btn1">
                                        <button type="submit">Опубликовать</button>
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