var opcionestipodoc = {
  "NN":[" "],
  "CC": ["Cédula de ciudadania"],
  "CE": ["Cédula de extranjeria"]
}
function cambioOpcionestipdoc()
{
  var combo = document.getElementById('opcionestipodoc');
  var opcion = combo.value;
   
  document.getElementById('idtdocumento').value = opcionestipodoc[opcion][0];
  document.getElementById('ciudadania').value = opcionestipodoc[opcion][1];
  document.getElementById('extranjeria').value = opcionestipodoc[opcion][2]; 
  
}