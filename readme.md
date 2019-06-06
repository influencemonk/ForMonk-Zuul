#Deploying to heroku

##Prerequisite
### Install Heroku CLI
link : ```https://devcenter.heroku.com/articles/heroku-cli#download-and-install```

first run ```heroku plugins:install java```

1. Open any command prompt
2. first run ```heroku plugins:install java```
3. run ```gradle build```
4. After build is complete run ```heroku deploy:jar ./build/libs/ForMonk-Zuul-0.0.1-SNAPSHOT.jar pacific-savannah-99876```
5. Check the swagger at ```https://pacific-savannah-99876.herokuapp.com/monk-o-auth/docApi/swagger-ui.html```
6. In case swagger is down , run ```heroku ps:scale web=1```