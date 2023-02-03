# Novi, Michigan Tour
I recently moved to Novi, Michigan and my friends were curious to see what Novi, as well as the surrounding area, has to offer. After completing a battery of courses provided by Google, I figured this would be a great time to demonstrate what I learned. This is the first project I completed that went beyond experimenting with no more than a handful of screens. This app was functional back in the middle of December, but I recently hammered out many bugs, refactored the code to be neater, and added some clean architecture elements. Please note that this app does NOT use data persistence, as I did not intend to practice it at the time.

There are three main features that can be found on the navigation bar: A home screen that displays categories relating to attractions in Novi and beyond. Clicking on a category will navigate to its associated and display a list of recommendations. Clicking yet again will navigate to the specific item, which features a picture, a direct link to its Google Maps page, and a save button. A saved screen that displays any saved recommendations. You can clear the entire list by pressing the "Clear List" button. Clicking on the saved item will take you to its associated page where you can individually remove it from your saves. A map screen that uses Google Maps API to display the location of recommendations in this app. There are boxes that can be checked to populate the map with whichever category you select, including the "saved" category.

## Demonstrations
Recommendations Feature  | Home Screenshot
------------- | -------------
<img src="https://user-images.githubusercontent.com/113391095/216476021-e0ad203c-a254-4ca4-ae08-abf1ee8142c3.gif" width = 400 height = 800>  |  <img src="https://user-images.githubusercontent.com/113391095/216476961-177226cd-08a9-48d1-a4ee-8cc85113d52c.png" width = 400 height = 800>

Google Maps Recommendation Feature  | Map Screenshot
------------- | -------------
| <img src="https://user-images.githubusercontent.com/113391095/216474419-7bbf529a-8872-4dcd-9267-418ff0792dc9.gif" width = 400 height = 800> | <img src="https://user-images.githubusercontent.com/113391095/216477118-d7f802ca-4704-4ae4-be05-24634e558990.png" width = 400 height = 800>
