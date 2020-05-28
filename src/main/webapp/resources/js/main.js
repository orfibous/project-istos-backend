//When user clicks "Login" toggle between hiding and showing the content
function dropdown_login_menu(){
	document.getElementById("dropdown_login").classList.toggle("show");
}

//Close Login if user clicks elsewhere
window.onclick = function(event){
	if(!event.target.matches('.selection')){
		var dropdowns = document.getElementByClassName("dropdown-content");
	}
}