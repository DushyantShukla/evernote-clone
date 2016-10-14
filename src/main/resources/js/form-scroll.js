$(".form-scroll").on('click', function(event) {

    var target = $( $(this).attr('href') );
    alert(this);
    $window.scrollTo(0, 0);


    if( target.length ) {
        event.preventDefault();
        
        $("#box").animate({
            scrollTop: target.offset().top
        }, 1000);
    }

});
