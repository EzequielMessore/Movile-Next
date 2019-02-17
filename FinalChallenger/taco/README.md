# App - TACO (Tabela de composição de alimentos)

Projeto final do *Movile Next* segunda edição.

O App tem como objetivo facilitar o acesso a informações nutricionais a partir de categorias pré selecionadas.

## Tecnologias utilizadas
O desenvolvimento do App foi baseado no conteudo do curso.

#### Arquitetura
A arquitetura do projeto foi baseada no `Clean Architecture`, foi tomado como base o projeto [Github](https://github.com/android10/Android-CleanArchitecture-Kotlin), com algumas alterações pessoais. O projeto foi divido da seguinte maneira:

###### Core
Este módulo centraliza as principais resposabilidades como:
* Lidar com injeção de dependência
* Centralizar nossas *extensions*
* Prover *Use Cases* padrões
* Classes padrões para as *views*

###### Data
Este módulo é responsavél por prover os dados da nossa aplicação. Aqui encontramos nosso *BD* e também acesso direto a *API*. E também os nosso mappers para fazer.

###### Domain
Assim como o próprio nome sugere está camada tem como finalidade descrever o que o aplicativo é o que ele pode fazer.

Encontraremos as logicas de decição de busca de dados (*DB* ou *API*), assim como nossos *UseCases*.

###### Presentation
A camada de apresentação conecta todas as peças diferentes em uma única unidade funcional que é o aplicativo. Encontraremos aqui nossas *Activities*, *ViewModels* entre outros.

#### Lib's Utilizadas

###### DataBinding
Utilizei o [DataBinding](https://developer.android.com/topic/libraries/data-binding/?hl=pt-br) para setar os valores das *Views*
* Gostei bastante de usar o `@BindingAdapter` utilizei ele para carregar nossa imagem, tratar nossos cenarios de exceção e agrupar logicas para visibilidade.

###### Banco de dados
Para o banco de dados foi utilizado o [Room](https://developer.android.com/topic/libraries/architecture/room).
* Encontrei algumas dificuldades quando estruturei minhas entidades, onde tive que optar por uma solução de `Conversores`.

###### Retrofit
[Retrofit](https://square.github.io/retrofit/) foi usado para fazer as chamadas para *API*

###### Reative Extensions
[Rx](http://reactivex.io/) usado para fazer as interações entre as camadas de *ViewModel*, *Repository*, *Service* também utilizado para fazer o filtro das listas.