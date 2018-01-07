$(function() {
    $("#insertForm").validate({
        debug: true,
        submitHandler: function (form) {
            form.submit();
        },
        rules: {

            "CLASSNAME": {
                required: true
            },
            "DESCRIPTION":{
                required: true
            }
        }
    });
});