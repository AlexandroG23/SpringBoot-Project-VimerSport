(function(){
	
	var listaBotonesEditar = document.querySelectorAll(".editarOferta");
	listaBotonesEditar.forEach(item =>{
		item.addEventListener("click", e =>{
			document.getElementById('id').value = item.dataset.id;
			document.getElementById('txtTipoOferta').value = item.dataset.tipo_oferta;
			$('#modalEditar').modal({show:true});
		})
		
	})
	
})();