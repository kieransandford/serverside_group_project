# serverside_group_project

## Project Title: Pokeverse
The main goal of our project was to build a functioning back-end framework using **Java**, **Spring Boot** and an **SQL database**.
We have achieved this by creating a virtual space for Pokemon Trainers and their Pokemon, with the ability to edit data and encourage a more social space through certain features.

### Project Description

#### WHAT OUR APPLICATION DOES:
- For both the Pokemon and Trainer classes there are **CRUD methods**, allowing the user to modify the data held by the API:

[POKEMON CRUD]
[TRAINER CRUD]

- **QUERIES**:

Find Pokemon by type:
[SCREENSHOT]

Find Trainer by town:
[SCREENSHOT]

Generate random Pokemon:
[SCREENSHOT]

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
- Ideally, we would like to flesh out our business framework where the user could purchase Pokemon as a Trainer
- Create a specific query for evolving a Pokemon which is hooked to the PokemonController

#### IDEAS FOR THE FRONT END:
- Use the randomly generated Pokemon query to highlight the "Pokemon of the Day"
- Use the find trainers by town query to "Find Trainers Near You"

### How to Install + Run the Project
- Git clone the project to your own system
- Make sure that the application is running before trying to access Swagger + H2
- Our data.sql file can only be connected through H2

## CREDITS:
- [Rebecca Bartholomew](https://github.com/Becca-20)
- [Michelle Tambi](https://github.com/michelletambi)
- [Kieran Sandford](https://github.com/kieransandford)
- [Naeem Khan](https://github.com/nkhan24)
