var main = {
    init : function() {
        var_this = this;
        $('#saveBtn').on('click', function() {
        _this.save();
        });
    },

    save : function() {
        var data = {
            id: $('#id').val(),
            pass: $('#pass').val(),
            name: $('#name').val(),
            email: $('#email1').val() + "@" + $('#email2').val(),
            point: 1000
        };

        $.ajax({
            type: 'POST',
            url: '/members',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
//
//    reset : function() {
////        $('#id').val() = "";
////        $('#pass').val() = "";
////        $('#pass_confirm').val() = "";
////        $('#name').val() = "";
////        $('#email1').val() = "";
////        $('#email2').val() = "";
////
//        window.location.href = '/join';
//    },


};