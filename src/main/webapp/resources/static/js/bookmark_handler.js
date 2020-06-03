//Since there are going to be more than one bookmarks, index config is important! This is an example for one bookmark only.
$(document).ready(function() {
	var remove_bookmark_button = document.getElementsByClassName('remove_bookmark');
	var bookmark_box = document.getElementsByClassName('single_bookmark_box');
	//console.log(remove_bookmark_button.length);
	//console.log(bookmark_box.length);
	for (var i = 0; i < remove_bookmark_button.length; i++) {
		(function(index) {
			//This is where the bookmark removal will take place
			remove_bookmark_button[i].onclick = function(){
				bookmark_box[index].style.display = "none";
			}
		})(i);
		console.log(remove_bookmark_button.length);
	}
	console.log(remove_bookmark_button.length);
	if(remove_bookmark_button.length === 0){
		var empty_bookmark_list = document.getElementById('no_bookmarks');
		empty_bookmark_list.style.display = "inline";
	}
});