# Instant news
Cette application Android développée en Kotlin récupère les meilleures actualités de l'API news (https://newsapi.org/docs/endpoints/top-headlines) et les affiche sous la forme d'une liste. Il est possible de cliquer sur une actualité afin d'avoir un aperçu de celle-ci et permet d'accéder à la source de l'actualité.

## Librairies utilisées
- __Retrofit__ (https://square.github.io/retrofit/) : Client HTTP Java pour Android, permet de créer simplement des interfaces et peut être associé à un convertisseur pour transformer les réponses JSON en objets Java

- __Moshi__ (https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) : Convertisseur permettant de transformer des réponses JSON en objets Java

- __Glide__ (https://github.com/bumptech/glide) : Librairie permettant de charger des images depuis une URL de façon asynchrone simplement

## Améliorations possibles
- __Paramétrage des appels à l'API :__ Cette application récupère simplement toutes les actualités de l'API News (https://newsapi.org/docs/endpoints/everything) en utilisant seulement un endpoint de l'API avec des paramètres pré-établis, on pourrait imaginer l'ajout d'un sélectionneur de type d'actualités afin de paramétrer l'appel à l'API (paramètre "category" qui peut être égal à business, sport ou technologie par exemple).
  J'ai d'ailleurs déjà ajouté un modèle permettant de récupérer les Headlines, qui est quasiment pareil
- __Paramétrage de différentes API :__ On pourrait également imaginer utiliser d'autres API que celle sélectionnée
- __Thème nuit :__ Il est possible de configurer un thème nuit afin que l'application s'adapte au thème choisi par l'utilisateur
- __Tests :__ L'application n'ayant pas de logique, il n'y a pas grand chose à tester, son contenu étant entièrement basé sur un appel à une API j'ai décidé de tester cette API même si le fonctionnement de l'API ne dépend pas du code de l'application. Si d'autres fonctionnalités sont ajoutées et ajoutent de la logique il faudra évidemment ajouter des tests correspondants


