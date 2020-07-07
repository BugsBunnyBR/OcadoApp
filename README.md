# WARNING
 :warning: This app is over engineered for modularization.
 
 :warning: I used a bunch of alpha libraries because I don't need to maintain this app, this app is not going to production and I wanted to learn something while coding it.

## OcadoApp

This app demonstrate an archtecture to split your application among feature, libraries and base modules.

The idea is that each feature should have it's own app module, with that the cross module 
navigation is not possible (unless your feature app also depends of other feature library), but the compilation time for a given feature app should be smaller than compiling the whole application.

### Modules:
- app: - Runs whole application
- features:products:list:app - Compiles and runs only the products list Activity and also runs instrumented tests
- features:products:detail:app - Compiles and runs only the product detail Activity and also runs instrumented tests

- features:products:list:library - Contains the code for the list Activiy
- features:products:detail:library - Contains the code for the detail Activity

- base:baseApp - Contains the basic infrastructure to run an application (BaseOcadoApp, LauncherActivity and assets)
- base:baseLibrary - Contains utils classes that should be used for most features
- base:baseTest - Contains utils for unit testing
- base:baseAndroidTest - Contains the basic infraestructure to run android tests (BaseTest, CustomTestRunner and ApplicationModuleTest)

- libraries:components - Contains common widgets that can be shared accross the application
- libraries:navigation - Contains the classes required to execute cross module navigation

### Other folders of interest
- buildSrc - Holds the  3rd party libraries definitions and versions
- build-system - Holds the configuration files for building the project with ktlint and detekt


### Main 3rd party libraries
- Hilt/Dagger
- Jetpack stuff (ConcatAdapter, ConstraintLayout, Activity, ViewModel)
- Material components
- Coil
- Retrofit/OkHttp
- Coroutines
- Dispatch
