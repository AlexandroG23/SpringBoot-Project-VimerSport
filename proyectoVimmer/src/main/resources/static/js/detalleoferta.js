(function(){
	
	var listaBotonesEditar = document.querySelectorAll(".editarDetalleOferta");
	listaBotonesEditar.forEach(item =>{
		item.addEventListener("click", e =>{
			document.getElementById('id').value = item.dataset.id;
			document.getElementById('cboProducto').value = item.dataset.producto;
			document.getElementById('cboOferta').value = item.dataset.oferta;
			document.getElementById('txtOferta_cantidad').value = item.dataset.oferta_cantidad;
			$('#modalEditar').modal({show:true});
			
		})
		
	})
	
})();