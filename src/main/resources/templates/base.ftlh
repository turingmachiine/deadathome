<#macro title></#macro>

<#macro main>
    <html>
    <#import "spring.ftl" as spring />
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><@title/></title>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/plugins.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/plugins/owl.carousel.min.css">

        <link rel="stylesheet" href="css/custom.css">

        <script src="js/vendor/modernizr-3.5.0.min.js"></script>


    </head>
    <body>
    <div class="wrapper" id="wrapper">
        <header id="wn__header" class="header__area header__absolute sticky__header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-6 col-lg-2">
                        <div class="logo">
                            <a href="/">
                                <img src="images/logo6.png" alt="logo image">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8 d-none d-lg-block">
                        <nav class="mainmenu__nav">
                            <ul class="meninmenu d-flex justify-content-start">
                                <li class="drop with--one--item"><a href="/houses"><@spring.message 'root.page.link_houses'/></a>
                                </li>
                                <li class="drop"><a href="/posts"><@spring.message 'root.page.link_posts'/></a>
                                </li>
                                <#if user?has_content>
                                    <li><a href="/create_house"><@spring.message 'root.page.link_create_house'/></a></li>
                                    <li><a href="/create_post"><@spring.message 'root.page.link_create_post'/></a></li>
                                </#if>
                            </ul>
                        </nav>
                    </div>
                    <#if user?has_content>
                        <div class="col-md-6 col-sm-6 col-6 col-lg-2">
                            <ul class="header__sidebar__right d-flex justify-content-end align-items-center">
                                <li class="setting__bar__icon"><a class="setting__active" href="#"></a>
                                    <div class="searchbar__content setting__block">
                                        <div class="content-inner">
                                            <div class="switcher-currency">
                                                <strong class="label switcher-label">
                                                    <span>${user.firstName}</span>
                                                    <a href="/?lang=ru"><img src="images/icons/1200px-Flag_of_Russia.svg.png" height="16" width="24"></a>
                                                    <a href="/?lang=en"><img src="images/icons/Flag_of_the_United_Kingdom.svg" height="16" width="24"></a>
                                                </strong>
                                                <div class="switcher-options">
                                                    <div class="switcher-currency-trigger">
                                                        <div class="setting__menu">
                                                            <span><a href="/profile"><@spring.message 'root.page.my_account'/></a></span>
                                                            <span><a href="/logout"><@spring.message 'root.page.logout'/></a></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    <#else>
                        <div class="col-md-6 col-sm-6 col-6 col-lg-2">
                            <ul class="header__sidebar__right d-flex justify-content-end align-items-center">
                                <li class="setting__bar__icon"><a class="setting__active" href="#"></a>
                                    <div class="searchbar__content setting__block">
                                        <div class="content-inner">
                                            <div class="switcher-currency">
                                                <strong class="label switcher-label">
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <span><@spring.message 'root.page.greeting'/></span>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <a href="/?lang=ru"><img src="images/icons/1200px-Flag_of_Russia.svg.png" height="16" width="24"></a>
                                                            <a href="/?lang=en"><img src="images/icons/Flag_of_the_United_Kingdom.svg" height="16" width="24"></a>
                                                        </div>
                                                    </div>
                                                </strong>
                                                <div class="switcher-options">
                                                    <div class="switcher-currency-trigger">
                                                        <div class="setting__menu">
                                                            <span><a href="/signIn"><@spring.message 'root.page.login'/></a></span>
                                                            <span><a href="/signUp"><@spring.message 'root.page.sign_up'/></a></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </#if>
                </div>
            </div>
        </header>
        <!-- Start Slider area -->
        <section class="best-seel-area pt--80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section__title text-center pb--50">
                            <h1 class="title__be--2"> <@spring.message 'root.page.app_name_first'/> <span class="color--theme"><a href="/houses"><@spring.message 'root.page.app_name_second'/></a> </span></h1>
                            <p><@spring.message 'root.page.app_name_lower'/></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <@content/>
        <footer id="wn__footer" class="footer__area bg__cat--8 brown--color">
            <div class="footer-static-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer__widget footer__menu">
                                <div class="ft__logo">
                                    <a href="https://ampl.ink/dV1Yx">
                                        <img src="images/logo6.png" alt="logo">
                                    </a>
                                    <p><a href="https://ampl.ink/dV1Yx"><@spring.message 'root.page.footer_text'/></a></p>
                                </div>
                                <div class="footer__content">
                                    <ul class="mainmenu d-flex justify-content-center">
                                        <li><a href="/houses"><@spring.message 'root.page.link_houses'/></a></li>
                                        <li><a href="/posts"><@spring.message 'root.page.link_posts'/></a></li>
                                        <#if user?has_content>
                                            <li><a href="/profile"><@spring.message 'root.page.my_account'/></a></li>
                                        </#if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright__wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <div class="copyright">
                                <div class="copy__right__inner text-left">
                                    <p>ITIS <i class="fa fa-copyright"></i> <a href="kpfu.ru">Kazan University.</a> Group 11-801, 13B class</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <script src="js/vendor/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/active.js"></script>
    <script src="js/change_img.js"></script>
    <script src="js/validation.js"></script>
    </body>
    </html>
</#macro>