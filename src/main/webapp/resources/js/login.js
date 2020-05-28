$(function() {
	var button = $('#login_button');
	var box = $('#login_dropdown_box');
	var form = $('#login_form');
	button.removeAttr('href');
	button.mouseup(function(login) {
		box.toggle();
		button.toggleClass('active');
	});
	form.mouseup(function() {
		return false;
	});
	$(this).mouseup(function(login) {
		if(!($(login.target).parent('#login_button').length > 0)){
			button.removeClass('active');
			box.hide();
		}
	});
});