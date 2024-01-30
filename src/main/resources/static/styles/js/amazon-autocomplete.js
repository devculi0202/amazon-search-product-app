$(document).ready(function () {
  var searchBox = document.getElementById("search-box");
  var autocompleteContainer = document.querySelector(
      ".autocomplete-results-container");
  var suggestionTrendingContainer = document.getElementById(
      "s-suggestion-trending-container");
  var childDivs = suggestionTrendingContainer.querySelectorAll(
      ".suggestion-trending-container");
  var dropdown = document.getElementById("myDropdown");
  var textWrapper = document.querySelector(".text-wrapper-3");
  var autoCompleteResults = document.getElementById("autocomplete-results");

  searchBox.addEventListener("mouseover", function () {
    autocompleteContainer.style.display = "block";
    suggestionTrendingContainer.style.display = "block";
    autoCompleteResults.style.display = "none";
    childDivs.forEach(function (div) {
      div.style.display = "block";
    });
  });

  /** invoke api autocomplete amazon*/
  searchBox.addEventListener("input", function () {
    // Get the value entered by the user
    var searchText = searchBox.value;
    autocompleteContainer.style.display = searchText ? "block" : "none";
    suggestionTrendingContainer.style.display = "none";
    autoCompleteResults.style.display = "block";
    // Call your API function with the search text
    if (searchText !== "") {
      var selectedOption = dropdown.options[dropdown.selectedIndex];
      // Get the value of the selected option
      var selectedValue = selectedOption.value.replace("search-alias=","");
      invokeAPI(selectedValue, searchText, "autocomplete-results");
    }
  });

  function invokeAPI(category, searchText, containerId, callback) {
    fetch(
        "http://localhost:8080/search/autocomplete?category=" + category
        + "&term=" + encodeURIComponent(
            searchText))
    .then(response => response.json())
    .then(result => {
      const suggestions = result.map(item => item.value);

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

  // Add a change event listener to the dropdown
  dropdown.addEventListener("change", function () {
    // Update the text of the text-wrapper-3 div with the selected option's text
    textWrapper.textContent = dropdown.options[dropdown.selectedIndex].text;
  });

  document.addEventListener('click', function (event) {
    var myContainer = document.getElementById('home-container');
    // Check if the clicked element is not the input or inside the container
    if (!searchBox.contains(event.target)) {
      autocompleteContainer.style.display = "none"
    }
  });
});


