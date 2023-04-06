(function ($) {
    "use strict";
    
    // loader
    var loader = function () {
        setTimeout(function () {
            if ($('#loader').length > 0) {
                $('#loader').removeClass('show');
            }
        }, 1);
    };
    loader();
    
    
    // Sticky Navbar
    $(window).scroll(function () {
        if ($(this).scrollTop() > 90) {
            $('.nav-bar').addClass('nav-sticky');
            $('.top, .page-header').css("margin-top", "73px");
        } else {
            $('.nav-bar').removeClass('nav-sticky');
            $('.top, .page-header').css("margin-top", "0");
        }
    });
    
    
    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 992) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }
        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });

    
})(jQuery);

const topButton = document.querySelector(".back-to-top")
window.addEventListener('scroll', () => {
    const scrollHeight = window.pageYOffset;
    if(scrollHeight > 400){
        topButton.style.display = "block";
    }
    else {
        topButton.style.display = "none";
    }
})
const about = document.getElementById("a");
const feature = document.getElementById("f");
const container = document.querySelector(".container-fluid")

about.addEventListener("click", (e) => {
    const linkHeight = container.getBoundingClientRect().height;    
    window.scrollTo(0,linkHeight + 20);
})

feature.addEventListener("click", (e) => {
    const linkHeight = document.getElementById("feature").offsetTop;
    window.scrollTo(0,(linkHeight - 80));
})