

# Instant news
Cette application Android développée en Kotlin récupère les actualités de l'API news (https://newsapi.org/docs/endpoints/everything) et les affiche sous la forme d'une liste. Il est possible de cliquer sur une actualité afin d'avoir un aperçu de celle-ci et permet d'accéder à la source de l'actualité.

## Choix des librairies utilisées
- __Retrofit__ (https://square.github.io/retrofit/) : Client HTTP Java pour Android, permet de créer simplement des interfaces et peut être associé à un convertisseur pour transformer les réponses JSON en objets Java.
  L'ayant déjà utilisé plusieurs fois, mon choix s'est par défaut porté dessus, j'ai néanmoins essayé d'utilisé Volley mais cette librairie ne dispose malheureusement pas d'un convertisseur JSON<->Java comme Retrofit.

- __Moshi__ (https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) : Convertisseur permettant de transformer des réponses JSON en objets Java. Les convertisseurs disponibles pour Retrofit sont relativement similaires mais Moshi a l'avantage d'être une librairie assez légère et régulièrement tenue à jour.

- __Glide__ (https://github.com/bumptech/glide) : Librairie permettant de charger des images depuis une URL de façon asynchrone simplement. J'ai décide d'utiliser une librairie pour gérer le chargement d'images asynchrone, cela m'a permis de déléguer le chargement de différents formats d'images à cette librairie plutôt que de le gérer moi même et potentiellement faire des erreurs. Il existe également Picasso

## Améliorations possibles
- __LiveData + ViewModel :__ L'application n'ayant pas d'interactivité avec l'utilisateur (aucune donnée n'est modifiée après récupération), je me suis dit qu'il n'y avait pas besoin de système d'Observable et donc pas besoin de LiveData ou de ViewModel et j'utilise donc simplement une List pour afficher la liste des news, la liste de news doit toujours être à jour donc un rafraichissement à chaque affichage me paraissait également normal.
  J'ai néanmoins un doute sur les performances si on avait un affichage complexe de chaque élément de la liste de news, dans le cas d'un rafraichissement de la liste (l'utilisateur ouvre une news et revient sur la liste), il me semble que le comportement actuel rafraichit toujours la liste (il efface et recrée les layout de chaque news), avec des livedata et viewmodel il serait peut être possible de rafraichir seulement les news ayant été modifiées (et donc effectuer moins de modifications de layout et gagner en performances).
  J'aurais donc sûrement dû partir sur une utilisation des LiveData et ViewModel

- __Paramétrage des appels à l'API :__ Cette application récupère simplement toutes les actualités de l'API News (https://newsapi.org/docs/endpoints/everything) en utilisant seulement un endpoint de l'API avec des paramètres pré-établis, on pourrait imaginer l'ajout d'un sélectionneur de type d'actualités afin de paramétrer l'appel à l'API (paramètre "category" qui peut être égal à business, sport ou technologie par exemple).    
  J'ai d'ailleurs déjà ajouté un modèle permettant de récupérer les Headlines, qui est quasiment pareil

- __Paramétrage de différentes API :__ On pourrait également imaginer utiliser d'autres API que celle sélectionnée

- __Thème nuit :__ Il est possible de configurer un thème nuit afin que l'application s'adapte au thème choisi par l'utilisateur

- __Tests :__ L'application n'ayant pas de logique, il n'y a pas grand chose à tester, son contenu étant entièrement basé sur un appel à l'API News j'ai décidé de tester cette API même si son bon fonctionnement ne dépend pas du code de l'application.  
  Si d'autres fonctionnalités sont ajoutées et ajoutent de la logique il faudra évidemment ajouter des tests correspondants
