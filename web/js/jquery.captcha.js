;
(function ($) {
    $.fn.captcha = function (options) {

        var cnItems = ["铅笔", "剪刀", "闹钟", "红心", "音符"];
        var defaults = {
            borderColor: "",
            captchaDir: "/images/captcha",
            url: "/loginAction.dox?action=captcha",
            formId: "dataForm",
            text: "验证你是一个人类,<br />拖动 <span>高亮的图标</span> 到圆圈内.",
            items: Array("pencil", "scissors", "clock", "heart", "note")
        };

        var options = $.extend(defaults, options);


        $(this).html("<b class='ajax-fc-rtop'><b class='ajax-fc-r1'></b> <b class='ajax-fc-r2'></b> <b class='ajax-fc-r3'></b> <b class='ajax-fc-r4'></b></b><img class='ajax-fc-border' id='ajax-fc-left' src='" + options.captchaDir + "/border-left.png' /><img class='ajax-fc-border' id='ajax-fc-right' src='" + options.captchaDir + "/border-right.png' /><div id='ajax-fc-content'><div id='ajax-fc-left'><p id='ajax-fc-task'>" + options.text + "</p><ul id='ajax-fc-task'><li class='ajax-fc-0'><img src='" + options.captchaDir + "/item-none.png' alt='' /></li><li class='ajax-fc-1'><img src='" + options.captchaDir + "/item-none.png' alt='' /></li><li class='ajax-fc-2'><img src='" + options.captchaDir + "/item-none.png' alt='' /></li><li class='ajax-fc-3'><img src='" + options.captchaDir + "/item-none.png' alt='' /></li><li class='ajax-fc-4'><img src='" + options.captchaDir + "/item-none.png' alt='' /></li></ul></div><div id='ajax-fc-right'><p id='ajax-fc-circle'></p></div></div><div id='ajax-fc-corner-spacer'></div><b class='ajax-fc-rbottom'><b class='ajax-fc-r4'></b> <b class='ajax-fc-r3'></b> <b class='ajax-fc-r2'></b> <b class='ajax-fc-r1'></b></b>");
        var rand = $.ajax({url: options.url, async: false}).responseText;

        var pic = randomNumber();
        $(".ajax-fc-" + rand).html("<img src=\"" + options.captchaDir + "/item-" + options.items[pic] + ".png\" alt=\"\" />");
        $("p#ajax-fc-task span").html(cnItems[pic]);
        $(".ajax-fc-" + rand).addClass('ajax-fc-highlighted');
        //$(".ajax-fc-" + rand).draggable({ containment: '#ajax-fc-content' });
        $('.ajax-fc-' + rand).draggable();
        var used = Array();
        for (var i = 0; i < 5; i++) {
            if (i != rand && i != pic) {
                $(".ajax-fc-" + i).html("<img src=\"" + options.captchaDir + "/item-" + options.items[i] + ".png\" alt=\"\" />");
                used[i] = options.items[i];
            }
        }
        $(".ajax-fc-container, .ajax-fc-rtop *, .ajax-fc-rbottom *").css("background-color", options.borderColor);
        $("#ajax-fc-circle").droppable({
            accept:".ajax-fc-" + rand,
            onDrop: function (e, source) {
                $(source).draggable('options').disabled=true;
                //$(".ajax-fc-" + rand).draggable("disable");
                $("#" + options.formId).append("<input type=\"hidden\" name=\"captcha\" value=\"" + rand + "\">");
            }
        });
    };

})(jQuery);

function randomNumber() {
    var chars = "01234";
    chars += ".";
    var size = 1;
    var i = 1;
    var ret = "";
    while (i <= size) {
        $max = chars.length - 1;
        $num = Math.floor(Math.random() * $max);
        $temp = chars.substr($num, 1);
        ret += $temp;
        i++;
    }
    return ret;
}