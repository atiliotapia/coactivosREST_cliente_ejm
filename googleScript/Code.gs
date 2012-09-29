function onOpen() { 
  
  var ss = SpreadsheetApp.getActiveSpreadsheet()
      var menuNuevo =  [
                        {name: "Listado de Deudores", functionName: "coactivosRest"},
                        {name: "Enviar Correo a Deudores", functionName: "enviarCorreo"},
                        {name: "Funcion A", functionName: "funcionA"}, 
                        {name: "Funcion B", functionName: "funcionB"}
                        
                       ]
          ss.addMenu("Sistemas Distribuidos (Prof:JoeDayz) ", menuNuevo)
      
}

function coactivosRest() { 

var fields = {'id':true,'direccion':true,'complementoIdMoneda':true,
              'complemento':true,'nroIdentificacion':true,'idEstadoDeuda':true,
              'idDistrito':true,'descripcion2':true,'descripcion1':true,
              'idExterno':true,'saldo':true};
var options = {}  
var result = UrlFetchApp.fetch("http://rest-coactivos.aesoluciones.cloudbees.net/rs/cliente-service/clientes.json", options);
  var o  = Utilities.jsonParse(result.getContentText());
  var doc = SpreadsheetApp.getActiveSpreadsheet();
  var cell = doc.getRange('a2');
  var index = 0;


  for (var i in o) {
    var row = o[i];
    
    for (var x1 in row) {      
      var row2 = row[x1];      
      //Browser.msgBox("row2")   
      
      for (var x2 in row2) {      
      var row3 = row2[x2];
      //Browser.msgBox("row3")   
        
      for (var x3 in row3) {      
      var row4 = row3[x3];
      //Browser.msgBox("row4")   
        
      var col = 0;
      for (var j in row4) {
        
        
        if (fields[j]) {          
          
          cell.offset(index, col).setValue(row4[j]);
          col++;
        }        
         }
      index++;      
       }
      
      }
      
    }
    
  }
}

function enviarCorreo() {  
  var sheet =  SpreadsheetApp.getActiveSpreadsheet()
      var cell =  sheet.getRange("A2:K10")
  var value = cell.getValue()
             
             MailApp.sendEmail("atilio.tapia@gmail.com, jhonathan.lmg@gmail.com, vidasaor@gmail.com, 

eescobar.dev@gmail.com", "Municipio SJM", value)                               
  
}

function funcionA() {  
  Browser.msgBox("Hola Alumno");   
  
}

function funcionB() {  
  Browser.msgBox("Hola Profesor");   
  
}


function myFunction() {  
  Browser.msgBox("Grupo UPC- Sistemas Distribuidos 2012 ");  
  
  //var ss = SpreadsheetApp.getActiveSpreadsheet()
      //var subMenu = 
}
  

