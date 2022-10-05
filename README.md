<p align="center">
<img src="https://sauvageboris.fr/training/javaee/recipeEE/resources/logo/100.png"/>
</p>

# Yolibeob<img src="https://cdn-icons-png.flaticon.com/512/599/599503.png" width="26" height="26" />

[![forthebadge](https://forthebadge.com/images/badges/powered-by-coffee.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/uses-git.svg)](https://forthebadge.com)

## What is Yolibeob

Yolibeob or 요리법 is a web site where you can share your recipes with everybody !

It use a database which will store all recipes and ingredients added by a connected user.

In there, you'll need to create an account to be able to create or delete a recipe but for people who don't want to be registed, you'll be able to read every recipes without any problem !

## How to use

### Step 1

- In the persistence.xml put your SGBD informations where you see "TO EDIT"
```java
<property name="hibernate.connection.user" value="TO EDIT"/>
            <property name="hibernate.connection.password" value="TO EDIT"/>
            <property name="hibernate.connection.url"
                      value="jdbc:mysql://localhost:TO EDIT/yolibeob"/> 
```
- The first value to change is your SGBD username, then the password and the localhost port number.

### Step 2

- Go to /populate

### Step 3

- Go to /home

You're ready to use Yolibeob ! <br>
Bon appétit !

## Features

### While not connected :

- View a list of all recipes
- Read a selected recipe

### While connected :

- All features listed above
- View a list of recipes by category (example : Dessert only)
- Add a recipe
- Delete a recipe
- Manage your account

### Comming Soon :

- Search a recipe by keywords (Muffin, Burger...)
- Request a random recipe (based on time and history less than 6 days)

## Tools
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 

### Using :

* [<img src="https://ubuntuhandbook.org/wp-content/uploads/2017/07/intellij-idea-ue-icon.png" width="70" height="70" />](https://www.jetbrains.com/idea) - IntelliJ (IDE)
* &nbsp; [<img src="https://camo.githubusercontent.com/bec2c92468d081617cb3145a8f3d8103e268bca400f6169c3a68dc66e05c971e/68747470733a2f2f76352e676574626f6f7473747261702e636f6d2f646f63732f352e302f6173736574732f6272616e642f626f6f7473747261702d6c6f676f2d736861646f772e706e67" width="50" height="41" />](https://getbootstrap.com/)  &ensp; - Bootstrap (CSS Framework)
* &nbsp; &nbsp; [<img src="https://cdn.icon-icons.com/icons2/2107/PNG/512/file_type_maven_icon_130397.png" width="45" height="45" />](https://maven.apache.org/) &nbsp;   - Maven

## Autors

* **Galatée** _alias_ [@galateeL](https://github.com/galateeL)
* **Kévin** _alias_ [@Solacebzh](https://github.com/Solacebzh)
* **Jérémie** _alias_ [@ScoteeG](https://github.com/ScoteeG)

