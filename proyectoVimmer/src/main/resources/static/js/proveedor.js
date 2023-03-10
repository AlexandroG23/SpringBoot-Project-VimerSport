(function(){
	
	var listaBotonesEditar = document.querySelectorAll(".editarProveedor");
	listaBotonesEditar.forEach(item =>{
		item.addEventListener("click", e =>{
			document.getElementById('id').value = item.dataset.id;
			document.getElementById('txtNombre').value = item.dataset.nombre;
			document.getElementById('txtDireccion').value = item.dataset.direccion;
			document.getElementById('txtTelefono').value = item.dataset.telefono;
			$('#modalEditar').modal({show:true});
		})
		
	})
	
})();