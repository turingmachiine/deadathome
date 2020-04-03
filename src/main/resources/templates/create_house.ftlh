<#include "base.ftlh"/>
<#macro title>Edit</#macro>

<#macro content>
    <section class="wn_contact_area bg--white pt--80">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-12">
                    <div class="contact-form-wrap">
                        <h2 class="contact__title">Опубликуйте дом</h2>
                        <form action="/create_house" method="post" enctype="multipart/form-data">
                            <div class="single-contact-form">
                                <input type="text" name="houseName" placeholder="Имя дома">
                            </div>
                            <div class="single-contact-form message">
                                <textarea name="description" placeholder="Описание"></textarea>
                            </div>
                            <div class="row">
                                <div class ="col-lg-8">
                                    <div class="single-contact-form space-between">
                                        <input type="text" name="latitude" placeholder="Широта">
                                        x
                                        <input type="text" name="longitude" placeholder="Долгота">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <select class="select-form" name="houseClass">
                                        <#list classes as c>
                                            <option> ${c}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class ="col-lg-12">
                                    <div class="single-contact-form space-between">
                                        <input type="text" name="city" placeholder="Город">
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
                </div>
                <div class="col-lg-4 col-12">
                    <div class="image-container">
                        <img src="/assets/images/product/1.jpg" id="imgProfile" class="img-thumbnail">
                    </div>
                </div>
            </div>
        </div>
    </section>

</#macro>
<@main/>