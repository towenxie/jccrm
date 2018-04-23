/**
 * Created by bgt on 2016/8/16.
 */
$(function(){
    // 全选与返选
    $("#all").click(function() {
        if (this.checked) {
            $('input[name="ids"]').prop("checked", true);
        } else {
            $('input[name="ids"]').removeAttr("checked");
        }

    });
});