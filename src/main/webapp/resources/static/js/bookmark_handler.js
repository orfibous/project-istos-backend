//Since there are going to be more than one bookmarks, index config is important! This is an example for one bookmark only.
$(document).ready(function() {
    //Get All bookmark IDs
    var myBookmarks = document.getElementsByClassName("single_bookmark_box");
    for (var i = 0; i< myBookmarks.length; i++){
        console.log(myBookmarks[i].id);
        requestMovieDataShort(myBookmarks[i].id,myBookmarks[i],i+1);
    }

    // //Voting
    // var remove_bookmark_button = document.getElementsByClassName('remove_bookmark');
    // // function(index) {
    //     remove_bookmark_button[index].onclick = function () {
    //
    //         var movieID = document.getElementsByClassName("single_bookmark_box")[index].id;
    //         removeBookmark(movieID);
    //         console.log("Index: ", index);
    //         $('.single_bookmark_box').eq(index).remove();
    //         if (bookmark_box.length === 0) {
    //             var empty_bookmark_list = document.getElementById('no_bookmarks');
    //             empty_bookmark_list.style.display = "inline";
    //         }
    //     }
    // // }

});

    // var bookmark_box = document.getElementsByClassName('single_bookmark_box');
    // for (var i = 0; i < remove_bookmark_button.length; i++) {
    //     (function(index) {
    //         //This is where the bookmark removal will take place
    //         remove_bookmark_button[index].onclick = function(){
    //             var movieID = document.getElementsByClassName("single_bookmark_box")[index].id;
    //             removeBookmark(movieID);
    //             console.log("Index: ",index);
    //             $('.single_bookmark_box').eq(index).remove();
    //             //console.log(bookmark_box.length);
    //             if(bookmark_box.length === 0){
    //                 var empty_bookmark_list = document.getElementById('no_bookmarks');
    //                 empty_bookmark_list.style.display = "inline";
    //             }
    //         }
    //     })(i);


//API Request Movie data with long plot
function requestMovieDataShort(searchText, container, counter) {
    if (searchText === ""){
        return ;
    }
    var request = new XMLHttpRequest();

    request.open('GET', `http://www.omdbapi.com/?apikey=6cece857&i=${searchText}`, true );

    request.send();

    //Access data here
    request.onload = function () {
        //Change Bookmark number
        container.getElementsByClassName("bookmark_counter")[0].innerHTML= counter;
        //parse JSON
        var data = JSON.parse(this.responseText);
        //check if a movie was found
        if (data.Error === "Movie not found!"){
            const movie_name_label = container.getElementsByClassName('movie_name_label')[0];
            movie_name_label.innerHTML = "Movie not found!";
            return ;
        }
        //else check HTTP request response and print info
        if(request.status>= 200 && request.status < 400){
            const movie_name_label = container.getElementsByClassName('movie_name_label')[0];
            movie_name_label.innerHTML = data.Title;
            const year = container.getElementsByClassName('year')[0];
            year.innerHTML = data.Year;
            const genre = container.getElementsByClassName('genre')[0];
            genre.innerHTML = data.Genre;
            const director_name = container.getElementsByClassName('director_name')[0];
            director_name.innerHTML = data.Director;
            const actor_names = container.getElementsByClassName('actor_names')[0];
            actor_names.innerHTML = data.Actors;
            const description = container.getElementsByClassName('description')[0];
            description.innerHTML = data.Plot;
            const image = container.getElementsByClassName('image_placeholder')[0];
            image.src = data.Poster;
        }else{
            console.log("error");
        }
    };
}

function addBookmark(movieID){
    $.ajax({
        type:'Post',
        url : 'addBookmark',
        contentType: "application/json",
        data: JSON.stringify(movieID),
        dataType: 'json',
        success : function(movieID) {
            console.log(movieID+'added bookmark')
        },
        error: function () {
            console.log("Failed to add Bookmark")
        }
    });
}

function removeBookmark(movieID){
    console.log(movieID);
    $.ajax({
        type:'Post',
        url : 'removeBookmark',
        contentType: "application/json",
        data: JSON.stringify(movieID),
        dataType: 'json',
        success : function(movieID) {
            console.log(movieID+'removed bookmark')
        },
        error: function () {
            console.log("Failed to remove Bookmark")
        }
    });
}