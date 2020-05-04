<#include "base.ftlh"/>

<#macro title><@spring.message 'sign.page.sign_up'/></#macro>
<#macro connect></#macro>
<#macro content>

    <section class="my_account_area pt--80 pb--55 bg--white">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 col-12">
                    <div class="my__account__wrapper">
                        <h3 class="account__title"><@spring.message 'sign.page.sign_up'/></h3>
                        <form action="/signUp" method="post" enctype="multipart/form-data">
                            <div class="account__form">
                                <div class="image-container">
                                    <img src="http://placehold.it/150x150" id="imgProfile" style="width: 150px; height: 150px" class="img-thumbnail" />
                                    <div class="middle">
                                        <input type="button" class="btn btn-secondary" id="btnChangePicture" value=<@spring.message 'sign.page.form.img'/>>
                                        <input type="file" style="display: none;" name="profilePic" id="profilePicture" name="file" />
                                        <br><input type="button" class="btn btn-secondary btn-sm mt-1 d-none" id="btnDiscard" value="Discard Changes"/>
                                    </div>
                                </div>
                                <div class="input__box">
                                    <label><@spring.message 'sign.page.login'/><span>*</span></label>
                                    <input name="email" id="email"type="text" oninput="email_check()">
                                    <label style="color: #bd2130" id="email_error"></label>
                                </div>
                                <div class="input__box">
                                    <label><@spring.message 'sign.page.form.pass'/><span>*</span></label>
                                    <input id="password" type="password" name="password" oninput="pass_check()">
                                    <label style="color: #bd2130" id="length_error"></label>
                                    <label style="color: #bd2130" id="num_error"></label>
                                    <label style="color: #bd2130" id="letter_error"></label>
                                </div>

                                <div class="input__box">
                                    <label><@spring.message 'sign.page.form.first_name'/><span>*</span></label>
                                    <input name="firstName" type="text">
                                </div>
                                <div class="input__box">
                                    <label><@spring.message 'sign.page.form.last_name'/><span>*</span></label>
                                    <input name="lastName" type="text">
                                </div>
                                <div class="form__btn mx-auto">
                                    <button type="submit" id="form_btn"><@spring.message 'sign.page.form.btn'/></button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</#macro>

<@main/>
