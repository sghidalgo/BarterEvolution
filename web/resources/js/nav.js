 $(window).scroll(function() {
        if ($("#menu").offset().top > 56) {
            $("#menu").addClass("bg-red");
        } else {
            $("#menu").removeClass("bg-red");
        }
      });
