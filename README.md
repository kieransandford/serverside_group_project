# serverside_group_project

## Project Title: Pokeverse
The main goal of our project was to build a functioning back-end framework using **Java**, **Spring Boot** and an **SQL database**.
We have achieved this by creating a virtual space for Pokemon Trainers and their Pokemon, with the ability to edit data and encourage a more social environment through certain features.

### Project Description

#### WHAT OUR APPLICATION DOES:
- For both the Pokemon and Trainer classes there are **CRUD methods**, allowing the user to modify the data held by the API:

- [x] CREATE -> `POST`
- [x] READ -> `GET`
- [x] UPDATE -> `PUT`
- [x] DELETE -> `DELETE`

##### Pokemon:
![image](https://user-images.githubusercontent.com/102289720/170242125-960d9bf0-8040-40ec-8332-c7e6b4e320e8.png)

##### Trainer:
![image](https://user-images.githubusercontent.com/102289720/170250617-6ca0a0e0-ec0d-4c2c-8c17-ac3f4fa8b4f6.png)  

- **QUERIES**:
     
***Find Trainer by town:***  
(**TrainerController** class)  
![image](https://user-images.githubusercontent.com/102289720/170244819-2689ff53-7c63-46d6-ae09-0baac09e9ad4.png)  

(**TrainerRepository** interface)  
![image](https://user-images.githubusercontent.com/102289720/170244889-253d5ebc-4041-47cf-acf7-fbe698b37794.png)  
   
***Generate random Pokemon:***   
(**PokemonController** class)  
![image](https://user-images.githubusercontent.com/102289720/170245455-8717cc74-05bd-42b5-9fa6-49698bb3356d.png)  
  
(**PokemonRepository** interface)  
![image](https://user-images.githubusercontent.com/102289720/170245627-d444bfdf-6b61-4187-93d5-7fc5740e5fa7.png) 

- **BUSINESS LOGIC**:  
- We decided to add some business logic to our API, by allowing Trainers to purchase Pokemon with funds from their wallet.  
(**Business** class)  
![image](https://user-images.githubusercontent.com/102289720/170253659-91292f0b-259c-4ba6-a045-80470559329a.png)  

   
#### WHY WE USED CERTAIN TECHNOLOGIES:
- [Swagger](https://swagger.io/) : This made it easy to see and test our CRUD methods
- [H2](http://www.h2database.com/html/quickstart.html) : This was our preferred method as a group to test the connection and routes with our database (data.sql file)
- [enums](https://www.w3schools.com/java/java_enums.asp): We used this for the Pokemon Generation field, to ensure that the only input allowed would be what we have classified in the enum. Every Pokemon has a specific Generation (from 1 to 9), and so it made sense to make these values fixed.
- [testing](https://www.w3schools.blog/junit-tutorial): We made sure that we included the junit testing dependency to our pom.xml file in order to test our methods and overall functionality throughout the development of our API  

#### CHALLENGES WE FACED:
- Working with **enums** was initially pretty tricky as we had multiple fields within each enum to work with, but after some research we managed to get them functioning successfully.
- Initially we were wary of **git branching and merging** our changes to the main branch, but as development progressed, we became more comfortable with this concept.
- Our **CRUD methods** would sporadically work and then not work, so it was a constant process of debugging and testing to make sure that our API remained functional.

#### FEATURES WE HOPE TO IMPLEMENT IN THE FUTURE:
- Use polymorphism for the Pokemon: Pokemon superclass which then has "Ordinary" and "Rare" subclasses inheriting properties from it (possible inclusion of the use of method overloading)
- Create a method which ensures that all transactions associated with the business logic (when a Trainer purchases a pokemon) gets automatically written into a text file as a financial invoice

#### IDEAS FOR THE FRONT END:
- Use the randomly generated Pokemon query to highlight the "Pokemon of the Day"
- Use the find trainers by town query to "Find Trainers Near You"
- Have a "marketplace" for Trainers to view and purchase all available Pokemon

### How to Install + Run the Project
- Git clone the project to your own system
- Make sure that the application is running before trying to access Swagger + H2
- Our data.sql file can only be connected through H2

## CREDITS:
- [Rebecca Bartholomew](https://github.com/Becca-20)
- [Michelle Tambi](https://github.com/michelletambi)
- [Kieran Sandford](https://github.com/kieransandford)
- [Naeem Khan](https://github.com/nkhan24)
