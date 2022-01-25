$(document).ready(function(){
  var validator = $("#formRastreio").bootstrapValidator({
    feedbackIcons: {
      valid: "glyphicon glyphicon-ok",
      invalid: "glyphicon glyphicon-remove",
      validating: "glyphicon glyphicon-refresh"
    },
    fields : {
      id_encomenda :{
        validators :{
          notEmpty : {
            message: "Tag Id da Encomenda é obrigatório"
          },
          regexp : {
            regexp: /^[a-zA-Z0-9]+$/i,  
            message: "Por favor, somente letras ou numeros"
          }
        }
      },
    }
  }).on("success.form.bv", function (e) {
		e.preventDefault();
	});
});

$(document).ready(function(){
  var validator = $("#formAtualizarRastreio").bootstrapValidator({
    feedbackIcons: {
      valid: "glyphicon glyphicon-ok",
      invalid: "glyphicon glyphicon-remove",
      validating: "glyphicon glyphicon-refresh"
    },
    fields : {
      id_encomenda :{
        validators :{
          notEmpty : {
            message: "Tag Id da Encomenda é obrigatório"
          },
          regexp : {
            regexp: /^[a-zA-Z0-9]+$/i,  
            message: "Por favor, somente letras ou numeros"
          }
        }
      },
      }
  }).on("success.form.bv", function (e) {
		e.preventDefault();
	});
});


