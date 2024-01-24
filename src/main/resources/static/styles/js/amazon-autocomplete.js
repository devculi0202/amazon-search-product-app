$(document).ready(function (){
    var searchBox = document.getElementById("search-box");
    var autocompleteContainer = document.querySelector(".autocomplete-results-container");
    var suggestionTrendingContainer = document.querySelector(".suggestion-trending-container");
    searchBox.addEventListener("mouseover", function () {
        autocompleteContainer.style.display = "block"
        suggestionTrendingContainer.style.display = "block";
    });
    searchBox.addEventListener("input", function () {
        // Get the value entered by the user
        var searchText = searchBox.value;
        autocompleteContainer.style.display = searchText ? "block" : "none";
        // Call your API function with the search text
        invokeAPI(searchText);
    });

    function invokeAPI(searchText) {
        $.getJSON("http://localhost:8080/search/autocomplete?term="+searchText, function (result){
            $.each(result,function (key,value){
                console.log(value.suggestion);
            });
        });
    }


});