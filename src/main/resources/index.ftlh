<#include "base.ftl"/>

<#macro title>Дед дома</#macro>

<#macro content>
    <section class="wn__recent__post bg--gray ptb--80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section__title text-center">
                            <h2 class="title__be--2"><a href="/posts"><span class="color--theme">Обсуди</span></a> чтобы не забыть</h2>
                            <p>На нашем сайте можно найти отличные посты, рассказывающие о домах престарелых</p>
                        </div>
                    </div>
                </div>
                <#if topPosts?has_content>
                <div class="row mt--50">
                    <#list topPosts as t>
                        <div class="col-md-6 col-lg-4 col-sm-12 mb-2">
                            <div class="post__itam">
                                <div class="content">
                                    <h3><a href="/post?id=${t.id}">${t.title}</a></h3>
                                    <div class="post__time">
                                        <span class="day">${t.postDate}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
                </#if>
            </div>
        </section>
        <!-- End Recent Post Area -->
        <!-- Best Sale Area -->
        <!-- Best Sale Area Area -->
    <!-- Footer Area -->

</#macro>

<@main/>