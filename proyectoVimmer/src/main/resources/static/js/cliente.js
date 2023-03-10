(function(){
	
	var listaBotonesEditar = document.querySelectorAll(".editarCliente");
	listaBotonesEditar.forEach(item =>{
		item.addEventListener("click", e =>{
			document.getElementById('id').value = item.dataset.id;
			document.getElementById('cboDistrito').value = item.dataset.distrito;
			document.getElementById('txtCorreo').value = item.dataset.correo;
			document.getElementById('txtNombre').value = item.dataset.nombre;
			document.getElementById('txtApellido').value = item.dataset.apellido;
			$('#modalEditar').modal({show:true});
			
		})
		
	})
	
})();