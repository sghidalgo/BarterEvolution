var opcionestipous = {
    "NN":[" "],
    "A": ["Administrador"],
    "E": ["Empleado"],
    "C": ["Cliente"]

  }
  function cambioOpcionestipus()
  {
    var combo = document.getElementById('opcionestipous');
    var opcion = combo.value;
     
    document.getElementById('idtusuario').value = opcionestipous[opcion][0];
    document.getElementById('administrador').value = opcionestipous[opcion][1];
    document.getElementById('empleado').value = opcionestipous[opcion][2]; 
    document.getElementById('cliente').value = opcionestipous[opcion][3]; 
  }