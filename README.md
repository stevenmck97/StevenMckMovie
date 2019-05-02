# StevenMckMovie

App Description
The purpose of this app is to allow the user to create, read, update, and delete movies from a movie list. It provides details such as the movie title, movie description, and a related image to the movie. The app also provides the user with the ability to add their own images from their android phone’s gallery and use it as a thumbnail image when viewing the entries in their movie list. The app is fully persistent with the use of JSON and has simple validation.

Motivation for Creating the App
I always found myself wanting an app which allowed me to quickly create a movie list and store movies. While there are plenty of better alternatives on the store, I somehow never quite got around to downloading any of them. Realizing the potential of the app by largely basing its code and design off of the code provided in the labs, I decided to develop the movie list app.

App Architecture
App architecture was an integral in the development of the application. It was important to have an app which was both visually appealing, simple to use, and extremely intuitive so as not to cause any confusion. To aid in my endeavor for a functional, simplistic, and appealing app, I followed a set of heuristics developed by User Experience experts. These heuristics include:
•	User control and freedom (Jakob Nielsen) - Easy navigation was a necessity in my design, the users had to be able to easily find all of the information they need. I achieved this through a simplistic design.

•	Recognition rather than recall (Jakob Nielsen) – This was done to keep the app intuitive to the user. For example, using a plus icon to indicate adding an entry to the list and also the placement of the icon in the top right corner of the screen as for users who frequent similar apps and technology, this is usually where the plus icon is displayed. I also opted to have the image from the movie display along side its title and description in the list so as to allow for instant recognition.

•	Aesthetic and minimalist design (Jakob Nielsen) – It was essential that everything displayed on screen was entirely relevant to the user and the experience they expected to have while using the app. Any extra, unnecessary pieces of information or options displayed can potentially minimize a user’s relative visibility. Because of this I opted to remove Google maps API integration as it was irrelevant to the experience the user expected.

Following the above guidelines I was able to develop a user-friendly, intuitive, and functional app.

App Context
The app was developed entirely for the convenience of use, with easy access and minimal data entry to make use of the app. Many movie list apps like imdb and similar apps require the user to make an account before offering their services. My app offers no such functionality as I wished for the user to gain access to their list as quickly as possible without any potential hindrances such as forgetting their password. Many related apps on the play store also offer increased functionality such as statistics within the app. However, this often comes at the price of ads being prevalent within the application, and often the only way to remove the ads being by making a once off payment. While my app has less functionality, it is at least entirely focused on the user experience.

Future Developments
Ideally, I would like to add a search button so that a user can search through their lists. I would also like to give users the option to sort their movies into different categories so as to manage their lists more efficiently. A watched-list and plan-to-watch list would also be ideal as it would allow users to keep track of what they want to watch and what they have already watched. Ultimately, I would like to connect to themovedb website API to give users additional information as they search for movies which may be suited to their tastes.
