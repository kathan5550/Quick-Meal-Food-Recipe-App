# Quick-Meal-Food-Recipe-App

# Description
The QuickMeal Java Recipe App is a versatile application developed in Java, leveraging the powerful capabilities of the Spoonacular API to provide users with a comprehensive collection of recipes. This app is designed to streamline the meal planning process by offering quick and easy access to a wide range of dishes suitable for various dietary preferences and cooking preferences.

# App Features

1. Spoonacular API Integration: Utilizes the Spoonacular API to fetch a vast array of recipes, including details such as ingredients, instructions, nutritional information, and more.
2. User-friendly Interface: The app boasts an intuitive and visually appealing user interface, making recipe browsing and selection a seamless experience.
3. Search and Filter Functionality: Allows users to search for recipes based on keywords, ingredients, cuisines, dietary restrictions, and meal types. Filter options enable precise recipe discovery.
4. Recipe Details: Provides detailed information for each recipe, including ingredients, step-by-step instructions, cooking time, serving size, and nutritional facts.
5. Offline Access: Supports offline access to previously viewed recipes, ensuring users can access their favorite dishes without an internet connection.
6. User Reviews and Ratings: Users can view and contribute reviews and ratings for recipes, fostering community engagement and providing valuable feedback.
7. Responsive Design: Built with responsiveness in mind, ensuring optimal performance across various devices and screen sizes.

# Introduction
The QuickMeal Java Recipe App utilizes the Spoonacular API to provide users with a wide range of recipes. The Spoonacular API offers comprehensive recipe data, including ingredients, instructions, nutritional information, and more.

# API key usage
To use the Spoonacular API in this project, follow these steps:

1. Sign up for a Spoonacular API key at https://spoonacular.com/food-api.
2. Replace `YOUR_API_KEY` in the code with your actual API key.
3. Use the provided code snippets to initialize the API client and make requests to fetch recipes.
4. Once you have your API key, you have to put it in the request URL for every request you make like so ?apiKey=YOUR-API-KEY.

# Attention:
Only the first query parameter is prefixed with a ? (question mark), all subsequent ones will be prefixed with a & (ampersand). That is how URLs work and nothing related to our API. Here's a full example with two parameters apiKey and includeNutrition: https://api.spoonacular.com/recipes/716429/information?apiKey=YOUR-API-KEY&includeNutrition=true.

Just so you know, parameters are case-sensitive, it is apiKey, not spiky.
Alternatively, you can put the API key in the request header as x-api-key.

This is my API Key which I had developed on the Spoonacular Food API platform. You guys can visit the Spoonacular API website. There are different varieties of great food recipes that you can try to make the recipe applications. I gave the link to the website where they have various food products, ingredients, recipes, and Menu items.
This is My apikey :1ab20968a21c42f081fce44fd36b1574

# App Visuals
<img width="301" alt="Screenshot 2024-02-19 at 11 39 13 AM" src="https://github.com/kathan5550/Quick-Meal-Food-Recipe-App/assets/105222761/94813d69-23ef-4164-9f1d-54ee5bddd4f7">   <img width="313" alt="Screenshot 2024-02-19 at 11 24 09 AM" src="https://github.com/kathan5550/Quick-Meal-Food-Recipe-App/assets/105222761/b847ca90-6b2e-4da7-985d-91622044349d">
<img width="295" alt="Screenshot 2024-02-22 at 10 29 48 AM" src="https://github.com/kathan5550/Quick-Meal-Food-Recipe-App/assets/105222761/25ba1ff0-1c59-44ab-9633-d60b601e30b1">
