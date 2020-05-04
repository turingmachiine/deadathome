<#include "base.ftlh"/>

<#macro title><@spring.message 'sign.page.sign_in'/></#macro>

<#macro connect></#macro>
<#macro content>
    <section class="my_account_area pt--80 pb--55 bg--white">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 col-12">
                    <div class="my__account__wrapper">
                        <h3 class="account__title"><@spring.message 'sign.page.sign_in'/></h3>
                        <form action="/signIn" method="post">
                            <div class="account__form">
                                <div class="input__box">
                                    <label><@spring.message 'sign.page.login'/><span>*</span></label>
                                    <input name="email" id="email"type="text" >
                                 </div>
                                <div class="input__box">
                                    <label><@spring.message 'sign.page.form.pass'/><span>*</span></label>
                                    <input id="password" type="password" name="password" <#--oninput="pass_check()"-->>
                                    <label style="color: #bd2130" id="length_error"></label>
                                    <label style="color: #bd2130" id="num_error"></label>
                                    <label style="color: #bd2130" id="letter_error"></label>
                                </div>
                                <div class="form__btn">
                                    <button type="submit" id="form_btn"><@spring.message 'sign.page.sign_in'/></button>
                                    <#--<label class="label-for-checkbox">
                                        <input id="rememberme" class="input-checkbox" name="rememberme" type="checkbox">
                                        <span>Запомнить меня</span>
                                    </label>
                                --></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</#macro>
<@main/>