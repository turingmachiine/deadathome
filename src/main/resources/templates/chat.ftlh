<#include "base.ftlh">

<#macro title><@spring.message 'chat.page.chat'/></#macro>

<#macro connect>connect()</#macro>
<#macro content>

    <div class="page-blog-details section-padding--lg bg--white">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-12">
                    <div class="blog-details content">
                        <div class="comments_area">
                            <h3 class="comment__title"><@spring.message 'chat.page.chat'/></h3>
                            <ul class="comment__list" id="messagesList">
                            </ul>
                        </div>
                        <#if user?has_content>
                            <div class="comment_respond mt--20">
                                <h3 class="reply_title"><@spring.message 'chat.page.add'/></h3>
                                <div class="input__box">
                                    <textarea id="message" name="message"></textarea>
                                </div>
                                <div class="form__btn1">
                                    <button onclick="sendMessage($('#message').val(), '${user.firstName} ${user.lastName}', '${user.profilePic.storageFileName}')"><@spring.message 'post.page.btn'/></button>
                                </div>
                            </div>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script>
    var webSocket;
    function connect() {
        webSocket = new WebSocket('ws://localhost:8000/chat');

        document.cookie = 'X-Authorization=' + '123456' + ';path=/';

        webSocket.onmessage = function receiveMessage(response) {
            let data = response['data'];
            let json = JSON.parse(data);
            $('#messagesList').append("<li>" +
                    "<div class=\"wn__comment\"> <div class=\"thumb\">" +
                    "<img src=\"files/"+ json['profilePic'] + " \" width=\"50px\" height=\"50px\" alt=\"no photo\">" +
                    "</div>" +
                    "<div class=\"content\"> <div class=\"comnt__author d-block d-sm-flex\">" +
                    "<span>" + json['from'] + "</span> " +
                    "</div>" +
                    "<p>" + json['text'] + "</p>" +
                    "</div> </div>" +
                    "</li>")

        }
    }

    function sendMessage(text, username, profilePic) {
        let message = {
            "text": text,
            "from": username,
            "profilePic": profilePic
        };

        webSocket.send(JSON.stringify(message));
    }
</script>
</#macro>
<@main/>