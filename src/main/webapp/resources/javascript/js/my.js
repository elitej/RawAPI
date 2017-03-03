$(document).ready(function(){
    $("#auth-button").click(function(){
    $("#auth-registration")
        .css({"color":"red","background-color":"red","margin-top": "20px"})
              .slideToggle().toggleClass("hidden-xs auth-registration");
    });

    $("#search-icon").click(function(){
        $("#search-text-area").slideToggle();
    }); 

});
