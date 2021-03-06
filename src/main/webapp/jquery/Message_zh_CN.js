$.extend($.validator.messages, {
    required: "This field can not be empty!",
    remote: "Input Error！Please input again!",
    email: "Please input the correct email!",
    url: "Please input the legal url!",
    date: "Please input the legal date!",
    dateISO: "Please input the legal date（For example：yyyy-mm-dd or yyyy/mm/dd）!",
    number: "Please input the legal number（integer or decimal）!",
    digits: "Please input integer!",
    creditcard: "Please input the legal credict card number!",
    equalTo: "Two inputs don't match!",
    accept: "Illegal filename suffixes!",
    extension : "This file is not allowed!" ,
    maxlength: $.validator.format("Input length no more than {0}!"),
    minlength: $.validator.format("Input length no less than {0}!"),
    rangelength: $.validator.format("Input length between {0} ~ {1}!"),
    range: $.validator.format("Please input a value between {0} ~ {1}!"),
    max: $.validator.format("Max input value is {0}!"),
    min: $.validator.format("Min input value is {0}!")
});