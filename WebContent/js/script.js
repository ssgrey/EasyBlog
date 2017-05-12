	alert(".js");
$(document).ready(function () {
	alert("ready");
    $("#newCommentForm").submit(function (e) {
    	alert("before ajax");
        e.preventDefault();//阻止执行默认动作
        alert("before ajax");
        $.ajax({
            url: '/pzz',
            type: 'POST',
            data: $('#newCommentForm').serialize(),//序列化表单提交内容
            dataType:"json",
            success: function (comment) {
            	alert("ajax callback");
                if (!comment.message) {

                    $("<div class='col-md-8 col-md-offset-1' id='comments'><div class='panel panel-default'><div class='panel-body'><p>" + comment.body + "</p></div><div class='panel-footer'><p>Author: <i>" + comment.author + "</i></p><p>Email: <i>"
                        + comment.email + "</i></p></div></div></div>").appendTo('#comments').hide().fadeIn(500);

                    $('#newCommentForm')[0].reset();

                } else {
                    alert(comment.message);
                }

            },

            error: function () {
                alert('添加评论失败！');
            }
        });

    });
});
