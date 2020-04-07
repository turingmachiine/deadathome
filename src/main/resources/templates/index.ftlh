<#include "base.ftlh"/>

<#macro title><@spring.message 'root.page.app_name_first'/> <@spring.message 'root.page.app_name_second'/></#macro>

<#macro content>
    <section class="wn__recent__post bg--gray ptb--80">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section__title text-center">
                        <h2 class="title__be--2"><a href="/posts"><span class="color--theme"><@spring.message 'root.page.top_posts_link'/></span></a> <@spring.message 'root.page.top_posts_text'/></h2>
                        <p><@spring.message 'root.page.top_posts_text_lower'/></p>
                    </div>
                </div>
            </div>
            <#if topPosts?has_content>
                <div class="row mt--50">
                    <#list topPosts as t>
                        <div class="col-md-6 col-lg-4 col-sm-12 mb-2">
                            <div class="post__itam">
                                <div class="content">
                                    <h3><a href="/post${t.id}">${t.title}</a></h3>
                                    <div class="post__time">
                                        <span class="day">${t.createdAt}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </#if>
        </div>
    </section>
</#macro>
<@main/>