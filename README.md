# RetrofitMoshiAndCoil
Retrofit in Android | Get Data from an API

![Instagram-Carousel-Retrofit10posts_01](https://user-images.githubusercontent.com/77014157/130150425-393dad5d-2b5a-4a19-8721-244b445335f7.gif)

![Instagram-Carousel-Retrofit10posts_10](https://user-images.githubusercontent.com/77014157/130150423-c38b6fdd-6a87-4b49-86f7-944a4b473f80.png)

# RetrofitMoshiAndCoil

IMAGENS: https://www.instagram.com/p/CSxZny_LZTc/?utm_source=ig_web_copy_link



This is an app to practice how to get data from an API on an Android device. I will use Retrofit in order to make the request
and parse the response.

Networking is a very important aspect of Android development. We often require to retrieve data or load images from a server to 
display on our application, this process is called networking.   

To interact with data from the internet we need to make a request to the server, lets understand what a request is and what happens
during the process.

There are two different parts to consider when making a request, the Client and the Server

A client can be any of your device's phone, tablet, laptop, or even a browser while the server can be any central computer or
program that controls or provides the information that you need.

The client and server use the hypertext transfer protocol (HTTP) methods to communicate with each other. There are specific
methods created to enable them to understand each other which includes:

- @GET - The get method is for reading data from the server
- @POST - The post method is to create or add data to a server
- @PUT - The put method is to update an already existing data
- @DELETE - The delete method is to remove an existing data

When the client makes any of these requests, the server processes it and reacts with a response. There are response codes that 
indicate the status of the request sent to the server.

- 100 - 1XX → This is an information response
- 200 - 2XX → This is a successful response
- 300 - 3XX → This is a redirection response
- 400 - 4XX → This is a client error
- 500 - 5XX → This is a server error

The most common response codes to encounter are: 
*200* which is an *OK* response code meaning that your request was successful.
*404* which is a *Not Found* error code meaning that the request sent by the client does not exist on the server.
*503* is a *Service Unavailable*  error code meaning that the server you are requesting information from is not available at the moment.
