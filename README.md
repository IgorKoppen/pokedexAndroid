# PokedexApp

Este projeto Android é um aplicativo simples de Pokédex que busca dados sobre Pokémons usando a PokeAPI. Ele utiliza Retrofit para fazer as solicitações HTTP e apresenta os dados em uma interface gráfica.


![Imagem do App](https://github.com/IgorKoppen/pokedexAndroid/blob/main/imagensDoProjeto/imagem%20do%20app.png)


## Funcionalidades

- Busca de Pokémon por ID.
- Exibição de nome, altura, peso e imagens do Pokémon.

## Estrutura do Projeto

- **model/**: Contém classes de modelo para representar os dados dos Pokémon.
- **PokemonAPI.kt**: Interface Retrofit para definir as chamadas à API.
- **PokemonRepository.kt**: Responsável por buscar os dados da API e transformá-los em objetos Pokémon.
- **RetrofitClient.kt**: Configuração do Retrofit para comunicação com a PokeAPI.

## Configuração do Ambiente

1. Clone o repositório.
2. Abra o projeto no Android Studio.
3. Tenha certeza de ter o Android SDK instalado.
4. Sincronize as dependências do Gradle.

## Uso

1. Execute o aplicativo no emulador ou em dispositivo físico.
2. Insira o ID do Pokémon desejado na caixa de texto e clique no botão de busca.
3. Os detalhes do Pokémon serão exibidos na tela.

## Tecnologias Utilizadas

- Kotlin
- Android Jetpack (ViewModel, LiveData)
- Retrofit
- Glide

## Notas

- Este projeto faz uso da PokeAPI para obter informações sobre os Pokémon.
- Certifique-se de ter uma conexão com a internet ao usar o aplicativo, pois ele depende de serviços online.
