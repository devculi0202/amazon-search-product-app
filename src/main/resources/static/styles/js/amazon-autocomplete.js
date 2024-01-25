$(document).ready(function () {
  var searchBox = document.getElementById("search-box");
  var autocompleteContainer = document.querySelector(
      ".autocomplete-results-container");
  var suggestionTrendingContainer = document.getElementById(
      "s-suggestion-trending-container");
  var childDivs = suggestionTrendingContainer.querySelectorAll(
      ".suggestion-trending-container");
  searchBox.addEventListener("mouseover", function () {
    autocompleteContainer.style.display = "block"
    suggestionTrendingContainer.style.display = "block";
    childDivs.forEach(function (div) {
      div.style.display = "block";
    });
  });
  searchBox.addEventListener("input", function () {

    // Get the value entered by the user
    var searchText = searchBox.value;
    autocompleteContainer.style.display = searchText ? "block" : "none";
    suggestionTrendingContainer.style.display = "none";
    // Call your API function with the search text
    if (searchText !== "") {
        invokeAPI(searchText, "autocomplete-results");
    }
  });

  function invokeAPI(searchText, containerId, callback) {
    fetch(
        "http://localhost:8080/search/autocomplete?term=" + encodeURIComponent(
            searchText))
    .then(response => response.json())
    .then(result => {
      const suggestions = result.map(item => item.suggestion);

      // Update the content of the specified container with the suggestions
      const container = document.getElementById(containerId);
      container.innerHTML = ""; // Clear existing content

      suggestions.forEach(suggestion => {
        console.log(suggestion);
        const resultDiv = document.createElement("div");
        resultDiv.className = "results";
        resultDiv.textContent = suggestion;
        container.appendChild(resultDiv);
      });
    })
    .catch(error => console.error('Error fetching data:', error));
  }
});