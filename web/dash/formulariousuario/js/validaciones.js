(function() {
    'use strict';
    window.addEventListener('load', function() {
      //Obtenga todos los formularios a los que queremos aplicar estilos personalizados de validación Bootstrap
      var forms = document.getElementsByClassName('needs-validation');
      
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();