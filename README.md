# Marvel_Kotlin

Build:<br />
//Retrofit & GSON <br />
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'<br />
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
      
//Logging:<br />
    implementation 'com.squareup.okhttp3:logging-interceptor:4.10.0'

//Glide<br />
    implementation 'com.github.bumptech.glide:glide:4.13.0'<br />
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    
Aplicação:<br />
    Androidx - API 33

<h3>Interface do aplicativo</h3>

<h3>Como usar o aplicativo</h3>
Você pode usa-lo pelo Android Studio usando este repositório.<br/>

Para que consiga rodar o projeto é necessário informar a API_KEY e PRIVATE_KEY disponibilizada com o login na API Marvel: https://developer.marvel.com/<br>

O preenchimento das Keys são feitas dentro do arquivo "Constants.kt"<br/>
const val API_KEY = ""<br/>
const val PRIVATE_KEY = ""<br/>

<h3>Funcionamento do aplicativo</h3>
O APP funciona a partir de uma tela onde há o nome e imagem dos personagens da Marvel, onde clicando no personagem desejado é apresentada uma nova tela com mais informações sobre o mesmo
