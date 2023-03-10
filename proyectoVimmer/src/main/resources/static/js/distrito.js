(function(){
	
	var listaBotonesEditar = document.querySelectorAll(".editarDistrito");
	listaBotonesEditar.forEach(item =>{
		item.addEventListener("click", e =>{
			document.getElementById('id').value = item.dataset.id;
			document.getElementById('txtNombre').value = item.dataset.nombre;
			document.getElementById('txtPostal').value = item.dataset.postal;
			$('#modalEditar').modal({show:true});
		})
		
	})
	
})();