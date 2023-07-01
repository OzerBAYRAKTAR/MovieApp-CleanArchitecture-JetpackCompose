
# MovieApp-CleanArchitectur-Jetpack Compose📱 

## 💻 API Usage

* Register for API Key at https://www.omdbapi.com/ 🔍

## 📷 Screenshots


# 🛠 Built With 

* Clean Architecture:  Clean architecture is a software design philosophy that separates the elements of a design into ring levels. An important goal of clean architecture is to provide developers with a way to organize code in such a way that it encapsulates the business logic but keeps it separate from the delivery mechanism. 

        1-) Domain: contains the definitions of the business logic of the app, the server data model, the abstract definition of repositories, and the definition of the use cases. It’s a simple, pure kotlin module (android independent)

        2-) Data: contains the implementation of the abstract definitions of the domain layer. Can be reused by any application without modifications. It contains repositories and data sources implementations, the database definition and its DAOs, the network APIs definitions, some mappers to convert network API models to database models, and vice versa.

        3-) Presentation: it’s android specific and contains fragments, view models, adapters, activities, and so on. It also contains a service locator to manage dependencies, but you can use Hilt if you prefer.

* Jetpack Compose : Jetpack Compose is Android’s recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.

* MVVM(Model-View-ViewModel) : Software design pattern that is structured to separate program logic and user interface control

* Retrofit : Retrofit is a type-safe REST client for Android, Java and Kotlin developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp.

* Dependency injection with Hilt : Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically. Hilt is built on top of the popular DI library Dagger to benefit from the compile-time correctness, runtime performance, scalability, and Android Studio support that Dagger provides.

* Coroutines : A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.

* Kotlin Flow : In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. 

* Coil : An image loading library for Android backed by Kotlin Coroutines. 

* ViewBinding : View binding is a feature that makes it easier to write code that interacts with views. Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module. 

* OKHttp : OkHttp is an efficient HTTP & HTTP/2 client for Android and Java applications.

         It comes with advanced features, such as connection pooling (if HTTP/2 isn’t available), transparent GZIP compression, and response caching, to avoid the network completely for repeated requests.

         It's also able to recover from common connection problems; on a connection failure, if a service has multiple IP addresses, it can retry the request to alternate addresses.




