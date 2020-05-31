$(document).ready(function() {
	//Search Bar
	let input = document.getElementById("searchBar");
	let timeout = null;
	input.addEventListener('keyup', function(e) {
		clearTimeout(timeout);
		timeout = setTimeout(function() {
			//THIS IS WHERE THE INFORMATION MUST BE UPDATED VIA THE API.
			var movie = document.getElementById("movie_name");
			movie.innerHTML = input.value;
		}, 1000);
	});

	//Voting
	var image = document.getElementById('vote_selection');
		image.addEventListener('click', function() {
			change();
		});

	function change(){
		var initialPath = "/project_istos_backend_war_exploded/resources/static/images/"
		if(image.getAttribute('src') == `${initialPath}like.png`){
			var path = `${initialPath}dislike.png`;
			image.src = path;
			image.style.filter = "drop-shadow(2px 2px 8px red)";
			image.alt = "dislike";
		}
		else {
			var path = `${initialPath}like.png`;
			console.log(path);
			image.src = path;
			image.style.filter = "drop-shadow(2px 2px 8px lightgreen)";
			image.alt = "like";
		}
	}

	//More Info
	$("#more_info_button").click(function() {
		var element = $("#more_info_button").text();
		var down = ' \u25BC ';
		var up = ' \u25B2 ';
		if (element === " More" + down) {
			$("#more_info_button").text(" Less" + up);
			$("#additional_information").slideDown();
		}
		else {
			$("#more_info_button").text(" More" + down);
			$("#additional_information").slideUp();
		}
	});
});