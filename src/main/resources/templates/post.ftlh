<#include "base.ftlh">

<#macro title>${post.title}</#macro>

<#macro content>
    <div class="page-blog-details section-padding--lg bg--white">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 col-12">
                    <div class="blog-details content">
                        <article class="blog-post-details">
                            <div class="post-thumbnail">
                                <#if post.fileInfo? has_content>
                                    <img src="files/${post.fileInfo.storageFileName}">
                                <#else>
                                    <img src="/assets/images/blog/big-img/1.jpg" alt="blog image">
                                </#if>
                            </div>
                            <div class="post_wrapper">
                                <div class="post_header">
                                    <h2>${post.title}</h2>
                                    <ul class="post_author">
                                        <li>${post.author.firstName} ${post.author.lastName}</li>
                                        <li class="post-separator">/</li>
                                        <li>${post.createdAt}</li>
                                    </ul>
                                </div>
                                <div class="post_content">
                                    <p>${post.postText}</p>
                                </div>
                            </div>
                        </article>
                        <div class="comments_area">
                            <h3 class="comment__title"><@spring.message 'post.page.comments'/></h3>
                            <ul class="comment__list">
                                <#if comments?has_content>
                                <#list comments as comment>
                                <li>
                                    <div class="wn__comment">
                                        <div class="thumb">
                                            <img src="files/${comment.user.profilePic.storageFileName}" width="50px" height="50px" alt="no photo">
                                        </div>
                                        <div class="content">
                                            <div class="comnt__author d-block d-sm-flex">
                                                <span>${comment.user.firstName} ${comment.user.lastName}</span>
                                                <span>${comment.createdAt}</span>
                                            </div>
                                            <p>${comment.commentText}</p>
                                        </div>
                                    </div>
                                </li>
                                </#list>
                                <#else>
                                    <h4><@spring.message 'post.page.no_comments'/></h4>
                                </#if>
                            </ul>
                        </div>
                        <#if user?has_content>
                        <div class="comment_respond mt--20">
                            <h3 class="reply_title"><@spring.message 'post.page.comment'/></h3>
                            <form class="comment__form" action="/comment${post.id}" method="post">
                                <div class="input__box">
                                    <textarea name="commentText"></textarea>
                                </div>
                                <div class="form__btn1">
                                    <button><@spring.message 'post.page.btn'/></button>
                                </div>
                            </form>
                        </div>
                        </#if>
                    </div>
                </div>
                <div class="col-lg-3 col-12 md-mt-40 sm-mt-40">
                    <div class="wn__sidebar">
                        <!-- Start Single Widget -->
                        <!-- End Single Widget -->
                        <!-- Start Single Widget -->
                        <aside class="widget recent_widget">
                            <h3 class="widget-title"><@spring.message 'post.page.other'/></h3>
                            <div class="recent-posts">
                                <ul>
                                    <#if otherPosts?has_content>
                                    <#list otherPosts as p>
                                    <li>
                                        <div class="post-wrapper d-flex">
                                            <div class="thumb">
                                                <a href="/post${p.id}">
                                                    <#if p.fileInfo?has_content>
                                                        <img src="files/${p.fileInfo.storageFileName}" alt="no photo"></a>
                                                    <#else>
                                                        no photo
                                                    </#if>
                                            </div>
                                            <div class="content">
                                                <h4><a href="post${p.id}">${p.title}</a></h4>
                                                <p>${p.createdAt}</p>
                                            </div>
                                        </div>
                                    </li>
                                    </#list>
                                    </#if>
                                </ul>
                            </div>
                        </aside>
                        <!-- End Single Widget -->
                        <!-- Start Single Widget -->
                        <!-- End Single Widget -->
                        <!-- Start Single Widget -->
                        <!-- End Single Widget -->
                        <!-- Start Single Widget -->
                        <!-- End Single Widget -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@main/>