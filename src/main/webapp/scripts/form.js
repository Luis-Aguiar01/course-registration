document.getElementById('course-form').addEventListener('submit', (e) => {
	const checkboxes = document.querySelectorAll('input[type="checkbox"]');
	const isChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);
	
	if (!isChecked) {
		e.preventDefault();
		alert('Selecione pelo menos um curso para enviar o formulário.');
	}
});