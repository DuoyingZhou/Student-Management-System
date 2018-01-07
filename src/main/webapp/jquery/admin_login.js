$(function() {
    $("#loginForm").validate({
        debug: true,
        submitHandler: function (form) {
            form.submit();
        },
        rules: {

            "AID": {
                required: true,
                email: true //must be in the format of email
            },
            "PASSWORD":{
                required: true,
                minlength: 2
            }
        }
    });
});