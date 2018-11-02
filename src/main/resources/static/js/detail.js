$(document).ready(function(){
    $("#link").click(function(){
        var url = "/expertu/detail";
        $.ajax({
            type : "post",
            async : true,
            url : url,
            dataType:'json',
            timeout:1000,
            success:function(data){
                $.each(data, function(idx, obj) {
                    $("#content").append("<h2>"+obj.productname+"</h2></br>");
                });
            },

            error: function() {
            }
        });
    });
})