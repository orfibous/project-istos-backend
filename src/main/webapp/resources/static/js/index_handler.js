var lastTestResult;

$(document).ready(function() {
	//Search Bar
	let input = document.getElementById("searchBar");
	let timeout = null;
	input.addEventListener('keyup', function(e) {
		clearTimeout(timeout);
		timeout = setTimeout(function() {
			//Call API to find movie
			resetDefaultView();
			requestMovieDataShort(input.value);
			lastTestResult = input.value;
			if (element === " More" + ' \u25B2 ') {
				requestMovieDataShort(lastTestResult);
			}
		}, 1000);
	});

	//Voting
	var image = document.getElementById('vote_selection');
		image.addEventListener('click', function() {
			change();
		});

	function change(){
		var initialPath = "/project_istos_backend_war_exploded/resources/static/images/";
		let path = "";
		if(image.getAttribute('src') === `${initialPath}save_bookmark.png`){
			path = `${initialPath}remove_bookmark.png`;
			image.src = path;
			image.style.filter = "drop-shadow(2px 2px 8px red)";
			image.alt = "dislike";
		}
		else {
			path = `${initialPath}save_bookmark.png`;
			image.src = path;
			image.style.filter = "drop-shadow(2px 2px 8px darkblue)";
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
			requestMovieDataLong(lastTestResult);
		}
		else {
			$("#more_info_button").text(" More" + down);
			$("#additional_information").slideUp();
			requestMovieDataShort(lastTestResult);
		}
	});

	//API Request Movie data with short plot
	function requestMovieDataShort(searchText) {
		if (searchText === " "){
			return ;
		}
		var request = new XMLHttpRequest();

		request.open('GET', `http://www.omdbapi.com/?apikey=6cece857&t=${searchText}`, true );

		request.send();

		//Access data here
		request.onload = function () {
			//parse JSON
			var data = JSON.parse(this.responseText);
			//check if a movie was found
			if (data.Error === "Movie not found!"){
				const title = document.getElementById('movie_name');
				title.innerHTML = "Movie not found!";
				return ;
			}
			//else check HTTP request response and print info
			if(request.status>= 200 && request.status < 400){
				const title = document.getElementById('movie_name');
				title.innerHTML = data.Title;
				const year = document.getElementById('year');
				year.innerHTML = data.Year;
				const genre = document.getElementById('genre');
				genre.innerHTML = data.Genre;
				const description = document.getElementById('description');
				description.innerHTML = data.Plot;
				description.style.color = "#FFFFFF";
				const imdb_rating = document.getElementById('imdb_rating');
				imdb_rating.innerHTML = data.imdbRating;
				const release_date = document.getElementById('release_date');
				release_date.innerHTML = data.Released;
				release_date.style.color = "#FFFFFF";
				const runtime = document.getElementById('runtime');
				runtime.innerHTML = data.Runtime;
				runtime.style.color = "#FFFFFF";
				const writer_names = document.getElementById('writer_names');
				writer_names.innerHTML = data.Writer;
				writer_names.style.color = "#FFFFFF";
				const director_names = document.getElementById('director_names');
				director_names.innerHTML = data.Director;
				director_names.style.color = "#FFFFFF";
				const actor_names = document.getElementById('actor_names');
				actor_names.innerHTML = data.Actors;
				actor_names.style.color = "#FFFFFF";
				const rated_value = document.getElementById('rated_value');
				rated_value.innerHTML = data.Rated;
				rated_value.style.color = "#FFFFFF";
				const language = document.getElementById('language');
				language.innerHTML = data.Language;
				language.style.color = "#FFFFFF";
				const country = document.getElementById('country');
				country.innerHTML = data.Country;
				country.style.color = "#FFFFFF";
				//change color based on score
				var scoreIMDB = parseFloat(data.imdbRating)*10;
				if (scoreIMDB <= 25){
					imdb_rating.style.color = "#ff0000";
				}
				else if( scoreIMDB <= 50){
					imdb_rating.style.color = "#ff9900";
				}else if(scoreIMDB <= 75){
					imdb_rating.style.color = "#ffff00";
				}else if(scoreIMDB >= 75){
					imdb_rating.style.color = "#009900";
				}
				const rt_rating = document.getElementById('rt_rating');
				rt_rating.innerHTML = data.Ratings[1].Value;
				//change color based on score
				var scoreRT = data.Ratings[1].Value.substr(0,data.Ratings[1].Value.length -1);
				//score = parseFloat(data.Ratings[1].Value);
				if (scoreRT <= 25){
					rt_rating.style.color = "#ff0000";
				}
				else if( scoreRT <= 50){
					rt_rating.style.color = "#ff9900";
				}else if(scoreRT <= 75){
					rt_rating.style.color = "#ffff00";
				}else if(scoreRT >= 75){
					rt_rating.style.color = "#009900";
				}
				const mc_rating = document.getElementById('mc_rating');
				mc_rating.innerHTML = data.Metascore;
				//change color based on score
				var scoreMC = parseFloat(data.Metascore);
				if (scoreMC <= 25){
					mc_rating.style.color = "#ff0000";
				}
				else if(scoreMC <= 50){
					mc_rating.style.color = "#ff9900";
				}else if(scoreMC <= 75){
					mc_rating.style.color = "#ffff00";
				}else if(scoreMC >= 75){
					mc_rating.style.color = "#009900";
				}
				const image = document.getElementById('no_image');
				image.src = data.Poster;

			}else{
				console.log("error");
			}
		};
	}
	//API Request Movie data with long plot
	function requestMovieDataLong(searchText) {
		if (searchText === ""){
			return ;
		}
		var request = new XMLHttpRequest();

		request.open('GET', `http://www.omdbapi.com/?apikey=6cece857&t=${searchText}&plot=full`, true );

		request.send();

		//Access data here
		request.onload = function () {
			//parse JSON
			var data = JSON.parse(this.responseText);
			//check if a movie was found
			if (data.Error === "Movie not found!"){
				const title = document.getElementById('movie_name');
				title.innerHTML = "Movie not found!";
				return ;
			}
			//else check HTTP request response and print info
			if(request.status>= 200 && request.status < 400){
				const description = document.getElementById('description');
				description.innerHTML = data.Plot;
				description.style.color = "#FFFFFF";
			}else{
				console.log("error");
			}
		};
	}

	function resetDefaultView() {
		const title = document.getElementById('movie_name');
		title.innerHTML = "MOVIE NAME";
		const year = document.getElementById('year');
		year.innerHTML = " (YEAR) ";
		const genre = document.getElementById('genre');
		genre.innerHTML = " (GENRE) ";
		const description = document.getElementById('description');
		description.innerHTML = "NO DESCRIPTION AVAILABLE";
		description.style.color = "#ff0000";
		const imdb_rating = document.getElementById('imdb_rating');
		imdb_rating.innerHTML = "0.0";
		imdb_rating.style.color = "#ff0000";
		const release_date = document.getElementById('release_date');
		release_date.innerHTML = "DD / MM / YYYY";
		release_date.style.color = "#ff0000";
		const runtime = document.getElementById('runtime');
		runtime.innerHTML = "0 min";
		runtime.style.color = "#ff0000";
		const writer_names = document.getElementById('writer_names');
		writer_names.innerHTML = "NO WRITER NAMES AVAILABLE";
		writer_names.style.color = "#ff0000";
		const director_names = document.getElementById('director_names');
		director_names.innerHTML = "NO DIRECTOR NAMES AVAILABLE";
		director_names.style.color = "#ff0000";
		const actor_names = document.getElementById('actor_names');
		actor_names.innerHTML = "NO ACTOR NAMES AVAILABLE";
		actor_names.style.color = "#ff0000";
		const rated_value = document.getElementById('rated_value');
		rated_value.innerHTML = "NOT RATED";
		rated_value.style.color = "#ff0000";
		const language = document.getElementById('language');
		language.innerHTML = "UNDEFINED";
		language.style.color = "#ff0000";
		const country = document.getElementById('country');
		country.innerHTML = "UNDEFINED";
		country.style.color = "#ff0000";
		const rt_rating = document.getElementById('rt_rating');
		rt_rating.innerHTML = "0%"
		rt_rating.style.color = "#ff0000";
		const mc_rating = document.getElementById('mc_rating');
		mc_rating.innerHTML = "0";
		mc_rating.style.color = "#ff0000";

		const image = document.getElementById('no_image');
		image.src = "/project_istos_backend_war_exploded/resources/static/images/no_image.jpg";
	}

});