(function(){
	
	var listaBotonesEditar = document.querySelectorAll(".editarCategoria");
	listaBotonesEditar.forEach(item =>{
		item.addEventListener("click", e =>{
			document.getElementById('id').value = item.dataset.id;
			document.getElementById('txtNombre').value = item.dataset.nombre;
			document.getElementById('txtDescripcion').value = item.dataset.descripcion;
			$('#modalEditar').modal({show:true});
		})
		
	})
	
})();