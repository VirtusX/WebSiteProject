var pass1;
var pass2;
$(function () {
    $('#pass1').on('input focus', function () {
        pass2 = $('#pass2');
        if ($(this).val().length > 0 && pass2.val().length > 0) {
            if ($(this).val() != pass2.val()) {
                $(this).addClass('wrong').removeClass('ok');
                pass2.addClass('wrong').removeClass('ok');
            }
            else {
                $(this).addClass('ok').removeClass('wrong');
                pass2.addClass('ok').removeClass('wrong');
            }
        }
    })
});
$(function () {
    $('#pass2').on('input focus', function () {
        pass1 = $('#pass1');
        if ($(this).val().length > 0 && pass1.val().length > 0) {
            if ($(this).val() != pass1.val()) {
                $(this).addClass('wrong').removeClass('ok');
                pass1.addClass('wrong').removeClass('ok');
            }
            else {
                $(this).addClass('ok').removeClass('wrong');
                pass1.addClass('ok').removeClass('wrong');
            }
        }
    })
});

$(function () {
    $('#pass1,#pass2').blur(function () {
        $('#pass2').removeClass('ok').removeClass('wrong');
        $('#pass1').removeClass('ok').removeClass('wrong');
    })
});
